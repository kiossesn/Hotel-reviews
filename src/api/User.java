package api;

import java.util.ArrayList;

/**
 * Κλάση που υλοποιεί έναν χρήστη.
 * Είναι υποκλάση της Person.
 */
public class User extends Person{

    //list of resorts that user reviewed
    ArrayList<Accomodation> myReviewed;

    //constructor for a new user
    public User(String name,String surname,String username,String password,int type){
        super(name,surname,username,password,type);
        myReviewed=new ArrayList<>();
    }

    /**
     * Μέθοδος που προσθέτει ένα κατάλυμα στη λίστα με τα καταλύματα που ο χρήστης άφησε κριτική.
     * @param a Το κατάλυμα που προστίθεται
     */
    public void addMyReviewed(Accomodation a){
        myReviewed.add(a);
    }
    public ArrayList<Accomodation> getMyReviewed(){return myReviewed;}
}
