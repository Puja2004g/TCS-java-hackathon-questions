package com.bootspring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.bootspring.TheatreOperations.findSecondHighest;
import static com.bootspring.TheatreOperations.findTheatreCategory;
import static org.junit.jupiter.api.Assertions.*;

class TheatreOperationsTest {
    private Theatre[] theatres;

    @BeforeEach
    void setup(){
        theatres = new Theatre[4];
        theatres[0] = new Theatre(100, "Central City Opera House", 24.0, 900, 4);
        theatres[1] = new Theatre(101, "Paramount Theatre", 22.0, 1100, 5);
        theatres[2] = new Theatre(102, "Radio City Music Hall", 25.0, 1500, 4);
        theatres[3] = new Theatre(103, "Schermerhorn Symphony Center", 21.0, 2000, 3);
    }

    @Test
    @DisplayName("Get Premium Theatre")
    void findTheatrePremium() {
        assertEquals("Premium", findTheatreCategory(theatres, 102));
    }

    @Test
    @DisplayName("Get non premium theatre")
    void findTheatreNonPremium(){
        assertEquals("Non Premium", findTheatreCategory(theatres, 100));
    }

    @Test
    @DisplayName("Theatre id is not present")
    void findNullTheatre(){
        assertNull(findTheatreCategory(theatres,200));
    }

    @Test
    @DisplayName("Find second highest")
    void findSecondHighestTest() {
        Theatre result = findSecondHighest(theatres);
        assertNotNull(result);
        assertEquals("Central City Opera House", result.getTheatreName());
    }
}