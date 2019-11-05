/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Elijah Badger
 */
@WebServlet(name = "customerProfileServlet", urlPatterns = {"/customerProfileServlet"})
public class customerProfileServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                System.out.println("Starting customer profile servlet....");
                HttpSession session = request.getSession();
                ServletContext context = getServletContext();
                Customer c = (Customer) session.getAttribute("customer");
                System.out.println("Double checking vlaues for customer object."); //Test code. Remove from final product.
                System.out.println("---"); //Test code. Remove from final product.
                c.display();

                c.setAddress(request.getParameter("addr_field"));
                c.setCreditCardInfo(request.getParameter("cardnumber_field"));
                c.setExpireDate(request.getParameter("expire_field"));
                c.setFN(request.getParameter("fname_field"));
                c.setLN(request.getParameter("lname_field"));
                c.setPassword(request.getParameter("password_field"));
                c.setPhone(request.getParameter("phone_field"));
                c.setSecurityCode(request.getParameter("security_field"));
                c.setUsername(request.getParameter("username_field"));

                c.display();
                c.updateCustomer();

                session.setAttribute("customer", c);
                RequestDispatcher rd = context.getRequestDispatcher("/edit_customer_profile.jsp");
                rd.forward(request, response);
            } catch (Exception e) {
                System.out.println("Crash in customer profile servlet." + e); //Test code. Remove from final product.
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
