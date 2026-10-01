import java.util.HashSet;
import java.util.Set;

public class Show {
    private final String showId;
    private final String showTime;
    private final Set<String> bookedSeatIds = new HashSet<>();

    public Show(String showId, String showTime) {
        if (showId == null || showId.trim().isEmpty() || showTime == null || showTime.trim().isEmpty()) {
            throw new IllegalArgumentException("Show details cannot be blank");
        }
        this.showId = showId;
        this.showTime = showTime;
    }

    public String getShowId() { return showId; }
    public String getShowTime() { return showTime; }

    public boolean isSeatAvailable(Seat seat) {
        return seat != null && !bookedSeatIds.contains(seat.getId());
    }

    boolean reserve(Seat seat) {
        return seat != null && bookedSeatIds.add(seat.getId());
    }

    void release(Seat seat) {
        if (seat != null) bookedSeatIds.remove(seat.getId());
    }
}
