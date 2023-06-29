/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess;

import basicobject.User;
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
public class UserDAO {

    public static ArrayList<User> getAllUsers() throws Exception {
        ArrayList<User> list = new ArrayList<>();

        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "select [userID],[fullName],[roleID],[password]\n"
                    + "from [dbo].[tblUsers]";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    String id = rs.getString("userID");
                    String fullName = rs.getString("fullName");
                    int roleID = rs.getString("roleID").equals("AD") ? 1 : 0;
                    String password = rs.getString("password");
                    list.add(new User(id, fullName, roleID, password));
                }
            }
            cn.close();
        }

        return list;
    }

    public static User getUser(String userid) throws Exception {
        User us = null;

        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "select [userID],[fullName],[roleID],[password]\n"
                    + "from [dbo].[tblUsers]"
                    + "where [userID] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, userid);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String id = rs.getString("userID");
                    String fullname = rs.getString("fullName");
                    int roleID = rs.getString("roleID").equals("AD") ? 1 : 0;
                    String pass = rs.getString("password");
                    us = new User(id, fullname, roleID, pass);
                }
            }
            cn.close();
        }

        return us;
    }
}
