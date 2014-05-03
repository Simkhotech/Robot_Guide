package by.bstu.robotics.servlets;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.bstu.robotics.excursions.Excursion;
import by.bstu.robotics.excursions.Exhibit;

/**
 * Servlet implementation class config
 */
public class Config extends HttpServlet {
	private static final String EXCURSION_ATTRIBUTE = "Excursion";
	private static final String CHANGE_USE_ATTARIBUTE = "Change_use";
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Config() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();

		if (request.getParameter(CHANGE_USE_ATTARIBUTE) != null) {
			int Change_use = Integer.parseInt( (String) request.getParameter(CHANGE_USE_ATTARIBUTE) );

			Excursion excursion_ = (Excursion) session.getAttribute(EXCURSION_ATTRIBUTE);

			excursion_.getExhibit(Change_use)
					.setUse(!(excursion_.getExhibit(Change_use).getUse()));

			session.setAttribute(EXCURSION_ATTRIBUTE, excursion_);
		}

		Enumeration enumeration = session.getAttributeNames();
		StringBuilder stringBuilder = new StringBuilder("<table border=\"1\">");

		while (enumeration.hasMoreElements()) {
			String field = (String) enumeration.nextElement();
			try {
				String value = (String) session.getAttribute(field);

				stringBuilder.append("<tr><td>")
							.append(field)
							.append("</td><td>")
							.append(value)
							.append("</td></tr>");
			} catch (ClassCastException e) {
				stringBuilder
							.append("<tr><td></td><td>class: ")
							.append(session.getAttribute(field).getClass().getName())
							.append("</td></tr>");
				if (session.getAttribute(field) instanceof Excursion) {
					Excursion excursion = (Excursion) session
							.getAttribute(field);
					for (Exhibit exhibit : excursion.getExhibits()) {
						stringBuilder.append("<tr><td>")
							.append(exhibit.getName())
							.append("</td><td>class: ")
							.append(exhibit.getDescription())
							.append("</td></tr><tr><td>Use: ")
							.append("" + exhibit.getUse())
							.append("</td><td><form name=\"\" method=\"get\" action=\"/Guide/Config\">")
							.append("<input type=\"submit\" value=\"")
							.append(exhibit.getId())
							.append("\" name=\"")
							.append(CHANGE_USE_ATTARIBUTE)
							.append("\"></form></td></tr>");
					}
				}
			}
		}

		stringBuilder.append("</table><a href=\"/Guide/Config\">Refresh</a>");

		enumeration = request.getAttributeNames();

		while (enumeration.hasMoreElements()) {
			String field = (String) enumeration.nextElement();
			String value = (String) request.getAttribute(field);

			stringBuilder.append(field + " = " + value + "<br/>");

		}
		
		request.setAttribute("Table", stringBuilder.toString());
		
		request.getRequestDispatcher("/WEB-INF/configPage.jsp").forward(request, response);

		// super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(req, resp);
	}
}
