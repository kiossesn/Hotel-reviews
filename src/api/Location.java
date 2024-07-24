package api;

import java.io.Serializable;

/**
 * Κλάση που υλοποιεί τη διεύθυνση ενός καταλύματος.
 */
public class Location implements Serializable {

    private String address,city;

    private int tk;

    //constructor for a new location
    public Location(String address,String city,int tk){
        this.address=address;
        this.city=city;
        this.tk=tk;
    }

    /**
     * Μέθοδος που κατασκευάζει ένα String με την τοποθεσία ενός καταλύματος στη μορφή: Διεύθυνση, Πόλη, Ταχυδρομικός_κώδικας
     * @return Επιστρέφει το String της τοποθεσίας.
     */
    public String returnLocation(){
        return address+", "+city+", "+tk;
    }
    //set new location
    public void setLocation(String address,String city,int tk){
        this.address=address;
        this.city=city;
        this.tk=tk;
    }
    //return address
    public String getAddress(){return address;}
    //return city
    public String getCity(){return city;}
    //return postal code
    public int getTk(){return tk;}

}
