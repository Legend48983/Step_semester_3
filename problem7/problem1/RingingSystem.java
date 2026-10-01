public class RingingSystem {
    public static void ringAll(Ringable[] devices) {
        if (devices == null) {
            return;
        }

        for (Ringable device : devices) {
            if (device != null) {
                System.out.println(device.ring());
            }
        }
    }
}
