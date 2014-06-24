package com.liferay.lig.util;

import java.util.Collections;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;

import com.liferay.lig.model.Insult;
import com.liferay.lig.model.impl.InsultImpl;
import com.liferay.lig.service.InsultLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;


public class ActionUtil {


    /**
     * Gets insults out of the service layer.
     * @param request
     * @return List<Insults>
     */
    public static List<Insult>getInsults(RenderRequest request) {

        List<Insult> insults;

        ThemeDisplay themeDisplay =
            (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

        long groupId = themeDisplay.getScopeGroupId();

        try {
            insults = InsultLocalServiceUtil.getInsults(groupId);
        }
        catch (SystemException e) {

            insults = Collections.EMPTY_LIST;
        }

        return insults;

    }

    /**
     * Given an ActionRequest, grabs the field values from the form
     * and populates an Insult object with them. This object can then
     * be validated and then stored.
     *
     * @param request
     * @return
     */
    public static Insult insultFromRequest (ActionRequest request) {

        InsultImpl insult = new InsultImpl();

        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

        insult.setCompanyId(themeDisplay.getCompanyId());
        insult.setGroupId(themeDisplay.getScopeGroupId());
        insult.setUserId(themeDisplay.getUserId());

        insult.setAdjectiveOne(ParamUtil.getString(request, "adjectiveOne"));
        insult.setAdjectiveTwo(ParamUtil.getString(request, "adjectiveTwo"));
        insult.setDirectObject(ParamUtil.getString(request, "directObject"));
        insult.setObjPreposition(ParamUtil.getString(request, "objPreposition"));
        insult.setInsultIdString(ParamUtil.getString(request, "resourcePrimKey"));

        if (insult.getInsultIdString()!="") {

            insult.setInsultId(Long.parseLong(ParamUtil.getString(request, "resourcePrimKey")));

        }

        return insult;
    }
}
