package by.bstu.robotics.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.bstu.robotics.excursions.Excursion;
import by.bstu.robotics.excursions.Exhibit;

/**
 * Servlet implementation class MoveServlet
 */
public class MoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MoveServlet() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();

		Excursion excursion = (Excursion) session.getAttribute("Excursion");

		boolean use = false;

		for (Exhibit exhibit : excursion.getExhibits()) {
			if (exhibit.getUse()) {
				use = true;
				request.setAttribute("Name", exhibit.getName());
				request.setAttribute("Description", exhibit.getDescription());

				((Excursion) session.getAttribute("Excursion")).getExhibit(
						exhibit.getId()).setUse(false);

				request.getRequestDispatcher("/WEB-INF/Excursion.jsp").forward(
						request, response);
				return;
			}
		}
		if (!use) {
			request.getRequestDispatcher("/WEB-INF/MovePage.jsp").forward(request,
					response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}
}
