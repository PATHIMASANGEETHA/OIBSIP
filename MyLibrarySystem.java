 import java.util.*;
public class MyLibrarySystem {
    


    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Books> bookList = new ArrayList<>();
    static int nextId = 1;

    public static void main(String[] args) {
        System.out.println("📚 Welcome to the Smart Library System 📚");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Issue a Book");
            System.out.println("4. Return a Book");
            System.out.println("5. Search Book");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // flush newline

            switch (choice) {
                case 1 -> addBook();
                case 2 -> showBooks();
                case 3 -> issueBook();
                case 4 -> returnBook();
                case 5 -> searchBook();
                case 6 -> {
                    System.out.println("📕 Exiting... Thank you for using MyLibrary!");
                    return;
                }
                default -> System.out.println("❌ Invalid choice, try again.");
            }
        }
    }

    static void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author's name: ");
        String author = scanner.nextLine();
        bookList.add(new Books(nextId++, title, author));
        System.out.println("✅ Book added successfully!");
    }

    static void showBooks() {
        if (bookList.isEmpty()) {
            System.out.println("📭 No books available.");
        } else {
            System.out.println("📚 Library Book List:");
            for (Books b : bookList) {
                b.displayInfo();
            }
        }
    }

    static void issueBook() {
        System.out.print("Enter book ID to issue: ");
        int id = scanner.nextInt();
        for (Books b : bookList) {
            if (b.bookId == id && !b.isIssued) {
                b.isIssued = true;
                System.out.println("✅ Book issued to you.");
                return;
            } else if (b.bookId == id && b.isIssued) {
                System.out.println("⚠️ Book is already issued.");
                return;
            }
        }
        System.out.println("❌ Book not found.");
    }

    static void returnBook() {
        System.out.print("Enter book ID to return: ");
        int id = scanner.nextInt();
        for (Books b : bookList) {
            if (b.bookId == id && b.isIssued) {
                b.isIssued = false;
                System.out.println("✅ Book returned. Thank you!");
                return;
            } else if (b.bookId == id && !b.isIssued) {
                System.out.println("⚠️ Book was not issued.");
                return;
            }
        }
        System.out.println("❌ Book not found.");
    }

    static void searchBook() {
        System.out.print("Enter keyword to search: ");
        String keyword = scanner.nextLine().toLowerCase();
        boolean found = false;
        for (Books b : bookList) {
            if (b.title.toLowerCase().contains(keyword) || b.author.toLowerCase().contains(keyword)) {
                b.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("🔍 No matching books found.");
        }
    }
}  

