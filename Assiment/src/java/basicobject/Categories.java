/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicobject;

import java.util.Objects;

/**
 *
 * @author overw
 */
public class Categories {
    private int id;
    private String name;
    private int status;

    public Categories() {
    }

    public Categories(int id, String name, int status) {
        this.id = id;
        this.name = name;
        this.status = status;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Categories{" + "id=" + id + ", name=" + name + ", status=" + status + '}';
    }
    
    //   2 Ham duoi day dung de su dung containsKey() cua HashMap chinh xac hon 
//   Neu khong co 2 ham nay thi containsKey() cua HashMap khi so sanh se khong
    // tra ve ket qua so sanh dung
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Categories other = (Categories) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
}
