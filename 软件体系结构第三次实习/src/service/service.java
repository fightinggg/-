package service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.regex.Pattern;


public class service {
    public static String sendEmail(String _url, String _payload) {
        return sendEmailBatch(_url, _payload);
    }

    public static String sendEmailBatch(String _url, String _payload) {
        System.out.println("???: "+_url+_payload);
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
            String[] s = _url.split(",");
            InternetAddress[] tmp = new InternetAddress[s.length];
            for (int i = 0; i < s.length; i++) tmp[i] = new InternetAddress(s[i]);
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

    public static String validateEmailAddress(String _url) {
        if (_url == null) return "N";
        String rule = "^[a-zA-Z0-9_]+@[a-zA-Z0-9_]+(\\.[a-zA-Z0-9_]+)+$";
        if (Pattern.compile(rule).matcher(_url).matches()) return "Y";
        else return "N";
    }
}