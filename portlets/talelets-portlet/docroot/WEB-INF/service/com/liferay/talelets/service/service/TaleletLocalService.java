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

package com.liferay.talelets.service.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

/**
 * The interface for the talelet local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Rich Sezov
 * @see TaleletLocalServiceUtil
 * @see com.liferay.talelets.service.service.base.TaleletLocalServiceBaseImpl
 * @see com.liferay.talelets.service.service.impl.TaleletLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface TaleletLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TaleletLocalServiceUtil} to access the talelet local service. Add custom service methods to {@link com.liferay.talelets.service.service.impl.TaleletLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the talelet to the database. Also notifies the appropriate model listeners.
	*
	* @param talelet the talelet to add
	* @return the talelet that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.talelets.service.model.Talelet addTalelet(
		com.liferay.talelets.service.model.Talelet talelet)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new talelet with the primary key. Does not add the talelet to the database.
	*
	* @param taleId the primary key for the new talelet
	* @return the new talelet
	*/
	public com.liferay.talelets.service.model.Talelet createTalelet(long taleId);

	/**
	* Deletes the talelet with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param taleId the primary key of the talelet to delete
	* @throws PortalException if a talelet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteTalelet(long taleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the talelet from the database. Also notifies the appropriate model listeners.
	*
	* @param talelet the talelet to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteTalelet(
		com.liferay.talelets.service.model.Talelet talelet)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the talelet with the primary key.
	*
	* @param taleId the primary key of the talelet to get
	* @return the talelet
	* @throws PortalException if a talelet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.talelets.service.model.Talelet getTalelet(long taleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the talelet with the UUID and group id.
	*
	* @param uuid the UUID of talelet to get
	* @param groupId the group id of the talelet to get
	* @return the talelet
	* @throws PortalException if a talelet with the UUID and group id could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.talelets.service.model.Talelet getTaleletByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets a range of all the talelets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of talelets to return
	* @param end the upper bound of the range of talelets to return (not inclusive)
	* @return the range of talelets
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.talelets.service.model.Talelet> getTalelets(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the number of talelets.
	*
	* @return the number of talelets
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTaleletsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the talelet in the database. Also notifies the appropriate model listeners.
	*
	* @param talelet the talelet to update
	* @return the talelet that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.talelets.service.model.Talelet updateTalelet(
		com.liferay.talelets.service.model.Talelet talelet)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the talelet in the database. Also notifies the appropriate model listeners.
	*
	* @param talelet the talelet to update
	* @param merge whether to merge the talelet with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the talelet that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.talelets.service.model.Talelet updateTalelet(
		com.liferay.talelets.service.model.Talelet talelet, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTaleletsCount(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.talelets.service.model.Talelet> getTalesByDate(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets Tale Starters ordered by date. In order to do this, a taleOrder of 1
	*  is hard coded into the query.
	*
	* @param taleId
	* @param status
	* @return
	* @throws SystemException
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.talelets.service.model.Talelet> getTaleStartersByDate(
		long taleId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the talelet chain, using the taleStarterId.
	*
	* @param taleStarterId
	* @return
	* @throws SystemException
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.talelets.service.model.Talelet> getTalelets(
		long taleStarterId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds a new Talelet to the database.
	*
	* @param newTalelet
	* @param userId
	* @return
	* @throws SystemException
	* @throws PortalException
	*/
	public com.liferay.talelets.service.model.Talelet addTalelet(
		com.liferay.talelets.service.model.Talelet newTalelet, long userId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.talelets.service.model.Talelet updateStatus(
		long userId, long resourcePrimKey, int status,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}