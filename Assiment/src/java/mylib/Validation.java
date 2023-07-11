/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylib;

import basicobject.Item;
import dbaccess.ItemDAO;

/**
 *
 * @author overw
 */
public class Validation {

    public static boolean checkName(String name, int oldId) throws Exception {
        for (Item i : ItemDAO.getAllItems()) {
            if (i.getName().equalsIgnoreCase(name)) {
                if (i.getId() != oldId) {
                    // Kiểm tra nếu tên đã tồn tại với id khác
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkName(String name) throws Exception {
        for (Item i : ItemDAO.getAllItems()) {
            if (i.getName().equalsIgnoreCase(name)) {
                // Kiểm tra nếu tên đã tồn tại với id khác
                return false;
            }
        }
        return true;
    }
}
