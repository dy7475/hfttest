package com.myfun.repository.mongodb.support.repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.BasicMongoPersistentEntity;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.MappingMongoEntityInformation;
import org.springframework.data.solr.core.query.result.ScoredPage;
import org.springframework.data.util.ClassTypeInformation;
import org.springframework.util.Assert;

import com.github.pagehelper.PageInfo;

public abstract class BaseMongoRepository<T, ID extends Serializable> implements MongoRepository<T, ID> {
	private final MongoEntityInformation<T, ID> entityInformation;

	public BaseMongoRepository() {
		entityInformation = new MappingMongoEntityInformation<>(
				new BasicMongoPersistentEntity<T>(ClassTypeInformation.from(getEntityClass())));
	}

	public Class<T> getEntityClass() {
		Class<T> entityClass = null;
		try {
			entityClass = resolveReturnedClassFromGernericType();
		} catch (Exception e) {
			throw new InvalidDataAccessApiUsageException("Unable to resolve EntityClass. Please use according setter!",
					e);
		}
		return entityClass;
	}

	@SuppressWarnings("unchecked")
	private Class<T> resolveReturnedClassFromGernericType() {
		ParameterizedType parameterizedType = resolveReturnedClassFromGernericType(getClass());
		return (Class<T>) parameterizedType.getActualTypeArguments()[0];
	}

	private ParameterizedType resolveReturnedClassFromGernericType(Class<?> clazz) {
		Object genericSuperclass = clazz.getGenericSuperclass();
		if (genericSuperclass instanceof ParameterizedType) {
			ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
			Type rawtype = parameterizedType.getRawType();
			if (BaseMongoRepository.class.equals(rawtype)) {
				return parameterizedType;
			}
		}
		return resolveReturnedClassFromGernericType(clazz.getSuperclass());
	}

	public abstract MongoTemplate getMongoTemplate();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.data.repository.CrudRepository#save(java.lang.Object)
	 */
	public <S extends T> S save(S entity) {

		Assert.notNull(entity, "Entity must not be null!");

		getMongoTemplate().save(entity, entityInformation.getCollectionName());

		return entity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.data.repository.CrudRepository#save(java.lang.
	 * Iterable)
	 */
	public <S extends T> List<S> save(Iterable<S> entities) {

		Assert.notNull(entities, "The given Iterable of entities not be null!");

		List<S> result = convertIterableToList(entities);

		for (S entity : result) {
			save(entity);
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.data.repository.CrudRepository#findOne(java.io.
	 * Serializable)
	 */
	public T findOne(ID id) {
		Assert.notNull(id, "The given id must not be null!");
		return getMongoTemplate().findById(id, entityInformation.getJavaType(), entityInformation.getCollectionName());
	}

	private Query getIdQuery(Object id) {
		return new Query(getIdCriteria(id));
	}

	private Criteria getIdCriteria(Object id) {
		return where(entityInformation.getIdAttribute()).is(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.data.repository.CrudRepository#exists(java.io.
	 * Serializable)
	 */
	public boolean exists(ID id) {

		Assert.notNull(id, "The given id must not be null!");
		return getMongoTemplate().exists(getIdQuery(id), entityInformation.getJavaType(),
				entityInformation.getCollectionName());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.data.repository.CrudRepository#count()
	 */
	public long count() {
		return getMongoTemplate().getCollection(entityInformation.getCollectionName()).count();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.data.repository.CrudRepository#delete(java.io.
	 * Serializable)
	 */
	public void delete(ID id) {
		Assert.notNull(id, "The given id must not be null!");
		getMongoTemplate().remove(getIdQuery(id), entityInformation.getJavaType(),
				entityInformation.getCollectionName());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.data.repository.CrudRepository#delete(java.lang.
	 * Object)
	 */
	public void delete(T entity) {
		Assert.notNull(entity, "The given entity must not be null!");
		delete(entityInformation.getId(entity));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.data.repository.CrudRepository#delete(java.lang.
	 * Iterable)
	 */
	public void delete(Iterable<? extends T> entities) {

		Assert.notNull(entities, "The given Iterable of entities not be null!");

		for (T entity : entities) {
			delete(entity);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.data.repository.CrudRepository#deleteAll()
	 */
	public void deleteAll() {
		getMongoTemplate().remove(new Query(), entityInformation.getCollectionName());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.data.repository.CrudRepository#findAll()
	 */
	public List<T> findAll() {
		return findAll(new Query());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.data.repository.CrudRepository#findAll(java.lang.
	 * Iterable)
	 */
	public Iterable<T> findAll(Iterable<ID> ids) {

		Set<ID> parameters = new HashSet<ID>(tryDetermineRealSizeOrReturn(ids, 10));
		for (ID id : ids) {
			parameters.add(id);
		}

		return findAll(new Query(new Criteria(entityInformation.getIdAttribute()).in(parameters)));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.data.repository.PagingAndSortingRepository#findAll(
	 * org.springframework.data.domain.Pageable)
	 */
	public Page<T> findAll(final Pageable pageable) {

		Long count = count();
		List<T> list = findAll(new Query().with(pageable));

		return new PageImpl<T>(list, pageable, count);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.data.repository.PagingAndSortingRepository#findAll(
	 * org.springframework.data.domain.Sort)
	 */
	public List<T> findAll(Sort sort) {
		return findAll(new Query().with(sort));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.data.mongodb.repository.MongoRepository#insert(java.
	 * lang.Object)
	 */
	@Override
	public <S extends T> S insert(S entity) {

		Assert.notNull(entity, "Entity must not be null!");

		getMongoTemplate().insert(entity, entityInformation.getCollectionName());
		return entity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.data.mongodb.repository.MongoRepository#insert(java.
	 * lang.Iterable)
	 */
	@Override
	public <S extends T> List<S> insert(Iterable<S> entities) {

		Assert.notNull(entities, "The given Iterable of entities not be null!");

		List<S> list = convertIterableToList(entities);

		if (list.isEmpty()) {
			return list;
		}

		getMongoTemplate().insertAll(list);
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.data.mongodb.repository.MongoRepository#
	 * findAllByExample(org.springframework.data.domain.Example,
	 * org.springframework.data.domain.Pageable)
	 */
	@Override
	public <S extends T> Page<S> findAll(Example<S> example, Pageable pageable) {

		Assert.notNull(example, "Sample must not be null!");

		Query q = new Query(new Criteria().alike(example)).with(pageable);

		long count = getMongoTemplate().count(q, example.getProbeType(), entityInformation.getCollectionName());

		if (count == 0) {
			return new PageImpl<S>(Collections.<S> emptyList());
		}

		return new PageImpl<S>(
				getMongoTemplate().find(q, example.getProbeType(), entityInformation.getCollectionName()), pageable,
				count);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.data.mongodb.repository.MongoRepository#
	 * findAllByExample(org.springframework.data.domain.Example,
	 * org.springframework.data.domain.Sort)
	 */
	@Override
	public <S extends T> List<S> findAll(Example<S> example, Sort sort) {

		Assert.notNull(example, "Sample must not be null!");

		Query q = new Query(new Criteria().alike(example));

		if (sort != null) {
			q.with(sort);
		}

		return getMongoTemplate().find(q, example.getProbeType(), entityInformation.getCollectionName());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.data.mongodb.repository.MongoRepository#
	 * findAllByExample(org.springframework.data.domain.Example)
	 */
	@Override
	public <S extends T> List<S> findAll(Example<S> example) {
		return findAll(example, (Sort) null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.data.repository.query.QueryByExampleExecutor#findOne(
	 * org.springframework.data.domain.Example)
	 */
	@Override
	public <S extends T> S findOne(Example<S> example) {

		Assert.notNull(example, "Sample must not be null!");

		Query q = new Query(new Criteria().alike(example));
		return getMongoTemplate().findOne(q, example.getProbeType(), entityInformation.getCollectionName());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.data.repository.query.QueryByExampleExecutor#count(
	 * org.springframework.data.domain.Example)
	 */
	@Override
	public <S extends T> long count(Example<S> example) {

		Assert.notNull(example, "Sample must not be null!");

		Query q = new Query(new Criteria().alike(example));
		return getMongoTemplate().count(q, example.getProbeType(), entityInformation.getCollectionName());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.data.repository.query.QueryByExampleExecutor#exists(
	 * org.springframework.data.domain.Example)
	 */
	@Override
	public <S extends T> boolean exists(Example<S> example) {

		Assert.notNull(example, "Sample must not be null!");

		Query q = new Query(new Criteria().alike(example));
		return getMongoTemplate().exists(q, example.getProbeType(), entityInformation.getCollectionName());
	}

	private List<T> findAll(Query query) {

		if (query == null) {
			return Collections.emptyList();
		}

		return getMongoTemplate().find(query, entityInformation.getJavaType(), entityInformation.getCollectionName());
	}

	private static <T> List<T> convertIterableToList(Iterable<T> entities) {

		if (entities instanceof List) {
			return (List<T>) entities;
		}

		int capacity = tryDetermineRealSizeOrReturn(entities, 10);

		if (capacity == 0 || entities == null) {
			return Collections.<T> emptyList();
		}

		List<T> list = new ArrayList<T>(capacity);
		for (T entity : entities) {
			list.add(entity);
		}

		return list;
	}

	private static int tryDetermineRealSizeOrReturn(Iterable<?> iterable, int defaultSize) {
		return iterable == null ? 0
				: (iterable instanceof Collection) ? ((Collection<?>) iterable).size() : defaultSize;
	}

	/**
	 * 分页 临时用 可能存在性能问题
	 * 
	 * @param page
	 * @param query
	 * @return
	 */
	public com.github.pagehelper.Page<T> findPage(Query query) {
		com.github.pagehelper.Page<T> page = new com.github.pagehelper.Page<T>((query.getSkip() / query.getLimit())+1, query.getLimit());
		long count = getMongoTemplate().count(query, getEntityClass());
		page.setTotal(count);
		
		List<T> list = findAll(query);

		page.addAll(list);

		return page;
	}

}
