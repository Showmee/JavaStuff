package model;

import java.util.ArrayList;

public class Customer {
	
	ArrayList<String> names = new ArrayList<String>();
	String surname;
	int id, salary;
	
	public ArrayList<String> getNames() {
		return names;
	}
	public void setNames(ArrayList<String> names) {
		this.names = names;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	
	
	/*@Override
	public String toString(){
		return "Customer [name: "+name+", surname: "+surname+", salary: "+salary+"]";
		
	}*/
	
}
