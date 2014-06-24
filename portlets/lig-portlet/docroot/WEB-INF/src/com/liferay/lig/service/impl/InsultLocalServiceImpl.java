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

package com.liferay.lig.service.impl;

import java.util.List;

import com.liferay.lig.model.Insult;
import com.liferay.lig.service.base.InsultLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.ResourceConstants;

/**
 * <a href="InsultLocalServiceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Rich Sezov
 */
public class InsultLocalServiceImpl extends InsultLocalServiceBaseImpl {

    /**
     * Gets all statements out of the database.
     *
     * @return List<Insult>
     * @throws SystemException
     */
    public List <Insult>getInsults (long groupId) throws SystemException {
        List <Insult>insults = insultPersistence.findByGroupId(groupId);

        return insults;

    }

    /**
     * Adds a statement to the database.
     *
     * @param newInsult
     * @param userId
     * @return Insult
     * @throws SystemException
     * @throws PortalException
     */
    public Insult addInsult (Insult newInsult, long userId) throws SystemException, PortalException {

        Insult insult = insultPersistence.create(counterLocalService.increment(Insult.class.getName()));

        resourceLocalService.addResources(
            newInsult.getCompanyId(), newInsult.getGroupId(), userId,
            Insult.class.getName(), insult.getPrimaryKey(), false, true, true);

        insult.setAdjectiveOne(newInsult.getAdjectiveOne());
        insult.setAdjectiveTwo(newInsult.getAdjectiveTwo());
        insult.setDirectObject(newInsult.getDirectObject());
        insult.setObjPreposition(newInsult.getObjPreposition());
        insult.setGroupId(newInsult.getGroupId());
        insult.setCompanyId(newInsult.getCompanyId());


        return insultPersistence.update(insult, false);

    }

    /**
     * Gets a particular statement out of the database.
     * @param insultId
     * @return Insult
     */
    public Insult getInsult (long insultId) throws SystemException {

        Insult insult = insultPersistence.fetchByPrimaryKey(insultId);

        return insult;

    }

    public Insult getInsultByObjPreposition (String objPreposition) throws SystemException {

        List<Insult> insults = insultPersistence.findByObjPreposition(objPreposition);

        Insult insult;

        if (!insults.isEmpty()) {

            insult = insults.get(0);

        } else {

            insult = null;

        }

        return insult;
    }

    /**
     * Deletes a statement out of the database.
     *
     * @param Insult
     */
    public void deleteInsult (Insult insult) throws SystemException, PortalException {

        long companyId = insult.getCompanyId();

        resourceLocalService.deleteResource(
            companyId, Insult.class.getName(),
            ResourceConstants.SCOPE_INDIVIDUAL, insult.getPrimaryKey());

        insultPersistence.remove(insult);
    }

    public void deleteInsult (long insultId) throws SystemException, PortalException {

        Insult insult = getInsult(insultId);

        deleteInsult (insult);
    }
}