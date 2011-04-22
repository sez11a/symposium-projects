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

package com.liferay.talelets.service.model;

/**
 * <p>
 * This class is a wrapper for {@link Talelet}.
 * </p>
 *
 * @author    Rich Sezov
 * @see       Talelet
 * @generated
 */
public class TaleletWrapper implements Talelet {
	public TaleletWrapper(Talelet talelet) {
		_talelet = talelet;
	}

	/**
	* Gets the primary key of this talelet.
	*
	* @return the primary key of this talelet
	*/
	public long getPrimaryKey() {
		return _talelet.getPrimaryKey();
	}

	/**
	* Sets the primary key of this talelet
	*
	* @param pk the primary key of this talelet
	*/
	public void setPrimaryKey(long pk) {
		_talelet.setPrimaryKey(pk);
	}

	/**
	* Gets the uuid of this talelet.
	*
	* @return the uuid of this talelet
	*/
	public java.lang.String getUuid() {
		return _talelet.getUuid();
	}

	/**
	* Sets the uuid of this talelet.
	*
	* @param uuid the uuid of this talelet
	*/
	public void setUuid(java.lang.String uuid) {
		_talelet.setUuid(uuid);
	}

	/**
	* Gets the tale id of this talelet.
	*
	* @return the tale id of this talelet
	*/
	public long getTaleId() {
		return _talelet.getTaleId();
	}

	/**
	* Sets the tale id of this talelet.
	*
	* @param taleId the tale id of this talelet
	*/
	public void setTaleId(long taleId) {
		_talelet.setTaleId(taleId);
	}

	/**
	* Gets the tale parent id of this talelet.
	*
	* @return the tale parent id of this talelet
	*/
	public long getTaleParentId() {
		return _talelet.getTaleParentId();
	}

	/**
	* Sets the tale parent id of this talelet.
	*
	* @param taleParentId the tale parent id of this talelet
	*/
	public void setTaleParentId(long taleParentId) {
		_talelet.setTaleParentId(taleParentId);
	}

	/**
	* Gets the tale starter id of this talelet.
	*
	* @return the tale starter id of this talelet
	*/
	public long getTaleStarterId() {
		return _talelet.getTaleStarterId();
	}

	/**
	* Sets the tale starter id of this talelet.
	*
	* @param taleStarterId the tale starter id of this talelet
	*/
	public void setTaleStarterId(long taleStarterId) {
		_talelet.setTaleStarterId(taleStarterId);
	}

	/**
	* Gets the tale order of this talelet.
	*
	* @return the tale order of this talelet
	*/
	public int getTaleOrder() {
		return _talelet.getTaleOrder();
	}

	/**
	* Sets the tale order of this talelet.
	*
	* @param taleOrder the tale order of this talelet
	*/
	public void setTaleOrder(int taleOrder) {
		_talelet.setTaleOrder(taleOrder);
	}

	/**
	* Gets the tale title of this talelet.
	*
	* @return the tale title of this talelet
	*/
	public java.lang.String getTaleTitle() {
		return _talelet.getTaleTitle();
	}

	/**
	* Sets the tale title of this talelet.
	*
	* @param taleTitle the tale title of this talelet
	*/
	public void setTaleTitle(java.lang.String taleTitle) {
		_talelet.setTaleTitle(taleTitle);
	}

	/**
	* Gets the author name of this talelet.
	*
	* @return the author name of this talelet
	*/
	public java.lang.String getAuthorName() {
		return _talelet.getAuthorName();
	}

	/**
	* Sets the author name of this talelet.
	*
	* @param authorName the author name of this talelet
	*/
	public void setAuthorName(java.lang.String authorName) {
		_talelet.setAuthorName(authorName);
	}

	/**
	* Gets the tale date of this talelet.
	*
	* @return the tale date of this talelet
	*/
	public java.util.Date getTaleDate() {
		return _talelet.getTaleDate();
	}

	/**
	* Sets the tale date of this talelet.
	*
	* @param taleDate the tale date of this talelet
	*/
	public void setTaleDate(java.util.Date taleDate) {
		_talelet.setTaleDate(taleDate);
	}

	/**
	* Gets the date updated of this talelet.
	*
	* @return the date updated of this talelet
	*/
	public java.util.Date getDateUpdated() {
		return _talelet.getDateUpdated();
	}

	/**
	* Sets the date updated of this talelet.
	*
	* @param dateUpdated the date updated of this talelet
	*/
	public void setDateUpdated(java.util.Date dateUpdated) {
		_talelet.setDateUpdated(dateUpdated);
	}

	/**
	* Gets the content of this talelet.
	*
	* @return the content of this talelet
	*/
	public java.lang.String getContent() {
		return _talelet.getContent();
	}

	/**
	* Sets the content of this talelet.
	*
	* @param content the content of this talelet
	*/
	public void setContent(java.lang.String content) {
		_talelet.setContent(content);
	}

	/**
	* Gets the company id of this talelet.
	*
	* @return the company id of this talelet
	*/
	public long getCompanyId() {
		return _talelet.getCompanyId();
	}

	/**
	* Sets the company id of this talelet.
	*
	* @param companyId the company id of this talelet
	*/
	public void setCompanyId(long companyId) {
		_talelet.setCompanyId(companyId);
	}

	/**
	* Gets the group id of this talelet.
	*
	* @return the group id of this talelet
	*/
	public long getGroupId() {
		return _talelet.getGroupId();
	}

	/**
	* Sets the group id of this talelet.
	*
	* @param groupId the group id of this talelet
	*/
	public void setGroupId(long groupId) {
		_talelet.setGroupId(groupId);
	}

	/**
	* Gets the user id of this talelet.
	*
	* @return the user id of this talelet
	*/
	public long getUserId() {
		return _talelet.getUserId();
	}

	/**
	* Sets the user id of this talelet.
	*
	* @param userId the user id of this talelet
	*/
	public void setUserId(long userId) {
		_talelet.setUserId(userId);
	}

	/**
	* Gets the user uuid of this talelet.
	*
	* @return the user uuid of this talelet
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _talelet.getUserUuid();
	}

	/**
	* Sets the user uuid of this talelet.
	*
	* @param userUuid the user uuid of this talelet
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_talelet.setUserUuid(userUuid);
	}

	/**
	* Gets the status of this talelet.
	*
	* @return the status of this talelet
	*/
	public int getStatus() {
		return _talelet.getStatus();
	}

	/**
	* Sets the status of this talelet.
	*
	* @param status the status of this talelet
	*/
	public void setStatus(int status) {
		_talelet.setStatus(status);
	}

	/**
	* Gets the status by user id of this talelet.
	*
	* @return the status by user id of this talelet
	*/
	public long getStatusByUserId() {
		return _talelet.getStatusByUserId();
	}

	/**
	* Sets the status by user id of this talelet.
	*
	* @param statusByUserId the status by user id of this talelet
	*/
	public void setStatusByUserId(long statusByUserId) {
		_talelet.setStatusByUserId(statusByUserId);
	}

	/**
	* Gets the status by user uuid of this talelet.
	*
	* @return the status by user uuid of this talelet
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getStatusByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _talelet.getStatusByUserUuid();
	}

	/**
	* Sets the status by user uuid of this talelet.
	*
	* @param statusByUserUuid the status by user uuid of this talelet
	*/
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_talelet.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Gets the status by user name of this talelet.
	*
	* @return the status by user name of this talelet
	*/
	public java.lang.String getStatusByUserName() {
		return _talelet.getStatusByUserName();
	}

	/**
	* Sets the status by user name of this talelet.
	*
	* @param statusByUserName the status by user name of this talelet
	*/
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_talelet.setStatusByUserName(statusByUserName);
	}

	/**
	* Gets the status date of this talelet.
	*
	* @return the status date of this talelet
	*/
	public java.util.Date getStatusDate() {
		return _talelet.getStatusDate();
	}

	/**
	* Sets the status date of this talelet.
	*
	* @param statusDate the status date of this talelet
	*/
	public void setStatusDate(java.util.Date statusDate) {
		_talelet.setStatusDate(statusDate);
	}

	/**
	* @deprecated {@link #isApproved}
	*/
	public boolean getApproved() {
		return _talelet.getApproved();
	}

	/**
	* Determines if this talelet is approved.
	*
	* @return <code>true</code> if this talelet is approved; <code>false</code> otherwise
	*/
	public boolean isApproved() {
		return _talelet.isApproved();
	}

	/**
	* Determines if this talelet is a draft.
	*
	* @return <code>true</code> if this talelet is a draft; <code>false</code> otherwise
	*/
	public boolean isDraft() {
		return _talelet.isDraft();
	}

	/**
	* Determines if this talelet is expired.
	*
	* @return <code>true</code> if this talelet is expired; <code>false</code> otherwise
	*/
	public boolean isExpired() {
		return _talelet.isExpired();
	}

	/**
	* Determines if this talelet is pending.
	*
	* @return <code>true</code> if this talelet is pending; <code>false</code> otherwise
	*/
	public boolean isPending() {
		return _talelet.isPending();
	}

	public boolean isNew() {
		return _talelet.isNew();
	}

	public void setNew(boolean n) {
		_talelet.setNew(n);
	}

	public boolean isCachedModel() {
		return _talelet.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_talelet.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _talelet.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_talelet.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _talelet.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _talelet.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_talelet.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new TaleletWrapper((Talelet)_talelet.clone());
	}

	public int compareTo(com.liferay.talelets.service.model.Talelet talelet) {
		return _talelet.compareTo(talelet);
	}

	public int hashCode() {
		return _talelet.hashCode();
	}

	public com.liferay.talelets.service.model.Talelet toEscapedModel() {
		return new TaleletWrapper(_talelet.toEscapedModel());
	}

	public java.lang.String toString() {
		return _talelet.toString();
	}

	public java.lang.String toXmlString() {
		return _talelet.toXmlString();
	}

	public Talelet getWrappedTalelet() {
		return _talelet;
	}

	private Talelet _talelet;
}