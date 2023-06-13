/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author overw
 */
public class MainServlet extends HttpServlet {

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
            String path = "index.jsp";
            String a = request.getParameter("action");
            if (a == null || a.isEmpty()) {
                path = "index.jsp";
            } else if (a.equals("1")) {
                path = "loginpage.jsp";
            } else if (a.equals("2")) {
                path = "LoginServlet";
            } else if (a.equals("3")) {
                path = "adminpage.jsp";
            } else if (a.equals("4")) {
                path = "userpage.jsp";
            } else if (a.equals("5")) {
                path = "LogoutServlet";
            } else if (a.equals("6")) {
                path = "FindServlet";
            } else if (a.equals("7")) {
                path = "AddToCartServlet";
            } else if (a.equals("8")) {
                path = "ViewCart.jsp";
            } else if (a.equals("9")) {
                // update or remove
                String removeBtn = request.getParameter("btnremove");
                // Khi user click vo nut remove
                if(removeBtn!=null) {
                    path="RemoveServlet";
                } else {
                    path="UpdateServlet";
                }
            } else if(a.equals("10")) {
                path = "SaveOrderServlet";
            }
            request.getRequestDispatcher(path).forward(request, response);
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
