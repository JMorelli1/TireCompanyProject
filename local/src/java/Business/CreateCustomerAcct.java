/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Business.*;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
                ServletContext context = getServletContext();
                Customer c = new Customer();
                Random r = new Random();
                int random_id = r.nextInt(10000);
                int random_id2 = r.nextInt(9);
                String randomid = Integer.toString(random_id);
                String randomid2 = Integer.toString(random_id);
                c.setCID(randomid);
                c.setAddress(request.getParameter("addr_field"));
                c.setCreditCardInfo(request.getParameter("cardnumber_field"));
                c.setExpireDate(request.getParameter("expire_field"));
                c.setFN(request.getParameter("fname_field"));
                c.setLN(request.getParameter("lname_field"));
                c.setOID(randomid2);
                c.setPassword(request.getParameter("password_field"));
                c.setPhone(request.getParameter("phone_field"));
                c.setSecurityCode(request.getParameter("security_field"));
                c.setUsername(request.getParameter("username_field"));
                
                c.insertDB();
                System.out.println("Account created. moving to new page..."); //Test Code. Remove from final product.
                System.out.println("---"); //Test Code. Remove from final product.
                
                    RequestDispatcher rd = context.getRequestDispatcher("/login.jsp");
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
