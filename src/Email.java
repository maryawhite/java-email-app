import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private String companySuffix = "aeycompany.com";
    private int defaultPasswordLength = 10;

    //constructor for firstname and last name, dept, password
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

        //call a method asking for department - return the dept
        this.department = setDepartment();

        //call a method that sets a password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is " + this.password);

        //combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;

    }

    private String setDepartment(){
        System.out.println("Department Codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter the department code:");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if(depChoice == 1){
            return "sales";
        } else if(depChoice == 2){
            return "development";
        } else if(depChoice == 3){
            return "accounting";
        } else {
            return "none";
        }
    }


    //set the mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    //set the alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }


    //methods to generate a password
//    public void generatePassword(){
//        System.out.println("Your password is:");
//        generatingRandomAlphaString();
//    }

    //generate a random String, code from Baeldung
    private String generatingRandomAlphaString() {
        int leftLimit = 97;    // letter 'a'
        int rightLimit = 122;    // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    //code from the tutorial for password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@$%&";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //change password
    public void changePassword(String password){
        this.password = password;
    }

    //get mailbox capacity
    public int getMailboxCapacity(){
        return mailboxCapacity;
    }

    public String getAlternateEmail(){
        return alternateEmail;
    }

    public String getPassword(){
        return password;
    }

    //print the information
    public String showInfo(){
        return "Display Name: " + firstName + " " + lastName +
                "\nCompany Email: " + email +
                "\nMailbox Capacity: " + mailboxCapacity + "mb";
    }

}

//generate an email firstname.lastname@department.company.com
//determine the department(sales, development, accounting) if none, leave blank
//generate a random String for a password
//have set methods to change the password, set the mailbox capacity, and define an alternate email address
//have get methods to display the name, email, and mailbox capacity
