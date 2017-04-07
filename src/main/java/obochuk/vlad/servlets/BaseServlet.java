package obochuk.vlad.servlets;

import obochuk.vlad.DBAccess.DBWorker;
import obochuk.vlad.entites.Result;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class BaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DBWorker worker = new DBWorker();
        Result result = worker.getLastResult();
        req.setAttribute("time", result.getDate());
        req.setAttribute("result", result.getResult());
        List<Integer> winners = worker.findEqual(result.getResult());
        if (winners == null || winners.size() == 0)
            req.setAttribute("text", "Жоден учасник лотореї не вгадав згенерованого числа.");
        else {
            StringBuilder text = new StringBuilder("В результатті проведення розіграшу було виявлено переможців - ").append(winners.size()).append(". Переможці: ");
            for (int id : winners) {
                text.append(worker.getUserName(id)).append(" ");
            }
            req.setAttribute("text", text);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/index.jsp");
        dispatcher.forward(req, resp);
    }
}
