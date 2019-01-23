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
}
