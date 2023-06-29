/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess;

import java.util.ArrayList;
import basicobject.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import mylib.DBUtils;

/**
 *
 * @author overw
 */
public class ItemDAO {

    public static ArrayList<Item> getAllItems(int type) throws Exception {
        ArrayList<Item> list = null;
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "SELECT [id], [name], [price], [type]\n"
                    + "FROM dbo.Item\n"
                    + "WHERE [type] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, type);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                list = new ArrayList<>();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int price = rs.getInt("price");
                    list.add(new Item(id, name, price, type));
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
            String sql = "select [id], [name], [price], [type]\n"
                    + "from [dbo].[Item]\n"
                    + "where [id] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    int itemid = rs.getInt("id");
                    String name = rs.getString("name");
                    int price = rs.getInt("price");
                    int type = rs.getInt("type");
                    item = new Item(itemid, name, price, type);
                }
            }
            cn.close();
        }

        return item;
    }
    
    public static int updateItem(Item item) throws Exception {
        int rs = 0;
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "update [dbo].[Item] \n"
                    + "set [name]=?, [price]=?, [type]=? \n"
                    + "where [id]=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, item.getName());
            pst.setInt(2, item.getPrice());
            pst.setInt(3, item.getType());
            pst.setInt(4, item.getId());
            rs = pst.executeUpdate();
            cn.close();
        }
        return rs;
    }
}
