abstract class ArtPiece {
    private static int nextId = 1;
    private final String pieceId;
    protected final String title;
    ArtPiece(String title) {
        if (title == null || title.trim().isEmpty()) throw new IllegalArgumentException();
        this.title = title; pieceId = "ART-" + nextId++;
    }
    abstract String describe();
    String getPieceId() { return pieceId; }
}
class Painting extends ArtPiece {
    Painting(String title) { super(title); }
    String describe() { return "Painting: " + title + ", framed on canvas"; }
}
class Sculpture extends ArtPiece {
    Sculpture(String title) { super(title); }
    String describe() { return "Sculpture: " + title + ", carved from stone"; }
}
public class Main {
    public static void main(String[] args) {
        ArtPiece[] pieces = {new Painting("Sunset Fields"), new Sculpture("The Thinker II")};
        for (ArtPiece p : pieces) System.out.println(p.describe() + " (" + p.getPieceId() + ")");
    }
}