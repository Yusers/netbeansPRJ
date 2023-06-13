/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;

/**
 *
 * @author overw
 */
public class Book {
    private String id;
    private String name;
    private double price;
    private int quantity;
    private String bookPublisher;
    private String status;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return quantity > 0 ? "Available" : "Not Available";
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    @Override
    public String toString() {
        return "Id: " + id + ", Name: " + name + ", Price: " + price + ", Quantity: " + quantity + ", bookPublisher: " + bookPublisher + ", Status: " + getStatus();
    }
    
}
