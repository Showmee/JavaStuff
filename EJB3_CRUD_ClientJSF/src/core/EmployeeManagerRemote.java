package core;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.3.1-patch-01
 * Tue Oct 21 20:16:46 CEST 2014
 * Generated source version: 2.3.1-patch-01
 * 
 */
 
@WebService(targetNamespace = "http://core/", name = "EmployeeManagerRemote")
@XmlSeeAlso({ObjectFactory.class})
public interface EmployeeManagerRemote {

    @RequestWrapper(localName = "addEmployee", targetNamespace = "http://core/", className = "core.AddEmployee")
    @WebMethod
    @ResponseWrapper(localName = "addEmployeeResponse", targetNamespace = "http://core/", className = "core.AddEmployeeResponse")
    public void addEmployee(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        int arg2
    );
}
