package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Business.TireList;

public final class tireSearch_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"stylesheet.css\"/>\n");
      out.write("        \n");
      out.write("        <title>Tire Search Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            TireList list = new TireList();
            list = list.generateTireList(true);
            
            
      out.write("\n");
      out.write("        <div id = \"interiorbox\">\n");
      out.write("        <h1>Tire Search Page</h1>\n");
      out.write("        <nav>\n");
      out.write("            <ul>\n");
      out.write("                <li><a href=\"index.html\">Home</a></li>\n");
      out.write("                <li><a href=\"tireSearch.jsp\">Tire Search</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </nav>\n");
      out.write("        \n");
      out.write("            <div class=\"wrapper\">\n");
      out.write("                <table>\n");
      out.write("            <tr>\n");
      out.write("                <th>Tire ID</th>\n");
      out.write("                <th>Tire Type</th>\n");
      out.write("                <th>Size of Tire</th>\n");
      out.write("                <th>Brand</th>\n");
      out.write("                <th>Stock Amount</th>\n");
      out.write("                <th>Price</th>\n");
      out.write("                <th>Vehicle Type</th>\n");
      out.write("            </tr>\n");
      out.write("\t\t");

                for(int i=0; i<list.listSize(); i++){
                    
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print(list.tireList.get(i).getStockID());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(list.tireList.get(i).getType());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(list.tireList.get(i).getSize());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(list.tireList.get(i).getBrand());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(list.tireList.get(i).getStock());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(list.tireList.get(i).getPrice());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(list.tireList.get(i).getVehicleType());
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("                    ");

                     }
                    
      out.write("\n");
      out.write("                </table>\n");
      out.write("                <div class=\"lowerpad\"></div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
