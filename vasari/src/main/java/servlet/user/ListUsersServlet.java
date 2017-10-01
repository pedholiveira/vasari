package servlet.user;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.UserService;

@WebServlet("/admin/listUsers")
public class ListUsersServlet extends HttpServlet {

	private static final long serialVersionUID = -4027159295798624286L;

	@Inject
	private UserService service;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> users = service.list();
		req.setAttribute("users", users);

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/pages/admin/list-users.jsp");
        rd.forward(req, resp);
	}
	
}
