/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dbaccess.FoodDao;
import basicobject.Food;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mylib.Validation;

/**
 *
 * @author overw
 */
public class AddFoodServlet extends HttpServlet {

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
            String descr = request.getParameter("txtDescription");
            double price = Double.parseDouble(request.getParameter("txtfoodprice"));
            int cookTime = Integer.parseInt(request.getParameter("txtfoodcooktime"));
            boolean status = Boolean.parseBoolean(request.getParameter("txtfoodstatus"));
            String addStatus = "";
            request.setAttribute("listFood", FoodDao.getAllFood());
            Food food = FoodDao.getFood(id);
            if (food == null) {
                if (Validation.checkID(id)) {
                    int rs = FoodDao.insertFood(id, name, descr, price, cookTime, status);
                    if (rs > 0) {
                        request.setAttribute("msg", "Successfully!");
//                out.print("<a href='MainServlet?action=1'>Go Back</a>");
                    } else {
                        addStatus = "updateFail";
                    }
                } else {
                    addStatus = "formatID";
                }
            } else {
                addStatus = "duplicateID";
            }

            if (addStatus.equals("updateFail")) {
                request.setAttribute("msg", "Add Failed!");
            } else if (addStatus.equals("duplicateID")) {
                request.setAttribute("msg", "duplicate ID!");
            } else if(addStatus.equals("formatID")) {
                request.setAttribute("msg", "ID must be F-XXX");
            }
            request.getRequestDispatcher("MainServlet?action=2").forward(request, response);

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
