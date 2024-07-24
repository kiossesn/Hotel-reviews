package api;

import java.io.Serializable;

/**
 * Κλάση που υλοποιεί κάποιον άνθρωπο που χρησιμοποιεί την εφαρμογή είτε είναι χρήστης είτε είναι πάροχος.
 */
public class Person implements Serializable {
    private String name,surname,username,password;

    //1 for provider, 2 for user
    int type;

    //constructor for a new person
    public Person(String name,String surname,String username,String password,int type) {
        //System.out.println("NEW PERSON...");
        this.name=name;
        this.surname=surname;
        this.username=username;
        this.password=password;
        this.type=type;
    }

    //return name
    public String getName(){
        return name;
    }
    //return surname
    public String getSurname(){
        return surname;
    }
    //return type(provider or user)
    public int getType(){
        return type;
    }
    //return username
    public String getUsername(){
        return username;
    }
    //return password
    public String getPassword(){
        return password;
    }
}
