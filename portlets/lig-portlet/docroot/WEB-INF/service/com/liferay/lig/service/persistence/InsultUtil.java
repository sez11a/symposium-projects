/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
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

package com.liferay.lig.service.persistence;

import com.liferay.lig.model.Insult;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the insult service. This utility wraps {@link InsultPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Rich Sezov
 * @see InsultPersistence
 * @see InsultPersistenceImpl
 * @generated
 */
public class InsultUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Insult insult) {
		getPersistence().clearCache(insult);
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
	public static List<Insult> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Insult> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Insult> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static Insult remove(Insult insult) throws SystemException {
		return getPersistence().remove(insult);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Insult update(Insult insult, boolean merge)
		throws SystemException {
		return getPersistence().update(insult, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Insult update(Insult insult, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(insult, merge, serviceContext);
	}

	/**
	* Caches the insult in the entity cache if it is enabled.
	*
	* @param insult the insult to cache
	*/
	public static void cacheResult(com.liferay.lig.model.Insult insult) {
		getPersistence().cacheResult(insult);
	}

	/**
	* Caches the insults in the entity cache if it is enabled.
	*
	* @param insults the insults to cache
	*/
	public static void cacheResult(
		java.util.List<com.liferay.lig.model.Insult> insults) {
		getPersistence().cacheResult(insults);
	}

	/**
	* Creates a new insult with the primary key. Does not add the insult to the database.
	*
	* @param insultId the primary key for the new insult
	* @return the new insult
	*/
	public static com.liferay.lig.model.Insult create(long insultId) {
		return getPersistence().create(insultId);
	}

	/**
	* Removes the insult with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param insultId the primary key of the insult to remove
	* @return the insult that was removed
	* @throws com.liferay.lig.NoSuchInsultException if a insult with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lig.model.Insult remove(long insultId)
		throws com.liferay.lig.NoSuchInsultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(insultId);
	}

	public static com.liferay.lig.model.Insult updateImpl(
		com.liferay.lig.model.Insult insult, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(insult, merge);
	}

	/**
	* Finds the insult with the primary key or throws a {@link com.liferay.lig.NoSuchInsultException} if it could not be found.
	*
	* @param insultId the primary key of the insult to find
	* @return the insult
	* @throws com.liferay.lig.NoSuchInsultException if a insult with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lig.model.Insult findByPrimaryKey(long insultId)
		throws com.liferay.lig.NoSuchInsultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(insultId);
	}

	/**
	* Finds the insult with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param insultId the primary key of the insult to find
	* @return the insult, or <code>null</code> if a insult with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lig.model.Insult fetchByPrimaryKey(long insultId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(insultId);
	}

	/**
	* Finds all the insults where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the matching insults
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lig.model.Insult> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Finds a range of all the insults where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of insults to return
	* @param end the upper bound of the range of insults to return (not inclusive)
	* @return the range of matching insults
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lig.model.Insult> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Finds an ordered range of all the insults where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of insults to return
	* @param end the upper bound of the range of insults to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching insults
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lig.model.Insult> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Finds the first insult in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching insult
	* @throws com.liferay.lig.NoSuchInsultException if a matching insult could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lig.model.Insult findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lig.NoSuchInsultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Finds the last insult in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching insult
	* @throws com.liferay.lig.NoSuchInsultException if a matching insult could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lig.model.Insult findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lig.NoSuchInsultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Finds the insults before and after the current insult in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param insultId the primary key of the current insult
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next insult
	* @throws com.liferay.lig.NoSuchInsultException if a insult with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lig.model.Insult[] findByGroupId_PrevAndNext(
		long insultId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lig.NoSuchInsultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(insultId, groupId,
			orderByComparator);
	}

	/**
	* Filters by the user's permissions and finds all the insults where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the matching insults that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lig.model.Insult> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	* Filters by the user's permissions and finds a range of all the insults where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of insults to return
	* @param end the upper bound of the range of insults to return (not inclusive)
	* @return the range of matching insults that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lig.model.Insult> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	* Filters by the user's permissions and finds an ordered range of all the insults where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of insults to return
	* @param end the upper bound of the range of insults to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching insults that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lig.model.Insult> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Finds all the insults where adjectiveOne = &#63;.
	*
	* @param adjectiveOne the adjective one to search with
	* @return the matching insults
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lig.model.Insult> findByAdjectiveOne(
		java.lang.String adjectiveOne)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAdjectiveOne(adjectiveOne);
	}

	/**
	* Finds a range of all the insults where adjectiveOne = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param adjectiveOne the adjective one to search with
	* @param start the lower bound of the range of insults to return
	* @param end the upper bound of the range of insults to return (not inclusive)
	* @return the range of matching insults
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lig.model.Insult> findByAdjectiveOne(
		java.lang.String adjectiveOne, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAdjectiveOne(adjectiveOne, start, end);
	}

	/**
	* Finds an ordered range of all the insults where adjectiveOne = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param adjectiveOne the adjective one to search with
	* @param start the lower bound of the range of insults to return
	* @param end the upper bound of the range of insults to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching insults
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lig.model.Insult> findByAdjectiveOne(
		java.lang.String adjectiveOne, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAdjectiveOne(adjectiveOne, start, end,
			orderByComparator);
	}

	/**
	* Finds the first insult in the ordered set where adjectiveOne = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param adjectiveOne the adjective one to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching insult
	* @throws com.liferay.lig.NoSuchInsultException if a matching insult could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lig.model.Insult findByAdjectiveOne_First(
		java.lang.String adjectiveOne,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lig.NoSuchInsultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAdjectiveOne_First(adjectiveOne, orderByComparator);
	}

	/**
	* Finds the last insult in the ordered set where adjectiveOne = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param adjectiveOne the adjective one to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching insult
	* @throws com.liferay.lig.NoSuchInsultException if a matching insult could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lig.model.Insult findByAdjectiveOne_Last(
		java.lang.String adjectiveOne,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lig.NoSuchInsultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAdjectiveOne_Last(adjectiveOne, orderByComparator);
	}

	/**
	* Finds the insults before and after the current insult in the ordered set where adjectiveOne = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param insultId the primary key of the current insult
	* @param adjectiveOne the adjective one to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next insult
	* @throws com.liferay.lig.NoSuchInsultException if a insult with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lig.model.Insult[] findByAdjectiveOne_PrevAndNext(
		long insultId, java.lang.String adjectiveOne,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lig.NoSuchInsultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAdjectiveOne_PrevAndNext(insultId, adjectiveOne,
			orderByComparator);
	}

	/**
	* Finds all the insults where directObject = &#63;.
	*
	* @param directObject the direct object to search with
	* @return the matching insults
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lig.model.Insult> findByDirectObject(
		java.lang.String directObject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDirectObject(directObject);
	}

	/**
	* Finds a range of all the insults where directObject = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param directObject the direct object to search with
	* @param start the lower bound of the range of insults to return
	* @param end the upper bound of the range of insults to return (not inclusive)
	* @return the range of matching insults
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lig.model.Insult> findByDirectObject(
		java.lang.String directObject, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDirectObject(directObject, start, end);
	}

	/**
	* Finds an ordered range of all the insults where directObject = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param directObject the direct object to search with
	* @param start the lower bound of the range of insults to return
	* @param end the upper bound of the range of insults to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching insults
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lig.model.Insult> findByDirectObject(
		java.lang.String directObject, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDirectObject(directObject, start, end,
			orderByComparator);
	}

	/**
	* Finds the first insult in the ordered set where directObject = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param directObject the direct object to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching insult
	* @throws com.liferay.lig.NoSuchInsultException if a matching insult could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lig.model.Insult findByDirectObject_First(
		java.lang.String directObject,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lig.NoSuchInsultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDirectObject_First(directObject, orderByComparator);
	}

	/**
	* Finds the last insult in the ordered set where directObject = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param directObject the direct object to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching insult
	* @throws com.liferay.lig.NoSuchInsultException if a matching insult could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lig.model.Insult findByDirectObject_Last(
		java.lang.String directObject,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lig.NoSuchInsultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDirectObject_Last(directObject, orderByComparator);
	}

	/**
	* Finds the insults before and after the current insult in the ordered set where directObject = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param insultId the primary key of the current insult
	* @param directObject the direct object to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next insult
	* @throws com.liferay.lig.NoSuchInsultException if a insult with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lig.model.Insult[] findByDirectObject_PrevAndNext(
		long insultId, java.lang.String directObject,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lig.NoSuchInsultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDirectObject_PrevAndNext(insultId, directObject,
			orderByComparator);
	}

	/**
	* Finds all the insults where adjectiveTwo = &#63;.
	*
	* @param adjectiveTwo the adjective two to search with
	* @return the matching insults
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lig.model.Insult> findByAdjectiveTwo(
		java.lang.String adjectiveTwo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAdjectiveTwo(adjectiveTwo);
	}

	/**
	* Finds a range of all the insults where adjectiveTwo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param adjectiveTwo the adjective two to search with
	* @param start the lower bound of the range of insults to return
	* @param end the upper bound of the range of insults to return (not inclusive)
	* @return the range of matching insults
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lig.model.Insult> findByAdjectiveTwo(
		java.lang.String adjectiveTwo, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAdjectiveTwo(adjectiveTwo, start, end);
	}

	/**
	* Finds an ordered range of all the insults where adjectiveTwo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param adjectiveTwo the adjective two to search with
	* @param start the lower bound of the range of insults to return
	* @param end the upper bound of the range of insults to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching insults
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lig.model.Insult> findByAdjectiveTwo(
		java.lang.String adjectiveTwo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAdjectiveTwo(adjectiveTwo, start, end,
			orderByComparator);
	}

	/**
	* Finds the first insult in the ordered set where adjectiveTwo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param adjectiveTwo the adjective two to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching insult
	* @throws com.liferay.lig.NoSuchInsultException if a matching insult could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lig.model.Insult findByAdjectiveTwo_First(
		java.lang.String adjectiveTwo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lig.NoSuchInsultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAdjectiveTwo_First(adjectiveTwo, orderByComparator);
	}

	/**
	* Finds the last insult in the ordered set where adjectiveTwo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param adjectiveTwo the adjective two to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching insult
	* @throws com.liferay.lig.NoSuchInsultException if a matching insult could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lig.model.Insult findByAdjectiveTwo_Last(
		java.lang.String adjectiveTwo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lig.NoSuchInsultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAdjectiveTwo_Last(adjectiveTwo, orderByComparator);
	}

	/**
	* Finds the insults before and after the current insult in the ordered set where adjectiveTwo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param insultId the primary key of the current insult
	* @param adjectiveTwo the adjective two to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next insult
	* @throws com.liferay.lig.NoSuchInsultException if a insult with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lig.model.Insult[] findByAdjectiveTwo_PrevAndNext(
		long insultId, java.lang.String adjectiveTwo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lig.NoSuchInsultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAdjectiveTwo_PrevAndNext(insultId, adjectiveTwo,
			orderByComparator);
	}

	/**
	* Finds all the insults where objPreposition = &#63;.
	*
	* @param objPreposition the obj preposition to search with
	* @return the matching insults
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lig.model.Insult> findByObjPreposition(
		java.lang.String objPreposition)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByObjPreposition(objPreposition);
	}

	/**
	* Finds a range of all the insults where objPreposition = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param objPreposition the obj preposition to search with
	* @param start the lower bound of the range of insults to return
	* @param end the upper bound of the range of insults to return (not inclusive)
	* @return the range of matching insults
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lig.model.Insult> findByObjPreposition(
		java.lang.String objPreposition, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByObjPreposition(objPreposition, start, end);
	}

	/**
	* Finds an ordered range of all the insults where objPreposition = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param objPreposition the obj preposition to search with
	* @param start the lower bound of the range of insults to return
	* @param end the upper bound of the range of insults to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching insults
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lig.model.Insult> findByObjPreposition(
		java.lang.String objPreposition, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByObjPreposition(objPreposition, start, end,
			orderByComparator);
	}

	/**
	* Finds the first insult in the ordered set where objPreposition = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param objPreposition the obj preposition to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching insult
	* @throws com.liferay.lig.NoSuchInsultException if a matching insult could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lig.model.Insult findByObjPreposition_First(
		java.lang.String objPreposition,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lig.NoSuchInsultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByObjPreposition_First(objPreposition, orderByComparator);
	}

	/**
	* Finds the last insult in the ordered set where objPreposition = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param objPreposition the obj preposition to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching insult
	* @throws com.liferay.lig.NoSuchInsultException if a matching insult could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lig.model.Insult findByObjPreposition_Last(
		java.lang.String objPreposition,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lig.NoSuchInsultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByObjPreposition_Last(objPreposition, orderByComparator);
	}

	/**
	* Finds the insults before and after the current insult in the ordered set where objPreposition = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param insultId the primary key of the current insult
	* @param objPreposition the obj preposition to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next insult
	* @throws com.liferay.lig.NoSuchInsultException if a insult with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lig.model.Insult[] findByObjPreposition_PrevAndNext(
		long insultId, java.lang.String objPreposition,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lig.NoSuchInsultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByObjPreposition_PrevAndNext(insultId, objPreposition,
			orderByComparator);
	}

	/**
	* Finds all the insults.
	*
	* @return the insults
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lig.model.Insult> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Finds a range of all the insults.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of insults to return
	* @param end the upper bound of the range of insults to return (not inclusive)
	* @return the range of insults
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lig.model.Insult> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Finds an ordered range of all the insults.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of insults to return
	* @param end the upper bound of the range of insults to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of insults
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lig.model.Insult> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the insults where groupId = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Removes all the insults where adjectiveOne = &#63; from the database.
	*
	* @param adjectiveOne the adjective one to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAdjectiveOne(java.lang.String adjectiveOne)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAdjectiveOne(adjectiveOne);
	}

	/**
	* Removes all the insults where directObject = &#63; from the database.
	*
	* @param directObject the direct object to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDirectObject(java.lang.String directObject)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDirectObject(directObject);
	}

	/**
	* Removes all the insults where adjectiveTwo = &#63; from the database.
	*
	* @param adjectiveTwo the adjective two to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAdjectiveTwo(java.lang.String adjectiveTwo)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAdjectiveTwo(adjectiveTwo);
	}

	/**
	* Removes all the insults where objPreposition = &#63; from the database.
	*
	* @param objPreposition the obj preposition to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByObjPreposition(java.lang.String objPreposition)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByObjPreposition(objPreposition);
	}

	/**
	* Removes all the insults from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the insults where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the number of matching insults
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Filters by the user's permissions and counts all the insults where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the number of matching insults that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	* Counts all the insults where adjectiveOne = &#63;.
	*
	* @param adjectiveOne the adjective one to search with
	* @return the number of matching insults
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAdjectiveOne(java.lang.String adjectiveOne)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAdjectiveOne(adjectiveOne);
	}

	/**
	* Counts all the insults where directObject = &#63;.
	*
	* @param directObject the direct object to search with
	* @return the number of matching insults
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDirectObject(java.lang.String directObject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDirectObject(directObject);
	}

	/**
	* Counts all the insults where adjectiveTwo = &#63;.
	*
	* @param adjectiveTwo the adjective two to search with
	* @return the number of matching insults
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAdjectiveTwo(java.lang.String adjectiveTwo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAdjectiveTwo(adjectiveTwo);
	}

	/**
	* Counts all the insults where objPreposition = &#63;.
	*
	* @param objPreposition the obj preposition to search with
	* @return the number of matching insults
	* @throws SystemException if a system exception occurred
	*/
	public static int countByObjPreposition(java.lang.String objPreposition)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByObjPreposition(objPreposition);
	}

	/**
	* Counts all the insults.
	*
	* @return the number of insults
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static InsultPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (InsultPersistence)PortletBeanLocatorUtil.locate(com.liferay.lig.service.ClpSerializer.SERVLET_CONTEXT_NAME,
					InsultPersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(InsultPersistence persistence) {
		_persistence = persistence;
	}

	private static InsultPersistence _persistence;
}