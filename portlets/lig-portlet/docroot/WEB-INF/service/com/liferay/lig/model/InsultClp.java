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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author Rich Sezov
 */
public class InsultClp extends BaseModelImpl<Insult> implements Insult {
	public InsultClp() {
	}

	public long getPrimaryKey() {
		return _insultId;
	}

	public void setPrimaryKey(long pk) {
		setInsultId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_insultId);
	}

	public long getInsultId() {
		return _insultId;
	}

	public void setInsultId(long insultId) {
		_insultId = insultId;
	}

	public String getAdjectiveOne() {
		return _adjectiveOne;
	}

	public void setAdjectiveOne(String adjectiveOne) {
		_adjectiveOne = adjectiveOne;
	}

	public String getDirectObject() {
		return _directObject;
	}

	public void setDirectObject(String directObject) {
		_directObject = directObject;
	}

	public String getAdjectiveTwo() {
		return _adjectiveTwo;
	}

	public void setAdjectiveTwo(String adjectiveTwo) {
		_adjectiveTwo = adjectiveTwo;
	}

	public String getObjPreposition() {
		return _objPreposition;
	}

	public void setObjPreposition(String objPreposition) {
		_objPreposition = objPreposition;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public java.lang.String getInsultIdString() {
		throw new UnsupportedOperationException();
	}

	public void setInsultIdString(java.lang.String insultIdString) {
		throw new UnsupportedOperationException();
	}

	public Insult toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (Insult)Proxy.newProxyInstance(Insult.class.getClassLoader(),
				new Class[] { Insult.class }, new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		InsultClp clone = new InsultClp();

		clone.setInsultId(getInsultId());
		clone.setAdjectiveOne(getAdjectiveOne());
		clone.setDirectObject(getDirectObject());
		clone.setAdjectiveTwo(getAdjectiveTwo());
		clone.setObjPreposition(getObjPreposition());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());

		return clone;
	}

	public int compareTo(Insult insult) {
		long pk = insult.getPrimaryKey();

		if (getPrimaryKey() < pk) {
			return -1;
		}
		else if (getPrimaryKey() > pk) {
			return 1;
		}
		else {
			return 0;
		}
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		InsultClp insult = null;

		try {
			insult = (InsultClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = insult.getPrimaryKey();

		if (getPrimaryKey() == pk) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return (int)getPrimaryKey();
	}

	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{insultId=");
		sb.append(getInsultId());
		sb.append(", adjectiveOne=");
		sb.append(getAdjectiveOne());
		sb.append(", directObject=");
		sb.append(getDirectObject());
		sb.append(", adjectiveTwo=");
		sb.append(getAdjectiveTwo());
		sb.append(", objPreposition=");
		sb.append(getObjPreposition());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.liferay.lig.model.Insult");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>insultId</column-name><column-value><![CDATA[");
		sb.append(getInsultId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>adjectiveOne</column-name><column-value><![CDATA[");
		sb.append(getAdjectiveOne());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>directObject</column-name><column-value><![CDATA[");
		sb.append(getDirectObject());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>adjectiveTwo</column-name><column-value><![CDATA[");
		sb.append(getAdjectiveTwo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>objPreposition</column-name><column-value><![CDATA[");
		sb.append(getObjPreposition());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _insultId;
	private String _adjectiveOne;
	private String _directObject;
	private String _adjectiveTwo;
	private String _objPreposition;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
}