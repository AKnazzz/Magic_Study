package org.workwork.g_spring.homework_g5.hw;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.productstar.servlets.model.Transaction;

import java.io.IOException;
import java.util.List;

public class DetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var context = req.getServletContext();

        try {
            var session = req.getSession(false);
            if (session == null) {
                resp.getWriter().println("Not authorized");
                return;
            }
            resp.getWriter().println("Transactions: ");
            for ( Transaction e : (List<Transaction>) context.getAttribute("transactions")) {
                resp.getWriter().println(e.getSimpleStringValue());
            }
            resp.getWriter().println("\n");
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }
}