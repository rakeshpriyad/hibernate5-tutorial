package raj.aayush.embeddable.service;

import java.util.List;
import java.util.Optional;

import raj.aayush.embeddable.entities.Employee;


public interface EmpService {
	public Employee findById(Long id);

	public List<Employee> findAll();

	public void merge(Employee emp);

	public void update(Employee emp);

	public void delete(Employee emp);

	public void deleteById(Long empId);

	public Integer create(Employee emp);

	public void persist(Employee emp);

	public Employee byIdLoad(Long id) ;
	public Optional<Employee> byIdLoadOptional(Long id) ;
}
