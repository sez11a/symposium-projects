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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * This class is used by
 * {@link com.liferay.talelets.service.service.http.TaleletServiceSoap}.
 * </p>
 *
 * @author    Rich Sezov
 * @see       com.liferay.talelets.service.service.http.TaleletServiceSoap
 * @generated
 */
public class TaleletSoap implements Serializable {
	public static TaleletSoap toSoapModel(Talelet model) {
		TaleletSoap soapModel = new TaleletSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setTaleId(model.getTaleId());
		soapModel.setTaleParentId(model.getTaleParentId());
		soapModel.setTaleStarterId(model.getTaleStarterId());
		soapModel.setTaleOrder(model.getTaleOrder());
		soapModel.setTaleTitle(model.getTaleTitle());
		soapModel.setAuthorName(model.getAuthorName());
		soapModel.setTaleDate(model.getTaleDate());
		soapModel.setDateUpdated(model.getDateUpdated());
		soapModel.setContent(model.getContent());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());

		return soapModel;
	}

	public static TaleletSoap[] toSoapModels(Talelet[] models) {
		TaleletSoap[] soapModels = new TaleletSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TaleletSoap[][] toSoapModels(Talelet[][] models) {
		TaleletSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TaleletSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TaleletSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TaleletSoap[] toSoapModels(List<Talelet> models) {
		List<TaleletSoap> soapModels = new ArrayList<TaleletSoap>(models.size());

		for (Talelet model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TaleletSoap[soapModels.size()]);
	}

	public TaleletSoap() {
	}

	public long getPrimaryKey() {
		return _taleId;
	}

	public void setPrimaryKey(long pk) {
		setTaleId(pk);
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
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
}