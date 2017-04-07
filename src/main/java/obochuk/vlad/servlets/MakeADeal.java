package obochuk.vlad.servlets;

import obochuk.vlad.DBAccess.DBWorker;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.CookieStore;

public class MakeADeal extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        Cookie[] cookies = req.getCookies();

        if (cookies != null) {
            int n;
            if ((n = findCookie(cookies, "id")) != -1) {
                int id = Integer.parseInt(cookies[n].getValue());
                if (id == 1) {
                    resp.sendRedirect(req.getContextPath() + "/start");
                    return;
                }
                String number = req.getParameter("number");
                if (number == null) {
                    dispatcher = req.getRequestDispatcher("/pages/deal.jsp");
                    dispatcher.forward(req, resp);
                    return;
                }
                try {
                    int gues = Integer.parseInt(number);
                    DBWorker worker = new DBWorker();
                    worker.setGues(id, gues);
                    req.setAttribute("message", "Вашу ставку прийнято, на наступний розіграш Ваше число = " + gues);
                    dispatcher = req.getRequestDispatcher("/pages/deal.jsp");
                    dispatcher.forward(req, resp);
                    return;
                } catch (Exception e) {
                    req.setAttribute("errMessage", "Введено невірне число, спробуйте ще раз");
                    dispatcher = req.getRequestDispatcher("/pages/deal.jsp");
                    dispatcher.forward(req, resp);
                    return;
                }
            }
        }

        resp.sendRedirect(req.getContextPath() + "/login");
    }

    private int findCookie(Cookie[] cookies, String name){
        int i = 0;
        for(Cookie cookie: cookies){
            if (cookie.getName().equals(name))
                return i;
            i++;
        }
        return -1;
    }
}
