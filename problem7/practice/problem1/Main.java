interface Ringable { String ring(); }
class AlarmClock implements Ringable {
    private final String time;
    AlarmClock(String time) { if (time == null || time.trim().isEmpty()) throw new IllegalArgumentException(); this.time = time; }
    public String ring() { return "Alarm ringing for " + time; }
}
class Doorbell implements Ringable {
    private final String location;
    Doorbell(String location) { if (location == null || location.trim().isEmpty()) throw new IllegalArgumentException(); this.location = location; }
    public String ring() { return "Doorbell ringing at " + location; }
}
public class Main {
    static void ringAll(Ringable[] devices) {
        if (devices == null) return;
        for (Ringable d : devices) if (d != null) System.out.println(d.ring());
    }
    public static void main(String[] args) { ringAll(new Ringable[]{new AlarmClock("7:00 AM"), new Doorbell("Front Door")}); }
}