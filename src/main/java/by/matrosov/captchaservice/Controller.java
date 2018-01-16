package by.matrosov.captchaservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/page")
public class Controller extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("page/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String captcha = req.getSession().getAttribute("captcha_security").toString();
        String verifyCaptcha = req.getParameter("captcha");
        if (captcha.equals(verifyCaptcha)){
            req.setAttribute("username", req.getParameter("username"));
            req.setAttribute("password", req.getParameter("password"));
            req.getRequestDispatcher("page/success.jsp").forward(req,resp);
        }else {
            req.setAttribute("error", "Captcha Invalid");
            req.getRequestDispatcher("page/index.jsp").forward(req,resp);
        }
    }
}
