package com.bootspring;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class GadgetManagement {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        Gadget[] gadgets = new Gadget[n];

        for(int i=0;i<n;i++){
            int modelNumber = Integer.parseInt(sc.nextLine().trim());
            int stock = Integer.parseInt(sc.nextLine().trim());
            String type = sc.nextLine();
            String brand = sc.nextLine();

            gadgets[i] = new Gadget(modelNumber, stock, type, brand);
            // System.out.println(modelNumber+ " " + stock + " " + type + " " + brand);
        }

        String type = sc.nextLine();
        String brand = sc.nextLine();
        int modelNum = Integer.parseInt(sc.nextLine());

        int getTotalStock = countTotalStockForType(gadgets, type);
        if(getTotalStock == 0){
            System.out.println("No Gadget found with mentioned attribute.");
        }
        else{
            System.out.println(getTotalStock);
        }

        Gadget getGadgetByBrand = findGadgetByBrandAndModel(gadgets, brand, modelNum);
        if(getGadgetByBrand == null){
            System.out.println("No Gadget found with mentioned attribute.");
        }
        else{
            System.out.println(getGadgetByBrand.getStock() +"-" + getGadgetByBrand.getType());
        }
    }

    static int countTotalStockForType(Gadget[] gadgets, String type){
        if(gadgets == null || type == null){
            return 0;
        }

        int total=0;

        for(Gadget gadget : gadgets){
            if(gadget.getType().equalsIgnoreCase(type)){
                total += gadget.getStock();
            }
        }

        return total;
    }

    static Gadget findGadgetByBrandAndModel(Gadget[] gadgets, String brand, int model){
        if(gadgets == null || brand == null){
            return null;
        }
        Gadget matchedModel = null;

        for(Gadget gadget : gadgets){
            if(gadget.getBrand().equalsIgnoreCase(brand) && gadget.getModelNumber()==model){
                matchedModel = gadget;
            }
        }

        return matchedModel;
    }

}

class Gadget{
    private int modelNumber;
    private int stock;
    private String type;
    private String brand;

    Gadget(int model, int stock, String type, String brand){
        this.modelNumber = model;
        this.stock = stock;
        this.type = type;
        this.brand = brand;
    }

    int getModelNumber(){
        return modelNumber;
    }

    void setModelNumber(int num){
        this.modelNumber = num;
    }

    int getStock(){
        return stock;
    }

    void setStock(int stock){
        this.stock = stock;
    }

    String getType(){
        return type;
    }

    void setType(String type){
        this.type = type;
    }

    String getBrand(){
        return brand;
    }

    void setBrand(String brand){
        this.brand = brand;
    }
}