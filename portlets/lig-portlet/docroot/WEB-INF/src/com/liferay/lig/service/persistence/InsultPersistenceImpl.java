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

package com.liferay.lig.service.persistence;

import com.liferay.lig.NoSuchInsultException;
import com.liferay.lig.model.Insult;
import com.liferay.lig.model.impl.InsultImpl;
import com.liferay.lig.model.impl.InsultModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.annotation.BeanReference;
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
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the insult service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link InsultUtil} to access the insult persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Rich Sezov
 * @see InsultPersistence
 * @see InsultUtil
 * @generated
 */
public class InsultPersistenceImpl extends BasePersistenceImpl<Insult>
	implements InsultPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = InsultImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_GROUPID = new FinderPath(InsultModelImpl.ENTITY_CACHE_ENABLED,
			InsultModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(InsultModelImpl.ENTITY_CACHE_ENABLED,
			InsultModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByGroupId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ADJECTIVEONE = new FinderPath(InsultModelImpl.ENTITY_CACHE_ENABLED,
			InsultModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByAdjectiveOne",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ADJECTIVEONE = new FinderPath(InsultModelImpl.ENTITY_CACHE_ENABLED,
			InsultModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByAdjectiveOne", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_DIRECTOBJECT = new FinderPath(InsultModelImpl.ENTITY_CACHE_ENABLED,
			InsultModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByDirectObject",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_DIRECTOBJECT = new FinderPath(InsultModelImpl.ENTITY_CACHE_ENABLED,
			InsultModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByDirectObject", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ADJECTIVETWO = new FinderPath(InsultModelImpl.ENTITY_CACHE_ENABLED,
			InsultModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByAdjectiveTwo",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ADJECTIVETWO = new FinderPath(InsultModelImpl.ENTITY_CACHE_ENABLED,
			InsultModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByAdjectiveTwo", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBJPREPOSITION = new FinderPath(InsultModelImpl.ENTITY_CACHE_ENABLED,
			InsultModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByObjPreposition",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_OBJPREPOSITION = new FinderPath(InsultModelImpl.ENTITY_CACHE_ENABLED,
			InsultModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByObjPreposition", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(InsultModelImpl.ENTITY_CACHE_ENABLED,
			InsultModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(InsultModelImpl.ENTITY_CACHE_ENABLED,
			InsultModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the insult in the entity cache if it is enabled.
	 *
	 * @param insult the insult to cache
	 */
	public void cacheResult(Insult insult) {
		EntityCacheUtil.putResult(InsultModelImpl.ENTITY_CACHE_ENABLED,
			InsultImpl.class, insult.getPrimaryKey(), insult);
	}

	/**
	 * Caches the insults in the entity cache if it is enabled.
	 *
	 * @param insults the insults to cache
	 */
	public void cacheResult(List<Insult> insults) {
		for (Insult insult : insults) {
			if (EntityCacheUtil.getResult(
						InsultModelImpl.ENTITY_CACHE_ENABLED, InsultImpl.class,
						insult.getPrimaryKey(), this) == null) {
				cacheResult(insult);
			}
		}
	}

	/**
	 * Clears the cache for all insults.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(InsultImpl.class.getName());
		EntityCacheUtil.clearCache(InsultImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the insult.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(Insult insult) {
		EntityCacheUtil.removeResult(InsultModelImpl.ENTITY_CACHE_ENABLED,
			InsultImpl.class, insult.getPrimaryKey());
	}

	/**
	 * Creates a new insult with the primary key. Does not add the insult to the database.
	 *
	 * @param insultId the primary key for the new insult
	 * @return the new insult
	 */
	public Insult create(long insultId) {
		Insult insult = new InsultImpl();

		insult.setNew(true);
		insult.setPrimaryKey(insultId);

		return insult;
	}

	/**
	 * Removes the insult with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the insult to remove
	 * @return the insult that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a insult with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Insult remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the insult with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param insultId the primary key of the insult to remove
	 * @return the insult that was removed
	 * @throws com.liferay.lig.NoSuchInsultException if a insult with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Insult remove(long insultId)
		throws NoSuchInsultException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Insult insult = (Insult)session.get(InsultImpl.class,
					new Long(insultId));

			if (insult == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + insultId);
				}

				throw new NoSuchInsultException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					insultId);
			}

			return remove(insult);
		}
		catch (NoSuchInsultException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Insult removeImpl(Insult insult) throws SystemException {
		insult = toUnwrappedModel(insult);

		Session session = null;

		try {
			session = openSession();

			if (insult.isCachedModel() || BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(InsultImpl.class,
						insult.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(insult);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(InsultModelImpl.ENTITY_CACHE_ENABLED,
			InsultImpl.class, insult.getPrimaryKey());

		return insult;
	}

	public Insult updateImpl(com.liferay.lig.model.Insult insult, boolean merge)
		throws SystemException {
		insult = toUnwrappedModel(insult);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, insult, merge);

			insult.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(InsultModelImpl.ENTITY_CACHE_ENABLED,
			InsultImpl.class, insult.getPrimaryKey(), insult);

		return insult;
	}

	protected Insult toUnwrappedModel(Insult insult) {
		if (insult instanceof InsultImpl) {
			return insult;
		}

		InsultImpl insultImpl = new InsultImpl();

		insultImpl.setNew(insult.isNew());
		insultImpl.setPrimaryKey(insult.getPrimaryKey());

		insultImpl.setInsultId(insult.getInsultId());
		insultImpl.setAdjectiveOne(insult.getAdjectiveOne());
		insultImpl.setDirectObject(insult.getDirectObject());
		insultImpl.setAdjectiveTwo(insult.getAdjectiveTwo());
		insultImpl.setObjPreposition(insult.getObjPreposition());
		insultImpl.setCompanyId(insult.getCompanyId());
		insultImpl.setGroupId(insult.getGroupId());
		insultImpl.setUserId(insult.getUserId());

		return insultImpl;
	}

	/**
	 * Finds the insult with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the insult to find
	 * @return the insult
	 * @throws com.liferay.portal.NoSuchModelException if a insult with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Insult findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the insult with the primary key or throws a {@link com.liferay.lig.NoSuchInsultException} if it could not be found.
	 *
	 * @param insultId the primary key of the insult to find
	 * @return the insult
	 * @throws com.liferay.lig.NoSuchInsultException if a insult with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Insult findByPrimaryKey(long insultId)
		throws NoSuchInsultException, SystemException {
		Insult insult = fetchByPrimaryKey(insultId);

		if (insult == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + insultId);
			}

			throw new NoSuchInsultException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				insultId);
		}

		return insult;
	}

	/**
	 * Finds the insult with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the insult to find
	 * @return the insult, or <code>null</code> if a insult with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Insult fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the insult with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param insultId the primary key of the insult to find
	 * @return the insult, or <code>null</code> if a insult with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Insult fetchByPrimaryKey(long insultId) throws SystemException {
		Insult insult = (Insult)EntityCacheUtil.getResult(InsultModelImpl.ENTITY_CACHE_ENABLED,
				InsultImpl.class, insultId, this);

		if (insult == null) {
			Session session = null;

			try {
				session = openSession();

				insult = (Insult)session.get(InsultImpl.class,
						new Long(insultId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (insult != null) {
					cacheResult(insult);
				}

				closeSession(session);
			}
		}

		return insult;
	}

	/**
	 * Finds all the insults where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the matching insults
	 * @throws SystemException if a system exception occurred
	 */
	public List<Insult> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the insults where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of insults to return
	 * @param end the upper bound of the range of insults to return (not inclusive)
	 * @return the range of matching insults
	 * @throws SystemException if a system exception occurred
	 */
	public List<Insult> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the insults where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of insults to return
	 * @param end the upper bound of the range of insults to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching insults
	 * @throws SystemException if a system exception occurred
	 */
	public List<Insult> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Insult> list = (List<Insult>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_GROUPID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;

				if (orderByComparator != null) {
					query = new StringBundler(3 +
							(orderByComparator.getOrderByFields().length * 3));
				}
				else {
					query = new StringBundler(2);
				}

				query.append(_SQL_SELECT_INSULT_WHERE);

				query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<Insult>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Insult>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_GROUPID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first insult in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching insult
	 * @throws com.liferay.lig.NoSuchInsultException if a matching insult could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Insult findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchInsultException, SystemException {
		List<Insult> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchInsultException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last insult in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching insult
	 * @throws com.liferay.lig.NoSuchInsultException if a matching insult could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Insult findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchInsultException, SystemException {
		int count = countByGroupId(groupId);

		List<Insult> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchInsultException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the insults before and after the current insult in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param insultId the primary key of the current insult
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next insult
	 * @throws com.liferay.lig.NoSuchInsultException if a insult with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Insult[] findByGroupId_PrevAndNext(long insultId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchInsultException, SystemException {
		Insult insult = findByPrimaryKey(insultId);

		Session session = null;

		try {
			session = openSession();

			Insult[] array = new InsultImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, insult, groupId,
					orderByComparator, true);

			array[1] = insult;

			array[2] = getByGroupId_PrevAndNext(session, insult, groupId,
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

	protected Insult getByGroupId_PrevAndNext(Session session, Insult insult,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INSULT_WHERE);

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

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(insult);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Insult> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Filters by the user's permissions and finds all the insults where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the matching insults that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Insult> filterFindByGroupId(long groupId)
		throws SystemException {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Filters by the user's permissions and finds a range of all the insults where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of insults to return
	 * @param end the upper bound of the range of insults to return (not inclusive)
	 * @return the range of matching insults that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Insult> filterFindByGroupId(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Filters by the user's permissions and finds an ordered range of all the insults where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of insults to return
	 * @param end the upper bound of the range of insults to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching insults that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Insult> filterFindByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId(groupId, start, end, orderByComparator);
		}

		Session session = null;

		try {
			session = openSession();

			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_FILTER_SQL_SELECT_INSULT_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
					Insult.class.getName(), _FILTER_COLUMN_PK,
					_FILTER_COLUMN_USERID, groupId);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity(_FILTER_ENTITY_ALIAS, InsultImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<Insult>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Finds all the insults where adjectiveOne = &#63;.
	 *
	 * @param adjectiveOne the adjective one to search with
	 * @return the matching insults
	 * @throws SystemException if a system exception occurred
	 */
	public List<Insult> findByAdjectiveOne(String adjectiveOne)
		throws SystemException {
		return findByAdjectiveOne(adjectiveOne, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the insults where adjectiveOne = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param adjectiveOne the adjective one to search with
	 * @param start the lower bound of the range of insults to return
	 * @param end the upper bound of the range of insults to return (not inclusive)
	 * @return the range of matching insults
	 * @throws SystemException if a system exception occurred
	 */
	public List<Insult> findByAdjectiveOne(String adjectiveOne, int start,
		int end) throws SystemException {
		return findByAdjectiveOne(adjectiveOne, start, end, null);
	}

	/**
	 * Finds an ordered range of all the insults where adjectiveOne = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param adjectiveOne the adjective one to search with
	 * @param start the lower bound of the range of insults to return
	 * @param end the upper bound of the range of insults to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching insults
	 * @throws SystemException if a system exception occurred
	 */
	public List<Insult> findByAdjectiveOne(String adjectiveOne, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				adjectiveOne,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Insult> list = (List<Insult>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ADJECTIVEONE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;

				if (orderByComparator != null) {
					query = new StringBundler(3 +
							(orderByComparator.getOrderByFields().length * 3));
				}
				else {
					query = new StringBundler(2);
				}

				query.append(_SQL_SELECT_INSULT_WHERE);

				if (adjectiveOne == null) {
					query.append(_FINDER_COLUMN_ADJECTIVEONE_ADJECTIVEONE_1);
				}
				else {
					if (adjectiveOne.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_ADJECTIVEONE_ADJECTIVEONE_3);
					}
					else {
						query.append(_FINDER_COLUMN_ADJECTIVEONE_ADJECTIVEONE_2);
					}
				}

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (adjectiveOne != null) {
					qPos.add(adjectiveOne);
				}

				list = (List<Insult>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Insult>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ADJECTIVEONE,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first insult in the ordered set where adjectiveOne = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param adjectiveOne the adjective one to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching insult
	 * @throws com.liferay.lig.NoSuchInsultException if a matching insult could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Insult findByAdjectiveOne_First(String adjectiveOne,
		OrderByComparator orderByComparator)
		throws NoSuchInsultException, SystemException {
		List<Insult> list = findByAdjectiveOne(adjectiveOne, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("adjectiveOne=");
			msg.append(adjectiveOne);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchInsultException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last insult in the ordered set where adjectiveOne = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param adjectiveOne the adjective one to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching insult
	 * @throws com.liferay.lig.NoSuchInsultException if a matching insult could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Insult findByAdjectiveOne_Last(String adjectiveOne,
		OrderByComparator orderByComparator)
		throws NoSuchInsultException, SystemException {
		int count = countByAdjectiveOne(adjectiveOne);

		List<Insult> list = findByAdjectiveOne(adjectiveOne, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("adjectiveOne=");
			msg.append(adjectiveOne);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchInsultException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the insults before and after the current insult in the ordered set where adjectiveOne = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param insultId the primary key of the current insult
	 * @param adjectiveOne the adjective one to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next insult
	 * @throws com.liferay.lig.NoSuchInsultException if a insult with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Insult[] findByAdjectiveOne_PrevAndNext(long insultId,
		String adjectiveOne, OrderByComparator orderByComparator)
		throws NoSuchInsultException, SystemException {
		Insult insult = findByPrimaryKey(insultId);

		Session session = null;

		try {
			session = openSession();

			Insult[] array = new InsultImpl[3];

			array[0] = getByAdjectiveOne_PrevAndNext(session, insult,
					adjectiveOne, orderByComparator, true);

			array[1] = insult;

			array[2] = getByAdjectiveOne_PrevAndNext(session, insult,
					adjectiveOne, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Insult getByAdjectiveOne_PrevAndNext(Session session,
		Insult insult, String adjectiveOne,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INSULT_WHERE);

		if (adjectiveOne == null) {
			query.append(_FINDER_COLUMN_ADJECTIVEONE_ADJECTIVEONE_1);
		}
		else {
			if (adjectiveOne.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ADJECTIVEONE_ADJECTIVEONE_3);
			}
			else {
				query.append(_FINDER_COLUMN_ADJECTIVEONE_ADJECTIVEONE_2);
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

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (adjectiveOne != null) {
			qPos.add(adjectiveOne);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(insult);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Insult> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the insults where directObject = &#63;.
	 *
	 * @param directObject the direct object to search with
	 * @return the matching insults
	 * @throws SystemException if a system exception occurred
	 */
	public List<Insult> findByDirectObject(String directObject)
		throws SystemException {
		return findByDirectObject(directObject, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the insults where directObject = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param directObject the direct object to search with
	 * @param start the lower bound of the range of insults to return
	 * @param end the upper bound of the range of insults to return (not inclusive)
	 * @return the range of matching insults
	 * @throws SystemException if a system exception occurred
	 */
	public List<Insult> findByDirectObject(String directObject, int start,
		int end) throws SystemException {
		return findByDirectObject(directObject, start, end, null);
	}

	/**
	 * Finds an ordered range of all the insults where directObject = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param directObject the direct object to search with
	 * @param start the lower bound of the range of insults to return
	 * @param end the upper bound of the range of insults to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching insults
	 * @throws SystemException if a system exception occurred
	 */
	public List<Insult> findByDirectObject(String directObject, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				directObject,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Insult> list = (List<Insult>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DIRECTOBJECT,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;

				if (orderByComparator != null) {
					query = new StringBundler(3 +
							(orderByComparator.getOrderByFields().length * 3));
				}
				else {
					query = new StringBundler(2);
				}

				query.append(_SQL_SELECT_INSULT_WHERE);

				if (directObject == null) {
					query.append(_FINDER_COLUMN_DIRECTOBJECT_DIRECTOBJECT_1);
				}
				else {
					if (directObject.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_DIRECTOBJECT_DIRECTOBJECT_3);
					}
					else {
						query.append(_FINDER_COLUMN_DIRECTOBJECT_DIRECTOBJECT_2);
					}
				}

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (directObject != null) {
					qPos.add(directObject);
				}

				list = (List<Insult>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Insult>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DIRECTOBJECT,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first insult in the ordered set where directObject = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param directObject the direct object to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching insult
	 * @throws com.liferay.lig.NoSuchInsultException if a matching insult could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Insult findByDirectObject_First(String directObject,
		OrderByComparator orderByComparator)
		throws NoSuchInsultException, SystemException {
		List<Insult> list = findByDirectObject(directObject, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("directObject=");
			msg.append(directObject);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchInsultException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last insult in the ordered set where directObject = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param directObject the direct object to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching insult
	 * @throws com.liferay.lig.NoSuchInsultException if a matching insult could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Insult findByDirectObject_Last(String directObject,
		OrderByComparator orderByComparator)
		throws NoSuchInsultException, SystemException {
		int count = countByDirectObject(directObject);

		List<Insult> list = findByDirectObject(directObject, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("directObject=");
			msg.append(directObject);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchInsultException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the insults before and after the current insult in the ordered set where directObject = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param insultId the primary key of the current insult
	 * @param directObject the direct object to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next insult
	 * @throws com.liferay.lig.NoSuchInsultException if a insult with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Insult[] findByDirectObject_PrevAndNext(long insultId,
		String directObject, OrderByComparator orderByComparator)
		throws NoSuchInsultException, SystemException {
		Insult insult = findByPrimaryKey(insultId);

		Session session = null;

		try {
			session = openSession();

			Insult[] array = new InsultImpl[3];

			array[0] = getByDirectObject_PrevAndNext(session, insult,
					directObject, orderByComparator, true);

			array[1] = insult;

			array[2] = getByDirectObject_PrevAndNext(session, insult,
					directObject, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Insult getByDirectObject_PrevAndNext(Session session,
		Insult insult, String directObject,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INSULT_WHERE);

		if (directObject == null) {
			query.append(_FINDER_COLUMN_DIRECTOBJECT_DIRECTOBJECT_1);
		}
		else {
			if (directObject.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DIRECTOBJECT_DIRECTOBJECT_3);
			}
			else {
				query.append(_FINDER_COLUMN_DIRECTOBJECT_DIRECTOBJECT_2);
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

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (directObject != null) {
			qPos.add(directObject);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(insult);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Insult> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the insults where adjectiveTwo = &#63;.
	 *
	 * @param adjectiveTwo the adjective two to search with
	 * @return the matching insults
	 * @throws SystemException if a system exception occurred
	 */
	public List<Insult> findByAdjectiveTwo(String adjectiveTwo)
		throws SystemException {
		return findByAdjectiveTwo(adjectiveTwo, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the insults where adjectiveTwo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param adjectiveTwo the adjective two to search with
	 * @param start the lower bound of the range of insults to return
	 * @param end the upper bound of the range of insults to return (not inclusive)
	 * @return the range of matching insults
	 * @throws SystemException if a system exception occurred
	 */
	public List<Insult> findByAdjectiveTwo(String adjectiveTwo, int start,
		int end) throws SystemException {
		return findByAdjectiveTwo(adjectiveTwo, start, end, null);
	}

	/**
	 * Finds an ordered range of all the insults where adjectiveTwo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param adjectiveTwo the adjective two to search with
	 * @param start the lower bound of the range of insults to return
	 * @param end the upper bound of the range of insults to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching insults
	 * @throws SystemException if a system exception occurred
	 */
	public List<Insult> findByAdjectiveTwo(String adjectiveTwo, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				adjectiveTwo,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Insult> list = (List<Insult>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ADJECTIVETWO,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;

				if (orderByComparator != null) {
					query = new StringBundler(3 +
							(orderByComparator.getOrderByFields().length * 3));
				}
				else {
					query = new StringBundler(2);
				}

				query.append(_SQL_SELECT_INSULT_WHERE);

				if (adjectiveTwo == null) {
					query.append(_FINDER_COLUMN_ADJECTIVETWO_ADJECTIVETWO_1);
				}
				else {
					if (adjectiveTwo.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_ADJECTIVETWO_ADJECTIVETWO_3);
					}
					else {
						query.append(_FINDER_COLUMN_ADJECTIVETWO_ADJECTIVETWO_2);
					}
				}

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (adjectiveTwo != null) {
					qPos.add(adjectiveTwo);
				}

				list = (List<Insult>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Insult>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ADJECTIVETWO,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first insult in the ordered set where adjectiveTwo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param adjectiveTwo the adjective two to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching insult
	 * @throws com.liferay.lig.NoSuchInsultException if a matching insult could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Insult findByAdjectiveTwo_First(String adjectiveTwo,
		OrderByComparator orderByComparator)
		throws NoSuchInsultException, SystemException {
		List<Insult> list = findByAdjectiveTwo(adjectiveTwo, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("adjectiveTwo=");
			msg.append(adjectiveTwo);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchInsultException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last insult in the ordered set where adjectiveTwo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param adjectiveTwo the adjective two to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching insult
	 * @throws com.liferay.lig.NoSuchInsultException if a matching insult could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Insult findByAdjectiveTwo_Last(String adjectiveTwo,
		OrderByComparator orderByComparator)
		throws NoSuchInsultException, SystemException {
		int count = countByAdjectiveTwo(adjectiveTwo);

		List<Insult> list = findByAdjectiveTwo(adjectiveTwo, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("adjectiveTwo=");
			msg.append(adjectiveTwo);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchInsultException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the insults before and after the current insult in the ordered set where adjectiveTwo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param insultId the primary key of the current insult
	 * @param adjectiveTwo the adjective two to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next insult
	 * @throws com.liferay.lig.NoSuchInsultException if a insult with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Insult[] findByAdjectiveTwo_PrevAndNext(long insultId,
		String adjectiveTwo, OrderByComparator orderByComparator)
		throws NoSuchInsultException, SystemException {
		Insult insult = findByPrimaryKey(insultId);

		Session session = null;

		try {
			session = openSession();

			Insult[] array = new InsultImpl[3];

			array[0] = getByAdjectiveTwo_PrevAndNext(session, insult,
					adjectiveTwo, orderByComparator, true);

			array[1] = insult;

			array[2] = getByAdjectiveTwo_PrevAndNext(session, insult,
					adjectiveTwo, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Insult getByAdjectiveTwo_PrevAndNext(Session session,
		Insult insult, String adjectiveTwo,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INSULT_WHERE);

		if (adjectiveTwo == null) {
			query.append(_FINDER_COLUMN_ADJECTIVETWO_ADJECTIVETWO_1);
		}
		else {
			if (adjectiveTwo.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ADJECTIVETWO_ADJECTIVETWO_3);
			}
			else {
				query.append(_FINDER_COLUMN_ADJECTIVETWO_ADJECTIVETWO_2);
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

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (adjectiveTwo != null) {
			qPos.add(adjectiveTwo);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(insult);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Insult> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the insults where objPreposition = &#63;.
	 *
	 * @param objPreposition the obj preposition to search with
	 * @return the matching insults
	 * @throws SystemException if a system exception occurred
	 */
	public List<Insult> findByObjPreposition(String objPreposition)
		throws SystemException {
		return findByObjPreposition(objPreposition, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the insults where objPreposition = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param objPreposition the obj preposition to search with
	 * @param start the lower bound of the range of insults to return
	 * @param end the upper bound of the range of insults to return (not inclusive)
	 * @return the range of matching insults
	 * @throws SystemException if a system exception occurred
	 */
	public List<Insult> findByObjPreposition(String objPreposition, int start,
		int end) throws SystemException {
		return findByObjPreposition(objPreposition, start, end, null);
	}

	/**
	 * Finds an ordered range of all the insults where objPreposition = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param objPreposition the obj preposition to search with
	 * @param start the lower bound of the range of insults to return
	 * @param end the upper bound of the range of insults to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching insults
	 * @throws SystemException if a system exception occurred
	 */
	public List<Insult> findByObjPreposition(String objPreposition, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				objPreposition,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Insult> list = (List<Insult>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBJPREPOSITION,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;

				if (orderByComparator != null) {
					query = new StringBundler(3 +
							(orderByComparator.getOrderByFields().length * 3));
				}
				else {
					query = new StringBundler(2);
				}

				query.append(_SQL_SELECT_INSULT_WHERE);

				if (objPreposition == null) {
					query.append(_FINDER_COLUMN_OBJPREPOSITION_OBJPREPOSITION_1);
				}
				else {
					if (objPreposition.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_OBJPREPOSITION_OBJPREPOSITION_3);
					}
					else {
						query.append(_FINDER_COLUMN_OBJPREPOSITION_OBJPREPOSITION_2);
					}
				}

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (objPreposition != null) {
					qPos.add(objPreposition);
				}

				list = (List<Insult>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Insult>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBJPREPOSITION,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first insult in the ordered set where objPreposition = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param objPreposition the obj preposition to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching insult
	 * @throws com.liferay.lig.NoSuchInsultException if a matching insult could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Insult findByObjPreposition_First(String objPreposition,
		OrderByComparator orderByComparator)
		throws NoSuchInsultException, SystemException {
		List<Insult> list = findByObjPreposition(objPreposition, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("objPreposition=");
			msg.append(objPreposition);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchInsultException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last insult in the ordered set where objPreposition = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param objPreposition the obj preposition to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching insult
	 * @throws com.liferay.lig.NoSuchInsultException if a matching insult could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Insult findByObjPreposition_Last(String objPreposition,
		OrderByComparator orderByComparator)
		throws NoSuchInsultException, SystemException {
		int count = countByObjPreposition(objPreposition);

		List<Insult> list = findByObjPreposition(objPreposition, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("objPreposition=");
			msg.append(objPreposition);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchInsultException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the insults before and after the current insult in the ordered set where objPreposition = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param insultId the primary key of the current insult
	 * @param objPreposition the obj preposition to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next insult
	 * @throws com.liferay.lig.NoSuchInsultException if a insult with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Insult[] findByObjPreposition_PrevAndNext(long insultId,
		String objPreposition, OrderByComparator orderByComparator)
		throws NoSuchInsultException, SystemException {
		Insult insult = findByPrimaryKey(insultId);

		Session session = null;

		try {
			session = openSession();

			Insult[] array = new InsultImpl[3];

			array[0] = getByObjPreposition_PrevAndNext(session, insult,
					objPreposition, orderByComparator, true);

			array[1] = insult;

			array[2] = getByObjPreposition_PrevAndNext(session, insult,
					objPreposition, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Insult getByObjPreposition_PrevAndNext(Session session,
		Insult insult, String objPreposition,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INSULT_WHERE);

		if (objPreposition == null) {
			query.append(_FINDER_COLUMN_OBJPREPOSITION_OBJPREPOSITION_1);
		}
		else {
			if (objPreposition.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OBJPREPOSITION_OBJPREPOSITION_3);
			}
			else {
				query.append(_FINDER_COLUMN_OBJPREPOSITION_OBJPREPOSITION_2);
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

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (objPreposition != null) {
			qPos.add(objPreposition);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(insult);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Insult> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the insults.
	 *
	 * @return the insults
	 * @throws SystemException if a system exception occurred
	 */
	public List<Insult> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the insults.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of insults to return
	 * @param end the upper bound of the range of insults to return (not inclusive)
	 * @return the range of insults
	 * @throws SystemException if a system exception occurred
	 */
	public List<Insult> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the insults.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of insults to return
	 * @param end the upper bound of the range of insults to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of insults
	 * @throws SystemException if a system exception occurred
	 */
	public List<Insult> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Insult> list = (List<Insult>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;
				String sql = null;

				if (orderByComparator != null) {
					query = new StringBundler(2 +
							(orderByComparator.getOrderByFields().length * 3));

					query.append(_SQL_SELECT_INSULT);

					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);

					sql = query.toString();
				}
				else {
					sql = _SQL_SELECT_INSULT;
				}

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Insult>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Insult>)QueryUtil.list(q, getDialect(), start,
							end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Insult>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the insults where groupId = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupId(long groupId) throws SystemException {
		for (Insult insult : findByGroupId(groupId)) {
			remove(insult);
		}
	}

	/**
	 * Removes all the insults where adjectiveOne = &#63; from the database.
	 *
	 * @param adjectiveOne the adjective one to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByAdjectiveOne(String adjectiveOne)
		throws SystemException {
		for (Insult insult : findByAdjectiveOne(adjectiveOne)) {
			remove(insult);
		}
	}

	/**
	 * Removes all the insults where directObject = &#63; from the database.
	 *
	 * @param directObject the direct object to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByDirectObject(String directObject)
		throws SystemException {
		for (Insult insult : findByDirectObject(directObject)) {
			remove(insult);
		}
	}

	/**
	 * Removes all the insults where adjectiveTwo = &#63; from the database.
	 *
	 * @param adjectiveTwo the adjective two to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByAdjectiveTwo(String adjectiveTwo)
		throws SystemException {
		for (Insult insult : findByAdjectiveTwo(adjectiveTwo)) {
			remove(insult);
		}
	}

	/**
	 * Removes all the insults where objPreposition = &#63; from the database.
	 *
	 * @param objPreposition the obj preposition to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByObjPreposition(String objPreposition)
		throws SystemException {
		for (Insult insult : findByObjPreposition(objPreposition)) {
			remove(insult);
		}
	}

	/**
	 * Removes all the insults from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Insult insult : findAll()) {
			remove(insult);
		}
	}

	/**
	 * Counts all the insults where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the number of matching insults
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(2);

				query.append(_SQL_COUNT_INSULT_WHERE);

				query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

				String sql = query.toString();

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
	 * Filters by the user's permissions and counts all the insults where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the number of matching insults that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroupId(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		Session session = null;

		try {
			session = openSession();

			StringBundler query = new StringBundler(2);

			query.append(_FILTER_SQL_COUNT_INSULT_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
					Insult.class.getName(), _FILTER_COLUMN_PK,
					_FILTER_COLUMN_USERID, groupId);

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
	 * Counts all the insults where adjectiveOne = &#63;.
	 *
	 * @param adjectiveOne the adjective one to search with
	 * @return the number of matching insults
	 * @throws SystemException if a system exception occurred
	 */
	public int countByAdjectiveOne(String adjectiveOne)
		throws SystemException {
		Object[] finderArgs = new Object[] { adjectiveOne };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ADJECTIVEONE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(2);

				query.append(_SQL_COUNT_INSULT_WHERE);

				if (adjectiveOne == null) {
					query.append(_FINDER_COLUMN_ADJECTIVEONE_ADJECTIVEONE_1);
				}
				else {
					if (adjectiveOne.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_ADJECTIVEONE_ADJECTIVEONE_3);
					}
					else {
						query.append(_FINDER_COLUMN_ADJECTIVEONE_ADJECTIVEONE_2);
					}
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (adjectiveOne != null) {
					qPos.add(adjectiveOne);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ADJECTIVEONE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the insults where directObject = &#63;.
	 *
	 * @param directObject the direct object to search with
	 * @return the number of matching insults
	 * @throws SystemException if a system exception occurred
	 */
	public int countByDirectObject(String directObject)
		throws SystemException {
		Object[] finderArgs = new Object[] { directObject };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DIRECTOBJECT,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(2);

				query.append(_SQL_COUNT_INSULT_WHERE);

				if (directObject == null) {
					query.append(_FINDER_COLUMN_DIRECTOBJECT_DIRECTOBJECT_1);
				}
				else {
					if (directObject.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_DIRECTOBJECT_DIRECTOBJECT_3);
					}
					else {
						query.append(_FINDER_COLUMN_DIRECTOBJECT_DIRECTOBJECT_2);
					}
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (directObject != null) {
					qPos.add(directObject);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DIRECTOBJECT,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the insults where adjectiveTwo = &#63;.
	 *
	 * @param adjectiveTwo the adjective two to search with
	 * @return the number of matching insults
	 * @throws SystemException if a system exception occurred
	 */
	public int countByAdjectiveTwo(String adjectiveTwo)
		throws SystemException {
		Object[] finderArgs = new Object[] { adjectiveTwo };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ADJECTIVETWO,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(2);

				query.append(_SQL_COUNT_INSULT_WHERE);

				if (adjectiveTwo == null) {
					query.append(_FINDER_COLUMN_ADJECTIVETWO_ADJECTIVETWO_1);
				}
				else {
					if (adjectiveTwo.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_ADJECTIVETWO_ADJECTIVETWO_3);
					}
					else {
						query.append(_FINDER_COLUMN_ADJECTIVETWO_ADJECTIVETWO_2);
					}
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (adjectiveTwo != null) {
					qPos.add(adjectiveTwo);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ADJECTIVETWO,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the insults where objPreposition = &#63;.
	 *
	 * @param objPreposition the obj preposition to search with
	 * @return the number of matching insults
	 * @throws SystemException if a system exception occurred
	 */
	public int countByObjPreposition(String objPreposition)
		throws SystemException {
		Object[] finderArgs = new Object[] { objPreposition };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_OBJPREPOSITION,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(2);

				query.append(_SQL_COUNT_INSULT_WHERE);

				if (objPreposition == null) {
					query.append(_FINDER_COLUMN_OBJPREPOSITION_OBJPREPOSITION_1);
				}
				else {
					if (objPreposition.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_OBJPREPOSITION_OBJPREPOSITION_3);
					}
					else {
						query.append(_FINDER_COLUMN_OBJPREPOSITION_OBJPREPOSITION_2);
					}
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (objPreposition != null) {
					qPos.add(objPreposition);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_OBJPREPOSITION,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the insults.
	 *
	 * @return the number of insults
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

				Query q = session.createQuery(_SQL_COUNT_INSULT);

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
	 * Initializes the insult persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.lig.model.Insult")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Insult>> listenersList = new ArrayList<ModelListener<Insult>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Insult>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	@BeanReference(type = InsultPersistence.class)
	protected InsultPersistence insultPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_INSULT = "SELECT insult FROM Insult insult";
	private static final String _SQL_SELECT_INSULT_WHERE = "SELECT insult FROM Insult insult WHERE ";
	private static final String _SQL_COUNT_INSULT = "SELECT COUNT(insult) FROM Insult insult";
	private static final String _SQL_COUNT_INSULT_WHERE = "SELECT COUNT(insult) FROM Insult insult WHERE ";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "insult.groupId = ?";
	private static final String _FINDER_COLUMN_ADJECTIVEONE_ADJECTIVEONE_1 = "insult.adjectiveOne IS NULL";
	private static final String _FINDER_COLUMN_ADJECTIVEONE_ADJECTIVEONE_2 = "insult.adjectiveOne = ?";
	private static final String _FINDER_COLUMN_ADJECTIVEONE_ADJECTIVEONE_3 = "(insult.adjectiveOne IS NULL OR insult.adjectiveOne = ?)";
	private static final String _FINDER_COLUMN_DIRECTOBJECT_DIRECTOBJECT_1 = "insult.directObject IS NULL";
	private static final String _FINDER_COLUMN_DIRECTOBJECT_DIRECTOBJECT_2 = "insult.directObject = ?";
	private static final String _FINDER_COLUMN_DIRECTOBJECT_DIRECTOBJECT_3 = "(insult.directObject IS NULL OR insult.directObject = ?)";
	private static final String _FINDER_COLUMN_ADJECTIVETWO_ADJECTIVETWO_1 = "insult.adjectiveTwo IS NULL";
	private static final String _FINDER_COLUMN_ADJECTIVETWO_ADJECTIVETWO_2 = "insult.adjectiveTwo = ?";
	private static final String _FINDER_COLUMN_ADJECTIVETWO_ADJECTIVETWO_3 = "(insult.adjectiveTwo IS NULL OR insult.adjectiveTwo = ?)";
	private static final String _FINDER_COLUMN_OBJPREPOSITION_OBJPREPOSITION_1 = "insult.objPreposition IS NULL";
	private static final String _FINDER_COLUMN_OBJPREPOSITION_OBJPREPOSITION_2 = "insult.objPreposition = ?";
	private static final String _FINDER_COLUMN_OBJPREPOSITION_OBJPREPOSITION_3 = "(insult.objPreposition IS NULL OR insult.objPreposition = ?)";
	private static final String _FILTER_SQL_SELECT_INSULT_WHERE = "SELECT DISTINCT {insult.*} FROM insults_Insult insult WHERE ";
	private static final String _FILTER_SQL_COUNT_INSULT_WHERE = "SELECT COUNT(DISTINCT insult.insultId) AS COUNT_VALUE FROM insults_Insult insult WHERE ";
	private static final String _FILTER_COLUMN_PK = "insult.insultId";
	private static final String _FILTER_COLUMN_USERID = "insult.userId";
	private static final String _FILTER_ENTITY_ALIAS = "insult";
	private static final String _ORDER_BY_ENTITY_ALIAS = "insult.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Insult exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Insult exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(InsultPersistenceImpl.class);
}