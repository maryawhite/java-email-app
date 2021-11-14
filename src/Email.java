import java.util.Random;

public class Email {
    private String firstName;
    private String lastName;
    private String department;

    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Email(String firstName, String lastName, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDepartment() {
        return department;
    }

    //method to create the email firstname.lastname@department.company.com
    public static String generateEmailAddress(Email object){
        String emailAdd = (object.getFirstName() + "." + object.getLastName() + "@" + object.getDepartment() + ".gingerVette.com");
        return emailAdd;

    }

    public static void generatePassword(){
        System.out.println("Your password is:");
        generatingRandomAlphaString();
    }

    //generate a random String, code from Baeldung
    public static void generatingRandomAlphaString() {
        int leftLimit = 97;    // letter 'a'
        int rightLimit = 122;    // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        System.out.println(generatedString);
    }

    public static void main(String[] args) {
        Email object1 = new Email("mary", "white", "accounting");

        System.out.println(generateEmailAddress(object1));
        generatePassword();
    }
}

//generate an email firstname.lastname@department.company.com
//determine the department(sales, development, accounting) if none, leave blank
//generate a random String for a password
//have set methods to change the password, set the mailbox capacity, and define an alternate email address
//have get methods to display the name, email, and mailbox capacity
