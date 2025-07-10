package com.bootspring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.bootspring.BikeShowroom.findMaxPriceOfBike;
import static com.bootspring.BikeShowroom.searchBikeByName;
import static org.junit.jupiter.api.Assertions.*;

class BikeShowroomTest {
    private Bike[] bikes;
    private Bike[] bike={};

    @BeforeEach
    void setup(){
        bikes = new Bike[5];

        bikes[0] = new Bike(101, 10, "Yamaha R15", 150000);
        bikes[1] = new Bike(102, 5, "Royal Enfield", 180000);
        bikes[2] = new Bike(103, 3, "KTM Duke", 210000);
        bikes[3] = new Bike(104, 7, "TVS Apache", 125000);
        bikes[4] = new Bike(105, 2, "Bajaj Dominar", 190000);
    }

    @Test
    @DisplayName("Find Bike with the maximum price")
    void findMaxPriceOfBikeTest() {
        Bike getmaxBike=findMaxPriceOfBike(bikes);
        assertNotNull(getmaxBike);
        assertEquals(103, getmaxBike.getId());
    }

    @Test
    @DisplayName("Find null as the maximum price")
    void findMaxPriceAsNull(){
        Bike getBike=findMaxPriceOfBike(bike);
        assertNull(getBike);
    }


    @Test
    @DisplayName("Get the Bike with the given name")
    void searchBikeByNameTest() {
        Bike getNameBike = searchBikeByName(bikes,"TVS Apache");
        assertNotNull(getNameBike);
    }

    @Test
    @DisplayName("No getting the Bike with the given name")
    void getBikeAsNull(){
        Bike getNameBike = searchBikeByName(bikes,"TVS jupiter");
        assertNull(getNameBike);
    }
}