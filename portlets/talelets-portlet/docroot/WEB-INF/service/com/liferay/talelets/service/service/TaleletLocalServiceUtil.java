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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the talelet local service. This utility wraps {@link com.liferay.talelets.service.service.impl.TaleletLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Rich Sezov
 * @see TaleletLocalService
 * @see com.liferay.talelets.service.service.base.TaleletLocalServiceBaseImpl
 * @see com.liferay.talelets.service.service.impl.TaleletLocalServiceImpl
 * @generated
 */
public class TaleletLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.talelets.service.service.impl.TaleletLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the talelet to the database. Also notifies the appropriate model listeners.
	*
	* @param talelet the talelet to add
	* @return the talelet that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.talelets.service.model.Talelet addTalelet(
		com.liferay.talelets.service.model.Talelet talelet)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addTalelet(talelet);
	}

	/**
	* Creates a new talelet with the primary key. Does not add the talelet to the database.
	*
	* @param taleId the primary key for the new talelet
	* @return the new talelet
	*/
	public static com.liferay.talelets.service.model.Talelet createTalelet(
		long taleId) {
		return getService().createTalelet(taleId);
	}

	/**
	* Deletes the talelet with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param taleId the primary key of the talelet to delete
	* @throws PortalException if a talelet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteTalelet(long taleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteTalelet(taleId);
	}

	/**
	* Deletes the talelet from the database. Also notifies the appropriate model listeners.
	*
	* @param talelet the talelet to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteTalelet(
		com.liferay.talelets.service.model.Talelet talelet)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteTalelet(talelet);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the talelet with the primary key.
	*
	* @param taleId the primary key of the talelet to get
	* @return the talelet
	* @throws PortalException if a talelet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.talelets.service.model.Talelet getTalelet(
		long taleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getTalelet(taleId);
	}

	/**
	* Gets the talelet with the UUID and group id.
	*
	* @param uuid the UUID of talelet to get
	* @param groupId the group id of the talelet to get
	* @return the talelet
	* @throws PortalException if a talelet with the UUID and group id could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.talelets.service.model.Talelet getTaleletByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getTaleletByUuidAndGroupId(uuid, groupId);
	}

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
	public static java.util.List<com.liferay.talelets.service.model.Talelet> getTalelets(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTalelets(start, end);
	}

	/**
	* Gets the number of talelets.
	*
	* @return the number of talelets
	* @throws SystemException if a system exception occurred
	*/
	public static int getTaleletsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTaleletsCount();
	}

	/**
	* Updates the talelet in the database. Also notifies the appropriate model listeners.
	*
	* @param talelet the talelet to update
	* @return the talelet that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.talelets.service.model.Talelet updateTalelet(
		com.liferay.talelets.service.model.Talelet talelet)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTalelet(talelet);
	}

	/**
	* Updates the talelet in the database. Also notifies the appropriate model listeners.
	*
	* @param talelet the talelet to update
	* @param merge whether to merge the talelet with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the talelet that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.talelets.service.model.Talelet updateTalelet(
		com.liferay.talelets.service.model.Talelet talelet, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTalelet(talelet, merge);
	}

	public static int getTaleletsCount(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTaleletsCount(groupId, status);
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
	public static java.util.List<com.liferay.talelets.service.model.Talelet> getTalesByDate(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTalesByDate(groupId, status, start, end);
	}

	/**
	* Gets Tale Starters ordered by date. In order to do this, a taleOrder of 1
	*  is hard coded into the query.
	*
	* @param taleId
	* @param status
	* @return
	* @throws SystemException
	*/
	public static java.util.List<com.liferay.talelets.service.model.Talelet> getTaleStartersByDate(
		long taleId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTaleStartersByDate(taleId, status, start, end);
	}

	/**
	* Gets the talelet chain, using the taleStarterId.
	*
	* @param taleStarterId
	* @return
	* @throws SystemException
	*/
	public static java.util.List<com.liferay.talelets.service.model.Talelet> getTalelets(
		long taleStarterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTalelets(taleStarterId);
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
	public static com.liferay.talelets.service.model.Talelet addTalelet(
		com.liferay.talelets.service.model.Talelet newTalelet, long userId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addTalelet(newTalelet, userId, serviceContext);
	}

	public static com.liferay.talelets.service.model.Talelet updateStatus(
		long userId, long resourcePrimKey, int status,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateStatus(userId, resourcePrimKey, status, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static TaleletLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					TaleletLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					TaleletLocalService.class.getName(), portletClassLoader);

			_service = new TaleletLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(TaleletLocalServiceUtil.class,
				"_service");
			MethodCache.remove(TaleletLocalService.class);
		}

		return _service;
	}

	public void setService(TaleletLocalService service) {
		MethodCache.remove(TaleletLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(TaleletLocalServiceUtil.class,
			"_service");
		MethodCache.remove(TaleletLocalService.class);
	}

	private static TaleletLocalService _service;
}