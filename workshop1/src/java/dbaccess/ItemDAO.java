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
        ArrayList<Item> list = new ArrayList<>();
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "SELECT [id], [name], [price], [type]\n"
                    + "FROM dbo.Item\n"
                    + "WHERE [type] = ?;";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, "%" + type + "%");
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                list.add(new Item(id, name, price, type));
            }
            cn.close();
        }

        return list;
    }
}
