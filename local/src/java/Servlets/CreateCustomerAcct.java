package Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Business.Customer;
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
@WebServlet(urlPatterns = {"/CreateCustomerAcct"})
public class CreateCustomerAcct extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            try {
                HttpSession session = request.getSession();
                
                ServletContext context = getServletContext();
                Customer customer = new Customer();
                int newId = customer.countCustomers() + 7001;
                customer.setCID(Integer.toString(newId));
                customer.setAddress(request.getParameter("addr_field"));
                customer.setCreditCardInfo(request.getParameter("cardnumber_field"));
                customer.setExpireDate(request.getParameter("expire_field"));
                customer.setFN(request.getParameter("fname_field"));
                customer.setLN(request.getParameter("lname_field"));
                customer.setPassword(request.getParameter("password_field"));
                customer.setPhone(request.getParameter("phone_field"));
                customer.setSecurityCode(request.getParameter("security_field"));
                customer.setUsername(request.getParameter("username_field"));
                
                customer.insertCustomer();
                
                session.setAttribute("customer", customer);
                RequestDispatcher rd = context.getRequestDispatcher("/customer_homepage.jsp");
                rd.forward(request, response);

            } catch (Exception e) {
                System.out.println("Crash in createAccount for customer servlet. " + e);
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
