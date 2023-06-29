/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dbaccess.FoodDAO;
import basicobject.Food;
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
public class InsertServlet extends HttpServlet {

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
            String id = request.getParameter("txtfoodid");
            String name = request.getParameter("txtfoodname");
            String descr = request.getParameter("txtfooddescr");
            double price = Double.parseDouble(request.getParameter("txtfoodprice"));
            int cookingtime = Integer.parseInt(request.getParameter("txtcookingtime"));
            boolean status = Boolean.parseBoolean(request.getParameter("txtfoodstatus"));
            Food food = FoodDAO.getFood(id);
            boolean flag = true;
            if (food == null) {
                int rs = FoodDAO.insertCar(id, name, descr, price, cookingtime, status);
                out.print(rs);
                if (rs > 0) {
                    request.setAttribute("msg", "Insert Successfully!");
                    request.getRequestDispatcher("MainServlet?action=2").forward(request, response);
                }
                flag = false;
            } else {
                flag = false;
            }
            if (!flag) {
                request.setAttribute("msg", "Insert Failed! ID already have or something!");
                request.getRequestDispatcher("MainServlet?action=2").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
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
