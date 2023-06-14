/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess;

import basicobject.Car;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import mylib.DBUtils;

/**
 *
 * @author overw
 */
public class OrderDAO {

    // Ham nay de chen 1 dong moi vao bang order va gio hang vao orderDetail
    public static int insertOrder(String userid, HashMap<Car, Integer> cart) throws Exception {
        int result = 0;

        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            cn.setAutoCommit(false);
            String sql = "insert [dbo].[tblOrder] ([OrderDate], [UserID], [Total])\n"
                    + "values(?,?,?)";
            PreparedStatement pst = cn.prepareStatement(sql);
            Date d = new Date(System.currentTimeMillis());
            double sum = 0;
            
            for(Car c:cart.keySet()) sum+= c.getPrice() * cart.get(c);
            pst.setDate(1, d);
            pst.setString(2, userid);
            pst.setInt(3, (int) sum);
            result = pst.executeUpdate();
            if(result>0) {
                sql="select MAX(OrderID) as 'orderid' from [dbo].[tblOrder]";
                pst = cn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                if(rs != null && rs.next()) {
                    int orderid = rs.getInt("orderid");
                    for(Car c : cart.keySet()) {
                        sql = "insert [dbo].[tblOrderDetail] ([OrderID], [CarID], [Quantity])\n"
                                + "values(?,?,?)";
                        pst = cn.prepareStatement(sql);
                        pst.setInt(1, orderid);
                        pst.setString(2, c.getId());
                        pst.setInt(3, cart.get(c));
                        result = pst.executeUpdate();
                    }
                }
            }
            cn.commit();
            cn.setAutoCommit(true);
            cn.close();
        }

        return result;
    }

}
