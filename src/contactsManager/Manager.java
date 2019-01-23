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
                    System.out.println();
                    Display.viewContacts();
                    System.out.println();
                    break;
                case 2:
                    Editor.addContact();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    appRunning = false;
                    break;
            }
        }

    }
}
