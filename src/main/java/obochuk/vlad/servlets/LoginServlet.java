package obochuk.vlad.servlets;


import obochuk.vlad.DBAccess.DBWorker;
import obochuk.vlad.DBAccess.loginException.WrongPasswordException;
import obochuk.vlad.DBAccess.loginException.WrongUsernameException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public final class LoginServlet extends HttpServlet{
    public LoginServlet(){}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("userName");
        String password = req.getParameter("userPassword");
        PrintWriter writer = resp.getWriter();

        DBWorker worker = new DBWorker();

        try {
            Integer id = worker.validate(name, password);
            resp.addCookie(new Cookie("id", id.toString()));
            resp.sendRedirect(req.getContextPath() + "/");
        }catch (WrongUsernameException e){
            RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/login.jsp");
            req.setAttribute("message", "Wrong username!");
            dispatcher.include(req, resp);
        }
        catch (WrongPasswordException e){
            RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/login.jsp");
            req.setAttribute("message", "Wrong password!");
            dispatcher.include(req, resp);
        }
    }
}