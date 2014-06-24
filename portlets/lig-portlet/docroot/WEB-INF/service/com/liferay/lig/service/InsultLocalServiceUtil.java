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

package com.liferay.lig.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;

/**
 * The utility for the insult local service. This utility wraps {@link com.liferay.lig.service.impl.InsultLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * Never modify this class directly. Add custom service methods to {@link com.liferay.lig.service.impl.InsultLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Rich Sezov
 * @see InsultLocalService
 * @see com.liferay.lig.service.base.InsultLocalServiceBaseImpl
 * @see com.liferay.lig.service.impl.InsultLocalServiceImpl
 * @generated
 */
public class InsultLocalServiceUtil {
	/**
	* Adds the insult to the database. Also notifies the appropriate model listeners.
	*
	* @param insult the insult to add
	* @return the insult that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lig.model.Insult addInsult(
		com.liferay.lig.model.Insult insult)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addInsult(insult);
	}

	/**
	* Creates a new insult with the primary key. Does not add the insult to the database.
	*
	* @param insultId the primary key for the new insult
	* @return the new insult
	*/
	public static com.liferay.lig.model.Insult createInsult(long insultId) {
		return getService().createInsult(insultId);
	}

	/**
	* Deletes the insult with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param insultId the primary key of the insult to delete
	* @throws PortalException if a insult with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteInsult(long insultId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteInsult(insultId);
	}

	/**
	* Deletes the insult from the database. Also notifies the appropriate model listeners.
	*
	* @param insult the insult to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteInsult(com.liferay.lig.model.Insult insult)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteInsult(insult);
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
	* Gets the insult with the primary key.
	*
	* @param insultId the primary key of the insult to get
	* @return the insult
	* @throws PortalException if a insult with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lig.model.Insult getInsult(long insultId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getInsult(insultId);
	}

	/**
	* Gets a range of all the insults.
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
	public static java.util.List<com.liferay.lig.model.Insult> getInsults(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getInsults(start, end);
	}

	/**
	* Gets the number of insults.
	*
	* @return the number of insults
	* @throws SystemException if a system exception occurred
	*/
	public static int getInsultsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getInsultsCount();
	}

	/**
	* Updates the insult in the database. Also notifies the appropriate model listeners.
	*
	* @param insult the insult to update
	* @return the insult that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lig.model.Insult updateInsult(
		com.liferay.lig.model.Insult insult)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateInsult(insult);
	}

	/**
	* Updates the insult in the database. Also notifies the appropriate model listeners.
	*
	* @param insult the insult to update
	* @param merge whether to merge the insult with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the insult that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lig.model.Insult updateInsult(
		com.liferay.lig.model.Insult insult, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateInsult(insult, merge);
	}

	/**
	* Gets all statements out of the database.
	*
	* @return List<Insult>
	* @throws SystemException
	*/
	public static java.util.List<com.liferay.lig.model.Insult> getInsults(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getInsults(groupId);
	}

	/**
	* Adds a statement to the database.
	*
	* @param newInsult
	* @param userId
	* @return Insult
	* @throws SystemException
	* @throws PortalException
	*/
	public static com.liferay.lig.model.Insult addInsult(
		com.liferay.lig.model.Insult newInsult, long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addInsult(newInsult, userId);
	}

	public static com.liferay.lig.model.Insult getInsultByObjPreposition(
		java.lang.String objPreposition)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getInsultByObjPreposition(objPreposition);
	}

	public static void clearService() {
		_service = null;
	}

	public static InsultLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					InsultLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new InsultLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(InsultLocalService service) {
		_service = service;
	}

	private static InsultLocalService _service;
}