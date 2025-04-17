import java.util.ArrayList;
import java.util.List;

// Singleton class to manage all bookings
// Single Responsibility Principle - This class manages bookings and their observers
public class BookingManager {
    private static BookingManager instance;
    private Resource[] resources;
    private List<BookingObserver> observers;

    // private constructor for singleton
    private BookingManager() {
        observers = new ArrayList<>();
        // start with some demo resources
        resources = new Resource[5];
        resources[0] = new LectureHall("LH1", 50);
        resources[1] = new LectureHall("LH2", 100);
        resources[2] = new LectureHall("LH3", 200);
        resources[3] = new Lab("Lab1", 40);
        resources[4] = new Lab("Lab2", 80);
    }

    public static BookingManager getInstance() {
        if (instance == null) {
            instance = new BookingManager();
        }
        return instance;
    }

    // Observer Pattern methods
    public void addObserver(BookingObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(String message) {
        for (BookingObserver observer : observers) {
            observer.onBookingUpdated(message);
        }
    }

    public Resource[] getResources() {
        return resources;
    }

    // Dependency Inversion Principle - Depends on BookingStrategy interface, not
    // concrete implementations
    public boolean bookResource(Resource resource, String timeSlot, BookingStrategy strategy) {
        if (strategy.validateBooking(resource, timeSlot)) {
            resource.setAvailable(false);
            notifyObservers("Resource " + resource.getName() + " booked for " + timeSlot);
            return true;
        }
        return false;
    }
}
