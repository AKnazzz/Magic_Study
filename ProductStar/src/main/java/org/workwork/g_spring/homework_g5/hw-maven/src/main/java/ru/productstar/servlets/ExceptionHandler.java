package org.workwork.g_spring.homework_g5.hw;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/exceptionHandler")
public class ExceptionHandler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processError(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processError(req, resp);
    }

    private void processError(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Throwable throwable = (Throwable) req.getAttribute("jakarta.servlet.error.exception");
        Integer statusCode = (Integer) req.getAttribute("jakarta.servlet.error.status_code");

        if (throwable == null && statusCode != 404) {
            resp.sendRedirect("/summary");
        }
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.write("<html><head><title>Exception/Error Details</title></head><body>");
        out.write("Error (" + statusCode + ") ");

        if (statusCode == 404) {
            out.write("- page not found");
        } else {
            out.write(throwable.getLocalizedMessage());
        }

        out.write("<br><br>");
        out.write("<a href=\"/summary\">Home Page</a>");
        out.write("</body></html>");
    }
}
