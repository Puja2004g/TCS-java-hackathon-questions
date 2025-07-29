package com.bootspring;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class VehicleManagement {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());

        Vehicle[] vehicles = new Vehicle[n];

        for(int i=0;i<n;i++){
            int reg = Integer.parseInt(sc.nextLine().trim());
            int quant = Integer.parseInt(sc.nextLine().trim());
            String type = sc.nextLine();
            String brand = sc.nextLine();

            vehicles[i] = new Vehicle(reg, quant, type, brand);
        }

        String type = sc.nextLine();
        String prefix = sc.nextLine();

        int avgQuant = getAverageQuantity(vehicles, type);

        if(avgQuant > 0){
            System.out.println(avgQuant);
        }
        else{
            System.out.println("No vehicles found for the given type");
        }

        Vehicle brandPrefix = searchVehicleWithBrandPrefix(vehicles, prefix);

        if(brandPrefix == null){
            System.out.println("No vehicle found with the given brand prefix");
        }
        else{
            System.out.println(brandPrefix.getRegNum() + "-" +
                    brandPrefix.getQuantity() + "-" +
                    brandPrefix.getType() + "-" + brandPrefix.getBrand());
        }
    }

    static int getAverageQuantity(Vehicle[] vehicles, String type){
        if(vehicles == null || type == null){
            return 0;
        }
        int sum=0;
        int count=0;

        for(Vehicle vehicle : vehicles){
            if(vehicle.getType().equalsIgnoreCase(type)){
                sum+=vehicle.getQuantity();
                count++;
            }
        }

        if(count==0 || sum==0){
            return 0;
        }

        return sum/count;
    }

    static Vehicle searchVehicleWithBrandPrefix(Vehicle[] vehicles, String brandPrefix){
        Vehicle getBrandPrefix = null;

        for(Vehicle vehicle : vehicles){
            if(vehicle.getBrand().startsWith(brandPrefix)){
                getBrandPrefix = vehicle;
            }
        }

        return getBrandPrefix;
    }
}

class Vehicle{
    private int registrationNumber;
    private int quantity;
    private String type;
    private String brand;

    Vehicle(int registrationNumber, int quantity, String type, String brand){
        this.registrationNumber = registrationNumber;
        this.quantity = quantity;
        this.type = type;
        this.brand = brand;
    }

    int getRegNum(){
        return registrationNumber;
    }

    void setRegNum(int reg){
        registrationNumber = reg;
    }

    int getQuantity(){
        return quantity;
    }

    void setQuantity(int quant){
        quantity = quant;
    }

    String getType(){
        return type;
    }

    void setType(String type){
        this.type=type;
    }

    String getBrand(){
        return brand;
    }

    void setBrand(String brand){
        this.brand = brand;
    }
}