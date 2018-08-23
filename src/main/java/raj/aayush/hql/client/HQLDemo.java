package raj.aayush.hql.client;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import raj.aayush.dao.EmpDao;
import raj.aayush.dao.impl.EmpDaoImpl;
import raj.aayush.entities.Employee;
import raj.aayush.service.EmpService;
import raj.aayush.service.impl.EmpServiceImpl;
import raj.aayush.util.HibernateUtil;

public class HQLDemo {

	public static void main(String[] args) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			EmpDao<Employee> dao= new EmpDaoImpl(session,Employee.class);
			EmpService empService = new EmpServiceImpl(dao);
			Employee e = empService.getEmployeeById(2L);
			
			System.out.println("--------Emp Name-----" + e.getEmployeeName());
					
			List<Employee> empList = empService.getAllEmployees();
			System.out.println(empList);
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			System.exit(0);
		}
	}
	
	public static Employee getEmployee(Integer i){
		Employee employee= new Employee();
		employee.setEmployeeName("Martin Bingel"+i);
		employee.setEmail("martin"+i+".cs2017@gmail.com");
		employee.setSalary(50000.00);
		employee.setDoj(new Date());
		return employee;
	}
}
