package contactsManager;

//contacts object being called in Display
public class Contacts {

    private String name;
    private String number;

//    constructor
    Contacts(String name, String number){
        this.name = name;
        this.number = number;
    }

//    getter
    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }



}
