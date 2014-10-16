package core;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import model.Customer;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "bean")
@SessionScoped
/**
 * @author Milosz Wadas
 */
public class JAXBReaderBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ArrayList<Customer> list = new ArrayList<Customer>();
	
	public ArrayList<Customer> getList() {
		return list;
	}

	public void setList(ArrayList<Customer> list) {
		this.list = list;
	}

	public void init() {
		try {
			File file = new File("C:\\file.xml");
			System.out.println("File found!");
			
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Customer customer = (Customer) jaxbUnmarshaller.unmarshal(file);
			
			//ArrayList<Customer> List = new ArrayList<Customer>();
			list.add(customer);
			
			System.out.println(customer.toString());
			setList(list);
			
		}catch (JAXBException e) {
			System.out.println("Error! File not found!");
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
}
