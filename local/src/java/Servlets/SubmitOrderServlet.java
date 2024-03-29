/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Business.TireList;
import Business.Order;
import Business.Customer;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author morel
 */
@WebServlet(name = "SubmitOrderServlet", urlPatterns = {"/SubmitOrderServlet"})
public class SubmitOrderServlet extends HttpServlet {

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
            
            HttpSession session = request.getSession();
            RequestDispatcher rdCompleted = request.getRequestDispatcher("customer_homepage.jsp");
            RequestDispatcher rdFailed = request.getRequestDispatcher("orderfailed.jsp");
            String orderStatus;
            
            
            TireList checkoutList = (TireList)session.getAttribute("checkoutList");
            Customer customer = (Customer)session.getAttribute("customer");
            Order newOrder = new Order();
            
            try{
            newOrder.insertNewOrderDB(customer.getCID(), "Processing");
            newOrder.insertOrderedItems(checkoutList);
            orderStatus = "completed";
            checkoutList.tireList.clear();
            session.setAttribute("checkoutList", checkoutList);
            session.setAttribute("orderStatus", orderStatus);
            rdCompleted.forward(request, response);
            }
            catch(Exception e){
                rdFailed.forward(request, response);
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
