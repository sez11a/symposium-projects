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

import com.liferay.lig.model.InsultClp;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.BaseModel;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static final String SERVLET_CONTEXT_NAME = "lig-portlet";

	public static void setClassLoader(ClassLoader classLoader) {
		_classLoader = classLoader;
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(InsultClp.class.getName())) {
			InsultClp oldCplModel = (InsultClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("com.liferay.lig.model.impl.InsultImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setInsultId",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getInsultId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setAdjectiveOne",
							new Class[] { String.class });

					String value1 = oldCplModel.getAdjectiveOne();

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setDirectObject",
							new Class[] { String.class });

					String value2 = oldCplModel.getDirectObject();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setAdjectiveTwo",
							new Class[] { String.class });

					String value3 = oldCplModel.getAdjectiveTwo();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setObjPreposition",
							new Class[] { String.class });

					String value4 = oldCplModel.getObjPreposition();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setCompanyId",
							new Class[] { Long.TYPE });

					Long value5 = new Long(oldCplModel.getCompanyId());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setGroupId",
							new Class[] { Long.TYPE });

					Long value6 = new Long(oldCplModel.getGroupId());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setUserId",
							new Class[] { Long.TYPE });

					Long value7 = new Long(oldCplModel.getUserId());

					method7.invoke(newModel, value7);

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

		if (oldModelClassName.equals("com.liferay.lig.model.impl.InsultImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					InsultClp newModel = new InsultClp();

					Method method0 = oldModelClass.getMethod("getInsultId");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setInsultId(value0);

					Method method1 = oldModelClass.getMethod("getAdjectiveOne");

					String value1 = (String)method1.invoke(oldModel,
							(Object[])null);

					newModel.setAdjectiveOne(value1);

					Method method2 = oldModelClass.getMethod("getDirectObject");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setDirectObject(value2);

					Method method3 = oldModelClass.getMethod("getAdjectiveTwo");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setAdjectiveTwo(value3);

					Method method4 = oldModelClass.getMethod(
							"getObjPreposition");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setObjPreposition(value4);

					Method method5 = oldModelClass.getMethod("getCompanyId");

					Long value5 = (Long)method5.invoke(oldModel, (Object[])null);

					newModel.setCompanyId(value5);

					Method method6 = oldModelClass.getMethod("getGroupId");

					Long value6 = (Long)method6.invoke(oldModel, (Object[])null);

					newModel.setGroupId(value6);

					Method method7 = oldModelClass.getMethod("getUserId");

					Long value7 = (Long)method7.invoke(oldModel, (Object[])null);

					newModel.setUserId(value7);

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