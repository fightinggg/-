package Controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.getChangeRate;
import Dao.getMaxValue;
import Dao.getMinValue;
import Dao.getMoney;

/**
 * Servlet implementation class HandleQuery
 */
@WebServlet("/HandleQuery")
public class HandleQuery extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleQuery() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String queryName = request.getParameter("Selecttion");
        List<Double> list = null;
        System.out.println(queryName);
        try {
            if (queryName.equals("最高价(元)")) {
                Class<?> g = Class.forName("Dao.getMaxValue");
                getMaxValue o = (getMaxValue) g.newInstance();
                request.setAttribute("list", o.get());
                request.getRequestDispatcher("/maxValue.jsp").forward(request, response);
            } else if (queryName.equals("最低价(元)")) {
                Class<?> g = Class.forName("Dao.getMinValue");
				getMinValue o = (getMinValue) g.newInstance();
                request.setAttribute("list", o.get());
                request.getRequestDispatcher("/minValue.jsp").forward(request, response);
            } else if (queryName.equals("换手率(%)")) {
                Class<?> g = Class.forName("Dao.getChangeRate");
				getChangeRate o = (getChangeRate) g.newInstance();
                request.setAttribute("list", o.get());
                request.getRequestDispatcher("/changeRate.jsp").forward(request, response);
            } else if (queryName.equals("成交金额(元)")) {
                Class<?> g = Class.forName("Dao.getMoney");
				getMoney o = (getMoney) g.newInstance();
                request.setAttribute("list", o.get());
                request.getRequestDispatcher("/money.jsp").forward(request, response);
            }
            response.getWriter().append("Served at: ").append(request.getContextPath());
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
