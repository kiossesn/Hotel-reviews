package api;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Κλάση που ευθύνεται για τις λειτουργίες που μπορεί να κάνει ένας χρήστης.
 */
public class UserSystem {

    //user using the system
    private User user;
    private Systemm systemm;

    //constructor for a new user system
    public UserSystem(User user,Systemm systemm){
        this.systemm=systemm;
        this.user=user;
    }

    /**
     * Μέθοδος που υλοποιεί την αναζήτηση καταλυμάτων από τον χρήστη.
     * Χρησιμοποιείται σειριακή αναζήτηση στη λίστα listOfResorts και λαμβάνονται υπόψη όλοι οι συνδυασμοί δεδομένων εισόδου από τον χρήστη.
     * Θεωρώ πως κάθε κριτήριο έχει την ίδια βαρύτητα.
     * Δεν είναι ανάγκη ένα κατάλυμα να έχει όλες τις επιλεγμένες παροχές για να μπει στη λίστα, αρκεί να έχει τουλάχιστον μία.
     * Η σειρά των καταλυμάτων στην τελική λίστα είναι τυχαία.
     * @param name Όνομα καταλύματος.
     * @param type Τύπος καταλύματος. (1 για ξενοδοχείο/2 για διαμέρισμα/3 για μεζονέτα)
     * @param address Διεύθυνση καταλύματος.
     * @param city Πόλη καταλύματος.
     * @param tk Ταχυδρομικός κώδικας (int).
     * @param facilities Παροχές καταλύματος.
     * @return Επιστρέφει λίστα με τα καταλύματα που πληρούν τα κριτήρια των δεδομένων εισόδου.
     */
    public ArrayList<Accomodation> accommodationSearch(String name, int type,String address, String city, int tk, Facilities facilities){
        //list with results
        ArrayList<Accomodation> list=new ArrayList<>();
        //facilities criteria
        if(facilities!=null){
            //list with selected facilities
            ArrayList<String> fac=new ArrayList<>();
            fac=facilities.listOfSelectedFacilities();
            //search in listOfResorts
            for(Accomodation a:systemm.getListOfResorts()){
                //list with selected facilities of each resort
                ArrayList<String> fac2=new ArrayList<>();
                fac2=a.getFacilities().listOfSelectedFacilities();
                //if resort has no facilities
                if(fac2.size()==0) break;
                //find common facilities
                for(String s:fac){
                    if(fac2.contains(s)){
                        list.add(a);
                        break;
                    }
                }
            }
        }
        //name, address, city, postal code and type
        if(!name.equals("") && !address.equals("") && !city.equals("") && tk!=0 && type!=0){
            for(Accomodation a:systemm.getListOfResorts()){
                if(name.equals(a.getName()) && address.equals(a.getLocation().getAddress()) && city.equals(a.getLocation().getCity()) && tk==a.getLocation().getTk() && type==a.getType2()){
                    list.add(a);
                }
            }
        }
        //name, address, city and postal code
        else if (!name.equals("") && !address.equals("") && !city.equals("") && tk!=0) {
            for(Accomodation a:systemm.getListOfResorts()){
                if(name.equals(a.getName()) && address.equals(a.getLocation().getAddress()) && city.equals(a.getLocation().getCity()) && tk==a.getLocation().getTk()){
                    list.add(a);
                }
            }
        }
        //name, address and city
        else if (!name.equals("") && !address.equals("") && !city.equals("")) {
            for(Accomodation a:systemm.getListOfResorts()){
                if(name.equals(a.getName()) && address.equals(a.getLocation().getAddress()) && city.equals(a.getLocation().getCity())){
                    list.add(a);
                }
            }
        }
        //name, address and postal code
        else if (!name.equals("") && !address.equals("") && tk!=0) {
            for(Accomodation a:systemm.getListOfResorts()){
                if(name.equals(a.getName()) && address.equals(a.getLocation().getAddress()) && tk==a.getLocation().getTk()){
                    list.add(a);
                }
            }
        }
        //name, address and type
        else if (!name.equals("") && !address.equals("") && type!=0) {
            for(Accomodation a:systemm.getListOfResorts()){
                if(name.equals(a.getName()) && address.equals(a.getLocation().getAddress()) && type==a.getType2()){
                    list.add(a);
                }
            }
        }
        //name, city and postal code
        else if (!name.equals("") && !city.equals("") && tk!=0) {
            for(Accomodation a:systemm.getListOfResorts()){
                if(name.equals(a.getName()) && city.equals(a.getLocation().getCity()) && tk==a.getLocation().getTk()){
                    list.add(a);
                }
            }
        }
        //name, city and type
        else if (!name.equals("") && !city.equals("") && type!=0) {
            for(Accomodation a:systemm.getListOfResorts()){
                if(name.equals(a.getName()) && city.equals(a.getLocation().getCity()) && type==a.getType2()){
                    list.add(a);
                }
            }
        }
        //name, postal code and type
        else if (!name.equals("") && tk!=0 && type!=0) {
            for(Accomodation a:systemm.getListOfResorts()){
                if(name.equals(a.getName()) && tk==a.getLocation().getTk() && type==a.getType2()){
                    list.add(a);
                }
            }
        }
        //name and address
        else if (!name.equals("") && !address.equals("")) {
            for(Accomodation a:systemm.getListOfResorts()){
                if(name.equals(a.getName()) && address.equals(a.getLocation().getAddress())){
                    list.add(a);
                }
            }
        }
        //name and city
        else if (!name.equals("") && !city.equals("")) {
            for(Accomodation a:systemm.getListOfResorts()){
                if(name.equals(a.getName()) && city.equals(a.getLocation().getCity())){
                    list.add(a);
                }
            }
        }
        //name and postal code
        else if (!name.equals("") && tk!=0) {
            for(Accomodation a:systemm.getListOfResorts()){
                if(name.equals(a.getName()) && tk==a.getLocation().getTk()){
                    list.add(a);
                }
            }
        }
        //name and type
        else if (!name.equals("") && type!=0) {
            for(Accomodation a:systemm.getListOfResorts()){
                if(name.equals(a.getName()) && type==a.getType2()){
                    list.add(a);
                }
            }
        }
        //address and type
        else if (!address.equals("") && type!=0) {
            for(Accomodation a:systemm.getListOfResorts()){
                if(address.equals(a.getLocation().getAddress()) && type==a.getType2()){
                    list.add(a);
                }
            }
        }
        //city and type
        else if (!city.equals("") && type!=0) {
            for(Accomodation a:systemm.getListOfResorts()){
                if(city.equals(a.getLocation().getCity()) && type==a.getType2()){
                    list.add(a);
                }
            }
        }
        //postal code and type
        else if (tk!=0 && type!=0) {
            for(Accomodation a:systemm.getListOfResorts()){
                if(tk==a.getLocation().getTk() && type==a.getType2()){
                    list.add(a);
                }
            }
        }
        //only name
        else if(!name.equals("")){
            for(Accomodation a:systemm.getListOfResorts()){
                if(name.equals(a.getName())){
                    list.add(a);
                }
            }
        }
        //only address
        else if(!address.equals("")){
            for(Accomodation a:systemm.getListOfResorts()){
                if(address.equals(a.getLocation().getAddress())){
                    list.add(a);
                }
            }
        }
        //only city
        else if(!city.equals("")){
            for(Accomodation a:systemm.getListOfResorts()){
                if(city.equals(a.getLocation().getCity())){
                    list.add(a);
                }
            }
        }
        //only postal code
        else if(tk!=0){
            for(Accomodation a:systemm.getListOfResorts()){
                if(tk==a.getLocation().getTk()){
                    list.add(a);
                }
            }
        }
        //only type
        else if(type!=0){
            for(Accomodation a:systemm.getListOfResorts()){
                if(type==a.getType2()){
                    list.add(a);
                }
            }
        }
        return list;
    }
    /**
     * Μέθοδος που δημιουργεί μια κριτική στο σύστημα.
     * Η διαδικασία περιλαμβάνει:
     * * * * Δημιουργία κριτικής.
     * * * * Προσθήκη καταλύματος στη λίστα καταλυμάτων που ο χρήστης έχει αφήσει κριτική (myReviewed)
     * * * * Προσθήκη κριτικής στη λίστα κριτικών του καταλύματος. (listOfReviews)
     * @param a Κατάλυμα για το οποίο γίνεται η κριτική.
     * @param text Κείμενο κριτικής.
     * @param score Βαθμολογία κριτικής.
     * @return Επιστρέφει το review που δημιουργήθηκε.
     */
    public Review makeReview(Accomodation a, User user, String text, LocalDate date, double score){
        /*1*/Review review=new Review(user,text,score,date,user.getName());
        /*2*/user.addMyReviewed(a);
        /*3*/a.addListOfReviews(review);
        return review;
    }

    /**
     * Μέθοδος που καλεί τη συνάρτηση edit για επεξεργασία των στοιχείων μιας αξιολόγησης.
     * @param r Αξιολόγηση προς επεξεργασία.
     * @param text Νέο κείμενο αξιολόγησης.
     * @param date Νέα ημερομηνία αξιολόγησης.
     * @param score Νέα βαθμολογία αξιολόγησης.
     * @return Επιστρέφει το διορθωμένο review.
     */
    public Review editReview(Review r,String text,LocalDate date, double score){
        /*1*/r.edit(text,date,score);
        return r;
    }

    /**
     * Μέθοδος η οποία πραγματοποιεί τη διαγραφή μιας αξιολόγησης.
     * Η διαγραφή περιλαμβάνει:
     * * * * Αφαίρεση της αξιολόγησης από τη λίστα των αξιολογήσεων του καταλύματος (listOfReviews).
     * * * * Αφαίρεση του καταλύματος από τη λίστα των καταλυμάτων που έχει αξιολογήσει ο χρήστης (myReviewed)
     * (Θεωρείται ότι ο χρήστης έχει κάνει μία μόνο αξιολόγηση για κάθε κατάλυμα)
     * @param r Αξιολόγηση προς διαγραφή.
     */
    public void deleteReview(Accomodation a,Review r){
        /*1*/a.listOfReviews.remove(r);
        /*2*/user.getMyReviewed().remove(a);
    }
    //return user
    public User getUser(){return user;}

}
