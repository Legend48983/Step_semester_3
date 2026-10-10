abstract class Drone { abstract String fly(); }
interface Trackable { String getLocation(); }
class DeliveryDrone extends Drone implements Trackable {
    private final String id, location;
    DeliveryDrone(String id, String location) { this.id=id; this.location=location; }
    String fly() { return "Delivery drone " + id + " flying"; }
    public String getLocation() { return location; }
}
class ScoutDrone extends Drone {
    ScoutDrone(String id) { }
    String fly() { return "Scout drone flying"; }
}
class GroundRobot implements Trackable {
    private final String location;
    GroundRobot(String location) { this.location=location; }
    public String getLocation() { return location; }
}
public class Main {
    static String locate(Object object) {
        if (object instanceof Trackable) return ((Trackable)object).getLocation();
        return "Tracking isn't available";
    }
    public static void main(String[] args) {
        Object[] fleet = {new DeliveryDrone("D1","Sector 4"), new ScoutDrone("S1"), new GroundRobot("Lab")};
        for (Object item : fleet) System.out.println(locate(item));
    }
}