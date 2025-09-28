import java.util.*;

// Book class
class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    @Override
    public String toString() {
        return "BookID: " + bookId + ", Title: " + title + ", Author: " + author +
               ", Available: " + isAvailable;
    }
}

// User class
class User {
    private int userId;
    private String name;
    private List<Book> borrowedBooks;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return "UserID: " + userId + ", Name: " + name + ", BorrowedBooks: " + borrowedBooks.size();
    }
}

// Library class
class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void displayBooks() {
        System.out.println("\n📚 Library Books:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void displayUsers() {
        System.out.println("\n👤 Registered Users:");
        for (User user : users) {
            System.out.println(user);
        }
    }

    public void issueBook(int bookId, int userId) {
        Book bookToIssue = findBook(bookId);
        User user = findUser(userId);

        if (bookToIssue != null && user != null) {
            if (bookToIssue.isAvailable()) {
                bookToIssue.setAvailable(false);
                user.borrowBook(bookToIssue);
                System.out.println("✅ Book issued successfully to " + user.getName());
            } else {
                System.out.println("❌ Book is not available!");
            }
        } else {
            System.out.println("❌ Book/User not found!");
        }
    }

    public void returnBook(int bookId, int userId) {
        Book bookToReturn = findBook(bookId);
        User user = findUser(userId);

        if (bookToReturn != null && user != null) {
            if (user.getBorrowedBooks().contains(bookToReturn)) {
                bookToReturn.setAvailable(true);
                user.returnBook(bookToReturn);
                System.out.println("✅ Book returned successfully by " + user.getName());
            } else {
                System.out.println("❌ This book was not borrowed by " + user.getName());
            }
        } else {
            System.out.println("❌ Book/User not found!");
        }
    }

    private Book findBook(int bookId) {
        for (Book b : books) {
            if (b.getBookId() == bookId) return b;
        }
        return null;
    }

    private User findUser(int userId) {
        for (User u : users) {
            if (u.getUserId() == userId) return u;
        }
        return null;
    }
}

// Main class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding books
        library.addBook(new Book(1, "Java Programming", "James Gosling"));
        library.addBook(new Book(2, "Python Basics", "Guido van Rossum"));
        library.addBook(new Book(3, "C++ Concepts", "Bjarne Stroustrup"));

        // Adding users
        library.addUser(new User(101, "Abhi"));
        library.addUser(new User(102, "Krushna"));

        // Display
        library.displayBooks();
        library.displayUsers();

        // Issue and Return
        library.issueBook(1, 101);
        library.issueBook(1, 102);  // not available
        library.returnBook(1, 101);
        library.issueBook(1, 102);  // now available
    }
}
