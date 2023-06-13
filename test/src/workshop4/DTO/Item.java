/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop4.DTO;


import java.util.Scanner;

public class Item {
    // Field hoặc trường hoặc thuộc tính của class Item
    private String creator;
    private int value;

    // Phương thức khởi tạo hoặc Object constructor
    public Item() {

    }

    // Phương thức khởi tạo có tham số
    public Item(int value, String creator) {
        this.value = value;
        this.creator = creator;
    }

    // Phương thức input của Class Item
    public void input() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Nhap value: ");
            value = Integer.parseInt(sc.nextLine());
            System.out.print("Nhap creator: ");
            creator = sc.nextLine();
        } while(!(value > 0 && creator != ""));
    }

    // Phương thức ouput của Class Item
    public void output() {
        System.out.println("Value: " + value);
        System.out.println("Creator: " + creator);
    }

    // Getters and Setters
    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

