package api;

import java.util.Scanner;

/**
 * Κλάση που ευθύνεται για τις λειτουργίες που μπορεί να κάνει ένας πάροχος.
 */
public class ProviderSystem {

    //provider using the system
    private Provider provider;
    private Systemm systemm;

    //constructor for a new provider system
    public ProviderSystem(Provider provider,Systemm systemm){
        this.systemm=systemm;
        this.provider=provider;
    }

    /**
     * Μέθοδος που καταχωρεί ένα νέο κατάλυμα στο σύστημα.
     * Η καταχώρηση περιλαμβάνει:
     * * * * Δημιουργία τοποθεσίας με τα δεδομένα διεύθυνση, πόλη, ταχυδρομικός_κώδικας
     * * * * Δημιουργία καταλύματος
     * * * * Προσθήκη καταλύματος στη λίστα καταλυμάτων του παρόχου (myResorts).
     * * * * Προσθήκη καταλύματος στη λίστα όλων των καταλυμάτων (listOfResorts).
     * @param name Όνομα καταλύματος.
     * @param radio Τύπος καταλύματος (1 Ξενοδοχείο, 2 Διαμέρισμα, 3 Μεζονέτα).
     * @param address Διεύθυνση καταλύματος.
     * @param town Πόλη καταλύματος.
     * @param tk Ταχυδρομικός κώδικας καταλύματος.
     * @param description Περιγραφή καταλύματος.
     * @param facilities Παροχές καταλύματος.
     * @return Επιστρέφει το νέο κατάλυμα.
     */
    public Accomodation accommodationRegister(Provider provider,String name,int radio,String address,String town,int tk,String description,Facilities facilities){
        /*1*/Location location=new Location(address,town,tk);
        /*2*/Accomodation newResort=new Accomodation(provider,name,radio,location,description,facilities);
        /*3*/provider.addMyResorts(newResort);
        /*4*/systemm.addListOfResorts(newResort);
        return newResort;
    }

    /**
     * Μέθοδος που επεξεργάζεται τα στοιχεία ενός υπάρχοντος καταλύματος.
     * Η επεξεργασία περιλαμβάνει:
     * * * * Set της τοποθεσίας.
     * * * * Set των υπόλοιπων στοιχείων (όνομα,τύπος,περιγραφή) και set των ήδη αλλαγμένων (τοποθεσία, παροχές)
     * @param x Κατάλυμα προς επεξεργασία.
     * @param name Όνομα καταλύματος.
     * @param type Τύπος καταλύματος (1 Ξενοδοχείο, 2 Διαμέρισμα, 3 Μεζονέτα).
     * @param location Παλιά τοποθεσία (πριν την αλλαγή).
     * @param address Διεύθυνση καταλύματος.
     * @param city Πόλη καταλύματος.
     * @param tk Ταχυδρομικός κώδικας καταλύματος.
     * @param description Περιγραφή καταλύματος.
     * @param facilities Παροχές καταλύματος.
     * @return Επιστρέφει το διορθωμένο κατάλυμα.
     */
    public Accomodation editAccommodation(Accomodation x,String name,int type,Location location,String address,String city,int tk,String description,Facilities facilities){
        /*1*/location.setLocation(address,city,tk);
        /*2*/x.edit(name,type,location,description,facilities);
        return x;
    }

    /**
     * Μέθοδος που διαγράφει ένα κατάλυμα από το σύστημα.
     * Η διαγραφή περιλαμβάνει:
     * * * * Αφαίρεση του καταλύματος από τη λίστα των καταλυμάτων του παρόχου (myResorts).
     * * * * Αφαίρεση του καταλύματος από τη λίστα όλων των καταλυμάτων (listOfResorts).
     * * * * Αφαίρεση του καταλύματος από τη λίστα myReviewed του κάθε χρήστη.
     * @param x Κατάλυμα προς διαγραφή.
     */
    public void deleteAccommodation(Accomodation x){
        /*1*/provider.myResorts.remove(x);
        /*2*/systemm.getListOfResorts().remove(x);
        /*3*/
        for(Person p:systemm.getListOfPeople()){
            if(p instanceof User) ((User) p).getMyReviewed().remove(x);
        }
    }

    //Getter για τον provider που είναι συνδεδεμένος
    public Provider getProvider(){return provider;}

}

