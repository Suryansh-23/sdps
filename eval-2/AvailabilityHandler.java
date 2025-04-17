// Checks if resource is available
public class AvailabilityHandler extends BookingHandler {
    public boolean handle(Resource resource, String timeSlot, String requester) {
        if (!resource.isAvailable()) {
            System.out.println("Resource " + resource.getName() + " is not available");
            return false;
        }

        if (nextHandler != null) {
            return nextHandler.handle(resource, timeSlot, requester);
        }
        return true;
    }
}
