
<<<<<<< HEAD
=======
public class Return  {
    // An array that contains registered students' usernames and associated passwords, ISBNS
    private String[] usernames = { "ali", "yousif", "fatima" };
    private String[] passwords = { "password1", "password2", "password3" };
    private String[] ISBN = { "12345", "55543", "67890" };

    public Return() {}

    public boolean login(String username, String password) {
        for (int i = 0; i < usernames.length; i++) {
            if (username.equals(usernames[i]) && password.equals(passwords[i])) {
                System.out.println("Hi " + usernames[i] + ", you have successfully logged in.");
                return true;
            }
        }
        System.out.println("Invalid username or password. Please try again.");
        return false;
    }

    public void returnBook(String username, String password, String bookISBN) {
        if (!login(username, password)) {
            return;
        }

        // Check if payment is zero (assuming it's stored somewhere)
        double payment = getPayment(username);  // Replace with your payment retrieval logic
        if (payment != 0) {
            System.out.println("Please settle your payment before returning a book.");
            return;
        }

        // Check if the book ISBN is available in the ISBN array
        boolean validISBN = false;
        for (String isbn : ISBN) {
            if (isbn.equals(bookISBN)) {
                validISBN = true;
                break;
            }
        }

        if (validISBN) {
            // Allow return and show message
            System.out.println("Thank you for returning the book with ISBN " + bookISBN);
        } else {
            System.out.println("Invalid book ISBN.");
        }
    }

    // payment method have to be implemented, we have the case where when the book due date is passed
    // then there is an amount of money that have to be paid by the user
    private double getPayment(String username) {
        // the method should be implemented and we have to integrate the different ways of paying online
        return 0.0;
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

        r.returnBook(username, password, bookISBN);
    }
}

>>>>>>> 2aff7af0100b0b89acad6e016d6852dc92ce2285