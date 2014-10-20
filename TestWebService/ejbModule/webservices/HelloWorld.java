package webservices;


import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@Stateless
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class HelloWorld implements HelloWorldRemote{
 
	@WebMethod 
	public String sayHello(String name){
		return "Hello "+name+ " to my webservice example!";
	};
 
}