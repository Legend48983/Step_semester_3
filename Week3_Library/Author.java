public class Author {
    private String name;
    private int numberOfBooksWritten;
    private String bio;

    public Author(String name, int numberOfBooksWritten, String bio) {
        this.name = name;
        this.numberOfBooksWritten = numberOfBooksWritten;
        this.bio = bio;
    }

    public void displayBio() {
        System.out.println("Author: " + name);
        System.out.println("Books Written: " + numberOfBooksWritten);
        System.out.println("Bio: " + bio);
    }

    public String getName() {
        return name;
    }
}