package api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class AccomodationTest {
    private Accomodation accomodation;
    private Review review1;

    @BeforeEach
    void setUp() {
        Provider provider=new Provider("Nick","Kiosses","kiossesn","password12",1);
        User user1=new User("Tasos","Bakasetas","bakasetast","password1234",2);
        User user2=new User("Nikos","Koklonis","koklonisn","password12345",2);

        Location l1=new Location("Karolou Koun 53","Thessaloniki",56626);
        Facilities f1=new Facilities();
        f1.addfacilities('a',1);
        f1.addfacilities('b',1);
        accomodation=new Accomodation(provider,"Hotel in Greece",1,l1,"Great hotel with 200 rooms.",f1);

        review1=new Review(user1,"Good experience!",5, LocalDate.now(),"Sakis");
        Review review2=new Review(user2,"Good experience!",1, LocalDate.now(),"Sakis");

        accomodation.addListOfReviews(review1);
        accomodation.addListOfReviews(review2);
    }

    @Test
    void averageScore() {
        assertEquals(3,accomodation.averageScore());
    }

    @Test
    void addListOfReviews() {
        assertTrue(accomodation.listOfReviews.contains(review1));
    }

    @Test
    void getName() {
        assertEquals("Hotel in Greece",accomodation.getName());
    }

    @Test
    void getType() {
        assertEquals("Hotel",accomodation.getType());
    }
    @Test
    void getType2() {
        assertEquals(1,accomodation.getType2());
    }

    @Test
    void getLocation() {
        assertTrue(accomodation.getLocation().getAddress().equals("Karolou Koun 53")&&accomodation.getLocation().getCity().equals("Thessaloniki")&&accomodation.getLocation().getTk()==56626);
    }

    @Test
    void getDescription() {
        assertEquals("Great hotel with 200 rooms.",accomodation.getDescription());
    }

    @Test
    void getFacilities() {
        assertTrue(accomodation.getFacilities().selectedOrNot('a',1)&&accomodation.getFacilities().selectedOrNot('b',1));
    }
    @Test
    void getListOfReviews(){
        assertTrue(accomodation.getListOfReviews().size()==2 && accomodation.getListOfReviews().get(0).getText().equals("Good experience!"));
    }

    @Test
    void edit() {
        Location l3=new Location("Mayorka 123","Madrid",12622);
        Facilities f3=new Facilities();
        f3.addfacilities('e',2);
        f3.addfacilities('g',4);
        accomodation.edit("Fancy maisonette",3,l3,"Luxurious maisonette.",f3);
        assertTrue(accomodation.getName().equals("Fancy maisonette") && accomodation.getType().equals("Maisonette") && accomodation.getLocation()==l3 && accomodation.getDescription().equals("Luxurious maisonette.") && accomodation.getFacilities()==f3);
    }
}