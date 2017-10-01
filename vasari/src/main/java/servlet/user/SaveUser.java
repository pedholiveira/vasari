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
import utils.ServletUtils;

@WebServlet("/admin/saveUser")
public class SaveUser extends HttpServlet {

	private static final long serialVersionUID = -3072710822164312689L;

	@Inject
	private UserService service;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User();
		String parameterId = req.getParameter("id");
		if(parameterId != null) {
			user = service.find(Long.valueOf(parameterId));
		}
		
		req.setAttribute("user", user);
		req.setAttribute("categories", CategoryEnum.values());
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/pages/admin/form-user.jsp");
        rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = ServletUtils.getObjectFromRequest(req, User.class);
		String parameterId = req.getParameter("id");
		if(!parameterId.equals("")) {
			user.setId(Long.valueOf(req.getParameter("id"))); //TODO - Passar id para o utilitário
		}
		service.save(user);
		
		resp.sendRedirect(req.getContextPath() + "/admin/listUsers");
	}
}
