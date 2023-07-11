/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess;

import basicobject.Item;
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
public class ItemDAO {

    public static ArrayList<Item> getAllItems() throws Exception {
        ArrayList<Item> list = new ArrayList<>();

        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "SELECT [ItemId], [ItemName], [Price], [CateId]\n"
                    + "FROM [dbo].[Items]";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    int id = rs.getInt("ItemId");
                    String name = rs.getString("ItemName");
                    int price = rs.getInt("Price");
                    int cateId = rs.getInt("CateId");
                    list.add(new Item(id, name, price, cateId));
                }
            }
            cn.close();
        }
        return list;
    }

    public static Item getItem(int id) throws Exception {
        Item item = null;

        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "SELECT [ItemId], [ItemName], [Price], [CateId]\n"
                    + "FROM [dbo].[Items]\n"
                    + "WHERE ItemId=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String name = rs.getString("ItemName");
                    int price = rs.getInt("Price");
                    int cateId = rs.getInt("CateId");
                    item = new Item(id, name, price, cateId);
                }
            }
            cn.close();
        }
        return item;
    }

    public static int updateItem(int newId, int oldId, String name, int price, int cateId) throws Exception {
        int rs = 0;
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "UPDATE [dbo].[Items] SET [ItemId]=?, [ItemName]=?, [Price]=?, [CateId]=? \n"
                    + "WHERE [ItemId]=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, newId);
            pst.setString(2, name);
            pst.setInt(3, price);
            pst.setInt(4, cateId);
            pst.setInt(5, oldId);
            rs = pst.executeUpdate();
            cn.close();
        }
        return rs;
    }
    
    public static int insertItem(int id, String name, int price, int cateId) throws Exception {
        int rs = 0;
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "insert Items values(?,?,?,?)";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, name);
            pst.setInt(3, price);
            pst.setInt(4, cateId);
            rs = pst.executeUpdate();
            cn.close();
        }
        return rs;
    }

    public static int deleteItem(String id) throws Exception {
        int rs = 0;
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "DELETE FROM [dbo].[Items]\n"
                    + "WHERE [ItemId] = ?;";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, id);
            rs = pst.executeUpdate();
            cn.close();
        }
        return rs;
    }
}
