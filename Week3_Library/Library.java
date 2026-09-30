public class Library {
    private Book[] books;
    private int bookCount;

    public Library(int size) {
        books = new Book[size];
        bookCount = 0;
    }

    public void addBook(Book book) {
        if (bookCount < books.length) {
            books[bookCount] = book;
            bookCount++;
            System.out.println("Book added: " + book.getTitle());
        } else {
            System.out.println("Library is full.");
        }
    }

    public void borrowBook(String title) {
        Book book = findByTitle(title);
        if (book != null) book.borrowBook();
        else System.out.println("Book not found.");
    }

    public void returnBook(String title) {
        Book book = findByTitle(title);
        if (book != null) book.returnBook();
        else System.out.println("Book not found.");
    }

    public void searchByTitle(String title) {
        Book book = findByTitle(title);
        if (book != null) book.displayDetails();
        else System.out.println("No book found with that title.");
    }

    public void searchByAuthor(String authorName) {
        boolean found = false;
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getAuthor().getName().equalsIgnoreCase(authorName)) {
                books[i].displayDetails();
                found = true;
            }
        }
        if (!found) System.out.println("No books found for that author.");
    }

    private Book findByTitle(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) return books[i];
        }
        return null;
    }

    public static void main(String[] args) {
        Author author1 = new Author("J.K. Rowling", 7,
                "British author known for the Harry Potter series.");
        Author author2 = new Author("George Orwell", 9,
                "English novelist and essayist.");

        Library library = new Library(5);
        Book book1 = new Book("Harry Potter", author1, 1997);
        Book book2 = new Book("1984", author2, 1949);

        System.out.println("===== LIBRARY SYSTEM =====");

        library.addBook(book1);
        library.addBook(book2);

        System.out.println("\n--- Book Details ---");
        book1.displayDetails();

        System.out.println("\n--- Borrow Book ---");
        library.borrowBook("Harry Potter");
        System.out.println("Available: " + book1.checkAvailability());

        System.out.println("\n--- Search by Title ---");
        library.searchByTitle("1984");

        System.out.println("\n--- Search by Author ---");
        library.searchByAuthor("George Orwell");

        System.out.println("\n--- Return Book ---");
        library.returnBook("Harry Potter");

        System.out.println("\n--- Author Bio ---");
        author1.displayBio();
    }
}