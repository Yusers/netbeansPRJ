/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dbaccess.ItemDAO;
import basicobject.Item;
import dbaccess.CateDAO;
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
public class CreateItemServlet extends HttpServlet {

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
            String createAction = request.getParameter("createAction");
            String url = "MainServlet"
                    + "?action=1";
            boolean flag = true;
            if (createAction == null) {
                String idParam = request.getParameter("id").trim();
                int id = Integer.parseInt(idParam);
                String name = request.getParameter("name").trim();
                String priceParam = request.getParameter("price");
                int price = Integer.parseInt(priceParam);
                String cateIdParam = request.getParameter("cateid");
                int cateId = Integer.parseInt(cateIdParam);
                Item alreadyID = ItemDAO.getItem(id);
                if (alreadyID == null) {
                    if (Validation.checkName(name)) {
                        int rs = ItemDAO.insertItem(id, name, price, cateId);
                        if (rs > 0) {
                            request.setAttribute("msg", "Create Success!");
                            createAction="1";
                        } else {
                            request.setAttribute("msg", "Create Fail!");
                            flag = false;
                        }
                    } else {
                        request.setAttribute("msg", "Create* Duplicate name!");
                        flag = false;
                    }
                } else {
                    flag = false;
                    request.setAttribute("msg", "Create* Duplicate ID! With: " + alreadyID.getName());
                }
            } else {
                request.setAttribute("ListCate", CateDAO.getAllCate());
            }
            if (!flag) {
                url = "MainServlet"
                        + "?action=5&createAction=1";
                // Tracking value input
                String idParam = request.getParameter("id").trim();
                int id = Integer.parseInt(idParam);
                String name = request.getParameter("name").trim();
                String priceParam = request.getParameter("price");
                int price = Integer.parseInt(priceParam);
                String cateIdParam = request.getParameter("cateid");
                int cateId = Integer.parseInt(cateIdParam);
                Item it = new Item(id, name, price, cateId);
                request.setAttribute("TrackingItem", it);
            }
            request.setAttribute("CREATE", createAction);
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
