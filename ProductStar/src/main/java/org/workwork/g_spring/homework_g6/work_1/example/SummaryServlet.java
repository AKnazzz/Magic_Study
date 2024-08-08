package org.workwork.g_spring.homework_g6.work_1.example;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.workwork.g_spring.homework_g6.work_1.example.model.Id;
import org.workwork.g_spring.homework_g6.work_1.example.model.Transaction;
import org.workwork.g_spring.homework_g6.work_1.example.model.Type;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class SummaryServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        var context = config.getServletContext();
        context.log("[SummaryServlet] init");

        var salary = Integer.parseInt(context.getInitParameter("salary"));
        var rent = Integer.parseInt(config.getInitParameter("rent"));

        context.setAttribute("freeMoney", salary - rent);
        Map<Id, Transaction> transactions = new LinkedHashMap<>();
        transactions.put(new Id(), new Transaction(Type.EXPENSE, "rent", rent));
        context.setAttribute("transactions", transactions);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var context = req.getServletContext();
        context.log("[SummaryServlet] doGet");

        var session = req.getSession(false);
        if (session == null) {
            resp.getWriter().println("Not authorized");
            return;
        }

        req.getRequestDispatcher("/details").include(req, resp);
        resp.getWriter().println("\nFree money: " + context.getAttribute("freeMoney"));
    }

}
