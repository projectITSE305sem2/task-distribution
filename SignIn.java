
//  ITSE305 Phase2 - Batool Ahmed Abdulla Alasmawi  202107846   sec 01
import java.util.*;
import java.util.Scanner;

// SignIn class
public class SignIn {
    // our data/attributes values
    private String[] usernames = { "ali", "yousif", "fatima" };
    private String[] passwords = { "password1", "password2", "password3" };

    // method to verification ( check user inputs)
    public boolean authenticate(String username, String password) {
        // Logic to authenticate the user
        // Check if the username and password match the stored values

        for (int i = 0; i < usernames.length; i++) {
            if (username.equals(usernames[i]) && password.equals(passwords[i])) {
                return true; // Authentication successful
            }
        }
        return false; // Authentication failed
    }

    // method to ask the user to enter her/his username and password to Sign in to
    // the system, system will pop up a successful/failed message, depend on user
    // inputs
    public void userSignIn() {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Welcome to ITSE305sem2 system project !!");

        System.out.print("Enter your username: ");
        String username = userInput.nextLine();

        System.out.print("Enter your password: ");
        String password = userInput.nextLine();

        if (authenticate(username, password)) {
            System.out.println("Sign in successful!");
        } else {
            System.out.println("Sign in failed. Invalid username or password.");
        }

        userInput.close(); // closing
    }

    // Main class, to excute/run the code we call the method
    // here we call SignIn.userSignIn() that will propote the user to enter her/his
    // username and password,
    // then check for verification. finally, a message will appears
    // (successful/failed )
    public static void main(String[] args) {
        SignIn signIn = new SignIn();
        signIn.userSignIn();
    }
}