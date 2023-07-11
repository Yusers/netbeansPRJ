/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess;

import basicobject.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import mylib.DBUtils;

/**
 *
 * @author overw
 */
public class TypeDao {

    public static ArrayList<Type> getAllTypes() throws Exception {
        ArrayList<Type> list = new ArrayList<>();

        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            //b2: viet sql va exec
            String sql = "select [id], [name], [status] from dbo.Types";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    int typeID = rs.getInt("id");
                    String typeName = rs.getString("name");
                    boolean status = rs.getBoolean("status");
                    list.add(new Type(typeID, typeName, status));
                }
            }
            cn.close();
        }

        return list;
    }

    public static Type getType(String name) throws Exception {
        Type type = null;

        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "select [id], [name], [status] from dbo.Types where name = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, name);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                type = new Type();
                while (rs.next()) {
                    int typeID = rs.getInt("id");
                    String typeName = rs.getString("name");
                    boolean status = rs.getBoolean("status");
                    type = new Type(typeID, typeName, status);
                }
            }
            cn.close();
        }

        return type;
    }

}
