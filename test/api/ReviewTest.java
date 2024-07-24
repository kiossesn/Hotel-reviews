package api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReviewTest {
    private User p3;
    private Review review;
    @BeforeEach
    void setUp() {
        p3=new User("Tasos","Bakasetas","bakasetast","password1234",2);
        review=new Review(p3,"Nice hotel!",4.5, LocalDate.now(),p3.getName());
    }

    @Test
    void edit() {
        review.edit("Bad hotel!",LocalDate.now(),2);
        assertTrue(review.getText().equals("Bad hotel!") && review.getScore()==2);
    }

    @Test
    void getScore() {
        assertEquals(4.5,review.getScore());
    }

    @Test
    void getFirstName() {
        assertEquals("Tasos",review.getFirstName());
    }

    @Test
    void getText() {
        assertEquals("Nice hotel!",review.getText());
    }

    @Test
    void getDate() {
        assertEquals(LocalDate.now(),review.getDate());
    }

    @Test
    void getUser() {
        assertEquals(p3.getUsername(),review.getUser().getUsername());
    }
}