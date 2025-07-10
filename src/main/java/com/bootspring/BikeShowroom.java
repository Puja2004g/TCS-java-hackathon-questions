package com.bootspring;

public class BikeShowroom {
    static Bike findMaxPriceOfBike(Bike[] bike){
        int max=0;
        Bike maxPriceBike=null;

        for(Bike bikes:bike){
            if(bikes.getPrice()>max){
                max = bikes.getPrice();
                maxPriceBike=bikes;
            }
        }

        return maxPriceBike;
    }

    static Bike searchBikeByName(Bike[] bike,String name){
        Bike byName = null;

        for(Bike bikes:bike){
            if(bikes.getName().equalsIgnoreCase(name)){
                byName=bikes;
            }
        }

        return byName;
    }
}

class Bike{
    private int id;
    private int quantity;
    private String name;
    private int price;

    public Bike(int id, int quantity, String name, int price) {
        this.id = id;
        this.quantity = quantity;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}