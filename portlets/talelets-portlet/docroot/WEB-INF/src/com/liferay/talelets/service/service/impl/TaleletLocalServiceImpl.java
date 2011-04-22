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

package com.liferay.talelets.service.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.talelets.service.model.Talelet;
import com.liferay.talelets.service.service.base.TaleletLocalServiceBaseImpl;
import com.liferay.talelets.util.TaleletModifiedDateComparator;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the talelet local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.liferay.talelets.service.service.TaleletLocalService} interface.
 * </p>
 * 
 * <p>
 * Never reference this interface directly. Always use
 * {@link com.liferay.talelets.service.service.TaleletLocalServiceUtil} to
 * access the talelet local service.
 * </p>
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * Talelets are collaborative stories created by multiple users, defined 
 * by three or more levels. The top level is a Tale, and it kicks off the story. 
 * The second level is the Tale Starter, which continues the story and "locks" 
 * the chain of talelets. The third and subsequent levels are Talelets, and 
 * continue the story to its conclusion, whatever that becomes. 
 * 
 * Since all three of these levels use the same entity to represent them, 
 * there are rules for defining which is which. 
 * 
 * Tale: A talelet with 0 in the parentId. 
 * Tale Starter: A talelet with a populated parentId and a taleOrder of 1. 
 * Talelet: A talelet with a parent , a taleOrder of > 1, and a taleletId 
 * which matches the primary key of its Tale Starter.  
 * 
 * @author Rich Sezov
 * @see com.liferay.talelets.service.service.base.TaleletLocalServiceBaseImpl
 * @see com.liferay.talelets.service.service.TaleletLocalServiceUtil
 */

public class TaleletLocalServiceImpl extends TaleletLocalServiceBaseImpl {

	public int getTaleletsCount(long groupId, int status) throws SystemException {
		
		return taleletPersistence.countByG_S(groupId, status);
		
	}
	
	/**
	 * Gets Tales by descending date. In order to do this, a taleOrder of 0 
	 * is hard coded into the query. 
	 * 
	 * @param groupId
	 * @param status
	 * @param start
	 * @param end
	 * @return
	 * @throws SystemException
	 */
	public List<Talelet> getTalesByDate (long groupId, int status, int start, int end) throws SystemException {
		
		List<Talelet> talelets = taleletPersistence.findByG_O(groupId, 0, status, start, end, new TaleletModifiedDateComparator());
		
		return talelets;
		
	}
	
	/**
	*  Gets Tale Starters ordered by date. In order to do this, a taleOrder of 1 
	*  is hard coded into the query. 
	* @param taleId
	* @param status
	* @return
	* @throws SystemException
	*/
	public List<Talelet> getTaleStartersByDate(long taleId, int status, int start, int end) throws SystemException {
		
		List<Talelet> talelets = taleletPersistence.findByTale(taleId, 1, status, start, end, new TaleletModifiedDateComparator());
		
		return talelets;
	}
	
	/**
	 * Gets the talelet chain, using the taleStarterId. 
	 * 
	 * @param taleStarterId
	 * @return
	 * @throws SystemException
	 */
	public List<Talelet> getTalelets(long taleStarterId) throws SystemException {
		
		List<Talelet> talelets = taleletPersistence.findByTaleStarter(taleStarterId);
		
		return talelets;
		
	}
	
	/**
     * Adds a new Talelet to the database.
     *
     * @param newTalelet
     * @param userId
     * @return
     * @throws SystemException
     * @throws PortalException
     */
    public Talelet addTalelet (Talelet newTalelet, long userId, ServiceContext serviceContext) throws SystemException, PortalException {

        Talelet talelet = taleletPersistence.create(counterLocalService.increment(Talelet.class.getName()));

        talelet.setCompanyId(newTalelet.getCompanyId());
        talelet.setGroupId(newTalelet.getGroupId());
        talelet.setUserId(serviceContext.getUserId());
        talelet.setAuthorName(newTalelet.getAuthorName());
        talelet.setContent(newTalelet.getContent());
        talelet.setTaleTitle(newTalelet.getTaleTitle());
        
        // Create and Update dates
    	talelet.setDateUpdated(new Date());
    	talelet.setTaleDate(new Date());
    	
        // Pull these from the object; should already be set
    	talelet.setTaleOrder(newTalelet.getTaleOrder());
        talelet.setTaleParentId(newTalelet.getTaleParentId());
        talelet.setTaleStarterId(newTalelet.getTaleStarterId());
        
        talelet.setStatus(WorkflowConstants.STATUS_DRAFT);

        taleletPersistence.update(talelet, false);

        resourceLocalService.addResources(
            talelet.getCompanyId(), talelet.getGroupId(), userId,
            Talelet.class.getName(), talelet.getPrimaryKey(), false, true, true);

        long[] assetCategoryIds = serviceContext.getAssetCategoryIds();
        String[] assetTagNames = serviceContext.getAssetTagNames();
        
        assetEntryLocalService.updateEntry(
            userId, talelet.getGroupId(), Talelet.class.getName(),
            talelet.getTaleId(), assetCategoryIds, assetTagNames);

     // Workflow

        WorkflowHandlerRegistryUtil.startWorkflowInstance(
            talelet.getCompanyId(), talelet.getGroupId(), userId, Talelet.class.getName(),
            talelet.getTaleId(), talelet, serviceContext);

        return talelet;
    }
    
    public Talelet updateStatus (long userId, long resourcePrimKey, int status, ServiceContext serviceContext) throws PortalException, SystemException {
    	User user = userLocalService.getUser(userId);
    	Talelet talelet = getTalelet(resourcePrimKey);
    	
    	talelet.setStatus(status);
    	talelet.setStatusByUserId(userId);
    	talelet.setStatusByUserName(user.getFullName());
    	talelet.setStatusDate(serviceContext.getModifiedDate());
    	
    	taleletPersistence.update(talelet, false);
    	
    	if (status == WorkflowConstants.STATUS_APPROVED) {
    		
    		assetEntryLocalService.updateVisible(Talelet.class.getName(), resourcePrimKey, true);
    		
    	} else {
    		
    		assetEntryLocalService.updateVisible(Talelet.class.getName(), resourcePrimKey, false);
    		
    	}
    	
    	// Indexer
    	
    	//Indexer indexer = IndexerRegistryUtil.getIndexer(Talelet.class);
    	//indexer.reindex(talelet);
    	return talelet;
    }

}
	
	
