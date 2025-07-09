package com.bootspring;

public class TheatreOperations {
    static String findTheatreCategory(Theatre[] theatres, int theatreId){
        for(Theatre theatre: theatres){
            if(theatre.getTheatreId()==theatreId){
                if(theatre.getSeatCapacity()>1000 && theatre.getRating()>=4){
                    return "Premium";
                }
                else{
                    return "Non Premium";
                }
            }
        }
        return null;
    }

    static Theatre findSecondHighest(Theatre[] theatres){
        Theatre highest = null;
        Theatre secondHighest = null;

        for(Theatre theatre:theatres){
            if(theatre.getRating()>=2){
                if(highest== null || theatre.getRating() > highest.getRating()){
                    secondHighest=highest;
                    highest=theatre;
                }
                else if(secondHighest==null || theatre.getRating()>secondHighest.getRating()){
                    secondHighest = theatre;
                }
            }
        }

        return secondHighest;
    }
}

class Theatre{
    private int theatreId;
    private String theatreName;
    private double ticketRate;
    private int seatCapacity;
    private int rating;

    public Theatre(int theatreId, String theatreName, double ticketRate, int seatCapacity, int rating) {
        this.theatreId = theatreId;
        this.theatreName = theatreName;
        this.ticketRate = ticketRate;
        this.seatCapacity = seatCapacity;
        this.rating = rating;
    }

    public int getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public double getTicketRate() {
        return ticketRate;
    }

    public void setTicketRate(double ticketRate) {
        this.ticketRate = ticketRate;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}