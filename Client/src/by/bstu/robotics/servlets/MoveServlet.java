package by.bstu.robotics.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.bstu.robotics.Robot.Constants;
import by.bstu.robotics.Robot.GlobalPoint;
import by.bstu.robotics.Robot.Robot;
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

		Exhibit exhibit = excursion.getExhibits().get(0);

		request.setAttribute("Description", exhibit.getDescription());
		request.setAttribute("imgURL", exhibit.getImgURL());
		request.setAttribute("audioURL", exhibit.getAudioURL());

		excursion.removeExhibit(0);
		
		Robot robot = new Robot(Constants.HOSTNAME);
		robot.run(new GlobalPoint(exhibit.getX(), exhibit.getY(), 0, -1f, Constants.ACCESS_WALL_DISTANCE, Constants.ACCESS_WALL_DISTANCE, -1f));
		        
		request.getRequestDispatcher("/WEB-INF/Excursion.jsp").forward(request, response);
				return;
			}
//		}
//		if (!use) {
//			request.getRequestDispatcher("/WEB-INF/MovePage.jsp").forward(request,
//					response);
//		}
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher("/WEB-INF/MovePage.jsp").forward(request,
				response);
	}
}
