package raj.aayush.service.impl;

import java.util.List;
import java.util.Optional;

import raj.aayush.dao.BaseDao;
import raj.aayush.entities.Employee;
import raj.aayush.service.BaseService;
import raj.aayush.service.EmpService;

public class EmpServiceImpl extends BaseService<Employee> implements EmpService {
	public EmpServiceImpl(BaseDao<Employee> baseDao) {
		super(baseDao);
	}

	public Employee byIdLoad(Long id) {
		return super.byIdLoad(id);
	}
	public Optional<Employee> byIdLoadOptional(Long id) {
		return super.byIdLoadOptional(id);
	}
	
	public Employee findById(Long id) {
		return super.findById(id);
	}

	public List<Employee> findAll() {
		return super.findAll();
	}

	public void merge(Employee emp) {
		super.merge(emp);
	}

	public void update(Employee emp) {
		super.update(emp);
	}

	public void delete(Employee emp) {
		super.delete(emp);
	}

	public void deleteById(Long empId) {
		super.deleteById(empId);
	}

	public Integer create(Employee emp) {
		return super.create(emp);
	}

	public void persist(Employee emp) {
		super.persist(emp);
	}

}
