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

package com.liferay.lig.service.http;

import com.liferay.lig.model.Insult;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.List;

/**
 * @author    Rich Sezov
 * @generated
 */
public class InsultJSONSerializer {
	public static JSONObject toJSONObject(Insult model) {
		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

		jsonObj.put("insultId", model.getInsultId());
		jsonObj.put("adjectiveOne", model.getAdjectiveOne());
		jsonObj.put("directObject", model.getDirectObject());
		jsonObj.put("adjectiveTwo", model.getAdjectiveTwo());
		jsonObj.put("objPreposition", model.getObjPreposition());
		jsonObj.put("companyId", model.getCompanyId());
		jsonObj.put("groupId", model.getGroupId());
		jsonObj.put("userId", model.getUserId());

		return jsonObj;
	}

	public static JSONArray toJSONArray(com.liferay.lig.model.Insult[] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (Insult model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(com.liferay.lig.model.Insult[][] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (Insult[] model : models) {
			jsonArray.put(toJSONArray(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		List<com.liferay.lig.model.Insult> models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (Insult model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}
}