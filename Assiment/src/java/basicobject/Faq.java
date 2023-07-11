/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicobject;

/**
 *
 * @author overw
 */
public class Faq {
    private int id;
    private String cusname;
    private String cuscontent;
    private int itemid;

    public Faq() {
    }

    public Faq(int id, String cusname, String cuscontent, int itemid) {
        this.id = id;
        this.cusname = cusname;
        this.cuscontent = cuscontent;
        this.itemid = itemid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCusname() {
        return cusname;
    }

    public void setCusname(String cusname) {
        this.cusname = cusname;
    }

    public String getCuscontent() {
        return cuscontent;
    }

    public void setCuscontent(String cuscontent) {
        this.cuscontent = cuscontent;
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }
    
}
