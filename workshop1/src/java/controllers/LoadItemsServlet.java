/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import basicobject.Item;
import basicobject.Type;
import dbaccess.ItemDAO;
import dbaccess.TypeDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author overw
 */
public class LoadItemsServlet extends HttpServlet {

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
            String type = request.getParameter("txttype");
            String edit = request.getParameter("editAction");
            String itemid = request.getParameter("txtitemid");
            int typeId = TypeDao.getType(type.trim()).getId();
            
            // Get parameter kiem tra update co dc click hay ko
            String update = request.getParameter("update");
            if (update != null) {
                // thuc hien update item
                String name = request.getParameter("txtitemname");
                int price = Integer.parseInt(request.getParameter("txtitemprice"));
                // Vi da get itemid va typeId trc do nen ko can thuc hien lai
                Item item = new Item(Integer.parseInt(itemid), name, price, typeId);
                int rs = ItemDAO.updateItem(item);
                if (rs > 0) {
                    request.setAttribute("msg", "update success");
                } else {
                    request.setAttribute("msg", "update failed");
                }
            }
            if (typeId > 0) {
                ArrayList<Item> list = ItemDAO.getAllItems(typeId);
                if (list != null) {
                    request.setAttribute("Items", list);
                    if (edit != null) {
                        request.setAttribute("editAction", edit);
                        request.setAttribute("Types", TypeDao.getAllTypes());
                        if (itemid != null) {
                            request.setAttribute("Item", ItemDAO.getItem(Integer.parseInt(itemid)));
                        }
                    }
                    request.setAttribute("Type", type);
                    request.getRequestDispatcher("MainServlet?action=3").forward(request, response);
                } else {
                    out.print("List are empty");
                }
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
