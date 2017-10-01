package servlet.user;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enumeration.CategoryEnum;
import model.User;
import service.UserService;
import util.ServletUtils;

@WebServlet("/admin/createUser")
public class CreateUser extends HttpServlet {

	private static final long serialVersionUID = -3285426610177338526L;

	@Inject
	private UserService service;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("categories", CategoryEnum.values());
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/pages/admin/form-user.jsp");
        rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = ServletUtils.getObjectFromRequest(req, User.class);
		service.create(user);
		
		resp.sendRedirect(req.getContextPath() + "/admin/listUsers");
	}
}
