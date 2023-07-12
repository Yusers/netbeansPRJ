package dbaccess;

import basicobject.Car;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import mylib.DBUtils;

public class CarDAO {

    public static ArrayList<Car> getAllCar() throws Exception {
        ArrayList<Car> carList = new ArrayList<>();
        Connection cn = new DBUtils().makeConnection();
        if (cn != null) {
            Statement st = cn.createStatement();
            String sql = "select id,name,description,price,speed,status from tblCars";
            ResultSet rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    String id = rs.getString("id");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    int speed = rs.getInt("speed");
                    boolean status = rs.getBoolean("status");
                    carList.add(new Car(id, name, description, price, speed, status));
                }
            }
            cn.close();
        }
        return carList;
    }

    public static int updateStatus(String id, boolean status) throws Exception {
        int rs = 0;
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "update tblCars set status = ? where id = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, "" + !status);
            pst.setString(2, id);
            rs = pst.executeUpdate();
            cn.close();
        }

        return rs;
    }

    public static ArrayList<Car> getCars(String search) throws Exception {
        ArrayList<Car> carList = new ArrayList<>();
        Connection cn = new DBUtils().makeConnection();
        if (cn != null) {
            String sql = "select id,name,description,price,speed,status from tblCars where name like ? and status=1";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, "%" + search + "%");
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String id = rs.getString("id");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    int speed = rs.getInt("speed");
                    boolean status = rs.getBoolean("status");
                    carList.add(new Car(id, name, description, price, speed, status));
                }
            }
            cn.close();
        }
        return carList;
    }

    public static Car getCar(String id) throws Exception {
        Car c = null;
        Connection cn = new DBUtils().makeConnection();
        if (cn != null) {
            String sql = "select id,name,description,price,speed,status from tblCars where id = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    int speed = rs.getInt("speed");
                    boolean status = rs.getBoolean("status");
                    c = new Car(id, name, description, price, speed, status);
                }
            }
            cn.close();
        }
        return c;
    }
}
