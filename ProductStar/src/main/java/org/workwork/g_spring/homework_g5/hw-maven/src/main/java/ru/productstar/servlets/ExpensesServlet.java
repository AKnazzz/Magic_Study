package org.workwork.g_spring.homework_g5.hw;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.productstar.servlets.model.Transaction;
import ru.productstar.servlets.model.TransactionType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExpensesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var context = req.getServletContext();

        var session = req.getSession(false);
        if (session == null) {
            resp.getWriter().println("Not authorized");
            return;
        }

        int freeMoney = (int)context.getAttribute("freeMoney");
        var transactions = new ArrayList<Transaction>((List) context.getAttribute("transactions"));
        try {
            for(var k : req.getParameterMap().keySet()) {
                int value = Integer.parseInt(req.getParameter(k));
                freeMoney -= value;
                transactions.add(new Transaction(TransactionType.EXPENSE, k, value));
            }

            context.setAttribute("transactions", transactions);
            context.setAttribute("freeMoney", freeMoney);
            resp.getWriter().println("Expenses were added");
            resp.sendRedirect("/summary");
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }
}