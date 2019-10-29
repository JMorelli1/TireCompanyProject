package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class create_005faccount_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Your Home Page</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <h1>Tires R' Us</h1>\r\n");
      out.write("        <ul>\r\n");
      out.write("            <a href=\"index.html\"><li>Home Page</li></a>\r\n");
      out.write("            <a href=\"about.jsp\"><li>Help</li></a>\r\n");
      out.write("        </ul>\r\n");
      out.write("        <h1>Enter Your Details Below</h1>\r\n");
      out.write("        <form action=\"http://localhost:8080/TiresRUs/CreateCustomerAcct\" method=\"post\">\r\n");
      out.write("\r\n");
      out.write("            <table>\r\n");
      out.write("                <tr><td>Username:</td><td>\r\n");
      out.write("                        <input type = \"text\" name = \"username_field\" value = \"\" /></td>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>Password:</td>\r\n");
      out.write("                    <td><input type = \"text\" name = \"password_field\" value = \"\" /></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr><td>First Name:</td>\r\n");
      out.write("                    <td><input type = \"text\" name = \"fname_field\" value = \"\" /></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr><td>Last Name:</td>\r\n");
      out.write("                    <td><input type = \"text\" name = \"lname_field\" value = \"\" /></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr><td>Address:</td>\r\n");
      out.write("                    <td><input type = \"text\" name = \"addr_field\" value = \"\" /></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr><td>Phone Number:</td>\r\n");
      out.write("                    <td><input type = \"text\" name = \"phone_field\" value = \"\" /></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr><td>Credit/Debit Card Number:</td>\r\n");
      out.write("                    <td><input type = \"text\" name = \"cardnumber_field\" value = \"\" /></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr><td>Expiration Date:</td>\r\n");
      out.write("                    <td><input type = \"text\" name = \"expire_field\" value = \"\" /></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr><td>Security Code:</td>\r\n");
      out.write("                    <td><input type = \"text\" name = \"security_field\" value = \"\" /></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("            <input type=\"submit\" value=\"Done\">\r\n");
      out.write("        </form>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
