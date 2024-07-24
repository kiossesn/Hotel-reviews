package api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserSystemTest {
    private UserSystem userSystem;
    private Accomodation a1;
    @BeforeEach
    void setUp() {
        Systemm systemm=new Systemm(0);
        User user=new User("Tasos","Bakasetas","bakasetast","password1234",2);
        userSystem=new UserSystem(user,systemm);

        Provider p1=new Provider("Nick","Kiosses","kiossesn","password12",1);

        Location l1=new Location("Karolou Koun 53","Thessaloniki",56626);
        Facilities f1=new Facilities();
        f1.addfacilities('a',1);
        f1.addfacilities('b',1);
        a1=new Accomodation(p1,"Hotel in Greece",1,l1,"Great hotel with 200 rooms.",f1);

        Location l2=new Location("Marousiou 12","Athens",56426);
        Facilities f2=new Facilities();
        f2.addfacilities('c',1);
        f2.addfacilities('d',1);
        Accomodation a2=new Accomodation(p1,"Flat in Athens",2,l2,"Big flat with a lot of space.",f2);

        Location l3=new Location("Mayorka 123","Madrid",12622);
        Facilities f3=new Facilities();
        f3.addfacilities('e',2);
        f3.addfacilities('g',4);
        Accomodation a3=new Accomodation(p1,"Fancy maisonette",3,l3,"Luxurious maisonette.",f3);

        systemm.addListOfResorts(a1);
        systemm.addListOfResorts(a2);
        systemm.addListOfResorts(a3);
    }

    @Test
    void accommodationSearch() {
        ArrayList<Accomodation> list=new ArrayList<>();
        list=userSystem.accommodationSearch("Fancy maisonette",0,"","",0,null);
        assertEquals("Luxurious maisonette.",list.get(0).getDescription());
    }

    @Test
    void makeReview() {
        Review review=userSystem.makeReview(a1,userSystem.getUser(),"Nice hotel!",LocalDate.now(),4.5);
        assertTrue(userSystem.getUser().getMyReviewed().contains(a1) && a1.getListOfReviews().contains(review));
    }

    @Test
    void editReview() {
        Review review=new Review(userSystem.getUser(),"Nice hotel!",4.5,LocalDate.now(),userSystem.getUser().getName());
        userSystem.editReview(review,"Bad hotel!",LocalDate.now(),2);
        assertTrue(review.getScore()==2 && review.getText().equals("Bad hotel!"));
    }

    @Test
    void deleteReview() {
        userSystem.makeReview(a1,userSystem.getUser(),"Nice hotel!",LocalDate.now(),4.5);
        Review review=new Review(userSystem.getUser(),"Nice hotel!",4.5,LocalDate.now(),userSystem.getUser().getName());
        userSystem.deleteReview(a1,review);
        assertTrue(!userSystem.getUser().getMyReviewed().contains(review) && !a1.getListOfReviews().contains(review));
    }

    @Test
    void getUser() {
        assertTrue(userSystem.getUser().getUsername().equals("bakasetast"));
    }
}