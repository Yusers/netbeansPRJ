/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess;

import basicobject.Faq;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import mylib.DBUtils;

/**
 *
 * @author overw
 */
public class FaqDAO {

    public static ArrayList<Faq> getAllFaq(String itemid) throws Exception {
        ArrayList<Faq> listFaq = new ArrayList<>();

        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "SELECT [Id], [CustName], [CustContent], [ItemId]\n"
                    + "FROM [dbo].[FAQ]\n"
                    + "WHERE [ItemId] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, itemid);
            ResultSet rs = pst.executeQuery();
            if(rs != null) {
                while(rs.next()) {
                    int id = rs.getInt("Id");
                    String cusname = rs.getString("CustName");
                    String cuscontent = rs.getString("CustContent");
                    int itid = rs.getInt("ItemId");
                    listFaq.add(new Faq(id, cusname, cuscontent, itid));
                }
            }
            cn.close();
        }

        return listFaq;
    }
}
