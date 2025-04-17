// Interface Segregation Principle - Small, specific interfaces
public interface BookingObserver {
    void onBookingUpdated(String message);
}
