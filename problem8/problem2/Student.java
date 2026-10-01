public class Student {
    private final String name;

    public Student(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be blank");
        }
        this.name = name;
    }

    public String getName() { return name; }
}
