package raj.aayush.client;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import raj.aayush.dao.BaseDao;
import raj.aayush.dao.impl.EmpDaoImpl;
import raj.aayush.entities.Employee;
import raj.aayush.service.EmpService;
import raj.aayush.service.impl.EmpServiceImpl;
import raj.aayush.util.HibernateUtil;

public class EmpCrudDemo {

	public static void main(String[] args) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			BaseDao<Employee> dao= new EmpDaoImpl(session,Employee.class);
			EmpService empService = new EmpServiceImpl(dao);
			//empService.create(getEmployee(3));
			/*Employee e =empService.findById(1L);
			System.out.println("empname : "+e.getEmployeeName());
			e.setEmployeeName("RRR");
			empService.update(e);
			Employee e1 =empService.findById(1L);
			System.out.println("empname : "+e1.getEmployeeName());*/
			
			List<Employee> empList = empService.findAll();
			System.out.println(empList);
			/*Employee e2 =empService.findById(1L);
			empService.delete(e2);*/
			
			Employee e3 = empService.byIdLoad(2L);
			System.out.println(e3);
			
			Optional<Employee> e4 = empService.byIdLoadOptional(2L);
			System.out.println(e4.isPresent());
			System.out.println(e4.get());

			
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			System.exit(0);
		}
	}
	
	private static Employee getEmployee(Integer i){
		Employee employee= new Employee();
		employee.setEmployeeName("Martin Bingel"+i);
		employee.setEmail("martin"+i+".cs2017@gmail.com");
		employee.setSalary(50000.00);
		employee.setDoj(new Date());
		return employee;
	}
}
