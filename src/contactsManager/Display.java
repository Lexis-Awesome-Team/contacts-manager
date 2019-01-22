package contactsManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Display {

   static List<String>contacts;

   static {
       try {
           contacts = Files.readAllLines(Paths.get("data", "contacts.txt"));
       } catch(IOException e){
           e.printStackTrace();
       }
   }


   static void getDisplay(){
       System.out.println("1. View Contacts.\n" +
       "2. Add a new contact.\n" +
       "3. Search a contact by name.\n" +
       "4. Delete an existing account.\n" +
       "5. Exit. \n\n"+
       "Enter an option (1, 2, 3, 4, 5)\n"
       );

   }

   static void viewContacts(){
       System.out.println("Name | Phone number\n" +
       "-------------------");
   }


}
