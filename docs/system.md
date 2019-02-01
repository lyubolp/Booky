#How does the system for the app work ?

##Components list
The system has to following components:

* Classes for the different data types (Achievement, Author, Book, Friend, Review, Series, Settings, User)
* Different activities ()

## How does a book get loaded into the system ?
1. The user logs into the system
2. When the user clicks the Library, all of the user's book are loaded into the activity. (JSONLoader, which calls JSONHandler)
3. After the user clicks a book, the id of the book is transfered from LibraryActivity to bookActivity 
4. When bookActivity is created, two objects are created - book & author. We call JSONLoader to get the information about the book, then JSONHandler converts it to book object.
After that, the Author object is created and the information is displayed.
