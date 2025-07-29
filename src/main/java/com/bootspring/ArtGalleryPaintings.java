package com.bootspring;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ArtGalleryPaintings {
    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);

        // int n = Integer.parseInt(sc.nextLine());

        ArtGallery[] artGalleries = new ArtGallery[5];

        for(int i=0;i<5;i++){
            int id = Integer.parseInt(sc.nextLine().trim());
            int quant = Integer.parseInt(sc.nextLine().trim());
            String style = sc.nextLine();
            String title = sc.nextLine();

            artGalleries[i] = new ArtGallery(id, quant, style, title);
        }

        String style = sc.nextLine();
        String title = sc.nextLine();
        int id = Integer.parseInt(sc.nextLine().trim());

        int countPaintings = countTotalPaintingForStyle(artGalleries, style);

        if(countPaintings > 0){
            System.out.println(countPaintings);
        }
        else{
            System.out.println("The given style is not available");
        }

        ArtGallery getPaintingTitle = finPaintingByTitleAndId(artGalleries, title, id);

        if(getPaintingTitle==null){
            System.out.println("The given title or painting ID is not available");
        }
        else{
            System.out.println(getPaintingTitle.getQuantity() + getPaintingTitle.getStyle());
        }
    }

    static int countTotalPaintingForStyle(ArtGallery[] artGalleries, String style){
        if(artGalleries == null || style == null){
            return 0;
        }
        int sum=0;

        for(ArtGallery artGallery : artGalleries){
            if(artGallery.getStyle().equalsIgnoreCase(style)){
                sum += artGallery.getQuantity();
            }
        }

        return sum;
    }

    static ArtGallery finPaintingByTitleAndId(ArtGallery[] artGalleries, String title,
                                              int paintingId){
        if(artGalleries == null || title == null){
            return null;
        }

        ArtGallery gallery = null;

        for(ArtGallery artGallery : artGalleries){
            if(artGallery.getTitle().equalsIgnoreCase(title) && artGallery.getId()==paintingId){
                gallery = artGallery;
            }
        }

        return gallery;
    }
}

class ArtGallery{
    private int paintingId;
    private int quantity;
    private String style;
    private String title;

    ArtGallery(int id , int quantity, String style, String title){
        paintingId = id;
        this.quantity = quantity;
        this.style = style;
        this.title = title;
    }

    int getId(){
        return paintingId;
    }

    void setId(int id){
        paintingId = id;
    }


    int getQuantity(){
        return quantity;
    }

    void setQuantity(int quantity){
        this.quantity = quantity;
    }

    String getStyle(){
        return style;
    }

    void setStyle(String style){
        this.style = style;
    }

    String getTitle(){
        return title;
    }

    void setTitle(String title){
        this.title = title;
    }
}