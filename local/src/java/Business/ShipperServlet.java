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
@WebServlet(name = "ShipperServlet", urlPatterns = {"/ShipperServlet"})
public class ShipperServlet extends HttpServlet {

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
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            System.out.println("Starting login servlet (for Shipper)....");
            HttpSession session;
            ServletContext context = getServletContext();
            String uid = request.getParameter("username");
            System.out.println("Username captured."); //Test code. Remove from final product.
            String upw = request.getParameter("pass");
            System.out.println("Password captured."); //Test code. Remove from final product.            
            Shipper s = new Shipper();
            System.out.println("Shipper obj created. Data fields: "); //Test code. Remove from final product.
            s.selectDB(uid);
            s.display();
            if (s.getPassword().equals(upw)) {
                session = request.getSession();
                session.setAttribute("shipper", s);
                RequestDispatcher rd = context.getRequestDispatcher("/shipper_homepage.jsp");
                rd.forward(request, response);
            } else {
                session = request.getSession();
                session.setAttribute("shipper", s);
                RequestDispatcher rd = context.getRequestDispatcher("/error_page.jsp");
                rd.forward(request, response);
            }
            session = request.getSession();
            session.setAttribute("shipper", s);
        } catch (Exception e) {
            System.out.println("Crash in ShipperServlet. " + e);
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
