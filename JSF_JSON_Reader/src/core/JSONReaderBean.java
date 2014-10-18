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

	// array to store the result
	public ArrayList<Customer> list = new ArrayList<Customer>();

	public ArrayList<Customer> getList() {
		return list;
	}

	public void setList(ArrayList<Customer> list) {
		this.list = list;
	}

	public void init() {
		try {
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader("c:\\test.json"));
			JSONObject jsonObject = (JSONObject) obj;

			System.out.println("File found!");

			Customer c = new Customer();

			ArrayList<String> temp = new ArrayList<String>();

			long id = (Long) jsonObject.get("id");
			System.out.println(id);

			// loop array
			//JSONArray names = (JSONArray) jsonObject.get("name");

			/*
			 * Iterator<String> iterator = names.iterator(); while
			 * (iterator.hasNext()) { System.out.println(iterator.next());
			 * temp.add(iterator.next()); }
			 */

			// get an array from the JSON object
			JSONArray names = (JSONArray) jsonObject.get("name");

			// take the elements of the json array
			for (int i = 0; i < names.size(); i++) {
				System.out.println("The " + i + " element of the array: "
						+ names.get(i));
				temp.add(""+names.get(i));
			}

			/*// take each value from the json array separately
			Iterator i = names.iterator();
			while (i.hasNext()) {
				JSONObject innerObj = (JSONObject) i.next();
				System.out.println("language " + innerObj.get("lang");
						//+ " with level " + innerObj.get("knowledge"));
			}*/

			String surname = (String) jsonObject.get("surname");
			System.out.println(surname);

			long salary = (Long) jsonObject.get("salary");
			System.out.println(salary);

			c.setId((int) id);
			c.setNames(temp);
			c.setSurname(surname);
			c.setSalary((int) salary);

			list.add(c);

			// System.out.println(c.toString());
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
