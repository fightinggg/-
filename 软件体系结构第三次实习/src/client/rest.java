package client;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


public class rest {
    public static String sendEmail(String _url, String _payload) {
        Client client = ClientBuilder.newClient();
        WebTarget roottarget = client.target("http://localhost:8080/service/rest");
        WebTarget sendEmailtarget = roottarget.path("/sendEmail");//创建一个子资源URI
        WebTarget sendEmailtargetWithQueryParam = sendEmailtarget.queryParam("_url", _url).queryParam("_payload", _payload);
        System.out.println(sendEmailtargetWithQueryParam.getUri());
        Invocation.Builder invocationBuilder = sendEmailtargetWithQueryParam.request(MediaType.TEXT_PLAIN_TYPE);
        invocationBuilder.header("some-header", "true");
        Response response = invocationBuilder.get();
        response.getStatus();
        return response.readEntity(String.class);
    }

    public static String sendEmailBatch(String _url, String _payload) {
        Client client = ClientBuilder.newClient();
        WebTarget roottarget = client.target("http://localhost:8080/service/rest");
        WebTarget sendEmailtarget = roottarget.path("/sendEmailBatch");//创建一个子资源URI
        WebTarget sendEmailtargetWithQueryParam = sendEmailtarget.queryParam("_url", _url).queryParam("_payload", _payload);
        Invocation.Builder invocationBuilder = sendEmailtargetWithQueryParam.request(MediaType.TEXT_PLAIN_TYPE);
        invocationBuilder.header("some-header", "true");
        Response response = invocationBuilder.get();
        response.getStatus();
        return response.readEntity(String.class);
    }

    public static String validateEmailAddress(String _url) {
        Client client = ClientBuilder.newClient();
        WebTarget sendEmailtarget = client.target("http://localhost:8080/service/rest/validateEmailAddress");
        WebTarget sendEmailtargetWithQueryParam = sendEmailtarget.queryParam("_url", _url);
        Invocation.Builder invocationBuilder = sendEmailtargetWithQueryParam.request(MediaType.TEXT_PLAIN_TYPE);
        invocationBuilder.header("some-header", "true");
        Response response = invocationBuilder.get();
        response.getStatus();
        return response.readEntity(String.class);
    }
}
