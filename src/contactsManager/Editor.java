package contactsManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Editor {
    static void addContact(){
        String name = Manager.userInput.getString("Please enter name:");
        String number = Manager.userInput.getString("Please enter number:");
        String contact = name + " | " + number;
        List<String> contactFile = Arrays.asList(contact);

        try{
            Files.write(Display.filePath, contactFile, StandardOpenOption.APPEND);
        }catch (IOException e){
            e.printStackTrace();
        }
        try {
            Display.contacts = Files.readAllLines(Display.filePath);
        } catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("Contact added: \n" + contact);
        System.out.println();
    }


    static void deleteContact(){
        //  display contacts so user can choose one to delete
        System.out.println("All Contacts:");
        Display.viewContacts();
        String nameToDelete = Manager.userInput.getString("Enter full name of contact you want to delete:");
        System.out.println("You Entered: \n" + Display.contacts.contains(nameToDelete));
    boolean confirm = Manager.userInput.yesNo("Are you sure you want to delete this contact? [y/n]");

        if (confirm) {
//            try {
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            System.out.println("Contact deleted.");
        } else {
            System.out.println("Nothing was deleted.");
        }

    }


//CLOSES THE CLASS
}

