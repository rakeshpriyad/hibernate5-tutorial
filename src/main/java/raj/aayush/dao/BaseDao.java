package raj.aayush.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;

public abstract class BaseDao<E extends Serializable> {
	private Class<E> clazz;

	public BaseDao(Session session, Class<E> clazz) {
		this.session = session;
		this.clazz = clazz;
	}

	private Session session;

	public Session getSession() {
		return this.session;
	}

	public E findById(Long id) {
		return session.get(clazz, id);
	}

	public E byIdLoad(Long id) {
		return session.byId(clazz).load(id);
	}
	public Optional<E> byIdLoadOptional(Long id) {
		return session.byId(clazz).loadOptional(id);
	}
	
	@SuppressWarnings("unchecked")
	public List<E> findAll() {
		return session.createQuery("from " + clazz.getName()).list();
	}
	
	

	public void merge(E entity) {
		session.beginTransaction();
		session.merge(entity);
		session.getTransaction().commit();
	}

	public void update(E entity) {
		session.beginTransaction();
		session.update(entity);
		session.getTransaction().commit();
	}

	public void delete(E entity) {
		session.beginTransaction();
		session.delete(entity);
		session.getTransaction().commit();
	}

	public void deleteById(Long entityId) {
		E entity = findById(entityId);
		delete(entity);
	}

	public Integer create(E entity) {
		session.beginTransaction();
		Integer id = (Integer) session.save(entity);
		System.out.println("Entity is created  with Id::" + id);
		session.getTransaction().commit();
		return id;
	}

	public void persist(E entity) {
		session.beginTransaction();
		session.persist(entity);
		session.getTransaction().commit();
	}

}
