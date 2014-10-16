package core;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.hibernate.mapping.Array;

import model.Customer;

public class JAXBReader {

	public void init() {
		try {
			File file = new File("C:\\file.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Customer customer = (Customer) jaxbUnmarshaller.unmarshal(file);
			
			System.out.println(customer);
			
			ArrayList<Customer> List = new ArrayList<Customer>();
			List.add(customer);
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
}
