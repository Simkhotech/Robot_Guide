package by.bstu.robotics.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.bstu.robotics.excursions.Excursion;
import by.bstu.robotics.util.LocalhostDBConnection;


/**
 * Servlet implementation class App
 */
public class App extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LocalhostDBConnection dbConnection;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public App() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		RequestDispatcher dispatcher;
		dbConnection = new LocalhostDBConnection();

		dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/index.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();

		response.setContentType("text/html");

		ArrayList<Excursion> excursions = new ArrayList<Excursion>(//);
		dbConnection.getExcursionCount());

		excursions = dbConnection.getExcursions();

		System.out.println(excursions.toString());
		String name = request.getParameter("name");

		if (name.equals("Ex1")) {
			request.setAttribute("Excursion", excursions.get(0));

			request.getRequestDispatcher("/WEB-INF/MovePage.jsp").forward(request,
					response);
		} else {
			request.setAttribute("Excursion", "Exursion number 2");
			request.getRequestDispatcher("/WEB-INF/Excursion.jsp").forward(
					request, response);
		}

		by.bstu.robotics.util.SessionOverride.setSessionAtributs(request);

	}
}
