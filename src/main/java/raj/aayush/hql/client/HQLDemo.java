package raj.aayush.hql.client;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import raj.aayush.dao.EmpDao;
import raj.aayush.dao.impl.EmpDaoImpl;
import raj.aayush.entities.Employee;
import raj.aayush.service.EmpService;
import raj.aayush.service.impl.EmpServiceImpl;
import raj.aayush.util.HibernateUtil;

public class HQLDemo {

	public static void main(String[] args) {
		insertEmployeeRecords(HibernateUtil.getSessionFactory());
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
	
	private static void insertEmployeeRecords(SessionFactory sf) {

		try(Session session = sf.openSession() ) {
			
			String HQL = "INSERT INTO raj.aayush.embeddable.entities.Employee(employeeName,doj,salary,bonus,email,designation)"+
			"SELECT employeeName,doj,salary,bonus,email,designation FROM raj.aayush.embeddable.entities.BackupEmployee";
			
			@SuppressWarnings("rawtypes")
			Query query = session.createQuery(HQL);
			session.beginTransaction();
			int executeUpdate = query.executeUpdate();
			if(executeUpdate>0)
				System.out.println(executeUpdate+" records are inserted successfully..");
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
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
