package api;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class SystemmTest {
    private Systemm systemm;
    private Person person;
    private Accomodation accomodation;

    @BeforeEach
    void setUp() {
        systemm=new Systemm(0);
        person=new Person("George","Kiosses","kiossesg","password123",1);
        Provider provider=new Provider("Nick","Kiosses","nickkioss","password12",1);
        Location l1=new Location("Karolou Koun 53","Thessaloniki",56626);
        Facilities f1=new Facilities();
        f1.addfacilities('a',1);
        f1.addfacilities('b',1);
        accomodation=new Accomodation(provider,"Hotel in Greece",1,l1,"Great hotel with 200 rooms.",f1);
    }

    @Test
    void fileTest() {
        //make list
        ArrayList<Person> list= new ArrayList<>();
        Provider p2=new Provider("George","Kiosses","kiossesg","password123",1);
        User p3=new User("Tasos","Bakasetas","bakasetast","password1234",2);
        list.add(p2);
        list.add(p3);
        //write list
        systemm.writeListToFile("fileTest.ser",list);
        //read list
        ArrayList<Person> list2= new ArrayList<>();
        list2=systemm.readListFromFile("fileTest.ser");
        //print lists to compare
        for (Person item : list) {
            System.out.println(item.getName());
            System.out.println(item.getSurname());
            System.out.println(item.getUsername());
            System.out.println(item.getPassword());
            System.out.println(item.getType());
            System.out.println("");
        }
        for (Person value : list2) {
            System.out.println(value.getName());
            System.out.println(value.getSurname());
            System.out.println(value.getUsername());
            System.out.println(value.getPassword());
            System.out.println(value.getType());
            System.out.println("");
        }
        //make map
        HashMap<String,String> map=new HashMap<>();
        map.put(p2.getUsername(),p2.getPassword());
        map.put(p3.getUsername(),p3.getPassword());
        //write map
        systemm.writeMapToFile("fileTest.ser",map);
        //read map
        HashMap<String,String> map2= new HashMap<>();
        map2=systemm.readMapFromFile("fileTest.ser");
        //print maps to compare
        System.out.println(map);
        System.out.println(map2);

        assertTrue(
                list.get(0).getUsername().equals(list2.get(0).getUsername()) && list.get(1).getUsername().equals(list2.get(1).getUsername())
                        && map.containsKey(p2.getUsername()) && map2.containsKey(p2.getUsername())
        );

    }

    @Test
    void addListOfPeople() {
        systemm.addListOfPeople(person);
        assertTrue(systemm.getListOfPeople().contains(person));
    }

    @Test
    void addListOfResorts() {
        systemm.addListOfResorts(accomodation);
        assertTrue(systemm.getListOfResorts().contains(accomodation));
    }

    @Test
    void userOrProvider() {
        assertEquals(1,systemm.userOrProvider(person));
    }

    @Test
    void login() {
        systemm.register("Nick", "Kiosses", "kiossesn", "password12", 1);
        Person person1=systemm.login("kiossesn","password12");
        assertEquals("kiossesn",person1.getUsername());
    }

    @Test
    void register() {
        assertNotNull(systemm.register("Nick", "Kiosses", "nickkioss", "password12", 1));
    }

    @Test
    void getListOfPeople(){
        systemm.addListOfPeople(person);
        assertTrue(systemm.getListOfPeople().size()==1 && systemm.getListOfPeople().get(0).getUsername().equals("kiossesg"));
    }
    @Test
    void getListOfResorts(){
        systemm.addListOfResorts(accomodation);
        assertTrue(systemm.getListOfResorts().size()==1 && systemm.getListOfResorts().get(0).getName().equals("Hotel in Greece"));
    }
}