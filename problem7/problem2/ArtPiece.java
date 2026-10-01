public abstract class ArtPiece {
    private static int nextPieceNumber = 1000;
    private final String pieceId;

    protected ArtPiece() {
        nextPieceNumber++;
        pieceId = "ART-" + nextPieceNumber;
    }

    public abstract String describe();

    public String getPieceId() {
        return pieceId;
    }
}
