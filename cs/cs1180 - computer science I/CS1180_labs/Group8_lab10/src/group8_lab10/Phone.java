package group8_lab10;

import java.text.DecimalFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexyeoh
 */
public class Phone {
    private String manufacturer;
    private String model;
    private double cost;
    
    //constructors
    public Phone(){
        manufacturer = "unknown";
        model = "unknown";
        cost = 0;
    }
    
    public Phone(String manufacturer, String model, double cost) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.cost = cost;
    }
    
    //returns stuff
    public String getManufacturer(){
        return this.manufacturer;
    }
    
    public String getModel(){
        return this.model;
    }
    
    public double getCost(){
        return this.cost;
    }
    
    //sets stuff
    public void setManufacturer(String manufacturer){
        this.manufacturer = manufacturer;
    }
    
    public void setModel(String model){
        this.model = model;
    }
    
    public void setCost(double cost){
        this.cost = cost;
    }
    
    //toString method
    @Override
    public String toString(){
        DecimalFormat formatter = new DecimalFormat("#0.00"); 
        String cost_string = formatter.format(this.cost);
        return "Manufacturer: " + this.manufacturer + "\nModel: " + this.model + "\nCost: $" + cost_string;
    }
}
