package com.bootspring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.bootspring.DepartmentalStoreOperations.findAverageWorkersInSpecificLocation;
import static com.bootspring.DepartmentalStoreOperations.findStoreDetailsForGivenLocation;
import static org.junit.jupiter.api.Assertions.*;

class DepartmentalStoreOperationsTest {
    private DepartmentalStore[] stores;

    @BeforeEach
    void setup(){
        stores = new DepartmentalStore[10];

        stores[0] = new DepartmentalStore("AB101", "Smart Mart", "Delhi", 48, 4);
        stores[1] = new DepartmentalStore("AB102", "Value Zone", "Mumbai", 36, 5);
        stores[2] = new DepartmentalStore("AB103", "Quick Buy", "Delhi", 30, 3);

        stores[3] = new DepartmentalStore("CD201", "Urban Store", "Mumbai", 52, 3);
        stores[4] = new DepartmentalStore("CD202", "Central Market", "Mumbai", 60, 4);

        stores[5] = new DepartmentalStore("EF301", "Daily Needs", "Kolkata", 44, 4);

        stores[6] = new DepartmentalStore("GH401", "Super Choice", "Chennai", 60, 2);
        stores[7] = new DepartmentalStore("GH402", "Budget Bazaar", "Chennai", 50, 3);

        stores[8] = new DepartmentalStore("IJ501", "Mega Mart", "Hyderabad", 47, 5);

        stores[9] = new DepartmentalStore("KL601", "Neighborhood Store", "Bangalore", 40, 4);
    }

    @Test
    @DisplayName("Get average no. of workers")
    void AverageWorkersInSpecificLocation() {
        assertEquals((48+36+30)/3, findAverageWorkersInSpecificLocation(stores, "AB"));
    }

    @Test
    @DisplayName("Get 0 average")
    void AverageWorkersInSpecificLocationNull(){
            assertEquals(0,findAverageWorkersInSpecificLocation(stores, "ZX"));
    }

    @Test
    @DisplayName("Get store details in ascending order as per rating")
    void StoreDetailsForGivenLocation() {
        DepartmentalStore[] departmentalStores = findStoreDetailsForGivenLocation(stores,"Mumbai");

        assertNotNull(departmentalStores);
        assertEquals(3,departmentalStores.length);
        assertEquals(5, departmentalStores[0].getRating());
        assertEquals(4, departmentalStores[1].getRating());
        assertEquals(3, departmentalStores[2].getRating());

    }

    @Test
    @DisplayName("Get null location")
    void storeDetailsForNoLocation(){
        DepartmentalStore[] departmentalStores = findStoreDetailsForGivenLocation(stores, "Pune");
        assertNull(departmentalStores);
    }
}