import java.util.ArrayList;
import java.util.Scanner;

public class Phone {

    /*
       1- Create instance variables
       phoneBrand, phoneModel, SerialNumber, passCode and ArrayList<Contact> allContact
       2- Create constructor to initialize this variables
       3- Create the method to add new contact this method take one parameter as Contact
       4- Create the method to print all Contacts' first and last name with phone number
       5- Create the method to update person's phone number. This method takes two parameter old phone number and new phone number
       6- Create the method to search with phone number and print all other information for person -->
       7- create the method to search with name of person and print phone number of person
       8- Create the method to update city of person with new city, you need two parameter one is phone number of person another is new email address.
       9- Create the method to update email address for person with new email address, you need two parameter oldEmail and newEmail

       In this contact list only two things are unique Phone number and email address. You can not store same phone number and email address two times
       because of that before adding the new contact you need to make sure this phone number is not exist in your Contact arraylist.
     */
    ArrayList<Contact> allContact = new ArrayList<>();
    String phoneBrand;
    String phoneModel;
    int SerialNumber;
    int passCode;


    Phone(String phoneBrand, String phoneModel, int SerialNumber, int passCode) {
        this.phoneBrand = phoneBrand;
        this.phoneModel = phoneModel;
        this.SerialNumber = SerialNumber;
        this.passCode = passCode;
        this.allContact = new ArrayList<Contact>();

    }

    public void NewContact(Contact contact2) {
        allContact.add(contact2);
        Contact contact = Contact.objectCreationMethod();
        Scanner scanner= new Scanner (System.in);
        System.out.println("Enter first name");
        String input = scanner.nextLine();
        contact.setFirstName(input);
        System.out.println("Enter last name");

        String input1 = scanner.nextLine();
        contact.setLastName(input1);
        System.out.println("Enter your phone number");

        String input2 = scanner.nextLine();
        contact.setPhoneNumber(input2);
        System.out.println("Enter your email");

        String input3 = scanner.nextLine();
        contact.setEmails(input3);
        System.out.println("Enter your city");
        String input4 = scanner.nextLine();
        contact.setCity(input4);

        System.out.println("Enter your company name");
        String input5 = scanner.nextLine();
        contact.setCompany(input5);

        PhoneAppRunner.printOptions();




    }

    public void allContacts() {
        Contact temp = Contact.objectCreationMethod();
        System.out.println("First name " + temp.getFirstName());
        System.out.println("Last name " + temp.getLastName());
        System.out.println("Phone number " + temp.getPhoneNumber());

    }

    public void updatePhoneNumber(String NewPhoneNumber, String OldPhoneNumber) {
        boolean valid = false;
        Contact temp1 = Contact.objectCreationMethod();
        Scanner scanner = new Scanner(System.in);
        if (temp1.getPhoneNumber() == OldPhoneNumber) {
            System.out.println("Are you " + temp1.getFirstName() + "?Y/N");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("y")) {
                System.out.println("Enter new phone number :");
                String new_number = scanner.nextLine();
                temp1.setPhoneNumber(NewPhoneNumber);
                System.out.println("Your new phone number is :" + NewPhoneNumber);

            } else {
                System.out.println(NewPhoneNumber + " is not valid does or does not exist");
            }

        }


    }

    public void searchWithPhoneNumber() {
        Contact temp2 = Contact.objectCreationMethod();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a phone number");
        String input = scanner.nextLine();
        if (temp2.getPhoneNumber().equalsIgnoreCase(input)) {
            System.out.println("First name: " + temp2.getFirstName());
            System.out.println(" Last name " + temp2.getLastName());
            System.out.println("Email: " + temp2.getEmails());
            System.out.println("city " + temp2.getCity());
            System.out.println("Company : " + temp2.getCompany());
        } else {
            System.out.println("The process can't be completed,try again");
        }
    }

    public void searchWithName() {
        Contact temp2 = Contact.objectCreationMethod();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please,enter a First name");
        String input = scanner.nextLine();
        if (temp2.getFirstName().equalsIgnoreCase(input)) {
            System.out.println(temp2.getPhoneNumber());

        } else {
            System.out.println("The process can't be completed,try again");
        }


    }//8- Create the method to update city of person with new city, you need two parameter one is phone number of person another

    public void updateCity(String phone_number, String email) {
        boolean valid = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a city name");
        String input = scanner.nextLine();
        for (Contact update : allContact) {
            if (update.getCity().equalsIgnoreCase(input)) {
                update.setCity(input);
                update.setPhoneNumber(phone_number);
                update.setEmails(email);
                System.out.println("Your updated city is :" + input);
                valid = true;
            }
        }
        if (!valid) {
            System.out.println("The process can't be completed,try again");
        }
    }

    public void updateEmail(String OldEmail, String NewEmail) {
        Scanner scanner = new Scanner(System.in);
        for (Contact email : allContact) {
            if (email.getEmails() == OldEmail) {
                System.out.println("are you " + email.getFirstName() + "? Y/N");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("y")) {
                    System.out.println("Enter the new Email: ");
                    String newEmail = scanner.nextLine();
                    email.setEmails(NewEmail);
                    System.out.println("Your updated email is: " + NewEmail);
                } else {
                    System.out.println("Sorry, the process can not be completed");
                }
            }
        }
    }
}


