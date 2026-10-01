public class ReclinerSeat implements Seat {
    private final String id;
    public ReclinerSeat(String id) { this.id = validate(id); }
    public String getId() { return id; }
    public double getPrice() { return 400.0; }
    private static String validate(String id) {
        if (id == null || id.trim().isEmpty()) throw new IllegalArgumentException("Seat ID cannot be blank");
        return id;
    }
}
