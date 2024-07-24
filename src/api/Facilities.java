package api;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Κλάση που υλοποιεί τις παροχές ενός καταλύματος.
 * Αυτό γίνεται με τη χρήση πινάκων τύπου boolean για κάθε ομάδα παροχών.
 * Όταν ένα κελί είναι false τότε η παροχή δε διατίθεται ενώ όταν είναι true διατίθεται.
 * Κάθε ομάδα παροχών κωδικοποιείται με ένα γράμμα, ενώ κάθε επιμέρους παροχή κωδικοποιείται με έναν αριθμό.
 */
public class Facilities implements Serializable {
    private boolean[] view,kitchen,clothes,climate,internet,outt,parking;
    private boolean wc,tv;

    /**
     * Default κατασκευαστής για την αρχικοποίηση των πινάκων σε false
     */
    public Facilities(){
        this.view=new boolean[7];
        for (int i = 1; i <= 6; i++) {view[i]=false;}
        this.kitchen=new boolean[9];
        for (int i = 1; i <= 8; i++) {kitchen[i]=false;}
        this.clothes=new boolean[3];
        for (int i = 1; i <= 2; i++) {clothes[i]=false;}
        this.climate=new boolean[4];
        for (int i = 1; i <= 3; i++) {climate[i]=false;}
        this.internet=new boolean[3];
        for (int i = 1; i <= 2; i++) {internet[i]=false;}
        this.outt=new boolean[3];
        for (int i = 1; i <= 2; i++) {outt[i]=false;}
        this.parking=new boolean[3];
        for (int i = 1; i <= 2; i++) {parking[i]=false;}
        wc=false;
        tv=false;
    }

    /**
     * Μέθοδος που προσθέτει μία παροχή ενός καταλύματος.
     * Αυτό πραγματοποιείται με αλλαγή του κελιού n της ομάδας ch από false σε true.
     * @param ch Ομάδα παροχών.
     * @param n Επιμέρους παροχή.
     */
    public void addfacilities(char ch,int n){
        if(ch=='a'){if(n<=6&&n>0)view[n]=true;}
        if(ch=='b'){if(n==1)wc=true;}
        if(ch=='c'){if(n<=2&&n>0)clothes[n]=true;}
        if(ch=='d'){if(n==1)tv=true;}
        if(ch=='e'){if(n<=3&&n>0)climate[n]=true;}
        if(ch=='f'){if(n<=2&&n>0)internet[n]=true;}
        if(ch=='g'){if(n<=8&&n>0)kitchen[n]=true;}
        if(ch=='h'){if(n<=2&&n>0)outt[n]=true;}
        if(ch=='i'){if(n<=2&&n>0)parking[n]=true;}
    }

    /**
     * Μέθοδος που βρίσκει αν η παροχή της ομάδας ch και με αριθμό n έχει επιλεχθεί για ένα κατάλυμα.
     * Αν δηλαδή στον πίνακα με κωδικό ch το κελί n είναι true τότε επιστρέφεται true, αλλιώς false.
     * @param ch Κωδικός ομάδας παροχών.
     * @param n Αριθμός παροχής.
     * @return Επιστρέφει true αν έχει επιλεχθεί, false αν όχι.
     */
    public boolean selectedOrNot(char ch, int n){
        if(ch=='a'){if(view[n])return true;}
        if(ch=='b'){if(wc)return true;}
        if(ch=='c'){if(clothes[n])return true;}
        if(ch=='d'){if(tv)return true;}
        if(ch=='e'){if(climate[n])return true;}
        if(ch=='f'){if(internet[n])return true;}
        if(ch=='g'){if(kitchen[n])return true;}
        if(ch=='h'){if(outt[n])return true;}
        if(ch=='i'){if(parking[n])return true;}
        return false;
    }

    /**
     * Μέθοδος που φτιάχνει μια λίστα με τις παροχές (σε String) που έχουν επιλεχθεί για ένα κατάλυμα.
     * Δημιουργεί μια λίστα και αναζητά σε κάθε πίνακα τα κελιά που είναι true και αναλόγως προσθέτει την περιγραφή κάθε παροχής στη λίστα.
     * @return Επιστρέφει τη λίστα με τις παροχές.
     */
    public ArrayList<String> listOfSelectedFacilities(){
        ArrayList<String> fac=new ArrayList<>();
        for(int i=1;i<=6;i++) {
            if (view[i]) {
                if (i == 1) {fac.add("* View on Pool");}
                if (i == 2){fac.add("* View on Beach");}
                if (i == 3) {fac.add("* View on Sea");}
                if (i == 4) {fac.add("* View on Port");}
                if (i == 5) {fac.add("* View on Mountain");}
                if (i == 6) {fac.add("* View on Street");}
            }
        }
        if(wc) {fac.add("* Blow-dryer");}
        for(int i=1;i<=2;i++) {
            if (clothes[i]) {
                if (i == 1) {fac.add("* Clothe Washing Machine");}
                if (i == 2) {fac.add("* Clothe Dryer");}
            }
        }
        if(tv) {fac.add("* Tv");}
        for(int i=1;i<=3;i++) {
            if (climate[i]) {
                if (i == 1) {fac.add("* Fireplace");}
                if (i == 2) {fac.add("* Air condition");}
                if (i == 3) {fac.add("* Central heating");}
            }
        }
        for(int i=1;i<=2;i++) {
            if (internet[i]) {
                if (i == 1) {fac.add("* WiFi");}
                if (i == 2) {fac.add("* Ethernet");}
            }
        }
        for(int i=1;i<=8;i++) {
            if(kitchen[i]) {
                if (i == 1) {fac.add("* Kitchen");}
                if (i == 2) {fac.add("* Fridge");}
                if (i == 3) {fac.add("* Microwave");}
                if (i == 4) {fac.add("* Kitchen equipment");}
                if (i == 5) {fac.add("* Dishes");}
                if (i == 6) {fac.add("* Cutlery");}
                if (i == 7) {fac.add("* Dish Washer");}
                if (i == 8) {fac.add("* Coffee machine");}
            }
        }
        for(int i=1;i<=2;i++) {
            if (outt[i]) {
                if (i == 1) {fac.add("* Balcony");}
                if (i == 2) {fac.add("* Backyard");}
            }
        }
        for(int i=1;i<=2;i++) {
            if (parking[i]) {
                if (i == 1) {fac.add("* Garage");}
                if (i == 2) {fac.add("* Parking on the Street");}
            }
        }
        return fac;
    }

    /**
     * Μέθοδος που θέτει όλους τους πίνακες των παροχών σε false.
     * Σαν reset.
     */
    public void setFacilitiesToFalse(){
        for (int i = 1; i <= 6; i++) {view[i]=false;}
        for (int i = 1; i <= 8; i++) {kitchen[i]=false;}
        for (int i = 1; i <= 2; i++) {clothes[i]=false;}
        for (int i = 1; i <= 3; i++) {climate[i]=false;};
        for (int i = 1; i <= 2; i++) {internet[i]=false;}
        for (int i = 1; i <= 2; i++) {outt[i]=false;}
        for (int i = 1; i <= 2; i++) {parking[i]=false;}
        wc=false;
        tv=false;
    }
}
