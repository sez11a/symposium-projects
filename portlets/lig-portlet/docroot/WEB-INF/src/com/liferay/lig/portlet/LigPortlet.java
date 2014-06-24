/**
 *
 */
package com.liferay.lig.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.lig.model.Insult;
import com.liferay.lig.model.impl.InsultImpl;
import com.liferay.lig.service.InsultLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;


/**
 * @author Rich Sezov
 *
 */
public class LigPortlet extends MVCPortlet {

    @SuppressWarnings("unchecked")
    public void generateInsults (ActionRequest request, ActionResponse response) throws SystemException {

        ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
        long groupId = themeDisplay.getScopeGroupId();

        String insultNum = ParamUtil.getString(request, "numberGenerate");

        if (insultNum!=null) {

            try {
                int numInsults = Integer.parseInt(insultNum);

                List<Insult> insults = InsultLocalServiceUtil.getInsults(groupId);

                ArrayList<String> generatedInsults = new ArrayList();

                for (int i=0;i<numInsults;i++) {

                    Insult rndInsult = getRandomInsult(insults);
                    String insultString = "You " + rndInsult.getAdjectiveOne() + " " + rndInsult.getDirectObject() + " of " + rndInsult.getAdjectiveTwo() + " " + rndInsult.getObjPreposition() + ". ";
                    generatedInsults.add(insultString);

                }

                request.setAttribute("insults", generatedInsults);

                response.setRenderParameter("jspPage", "/insults/show_statements.jsp");

            } catch (Exception e) {

                SessionErrors.add(request, "please-enter-number");
            }

        } else {

            SessionErrors.add(request, "please-enter-number");

        }

    }

   /* @Override
    public void doView(
        RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {

        include("/insults/view.jsp", renderRequest, renderResponse);
    }*/

    private Insult getRandomInsult(List<Insult> insults) {

        InsultImpl insult = new InsultImpl();

        Random random = new Random();

        int totalInsults = insults.size();

        insult.setAdjectiveOne(insults.get(random.nextInt(totalInsults)).getAdjectiveOne());

        insult.setDirectObject(insults.get(random.nextInt(totalInsults)).getDirectObject());

        insult.setAdjectiveTwo(insults.get(random.nextInt(totalInsults)).getAdjectiveTwo());

        insult.setObjPreposition(insults.get(random.nextInt(totalInsults)).getObjPreposition());

        return insult;
    }

}
