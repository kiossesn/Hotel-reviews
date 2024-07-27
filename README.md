# Hotel-reviews
>This is a simple application for hotel uploads and reviews written in Java.\
>The project contains API, GUI and test files (jUnit) for the API.

**### Set Up**
>Run SetUp.java the first time you are using the system.\
>In this file there is the main function that initializes all the claasses and saves some necessary default information in the system files.

**### Run**
>After the set up, run Login.java (GUI directory) to start the application.

**### Users**
>Users of the system can be either _Providers_ (aka people uploading their hotel business) or _Users_ (aka people searching for accommodation)

**### System files**
>The application contains three files for information storing.
1.	ListOfPeople.ser : Saves a list of all the users using the system. 
(Arraylist<Person>)
2.	ListOfResorts.ser : Saves a list of all the hotels that have been uploaded on the application.  (Arraylist<Accomodation>)
3.	LoginCredentials.ser : Saves a HashMap which has the credentials (username, password) of all the Users and Providers. (HashMap<String,String>)
Information storing occurs every time the application terminates.
Information fetching occurs every time the application boots.

**### User actions**
>Simple users can do the above:
1. Login or register
2. Search for accommodation using filters
3. View hotel's information
4. Review a hotel
5. View their own dashboard (their reviews and avg rates)
6. Edit or delete reviews

**### Provider actions**
>Providers can do the above:
1. Login or register
2. Upload a new accommodation post (add facilities, information etc.)
3. View their own dashboard (see their registrations and reviews)
4. Edit or delete their uploads
