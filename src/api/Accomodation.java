package api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Κλάση που υλοποιεί ένα κατάλυμα
 */
public class Accomodation implements Serializable {
    //provider that owns the registration
    private Provider provider;
    private String name,description;
    private Location location;
    private Facilities facilities;

    //1 for hotel, 2 for apartment, 3 for maisonette
    private int type;

    //list that contains all the reviews of a resort
    ArrayList<Review> listOfReviews;

    //constructor for a new resort
    public Accomodation(Provider provider,String name,int type,Location location,String description,Facilities facilities){
        this.provider=provider;
        this.name=name;
        this.type=type;
        this.location=location;
        this.description=description;
        this.facilities=facilities;
        listOfReviews = new ArrayList<>();
    }

    /**
     * Μέθοδος που βρίσκει το μέσο όρο βαθμολογίας που δόθηκε για ένα κατάλυμα από τους χρήστες σε κριτικές.
     * @return Επιστρέφει το μέσο όρο.
     */
    public double averageScore(){
        double sum=0.0;
        for(Review a:listOfReviews){
            sum+=a.getScore();
        }
        if(listOfReviews.size()!=0)return sum/listOfReviews.size();
        else return 0.0;
    }

    /**
     * Μέθοδος που προσθέτει μία κριτική στη λίστα των αξιολογήσεων ενός καταλύματος (listOfReviews).
     * @param a Κριτική που προστίθεται.
     */
    public void addListOfReviews(Review a){listOfReviews.add(a);}

    //return name
    public String getName(){
        return name;
    }
    //return type in words
    public String getType(){
        if(type==1) return "Hotel";
        if(type==2) return "Apartment";
        return "Maisonette";
    }
    //return type as int
    public int getType2(){return type;}
    //return location
    public Location getLocation(){
        return location;
    }
    //return description
    public String getDescription(){
        return description;
    }
    //return facilities
    public Facilities getFacilities(){return facilities;}
    //return provider
    public Provider getProvider(){return provider;}
    //return listOfReviews
    public ArrayList<Review> getListOfReviews(){return listOfReviews;}
    //set new accommodation
    public void edit(String name,int type,Location location,String description,Facilities facilities){
        this.name=name;
        this.type=type;
        this.location=location;
        this.description=description;
        this.facilities=facilities;
    }
}
