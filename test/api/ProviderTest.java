package api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ProviderTest {
    private Provider provider;
    private Accomodation accomodation;
    private Accomodation accomodation2;

    @BeforeEach
    void setUp() {
        provider=new Provider("Nick","Kiosses","kiossesn","password12",1);
        User user=new User("Tasos","Bakasetas","bakasetast","password1234",2);

        Location l1=new Location("Karolou Koun 53","Thessaloniki",56626);
        Facilities f1=new Facilities();
        f1.addfacilities('a',1);
        f1.addfacilities('b',1);
        accomodation=new Accomodation(provider,"Hotel in Greece",1,l1,"Great hotel with 200 rooms.",f1);
        Review review1=new Review(user,"Good experience!",5, LocalDate.now(),"Sakis");
        provider.addMyResorts(accomodation);
        accomodation.addListOfReviews(review1);

        Location l2=new Location("Marousiou 12","Athens",56426);
        Facilities f2=new Facilities();
        f2.addfacilities('c',1);
        f2.addfacilities('d',1);
        accomodation2=new Accomodation(provider,"Flat in Athens",2,l2,"Big flat with a lot of space.",f2);
        Review review2=new Review(user,"Good experience!",1, LocalDate.now(),"Sakis");
        accomodation.addListOfReviews(review2);
    }

    @Test
    void addMyResorts() {
        assertTrue(provider.myResorts.contains(accomodation));
    }

    @Test
    void getTotalReviews() {
        assertEquals(provider.getTotalReviews(),2);
    }

    @Test
    void getAverageScore() {
        assertEquals(provider.getAverageScore(),3.0);
    }
}