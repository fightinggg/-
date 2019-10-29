package client;

import soapclient.Soap;
import soapclient.SoapService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class soap {

    static Soap emailservice = new SoapService().getSoapPort();

    public static String sendEmail(String _url, String _payload) {
        return emailservice.sendEmail(_url, _payload);
    }

    public static String sendEmailBatch(String _url, String _payload) {
        return emailservice.sendEmailBatch(_url, _payload);
    }

    public static String validateEmailAddress(String _url) {
        return emailservice.validateEmailAddress(_url);
    }
}
