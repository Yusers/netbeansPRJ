/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess;

import basicobject.Categories;
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
public class CateDAO {

    public static ArrayList<Categories> getAllCate() throws Exception {
        ArrayList<Categories> listCate = new ArrayList<>();

        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "SELECT [CateId], [CateName], [Status]\n"
                    + "FROM [dbo].[Categories]";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs!=null) {
                while(rs.next()) {
                    int id = rs.getInt("CateId");
                    String name = rs.getString("CateName");
                    int status = rs.getInt("Status");
                    listCate.add(new Categories(id, name, status));
                }
            }
            cn.close();
        }

        return listCate;
    }
    
    public static Categories getCate(int cateid) throws Exception {
        Categories cate = null;

        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "SELECT [CateId], [CateName], [Status]\n"
                    + "FROM [dbo].[Categories]\n"
                    + "WHERE [CateId] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, cateid);
            ResultSet rs = pst.executeQuery();
            if(rs!=null) {
                while(rs.next()) {
                    int id = rs.getInt("CateId");
                    String name = rs.getString("CateName");
                    int status = rs.getInt("Status");
                    cate = new Categories(id, name, status);
                }
            }
            cn.close();
        }

        return cate;
    }
}
