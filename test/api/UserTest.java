package api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private User user;
    @BeforeEach
    void setUp() {
        user=new User("Tasos","Bakasetas","bakasetast","password1234",2);

    }

    @Test
    void addMyReviewed_getMyReviewed() {
        Provider p1 = new Provider("Nick", "Kiosses", "kiossesn", "password12", 1);
        Location l1 = new Location("Karolou Koun 53", "Thessaloniki", 56626);
        Facilities f1 = new Facilities();
        f1.addfacilities('a', 1);
        f1.addfacilities('b', 1);
        Accomodation a1 = new Accomodation(p1, "Hotel in Greece", 1, l1, "Great hotel with 200 rooms.", f1);
        LocalDate date = LocalDate.now();
        Review r1 = new Review(user, "Nice hotel!", 4.5, date, user.getName());
        a1.addListOfReviews(r1);
        user.addMyReviewed(a1);
        assertTrue(user.getMyReviewed().contains(a1));
    }
}