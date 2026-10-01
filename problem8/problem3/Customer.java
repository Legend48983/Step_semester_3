public class Customer {
    private final String name;

    public Customer(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be blank");
        }
        this.name = name;
    }

    public String getName() { return name; }
}
