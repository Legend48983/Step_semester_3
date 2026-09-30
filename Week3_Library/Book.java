public class Book {
    private String title;
    private Author author;
    private int publicationYear;
    private boolean available;

    public Book(String title, Author author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.available = true;
    }

    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author.getName());
        System.out.println("Publication Year: " + publicationYear);
        System.out.println("Available: " + available);
    }

    public boolean checkAvailability() {
        return available;
    }

    public void borrowBook() {
        if (available) {
            available = false;
            System.out.println(title + " borrowed successfully.");
        } else {
            System.out.println(title + " is not available.");
        }
    }

    public void returnBook() {
        available = true;
        System.out.println(title + " returned successfully.");
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }
}