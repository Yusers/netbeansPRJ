/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylib;

/**
 *
 * @author overw
 */
public class Validation {
    public static boolean checkID(String id) {
        return id.matches("F-\\d{3}");
    }
}
