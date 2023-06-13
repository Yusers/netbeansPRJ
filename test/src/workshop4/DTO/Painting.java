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

public class Painting extends Item {
    private int height;
    private int width;
    private boolean isWatercolour;
    private boolean isFramed;


    public Painting() {
        
    }
    
    public Painting(int value, String creator, int height, int width, boolean isWatercolour, boolean isFramed) {
        super(value, creator);
        this.height = height;
        this.width = width;
        this.isWatercolour = isWatercolour;
        this.isFramed = isFramed;
    }

    public void inputPainting() {
        input();
        Scanner sc = new Scanner(System.in);
        System.out.print("Height: ");
        height = Integer.parseInt(sc.nextLine());
        System.out.print("Width: ");
        width = Integer.parseInt(sc.nextLine());
        System.out.print("isWatercolour: ");
        isWatercolour = sc.nextBoolean();
        System.out.print("isFramed: ");
        isFramed = sc.nextBoolean();
    }

    public void outputPainting() {
        output();
        System.out.println("Height: " + height);
        System.out.println("Width: " + width);
        System.out.println("isWatercolour: " + isWatercolour);
        System.out.println("isFramed: " + isFramed);
    }

    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public boolean isWatercolour() {
        return isWatercolour;
    }
    public void setWatercolour(boolean isWatercolour) {
        this.isWatercolour = isWatercolour;
    }
    public boolean isFramed() {
        return isFramed;
    }
    public void setFramed(boolean isFramed) {
        this.isFramed = isFramed;
    }

    
}

