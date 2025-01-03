package com.onlinebookstore.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.onlinebookstore.DBConnectionManager;

@WebServlet("/DeleteBook")
public class DeleteBookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        
        String bookId = request.getParameter("id");
        String message;

        try (Connection connection = new DBConnectionManager().openConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM Books WHERE id = ?")) {

            statement.setInt(1, Integer.parseInt(bookId)); 
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                message = "Book with ID " + bookId + " was successfully deleted.";
            } else {
                message = "Book with ID " + bookId + " not found.";
            }

        } catch (Exception e) {
            e.printStackTrace();
            message = "An error occurred: " + e.getMessage();
        }

        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>" + message + "</h1>");
        response.getWriter().println("</body></html>");
    }
}
