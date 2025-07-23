public class Books {
    
    int bookId;
    String title;
    String author;
    boolean isIssued;

    Books(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    void displayInfo() {
        System.out.println("ID: " + bookId + " | Title: " + title + " | Author: " + author + " | Status: " + (isIssued ? "Issued" : "Available"));
    }
}

