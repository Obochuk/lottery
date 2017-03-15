package obochuk.vlad.servlets;

import obochuk.vlad.DBAccess.DBWorker;
import obochuk.vlad.etc.Images;
import sun.nio.cs.StandardCharsets;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

@MultipartConfig
public class RegisterServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/register.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("userName");
        String userPassword = req.getParameter("userPassword");
        String description = req.getParameter("description");
        Part filePart = req.getPart("photo");
        int x = Integer.parseInt(req.getParameter("x"));
        int y = Integer.parseInt(req.getParameter("y"));
        int w = Integer.parseInt(req.getParameter("w"));
        int h = Integer.parseInt(req.getParameter("h"));


        InputStream fileContent = filePart.getInputStream();
        BufferedImage image = ImageIO.read(fileContent);
        image = Images.scaleImage(image, 450);
        image = image.getSubimage(x, y, w, h);
        InputStream cropedImage = Images.toInputStream(image);
        fileContent = filePart.getInputStream();


        DBWorker worker = new DBWorker();
        Integer id = worker.addUser(username, userPassword, description, fileContent, cropedImage);


        resp.addCookie(new Cookie("id", id.toString()));
        resp.sendRedirect(req.getContextPath() + "/");
    }
}
