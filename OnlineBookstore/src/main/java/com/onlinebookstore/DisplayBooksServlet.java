package com.onlinebookstore;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.onlinebookstore.DBConnectionManager;

@WebServlet("/displayBooks")
public class DisplayBooksServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1>Book List</h1>");
        out.println("<table border='1'>");
        out.println("<tr><th>ID</th><th>Title</th><th>Author</th><th>Price</th></tr>");

        try (Connection connection = new DBConnectionManager().openConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Books")) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                double price = resultSet.getDouble("price");

                out.println("<tr>");
                out.println("<td>" + id + "</td>");
                out.println("<td>" + title + "</td>");
                out.println("<td>" + author + "</td>");
                out.println("<td>" + price + "</td>");
                out.println("</tr>");
            }

        } catch (Exception e) {
            e.printStackTrace();
            out.println("<p>Error fetching books: " + e.getMessage() + "</p>");
        }

        
        out.println("</table>");
        out.println("</body></html>");
    }
}
