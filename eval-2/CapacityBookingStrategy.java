// Another concrete strategy implementing the Strategy Pattern
// Open/Closed Principle - We can add new booking strategies without modifying existing code
public class CapacityBookingStrategy implements BookingStrategy {
    private int requiredCapacity;

    public CapacityBookingStrategy(int requiredCapacity) {
        this.requiredCapacity = requiredCapacity;
    }

    public boolean validateBooking(Resource resource, String timeSlot) {
        // Validates if the resource has enough capacity
        return resource.isAvailable() && resource.getCapacity() >= requiredCapacity;
    }
}
