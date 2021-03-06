package servlet;

import model.User;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeleteServlet", urlPatterns = "/remove")
public class DeleteServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        User user = UserService.getInstance().getUserById(id);
        UserService.getInstance().removeUser(user);
        RequestDispatcher dispatcher = req.getServletContext()
                .getRequestDispatcher("/admin.jsp");
        dispatcher.forward(req, resp);
    }
}
