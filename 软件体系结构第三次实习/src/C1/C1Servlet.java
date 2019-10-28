package C1;

import Client.Emailservice;
import Client.EmailserviceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "C1Servlet")
public class C1Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getParameter("url");
        String payload = request.getParameter("payload");
        System.out.println(url+payload);
        Emailservice emailservice = new EmailserviceService().getEmailservicePort();
        String res = emailservice.validateEmailAddress(url);
        if (url.equals("N")) {
            request.getRequestDispatcher("/emailerror.jsp").forward(request,response);
        } else {
            String[] s = url.split(",");
            List<String> tmp = new ArrayList<String>(Arrays.asList(s));
            res=emailservice.sendEmailBatch(tmp,payload);
            if(url.equals("N")){
                request.getRequestDispatcher("/senderror.jsp").forward(request,response);
            }
            else request.getRequestDispatcher("/sendsuccess.jsp").forward(request,response);
        }
    }
}
