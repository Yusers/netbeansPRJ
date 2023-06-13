/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass2.core;

/**
 *
 * @author overw
 */
public class Customer {
    private String id;
    private String name;
    private String address;
    private String phone;
    
//    Getter and setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
//    toString()

    @Override
    public String toString() {
        return id + "," + name + "," + address + "," + phone;
    }
    
}
