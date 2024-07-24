package api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {
    private Location location;
    @BeforeEach
    void Before(){
        location=new Location("Karolou Koun 53", "Thessaloniki",56626);
    }
    @Test
    void returnLocation() {
        assertEquals("Karolou Koun 53, Thessaloniki, 56626",location.returnLocation());
    }

    @Test
    void setLocation() {
        location.setLocation("Agiou Meletiou 153","Athens", 54423);
        assertEquals("Agiou Meletiou 153, Athens, 54423",location.returnLocation());
    }

    @Test
    void getAddress() {
        assertEquals("Karolou Koun 53",location.getAddress());
    }

    @Test
    void getCity() {
        assertEquals("Thessaloniki",location.getCity());
    }

    @Test
    void getTk() {
        assertEquals(56626,location.getTk());
    }
}