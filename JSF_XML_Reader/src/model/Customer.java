package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {
	
	String name, surname;
	int id, salary;
	
	public String getName() {
		return name;
	}
	
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	@XmlElement
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public int getId() {
		return id;
	}
	
	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}
	
	public int getSalary() {
		return salary;
	}
	
	@XmlElement
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString(){
		return "Customer [name: "+name+", surname: "+surname+", salary: "+salary+"]";
		
	}
	
}
