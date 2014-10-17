package core;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;


import java.util.Iterator;

import model.Customer;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


@ManagedBean(name = "Jbean")
@SessionScoped
/**
 * @author Milosz Wadas
 */
public class JSONReaderBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//array to store the result
	public ArrayList<Customer> list = new ArrayList<Customer>();
	
	public ArrayList<Customer> getList() {
		return list;
	}

	public void setList(ArrayList<Customer> list) {
		this.list = list;
	}

	public void init() {
		
		JSONParser parser = new JSONParser();
		
		try {
			Object obj = parser.parse(new FileReader("c:\\file.json"));
			System.out.println("File found!");
			
			Customer c = new Customer();
			JSONObject jsonObject = (JSONObject) obj;
			ArrayList<String> temp = new ArrayList<String>();
			
			long id = (Long) jsonObject.get("id");
			System.out.println(id);
			
			// loop array
			JSONArray names = (JSONArray) jsonObject.get("name");
			
			Iterator<String> iterator = names.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
				temp.add(iterator.next());
			}
			
			String surname = (String) jsonObject.get("surname");
			System.out.println(surname);
			
			long salary = (Long) jsonObject.get("salary");
			System.out.println(salary);
			
			c.setId((int)id);
			c.setNames(temp);
			c.setSurname(surname);
			c.setSalary((int)salary);
			
			list.add(c);
			
			//System.out.println(c.toString());
			setList(list);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
}
