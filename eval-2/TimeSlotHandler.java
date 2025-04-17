// Checks for time slot conflicts
public class TimeSlotHandler extends BookingHandler {
    public boolean handle(Resource resource, String timeSlot, String requester) {
        // simple time slot validation (in real app, would be more complex)
        if (timeSlot == null || timeSlot.isEmpty()) {
            System.out.println("Invalid time slot");
            return false;
        }

        if (nextHandler != null) {
            return nextHandler.handle(resource, timeSlot, requester);
        }
        return true;
    }
}
