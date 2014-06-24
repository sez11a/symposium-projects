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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * This class is used by
 * {@link com.liferay.lig.service.http.InsultServiceSoap}.
 * </p>
 *
 * @author    Rich Sezov
 * @see       com.liferay.lig.service.http.InsultServiceSoap
 * @generated
 */
public class InsultSoap implements Serializable {
	public static InsultSoap toSoapModel(Insult model) {
		InsultSoap soapModel = new InsultSoap();

		soapModel.setInsultId(model.getInsultId());
		soapModel.setAdjectiveOne(model.getAdjectiveOne());
		soapModel.setDirectObject(model.getDirectObject());
		soapModel.setAdjectiveTwo(model.getAdjectiveTwo());
		soapModel.setObjPreposition(model.getObjPreposition());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());

		return soapModel;
	}

	public static InsultSoap[] toSoapModels(Insult[] models) {
		InsultSoap[] soapModels = new InsultSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static InsultSoap[][] toSoapModels(Insult[][] models) {
		InsultSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new InsultSoap[models.length][models[0].length];
		}
		else {
			soapModels = new InsultSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static InsultSoap[] toSoapModels(List<Insult> models) {
		List<InsultSoap> soapModels = new ArrayList<InsultSoap>(models.size());

		for (Insult model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new InsultSoap[soapModels.size()]);
	}

	public InsultSoap() {
	}

	public long getPrimaryKey() {
		return _insultId;
	}

	public void setPrimaryKey(long pk) {
		setInsultId(pk);
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

	private long _insultId;
	private String _adjectiveOne;
	private String _directObject;
	private String _adjectiveTwo;
	private String _objPreposition;
	private long _companyId;
	private long _groupId;
	private long _userId;
}