/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop4.DTO;

import java.util.Scanner;

public class Statue extends Item{
    // Field
    private int weight;
    private String colour;

    public Statue() {
    }

    public Statue(int value, String creator, int weight, String colour) {
        super(value, creator);
        this.weight = weight;
        this.colour = colour;
    }

   public void inputStatue() {
        input();
        Scanner sc = new Scanner(System.in);
        System.out.print("Weight: ");
        weight = Integer.parseInt(sc.nextLine());
        System.out.print("Colour: ");
        colour = sc.nextLine();
    }

    public void outputStatue() {
        output();
        System.out.println("Weight: " + weight);
        System.out.println("Colour: " + colour);
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    
}
