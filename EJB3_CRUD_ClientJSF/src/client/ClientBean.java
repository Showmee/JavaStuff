package client;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import core.EmployeeManagerRemote;
import core.EmployeeManagerService;

/**
 * 
 * @author @MiloszWadas
 *
 */
@ManagedBean(name ="ejbBean")
@SessionScoped
public class ClientBean {
	
	private String status;
	
	
	public ClientBean(){
		
	}

	public void init() {

		EmployeeManagerService webService = new EmployeeManagerService();
		
		System.out.println("________________________________________________________");
		System.out.println("Port: "+webService.getEmployeeManagerPort());
		System.out.println("Service Name: "+webService.getServiceName());
		System.out.println("WSDL location: "+webService.getWSDLDocumentLocation());
		System.out.println("________________________________________________________");
		EmployeeManagerRemote serviceInterface = webService.getEmployeeManagerPort();
		
		//System.out.println(serviceInterface.sayHello("@MiloszWadas"));
		//String temp = "";
		//System.out.println( temp = serviceInterface.sayHello("@MiloszWadas"));
		serviceInterface.addEmployee("Robert", "Nomad", 25000);
		System.out.println("addEmplyee");
		//setOutput(temp);
	}
	

	/* get & set */
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
