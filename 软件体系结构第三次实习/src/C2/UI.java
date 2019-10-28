package C2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Client.*;


import javax.swing.*;

public class UI extends JFrame {

    void check(String s) {
        System.out.println(s);
        if (s.equals("Y")) JOptionPane.showMessageDialog(null, "成功", "提示", JOptionPane.PLAIN_MESSAGE);
        else JOptionPane.showMessageDialog(null, "失败", "提示", JOptionPane.PLAIN_MESSAGE);
    }

    public UI() {
        JPanel jp1 = new JPanel();
        jp1.add(new JLabel("邮箱"));
        TextField t1 = new TextField(20);
        jp1.add(t1);

        JPanel jp2 = new JPanel();
        jp2.add(new JLabel("正文"));
        TextField t2 = new TextField(20);
        jp2.add(t2);

        JPanel jp3 = new JPanel();
        Button b1 = new Button("发送");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Emailservice emailservice = new EmailserviceService().getEmailservicePort();
                check(emailservice.sendEmail(t1.getText(), t2.getText()));
            }
        });
        Button b2 = new Button("批量发送");
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Emailservice emailservice = new EmailserviceService().getEmailservicePort();
                String[] s = t1.getText().split(",");
                List<String> tmp = new ArrayList<String>(Arrays.asList(s));
                check(emailservice.sendEmailBatch(tmp, t2.getText()));
            }
        });
        Button b3 = new Button("检测邮箱");
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Emailservice emailservice = new EmailserviceService().getEmailservicePort();
                check(emailservice.validateEmailAddress(t1.getText()));
            }
        });

        jp3.add(b1);
        jp3.add(b2);
        jp3.add(b3);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);

        this.setLayout(new GridLayout(3, 1));
        this.setSize(350, 250);
        this.setTitle("email");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new UI();
    }
}