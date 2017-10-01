package servlet.user;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

@WebServlet("/admin/deleteUser")
public class DeleteUser extends HttpServlet {
	
	private static final long serialVersionUID = -1068964964433088320L;

	@Inject
	private UserService service;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long id = Long.valueOf(req.getParameter("id"));
		service.delete(id);
		
		resp.sendRedirect(req.getContextPath() + "/admin/listUsers");
	}
}
