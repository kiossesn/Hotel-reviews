package api;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Κλάση που υλοποιεί το σύστημα που ευθύνεται για την αποθήκευση όλων των στοιχείων των ανθρώπων που χρησιμοποιούν την εφαρμογή
 * και όλων των καταλυμάτων που εγγράφονται στην εφαρμογή.
 * Επίσης, υλοποιεί την είσοδο στο σύστημα και την εγγραφή χρήστη σε αυτό.
 */
public class Systemm {

    //list of all people
    private ArrayList<Person> listOfPeople;

    //list of all accommodation
    private ArrayList<Accomodation> listOfResorts;

    //map which contains <key=username, value=password>
    private HashMap<String,String> loginCredentials = new HashMap<>();

    /**
     * Κατασκευαστής ενός νέου συστήματος.
     * Διαβάζει από τα αρχεία ListOfPeople, ListOfResorts και LoginCredentials και αρχικοποιεί τις λίστες και το HashMap.
     * Επίσης, δημιουργεί τη λίστα myResorts του κάθε provider και τοποθετεί τα καταλύματα που τους αντιστοιχούν.
     * Ακόμη, δημιουργεί τη λίστα myReviewed του κάθε user και τοποθετεί τα καταλύματα στα οποία έχει κάνει αξιολόγηση.
     * */
    public Systemm() {
        listOfPeople=new ArrayList<>();
        listOfResorts=new ArrayList<>();
        loginCredentials=new HashMap<>();
        listOfPeople=readListFromFile("ListOfPeople.ser");
        listOfResorts=readListFromFile("ListOfResorts.ser");
        loginCredentials=readMapFromFile("LoginCredentials.ser");
        for(Person p:listOfPeople){
            if(p instanceof Provider){
                ((Provider) p).myResorts= new ArrayList<>();
                for (Accomodation accomodation:listOfResorts) {
                    if(accomodation.getProvider().getUsername().equals(p.getUsername())) ((Provider) p).addMyResorts(accomodation);
                }
            }
            else{
                ((User) p).myReviewed=new ArrayList<>();
                for (Accomodation accomodation:listOfResorts) {
                    for(Review r:accomodation.listOfReviews){
                       if(r.getFirstName().equals(p.getName())) ((User) p).addMyReviewed(accomodation);
                   }
                }
            }
        }
    }

    /**
     * Κατασκευαστής για το SetUp.
     * @param i Τυχαία μεταβλητή.
     */
    public Systemm(int i){
        listOfPeople=new ArrayList<>();
        listOfResorts=new ArrayList<>();
    }

    /**
     * Μέθοδος για την εγγραφή όλων των χρήσιμων δεδομένων του προγράμματος σε αρχεία.
     * Συγκεκριμένα, αποθηκεύονται οι λίστες με τους χρήστες και παρόχους του συστήματος, το σύνολο των καταλυμάτων και τα στοιχεία σύνδεσης των χρηστών και παρόχων.
     */
    public void saveInFiles(){
        writeListToFile("ListOfResorts.ser",listOfResorts);
        writeListToFile("ListOfPeople.ser",listOfPeople);
        writeMapToFile("LoginCredentials.ser",loginCredentials);
    }

    /**
     * Μέθοδος που εγγράφει ένα HashMap σε αρχείο με συγκεκριμένο path.
     * @param path Διεύθυνση αρχείου στο οποίο γίνεται η εγγραφή.
     * @param map HashMap το οποίο εγγράφουμε στο αρχείο.
     */
    public void writeMapToFile(String path,HashMap map){
        try(ObjectOutputStream obj=new ObjectOutputStream(new FileOutputStream(path));){
            obj.writeObject(map);
            obj.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Μέθοδος που διαβάζει ένα HashMap από αρχείο με συγκεκριμένο path.
     * @param path Διεύθυνση αρχείου από το οποίο γίνεται η ανάγνωση.
     * @return Επιστρέφει το HashMap που διαβάστηκε.
     */
    public HashMap readMapFromFile(String path) {
        try(ObjectInputStream obj=new ObjectInputStream(new FileInputStream(path));){
            HashMap<String,String> map= (HashMap<String, String>) obj.readObject();
            obj.close();
            return map;
        }
        catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    /**
     * Μέθοδος που εγγράφει μια λίστα σε αρχείο με συγκεκριμένο path.
     * @param path Διεύθυνση αρχείου στο οποίο γίνεται η εγγραφή.
     * @param list Λίστα την οποία εγγράφουμε στο αρχείο.
     */
    public void writeListToFile(String path,ArrayList list) {
        try(ObjectOutputStream obj=new ObjectOutputStream(new FileOutputStream(path));){
            obj.writeObject(list);
            obj.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Μέθοδος που διαβάζει μια λίστα από αρχείο με συγκεκριμένο path.
     * @param path Διεύθυνση αρχείου από το οποίο γίνεται η ανάγνωση.
     * @return Επιστρέφει τη λίστα που διαβάστηκε.
     */
    public ArrayList readListFromFile(String path) {
        try(ObjectInputStream obj=new ObjectInputStream(new FileInputStream(path));){
            if(path.equals("C:\\Users\\nickk\\IdeaProjects\\myreviews-4203-4290\\src\\api\\ListOfResorts.ser")){
                ArrayList<Accomodation> accomodation = (ArrayList<Accomodation>) obj.readObject();
                obj.close();
                return accomodation;
            }
            ArrayList<Person> people = (ArrayList<Person>) obj.readObject();
            obj.close();
            return people;
        }
        catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    /**
     * Μέθοδος που προσθέτει ένα κατάλυμα (τύπου Accomodation) στη λίστα όλων των καταλυμάτων του συστήματος (listOfResorts).
     * @param a Κατάλυμα που προστίθεται.
     */
    public void addListOfResorts(Accomodation a){
        listOfResorts.add(a);
    }

    /**
     * Μέθοδος που προσθέτει έναν άνθρωπο (τύπου Person) στη λίστα όλων των χρηστών ή παρόχων του συστήματος (listOfPeople).
     * @param p Άνθρωπος που προστίθεται.
     */
    public void addListOfPeople(Person p){listOfPeople.add(p);}

    /**
     * Μέθοδος που προσθέτει ένα ζευγάρι username, password στο HashMap με τα στοιχεία σύνδεσης όλων.
     * @param username Το key.
     * @param password Το value.
     */
    public void addLoginCredentials(String username,String password){loginCredentials.put(username,password);}

    /**
     * Μέθοδος που βρίσκει εάν ένας άνθρωπος (τύπος Person) είναι πάροχος (τύπος Provider) ή χρήστης (τύπος User).
     * @param person Άνθρωπος που θέλουμε να βρούμε αν είναι χρήστης ή πάροχος.
     * @return Επιστρέφει 1 για πάροχος ή 2 για χρήστης.
     */
    public int userOrProvider(Person person){
        if (person instanceof User){
            return 2;
        }
        else{
            return 1;
        }
    }

    /**
     * Μέθοδος που πραγματοποιεί την είσοδο ενός ανθρώπου στο σύστημα με το username και το password του.
     * Γίνεται ταυτοποίηση με αναζήτηση στη λίστα listOfPeople.
     * @param username Όνομα χρήστη ή παρόχου.
     * @param password Κωδικός χρήστη ή παρόχου.
     * @return Επιστρέφει τον άνθρωπο (τύπος Person) που εισήχθη στο σύστημα. Αν η ταυτοποίηση αποτύχει επιστρέφει null.
     */
    public Person login(String username,String password){
            for (Person a : listOfPeople) {
                if (a.getUsername().equals(username)) {
                    if (a.getPassword().equals(password)) {
                        return a;
                    }
                }
            }
        return null;
    }

    /**
     * Μέθοδος που πραγματοποιεί την εγγραφή ενός νέου ανθρώπου στο σύστημα.
     * Λαμβάνει υπόψη το type του ανθρώπου και αναλόγως τον κατατάσσει σε πάροχο ή χρήστη.
     * Η εγγραφή περιλαμβάνει:
     * * * * Δημιουργία παρόχου ή χρήστη.
     * * * * Προσθήκη στοιχείων εισόδου στο map loginCredentials
     * * * * Προσθήκη του νέου παρόχου ή χρήστη στη λίστα listOfPeople
     * @param name Όνομα.
     * @param surname Επίθετο.
     * @param username Όνομα χρήστη ή παρόχου.
     * @param password Κωδικός χρήστη ή παρόχου.
     * @param type 1 για πάροχος ή 2 για χρήστης
     * @return Επιστρέφει τον άνθρωπο (τύπος Person) ο οποίος εγγράφτηκε. Αν το username υπάρχει ήδη επιστρέφει null.
     */
    public Person register(String name,String surname, String username,String password,int type) {
        //username already exists
        if (loginCredentials.containsKey(username)) {
            return null;
        }
        //if person is provider
        if(type==1) {
            /*1*/Provider newPerson = new Provider(name, surname, username, password, type);
            /*2*/loginCredentials.put(username, password);
            /*3*/listOfPeople.add(newPerson);
            return newPerson;
        }
        //if person is user
        if(type==2) {
            /*1*/User newPerson = new User(name, surname, username, password, type);
            /*2*/loginCredentials.put(username, password);
            /*3*/listOfPeople.add(newPerson);
            return newPerson;
        }
        return null;
    }
    //returns listOfPeople
    public ArrayList<Person> getListOfPeople(){return listOfPeople;}
    //returns listOfResorts
    public ArrayList<Accomodation> getListOfResorts(){return listOfResorts;}
}
