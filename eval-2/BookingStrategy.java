// Strategy pattern interface for different booking rules
public interface BookingStrategy {
    boolean validateBooking(Resource resource, String timeSlot);
}
