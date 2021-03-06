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

package com.liferay.talelets.service.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import com.liferay.portlet.asset.service.AssetEntryLocalService;
import com.liferay.portlet.asset.service.AssetEntryService;
import com.liferay.portlet.asset.service.persistence.AssetEntryPersistence;
import com.liferay.portlet.social.service.SocialActivityLocalService;
import com.liferay.portlet.social.service.persistence.SocialActivityPersistence;

import com.liferay.talelets.service.model.Talelet;
import com.liferay.talelets.service.service.TaleletLocalService;
import com.liferay.talelets.service.service.persistence.TaleletPersistence;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the talelet local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.talelets.service.service.impl.TaleletLocalServiceImpl}.
 * </p>
 *
 * @author Rich Sezov
 * @see com.liferay.talelets.service.service.impl.TaleletLocalServiceImpl
 * @see com.liferay.talelets.service.service.TaleletLocalServiceUtil
 * @generated
 */
public abstract class TaleletLocalServiceBaseImpl implements TaleletLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.talelets.service.service.TaleletLocalServiceUtil} to access the talelet local service.
	 */

	/**
	 * Adds the talelet to the database. Also notifies the appropriate model listeners.
	 *
	 * @param talelet the talelet to add
	 * @return the talelet that was added
	 * @throws SystemException if a system exception occurred
	 */
	public Talelet addTalelet(Talelet talelet) throws SystemException {
		talelet.setNew(true);

		return taleletPersistence.update(talelet, false);
	}

	/**
	 * Creates a new talelet with the primary key. Does not add the talelet to the database.
	 *
	 * @param taleId the primary key for the new talelet
	 * @return the new talelet
	 */
	public Talelet createTalelet(long taleId) {
		return taleletPersistence.create(taleId);
	}

	/**
	 * Deletes the talelet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taleId the primary key of the talelet to delete
	 * @throws PortalException if a talelet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteTalelet(long taleId)
		throws PortalException, SystemException {
		taleletPersistence.remove(taleId);
	}

	/**
	 * Deletes the talelet from the database. Also notifies the appropriate model listeners.
	 *
	 * @param talelet the talelet to delete
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteTalelet(Talelet talelet) throws SystemException {
		taleletPersistence.remove(talelet);
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return taleletPersistence.findWithDynamicQuery(dynamicQuery);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return taleletPersistence.findWithDynamicQuery(dynamicQuery, start, end);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return taleletPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Counts the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return taleletPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Gets the talelet with the primary key.
	 *
	 * @param taleId the primary key of the talelet to get
	 * @return the talelet
	 * @throws PortalException if a talelet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Talelet getTalelet(long taleId)
		throws PortalException, SystemException {
		return taleletPersistence.findByPrimaryKey(taleId);
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
	public Talelet getTaleletByUuidAndGroupId(String uuid, long groupId)
		throws PortalException, SystemException {
		return taleletPersistence.findByUUID_G(uuid, groupId);
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
	public List<Talelet> getTalelets(int start, int end)
		throws SystemException {
		return taleletPersistence.findAll(start, end);
	}

	/**
	 * Gets the number of talelets.
	 *
	 * @return the number of talelets
	 * @throws SystemException if a system exception occurred
	 */
	public int getTaleletsCount() throws SystemException {
		return taleletPersistence.countAll();
	}

	/**
	 * Updates the talelet in the database. Also notifies the appropriate model listeners.
	 *
	 * @param talelet the talelet to update
	 * @return the talelet that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public Talelet updateTalelet(Talelet talelet) throws SystemException {
		talelet.setNew(false);

		return taleletPersistence.update(talelet, true);
	}

	/**
	 * Updates the talelet in the database. Also notifies the appropriate model listeners.
	 *
	 * @param talelet the talelet to update
	 * @param merge whether to merge the talelet with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the talelet that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public Talelet updateTalelet(Talelet talelet, boolean merge)
		throws SystemException {
		talelet.setNew(false);

		return taleletPersistence.update(talelet, merge);
	}

	/**
	 * Gets the talelet local service.
	 *
	 * @return the talelet local service
	 */
	public TaleletLocalService getTaleletLocalService() {
		return taleletLocalService;
	}

	/**
	 * Sets the talelet local service.
	 *
	 * @param taleletLocalService the talelet local service
	 */
	public void setTaleletLocalService(TaleletLocalService taleletLocalService) {
		this.taleletLocalService = taleletLocalService;
	}

	/**
	 * Gets the talelet persistence.
	 *
	 * @return the talelet persistence
	 */
	public TaleletPersistence getTaleletPersistence() {
		return taleletPersistence;
	}

	/**
	 * Sets the talelet persistence.
	 *
	 * @param taleletPersistence the talelet persistence
	 */
	public void setTaleletPersistence(TaleletPersistence taleletPersistence) {
		this.taleletPersistence = taleletPersistence;
	}

	/**
	 * Gets the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Gets the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Gets the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Gets the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Gets the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Gets the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Gets the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	/**
	 * Gets the asset entry local service.
	 *
	 * @return the asset entry local service
	 */
	public AssetEntryLocalService getAssetEntryLocalService() {
		return assetEntryLocalService;
	}

	/**
	 * Sets the asset entry local service.
	 *
	 * @param assetEntryLocalService the asset entry local service
	 */
	public void setAssetEntryLocalService(
		AssetEntryLocalService assetEntryLocalService) {
		this.assetEntryLocalService = assetEntryLocalService;
	}

	/**
	 * Gets the asset entry remote service.
	 *
	 * @return the asset entry remote service
	 */
	public AssetEntryService getAssetEntryService() {
		return assetEntryService;
	}

	/**
	 * Sets the asset entry remote service.
	 *
	 * @param assetEntryService the asset entry remote service
	 */
	public void setAssetEntryService(AssetEntryService assetEntryService) {
		this.assetEntryService = assetEntryService;
	}

	/**
	 * Gets the asset entry persistence.
	 *
	 * @return the asset entry persistence
	 */
	public AssetEntryPersistence getAssetEntryPersistence() {
		return assetEntryPersistence;
	}

	/**
	 * Sets the asset entry persistence.
	 *
	 * @param assetEntryPersistence the asset entry persistence
	 */
	public void setAssetEntryPersistence(
		AssetEntryPersistence assetEntryPersistence) {
		this.assetEntryPersistence = assetEntryPersistence;
	}

	/**
	 * Gets the social activity local service.
	 *
	 * @return the social activity local service
	 */
	public SocialActivityLocalService getSocialActivityLocalService() {
		return socialActivityLocalService;
	}

	/**
	 * Sets the social activity local service.
	 *
	 * @param socialActivityLocalService the social activity local service
	 */
	public void setSocialActivityLocalService(
		SocialActivityLocalService socialActivityLocalService) {
		this.socialActivityLocalService = socialActivityLocalService;
	}

	/**
	 * Gets the social activity persistence.
	 *
	 * @return the social activity persistence
	 */
	public SocialActivityPersistence getSocialActivityPersistence() {
		return socialActivityPersistence;
	}

	/**
	 * Sets the social activity persistence.
	 *
	 * @param socialActivityPersistence the social activity persistence
	 */
	public void setSocialActivityPersistence(
		SocialActivityPersistence socialActivityPersistence) {
		this.socialActivityPersistence = socialActivityPersistence;
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query to perform
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = taleletPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = TaleletLocalService.class)
	protected TaleletLocalService taleletLocalService;
	@BeanReference(type = TaleletPersistence.class)
	protected TaleletPersistence taleletPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@BeanReference(type = AssetEntryLocalService.class)
	protected AssetEntryLocalService assetEntryLocalService;
	@BeanReference(type = AssetEntryService.class)
	protected AssetEntryService assetEntryService;
	@BeanReference(type = AssetEntryPersistence.class)
	protected AssetEntryPersistence assetEntryPersistence;
	@BeanReference(type = SocialActivityLocalService.class)
	protected SocialActivityLocalService socialActivityLocalService;
	@BeanReference(type = SocialActivityPersistence.class)
	protected SocialActivityPersistence socialActivityPersistence;
}