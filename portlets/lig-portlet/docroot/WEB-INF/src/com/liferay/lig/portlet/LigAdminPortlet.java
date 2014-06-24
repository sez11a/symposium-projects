/**
 *
 */

package com.liferay.lig.portlet;

import java.util.ArrayList;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.lig.model.Insult;
import com.liferay.lig.model.impl.InsultImpl;
import com.liferay.lig.service.InsultLocalServiceUtil;
import com.liferay.lig.util.ActionUtil;
import com.liferay.lig.util.StatementValidator;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * @author Rich Sezov
 */
public class LigAdminPortlet extends MVCPortlet {

    /**
     * Action for adding a statement to the database. Creates
     * an empty bean and puts it in the request.
     *
     * @param request
     * @param response
     */
    public void addInsult (ActionRequest request, ActionResponse response) {

        InsultImpl insult = new InsultImpl();

        request.setAttribute("insult", insult);

        response.setRenderParameter("jspPage", "/admin/edit_sentence.jsp");
    }

    /**
     * Gets a statement from the database based on its primary key
     * and puts it in the request. This is designed to be called
     * from the Search Container.
     *
     * @param request
     * @param response
     */
    public void editInsult (ActionRequest request, ActionResponse response) {

        String primKey= ParamUtil.getString(request, "resourcePrimKey");

        if (primKey!=null) {

            try {

                Insult insult = InsultLocalServiceUtil.getInsult(Long.parseLong(primKey));
                request.setAttribute("insult", insult);

                response.setRenderParameter("jspPage", "/admin/edit_sentence.jsp");
            }
            catch (NumberFormatException e) {
                SessionErrors.add(request, "failed-to-retrieve");
            }
            catch (PortalException e) {
                SessionErrors.add(request, "failed-to-retrieve");
            }
            catch (SystemException e) {
                SessionErrors.add(request, "failed-to-retrieve");
            }
        }
    }

    /**
     * Called when a user is either adding or updating a statement. If the primary key
     * is greater than 0, an update is performed, because there's an existing key.
     * Otherwise, an add is performed.
     *
     * @param request
     * @param response
     */
    @SuppressWarnings("unchecked")
    public void updateInsult(ActionRequest request, ActionResponse response) {

        Insult insult = ActionUtil.insultFromRequest(request);

        ArrayList<String> errors = new ArrayList();

        if (StatementValidator.validateStatement(insult, errors)) {

            if (insult.getInsultId() > 0) {
                // Updating

                try {
                    Insult fromDB =
                        InsultLocalServiceUtil.getInsult(insult.getInsultId());

                    if (fromDB != null &&
                        (insult.getInsultId() == fromDB.getInsultId())) {

                        fromDB =
                            InsultLocalServiceUtil.updateInsult(insult, false);
                        SessionMessages.add(request, "statement-added");

                    }
                }
                catch (PortalException e) {

                    errors.add("failed-to-update");

                }
                catch (SystemException e) {

                    errors.add("failed-to-update");

                }

            }
            else {
                // Adding

                try {
                    InsultLocalServiceUtil.addInsult(insult, insult.getUserId());

                }
                catch (SystemException e) {

                    errors.add("failed-to-add");

                }
                catch (PortalException e) {

                    errors.add("failed-to-add");
                }

            }

            response.setRenderParameter("jspPage", "/admin/view.jsp");

        } else {

            for (String error : errors) {
                SessionErrors.add(request, error);
            }

            request.setAttribute("insult", insult);
            response.setRenderParameter("jspPage", "/admin/edit_sentence.jsp");
        }


    }

    /**
     * Deletes the insult from the database.
     *
     * @param request
     * @param response
     */
    public void deleteInsult (ActionRequest request, ActionResponse response) throws Exception {

        long insultKey = ParamUtil.getLong(request, "resourcePrimKey");

        if (Validator.isNotNull(insultKey)) {
            InsultLocalServiceUtil.deleteInsult(insultKey);
            SessionMessages.add(request, "insult-deleted");

        } else {
            SessionErrors.add(request, "error-deleting");

        }
    }

}
