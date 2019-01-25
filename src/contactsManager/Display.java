package contactsManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class Display {

    static Path filePath = Paths.get("data","contacts.txt");

    static List<Contacts> people = new ArrayList<>();
    static List<String>contacts;

    static void updateContacts(){
       try {
           contacts = Files.readAllLines(filePath);
       } catch(IOException e){
           e.printStackTrace();
       }
    }



    static String getDisplay(){
       return"1. View Contacts.\n" +
       "2. Add a new contact.\n" +
       "3. Search for a contact.\n" +
       "4. Delete an existing account.\n" +
       "5. Exit. \n\n"+
       "Enter an option (1, 2, 3, 4, 5)\n";

    }

    static void viewContacts(){
        updateContacts();
        constructContacts();
        String nameTitle = "Name";
        String phoneNumberTitle = " Phone Number    |";
        String dashedLine = "-------------------------------------------";
        System.out.format("%n%34s%n", dashedLine);
        System.out.format("|  %-19s | %11s %n%34s", nameTitle,  phoneNumberTitle, dashedLine);
        System.out.println();
        for(Contacts contact : people){
            if(contact.getName().length() > 18) {
                System.out.format("|  %-18s  | %-15s  |%n", contact.getName().substring(0,18), contact.getNumber());
            }
             else{
                 System.out.format("|  %-18s  | %-15s  |%n", contact.getName(), contact.getNumber());
             }
        }
        System.out.format("%34s%n", dashedLine);
    }


    static void searchContacts(int choice){
       boolean contactExists = false;
       updateContacts();
       constructContacts();
       switch(choice){
           case 1:
           // search by name
               System.out.println("Search by Name");
               String nameSearch = Manager.userInput.getString("Please enter a name:\n");
               for(Contacts contact: people){
                   if (contact.getName().toLowerCase().contains(nameSearch.toLowerCase().trim())){
                       contactExists = true;
                       System.out.println(contact.getName() + " | " + contact.getNumber());
                   }
               }
               if(!contactExists) {
                   System.out.println("No contact matching that name;");
               }
               break;
           case 2:
               // search by number
               System.out.println("Search by Number");
               contactExists = false;
               nameSearch = Manager.userInput.getString("Please enter a number:\n");
               for(Contacts contact : people ){
                   if (contact.getNumber().contains(nameSearch.trim())){
                       contactExists = true;
                       System.out.println(contact.getName() + " | " + contact.getNumber());
                   }
               }
               if(!contactExists) {
                   System.out.println("No contact matching that number;");
               }
               break;
       }

    }

    static void constructContacts(){
        people.clear();
        for(String contact : contacts){
            String contactName = contact.substring(0, contact.indexOf("|")).trim();
            String contactNumber = contact.substring(contact.indexOf("|")+1, contact.length()-1) + contact.charAt(contact.length()-1);
            Contacts person = new Contacts(contactName,contactNumber);
            people.add(person);
        }
    }

}
