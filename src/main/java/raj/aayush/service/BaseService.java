package raj.aayush.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import raj.aayush.dao.BaseDao;

public abstract class BaseService<E extends Serializable> {
	private BaseDao<E> baseDao;
	
	public BaseService(BaseDao<E> baseDao) {
		super();
		this.baseDao = baseDao;
	}

	public E findById(Long id) {
		return baseDao.findById( id);
	}
	public E byIdLoad(Long id) {
		return baseDao.byIdLoad(id);
	}
	public Optional<E> byIdLoadOptional(Long id) {
		return baseDao.byIdLoadOptional(id);
	}
	
	public List<E> findAll() {
		return baseDao.findAll();
	}

	public void merge(E entity) {
		baseDao.merge( entity);
	}

	public void update(E entity) {
		baseDao.update( entity);
	}

	public void delete(E entity) {
		baseDao.delete(entity);
	}

	public void deleteById(Long entityId) {
		baseDao.deleteById( entityId);
	}

	public Integer create(E entity) {
		return baseDao.create( entity);
	}

	public void persist(E entity) {
		baseDao.persist(entity);
	}

	public BaseDao<E> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao<E> baseDao) {
		this.baseDao = baseDao;
	}
}
