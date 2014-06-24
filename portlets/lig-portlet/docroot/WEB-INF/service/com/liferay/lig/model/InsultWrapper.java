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

package com.liferay.lig.model;

/**
 * <p>
 * This class is a wrapper for {@link Insult}.
 * </p>
 *
 * @author    Rich Sezov
 * @see       Insult
 * @generated
 */
public class InsultWrapper implements Insult {
	public InsultWrapper(Insult insult) {
		_insult = insult;
	}

	public long getPrimaryKey() {
		return _insult.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_insult.setPrimaryKey(pk);
	}

	public long getInsultId() {
		return _insult.getInsultId();
	}

	public void setInsultId(long insultId) {
		_insult.setInsultId(insultId);
	}

	public java.lang.String getAdjectiveOne() {
		return _insult.getAdjectiveOne();
	}

	public void setAdjectiveOne(java.lang.String adjectiveOne) {
		_insult.setAdjectiveOne(adjectiveOne);
	}

	public java.lang.String getDirectObject() {
		return _insult.getDirectObject();
	}

	public void setDirectObject(java.lang.String directObject) {
		_insult.setDirectObject(directObject);
	}

	public java.lang.String getAdjectiveTwo() {
		return _insult.getAdjectiveTwo();
	}

	public void setAdjectiveTwo(java.lang.String adjectiveTwo) {
		_insult.setAdjectiveTwo(adjectiveTwo);
	}

	public java.lang.String getObjPreposition() {
		return _insult.getObjPreposition();
	}

	public void setObjPreposition(java.lang.String objPreposition) {
		_insult.setObjPreposition(objPreposition);
	}

	public long getCompanyId() {
		return _insult.getCompanyId();
	}

	public void setCompanyId(long companyId) {
		_insult.setCompanyId(companyId);
	}

	public long getGroupId() {
		return _insult.getGroupId();
	}

	public void setGroupId(long groupId) {
		_insult.setGroupId(groupId);
	}

	public long getUserId() {
		return _insult.getUserId();
	}

	public void setUserId(long userId) {
		_insult.setUserId(userId);
	}

	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _insult.getUserUuid();
	}

	public void setUserUuid(java.lang.String userUuid) {
		_insult.setUserUuid(userUuid);
	}

	public com.liferay.lig.model.Insult toEscapedModel() {
		return _insult.toEscapedModel();
	}

	public boolean isNew() {
		return _insult.isNew();
	}

	public void setNew(boolean n) {
		_insult.setNew(n);
	}

	public boolean isCachedModel() {
		return _insult.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_insult.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _insult.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_insult.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _insult.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _insult.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_insult.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _insult.clone();
	}

	public int compareTo(com.liferay.lig.model.Insult insult) {
		return _insult.compareTo(insult);
	}

	public int hashCode() {
		return _insult.hashCode();
	}

	public java.lang.String toString() {
		return _insult.toString();
	}

	public java.lang.String toXmlString() {
		return _insult.toXmlString();
	}

	public java.lang.String getInsultIdString() {
		return _insult.getInsultIdString();
	}

	public void setInsultIdString(java.lang.String insultIdString) {
		_insult.setInsultIdString(insultIdString);
	}

	public Insult getWrappedInsult() {
		return _insult;
	}

	private Insult _insult;
}