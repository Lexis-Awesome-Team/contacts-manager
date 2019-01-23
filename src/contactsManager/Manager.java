package contactsManager;

import util.Input;

public class Manager {
        static Input userInput = new Input();
    public static void main(String[] args) {
        boolean appRunning = true;
        while(appRunning) {
            int menuChoice = userInput.getInt(Display.getDisplay(), 1, 5);
            switch (menuChoice){
                case 1:
                    // View all contacts
                    System.out.println();
                    Display.viewContacts();
                    System.out.println();
                    break;
                case 2:
                    // Add a new contact
                    Editor.addContact();
                    break;
                case 3:
                    // Search for a contact
                    int userChoice = userInput.getInt("\"How would you like to search?\"\n 1. Name\n 2. Number\n", 1, 2);
                    Display.searchContacts(userChoice, "");
                    System.out.println();
                    break;
                case 4:
                    // Delete a contact
                    Editor.deleteContact();
                    break;
                case 5:
                    // Exit the app
                    appRunning = false;
                    System.out.println("Goodbye.");
                    break;
            }
        }

    }
}
