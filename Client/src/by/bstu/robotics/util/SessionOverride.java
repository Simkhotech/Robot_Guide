/**
 * 
 */
package by.bstu.robotics.util;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Simkhotech
 * 
 */
public class SessionOverride {

	public static HttpSession setSessionAtributs(HttpServletRequest request) {
		HttpSession session = request.getSession(true);

		Enumeration enumeration = request.getAttributeNames();

		while (enumeration.hasMoreElements()) {
			String field = (String) enumeration.nextElement();
			session.setAttribute(field, request.getAttribute(field));
		}
		return session;
	}
}
