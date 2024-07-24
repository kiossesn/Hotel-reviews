package api;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    private Person person;

    @BeforeEach
    void setUp() {
        person=new Person("Nick","Kiosses","kiossesn","password12",1);
    }

    @Test
    void getName() {
        assertEquals(person.getName(),"Nick");
    }

    @Test
    void getSurname() {
        assertEquals(person.getSurname(),"Kiosses");
    }

    @Test
    void getType() {
        assertEquals(person.getType(),1);
    }

    @Test
    void getUsername() {
        assertEquals(person.getUsername(),"kiossesn");
    }

    @Test
    void getPassword() {
        assertEquals(person.getPassword(),"password12");
    }
}