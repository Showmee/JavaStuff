package client;

import webservices.HelloWorldRemote;
import webservices.HelloWorldService;

public class ClientBean {
	public static void main(String[] args) {

		HelloWorldService webService = new HelloWorldService();
		HelloWorldRemote serviceInterface = webService.getHelloWorldPort();

		System.out.println(serviceInterface.sayHello("@MiloszWadas"));
	 }
}
