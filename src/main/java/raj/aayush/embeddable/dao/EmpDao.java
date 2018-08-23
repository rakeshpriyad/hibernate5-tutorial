package raj.aayush.embeddable.dao;

import java.util.List;

import org.hibernate.Session;

import raj.aayush.embeddable.entities.Employee;

public interface EmpDao {

	public Employee findById(Long id);

	public List<Employee> findAll(Session session);

	public void merge(Employee emp);

	public void update(Employee emp);

	public void delete(Employee emp);

	public void deleteById(Long empId);

	public Integer create(Employee emp);

	public void persist(Employee emp);

}
