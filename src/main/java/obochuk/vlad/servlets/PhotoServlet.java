package obochuk.vlad.servlets;

import obochuk.vlad.DBAccess.DBWorker;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PhotoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBWorker worker = new DBWorker();
        int id = Integer.parseInt(req.getParameter("id"));
        if (Boolean.valueOf(req.getParameter("crop")))
            resp.getOutputStream().write(worker.getCropedPhoto(id));
        else
            resp.getOutputStream().write(worker.getPhoto(id));
    }
}
