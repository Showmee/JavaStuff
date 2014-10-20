package webservices;

import javax.ejb.Remote;
import javax.jws.WebService;

@Remote
@WebService
public interface HelloWorldRemote {

	String sayHello(String str);
}
