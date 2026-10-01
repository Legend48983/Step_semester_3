public abstract class Drone {
    protected final String id;

    protected Drone(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("id cannot be blank");
        }
        this.id = id;
    }

    public abstract String fly();
}
