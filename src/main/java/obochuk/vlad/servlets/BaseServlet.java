package obochuk.vlad.servlets;

import obochuk.vlad.DBAccess.DBConnector;
import obochuk.vlad.DBAccess.DBWorker;
import obochuk.vlad.entites.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : req.getCookies()) {
                if (cookie.getName().equals("logined"))
                    if (cookie.getValue().equals("true")) {
                        DBWorker worker = new DBWorker();
                        req.setAttribute("result", worker.getAllUsers());
                        dispatcher = req.getRequestDispatcher("/pages/welcome.jsp");
                        dispatcher.forward(req, resp);
                        return;
                    }
            }
        }
        resp.sendRedirect(req.getContextPath() + "/login");
    }
}
