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

import enumeration.CategoryEnum;
import model.User;
import service.UserService;

@WebServlet("/student/listStudents")
public class ListStudents extends HttpServlet {

	private static final long serialVersionUID = 4659856368058498094L;

	@Inject
	private UserService service;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> users = service.list(CategoryEnum.STUDENT);
		req.setAttribute("users", users);

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/pages/student/list-students.jsp");
        rd.forward(req, resp);
	}
	
}
