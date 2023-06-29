/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess;

import java.sql.Connection;
import basicobject.Food;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import mylib.DBUtils;

/**
 *
 * @author overw
 */
public class FoodDAO {

    public static Food getFood(String id) throws Exception {
        Food food = null;

        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "Select [id], [name], [description], [price], [cookingTime], [status]\n"
                    + "from [dbo].[tblFoods]\n"
                    + "where id = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            if(rs!=null) {
                while(rs.next()) {
                    String fid = rs.getString("id");
                    String name = rs.getString("name");
                    String descr = rs.getString("description");
                    double price = rs.getDouble("price");
                    int cookingTime = rs.getInt("cookingTime");
                    boolean status= rs.getBoolean("status");
                    food = new Food(fid, name, descr, price, cookingTime, status);
                }
            }
            cn.close();
        }

        return food;
    }

    public static int insertCar(String id, String name, String descr, double price, int cookingTime, boolean status) throws Exception {
        int rs = 0;
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "insert [dbo].[tblFoods]([id], [name], [description], [price], [cookingTime], [status])\n"
                    + "values(?,?,?,?,?,?)";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, id);
            pst.setString(2, name);
            pst.setString(3, descr);
            pst.setDouble(4, price);
            pst.setInt(5, cookingTime);
            pst.setBoolean(6, status);
            rs = pst.executeUpdate();
            cn.close();
        }
        return rs;
    }
}
