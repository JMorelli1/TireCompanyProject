/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;
import Business.TireList;
import Business.Tire;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author morel
 */
@WebServlet(name = "FilterTireSearchServlet", urlPatterns = {"/FilterTireSearchServlet"})
public class FilterTireSearchServlet extends HttpServlet {

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
            
            HttpSession session1;
            session1 = request.getSession();
            
            TireList tl1;
            tl1 = (TireList)session1.getAttribute("tireSearchList");
            
            TireList filteredList = new TireList();
            
            String [] checkedTireBrands = request.getParameterValues("TireBrands");
            String [] checkedPriceRange = request.getParameterValues("PriceRange");
            String [] checkedVehicleType = request.getParameterValues("VehicleType");
            
            RequestDispatcher rdTireSearch = request.getRequestDispatcher("/tireSearch.jsp");
            
        if(checkedTireBrands != null){
            for(int i = 0; i < tl1.listSize();i++){
                for(String checkedTireBrandsElement : checkedTireBrands){
                    if(tl1.getTire(i).getBrand().equals(checkedTireBrandsElement)){
                        filteredList.addItem(tl1.getTire(i));
                    }
                }
//                for(String checkedPriceRangeElement : checkedPriceRange){
//                    if(tl1.getTire(i).getBrand().equals(checkedPriceRangeElement)){
//                        filteredList.addItem(tl1.getTire(i));
//                    }
//                }
//                for(String checkedVehicleTypeElement : checkedVehicleType){
//                    if(tl1.getTire(i).getVehicleType().equals(checkedVehicleTypeElement)){
//                        filteredList.addItem(tl1.getTire(i));
//                    }
//                }
            }
        }
        else{
            filteredList = tl1;
        }
        
            
            session1.setAttribute("filteredList", filteredList);
            rdTireSearch.forward(request, response);
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
