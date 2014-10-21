package core;

import javax.ejb.Remote;
import javax.jws.WebService;

@Remote
@WebService
public interface EmployeeManagerRemote {
	void addEmployee(String name, String surname, int salary);
}
