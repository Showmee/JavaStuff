package core;

import java.util.ArrayList;

import model.Employee;



public class EmployeeBean {
	
	private ArrayList<Employee> list = new ArrayList<Employee>();
	
	
	
	public EmployeeBean(){
		
	}

	/* getters & setters */
	public ArrayList<Employee> getList() {
		return list;
	}
	public void setList(ArrayList<Employee> list) {
		this.list = list;
	}	
}
