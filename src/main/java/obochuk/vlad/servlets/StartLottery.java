package obochuk.vlad.servlets;

import obochuk.vlad.DBAccess.DBWorker;
import obochuk.vlad.etc.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StartLottery extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        if (req.getParameter("start") != null) {
            DBWorker worker = new DBWorker();
            int res = Random.INSTANCE.nextInt();
            worker.addNewResult(res);
            List<Integer> winners = worker.findEqual(res);
            if (winners == null || winners.size() == 0)
                req.setAttribute("result", "Жоден учасник лотореї не вгадав згенерованого числа. Згенероване число = " + res);
            else {
                StringBuilder result = new StringBuilder("В результатті проведення розіграшу було виявлено переможців - ").append(winners.size()).append(". Переможці: ");
                for (int id : winners) {
                    result.append(worker.getUserName(id)).append(" ");
                }
                result.append(". Згенероване число: ").append(res);
                req.setAttribute("result", result);
            }

        }
        dispatcher = req.getRequestDispatcher("/pages/start.jsp");
        dispatcher.forward(req, resp);
    }
}