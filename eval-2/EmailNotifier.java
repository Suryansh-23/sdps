// Single Responsibility Principle - This class only handles notifications
public class EmailNotifier implements BookingObserver {
    public void onBookingUpdated(String message) {
        // In real app, this would send an email
        System.out.println("Email notification: " + message);
    }
}
