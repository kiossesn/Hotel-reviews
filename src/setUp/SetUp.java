package setUp;

import api.*;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Πραγματοποιεί αρχικοποίηση-εγγραφή και αποθήκευση στη λίστα listOfPeople και στο αρχείο ListOfPeople.ser 2 χρηστών και 2 παρόχων.
 * Αποθηκεύει, ακόμη, τα στοιχεία εισόδου τους (username, password) στο HashMap loginCredentials.
 * Επίσης, πραγματοποιεί αρχικοποίηση-εγγραφή και αποθήκευση στη λίστα listOfResorts και στο αρχείο ListOfResorts.ser 10 καταλυμάτων.
 * Αποθηκεύει, ακόμη, τα καταλύματα κάθε παρόχου στη λίστα myResorts του καθενός.
 * Τέλος, αποθηκεύει το HashMap loginCredentials με τα username και τα password κάθε ανθρώπου στο αρχείο LoginCredentials.ser.
 */
public class SetUp {
    private static Systemm system;

    public static void main(String[] args) {
        //make a system
        system= new Systemm(0);
        //initialize people
        Provider p1=new Provider("Nick","Kiosses","provider1","password1",1);
        Provider p2=new Provider("George","Kiosses","provider2","password2",1);
        User p3=new User("Tasos","Bakasetas","user1","password1",2);
        User p4=new User("Nikos","Koklonis","user2","password2",2);
        //add people to listOfPeople and username+password to loginCredentials
        system.addListOfPeople(p1);
        system.addLoginCredentials(p1.getUsername(), p1.getPassword());
        system.addListOfPeople(p2);
        system.addLoginCredentials(p2.getUsername(), p2.getPassword());
        system.addListOfPeople(p3);
        system.addLoginCredentials(p3.getUsername(), p3.getPassword());
        system.addListOfPeople(p4);
        system.addLoginCredentials(p4.getUsername(), p4.getPassword());

        //initialize resorts
        Location l1=new Location("Karolou Koun 53","Thessaloniki",56626);
        Facilities f1=new Facilities();
        f1.addfacilities('a',1);
        f1.addfacilities('b',1);
        Accomodation a1=new Accomodation(p1,"Hotel in Greece",1,l1,"Great hotel with 200 rooms.",f1);
        LocalDate date=LocalDate.now();
        Review r1=new Review(p3,"Nice hotel!",4.5,date,p3.getName());
        Review r11=new Review(p4,"Bad hotel!",2.5,date,p4.getName());

        Location l2=new Location("Marousiou 12","Athens",56426);
        Facilities f2=new Facilities();
        f2.addfacilities('c',1);
        f2.addfacilities('d',1);
        Accomodation a2=new Accomodation(p1,"Flat in Athens",2,l2,"Big flat with a lot of space.",f2);
        Review r2=new Review(p3,"Didn't like it!",2.5,date,p3.getName());
        Review r22=new Review(p4,"Small apartment",1.5,date,p4.getName());

        Location l3=new Location("Mayorka 123","Madrid",12622);
        Facilities f3=new Facilities();
        f3.addfacilities('e',2);
        f3.addfacilities('g',4);
        Accomodation a3=new Accomodation(p1,"Fancy maisonette",3,l3,"Luxurious maisonette.",f3);
        Review r3=new Review(p3,"The best maisonette!",5,date,p3.getName());
        Review r33=new Review(p4,"Great place.",4.5,date,p4.getName());

        Location l4=new Location("Karakas 345","Papua",16636);
        Facilities f4=new Facilities();
        f4.addfacilities('g',6);
        f4.addfacilities('g',1);
        Accomodation a4=new Accomodation(p1,"Hotel in Peru",1,l4,"Motel with 20 rooms.",f4);
        Review r4=new Review(p3,"Didn't like it at all!",1,date,p3.getName());
        Review r44=new Review(p4,"Don't recommend.",2,date,p4.getName());

        Location l5=new Location("Albeit 553","Johanessburg",73026);
        Facilities f5=new Facilities();
        f5.addfacilities('g',7);
        f5.addfacilities('h',2);
        Accomodation a5=new Accomodation(p1,"Hostel in South Africa",1,l5,"Great cozy hostel with 15 rooms.",f5);
        Review r5=new Review(p3,"It was ok.",3,date,p3.getName());
        Review r55=new Review(p4,"Average hostel.",3,date,p4.getName());

        Location l6=new Location("Monteu 821","Paris",54026);
        Facilities f6=new Facilities();
        f6.addfacilities('g',4);
        f6.addfacilities('b',1);
        Accomodation a6=new Accomodation(p2,"Flat in South France",2,l6,"Flat next to Eiffel Tower.",f6);
        Review r6=new Review(p3,"Great apartment with a lot of space.",5,date,p3.getName());
        Review r66=new Review(p4,"Definitely i recommend it to anybody.",4,date,p4.getName());

        Location l7=new Location("Nikols 53","Budapest",63080);
        Facilities f7=new Facilities();
        f7.addfacilities('a',2);
        f7.addfacilities('c',2);
        Accomodation a7=new Accomodation(p2,"Hotel in Austria",1,l7,"Big tourist hotel in midtown.",f7);
        Review r7=new Review(p3,"Good hotel, nice rooms.",4,date,p3.getName());
        Review r77=new Review(p4,"Food was bad.",2.5,date,p4.getName());

        Location l8=new Location("Karatzoglou 90","Athens", 1225);
        Facilities f8=new Facilities();
        f8.addfacilities('a',6);
        f8.addfacilities('d',1);
        Accomodation a8=new Accomodation(p2,"Flat in Athens",2,l8,"Apartment in 6th floor.",f8);
        Review r8=new Review(p3,"I will go back next year.",4.5,date,p3.getName());
        Review r88=new Review(p4,"Quite expensive.",2.5,date,p4.getName());

        Location l9=new Location("Amanetiou 1","Larissa",22211);
        Facilities f9=new Facilities();
        f9.addfacilities('e',2);
        f9.addfacilities('e',3);
        Accomodation a9=new Accomodation(p2,"Maisonette in Greece",3,l9,"Luxurious maisonette with big storage rooms.",f9);
        Review r9=new Review(p3,"Overpriced!",2,date,p3.getName());
        Review r99=new Review(p4,"Very overpriced.",1,date,p4.getName());

        Location l10=new Location("Agiou Meletiou 129","Athens",56632);
        Facilities f10=new Facilities();
        f10.addfacilities('f',2);
        f10.addfacilities('d',1);
        Accomodation a10=new Accomodation(p2,"Hotel in Greece",1,l10,"Beautiful historic hotel.",f10);
        Review r10=new Review(p3,"Good experience!",3.5,date,p3.getName());
        Review r1010=new Review(p4,"Cheap hotel.",3,date,p4.getName());

        //add accommodation to myResorts list for each provider
        p1.addMyResorts(a1);
        p1.addMyResorts(a2);
        p1.addMyResorts(a3);
        p1.addMyResorts(a4);
        p1.addMyResorts(a5);
        p2.addMyResorts(a6);
        p2.addMyResorts(a7);
        p2.addMyResorts(a8);
        p2.addMyResorts(a9);
        p2.addMyResorts(a10);
        //add accommodation to listOfResorts
        system.addListOfResorts(a1);
        system.addListOfResorts(a2);
        system.addListOfResorts(a3);
        system.addListOfResorts(a4);
        system.addListOfResorts(a5);
        system.addListOfResorts(a6);
        system.addListOfResorts(a7);
        system.addListOfResorts(a8);
        system.addListOfResorts(a9);
        system.addListOfResorts(a10);

        //add reviewed resorts to myReviewed list for each user
        p3.addMyReviewed(a1);
        p3.addMyReviewed(a2);
        p3.addMyReviewed(a3);
        p3.addMyReviewed(a4);
        p3.addMyReviewed(a5);
        p3.addMyReviewed(a6);
        p3.addMyReviewed(a7);
        p3.addMyReviewed(a8);
        p3.addMyReviewed(a9);
        p3.addMyReviewed(a10);
        p4.addMyReviewed(a1);
        p4.addMyReviewed(a2);
        p4.addMyReviewed(a3);
        p4.addMyReviewed(a4);
        p4.addMyReviewed(a5);
        p4.addMyReviewed(a6);
        p4.addMyReviewed(a7);
        p4.addMyReviewed(a8);
        p4.addMyReviewed(a9);
        p4.addMyReviewed(a10);
        //add reviews to listOfReviews of each resort
        a1.addListOfReviews(r1);
        a1.addListOfReviews(r11);
        a2.addListOfReviews(r2);
        a2.addListOfReviews(r22);
        a3.addListOfReviews(r3);
        a3.addListOfReviews(r33);
        a4.addListOfReviews(r4);
        a4.addListOfReviews(r44);
        a5.addListOfReviews(r5);
        a5.addListOfReviews(r55);
        a6.addListOfReviews(r6);
        a6.addListOfReviews(r66);
        a7.addListOfReviews(r7);
        a7.addListOfReviews(r77);
        a8.addListOfReviews(r8);
        a8.addListOfReviews(r88);
        a9.addListOfReviews(r9);
        a9.addListOfReviews(r99);
        a10.addListOfReviews(r10);
        a10.addListOfReviews(r1010);

        //save lists in files
        system.saveInFiles();

        System.out.println("***** SETUP DONE *****");
    }
}
