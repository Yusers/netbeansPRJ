/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop4.DTO;

/**
 *
 * @author overw
 */
import java.util.Scanner;

public class Vase extends Item{
    // Field
    private int height;
    private String material;

    // Phương thức khởi tạo
    public Vase() {

    }

    // Phương thức khởi tạo có tham số
    public Vase(int value, String creator, int height, String material) {
        super(value, creator);
        this.height = height;
        this.material = material;
    }

    public void inputVase() {
        input();
        Scanner sc = new Scanner(System.in);
        System.out.print("Height: ");
        height = Integer.parseInt(sc.nextLine());
        System.out.print("Material: ");
        material = sc.nextLine();
    }

    public void outputVase() {
        output();
        System.out.println("Height: " + height);
        System.out.println("Material: " + material);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    
}
