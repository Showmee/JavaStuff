package client;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import webservices.HelloWorldRemote;
import webservices.HelloWorldService;

@ManagedBean(name = "clientBean")
@SessionScoped
public class ClientBean {

	private String output;

	public void init() {

		HelloWorldService webService = new HelloWorldService();
		HelloWorldRemote serviceInterface = webService.getHelloWorldPort();

		//System.out.println(serviceInterface.sayHello("@MiloszWadas"));
		String temp = "";
		System.out.println( temp = serviceInterface.sayHello("@MiloszWadas"));
		setOutput(temp);
	}
	
	
	/* getters n setters */
	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

}
