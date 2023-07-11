/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess;

import basicobject.Food;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import mylib.DBUtils;
import mylib.Validation;

/**
 *
 * @author overw
 */
public class FoodDao {

    public static ArrayList<Food> getAllFood() throws Exception {
        ArrayList<Food> listFood = null;

        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "select [id], [name], [description], [price], [cookingTime], [status]\n"
                    + "from [dbo].[tblFoods]";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs != null) {
                listFood = new ArrayList<>();
                while (rs.next()) {
                    String id = rs.getString("id");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    double price = rs.getDouble("price");
                    int cookingTime = rs.getInt("cookingTime");
                    boolean status = rs.getBoolean("status");
                    listFood.add(new Food(id, name, description, price, cookingTime, status));
                }
            }
            cn.close();
        }

        return listFood;
    }

    // get CarID
    public static Food getFood(String foodId, boolean foodStatus) throws Exception {
        Food food = null;

        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "select [id], [name], [description], [price], [cookingTime], [status]\n"
                    + "from [dbo].[tblFoods]\n"
                    + "where [id] = ? and [status] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, foodId);
            pst.setBoolean(2, foodStatus);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String id = rs.getString("id");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    double price = rs.getDouble("price");
                    int cookingTime = rs.getInt("cookingTime");
                    boolean status = rs.getBoolean("status");
                    food = new Food(id, name, description, price, cookingTime, status);
                }
            }
            cn.close();
        }

        return food;
    }
    
    // get CarID
    public static Food getFood(String foodId) throws Exception {
        Food food = null;
        
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "select [id], [name], [description], [price], [cookingTime], [status]\n"
                    + "from [dbo].[tblFoods]\n"
                    + "where [id] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, foodId);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String id = rs.getString("id");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    double price = rs.getDouble("price");
                    int cookingTime = rs.getInt("cookingTime");
                    boolean status = rs.getBoolean("status");
                    food = new Food(id, name, description, price, cookingTime, status);
                }
            }
            cn.close();
        }

        return food;
    }
    
    // ham nay de insert 1 user moi vao bang tblUsers
    // tra ve 1/0
    public static int insertFood(String id, String name, String descr, double price, int cookTime, boolean status) throws Exception {
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
            pst.setInt(5, cookTime);
            pst.setBoolean(6, status);
            rs = pst.executeUpdate();
            cn.close();
        }
        return rs;
    }
}
