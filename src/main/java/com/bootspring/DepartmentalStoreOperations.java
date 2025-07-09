package com.bootspring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DepartmentalStoreOperations {
    static int findAverageWorkersInSpecificLocation(DepartmentalStore[] store, String startsWithInput){
        int sum=0;
        int count=0;

        for(DepartmentalStore stores:store){
            if(stores.getStoreId().startsWith(startsWithInput)){
                count++;
                sum+=stores.getNoOfWorkers();
            }
        }

        if(count>0){
            return sum/count;
        }
        else{
            return 0;
        }
    }

//    using arraylist and comparator

    static ArrayList<DepartmentalStore> findStoreDetailsForGivenLocationComparator(DepartmentalStore[] departmentalStores, String location){
        ArrayList<DepartmentalStore> locationSpecificStore = new ArrayList<>();

        for(DepartmentalStore store:departmentalStores){
            if(store.getLocation().equalsIgnoreCase(location)){
                locationSpecificStore.add(store);
            }
        }

        if(locationSpecificStore.isEmpty()){
            return null;
        }

        Collections.sort(locationSpecificStore, new Comparator<DepartmentalStore>() {
            @Override
            public int compare(DepartmentalStore o1, DepartmentalStore o2) {
                return o1.getRating()-o2.getRating();
            }
        });

        return locationSpecificStore;
    }


//    using array and bubble sort
    static DepartmentalStore[] findStoreDetailsForGivenLocation(DepartmentalStore[] departmentalStores, String location){
        int size=0;

        for(DepartmentalStore store:departmentalStores){
            if(store.getLocation().equals(location)){
                size++;
            }
        }

        DepartmentalStore[] locationSpecificStore = new DepartmentalStore[size];

        int ind=0;
        for(DepartmentalStore store:departmentalStores){
            if(store.getLocation().equals(location)){
                locationSpecificStore[ind] = store;
                ind++;
            }
        }

        //bubble sort for ascending
        for(int i=0;i<size;i++){
            for(int j=0;j<size-i-1;j++){
                if(locationSpecificStore[j].getRating()<locationSpecificStore[j+1].getRating()){
                    DepartmentalStore temp = locationSpecificStore[j];
                    locationSpecificStore[j] = locationSpecificStore[j+1];
                    locationSpecificStore[j+1] = temp;
                }
            }
        }

        if(size==0){
            return null;
        }
        else{
            return locationSpecificStore;
        }
    }
}

class DepartmentalStore{
    private String storeId;
    private String storeName;
    private String location;
    private int noOfWorkers;
    private int rating;

    public DepartmentalStore(String storeId, String storeName, String location, int noOfWorkers, int rating) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.location = location;
        this.noOfWorkers = noOfWorkers;
        this.rating = rating;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNoOfWorkers() {
        return noOfWorkers;
    }

    public void setNoOfWorkers(int noOfWorkers) {
        this.noOfWorkers = noOfWorkers;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}