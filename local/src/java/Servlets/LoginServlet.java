/************************************************************************************
 *@author James Morelli
 * Tire Project: Login Servlet
 * Created: 10/30/19
 ***********************************************************************************/ 
package Servlets;

import Business.Admin;
import Business.Customer;
import Business.DBAccess;
import Business.Shipper;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
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
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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
            HttpSession session; 
            DBAccess database = new DBAccess();
            session = request.getSession();
            boolean loginedIn = false;
            
            RequestDispatcher rdCustomer = request.getRequestDispatcher("/customer_homepage.jsp");
            RequestDispatcher rdAdmin = request.getRequestDispatcher("/admin_homepage.jsp");
            RequestDispatcher rdShipper = request.getRequestDispatcher("/shipper_homepage.jsp");
            RequestDispatcher rdErrorPage = request.getRequestDispatcher("/login.jsp");
            RequestDispatcher rdCrashPage = request.getRequestDispatcher("/error_page.jsp");
            
            String username = request.getParameter("username");
            String password = request.getParameter("pass");
            
            ResultSet users = database.checkUserNames();
            
            try{
                while(users.next()){
                    if(username.equals(users.getString("Username")) && password.equals(users.getString("Password"))){
                        if(users.getString("EmployeeID").startsWith("5")){
                            Admin admin = new Admin();
                            admin.selectDB(username);
                            session.setAttribute("admin", admin);
                            rdAdmin.forward(request, response);
                            loginedIn = true;
                        }
                        else if(users.getString("EmployeeID").startsWith("7")){
                            Customer customer = new Customer();
                            customer.selectCustomerUsername(username);
                            session.setAttribute("customer", customer);
                            rdCustomer.forward(request, response);
                            loginedIn = true;
                        }
                        else if(users.getString("EmployeeID").startsWith("9")){
                            Shipper shipper = new Shipper();
                            shipper.selectDB(username);
                            session.setAttribute("shipper", shipper);
                            rdShipper.forward(request, response);
                            loginedIn = true;
                        }
                    }
                }
                if(loginedIn == false){
                   String loginError = "true";
                   session.setAttribute("loginError", loginError);
                   rdErrorPage.forward(request, response); 
                }
            }
            catch(SQLException e){
                System.out.println("Error logging in: " + e);
                rdCrashPage.forward(request, response);
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
