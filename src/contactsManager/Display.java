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
       String nameTitle = "Name";
       String phoneNumberTitle = "Phone Number   |";
       String dashedLine = "-------------------------------------------";
       System.out.format("%n%34s%n", dashedLine);
       System.out.format("|  %-21s | %11s %n%34s", nameTitle,  phoneNumberTitle, dashedLine);
       System.out.println();
       for(String contact : contacts){
          String contactName = contact.substring(0, contact.indexOf("|"));
          String contactNumber = contact.substring(contact.indexOf("|"), contact.length()-1) + contact.charAt(contact.length()-1);
          System.out.format("|  %-18s %18s  | %n", contactName, contactNumber);
       }
       System.out.format("%34s%n", dashedLine);
   }


   static void searchContacts(int choice, String name){
       boolean contactExists = false;
       switch(choice){
           case 1:
           // search by name
               System.out.println("Search by Name");
               String nameSearch = Manager.userInput.getString("Please enter a name:\n");
               for(String contact: contacts ){
                   if (contact.substring(0, contact.toLowerCase().indexOf("|")).contains(nameSearch.toLowerCase().trim())){
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
                   if (contact.toLowerCase().substring(contact.indexOf("|"), contact.length()-1).contains(nameSearch.toLowerCase().trim())){
                       contactExists = true;
                       System.out.println(contact);
                   }
               }
               if(!contactExists) {
                   System.out.println("No contact matching that number;");
               }
               break;
           case 3:
               //Used only by delete method

               break;
       }

   }

}
