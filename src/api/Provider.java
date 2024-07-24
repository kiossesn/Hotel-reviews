package api;

import java.util.ArrayList;

/**
 * Κλάση που υλοποιεί έναν πάροχο.
 * Είναι υποκλάση της Person.
 */
public class Provider extends Person{

    //list of provider's resorts
    ArrayList<Accomodation> myResorts;

    //constructor for a new provider
    public Provider(String name,String surname,String username,String password,int type){
        super(name,surname,username,password,type);
        myResorts=new ArrayList<>();
    }

    /**
     * Μέθοδος που προσθέτει ένα κατάλυμα στη λίστα του παρόχου.
     * @param a Επιστρέφει το κατάλυμα που προστίθεται.
     */
    public void addMyResorts(Accomodation a){myResorts.add(a);}

    /**
     * Μέθοδος που υπολογίζει τον αριθμό των αξιολογήσεων ενός καταλύματος, που έγιναν από χρήστες.
     * @return Επιστρέφει τον αριθμό των αξιολογήσεων.
     */
    public int getTotalReviews(){
        int k=0;
        for(Accomodation a:myResorts){
            for(Review  b: a.listOfReviews){
                k++;
            }
        }
        return k;
    }

    /**
     * Μέθοδος που βρίσκει το μέσο όρο βαθμολογίας στο σύνολο των καταλυμάτων ενός παρόχου.
     * @return Επιστρέφει τον μέσο όρο.
     */
    public double getAverageScore(){
        double sum=0.0;
        int k=0;
        for(Accomodation a:myResorts){
            for(Review  b: a.listOfReviews){
                k++;
                sum+=b.getScore();
            }
        }
        if(k!=0)return sum/k;
        else return 0.0;
    }

    //returns myResorts list
    public ArrayList<Accomodation> getMyResorts(){return myResorts;}
}
