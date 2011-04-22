/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.talelets.util;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.talelets.service.model.Talelet;
import com.liferay.talelets.service.model.impl.TaleletImpl;
import com.liferay.talelets.service.service.TaleletLocalServiceUtil;

/**
 * Helps to adhere to MVC by getting data calls out of the JSP.
 *  
 * @author Rich Sezov
 *
 */
public class ActionUtil {
	
	@SuppressWarnings("unchecked")
	public static List <Talelet> getActiveTales(long groupId, int start, int end) {
		
		List<Talelet> talelets;
		
		try {
			talelets = TaleletLocalServiceUtil.getTalesByDate(groupId, WorkflowConstants.STATUS_APPROVED, start, end);
		} catch (SystemException e) {
			
			talelets = Collections.EMPTY_LIST;
		}
		
		return talelets;
		
	}
	
	@SuppressWarnings("unchecked")
	public static List<Talelet> getTaleStartersByDate(long taleId, int start, int end) {
		
		List<Talelet> talelets;
		
		try {
			
			talelets = TaleletLocalServiceUtil.getTaleStartersByDate(taleId, WorkflowConstants.STATUS_APPROVED, start, end);
		
		} catch (SystemException e) {
			
			talelets = Collections.EMPTY_LIST;
		}
		
		return talelets;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Talelet> getTalelets (long taleStarterId) {
		
		List<Talelet> talelets;
		
		try {
			
			talelets = TaleletLocalServiceUtil.getTalelets(taleStarterId);
		} catch (SystemException e) {
			
			talelets = Collections.EMPTY_LIST;
		}
		
		return talelets;
	}
	
	public static Talelet getTalelet (long taleId) {
		
		try {
			return TaleletLocalServiceUtil.getTalelet(taleId);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static int getTaleletsCount(long groupId) {
		
		try {
			
			return TaleletLocalServiceUtil.getTaleletsCount(groupId, WorkflowConstants.STATUS_APPROVED);
		
		} catch (SystemException e) {
			
			return 0;
		
		}
	}
	
    /**
     * Given an ActionRequest, grabs the field values from the form and
     * populates a Talelet object with them. This object can then be validated
     * and then stored.
     *
     * @param request
     * @return
     */
    public static Talelet taleletFromRequest(ActionRequest request) {

        TaleletImpl talelet = new TaleletImpl();

        ThemeDisplay themeDisplay =
            (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

        talelet.setCompanyId(themeDisplay.getCompanyId());
        talelet.setGroupId(themeDisplay.getScopeGroupId());
        talelet.setUserId(themeDisplay.getUserId());
        try {
	        talelet.setTaleId(Long.parseLong(ParamUtil.getString(request, "taleletPrimKey")));
        } catch (NumberFormatException nfe) {
        	// if this is a new top-level Tale, can't set these
        	// so we do nothing
        }
        try {
	        talelet.setTaleParentId(Long.parseLong(ParamUtil.getString(request, "taleParentId")));
        } catch (NumberFormatException nfe) {
        	// if this is a new top-level Tale, can't set these
        	// so we do nothing
        }
        try {
	        talelet.setTaleStarterId(Long.parseLong(ParamUtil.getString(request, "taleStarterId")));
        } catch (NumberFormatException nfe) {
        	// if this is a new top-level Tale, can't set these
        	// so we do nothing
        }
        try {
	        talelet.setTaleOrder(Integer.parseInt(ParamUtil.getString(request, "taleOrder")));
        } catch (NumberFormatException nfe) {
        	// if this is a new top-level Tale, can't set these
        	// so we do nothing
        }
        talelet.setTaleTitle(ParamUtil.getString(request, "taleTitle"));
        talelet.setAuthorName(themeDisplay.getUser().getFullName());
        // Don't set dates here; create date can be set in add; modified in update
        
        talelet.setContent(ParamUtil.getString(request, "content"));

        return talelet;
    }
}
