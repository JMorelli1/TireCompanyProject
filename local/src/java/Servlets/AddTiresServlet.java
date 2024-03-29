/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Business.Customer;
import Business.TireList;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author morel
 */
@WebServlet(name = "AddTiresServlet", urlPatterns = {"/AddTiresServlet"})
public class AddTiresServlet extends HttpServlet {

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
            RequestDispatcher rdCheckout = request.getRequestDispatcher("checkout.jsp");
            RequestDispatcher rdError = request.getRequestDispatcher("login.jsp");
            
            String loginError = "AddTires";
            
            TireList filteredList;
            TireList checkoutList;
            Customer customer = (Customer)session.getAttribute("customer");
            
            //If Else: checks if there is a customer logged in and redirects user to login
            if(customer == null){
                session.setAttribute("loginError", loginError);
                rdError.forward(request, response);
            }
            else{
            //If Else : checks if there is already session data on the filtered list
            if(session.getAttribute("filteredList") == null){
                filteredList = (TireList)session.getAttribute("tireSearchList");
            }
            else{
                filteredList = (TireList)session.getAttribute("filteredList");
            }
            
            //If Else : checks if there is already session data on the checkout list
            if(session.getAttribute("checkoutList") == null){
                checkoutList = new TireList();
            }
            else{
                checkoutList = (TireList)session.getAttribute("checkoutList");
            }
            
            String [] selectedTires = request.getParameterValues("selectedTires");
            String [] quantities = request.getParameterValues("quantity");
            ArrayList<String> outOfStock = new ArrayList<>();
            
            for(int i = 0; i < filteredList.listSize(); i++){
                for(String selectedTiresElement: selectedTires){
                    if(filteredList.getTire(i).getStockID().equals(selectedTiresElement)){
                        int x = Integer.parseInt(quantities[i]);
                            filteredList.getTire(i).setQuantity(x);
                            checkoutList.addItem(filteredList.getTire(i));
                    }
                }
            }
            session.setAttribute("checkoutList", checkoutList);
            rdCheckout.forward(request, response);
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
