class BookInventory {
    private final int copiesTotal;
    private int copiesAvailable;
    public BookInventory(int total) {
        if (total < 1 || total > 500) throw new IllegalArgumentException("Invalid total");
        copiesTotal = total; copiesAvailable = total;
    }
    public void checkOut() { if (copiesAvailable > 0) copiesAvailable--; }
    public void checkIn() { if (copiesAvailable < copiesTotal) copiesAvailable++; }
    public int getCopiesAvailable() { return copiesAvailable; }
}
public class Main {
    public static void main(String[] args) {
        BookInventory inventory = new BookInventory(2);
        inventory.checkOut(); inventory.checkOut(); inventory.checkOut();
        System.out.println(inventory.getCopiesAvailable());
        inventory.checkIn(); inventory.checkIn(); inventory.checkIn();
        System.out.println(inventory.getCopiesAvailable());
    }
}