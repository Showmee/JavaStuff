package core;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Employee;

@WebService
@SOAPBinding(style = Style.RPC)
@Stateless
public class EmployeeManager implements EmployeeManagerRemote{
	private EntityManager em;
	
	public EmployeeManager(){
		
	}
	
	@WebMethod
	public void addEmployee(String name, String surname, int salary){
		Employee emp = new Employee();
		emp.setFirst_name(name);
		emp.setLast_name(surname);
		emp.setSalary(salary);
		
		em.persist(emp);
		System.out.println("Employee added to DB!");
	};
	
	public void removeEmployee(){
		
	}
	
	public Employee raiseSalary(){
		return null;
	}
	
	public Employee findEmployee(int id){
		return em.find(Employee.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Employee> findAllEmployees() {
	    Query query = em.createQuery("SELECT e FROM Employee e");
	    return (Collection<Employee>) query.getResultList();
	  }

	
	
}
