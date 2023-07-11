/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import basicobject.Item;
import dbaccess.ItemDAO;
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
public class EditItemServlet extends HttpServlet {

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
            // Lay Parameter tu form
            String oldIdParam = request.getParameter("oldId").trim();
            int oldId = Integer.parseInt(oldIdParam);
            String newIdParam = request.getParameter("newId").trim();
            int newId = Integer.parseInt(newIdParam);
            String name = request.getParameter("name").trim();
            String priceParam = request.getParameter("price");
            int price = Integer.parseInt(priceParam);
            String cateIdParam = request.getParameter("cateid");
            int cateId = Integer.parseInt(cateIdParam);
            String urlRewriting = "MainServlet"
                    + "?action=1&itemid="
                    + oldIdParam;
            Item item = null;
            // Kiem tra newId vs old co giong nhau ko
            if (newId != oldId) {
                // kiem tra co ton tai newId do hay chua
                item = ItemDAO.getItem(newId);
            }
            // Neu Khong trung id voi database thi thuc hien
            if (item == null) {
                if (!Validation.checkName(name, oldId)) {
                    // Kiem tra co trung name ko?
                    // Truong hop dac biet neu nhu thay doi id ko bi trung va name bi trung
                    request.setAttribute("msg", "Dupilcate Name");
                } else {
                    int rs = ItemDAO.updateItem(newId, oldId, name, price, cateId);
                    // Update thanh cong thi thuc hien dong if
                    if (rs > 0) {
                        urlRewriting = "MainServlet"
                            + "?action=1&itemid="
                            + newIdParam;
                        request.setAttribute("msg", "Update Success!");
                    } else {
                        // Update khong thanh cong
                        request.setAttribute("msg", "Update Failed!");
                    }
                }
            } else {
                // Trung id thi se in msg
                request.setAttribute("msg", "Update Failed! ID duplicate with: " + item.getName());
            }

            // Chuyen trang
            request.getRequestDispatcher(urlRewriting).forward(request, response);
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
