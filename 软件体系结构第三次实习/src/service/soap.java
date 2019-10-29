package service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService()
public class soap {
    @WebMethod
    public String validateEmailAddress(String _url) {
        return service.validateEmailAddress(_url);
    }

    @WebMethod
    public String sendEmail(String _url, String _payload) {
        return service.sendEmail(_url, _payload);
    }

    @WebMethod
    public String sendEmailBatch(String _url, String _payload) {
        return service.sendEmailBatch(_url, _payload);
    }

    public static void main(String[] args) {
        String url = "http://localhost:9090/service/soap";
        Endpoint.publish(url, new soap());
        System.out.print("public Success");
    }
}


/*

wsimport -s  /Users/s/Desktop/workspace/java/软件体系结构第三次实习/src  -p soapclient -keep "http://localhost:9090/service/soap?wsdl"



*
* */