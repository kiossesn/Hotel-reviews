package api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FacilitiesTest {
    private Facilities facilities;
    @BeforeEach
    void setUp() {
        facilities=new Facilities();
    }

    @Test
    void addfacilities_selectedOrNot() {
        facilities.addfacilities('a',1);
        facilities.addfacilities('c',2);
        assertTrue(facilities.selectedOrNot('a',1) && facilities.selectedOrNot('c',2) && !facilities.selectedOrNot('b',1));
    }

    @Test
    void listOfSelectedFacilities() {
        facilities.addfacilities('a',1);
        facilities.addfacilities('b',1);
        facilities.addfacilities('c',1);
        ArrayList<String> list=new ArrayList<>();
        list=facilities.listOfSelectedFacilities();
        assertTrue(list.size()==3 && list.get(0).equals("* View on Pool") && list.get(1).equals("* Blow-dryer") && list.get(2).equals("* Clothe Washing Machine"));
    }

    @Test
    void setFacilitiesToFalse() {
        facilities.addfacilities('a',1);
        facilities.addfacilities('b',1);
        facilities.addfacilities('c',1);
        facilities.setFacilitiesToFalse();
        assertTrue(!facilities.selectedOrNot('a',1) && !facilities.selectedOrNot('b',1) && !facilities.selectedOrNot('c',1));
    }
}