/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;

/**
 *
 * @author alexyeoh
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] array = {22,33,44};
        arrayProcess(array);
        System.out.println(array[1]);
        
    }
    public static void arrayProcess(int[] array){
        for (int k = 0; k<array.length;k++){
            array[k] = array[k] + 5;
        }
    }
    
}
