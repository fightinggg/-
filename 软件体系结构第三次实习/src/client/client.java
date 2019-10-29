package client;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.regex.Pattern;




public class client {
    public static String sendEmail(String _url, String _payload, String type) {
        if (type.equals("rest")) return rest.sendEmail(_url, _payload);
        else return soap.sendEmail(_url, _payload);
    }

    public static String sendEmailBatch(String _url, String _payload, String type) {
        if (type.equals("rest")) return rest.sendEmailBatch(_url, _payload);
        else return soap.sendEmailBatch(_url, _payload);
    }

    public static String validateEmailAddress(String _url,String type) {
        if (type.equals("rest")) return rest.validateEmailAddress(_url);
        else return soap.validateEmailAddress(_url);
    }
}