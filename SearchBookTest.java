import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class SearchBookTest {

    LinkedList<Book> booksList = new LinkedList<>();

    // @Abeermohammed11 put repeated lines in a  BeforeEach method to reduce code lines
    @BeforeEach
    void setUp() {
        booksList = new LinkedList<>();
        Book b1 = new Book("To Kill a Mockingbird", "Harper Lee", "", "J.B Lippincott & Co", "9780446310789", 1000, 1960);
        Book b2 = new Book("Pride and Prejudice", "Jane Austen", "", "T. Egerton, Whitehall", "9780141439518", 1001, 1813);
        Book b3 = new Book("The Great Gatsby", "F.Scott Fitzgerald", "", "Charles Scribner's Sons", "9780743273565", 1002, 1925);
        booksList.addLast(b1);
        booksList.addLast(b2);
        booksList.addLast(b3);
    }

    @AfterEach
    void tearDown() {
        // Clean up any resources after each test, if required
    }

    //@Abeermohammed11 Add a privte method that will help merging the tests
    private String searchAndGetResult(String targetValue) {
        String result = "not found";

        for (Book book : booksList) {
            if (book.getTitle().equalsIgnoreCase(targetValue)
                    || book.getAuthor1().equalsIgnoreCase(targetValue)
                    || book.getIsbn().equalsIgnoreCase(targetValue)) {
                result = book.getTitle() + " - " + book.getAuthor1();
                break;
            }
        }

        return result;
    }
    @Test
    void searchByTitleTest() {
        String targetTitle= "The Great Gatsby";
        String expected = "The Great Gatsby - F.Scott Fitzgerald";

        String result = searchAndGetResult(targetTitle);
        assertEquals(expected, result, "Search by title failed");
    }

    @Test
    void searchByAuthorTest() {
        String targetAuthor = "F.Scott Fitzgerald";
        String expected = "The Great Gatsby - F.Scott Fitzgerald";

        String result = searchAndGetResult(targetAuthor);
        assertEquals(expected, result, "Search by author failed");
    }

    @Test
    void searchByISBNTest() {
        String targetISBN = "9780743273565";
        String expected = "The Great Gatsby - F.Scott Fitzgerald";

        String result = searchAndGetResult(targetISBN);
        assertEquals(expected, result, "Search by ISBN failed");
    }
}