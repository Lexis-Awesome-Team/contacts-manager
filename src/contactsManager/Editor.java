    package contactsManager;

    import java.io.File;
    import java.io.IOException;
    import java.nio.file.Files;
    import java.nio.file.StandardOpenOption;
    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.Dictionary;
    import java.util.List;


    class Editor {
    static void addContact(){
        String name = "";
        String number = "";
        name = Manager.userInput.getString("Please enter name:");
        number = Manager.userInput.getString("Please enter number:");
        number = number.replaceAll("[^0-9]", "");
        if (number.length() == 10 || number.length() == 7) {
            if (number.length()==10) {
                number = "(" + number.substring(0, 3) + ")" + number.substring(3, 6) + "-" + number.substring(6, 9) + number.charAt(9);
            } else {
                number = number.substring(0, 3) + "-" + number.substring(3, 6) + number.charAt(6);
            }
        if (verifyContact(name)){
            if(Manager.userInput.yesNo("Contact already exists would you like to overwrite it? [y/n]")){
                for(String contact: Display.contacts){
                    if (contact.toLowerCase().contains(name.toLowerCase())){
                        Display.contacts.set(Display.contacts.indexOf(contact), name + " | " + number);
                    }
                }
            }

        }
        else {
            String contact = name.trim() + " | " + number.trim();
            Display.contacts.add(contact);
            System.out.println("Contact added: \n" + contact);
        }
            try{
                Files.write(Display.filePath, Display.contacts);
            }catch (IOException e){
                e.printStackTrace();
            }
            Display.updateContacts();
            Display.constructContacts();
            System.out.println();
        } else {
                System.out.println("Please enter a valid 7 or 10 digit number.");
            }
         }

    static void deleteContact(){
            //  display contacts so user can choose one to delete
            //  contcts is a copy of contacts array
        List<String> contcts = new ArrayList<>();
        System.out.println("All Contacts:");
        Display.viewContacts();
        String nameToDelete = Manager.userInput.getString("Enter full name of contact you want to delete:\n");
        String contactToDelete = "";
        boolean confirm = false;
        boolean contactExists = false;
        for (Contacts contact: Display.people) {
            if(contact.getName().toLowerCase().contains(nameToDelete.toLowerCase().trim())){
                contactExists = true;
                System.out.println("You entered:\n" + contact.getName() + " | " + contact.getNumber());
                confirm = Manager.userInput.yesNo("Are you sure you want to delete this contact? [y/n]\n");
                contactToDelete = contact.getName();
            }
        }
        if (confirm) {
            for(Contacts contact: Display.people) {
                if(contact.getName().equalsIgnoreCase(contactToDelete.trim())){
                    continue;
                    } else {
                        contcts.add(contact.getName() + " | " + contact.getNumber());
                    }
                }
            System.out.println("Contact Deleted.");
            try {
                Files.write(Display.filePath,contcts);
            } catch (IOException e) {
                e.printStackTrace();
            }


            }
            else {
                System.out.println("Nothing was deleted.");
            }
            Display.updateContacts();
            Display.constructContacts();

            if(!contactExists){
                System.out.println("Contact does not exist.");
            }

    }

    static boolean verifyContact(String name){
        boolean contactExists = false;
        for(Contacts contact : Display.people){
            if (contact.getName().equalsIgnoreCase(name.trim())){
                contactExists = true;
            }
        }
        return contactExists;
    }


        //CLOSES THE CLASS
}

