package com.liferay.talelets.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.talelets.service.NoSuchTaleletException;
import com.liferay.talelets.service.model.Talelet;
import com.liferay.talelets.service.model.impl.TaleletImpl;
import com.liferay.talelets.service.service.TaleletLocalServiceUtil;
import com.liferay.talelets.util.ActionUtil;
import com.liferay.talelets.util.TaleletValidator;
import com.liferay.talelets.util.WebKeys;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class TaleletPortlet
 */
public class TaleletPortlet extends MVCPortlet {
	
	   public void render(
		        RenderRequest renderRequest, RenderResponse renderResponse)
		    throws PortletException, IOException {

		    try {
		        Talelet talelet = null;

		        long resourcePrimKey = ParamUtil.getLong(
		            renderRequest, "resourcePrimKey");

		        if (resourcePrimKey > 0) {
		            talelet = TaleletLocalServiceUtil.getTalelet(resourcePrimKey);

		        } else {

		            talelet = new TaleletImpl();
		        }

		        renderRequest.setAttribute(WebKeys.TALELET_ENTRY, talelet);

		    }
		    catch (Exception e) {
		        if (e instanceof NoSuchTaleletException) {

		            SessionErrors.add(renderRequest, e.getClass().getName());
		        }
		        else {
		            throw new PortletException(e);
		        }
		    }

		    super.render(renderRequest, renderResponse);
		}
	   
	   /**
	     * Called when a user is either adding or updating a Talelet. If the primary key
	     * is greater than 0, an update is performed, because there's an existing key.
	     * Otherwise, an add is performed.
	     *
	     * @param request
	     * @param response
	     * @throws SystemException
	     * @throws PortalException
	     */
	    @SuppressWarnings("unchecked")
	    public void updateTalelet(ActionRequest request, ActionResponse response) throws PortalException, SystemException {

	        Talelet talelet = ActionUtil.taleletFromRequest(request);

	        ArrayList<String> errors = new ArrayList();
	        ServiceContext serviceContext = ServiceContextFactory.getInstance(Talelet.class.getName(), request);

	        if (TaleletValidator.validateTalelet(talelet, errors)) {

	            if (talelet.getTaleId() > 0) {
	                // Updating

	                try {
	                    Talelet fromDB =
	                        TaleletLocalServiceUtil.getTalelet(talelet.getTaleId());

	                    if (fromDB != null &&
	                        (talelet.getTaleId() == fromDB.getTaleId())) {

	                        // update timestamp
	                    	talelet.setDateUpdated(new Date());
	                    	
	                    	// update timestamp on chain
	                    	if (talelet.getTaleStarterId() > 0) {
	                    		
	                    		Talelet taleStarter = TaleletLocalServiceUtil.getTalelet(talelet.getTaleStarterId());
	                    		taleStarter.setDateUpdated(new Date());
	                    		
	                    		Talelet tale = TaleletLocalServiceUtil.getTalelet(taleStarter.getTaleParentId());
	                    		tale.setDateUpdated(new Date());
	                    		
	                    		taleStarter = TaleletLocalServiceUtil.updateTalelet(taleStarter, false);
	                    		tale = TaleletLocalServiceUtil.updateTalelet(tale, false);
	                    	}
	                    	
	                    	fromDB =
	                            TaleletLocalServiceUtil.updateTalelet(talelet, false);
	                        SessionMessages.add(request, "talelet-updated");

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
	                	                	
	                    talelet = TaleletLocalServiceUtil.addTalelet(talelet, talelet.getUserId(), serviceContext);
	                    SessionMessages.add(request, "talelet-added");
	                    
	                 // update timestamp on chain
                    	if (talelet.getTaleStarterId() > 0) {
                    		
                    		Talelet taleStarter = TaleletLocalServiceUtil.getTalelet(talelet.getTaleStarterId());
                    		taleStarter.setDateUpdated(new Date());
                    		
                    		Talelet tale = TaleletLocalServiceUtil.getTalelet(taleStarter.getTaleParentId());
                    		tale.setDateUpdated(new Date());
                    		
                    		taleStarter = TaleletLocalServiceUtil.updateTalelet(taleStarter, false);
                    		tale = TaleletLocalServiceUtil.updateTalelet(tale, false);
                    		response.setRenderParameter("resourcePrimKey", Long.toString(taleStarter.getTaleId()));
                    	}

	                }
	                catch (SystemException e) {

	                    errors.add("failed-to-add");

	                }
	                catch (PortalException e) {

	                    errors.add("failed-to-add");
	                }

	            }
	            String taleType = ParamUtil.getString(request, "taleType");
	            if (taleType.equalsIgnoreCase("taleStarter")) {
	            	response.setRenderParameter("resourcePrimKey", Long.toString(talelet.getTaleParentId()));
	            	response.setRenderParameter("jspPage", "/html/view_tale_starters.jsp");
	            } else if (taleType.equalsIgnoreCase("talelet")) {
	            	
	            	response.setRenderParameter("jspPage", "/html/view_talelets.jsp");
	            	
	            } else {
	            response.setRenderParameter("jspPage", "/html/view.jsp");
	            }

	        } else {

	            for (String error : errors) {
	                SessionErrors.add(request, error);
	            }

	            request.setAttribute(WebKeys.TALELET_ENTRY, talelet);
	            response.setRenderParameter("jspPage", "/html/edit_talelet.jsp");
	        }


	    }
 

}
