package by.bstu.robotics.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;


public class PermissionTag extends SimpleTagSupport {
    private String role;

    public String getRole() {
            return role;
    }

    public void setRole(String role) {
            this.role = role;
    }

    @Override
    public void doTag() throws JspException, IOException {
            PageContext pageContext = (PageContext) getJspContext();
            HttpServletRequest request = (HttpServletRequest) pageContext
                            .getRequest();
            if(request.getSession().getAttribute("role")==null)
                    request.getSession().setAttribute("role", "");
            if (request.getSession().getAttribute("role").equals("ROLE_ADMIN")) {
                    getJspBody().invoke(null);
            }
    }

}
