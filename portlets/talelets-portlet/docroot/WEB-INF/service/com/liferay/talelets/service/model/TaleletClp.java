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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author Rich Sezov
 */
public class TaleletClp extends BaseModelImpl<Talelet> implements Talelet {
	public TaleletClp() {
	}

	public long getPrimaryKey() {
		return _taleId;
	}

	public void setPrimaryKey(long pk) {
		setTaleId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_taleId);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getTaleId() {
		return _taleId;
	}

	public void setTaleId(long taleId) {
		_taleId = taleId;
	}

	public long getTaleParentId() {
		return _taleParentId;
	}

	public void setTaleParentId(long taleParentId) {
		_taleParentId = taleParentId;
	}

	public long getTaleStarterId() {
		return _taleStarterId;
	}

	public void setTaleStarterId(long taleStarterId) {
		_taleStarterId = taleStarterId;
	}

	public int getTaleOrder() {
		return _taleOrder;
	}

	public void setTaleOrder(int taleOrder) {
		_taleOrder = taleOrder;
	}

	public String getTaleTitle() {
		return _taleTitle;
	}

	public void setTaleTitle(String taleTitle) {
		_taleTitle = taleTitle;
	}

	public String getAuthorName() {
		return _authorName;
	}

	public void setAuthorName(String authorName) {
		_authorName = authorName;
	}

	public Date getTaleDate() {
		return _taleDate;
	}

	public void setTaleDate(Date taleDate) {
		_taleDate = taleDate;
	}

	public Date getDateUpdated() {
		return _dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		_dateUpdated = dateUpdated;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
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

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getStatusByUserId(), "uuid",
			_statusByUserUuid);
	}

	public void setStatusByUserUuid(String statusByUserUuid) {
		_statusByUserUuid = statusByUserUuid;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	/**
	 * @deprecated {@link #isApproved}
	 */
	public boolean getApproved() {
		return isApproved();
	}

	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isDraft() {
		if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	public Talelet toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (Talelet)Proxy.newProxyInstance(Talelet.class.getClassLoader(),
				new Class[] { Talelet.class }, new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		TaleletClp clone = new TaleletClp();

		clone.setUuid(getUuid());
		clone.setTaleId(getTaleId());
		clone.setTaleParentId(getTaleParentId());
		clone.setTaleStarterId(getTaleStarterId());
		clone.setTaleOrder(getTaleOrder());
		clone.setTaleTitle(getTaleTitle());
		clone.setAuthorName(getAuthorName());
		clone.setTaleDate(getTaleDate());
		clone.setDateUpdated(getDateUpdated());
		clone.setContent(getContent());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setStatus(getStatus());
		clone.setStatusByUserId(getStatusByUserId());
		clone.setStatusByUserName(getStatusByUserName());
		clone.setStatusDate(getStatusDate());

		return clone;
	}

	public int compareTo(Talelet talelet) {
		int value = 0;

		if (getTaleOrder() < talelet.getTaleOrder()) {
			value = -1;
		}
		else if (getTaleOrder() > talelet.getTaleOrder()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		TaleletClp talelet = null;

		try {
			talelet = (TaleletClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = talelet.getPrimaryKey();

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
		StringBundler sb = new StringBundler(35);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", taleId=");
		sb.append(getTaleId());
		sb.append(", taleParentId=");
		sb.append(getTaleParentId());
		sb.append(", taleStarterId=");
		sb.append(getTaleStarterId());
		sb.append(", taleOrder=");
		sb.append(getTaleOrder());
		sb.append(", taleTitle=");
		sb.append(getTaleTitle());
		sb.append(", authorName=");
		sb.append(getAuthorName());
		sb.append(", taleDate=");
		sb.append(getTaleDate());
		sb.append(", dateUpdated=");
		sb.append(getDateUpdated());
		sb.append(", content=");
		sb.append(getContent());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", statusByUserId=");
		sb.append(getStatusByUserId());
		sb.append(", statusByUserName=");
		sb.append(getStatusByUserName());
		sb.append(", statusDate=");
		sb.append(getStatusDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append("com.liferay.talelets.service.model.Talelet");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taleId</column-name><column-value><![CDATA[");
		sb.append(getTaleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taleParentId</column-name><column-value><![CDATA[");
		sb.append(getTaleParentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taleStarterId</column-name><column-value><![CDATA[");
		sb.append(getTaleStarterId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taleOrder</column-name><column-value><![CDATA[");
		sb.append(getTaleOrder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taleTitle</column-name><column-value><![CDATA[");
		sb.append(getTaleTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>authorName</column-name><column-value><![CDATA[");
		sb.append(getAuthorName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taleDate</column-name><column-value><![CDATA[");
		sb.append(getTaleDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateUpdated</column-name><column-value><![CDATA[");
		sb.append(getDateUpdated());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
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
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserId</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserName</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusDate</column-name><column-value><![CDATA[");
		sb.append(getStatusDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _taleId;
	private long _taleParentId;
	private long _taleStarterId;
	private int _taleOrder;
	private String _taleTitle;
	private String _authorName;
	private Date _taleDate;
	private Date _dateUpdated;
	private String _content;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserUuid;
	private String _statusByUserName;
	private Date _statusDate;
}