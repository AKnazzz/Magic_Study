package org.workwork.g_spring.homework_g5.hw;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.productstar.servlets.model.Transaction;
import ru.productstar.servlets.model.TransactionType;

import java.io.IOException;
import java.util.ArrayList;

public class SummaryServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        var context = config.getServletContext();
        var salary = Integer.valueOf(context.getInitParameter("salary"));
        var rent = Integer.valueOf(config.getInitParameter("rent"));

        context.setAttribute("freeMoney", salary - rent);
        context.setAttribute("transactions",  new ArrayList<Transaction>() {
            { add(new Transaction(TransactionType.EXPENSE, "rent", rent)); }
        });
        context.log("[SummaryServlet] Init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            var context = req.getServletContext();

            var session = req.getSession(false);
            if (session == null) {
                resp.getWriter().println("Not authorized");
                return;
            }
            req.getRequestDispatcher("/details").include(req, resp);
            int freeMoney = (int)context.getAttribute("freeMoney");

            context.log("[SummaryServlet] Free money: " + freeMoney);
            resp.getWriter().println("Free money: " + freeMoney);
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }
}
