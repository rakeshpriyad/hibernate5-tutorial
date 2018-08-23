package raj.aayush.dao.impl;

import java.util.List;

import org.hibernate.Session;

import raj.aayush.dao.BaseDao;
import raj.aayush.dao.EmpDao;
import raj.aayush.entities.Employee;

public class EmpDaoImpl extends BaseDao<Employee> implements EmpDao<Employee> {
	public EmpDaoImpl(Session session, Class<Employee> clazz) {
		super(session, clazz);
	}

	public Employee findById( Long id) {
		return super.findById(id);
	}

	public List<Employee> findAll(Session session) {
		return super.findAll();
	}

	public void merge( Employee emp) {
		super.merge(emp);
	}

	public void update( Employee emp) {
		super.update(emp);
	}

	public void delete( Employee emp) {
		super.delete(emp);
	}

	public void deleteById( Long empId) {
		super.deleteById(empId);
	}

	public Integer create( Employee emp) {
		return super.create(emp);
	}

	public void persist(Employee emp) {
		super.persist(emp);
	}

}
