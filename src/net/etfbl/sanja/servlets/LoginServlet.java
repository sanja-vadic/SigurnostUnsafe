package net.etfbl.sanja.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.etfbl.sanja.dto.User;
import net.etfbl.sanja.mysql.UserMySql;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			System.out.println(new UserMySql().checkCredentials("admin", "p@sswor"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		UserMySql userMySql = new UserMySql();

		User user = null;
		try {
			user = userMySql.checkCredentials(username, password);

			if (user != null) {
				response.getWriter().print("Uspjesno ste se ulogovali. Dobrodosli, " + user.getFirstname());
			} else {
				response.getWriter().print("Pogresni kredencijali");
			}
		} catch (Exception e) {
			response.getWriter().print(e.getMessage());
			e.printStackTrace();
		}
	}

}
