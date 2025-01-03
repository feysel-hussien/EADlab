package com.onlinebookstore.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.onlinebookstore.DBConnectionManager;

@WebServlet("/registerBook")
public class BookRegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DBConnectionManager dbConnectionManager;

    // Constructor for dependency injection
    public BookRegistrationServlet(DBConnectionManager dbConnectionManager) {
        this.dbConnectionManager = dbConnectionManager;
    }

    @Override
    public void init() throws ServletException {
        // Initialize Spring ApplicationContext and inject dependencies
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        this.dbConnectionManager = context.getBean("dbConnectionManager", DBConnectionManager.class);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String title = request.getParameter("title");
        String author = request.getParameter("author");
        double price = Double.parseDouble(request.getParameter("price"));
        String message;

        try (Connection connection = dbConnectionManager.openConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO Books (title, author, price) VALUES (?, ?, ?)")) {

            statement.setString(1, title);
            statement.setString(2, author);
            statement.setDouble(3, price);
            statement.executeUpdate();
            message = "Book registered successfully.";

        } catch (Exception e) {
            e.printStackTrace();
            message = "An error occurred: " + e.getMessage();
        }

        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>" + message + "</h1>");
        response.getWriter().println("</body></html>");
    }
}
