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
 * The model interface for the Insult service. Represents a row in the &quot;insults_Insult&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Never modify this interface directly. Add methods to {@link com.liferay.lig.model.impl.InsultImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * <p>
 * Never reference this interface directly. All methods that expect a insult model instance should use the {@link Insult} interface instead.
 * </p>
 *
 * @author Rich Sezov
 * @see InsultModel
 * @see com.liferay.lig.model.impl.InsultImpl
 * @see com.liferay.lig.model.impl.InsultModelImpl
 * @generated
 */
public interface Insult extends InsultModel {
	public java.lang.String getInsultIdString();

	public void setInsultIdString(java.lang.String insultIdString);
}