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

package com.liferay.talelets.service.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.portlet.asset.service.persistence.AssetEntryPersistence;

import com.liferay.talelets.service.NoSuchTaleletException;
import com.liferay.talelets.service.model.Talelet;
import com.liferay.talelets.service.model.impl.TaleletImpl;
import com.liferay.talelets.service.model.impl.TaleletModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the talelet service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Rich Sezov
 * @see TaleletPersistence
 * @see TaleletUtil
 * @generated
 */
public class TaleletPersistenceImpl extends BasePersistenceImpl<Talelet>
	implements TaleletPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TaleletUtil} to access the talelet persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TaleletImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_UUID = new FinderPath(TaleletModelImpl.ENTITY_CACHE_ENABLED,
			TaleletModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(TaleletModelImpl.ENTITY_CACHE_ENABLED,
			TaleletModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByUuid", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(TaleletModelImpl.ENTITY_CACHE_ENABLED,
			TaleletModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(TaleletModelImpl.ENTITY_CACHE_ENABLED,
			TaleletModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_GROUPID = new FinderPath(TaleletModelImpl.ENTITY_CACHE_ENABLED,
			TaleletModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(TaleletModelImpl.ENTITY_CACHE_ENABLED,
			TaleletModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByGroupId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_G_O = new FinderPath(TaleletModelImpl.ENTITY_CACHE_ENABLED,
			TaleletModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByG_O",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_G_O = new FinderPath(TaleletModelImpl.ENTITY_CACHE_ENABLED,
			TaleletModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByG_O",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_FIND_BY_TALE = new FinderPath(TaleletModelImpl.ENTITY_CACHE_ENABLED,
			TaleletModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByTale",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_TALE = new FinderPath(TaleletModelImpl.ENTITY_CACHE_ENABLED,
			TaleletModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByTale",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_FIND_BY_TALESTARTER = new FinderPath(TaleletModelImpl.ENTITY_CACHE_ENABLED,
			TaleletModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByTaleStarter",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_TALESTARTER = new FinderPath(TaleletModelImpl.ENTITY_CACHE_ENABLED,
			TaleletModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByTaleStarter", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_COMPANYID = new FinderPath(TaleletModelImpl.ENTITY_CACHE_ENABLED,
			TaleletModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(TaleletModelImpl.ENTITY_CACHE_ENABLED,
			TaleletModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByCompanyId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_U_G = new FinderPath(TaleletModelImpl.ENTITY_CACHE_ENABLED,
			TaleletModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByU_G",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_U_G = new FinderPath(TaleletModelImpl.ENTITY_CACHE_ENABLED,
			TaleletModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByU_G",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_G_S = new FinderPath(TaleletModelImpl.ENTITY_CACHE_ENABLED,
			TaleletModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByG_S",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_G_S = new FinderPath(TaleletModelImpl.ENTITY_CACHE_ENABLED,
			TaleletModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByG_S",
			new String[] { Long.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(TaleletModelImpl.ENTITY_CACHE_ENABLED,
			TaleletModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TaleletModelImpl.ENTITY_CACHE_ENABLED,
			TaleletModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the talelet in the entity cache if it is enabled.
	 *
	 * @param talelet the talelet to cache
	 */
	public void cacheResult(Talelet talelet) {
		EntityCacheUtil.putResult(TaleletModelImpl.ENTITY_CACHE_ENABLED,
			TaleletImpl.class, talelet.getPrimaryKey(), talelet);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { talelet.getUuid(), new Long(talelet.getGroupId()) },
			talelet);
	}

	/**
	 * Caches the talelets in the entity cache if it is enabled.
	 *
	 * @param talelets the talelets to cache
	 */
	public void cacheResult(List<Talelet> talelets) {
		for (Talelet talelet : talelets) {
			if (EntityCacheUtil.getResult(
						TaleletModelImpl.ENTITY_CACHE_ENABLED,
						TaleletImpl.class, talelet.getPrimaryKey(), this) == null) {
				cacheResult(talelet);
			}
		}
	}

	/**
	 * Clears the cache for all talelets.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(TaleletImpl.class.getName());
		EntityCacheUtil.clearCache(TaleletImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the talelet.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(Talelet talelet) {
		EntityCacheUtil.removeResult(TaleletModelImpl.ENTITY_CACHE_ENABLED,
			TaleletImpl.class, talelet.getPrimaryKey());

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { talelet.getUuid(), new Long(talelet.getGroupId()) });
	}

	/**
	 * Creates a new talelet with the primary key. Does not add the talelet to the database.
	 *
	 * @param taleId the primary key for the new talelet
	 * @return the new talelet
	 */
	public Talelet create(long taleId) {
		Talelet talelet = new TaleletImpl();

		talelet.setNew(true);
		talelet.setPrimaryKey(taleId);

		String uuid = PortalUUIDUtil.generate();

		talelet.setUuid(uuid);

		return talelet;
	}

	/**
	 * Removes the talelet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the talelet to remove
	 * @return the talelet that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a talelet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Talelet remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the talelet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taleId the primary key of the talelet to remove
	 * @return the talelet that was removed
	 * @throws com.liferay.talelets.service.NoSuchTaleletException if a talelet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Talelet remove(long taleId)
		throws NoSuchTaleletException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Talelet talelet = (Talelet)session.get(TaleletImpl.class,
					new Long(taleId));

			if (talelet == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + taleId);
				}

				throw new NoSuchTaleletException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					taleId);
			}

			return remove(talelet);
		}
		catch (NoSuchTaleletException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Talelet removeImpl(Talelet talelet) throws SystemException {
		talelet = toUnwrappedModel(talelet);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, talelet);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		TaleletModelImpl taleletModelImpl = (TaleletModelImpl)talelet;

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				taleletModelImpl.getOriginalUuid(),
				new Long(taleletModelImpl.getOriginalGroupId())
			});

		EntityCacheUtil.removeResult(TaleletModelImpl.ENTITY_CACHE_ENABLED,
			TaleletImpl.class, talelet.getPrimaryKey());

		return talelet;
	}

	public Talelet updateImpl(
		com.liferay.talelets.service.model.Talelet talelet, boolean merge)
		throws SystemException {
		talelet = toUnwrappedModel(talelet);

		boolean isNew = talelet.isNew();

		TaleletModelImpl taleletModelImpl = (TaleletModelImpl)talelet;

		if (Validator.isNull(talelet.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			talelet.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, talelet, merge);

			talelet.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(TaleletModelImpl.ENTITY_CACHE_ENABLED,
			TaleletImpl.class, talelet.getPrimaryKey(), talelet);

		if (!isNew &&
				(!Validator.equals(talelet.getUuid(),
					taleletModelImpl.getOriginalUuid()) ||
				(talelet.getGroupId() != taleletModelImpl.getOriginalGroupId()))) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
				new Object[] {
					taleletModelImpl.getOriginalUuid(),
					new Long(taleletModelImpl.getOriginalGroupId())
				});
		}

		if (isNew ||
				(!Validator.equals(talelet.getUuid(),
					taleletModelImpl.getOriginalUuid()) ||
				(talelet.getGroupId() != taleletModelImpl.getOriginalGroupId()))) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
				new Object[] { talelet.getUuid(), new Long(talelet.getGroupId()) },
				talelet);
		}

		return talelet;
	}

	protected Talelet toUnwrappedModel(Talelet talelet) {
		if (talelet instanceof TaleletImpl) {
			return talelet;
		}

		TaleletImpl taleletImpl = new TaleletImpl();

		taleletImpl.setNew(talelet.isNew());
		taleletImpl.setPrimaryKey(talelet.getPrimaryKey());

		taleletImpl.setUuid(talelet.getUuid());
		taleletImpl.setTaleId(talelet.getTaleId());
		taleletImpl.setTaleParentId(talelet.getTaleParentId());
		taleletImpl.setTaleStarterId(talelet.getTaleStarterId());
		taleletImpl.setTaleOrder(talelet.getTaleOrder());
		taleletImpl.setTaleTitle(talelet.getTaleTitle());
		taleletImpl.setAuthorName(talelet.getAuthorName());
		taleletImpl.setTaleDate(talelet.getTaleDate());
		taleletImpl.setDateUpdated(talelet.getDateUpdated());
		taleletImpl.setContent(talelet.getContent());
		taleletImpl.setCompanyId(talelet.getCompanyId());
		taleletImpl.setGroupId(talelet.getGroupId());
		taleletImpl.setUserId(talelet.getUserId());
		taleletImpl.setStatus(talelet.getStatus());
		taleletImpl.setStatusByUserId(talelet.getStatusByUserId());
		taleletImpl.setStatusByUserName(talelet.getStatusByUserName());
		taleletImpl.setStatusDate(talelet.getStatusDate());

		return taleletImpl;
	}

	/**
	 * Finds the talelet with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the talelet to find
	 * @return the talelet
	 * @throws com.liferay.portal.NoSuchModelException if a talelet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Talelet findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the talelet with the primary key or throws a {@link com.liferay.talelets.service.NoSuchTaleletException} if it could not be found.
	 *
	 * @param taleId the primary key of the talelet to find
	 * @return the talelet
	 * @throws com.liferay.talelets.service.NoSuchTaleletException if a talelet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Talelet findByPrimaryKey(long taleId)
		throws NoSuchTaleletException, SystemException {
		Talelet talelet = fetchByPrimaryKey(taleId);

		if (talelet == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + taleId);
			}

			throw new NoSuchTaleletException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				taleId);
		}

		return talelet;
	}

	/**
	 * Finds the talelet with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the talelet to find
	 * @return the talelet, or <code>null</code> if a talelet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Talelet fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the talelet with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taleId the primary key of the talelet to find
	 * @return the talelet, or <code>null</code> if a talelet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Talelet fetchByPrimaryKey(long taleId) throws SystemException {
		Talelet talelet = (Talelet)EntityCacheUtil.getResult(TaleletModelImpl.ENTITY_CACHE_ENABLED,
				TaleletImpl.class, taleId, this);

		if (talelet == null) {
			Session session = null;

			try {
				session = openSession();

				talelet = (Talelet)session.get(TaleletImpl.class,
						new Long(taleId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (talelet != null) {
					cacheResult(talelet);
				}

				closeSession(session);
			}
		}

		return talelet;
	}

	/**
	 * Finds all the talelets where uuid = &#63;.
	 *
	 * @param uuid the uuid to search with
	 * @return the matching talelets
	 * @throws SystemException if a system exception occurred
	 */
	public List<Talelet> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the talelets where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid to search with
	 * @param start the lower bound of the range of talelets to return
	 * @param end the upper bound of the range of talelets to return (not inclusive)
	 * @return the range of matching talelets
	 * @throws SystemException if a system exception occurred
	 */
	public List<Talelet> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Finds an ordered range of all the talelets where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid to search with
	 * @param start the lower bound of the range of talelets to return
	 * @param end the upper bound of the range of talelets to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching talelets
	 * @throws SystemException if a system exception occurred
	 */
	public List<Talelet> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				uuid,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Talelet> list = (List<Talelet>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_UUID,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TALELET_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_UUID_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TaleletModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				list = (List<Talelet>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_UUID,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_UUID,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first talelet in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching talelet
	 * @throws com.liferay.talelets.service.NoSuchTaleletException if a matching talelet could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Talelet findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchTaleletException, SystemException {
		List<Talelet> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTaleletException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last talelet in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching talelet
	 * @throws com.liferay.talelets.service.NoSuchTaleletException if a matching talelet could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Talelet findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchTaleletException, SystemException {
		int count = countByUuid(uuid);

		List<Talelet> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTaleletException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the talelets before and after the current talelet in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param taleId the primary key of the current talelet
	 * @param uuid the uuid to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next talelet
	 * @throws com.liferay.talelets.service.NoSuchTaleletException if a talelet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Talelet[] findByUuid_PrevAndNext(long taleId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchTaleletException, SystemException {
		Talelet talelet = findByPrimaryKey(taleId);

		Session session = null;

		try {
			session = openSession();

			Talelet[] array = new TaleletImpl[3];

			array[0] = getByUuid_PrevAndNext(session, talelet, uuid,
					orderByComparator, true);

			array[1] = talelet;

			array[2] = getByUuid_PrevAndNext(session, talelet, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Talelet getByUuid_PrevAndNext(Session session, Talelet talelet,
		String uuid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TALELET_WHERE);

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else {
			if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(TaleletModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (uuid != null) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(talelet);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Talelet> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds the talelet where uuid = &#63; and groupId = &#63; or throws a {@link com.liferay.talelets.service.NoSuchTaleletException} if it could not be found.
	 *
	 * @param uuid the uuid to search with
	 * @param groupId the group id to search with
	 * @return the matching talelet
	 * @throws com.liferay.talelets.service.NoSuchTaleletException if a matching talelet could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Talelet findByUUID_G(String uuid, long groupId)
		throws NoSuchTaleletException, SystemException {
		Talelet talelet = fetchByUUID_G(uuid, groupId);

		if (talelet == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchTaleletException(msg.toString());
		}

		return talelet;
	}

	/**
	 * Finds the talelet where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid to search with
	 * @param groupId the group id to search with
	 * @return the matching talelet, or <code>null</code> if a matching talelet could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Talelet fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Finds the talelet where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid to search with
	 * @param groupId the group id to search with
	 * @return the matching talelet, or <code>null</code> if a matching talelet could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Talelet fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_TALELET_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_G_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_G_UUID_2);
				}
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			query.append(TaleletModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<Talelet> list = q.list();

				result = list;

				Talelet talelet = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					talelet = list.get(0);

					cacheResult(talelet);

					if ((talelet.getUuid() == null) ||
							!talelet.getUuid().equals(uuid) ||
							(talelet.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, talelet);
					}
				}

				return talelet;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (Talelet)result;
			}
		}
	}

	/**
	 * Finds all the talelets where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the matching talelets
	 * @throws SystemException if a system exception occurred
	 */
	public List<Talelet> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the talelets where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of talelets to return
	 * @param end the upper bound of the range of talelets to return (not inclusive)
	 * @return the range of matching talelets
	 * @throws SystemException if a system exception occurred
	 */
	public List<Talelet> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the talelets where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of talelets to return
	 * @param end the upper bound of the range of talelets to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching talelets
	 * @throws SystemException if a system exception occurred
	 */
	public List<Talelet> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Talelet> list = (List<Talelet>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_GROUPID,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TALELET_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TaleletModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<Talelet>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_GROUPID,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_GROUPID,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first talelet in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching talelet
	 * @throws com.liferay.talelets.service.NoSuchTaleletException if a matching talelet could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Talelet findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTaleletException, SystemException {
		List<Talelet> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTaleletException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last talelet in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching talelet
	 * @throws com.liferay.talelets.service.NoSuchTaleletException if a matching talelet could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Talelet findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTaleletException, SystemException {
		int count = countByGroupId(groupId);

		List<Talelet> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTaleletException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the talelets before and after the current talelet in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param taleId the primary key of the current talelet
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next talelet
	 * @throws com.liferay.talelets.service.NoSuchTaleletException if a talelet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Talelet[] findByGroupId_PrevAndNext(long taleId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTaleletException, SystemException {
		Talelet talelet = findByPrimaryKey(taleId);

		Session session = null;

		try {
			session = openSession();

			Talelet[] array = new TaleletImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, talelet, groupId,
					orderByComparator, true);

			array[1] = talelet;

			array[2] = getByGroupId_PrevAndNext(session, talelet, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Talelet getByGroupId_PrevAndNext(Session session,
		Talelet talelet, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TALELET_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(TaleletModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(talelet);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Talelet> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Filters by the user's permissions and finds all the talelets where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the matching talelets that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Talelet> filterFindByGroupId(long groupId)
		throws SystemException {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Filters by the user's permissions and finds a range of all the talelets where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of talelets to return
	 * @param end the upper bound of the range of talelets to return (not inclusive)
	 * @return the range of matching talelets that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Talelet> filterFindByGroupId(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Filters by the user's permissions and finds an ordered range of all the talelets where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of talelets to return
	 * @param end the upper bound of the range of talelets to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching talelets that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Talelet> filterFindByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId(groupId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(3 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TALELET_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TALELET_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TALELET_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator);
			}
		}

		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(TaleletModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TaleletModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Talelet.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, TaleletImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, TaleletImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<Talelet>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Finds all the talelets where groupId = &#63; and taleOrder = &#63; and status = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param taleOrder the tale order to search with
	 * @param status the status to search with
	 * @return the matching talelets
	 * @throws SystemException if a system exception occurred
	 */
	public List<Talelet> findByG_O(long groupId, int taleOrder, int status)
		throws SystemException {
		return findByG_O(groupId, taleOrder, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the talelets where groupId = &#63; and taleOrder = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param taleOrder the tale order to search with
	 * @param status the status to search with
	 * @param start the lower bound of the range of talelets to return
	 * @param end the upper bound of the range of talelets to return (not inclusive)
	 * @return the range of matching talelets
	 * @throws SystemException if a system exception occurred
	 */
	public List<Talelet> findByG_O(long groupId, int taleOrder, int status,
		int start, int end) throws SystemException {
		return findByG_O(groupId, taleOrder, status, start, end, null);
	}

	/**
	 * Finds an ordered range of all the talelets where groupId = &#63; and taleOrder = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param taleOrder the tale order to search with
	 * @param status the status to search with
	 * @param start the lower bound of the range of talelets to return
	 * @param end the upper bound of the range of talelets to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching talelets
	 * @throws SystemException if a system exception occurred
	 */
	public List<Talelet> findByG_O(long groupId, int taleOrder, int status,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId, taleOrder, status,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Talelet> list = (List<Talelet>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_G_O,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_TALELET_WHERE);

			query.append(_FINDER_COLUMN_G_O_GROUPID_2);

			query.append(_FINDER_COLUMN_G_O_TALEORDER_2);

			query.append(_FINDER_COLUMN_G_O_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TaleletModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(taleOrder);

				qPos.add(status);

				list = (List<Talelet>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_G_O,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_G_O,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first talelet in the ordered set where groupId = &#63; and taleOrder = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param taleOrder the tale order to search with
	 * @param status the status to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching talelet
	 * @throws com.liferay.talelets.service.NoSuchTaleletException if a matching talelet could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Talelet findByG_O_First(long groupId, int taleOrder, int status,
		OrderByComparator orderByComparator)
		throws NoSuchTaleletException, SystemException {
		List<Talelet> list = findByG_O(groupId, taleOrder, status, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", taleOrder=");
			msg.append(taleOrder);

			msg.append(", status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTaleletException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last talelet in the ordered set where groupId = &#63; and taleOrder = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param taleOrder the tale order to search with
	 * @param status the status to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching talelet
	 * @throws com.liferay.talelets.service.NoSuchTaleletException if a matching talelet could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Talelet findByG_O_Last(long groupId, int taleOrder, int status,
		OrderByComparator orderByComparator)
		throws NoSuchTaleletException, SystemException {
		int count = countByG_O(groupId, taleOrder, status);

		List<Talelet> list = findByG_O(groupId, taleOrder, status, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", taleOrder=");
			msg.append(taleOrder);

			msg.append(", status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTaleletException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the talelets before and after the current talelet in the ordered set where groupId = &#63; and taleOrder = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param taleId the primary key of the current talelet
	 * @param groupId the group id to search with
	 * @param taleOrder the tale order to search with
	 * @param status the status to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next talelet
	 * @throws com.liferay.talelets.service.NoSuchTaleletException if a talelet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Talelet[] findByG_O_PrevAndNext(long taleId, long groupId,
		int taleOrder, int status, OrderByComparator orderByComparator)
		throws NoSuchTaleletException, SystemException {
		Talelet talelet = findByPrimaryKey(taleId);

		Session session = null;

		try {
			session = openSession();

			Talelet[] array = new TaleletImpl[3];

			array[0] = getByG_O_PrevAndNext(session, talelet, groupId,
					taleOrder, status, orderByComparator, true);

			array[1] = talelet;

			array[2] = getByG_O_PrevAndNext(session, talelet, groupId,
					taleOrder, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Talelet getByG_O_PrevAndNext(Session session, Talelet talelet,
		long groupId, int taleOrder, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TALELET_WHERE);

		query.append(_FINDER_COLUMN_G_O_GROUPID_2);

		query.append(_FINDER_COLUMN_G_O_TALEORDER_2);

		query.append(_FINDER_COLUMN_G_O_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(TaleletModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(taleOrder);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(talelet);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Talelet> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Filters by the user's permissions and finds all the talelets where groupId = &#63; and taleOrder = &#63; and status = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param taleOrder the tale order to search with
	 * @param status the status to search with
	 * @return the matching talelets that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Talelet> filterFindByG_O(long groupId, int taleOrder, int status)
		throws SystemException {
		return filterFindByG_O(groupId, taleOrder, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Filters by the user's permissions and finds a range of all the talelets where groupId = &#63; and taleOrder = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param taleOrder the tale order to search with
	 * @param status the status to search with
	 * @param start the lower bound of the range of talelets to return
	 * @param end the upper bound of the range of talelets to return (not inclusive)
	 * @return the range of matching talelets that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Talelet> filterFindByG_O(long groupId, int taleOrder,
		int status, int start, int end) throws SystemException {
		return filterFindByG_O(groupId, taleOrder, status, start, end, null);
	}

	/**
	 * Filters by the user's permissions and finds an ordered range of all the talelets where groupId = &#63; and taleOrder = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param taleOrder the tale order to search with
	 * @param status the status to search with
	 * @param start the lower bound of the range of talelets to return
	 * @param end the upper bound of the range of talelets to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching talelets that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Talelet> filterFindByG_O(long groupId, int taleOrder,
		int status, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_O(groupId, taleOrder, status, start, end,
				orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TALELET_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TALELET_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_O_GROUPID_2);

		query.append(_FINDER_COLUMN_G_O_TALEORDER_2);

		query.append(_FINDER_COLUMN_G_O_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TALELET_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator);
			}
		}

		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(TaleletModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TaleletModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Talelet.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, TaleletImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, TaleletImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(taleOrder);

			qPos.add(status);

			return (List<Talelet>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Finds all the talelets where taleParentId = &#63; and taleOrder = &#63; and status = &#63;.
	 *
	 * @param taleParentId the tale parent id to search with
	 * @param taleOrder the tale order to search with
	 * @param status the status to search with
	 * @return the matching talelets
	 * @throws SystemException if a system exception occurred
	 */
	public List<Talelet> findByTale(long taleParentId, int taleOrder, int status)
		throws SystemException {
		return findByTale(taleParentId, taleOrder, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the talelets where taleParentId = &#63; and taleOrder = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param taleParentId the tale parent id to search with
	 * @param taleOrder the tale order to search with
	 * @param status the status to search with
	 * @param start the lower bound of the range of talelets to return
	 * @param end the upper bound of the range of talelets to return (not inclusive)
	 * @return the range of matching talelets
	 * @throws SystemException if a system exception occurred
	 */
	public List<Talelet> findByTale(long taleParentId, int taleOrder,
		int status, int start, int end) throws SystemException {
		return findByTale(taleParentId, taleOrder, status, start, end, null);
	}

	/**
	 * Finds an ordered range of all the talelets where taleParentId = &#63; and taleOrder = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param taleParentId the tale parent id to search with
	 * @param taleOrder the tale order to search with
	 * @param status the status to search with
	 * @param start the lower bound of the range of talelets to return
	 * @param end the upper bound of the range of talelets to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching talelets
	 * @throws SystemException if a system exception occurred
	 */
	public List<Talelet> findByTale(long taleParentId, int taleOrder,
		int status, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				taleParentId, taleOrder, status,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Talelet> list = (List<Talelet>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_TALE,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_TALELET_WHERE);

			query.append(_FINDER_COLUMN_TALE_TALEPARENTID_2);

			query.append(_FINDER_COLUMN_TALE_TALEORDER_2);

			query.append(_FINDER_COLUMN_TALE_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TaleletModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(taleParentId);

				qPos.add(taleOrder);

				qPos.add(status);

				list = (List<Talelet>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_TALE,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_TALE,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first talelet in the ordered set where taleParentId = &#63; and taleOrder = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param taleParentId the tale parent id to search with
	 * @param taleOrder the tale order to search with
	 * @param status the status to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching talelet
	 * @throws com.liferay.talelets.service.NoSuchTaleletException if a matching talelet could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Talelet findByTale_First(long taleParentId, int taleOrder,
		int status, OrderByComparator orderByComparator)
		throws NoSuchTaleletException, SystemException {
		List<Talelet> list = findByTale(taleParentId, taleOrder, status, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("taleParentId=");
			msg.append(taleParentId);

			msg.append(", taleOrder=");
			msg.append(taleOrder);

			msg.append(", status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTaleletException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last talelet in the ordered set where taleParentId = &#63; and taleOrder = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param taleParentId the tale parent id to search with
	 * @param taleOrder the tale order to search with
	 * @param status the status to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching talelet
	 * @throws com.liferay.talelets.service.NoSuchTaleletException if a matching talelet could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Talelet findByTale_Last(long taleParentId, int taleOrder,
		int status, OrderByComparator orderByComparator)
		throws NoSuchTaleletException, SystemException {
		int count = countByTale(taleParentId, taleOrder, status);

		List<Talelet> list = findByTale(taleParentId, taleOrder, status,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("taleParentId=");
			msg.append(taleParentId);

			msg.append(", taleOrder=");
			msg.append(taleOrder);

			msg.append(", status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTaleletException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the talelets before and after the current talelet in the ordered set where taleParentId = &#63; and taleOrder = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param taleId the primary key of the current talelet
	 * @param taleParentId the tale parent id to search with
	 * @param taleOrder the tale order to search with
	 * @param status the status to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next talelet
	 * @throws com.liferay.talelets.service.NoSuchTaleletException if a talelet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Talelet[] findByTale_PrevAndNext(long taleId, long taleParentId,
		int taleOrder, int status, OrderByComparator orderByComparator)
		throws NoSuchTaleletException, SystemException {
		Talelet talelet = findByPrimaryKey(taleId);

		Session session = null;

		try {
			session = openSession();

			Talelet[] array = new TaleletImpl[3];

			array[0] = getByTale_PrevAndNext(session, talelet, taleParentId,
					taleOrder, status, orderByComparator, true);

			array[1] = talelet;

			array[2] = getByTale_PrevAndNext(session, talelet, taleParentId,
					taleOrder, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Talelet getByTale_PrevAndNext(Session session, Talelet talelet,
		long taleParentId, int taleOrder, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TALELET_WHERE);

		query.append(_FINDER_COLUMN_TALE_TALEPARENTID_2);

		query.append(_FINDER_COLUMN_TALE_TALEORDER_2);

		query.append(_FINDER_COLUMN_TALE_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(TaleletModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(taleParentId);

		qPos.add(taleOrder);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(talelet);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Talelet> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the talelets where taleStarterId = &#63;.
	 *
	 * @param taleStarterId the tale starter id to search with
	 * @return the matching talelets
	 * @throws SystemException if a system exception occurred
	 */
	public List<Talelet> findByTaleStarter(long taleStarterId)
		throws SystemException {
		return findByTaleStarter(taleStarterId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the talelets where taleStarterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param taleStarterId the tale starter id to search with
	 * @param start the lower bound of the range of talelets to return
	 * @param end the upper bound of the range of talelets to return (not inclusive)
	 * @return the range of matching talelets
	 * @throws SystemException if a system exception occurred
	 */
	public List<Talelet> findByTaleStarter(long taleStarterId, int start,
		int end) throws SystemException {
		return findByTaleStarter(taleStarterId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the talelets where taleStarterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param taleStarterId the tale starter id to search with
	 * @param start the lower bound of the range of talelets to return
	 * @param end the upper bound of the range of talelets to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching talelets
	 * @throws SystemException if a system exception occurred
	 */
	public List<Talelet> findByTaleStarter(long taleStarterId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				taleStarterId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Talelet> list = (List<Talelet>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_TALESTARTER,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TALELET_WHERE);

			query.append(_FINDER_COLUMN_TALESTARTER_TALESTARTERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TaleletModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(taleStarterId);

				list = (List<Talelet>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_TALESTARTER,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_TALESTARTER,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first talelet in the ordered set where taleStarterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param taleStarterId the tale starter id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching talelet
	 * @throws com.liferay.talelets.service.NoSuchTaleletException if a matching talelet could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Talelet findByTaleStarter_First(long taleStarterId,
		OrderByComparator orderByComparator)
		throws NoSuchTaleletException, SystemException {
		List<Talelet> list = findByTaleStarter(taleStarterId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("taleStarterId=");
			msg.append(taleStarterId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTaleletException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last talelet in the ordered set where taleStarterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param taleStarterId the tale starter id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching talelet
	 * @throws com.liferay.talelets.service.NoSuchTaleletException if a matching talelet could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Talelet findByTaleStarter_Last(long taleStarterId,
		OrderByComparator orderByComparator)
		throws NoSuchTaleletException, SystemException {
		int count = countByTaleStarter(taleStarterId);

		List<Talelet> list = findByTaleStarter(taleStarterId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("taleStarterId=");
			msg.append(taleStarterId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTaleletException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the talelets before and after the current talelet in the ordered set where taleStarterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param taleId the primary key of the current talelet
	 * @param taleStarterId the tale starter id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next talelet
	 * @throws com.liferay.talelets.service.NoSuchTaleletException if a talelet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Talelet[] findByTaleStarter_PrevAndNext(long taleId,
		long taleStarterId, OrderByComparator orderByComparator)
		throws NoSuchTaleletException, SystemException {
		Talelet talelet = findByPrimaryKey(taleId);

		Session session = null;

		try {
			session = openSession();

			Talelet[] array = new TaleletImpl[3];

			array[0] = getByTaleStarter_PrevAndNext(session, talelet,
					taleStarterId, orderByComparator, true);

			array[1] = talelet;

			array[2] = getByTaleStarter_PrevAndNext(session, talelet,
					taleStarterId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Talelet getByTaleStarter_PrevAndNext(Session session,
		Talelet talelet, long taleStarterId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TALELET_WHERE);

		query.append(_FINDER_COLUMN_TALESTARTER_TALESTARTERID_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(TaleletModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(taleStarterId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(talelet);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Talelet> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the talelets where companyId = &#63;.
	 *
	 * @param companyId the company id to search with
	 * @return the matching talelets
	 * @throws SystemException if a system exception occurred
	 */
	public List<Talelet> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Finds a range of all the talelets where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param start the lower bound of the range of talelets to return
	 * @param end the upper bound of the range of talelets to return (not inclusive)
	 * @return the range of matching talelets
	 * @throws SystemException if a system exception occurred
	 */
	public List<Talelet> findByCompanyId(long companyId, int start, int end)
		throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the talelets where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param start the lower bound of the range of talelets to return
	 * @param end the upper bound of the range of talelets to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching talelets
	 * @throws SystemException if a system exception occurred
	 */
	public List<Talelet> findByCompanyId(long companyId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Talelet> list = (List<Talelet>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_COMPANYID,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TALELET_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TaleletModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<Talelet>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_COMPANYID,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_COMPANYID,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first talelet in the ordered set where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching talelet
	 * @throws com.liferay.talelets.service.NoSuchTaleletException if a matching talelet could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Talelet findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTaleletException, SystemException {
		List<Talelet> list = findByCompanyId(companyId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTaleletException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last talelet in the ordered set where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching talelet
	 * @throws com.liferay.talelets.service.NoSuchTaleletException if a matching talelet could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Talelet findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTaleletException, SystemException {
		int count = countByCompanyId(companyId);

		List<Talelet> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTaleletException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the talelets before and after the current talelet in the ordered set where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param taleId the primary key of the current talelet
	 * @param companyId the company id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next talelet
	 * @throws com.liferay.talelets.service.NoSuchTaleletException if a talelet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Talelet[] findByCompanyId_PrevAndNext(long taleId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTaleletException, SystemException {
		Talelet talelet = findByPrimaryKey(taleId);

		Session session = null;

		try {
			session = openSession();

			Talelet[] array = new TaleletImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, talelet, companyId,
					orderByComparator, true);

			array[1] = talelet;

			array[2] = getByCompanyId_PrevAndNext(session, talelet, companyId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Talelet getByCompanyId_PrevAndNext(Session session,
		Talelet talelet, long companyId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TALELET_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(TaleletModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(talelet);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Talelet> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the talelets where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param userId the user id to search with
	 * @return the matching talelets
	 * @throws SystemException if a system exception occurred
	 */
	public List<Talelet> findByU_G(long groupId, long userId)
		throws SystemException {
		return findByU_G(groupId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Finds a range of all the talelets where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param userId the user id to search with
	 * @param start the lower bound of the range of talelets to return
	 * @param end the upper bound of the range of talelets to return (not inclusive)
	 * @return the range of matching talelets
	 * @throws SystemException if a system exception occurred
	 */
	public List<Talelet> findByU_G(long groupId, long userId, int start, int end)
		throws SystemException {
		return findByU_G(groupId, userId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the talelets where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param userId the user id to search with
	 * @param start the lower bound of the range of talelets to return
	 * @param end the upper bound of the range of talelets to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching talelets
	 * @throws SystemException if a system exception occurred
	 */
	public List<Talelet> findByU_G(long groupId, long userId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId, userId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Talelet> list = (List<Talelet>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_U_G,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_TALELET_WHERE);

			query.append(_FINDER_COLUMN_U_G_GROUPID_2);

			query.append(_FINDER_COLUMN_U_G_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TaleletModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(userId);

				list = (List<Talelet>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_U_G,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_U_G,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first talelet in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param userId the user id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching talelet
	 * @throws com.liferay.talelets.service.NoSuchTaleletException if a matching talelet could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Talelet findByU_G_First(long groupId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchTaleletException, SystemException {
		List<Talelet> list = findByU_G(groupId, userId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTaleletException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last talelet in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param userId the user id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching talelet
	 * @throws com.liferay.talelets.service.NoSuchTaleletException if a matching talelet could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Talelet findByU_G_Last(long groupId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchTaleletException, SystemException {
		int count = countByU_G(groupId, userId);

		List<Talelet> list = findByU_G(groupId, userId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTaleletException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the talelets before and after the current talelet in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param taleId the primary key of the current talelet
	 * @param groupId the group id to search with
	 * @param userId the user id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next talelet
	 * @throws com.liferay.talelets.service.NoSuchTaleletException if a talelet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Talelet[] findByU_G_PrevAndNext(long taleId, long groupId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchTaleletException, SystemException {
		Talelet talelet = findByPrimaryKey(taleId);

		Session session = null;

		try {
			session = openSession();

			Talelet[] array = new TaleletImpl[3];

			array[0] = getByU_G_PrevAndNext(session, talelet, groupId, userId,
					orderByComparator, true);

			array[1] = talelet;

			array[2] = getByU_G_PrevAndNext(session, talelet, groupId, userId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Talelet getByU_G_PrevAndNext(Session session, Talelet talelet,
		long groupId, long userId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TALELET_WHERE);

		query.append(_FINDER_COLUMN_U_G_GROUPID_2);

		query.append(_FINDER_COLUMN_U_G_USERID_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(TaleletModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(talelet);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Talelet> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Filters by the user's permissions and finds all the talelets where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param userId the user id to search with
	 * @return the matching talelets that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Talelet> filterFindByU_G(long groupId, long userId)
		throws SystemException {
		return filterFindByU_G(groupId, userId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Filters by the user's permissions and finds a range of all the talelets where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param userId the user id to search with
	 * @param start the lower bound of the range of talelets to return
	 * @param end the upper bound of the range of talelets to return (not inclusive)
	 * @return the range of matching talelets that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Talelet> filterFindByU_G(long groupId, long userId, int start,
		int end) throws SystemException {
		return filterFindByU_G(groupId, userId, start, end, null);
	}

	/**
	 * Filters by the user's permissions and finds an ordered range of all the talelets where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param userId the user id to search with
	 * @param start the lower bound of the range of talelets to return
	 * @param end the upper bound of the range of talelets to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching talelets that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Talelet> filterFindByU_G(long groupId, long userId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByU_G(groupId, userId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TALELET_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TALELET_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_U_G_GROUPID_2);

		query.append(_FINDER_COLUMN_U_G_USERID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TALELET_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator);
			}
		}

		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(TaleletModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TaleletModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Talelet.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, TaleletImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, TaleletImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(userId);

			return (List<Talelet>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Finds all the talelets where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param status the status to search with
	 * @return the matching talelets
	 * @throws SystemException if a system exception occurred
	 */
	public List<Talelet> findByG_S(long groupId, int status)
		throws SystemException {
		return findByG_S(groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Finds a range of all the talelets where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param status the status to search with
	 * @param start the lower bound of the range of talelets to return
	 * @param end the upper bound of the range of talelets to return (not inclusive)
	 * @return the range of matching talelets
	 * @throws SystemException if a system exception occurred
	 */
	public List<Talelet> findByG_S(long groupId, int status, int start, int end)
		throws SystemException {
		return findByG_S(groupId, status, start, end, null);
	}

	/**
	 * Finds an ordered range of all the talelets where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param status the status to search with
	 * @param start the lower bound of the range of talelets to return
	 * @param end the upper bound of the range of talelets to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching talelets
	 * @throws SystemException if a system exception occurred
	 */
	public List<Talelet> findByG_S(long groupId, int status, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId, status,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Talelet> list = (List<Talelet>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_G_S,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_TALELET_WHERE);

			query.append(_FINDER_COLUMN_G_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TaleletModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(status);

				list = (List<Talelet>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_G_S,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_G_S,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first talelet in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param status the status to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching talelet
	 * @throws com.liferay.talelets.service.NoSuchTaleletException if a matching talelet could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Talelet findByG_S_First(long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchTaleletException, SystemException {
		List<Talelet> list = findByG_S(groupId, status, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTaleletException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last talelet in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param status the status to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching talelet
	 * @throws com.liferay.talelets.service.NoSuchTaleletException if a matching talelet could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Talelet findByG_S_Last(long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchTaleletException, SystemException {
		int count = countByG_S(groupId, status);

		List<Talelet> list = findByG_S(groupId, status, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTaleletException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the talelets before and after the current talelet in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param taleId the primary key of the current talelet
	 * @param groupId the group id to search with
	 * @param status the status to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next talelet
	 * @throws com.liferay.talelets.service.NoSuchTaleletException if a talelet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Talelet[] findByG_S_PrevAndNext(long taleId, long groupId,
		int status, OrderByComparator orderByComparator)
		throws NoSuchTaleletException, SystemException {
		Talelet talelet = findByPrimaryKey(taleId);

		Session session = null;

		try {
			session = openSession();

			Talelet[] array = new TaleletImpl[3];

			array[0] = getByG_S_PrevAndNext(session, talelet, groupId, status,
					orderByComparator, true);

			array[1] = talelet;

			array[2] = getByG_S_PrevAndNext(session, talelet, groupId, status,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Talelet getByG_S_PrevAndNext(Session session, Talelet talelet,
		long groupId, int status, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TALELET_WHERE);

		query.append(_FINDER_COLUMN_G_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_S_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(TaleletModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(talelet);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Talelet> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Filters by the user's permissions and finds all the talelets where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param status the status to search with
	 * @return the matching talelets that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Talelet> filterFindByG_S(long groupId, int status)
		throws SystemException {
		return filterFindByG_S(groupId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Filters by the user's permissions and finds a range of all the talelets where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param status the status to search with
	 * @param start the lower bound of the range of talelets to return
	 * @param end the upper bound of the range of talelets to return (not inclusive)
	 * @return the range of matching talelets that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Talelet> filterFindByG_S(long groupId, int status, int start,
		int end) throws SystemException {
		return filterFindByG_S(groupId, status, start, end, null);
	}

	/**
	 * Filters by the user's permissions and finds an ordered range of all the talelets where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param status the status to search with
	 * @param start the lower bound of the range of talelets to return
	 * @param end the upper bound of the range of talelets to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching talelets that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Talelet> filterFindByG_S(long groupId, int status, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S(groupId, status, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TALELET_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TALELET_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TALELET_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator);
			}
		}

		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(TaleletModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TaleletModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Talelet.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, TaleletImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, TaleletImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(status);

			return (List<Talelet>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Finds all the talelets.
	 *
	 * @return the talelets
	 * @throws SystemException if a system exception occurred
	 */
	public List<Talelet> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the talelets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of talelets to return
	 * @param end the upper bound of the range of talelets to return (not inclusive)
	 * @return the range of talelets
	 * @throws SystemException if a system exception occurred
	 */
	public List<Talelet> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the talelets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of talelets to return
	 * @param end the upper bound of the range of talelets to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of talelets
	 * @throws SystemException if a system exception occurred
	 */
	public List<Talelet> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Talelet> list = (List<Talelet>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TALELET);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TALELET.concat(TaleletModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Talelet>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Talelet>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_ALL,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs,
						list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the talelets where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUuid(String uuid) throws SystemException {
		for (Talelet talelet : findByUuid(uuid)) {
			remove(talelet);
		}
	}

	/**
	 * Removes the talelet where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid to search with
	 * @param groupId the group id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUUID_G(String uuid, long groupId)
		throws NoSuchTaleletException, SystemException {
		Talelet talelet = findByUUID_G(uuid, groupId);

		remove(talelet);
	}

	/**
	 * Removes all the talelets where groupId = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupId(long groupId) throws SystemException {
		for (Talelet talelet : findByGroupId(groupId)) {
			remove(talelet);
		}
	}

	/**
	 * Removes all the talelets where groupId = &#63; and taleOrder = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @param taleOrder the tale order to search with
	 * @param status the status to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_O(long groupId, int taleOrder, int status)
		throws SystemException {
		for (Talelet talelet : findByG_O(groupId, taleOrder, status)) {
			remove(talelet);
		}
	}

	/**
	 * Removes all the talelets where taleParentId = &#63; and taleOrder = &#63; and status = &#63; from the database.
	 *
	 * @param taleParentId the tale parent id to search with
	 * @param taleOrder the tale order to search with
	 * @param status the status to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTale(long taleParentId, int taleOrder, int status)
		throws SystemException {
		for (Talelet talelet : findByTale(taleParentId, taleOrder, status)) {
			remove(talelet);
		}
	}

	/**
	 * Removes all the talelets where taleStarterId = &#63; from the database.
	 *
	 * @param taleStarterId the tale starter id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTaleStarter(long taleStarterId)
		throws SystemException {
		for (Talelet talelet : findByTaleStarter(taleStarterId)) {
			remove(talelet);
		}
	}

	/**
	 * Removes all the talelets where companyId = &#63; from the database.
	 *
	 * @param companyId the company id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompanyId(long companyId) throws SystemException {
		for (Talelet talelet : findByCompanyId(companyId)) {
			remove(talelet);
		}
	}

	/**
	 * Removes all the talelets where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @param userId the user id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByU_G(long groupId, long userId)
		throws SystemException {
		for (Talelet talelet : findByU_G(groupId, userId)) {
			remove(talelet);
		}
	}

	/**
	 * Removes all the talelets where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @param status the status to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_S(long groupId, int status) throws SystemException {
		for (Talelet talelet : findByG_S(groupId, status)) {
			remove(talelet);
		}
	}

	/**
	 * Removes all the talelets from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Talelet talelet : findAll()) {
			remove(talelet);
		}
	}

	/**
	 * Counts all the talelets where uuid = &#63;.
	 *
	 * @param uuid the uuid to search with
	 * @return the number of matching talelets
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUuid(String uuid) throws SystemException {
		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TALELET_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_UUID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the talelets where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid to search with
	 * @param groupId the group id to search with
	 * @return the number of matching talelets
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUUID_G(String uuid, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID_G,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TALELET_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_G_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_G_UUID_2);
				}
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the talelets where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the number of matching talelets
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TALELET_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Filters by the user's permissions and counts all the talelets where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the number of matching talelets that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroupId(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_TALELET_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Talelet.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Counts all the talelets where groupId = &#63; and taleOrder = &#63; and status = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param taleOrder the tale order to search with
	 * @param status the status to search with
	 * @return the number of matching talelets
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_O(long groupId, int taleOrder, int status)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, taleOrder, status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_O,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_TALELET_WHERE);

			query.append(_FINDER_COLUMN_G_O_GROUPID_2);

			query.append(_FINDER_COLUMN_G_O_TALEORDER_2);

			query.append(_FINDER_COLUMN_G_O_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(taleOrder);

				qPos.add(status);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_O, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Filters by the user's permissions and counts all the talelets where groupId = &#63; and taleOrder = &#63; and status = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param taleOrder the tale order to search with
	 * @param status the status to search with
	 * @return the number of matching talelets that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByG_O(long groupId, int taleOrder, int status)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_O(groupId, taleOrder, status);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_TALELET_WHERE);

		query.append(_FINDER_COLUMN_G_O_GROUPID_2);

		query.append(_FINDER_COLUMN_G_O_TALEORDER_2);

		query.append(_FINDER_COLUMN_G_O_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Talelet.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(taleOrder);

			qPos.add(status);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Counts all the talelets where taleParentId = &#63; and taleOrder = &#63; and status = &#63;.
	 *
	 * @param taleParentId the tale parent id to search with
	 * @param taleOrder the tale order to search with
	 * @param status the status to search with
	 * @return the number of matching talelets
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTale(long taleParentId, int taleOrder, int status)
		throws SystemException {
		Object[] finderArgs = new Object[] { taleParentId, taleOrder, status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TALE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_TALELET_WHERE);

			query.append(_FINDER_COLUMN_TALE_TALEPARENTID_2);

			query.append(_FINDER_COLUMN_TALE_TALEORDER_2);

			query.append(_FINDER_COLUMN_TALE_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(taleParentId);

				qPos.add(taleOrder);

				qPos.add(status);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TALE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the talelets where taleStarterId = &#63;.
	 *
	 * @param taleStarterId the tale starter id to search with
	 * @return the number of matching talelets
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTaleStarter(long taleStarterId) throws SystemException {
		Object[] finderArgs = new Object[] { taleStarterId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TALESTARTER,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TALELET_WHERE);

			query.append(_FINDER_COLUMN_TALESTARTER_TALESTARTERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(taleStarterId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TALESTARTER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the talelets where companyId = &#63;.
	 *
	 * @param companyId the company id to search with
	 * @return the number of matching talelets
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompanyId(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TALELET_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANYID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the talelets where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param userId the user id to search with
	 * @return the number of matching talelets
	 * @throws SystemException if a system exception occurred
	 */
	public int countByU_G(long groupId, long userId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_U_G,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TALELET_WHERE);

			query.append(_FINDER_COLUMN_U_G_GROUPID_2);

			query.append(_FINDER_COLUMN_U_G_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(userId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_U_G, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Filters by the user's permissions and counts all the talelets where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param userId the user id to search with
	 * @return the number of matching talelets that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByU_G(long groupId, long userId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByU_G(groupId, userId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_TALELET_WHERE);

		query.append(_FINDER_COLUMN_U_G_GROUPID_2);

		query.append(_FINDER_COLUMN_U_G_USERID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Talelet.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(userId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Counts all the talelets where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param status the status to search with
	 * @return the number of matching talelets
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_S(long groupId, int status) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_S,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TALELET_WHERE);

			query.append(_FINDER_COLUMN_G_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_S_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(status);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_S, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Filters by the user's permissions and counts all the talelets where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param status the status to search with
	 * @return the number of matching talelets that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByG_S(long groupId, int status)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_S(groupId, status);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_TALELET_WHERE);

		query.append(_FINDER_COLUMN_G_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_S_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Talelet.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(status);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Counts all the talelets.
	 *
	 * @return the number of talelets
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TALELET);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the talelet persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.talelets.service.model.Talelet")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Talelet>> listenersList = new ArrayList<ModelListener<Talelet>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Talelet>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(TaleletImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST);
	}

	@BeanReference(type = TaleletPersistence.class)
	protected TaleletPersistence taleletPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@BeanReference(type = AssetEntryPersistence.class)
	protected AssetEntryPersistence assetEntryPersistence;
	private static final String _SQL_SELECT_TALELET = "SELECT talelet FROM Talelet talelet";
	private static final String _SQL_SELECT_TALELET_WHERE = "SELECT talelet FROM Talelet talelet WHERE ";
	private static final String _SQL_COUNT_TALELET = "SELECT COUNT(talelet) FROM Talelet talelet";
	private static final String _SQL_COUNT_TALELET_WHERE = "SELECT COUNT(talelet) FROM Talelet talelet WHERE ";
	private static final String _FINDER_COLUMN_UUID_UUID_1 = "talelet.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "talelet.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(talelet.uuid IS NULL OR talelet.uuid = ?)";
	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "talelet.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "talelet.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(talelet.uuid IS NULL OR talelet.uuid = ?) AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "talelet.groupId = ?";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "talelet.groupId = ?";
	private static final String _FINDER_COLUMN_G_O_GROUPID_2 = "talelet.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_O_TALEORDER_2 = "talelet.taleOrder = ? AND ";
	private static final String _FINDER_COLUMN_G_O_STATUS_2 = "talelet.status = ?";
	private static final String _FINDER_COLUMN_TALE_TALEPARENTID_2 = "talelet.taleParentId = ? AND ";
	private static final String _FINDER_COLUMN_TALE_TALEORDER_2 = "talelet.taleOrder = ? AND ";
	private static final String _FINDER_COLUMN_TALE_STATUS_2 = "talelet.status = ?";
	private static final String _FINDER_COLUMN_TALESTARTER_TALESTARTERID_2 = "talelet.taleStarterId = ?";
	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "talelet.companyId = ?";
	private static final String _FINDER_COLUMN_U_G_GROUPID_2 = "talelet.groupId = ? AND ";
	private static final String _FINDER_COLUMN_U_G_USERID_2 = "talelet.userId = ?";
	private static final String _FINDER_COLUMN_G_S_GROUPID_2 = "talelet.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_S_STATUS_2 = "talelet.status = ?";
	private static final String _FILTER_SQL_SELECT_TALELET_WHERE = "SELECT DISTINCT {talelet.*} FROM talelets_Talelet talelet WHERE ";
	private static final String _FILTER_SQL_SELECT_TALELET_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {talelets_Talelet.*} FROM (SELECT DISTINCT talelet.taleId FROM talelets_Talelet talelet WHERE ";
	private static final String _FILTER_SQL_SELECT_TALELET_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN talelets_Talelet ON TEMP_TABLE.taleId = talelets_Talelet.taleId";
	private static final String _FILTER_SQL_COUNT_TALELET_WHERE = "SELECT COUNT(DISTINCT talelet.taleId) AS COUNT_VALUE FROM talelets_Talelet talelet WHERE ";
	private static final String _FILTER_COLUMN_PK = "talelet.taleId";
	private static final String _FILTER_COLUMN_USERID = "talelet.userId";
	private static final String _FILTER_ENTITY_ALIAS = "talelet";
	private static final String _FILTER_ENTITY_TABLE = "talelets_Talelet";
	private static final String _ORDER_BY_ENTITY_ALIAS = "talelet.";
	private static final String _ORDER_BY_ENTITY_TABLE = "talelets_Talelet.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Talelet exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Talelet exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(TaleletPersistenceImpl.class);
}