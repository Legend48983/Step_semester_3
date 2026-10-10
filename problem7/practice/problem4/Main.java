abstract class ClassroomDevice { public abstract String operate(); }
interface Chargeable { String charge(); String charge(int minutes); }
class Tablet extends ClassroomDevice implements Chargeable {
    private final String assetTag;
    Tablet(String tag) { if (tag == null || tag.trim().isEmpty()) throw new IllegalArgumentException(); assetTag = tag; }
    public String operate() { return "Tablet " + assetTag + " displaying lesson"; }
    public String charge() { return assetTag + " charging"; }
    public String charge(int minutes) { if (minutes <= 0) throw new IllegalArgumentException(); return assetTag + " charging for " + minutes + " minutes"; }
}
public class Main {
    public static void main(String[] args) {
        Tablet t = new Tablet("TAB-5");
        System.out.println(t.operate()); System.out.println(t.charge()); System.out.println(t.charge(30));
    }
}