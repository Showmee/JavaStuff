
/*
 * 
 */

package core;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.3.1-patch-01
 * Tue Oct 21 20:16:46 CEST 2014
 * Generated source version: 2.3.1-patch-01
 * 
 */


@WebServiceClient(name = "EmployeeManagerService", 
                  wsdlLocation = "http://localhost:8080/EJB3_CRUD_Example/EmployeeManager?wsdl",
                  targetNamespace = "http://core/") 
public class EmployeeManagerService extends Service {

    public final static URL WSDL_LOCATION;
    public final static QName SERVICE = new QName("http://core/", "EmployeeManagerService");
    public final static QName EmployeeManagerPort = new QName("http://core/", "EmployeeManagerPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/EJB3_CRUD_Example/EmployeeManager?wsdl");
        } catch (MalformedURLException e) {
            System.err.println("Can not initialize the default wsdl from http://localhost:8080/EJB3_CRUD_Example/EmployeeManager?wsdl");
            // e.printStackTrace();
        }
        WSDL_LOCATION = url;
    }

    public EmployeeManagerService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public EmployeeManagerService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EmployeeManagerService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    /*public EmployeeManagerService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }
    public EmployeeManagerService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public EmployeeManagerService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }*/

    /**
     * 
     * @return
     *     returns EmployeeManagerRemote
     */
    @WebEndpoint(name = "EmployeeManagerPort")
    public EmployeeManagerRemote getEmployeeManagerPort() {
        return super.getPort(EmployeeManagerPort, EmployeeManagerRemote.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns EmployeeManagerRemote
     */
    @WebEndpoint(name = "EmployeeManagerPort")
    public EmployeeManagerRemote getEmployeeManagerPort(WebServiceFeature... features) {
        return super.getPort(EmployeeManagerPort, EmployeeManagerRemote.class, features);
    }

}
