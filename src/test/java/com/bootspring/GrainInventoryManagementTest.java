package com.bootspring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.bootspring.GrainInventoryManagement.countGrainByName;
import static com.bootspring.GrainInventoryManagement.getMinGrainFromMaharashtra;
import static org.junit.jupiter.api.Assertions.*;

class GrainInventoryManagementTest {
    private Grain[] grains;
    private Grain[] grain = {};

    @BeforeEach
    void setup(){
        grains = new Grain[5];

        grains[0] = new Grain(301, "Wheat", "Punjab", 130);            // Name match (1)
        grains[1] = new Grain(302, "Rice", "Maharashtra", 150);        // From Maharashtra
        grains[2] = new Grain(303, "Wheat", "Maharashtra", 90);        // From Maharashtra (minimum qty)
        grains[3] = new Grain(304, "Bajra", "Rajasthan", 70);
        grains[4] = new Grain(305, "Wheat", "Bihar", 110);             // Name match (2)

    }

    @Test
    @DisplayName("Count the grain with given name")
    void countGrainByNameTest() {
        assertEquals(3,countGrainByName(grains,"wheat"));
    }

    @Test
    @DisplayName("No grains from the given name")
    void countNoGrainByName(){
        assertEquals(0,countGrainByName(grains,"Barley"));
    }

    @Test
    @DisplayName("Get minimum quantity grain from Maharashtra")
    void getMinGrainFromMaharashtraTest() {
        Grain minQuantityGrain = getMinGrainFromMaharashtra(grains);
        assertEquals(303,minQuantityGrain.getGrainId());
    }

    @Test
    @DisplayName("No grain from Maharashtra")
    void NoOneFromMaharashtra(){
        Grain minQuantityGrain = getMinGrainFromMaharashtra(grain);
        assertNull(minQuantityGrain);
    }
}