/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicobject;

import java.io.Serializable;

/**
 *
 * @author overw
 */
public class Item implements Serializable{
    private int id;
    private String name;
    private int price;
    private int cateid;

    public Item() {
    }

    public Item(int id, String name, int price, int cateid) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.cateid = cateid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCateid() {
        return cateid;
    }

    public void setCateid(int cateid) {
        this.cateid = cateid;
    }
    
}
