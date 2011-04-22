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

package com.liferay.talelets.service.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.liferay.talelets.service.model.Talelet;

/**
 * The persistence interface for the talelet service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Rich Sezov
 * @see TaleletPersistenceImpl
 * @see TaleletUtil
 * @generated
 */
public interface TaleletPersistence extends BasePersistence<Talelet> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TaleletUtil} to access the talelet persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the talelet in the entity cache if it is enabled.
	*
	* @param talelet the talelet to cache
	*/
	public void cacheResult(com.liferay.talelets.service.model.Talelet talelet);

	/**
	* Caches the talelets in the entity cache if it is enabled.
	*
	* @param talelets the talelets to cache
	*/
	public void cacheResult(
		java.util.List<com.liferay.talelets.service.model.Talelet> talelets);

	/**
	* Creates a new talelet with the primary key. Does not add the talelet to the database.
	*
	* @param taleId the primary key for the new talelet
	* @return the new talelet
	*/
	public com.liferay.talelets.service.model.Talelet create(long taleId);

	/**
	* Removes the talelet with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param taleId the primary key of the talelet to remove
	* @return the talelet that was removed
	* @throws com.liferay.talelets.service.NoSuchTaleletException if a talelet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.talelets.service.model.Talelet remove(long taleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException;

	public com.liferay.talelets.service.model.Talelet updateImpl(
		com.liferay.talelets.service.model.Talelet talelet, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the talelet with the primary key or throws a {@link com.liferay.talelets.service.NoSuchTaleletException} if it could not be found.
	*
	* @param taleId the primary key of the talelet to find
	* @return the talelet
	* @throws com.liferay.talelets.service.NoSuchTaleletException if a talelet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.talelets.service.model.Talelet findByPrimaryKey(
		long taleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException;

	/**
	* Finds the talelet with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param taleId the primary key of the talelet to find
	* @return the talelet, or <code>null</code> if a talelet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.talelets.service.model.Talelet fetchByPrimaryKey(
		long taleId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the talelets where uuid = &#63;.
	*
	* @param uuid the uuid to search with
	* @return the matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.talelets.service.model.Talelet> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the talelets where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param start the lower bound of the range of talelets to return
	* @param end the upper bound of the range of talelets to return (not inclusive)
	* @return the range of matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.talelets.service.model.Talelet> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the talelets where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param start the lower bound of the range of talelets to return
	* @param end the upper bound of the range of talelets to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.talelets.service.model.Talelet> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first talelet in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching talelet
	* @throws com.liferay.talelets.service.NoSuchTaleletException if a matching talelet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.talelets.service.model.Talelet findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException;

	/**
	* Finds the last talelet in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching talelet
	* @throws com.liferay.talelets.service.NoSuchTaleletException if a matching talelet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.talelets.service.model.Talelet findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException;

	/**
	* Finds the talelets before and after the current talelet in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param taleId the primary key of the current talelet
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next talelet
	* @throws com.liferay.talelets.service.NoSuchTaleletException if a talelet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.talelets.service.model.Talelet[] findByUuid_PrevAndNext(
		long taleId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException;

	/**
	* Finds the talelet where uuid = &#63; and groupId = &#63; or throws a {@link com.liferay.talelets.service.NoSuchTaleletException} if it could not be found.
	*
	* @param uuid the uuid to search with
	* @param groupId the group id to search with
	* @return the matching talelet
	* @throws com.liferay.talelets.service.NoSuchTaleletException if a matching talelet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.talelets.service.model.Talelet findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException;

	/**
	* Finds the talelet where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid to search with
	* @param groupId the group id to search with
	* @return the matching talelet, or <code>null</code> if a matching talelet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.talelets.service.model.Talelet fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the talelet where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid to search with
	* @param groupId the group id to search with
	* @return the matching talelet, or <code>null</code> if a matching talelet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.talelets.service.model.Talelet fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the talelets where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.talelets.service.model.Talelet> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the talelets where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of talelets to return
	* @param end the upper bound of the range of talelets to return (not inclusive)
	* @return the range of matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.talelets.service.model.Talelet> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the talelets where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of talelets to return
	* @param end the upper bound of the range of talelets to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.talelets.service.model.Talelet> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first talelet in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching talelet
	* @throws com.liferay.talelets.service.NoSuchTaleletException if a matching talelet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.talelets.service.model.Talelet findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException;

	/**
	* Finds the last talelet in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching talelet
	* @throws com.liferay.talelets.service.NoSuchTaleletException if a matching talelet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.talelets.service.model.Talelet findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException;

	/**
	* Finds the talelets before and after the current talelet in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param taleId the primary key of the current talelet
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next talelet
	* @throws com.liferay.talelets.service.NoSuchTaleletException if a talelet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.talelets.service.model.Talelet[] findByGroupId_PrevAndNext(
		long taleId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException;

	/**
	* Filters by the user's permissions and finds all the talelets where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the matching talelets that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.talelets.service.model.Talelet> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds a range of all the talelets where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of talelets to return
	* @param end the upper bound of the range of talelets to return (not inclusive)
	* @return the range of matching talelets that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.talelets.service.model.Talelet> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds an ordered range of all the talelets where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of talelets to return
	* @param end the upper bound of the range of talelets to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching talelets that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.talelets.service.model.Talelet> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the talelets where groupId = &#63; and taleOrder = &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param taleOrder the tale order to search with
	* @param status the status to search with
	* @return the matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.talelets.service.model.Talelet> findByG_O(
		long groupId, int taleOrder, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the talelets where groupId = &#63; and taleOrder = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param taleOrder the tale order to search with
	* @param status the status to search with
	* @param start the lower bound of the range of talelets to return
	* @param end the upper bound of the range of talelets to return (not inclusive)
	* @return the range of matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.talelets.service.model.Talelet> findByG_O(
		long groupId, int taleOrder, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the talelets where groupId = &#63; and taleOrder = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param taleOrder the tale order to search with
	* @param status the status to search with
	* @param start the lower bound of the range of talelets to return
	* @param end the upper bound of the range of talelets to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.talelets.service.model.Talelet> findByG_O(
		long groupId, int taleOrder, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first talelet in the ordered set where groupId = &#63; and taleOrder = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param taleOrder the tale order to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching talelet
	* @throws com.liferay.talelets.service.NoSuchTaleletException if a matching talelet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.talelets.service.model.Talelet findByG_O_First(
		long groupId, int taleOrder, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException;

	/**
	* Finds the last talelet in the ordered set where groupId = &#63; and taleOrder = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param taleOrder the tale order to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching talelet
	* @throws com.liferay.talelets.service.NoSuchTaleletException if a matching talelet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.talelets.service.model.Talelet findByG_O_Last(
		long groupId, int taleOrder, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException;

	/**
	* Finds the talelets before and after the current talelet in the ordered set where groupId = &#63; and taleOrder = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param taleId the primary key of the current talelet
	* @param groupId the group id to search with
	* @param taleOrder the tale order to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next talelet
	* @throws com.liferay.talelets.service.NoSuchTaleletException if a talelet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.talelets.service.model.Talelet[] findByG_O_PrevAndNext(
		long taleId, long groupId, int taleOrder, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException;

	/**
	* Filters by the user's permissions and finds all the talelets where groupId = &#63; and taleOrder = &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param taleOrder the tale order to search with
	* @param status the status to search with
	* @return the matching talelets that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.talelets.service.model.Talelet> filterFindByG_O(
		long groupId, int taleOrder, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds a range of all the talelets where groupId = &#63; and taleOrder = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param taleOrder the tale order to search with
	* @param status the status to search with
	* @param start the lower bound of the range of talelets to return
	* @param end the upper bound of the range of talelets to return (not inclusive)
	* @return the range of matching talelets that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.talelets.service.model.Talelet> filterFindByG_O(
		long groupId, int taleOrder, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds an ordered range of all the talelets where groupId = &#63; and taleOrder = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param taleOrder the tale order to search with
	* @param status the status to search with
	* @param start the lower bound of the range of talelets to return
	* @param end the upper bound of the range of talelets to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching talelets that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.talelets.service.model.Talelet> filterFindByG_O(
		long groupId, int taleOrder, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the talelets where taleParentId = &#63; and taleOrder = &#63; and status = &#63;.
	*
	* @param taleParentId the tale parent id to search with
	* @param taleOrder the tale order to search with
	* @param status the status to search with
	* @return the matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.talelets.service.model.Talelet> findByTale(
		long taleParentId, int taleOrder, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the talelets where taleParentId = &#63; and taleOrder = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param taleParentId the tale parent id to search with
	* @param taleOrder the tale order to search with
	* @param status the status to search with
	* @param start the lower bound of the range of talelets to return
	* @param end the upper bound of the range of talelets to return (not inclusive)
	* @return the range of matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.talelets.service.model.Talelet> findByTale(
		long taleParentId, int taleOrder, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the talelets where taleParentId = &#63; and taleOrder = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param taleParentId the tale parent id to search with
	* @param taleOrder the tale order to search with
	* @param status the status to search with
	* @param start the lower bound of the range of talelets to return
	* @param end the upper bound of the range of talelets to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.talelets.service.model.Talelet> findByTale(
		long taleParentId, int taleOrder, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first talelet in the ordered set where taleParentId = &#63; and taleOrder = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param taleParentId the tale parent id to search with
	* @param taleOrder the tale order to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching talelet
	* @throws com.liferay.talelets.service.NoSuchTaleletException if a matching talelet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.talelets.service.model.Talelet findByTale_First(
		long taleParentId, int taleOrder, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException;

	/**
	* Finds the last talelet in the ordered set where taleParentId = &#63; and taleOrder = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param taleParentId the tale parent id to search with
	* @param taleOrder the tale order to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching talelet
	* @throws com.liferay.talelets.service.NoSuchTaleletException if a matching talelet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.talelets.service.model.Talelet findByTale_Last(
		long taleParentId, int taleOrder, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException;

	/**
	* Finds the talelets before and after the current talelet in the ordered set where taleParentId = &#63; and taleOrder = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param taleId the primary key of the current talelet
	* @param taleParentId the tale parent id to search with
	* @param taleOrder the tale order to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next talelet
	* @throws com.liferay.talelets.service.NoSuchTaleletException if a talelet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.talelets.service.model.Talelet[] findByTale_PrevAndNext(
		long taleId, long taleParentId, int taleOrder, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException;

	/**
	* Finds all the talelets where taleStarterId = &#63;.
	*
	* @param taleStarterId the tale starter id to search with
	* @return the matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.talelets.service.model.Talelet> findByTaleStarter(
		long taleStarterId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the talelets where taleStarterId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param taleStarterId the tale starter id to search with
	* @param start the lower bound of the range of talelets to return
	* @param end the upper bound of the range of talelets to return (not inclusive)
	* @return the range of matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.talelets.service.model.Talelet> findByTaleStarter(
		long taleStarterId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the talelets where taleStarterId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param taleStarterId the tale starter id to search with
	* @param start the lower bound of the range of talelets to return
	* @param end the upper bound of the range of talelets to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.talelets.service.model.Talelet> findByTaleStarter(
		long taleStarterId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first talelet in the ordered set where taleStarterId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param taleStarterId the tale starter id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching talelet
	* @throws com.liferay.talelets.service.NoSuchTaleletException if a matching talelet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.talelets.service.model.Talelet findByTaleStarter_First(
		long taleStarterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException;

	/**
	* Finds the last talelet in the ordered set where taleStarterId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param taleStarterId the tale starter id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching talelet
	* @throws com.liferay.talelets.service.NoSuchTaleletException if a matching talelet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.talelets.service.model.Talelet findByTaleStarter_Last(
		long taleStarterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException;

	/**
	* Finds the talelets before and after the current talelet in the ordered set where taleStarterId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param taleId the primary key of the current talelet
	* @param taleStarterId the tale starter id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next talelet
	* @throws com.liferay.talelets.service.NoSuchTaleletException if a talelet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.talelets.service.model.Talelet[] findByTaleStarter_PrevAndNext(
		long taleId, long taleStarterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException;

	/**
	* Finds all the talelets where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.talelets.service.model.Talelet> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the talelets where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param start the lower bound of the range of talelets to return
	* @param end the upper bound of the range of talelets to return (not inclusive)
	* @return the range of matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.talelets.service.model.Talelet> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the talelets where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param start the lower bound of the range of talelets to return
	* @param end the upper bound of the range of talelets to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.talelets.service.model.Talelet> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first talelet in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching talelet
	* @throws com.liferay.talelets.service.NoSuchTaleletException if a matching talelet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.talelets.service.model.Talelet findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException;

	/**
	* Finds the last talelet in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching talelet
	* @throws com.liferay.talelets.service.NoSuchTaleletException if a matching talelet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.talelets.service.model.Talelet findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException;

	/**
	* Finds the talelets before and after the current talelet in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param taleId the primary key of the current talelet
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next talelet
	* @throws com.liferay.talelets.service.NoSuchTaleletException if a talelet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.talelets.service.model.Talelet[] findByCompanyId_PrevAndNext(
		long taleId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException;

	/**
	* Finds all the talelets where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @return the matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.talelets.service.model.Talelet> findByU_G(
		long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the talelets where groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param start the lower bound of the range of talelets to return
	* @param end the upper bound of the range of talelets to return (not inclusive)
	* @return the range of matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.talelets.service.model.Talelet> findByU_G(
		long groupId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the talelets where groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param start the lower bound of the range of talelets to return
	* @param end the upper bound of the range of talelets to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.talelets.service.model.Talelet> findByU_G(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first talelet in the ordered set where groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching talelet
	* @throws com.liferay.talelets.service.NoSuchTaleletException if a matching talelet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.talelets.service.model.Talelet findByU_G_First(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException;

	/**
	* Finds the last talelet in the ordered set where groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching talelet
	* @throws com.liferay.talelets.service.NoSuchTaleletException if a matching talelet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.talelets.service.model.Talelet findByU_G_Last(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException;

	/**
	* Finds the talelets before and after the current talelet in the ordered set where groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param taleId the primary key of the current talelet
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next talelet
	* @throws com.liferay.talelets.service.NoSuchTaleletException if a talelet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.talelets.service.model.Talelet[] findByU_G_PrevAndNext(
		long taleId, long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException;

	/**
	* Filters by the user's permissions and finds all the talelets where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @return the matching talelets that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.talelets.service.model.Talelet> filterFindByU_G(
		long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds a range of all the talelets where groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param start the lower bound of the range of talelets to return
	* @param end the upper bound of the range of talelets to return (not inclusive)
	* @return the range of matching talelets that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.talelets.service.model.Talelet> filterFindByU_G(
		long groupId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds an ordered range of all the talelets where groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param start the lower bound of the range of talelets to return
	* @param end the upper bound of the range of talelets to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching talelets that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.talelets.service.model.Talelet> filterFindByU_G(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the talelets where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @return the matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.talelets.service.model.Talelet> findByG_S(
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the talelets where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @param start the lower bound of the range of talelets to return
	* @param end the upper bound of the range of talelets to return (not inclusive)
	* @return the range of matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.talelets.service.model.Talelet> findByG_S(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the talelets where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @param start the lower bound of the range of talelets to return
	* @param end the upper bound of the range of talelets to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.talelets.service.model.Talelet> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first talelet in the ordered set where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching talelet
	* @throws com.liferay.talelets.service.NoSuchTaleletException if a matching talelet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.talelets.service.model.Talelet findByG_S_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException;

	/**
	* Finds the last talelet in the ordered set where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching talelet
	* @throws com.liferay.talelets.service.NoSuchTaleletException if a matching talelet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.talelets.service.model.Talelet findByG_S_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException;

	/**
	* Finds the talelets before and after the current talelet in the ordered set where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param taleId the primary key of the current talelet
	* @param groupId the group id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next talelet
	* @throws com.liferay.talelets.service.NoSuchTaleletException if a talelet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.talelets.service.model.Talelet[] findByG_S_PrevAndNext(
		long taleId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException;

	/**
	* Filters by the user's permissions and finds all the talelets where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @return the matching talelets that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.talelets.service.model.Talelet> filterFindByG_S(
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds a range of all the talelets where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @param start the lower bound of the range of talelets to return
	* @param end the upper bound of the range of talelets to return (not inclusive)
	* @return the range of matching talelets that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.talelets.service.model.Talelet> filterFindByG_S(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds an ordered range of all the talelets where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @param start the lower bound of the range of talelets to return
	* @param end the upper bound of the range of talelets to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching talelets that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.talelets.service.model.Talelet> filterFindByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the talelets.
	*
	* @return the talelets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.talelets.service.model.Talelet> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the talelets.
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
	public java.util.List<com.liferay.talelets.service.model.Talelet> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the talelets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of talelets to return
	* @param end the upper bound of the range of talelets to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of talelets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.talelets.service.model.Talelet> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the talelets where uuid = &#63; from the database.
	*
	* @param uuid the uuid to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the talelet where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid to search with
	* @param groupId the group id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException;

	/**
	* Removes all the talelets where groupId = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the talelets where groupId = &#63; and taleOrder = &#63; and status = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param taleOrder the tale order to search with
	* @param status the status to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_O(long groupId, int taleOrder, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the talelets where taleParentId = &#63; and taleOrder = &#63; and status = &#63; from the database.
	*
	* @param taleParentId the tale parent id to search with
	* @param taleOrder the tale order to search with
	* @param status the status to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTale(long taleParentId, int taleOrder, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the talelets where taleStarterId = &#63; from the database.
	*
	* @param taleStarterId the tale starter id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTaleStarter(long taleStarterId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the talelets where companyId = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the talelets where groupId = &#63; and userId = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByU_G(long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the talelets where groupId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_S(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the talelets from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the talelets where uuid = &#63;.
	*
	* @param uuid the uuid to search with
	* @return the number of matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the talelets where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid to search with
	* @param groupId the group id to search with
	* @return the number of matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the talelets where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the number of matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and counts all the talelets where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the number of matching talelets that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the talelets where groupId = &#63; and taleOrder = &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param taleOrder the tale order to search with
	* @param status the status to search with
	* @return the number of matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_O(long groupId, int taleOrder, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and counts all the talelets where groupId = &#63; and taleOrder = &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param taleOrder the tale order to search with
	* @param status the status to search with
	* @return the number of matching talelets that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_O(long groupId, int taleOrder, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the talelets where taleParentId = &#63; and taleOrder = &#63; and status = &#63;.
	*
	* @param taleParentId the tale parent id to search with
	* @param taleOrder the tale order to search with
	* @param status the status to search with
	* @return the number of matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public int countByTale(long taleParentId, int taleOrder, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the talelets where taleStarterId = &#63;.
	*
	* @param taleStarterId the tale starter id to search with
	* @return the number of matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public int countByTaleStarter(long taleStarterId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the talelets where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the number of matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the talelets where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @return the number of matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public int countByU_G(long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and counts all the talelets where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @return the number of matching talelets that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByU_G(long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the talelets where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @return the number of matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_S(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and counts all the talelets where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @return the number of matching talelets that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_S(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the talelets.
	*
	* @return the number of talelets
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}