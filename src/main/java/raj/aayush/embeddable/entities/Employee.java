package raj.aayush.embeddable.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="employee_table_embd")
@DynamicUpdate
public class Employee  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 26136341162481290L;

	@Id
	@Column(name="employee_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long employeeId;
	
	@Column(name="employee_name",length=200,nullable=false)
	private String employeeName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="date_of_joing")
	private Date doj;
	
	@Column(name="salary")
	private Double salary;

	@Column(name="bonus")
	private BigDecimal bonus;
	
	@Column(name="designation",length=50)
	private String designation;
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	 
	@ElementCollection
	@JoinTable(name="address_table",joinColumns=@JoinColumn(name="employee_id"))
	private Collection<Address> addressList = new HashSet<>();
	
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	public Collection<Address> getAddressList() {
		return addressList;
	}
	public void setAddressList(Collection<Address> addressList) {
		this.addressList = addressList;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", email=" + email + ", doj="
				+ doj + ", salary=" + salary + "]";
	}
	
	public BigDecimal getBonus() {
		return bonus;
	}
	public void setBonus(BigDecimal bonus) {
		this.bonus = bonus;
	}
}
