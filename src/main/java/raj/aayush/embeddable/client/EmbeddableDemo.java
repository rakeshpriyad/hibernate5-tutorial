package raj.aayush.embeddable.client;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import raj.aayush.dao.BaseDao;
import raj.aayush.embeddable.dao.impl.EmpDaoImpl;
import raj.aayush.embeddable.entities.Address;
import raj.aayush.embeddable.entities.Employee;
import raj.aayush.embeddable.service.EmpService;
import raj.aayush.embeddable.service.impl.EmpServiceImpl;
import raj.aayush.util.HibernateUtil;

public class EmbeddableDemo {

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
	
	public static Employee getEmployee(Integer i){
		Employee employee= new Employee();
		employee.setEmployeeName("Barry Bingel"+i);
		employee.setEmail("barry"+ i +".cs2017@gmail.com");
		employee.setSalary(50000.00);
		employee.setDoj(new Date());
		
		Address address1 = new Address();
		address1.setCity("Chennai");
		address1.setPincode(9087727L);
		address1.setState("Tamilnadu");
		address1.setStreet("Park Street");
		
		Address address2 = new Address();
		address2.setCity("Pune");
		address2.setPincode(90870988L);
		address2.setState("MH");
		address2.setStreet("XYZ Street");
		
		employee.getAddressList().add(address1);
		employee.getAddressList().add(address2);
		
		return employee;
	}
}
