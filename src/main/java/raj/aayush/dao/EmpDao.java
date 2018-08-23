package raj.aayush.dao;

import java.util.List;

public interface EmpDao<Employee> {

	public Employee findById(Long id);

	public List<Employee> findAll();

	public void merge(Employee emp);

	public void update(Employee emp);

	public void delete(Employee emp);

	public void deleteById(Long empId);

	public Integer create(Employee emp);

	public void persist(Employee emp);
	
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(Long id) ;

}
