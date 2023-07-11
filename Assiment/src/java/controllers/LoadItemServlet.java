/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import basicobject.Categories;
import basicobject.Item;
import dbaccess.CateDAO;
import dbaccess.ItemDAO;
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
public class LoadItemServlet extends HttpServlet {

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
            // Neu ng dung bam edit thi itemid se ton tai
            // .. va thuc hien doan code sau
            String editAction = request.getParameter("editAction");
            String url = "MainServlet?action=2";
            ArrayList<Item> listItems = ItemDAO.getAllItems();
            if (!listItems.isEmpty() || listItems.size() > 0) {
                request.setAttribute("Items", listItems);
                String faqLoad = request.getParameter("faq");
                if (faqLoad != null) {
                    url = "MainServlet?action=6";
                }
            }

            // Truong hop nhan nut edit
            String itemid = request.getParameter("itemid");
            if (editAction != null) {
                if (itemid != null) {
                    Item item = ItemDAO.getItem(Integer.parseInt(itemid));
                    if (item != null) {
                        request.setAttribute("Item", item);
                        String cateidParam = request.getParameter("cateid");
                        int cateid = Integer.parseInt(cateidParam);
                        // Dua cateid mac dinh len dau mang
                        ArrayList<Categories> listCate = CateDAO.getAllCate();
                        int pos = listCate.indexOf(CateDAO.getCate(cateid));
                        Categories firstIndex = listCate.get(0);
                        listCate.set(0, listCate.get(pos));
                        listCate.set(pos, firstIndex);
                        request.setAttribute("ListCate", listCate);
                    }
                }
            }

            // Truong hop nhan nut delete
            String deleteAction = request.getParameter("deleteAction");
            if (deleteAction != null) {
                url = "MainServlet?action=4&itemid=" + itemid;
            }

            // Chuyen trang
            request.getRequestDispatcher(url).forward(request, response);
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
