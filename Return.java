import java.util.Scanner;

public class Return {
    private String[] usernames = { "ali", "yousif", "fatima" };
    private String[] passwords = { "password1", "password2", "password3" };
    private String[] ISBN = { "12345", "55543", "67890" };

    public Return() {}

    public boolean login(String username, String password) {
        for (int i = 0; i < usernames.length; i++) {
            if (username.equals(usernames[i]) && password.equals(passwords[i])) {
                return true;
            }
        }
        return false;
    }

    public String returnBook(String username, String password, String bookISBN) {
        // Suggestions by Batool - Check for null or empty inputs
        if (username == null || username.isEmpty()) {
            System.out.println("Username is required.");
            System.exit(0);
        }

        if (password == null || password.isEmpty()) {
            System.out.println("Password is required.");
            System.exit(0);
        }

        if (bookISBN == null || bookISBN.isEmpty()) {
            System.out.println("Book ISBN is required.");
            System.exit(0);
        }

        // Check if username and password match
        if (!login(username, password)) {
            System.out.println("Invalid username or password. Please try again.");
            System.exit(0);
        }

        double payment = getPayment(username);
        if (payment != 0) {
            // Suggestions by batool- Display payment amount if there is an unfinished payment
            System.out.println("Please settle your payment of $" + payment + " before returning a book.");
            System.exit(0);
        }

        boolean validISBN = false;
        for (String isbn : ISBN) {
            if (isbn.equals(bookISBN)) {
                validISBN = true;
                break;
            }
        }

        if (validISBN) {
            return "Thank you for returning the book with ISBN " + bookISBN;
        } else {
            return "Invalid book ISBN.";
        }
    }

    private double getPayment(String username) {
        // Implement your payment retrieval logic here
        return 5.0;
    }

    public static void main(String[] args) {
        Return r = new Return();

        Scanner kb = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String username = kb.nextLine();

        System.out.print("Enter your password: ");
        String password = kb.nextLine();

        System.out.print("Enter the book ISBN: ");
        String bookISBN = kb.nextLine();

        String result = r.returnBook(username, password, bookISBN);
        System.out.println(result);
    }
}
