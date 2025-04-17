// Basic time slot validation
public class BasicBookingStrategy implements BookingStrategy {
    public boolean validateBooking(Resource resource, String timeSlot) {
        // simple check if resource is available
        return resource.isAvailable();
    }
}
