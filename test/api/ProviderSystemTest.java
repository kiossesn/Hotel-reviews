package api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ProviderSystemTest {
    private ProviderSystem providerSystem;
    private Systemm systemm;
    private Provider p1;
    @BeforeEach
    void setUp() {
        p1=new Provider("Nick","Kiosses","kiossesn","password12",1);
        systemm=new Systemm(0);
        providerSystem=new ProviderSystem(p1,systemm);
    }

    @Test
    void accommodationRegister() {
        Facilities f1=new Facilities();
        f1.addfacilities('a',1);
        f1.addfacilities('b',1);
        Accomodation accomodation=providerSystem.accommodationRegister(p1,"Hotel in Greece",1,"Karolou Koun 53","Thessaloniki",56626,"Great hotel with 200 rooms.",f1);
        assertTrue(p1.getMyResorts().contains(accomodation) && systemm.getListOfResorts().contains(accomodation));
    }

    @Test
    void editAccommodation() {
        Location l1=new Location("Karolou Koun 53","Thessaloniki",56626);
        Facilities f1=new Facilities();
        f1.addfacilities('a',1);
        f1.addfacilities('b',1);
        Accomodation a1=new Accomodation(p1,"Hotel in Greece",1,l1,"Great hotel with 200 rooms.",f1);

        Accomodation accomodation=providerSystem.editAccommodation(a1,"Hotel in Hawai",1,l1,"Hawaian 123","Osaka",12210,"Great hotel with 100 rooms.",f1);
        assertTrue(accomodation.getName().equals("Hotel in Hawai") && accomodation.getLocation().getAddress().equals("Hawaian 123") && accomodation.getLocation().getCity().equals("Osaka") && accomodation.getLocation().getTk()==12210);
    }

    @Test
    void deleteAccommodation() {
        Accomodation accomodation=providerSystem.accommodationRegister(p1,"Hotel in Greece",1,"Karolou Koun 53","Thessaloniki",56626,"Great hotel with 200 rooms.",null);
        User p3=new User("Tasos","Bakasetas","bakasetast","password1234",2);
        systemm.addListOfPeople(p3);
        UserSystem userSystem=new UserSystem(p3,systemm);
        userSystem.makeReview(accomodation,p3,"Nice hotel!", LocalDate.now(),4.5);
        providerSystem.deleteAccommodation(accomodation);
        assertTrue(!systemm.getListOfResorts().contains(accomodation) && !p1.getMyResorts().contains(accomodation) && !p3.getMyReviewed().contains(accomodation));
    }

    @Test
    void getProvider() {
        assertTrue(providerSystem.getProvider().getUsername().equals("kiossesn"));
    }
}