package com.bootspring;

public class PhotographerManagement {
    static int countPhotographerBySpecialization(Photographer[] photographers, String spec){
        int count=0;

        for(Photographer photo:photographers){
            if(photo.getSpecialization().equalsIgnoreCase(spec)){
                count++;
            }
        }

        return count;
    }

    static Photographer getSecondHighestRatedPhotographer(Photographer[] photographers){
        Photographer highest=null;
        Photographer secondHighest=null;

        for(Photographer photos:photographers){
            if(highest==null || photos.getRating() > highest.getRating()){
                secondHighest = highest;
                highest = photos;
            }

            else if(secondHighest==null || photos.getRating() > secondHighest.getRating()){
                secondHighest = photos;
            }

        }

        return  secondHighest;
    }
}

class Photographer{
    private int id;
    private String name;
    private String specialization;
    private double rating;

    public Photographer(int id, String name, String specialization, double rating) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}