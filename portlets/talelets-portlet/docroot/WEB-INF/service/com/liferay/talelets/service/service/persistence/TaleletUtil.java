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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.liferay.talelets.service.model.Talelet;

import java.util.List;

/**
 * The persistence utility for the talelet service. This utility wraps {@link TaleletPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Rich Sezov
 * @see TaleletPersistence
 * @see TaleletPersistenceImpl
 * @generated
 */
public class TaleletUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Talelet talelet) {
		getPersistence().clearCache(talelet);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Talelet> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Talelet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Talelet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static Talelet remove(Talelet talelet) throws SystemException {
		return getPersistence().remove(talelet);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Talelet update(Talelet talelet, boolean merge)
		throws SystemException {
		return getPersistence().update(talelet, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Talelet update(Talelet talelet, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(talelet, merge, serviceContext);
	}

	/**
	* Caches the talelet in the entity cache if it is enabled.
	*
	* @param talelet the talelet to cache
	*/
	public static void cacheResult(
		com.liferay.talelets.service.model.Talelet talelet) {
		getPersistence().cacheResult(talelet);
	}

	/**
	* Caches the talelets in the entity cache if it is enabled.
	*
	* @param talelets the talelets to cache
	*/
	public static void cacheResult(
		java.util.List<com.liferay.talelets.service.model.Talelet> talelets) {
		getPersistence().cacheResult(talelets);
	}

	/**
	* Creates a new talelet with the primary key. Does not add the talelet to the database.
	*
	* @param taleId the primary key for the new talelet
	* @return the new talelet
	*/
	public static com.liferay.talelets.service.model.Talelet create(long taleId) {
		return getPersistence().create(taleId);
	}

	/**
	* Removes the talelet with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param taleId the primary key of the talelet to remove
	* @return the talelet that was removed
	* @throws com.liferay.talelets.service.NoSuchTaleletException if a talelet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.talelets.service.model.Talelet remove(long taleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException {
		return getPersistence().remove(taleId);
	}

	public static com.liferay.talelets.service.model.Talelet updateImpl(
		com.liferay.talelets.service.model.Talelet talelet, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(talelet, merge);
	}

	/**
	* Finds the talelet with the primary key or throws a {@link com.liferay.talelets.service.NoSuchTaleletException} if it could not be found.
	*
	* @param taleId the primary key of the talelet to find
	* @return the talelet
	* @throws com.liferay.talelets.service.NoSuchTaleletException if a talelet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.talelets.service.model.Talelet findByPrimaryKey(
		long taleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException {
		return getPersistence().findByPrimaryKey(taleId);
	}

	/**
	* Finds the talelet with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param taleId the primary key of the talelet to find
	* @return the talelet, or <code>null</code> if a talelet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.talelets.service.model.Talelet fetchByPrimaryKey(
		long taleId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(taleId);
	}

	/**
	* Finds all the talelets where uuid = &#63;.
	*
	* @param uuid the uuid to search with
	* @return the matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.talelets.service.model.Talelet> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

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
	public static java.util.List<com.liferay.talelets.service.model.Talelet> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static java.util.List<com.liferay.talelets.service.model.Talelet> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static com.liferay.talelets.service.model.Talelet findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

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
	public static com.liferay.talelets.service.model.Talelet findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

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
	public static com.liferay.talelets.service.model.Talelet[] findByUuid_PrevAndNext(
		long taleId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException {
		return getPersistence()
				   .findByUuid_PrevAndNext(taleId, uuid, orderByComparator);
	}

	/**
	* Finds the talelet where uuid = &#63; and groupId = &#63; or throws a {@link com.liferay.talelets.service.NoSuchTaleletException} if it could not be found.
	*
	* @param uuid the uuid to search with
	* @param groupId the group id to search with
	* @return the matching talelet
	* @throws com.liferay.talelets.service.NoSuchTaleletException if a matching talelet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.talelets.service.model.Talelet findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Finds the talelet where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid to search with
	* @param groupId the group id to search with
	* @return the matching talelet, or <code>null</code> if a matching talelet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.talelets.service.model.Talelet fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Finds the talelet where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid to search with
	* @param groupId the group id to search with
	* @return the matching talelet, or <code>null</code> if a matching talelet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.talelets.service.model.Talelet fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Finds all the talelets where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.talelets.service.model.Talelet> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

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
	public static java.util.List<com.liferay.talelets.service.model.Talelet> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

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
	public static java.util.List<com.liferay.talelets.service.model.Talelet> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

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
	public static com.liferay.talelets.service.model.Talelet findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

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
	public static com.liferay.talelets.service.model.Talelet findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

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
	public static com.liferay.talelets.service.model.Talelet[] findByGroupId_PrevAndNext(
		long taleId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(taleId, groupId, orderByComparator);
	}

	/**
	* Filters by the user's permissions and finds all the talelets where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the matching talelets that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.talelets.service.model.Talelet> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId);
	}

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
	public static java.util.List<com.liferay.talelets.service.model.Talelet> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

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
	public static java.util.List<com.liferay.talelets.service.model.Talelet> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Finds all the talelets where groupId = &#63; and taleOrder = &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param taleOrder the tale order to search with
	* @param status the status to search with
	* @return the matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.talelets.service.model.Talelet> findByG_O(
		long groupId, int taleOrder, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_O(groupId, taleOrder, status);
	}

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
	public static java.util.List<com.liferay.talelets.service.model.Talelet> findByG_O(
		long groupId, int taleOrder, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_O(groupId, taleOrder, status, start, end);
	}

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
	public static java.util.List<com.liferay.talelets.service.model.Talelet> findByG_O(
		long groupId, int taleOrder, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_O(groupId, taleOrder, status, start, end,
			orderByComparator);
	}

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
	public static com.liferay.talelets.service.model.Talelet findByG_O_First(
		long groupId, int taleOrder, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException {
		return getPersistence()
				   .findByG_O_First(groupId, taleOrder, status,
			orderByComparator);
	}

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
	public static com.liferay.talelets.service.model.Talelet findByG_O_Last(
		long groupId, int taleOrder, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException {
		return getPersistence()
				   .findByG_O_Last(groupId, taleOrder, status, orderByComparator);
	}

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
	public static com.liferay.talelets.service.model.Talelet[] findByG_O_PrevAndNext(
		long taleId, long groupId, int taleOrder, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException {
		return getPersistence()
				   .findByG_O_PrevAndNext(taleId, groupId, taleOrder, status,
			orderByComparator);
	}

	/**
	* Filters by the user's permissions and finds all the talelets where groupId = &#63; and taleOrder = &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param taleOrder the tale order to search with
	* @param status the status to search with
	* @return the matching talelets that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.talelets.service.model.Talelet> filterFindByG_O(
		long groupId, int taleOrder, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_O(groupId, taleOrder, status);
	}

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
	public static java.util.List<com.liferay.talelets.service.model.Talelet> filterFindByG_O(
		long groupId, int taleOrder, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_O(groupId, taleOrder, status, start, end);
	}

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
	public static java.util.List<com.liferay.talelets.service.model.Talelet> filterFindByG_O(
		long groupId, int taleOrder, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_O(groupId, taleOrder, status, start, end,
			orderByComparator);
	}

	/**
	* Finds all the talelets where taleParentId = &#63; and taleOrder = &#63; and status = &#63;.
	*
	* @param taleParentId the tale parent id to search with
	* @param taleOrder the tale order to search with
	* @param status the status to search with
	* @return the matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.talelets.service.model.Talelet> findByTale(
		long taleParentId, int taleOrder, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTale(taleParentId, taleOrder, status);
	}

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
	public static java.util.List<com.liferay.talelets.service.model.Talelet> findByTale(
		long taleParentId, int taleOrder, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTale(taleParentId, taleOrder, status, start, end);
	}

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
	public static java.util.List<com.liferay.talelets.service.model.Talelet> findByTale(
		long taleParentId, int taleOrder, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTale(taleParentId, taleOrder, status, start, end,
			orderByComparator);
	}

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
	public static com.liferay.talelets.service.model.Talelet findByTale_First(
		long taleParentId, int taleOrder, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException {
		return getPersistence()
				   .findByTale_First(taleParentId, taleOrder, status,
			orderByComparator);
	}

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
	public static com.liferay.talelets.service.model.Talelet findByTale_Last(
		long taleParentId, int taleOrder, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException {
		return getPersistence()
				   .findByTale_Last(taleParentId, taleOrder, status,
			orderByComparator);
	}

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
	public static com.liferay.talelets.service.model.Talelet[] findByTale_PrevAndNext(
		long taleId, long taleParentId, int taleOrder, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException {
		return getPersistence()
				   .findByTale_PrevAndNext(taleId, taleParentId, taleOrder,
			status, orderByComparator);
	}

	/**
	* Finds all the talelets where taleStarterId = &#63;.
	*
	* @param taleStarterId the tale starter id to search with
	* @return the matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.talelets.service.model.Talelet> findByTaleStarter(
		long taleStarterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTaleStarter(taleStarterId);
	}

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
	public static java.util.List<com.liferay.talelets.service.model.Talelet> findByTaleStarter(
		long taleStarterId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTaleStarter(taleStarterId, start, end);
	}

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
	public static java.util.List<com.liferay.talelets.service.model.Talelet> findByTaleStarter(
		long taleStarterId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTaleStarter(taleStarterId, start, end,
			orderByComparator);
	}

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
	public static com.liferay.talelets.service.model.Talelet findByTaleStarter_First(
		long taleStarterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException {
		return getPersistence()
				   .findByTaleStarter_First(taleStarterId, orderByComparator);
	}

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
	public static com.liferay.talelets.service.model.Talelet findByTaleStarter_Last(
		long taleStarterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException {
		return getPersistence()
				   .findByTaleStarter_Last(taleStarterId, orderByComparator);
	}

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
	public static com.liferay.talelets.service.model.Talelet[] findByTaleStarter_PrevAndNext(
		long taleId, long taleStarterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException {
		return getPersistence()
				   .findByTaleStarter_PrevAndNext(taleId, taleStarterId,
			orderByComparator);
	}

	/**
	* Finds all the talelets where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.talelets.service.model.Talelet> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId);
	}

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
	public static java.util.List<com.liferay.talelets.service.model.Talelet> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

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
	public static java.util.List<com.liferay.talelets.service.model.Talelet> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

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
	public static com.liferay.talelets.service.model.Talelet findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

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
	public static com.liferay.talelets.service.model.Talelet findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

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
	public static com.liferay.talelets.service.model.Talelet[] findByCompanyId_PrevAndNext(
		long taleId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(taleId, companyId,
			orderByComparator);
	}

	/**
	* Finds all the talelets where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @return the matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.talelets.service.model.Talelet> findByU_G(
		long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByU_G(groupId, userId);
	}

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
	public static java.util.List<com.liferay.talelets.service.model.Talelet> findByU_G(
		long groupId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByU_G(groupId, userId, start, end);
	}

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
	public static java.util.List<com.liferay.talelets.service.model.Talelet> findByU_G(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByU_G(groupId, userId, start, end, orderByComparator);
	}

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
	public static com.liferay.talelets.service.model.Talelet findByU_G_First(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException {
		return getPersistence()
				   .findByU_G_First(groupId, userId, orderByComparator);
	}

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
	public static com.liferay.talelets.service.model.Talelet findByU_G_Last(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException {
		return getPersistence()
				   .findByU_G_Last(groupId, userId, orderByComparator);
	}

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
	public static com.liferay.talelets.service.model.Talelet[] findByU_G_PrevAndNext(
		long taleId, long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException {
		return getPersistence()
				   .findByU_G_PrevAndNext(taleId, groupId, userId,
			orderByComparator);
	}

	/**
	* Filters by the user's permissions and finds all the talelets where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @return the matching talelets that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.talelets.service.model.Talelet> filterFindByU_G(
		long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByU_G(groupId, userId);
	}

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
	public static java.util.List<com.liferay.talelets.service.model.Talelet> filterFindByU_G(
		long groupId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByU_G(groupId, userId, start, end);
	}

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
	public static java.util.List<com.liferay.talelets.service.model.Talelet> filterFindByU_G(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByU_G(groupId, userId, start, end,
			orderByComparator);
	}

	/**
	* Finds all the talelets where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @return the matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.talelets.service.model.Talelet> findByG_S(
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_S(groupId, status);
	}

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
	public static java.util.List<com.liferay.talelets.service.model.Talelet> findByG_S(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_S(groupId, status, start, end);
	}

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
	public static java.util.List<com.liferay.talelets.service.model.Talelet> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_S(groupId, status, start, end, orderByComparator);
	}

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
	public static com.liferay.talelets.service.model.Talelet findByG_S_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException {
		return getPersistence()
				   .findByG_S_First(groupId, status, orderByComparator);
	}

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
	public static com.liferay.talelets.service.model.Talelet findByG_S_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException {
		return getPersistence()
				   .findByG_S_Last(groupId, status, orderByComparator);
	}

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
	public static com.liferay.talelets.service.model.Talelet[] findByG_S_PrevAndNext(
		long taleId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException {
		return getPersistence()
				   .findByG_S_PrevAndNext(taleId, groupId, status,
			orderByComparator);
	}

	/**
	* Filters by the user's permissions and finds all the talelets where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @return the matching talelets that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.talelets.service.model.Talelet> filterFindByG_S(
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_S(groupId, status);
	}

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
	public static java.util.List<com.liferay.talelets.service.model.Talelet> filterFindByG_S(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_S(groupId, status, start, end);
	}

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
	public static java.util.List<com.liferay.talelets.service.model.Talelet> filterFindByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_S(groupId, status, start, end,
			orderByComparator);
	}

	/**
	* Finds all the talelets.
	*
	* @return the talelets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.talelets.service.model.Talelet> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.liferay.talelets.service.model.Talelet> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.liferay.talelets.service.model.Talelet> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the talelets where uuid = &#63; from the database.
	*
	* @param uuid the uuid to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Removes the talelet where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid to search with
	* @param groupId the group id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.talelets.service.NoSuchTaleletException {
		getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Removes all the talelets where groupId = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Removes all the talelets where groupId = &#63; and taleOrder = &#63; and status = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param taleOrder the tale order to search with
	* @param status the status to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_O(long groupId, int taleOrder, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_O(groupId, taleOrder, status);
	}

	/**
	* Removes all the talelets where taleParentId = &#63; and taleOrder = &#63; and status = &#63; from the database.
	*
	* @param taleParentId the tale parent id to search with
	* @param taleOrder the tale order to search with
	* @param status the status to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTale(long taleParentId, int taleOrder, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTale(taleParentId, taleOrder, status);
	}

	/**
	* Removes all the talelets where taleStarterId = &#63; from the database.
	*
	* @param taleStarterId the tale starter id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTaleStarter(long taleStarterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTaleStarter(taleStarterId);
	}

	/**
	* Removes all the talelets where companyId = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Removes all the talelets where groupId = &#63; and userId = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByU_G(long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByU_G(groupId, userId);
	}

	/**
	* Removes all the talelets where groupId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_S(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_S(groupId, status);
	}

	/**
	* Removes all the talelets from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the talelets where uuid = &#63;.
	*
	* @param uuid the uuid to search with
	* @return the number of matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Counts all the talelets where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid to search with
	* @param groupId the group id to search with
	* @return the number of matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Counts all the talelets where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the number of matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Filters by the user's permissions and counts all the talelets where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the number of matching talelets that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	* Counts all the talelets where groupId = &#63; and taleOrder = &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param taleOrder the tale order to search with
	* @param status the status to search with
	* @return the number of matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_O(long groupId, int taleOrder, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_O(groupId, taleOrder, status);
	}

	/**
	* Filters by the user's permissions and counts all the talelets where groupId = &#63; and taleOrder = &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param taleOrder the tale order to search with
	* @param status the status to search with
	* @return the number of matching talelets that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_O(long groupId, int taleOrder, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByG_O(groupId, taleOrder, status);
	}

	/**
	* Counts all the talelets where taleParentId = &#63; and taleOrder = &#63; and status = &#63;.
	*
	* @param taleParentId the tale parent id to search with
	* @param taleOrder the tale order to search with
	* @param status the status to search with
	* @return the number of matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTale(long taleParentId, int taleOrder, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTale(taleParentId, taleOrder, status);
	}

	/**
	* Counts all the talelets where taleStarterId = &#63;.
	*
	* @param taleStarterId the tale starter id to search with
	* @return the number of matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTaleStarter(long taleStarterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTaleStarter(taleStarterId);
	}

	/**
	* Counts all the talelets where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the number of matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Counts all the talelets where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @return the number of matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public static int countByU_G(long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByU_G(groupId, userId);
	}

	/**
	* Filters by the user's permissions and counts all the talelets where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @return the number of matching talelets that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByU_G(long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByU_G(groupId, userId);
	}

	/**
	* Counts all the talelets where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @return the number of matching talelets
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_S(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_S(groupId, status);
	}

	/**
	* Filters by the user's permissions and counts all the talelets where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @return the number of matching talelets that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_S(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByG_S(groupId, status);
	}

	/**
	* Counts all the talelets.
	*
	* @return the number of talelets
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TaleletPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TaleletPersistence)PortletBeanLocatorUtil.locate(com.liferay.talelets.service.service.ClpSerializer.SERVLET_CONTEXT_NAME,
					TaleletPersistence.class.getName());

			ReferenceRegistry.registerReference(TaleletUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(TaleletPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(TaleletUtil.class, "_persistence");
	}

	private static TaleletPersistence _persistence;
}