package service;
import java.util.Properties;
import java.util.regex.Pattern;
import javax.jws.WebMethod;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService()
public class emailservice {
    @WebMethod
    public String validateEmailAddress(String _url) {
        if (_url == null) return "N";
        String rule = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?";
        if (Pattern.compile(rule).matcher(_url).matches()) return "Y";
        else return "N";
    }
    @WebMethod
    public String sendEmail(String _url, String _payload) {
        return sendEmailBatch(new String[]{_url}, _payload);
    }

    @WebMethod
    public String sendEmailBatch(String[] _url, String _payload) {
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");// 连接协议
        properties.put("mail.smtp.host", "smtp.qq.com");// 主机名
        properties.put("mail.smtp.port", 465);// 端口号
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");// 设置是否使用ssl安全连接 ---一般都使用
        properties.put("mail.debug", "true");// 设置是否显示debug信息 true 会在控制台显示相关信息
        Session session = Session.getInstance(properties);
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress("246553278@qq.com"));
            InternetAddress[] tmp = new InternetAddress[_url.length];
            for (int i = 0; i < _url.length; i++) tmp[i] = new InternetAddress(_url[i]);
            message.setRecipients(Message.RecipientType.TO, tmp);
            message.setSubject("自动发送");
            message.setText(_payload);
            Transport transport = session.getTransport();
            transport.connect("246553278@qq.com", "qgftiwslmlxsbhaj");// 密码为QQ邮箱开通的stmp服务后得到的客户端授权码
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException e) {
            e.printStackTrace();
            return "N";
        }
        return "Y";
    }

    public static void main(String[] args) {
        String url = "http://localhost:9090/Service/emailservice";
        Endpoint.publish(url, new emailservice());
        System.out.print("public Success");
    }
}


/*

wsimport -s  /Users/s/Desktop/workspace/java/软件体系结构第三次实习/src  -p Client -keep "http://localhost:9090/Service/emailservice?wsdl"
*
* */