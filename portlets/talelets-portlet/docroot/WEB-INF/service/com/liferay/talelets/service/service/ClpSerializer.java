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

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.BaseModel;

import com.liferay.talelets.service.model.TaleletClp;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static final String SERVLET_CONTEXT_NAME = "talelets-portlet";

	public static void setClassLoader(ClassLoader classLoader) {
		_classLoader = classLoader;
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(TaleletClp.class.getName())) {
			TaleletClp oldCplModel = (TaleletClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("com.liferay.talelets.service.model.impl.TaleletImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setUuid",
							new Class[] { String.class });

					String value0 = oldCplModel.getUuid();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setTaleId",
							new Class[] { Long.TYPE });

					Long value1 = new Long(oldCplModel.getTaleId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setTaleParentId",
							new Class[] { Long.TYPE });

					Long value2 = new Long(oldCplModel.getTaleParentId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setTaleStarterId",
							new Class[] { Long.TYPE });

					Long value3 = new Long(oldCplModel.getTaleStarterId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setTaleOrder",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getTaleOrder());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setTaleTitle",
							new Class[] { String.class });

					String value5 = oldCplModel.getTaleTitle();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setAuthorName",
							new Class[] { String.class });

					String value6 = oldCplModel.getAuthorName();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setTaleDate",
							new Class[] { Date.class });

					Date value7 = oldCplModel.getTaleDate();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setDateUpdated",
							new Class[] { Date.class });

					Date value8 = oldCplModel.getDateUpdated();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setContent",
							new Class[] { String.class });

					String value9 = oldCplModel.getContent();

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setCompanyId",
							new Class[] { Long.TYPE });

					Long value10 = new Long(oldCplModel.getCompanyId());

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setGroupId",
							new Class[] { Long.TYPE });

					Long value11 = new Long(oldCplModel.getGroupId());

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setUserId",
							new Class[] { Long.TYPE });

					Long value12 = new Long(oldCplModel.getUserId());

					method12.invoke(newModel, value12);

					Method method13 = newModelClass.getMethod("setStatus",
							new Class[] { Integer.TYPE });

					Integer value13 = new Integer(oldCplModel.getStatus());

					method13.invoke(newModel, value13);

					Method method14 = newModelClass.getMethod("setStatusByUserId",
							new Class[] { Long.TYPE });

					Long value14 = new Long(oldCplModel.getStatusByUserId());

					method14.invoke(newModel, value14);

					Method method15 = newModelClass.getMethod("setStatusByUserName",
							new Class[] { String.class });

					String value15 = oldCplModel.getStatusByUserName();

					method15.invoke(newModel, value15);

					Method method16 = newModelClass.getMethod("setStatusDate",
							new Class[] { Date.class });

					Date value16 = oldCplModel.getStatusDate();

					method16.invoke(newModel, value16);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.liferay.talelets.service.model.impl.TaleletImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					TaleletClp newModel = new TaleletClp();

					Method method0 = oldModelClass.getMethod("getUuid");

					String value0 = (String)method0.invoke(oldModel,
							(Object[])null);

					newModel.setUuid(value0);

					Method method1 = oldModelClass.getMethod("getTaleId");

					Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

					newModel.setTaleId(value1);

					Method method2 = oldModelClass.getMethod("getTaleParentId");

					Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

					newModel.setTaleParentId(value2);

					Method method3 = oldModelClass.getMethod("getTaleStarterId");

					Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

					newModel.setTaleStarterId(value3);

					Method method4 = oldModelClass.getMethod("getTaleOrder");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setTaleOrder(value4);

					Method method5 = oldModelClass.getMethod("getTaleTitle");

					String value5 = (String)method5.invoke(oldModel,
							(Object[])null);

					newModel.setTaleTitle(value5);

					Method method6 = oldModelClass.getMethod("getAuthorName");

					String value6 = (String)method6.invoke(oldModel,
							(Object[])null);

					newModel.setAuthorName(value6);

					Method method7 = oldModelClass.getMethod("getTaleDate");

					Date value7 = (Date)method7.invoke(oldModel, (Object[])null);

					newModel.setTaleDate(value7);

					Method method8 = oldModelClass.getMethod("getDateUpdated");

					Date value8 = (Date)method8.invoke(oldModel, (Object[])null);

					newModel.setDateUpdated(value8);

					Method method9 = oldModelClass.getMethod("getContent");

					String value9 = (String)method9.invoke(oldModel,
							(Object[])null);

					newModel.setContent(value9);

					Method method10 = oldModelClass.getMethod("getCompanyId");

					Long value10 = (Long)method10.invoke(oldModel,
							(Object[])null);

					newModel.setCompanyId(value10);

					Method method11 = oldModelClass.getMethod("getGroupId");

					Long value11 = (Long)method11.invoke(oldModel,
							(Object[])null);

					newModel.setGroupId(value11);

					Method method12 = oldModelClass.getMethod("getUserId");

					Long value12 = (Long)method12.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value12);

					Method method13 = oldModelClass.getMethod("getStatus");

					Integer value13 = (Integer)method13.invoke(oldModel,
							(Object[])null);

					newModel.setStatus(value13);

					Method method14 = oldModelClass.getMethod(
							"getStatusByUserId");

					Long value14 = (Long)method14.invoke(oldModel,
							(Object[])null);

					newModel.setStatusByUserId(value14);

					Method method15 = oldModelClass.getMethod(
							"getStatusByUserName");

					String value15 = (String)method15.invoke(oldModel,
							(Object[])null);

					newModel.setStatusByUserName(value15);

					Method method16 = oldModelClass.getMethod("getStatusDate");

					Date value16 = (Date)method16.invoke(oldModel,
							(Object[])null);

					newModel.setStatusDate(value16);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static ClassLoader _classLoader;
}