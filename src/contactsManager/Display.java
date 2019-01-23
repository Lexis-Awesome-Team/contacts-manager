package contactsManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

class Display {

   static Path filePath = Paths.get("data","contacts.txt");

   static List<String>contacts;

   static {
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
       System.out.println("Name | Phone number\n" +
       "-------------------");
       for(String contact : contacts){
           System.out.println(contact);
       }
   }


   static void searchContacts(){
       int searchChoice = Manager.userInput.getInt("How would you like to search?\n 1. Name\n 2. Number\n");
       switch(searchChoice){
           case 1:
           // search by name
               System.out.println("Search by Name");
               boolean contactExists = false;
               String nameSearch = Manager.userInput.getString("Please enter a name:\n");
               for(String contact: contacts ){
                   if (contact.substring(0, contact.indexOf("|")).contains(nameSearch)){
                       contactExists = true;
                       System.out.println(contact);
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
           for(String contact : contacts ){
               if (contact.substring(contact.indexOf("|"), contact.length()-1).contains(nameSearch)){
                   contactExists = true;
                   System.out.println(contact);
               }
           }
           if(!contactExists) {
               System.out.println("No contact matching that number;");
           }
           break;
       }

   }

}
