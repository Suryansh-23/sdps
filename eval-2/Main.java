public class Main {
    public static void main(String[] args) {
        // Get our singleton booking manager
        BookingManager manager = BookingManager.getInstance();

        // Add observers (Observer Pattern)
        manager.addObserver(new EmailNotifier());

        // Setup our chain of handlers (Chain of Responsibility Pattern)
        BookingHandler availabilityHandler = new AvailabilityHandler();
        BookingHandler timeSlotHandler = new TimeSlotHandler();
        availabilityHandler.setNext(timeSlotHandler);

        // Different booking strategies (Strategy Pattern)
        BookingStrategy basicStrategy = new BasicBookingStrategy();
        BookingStrategy smallGroupStrategy = new CapacityBookingStrategy(75);
        BookingStrategy largeGroupStrategy = new CapacityBookingStrategy(150);

        Resource[] resources = manager.getResources();

        System.out.println("\n=== Basic Booking Strategy ===");
        // Try booking a lecture hall with basic strategy
        if (manager.bookResource(resources[0], "9AM-10AM", basicStrategy)) {
            System.out.println("Successfully booked " + resources[0].getName());
        }

        // Try booking the same resource again (should fail)
        System.out.println("\n=== Double Booking ===");
        if (manager.bookResource(resources[0], "9AM-10AM", basicStrategy)) {
            System.out.println("Successfully booked " + resources[0].getName());
        } else {
            System.out.println("Booking failed - resource already booked");
        }

        System.out.println("\n=== Lab Booking ===");
        // Try booking a lab
        if (manager.bookResource(resources[3], "2PM-4PM", basicStrategy)) {
            System.out.println("Successfully booked " + resources[3].getName());
        }

        System.out.println("\n=== Different Capacity Requirements ===");
        // Try booking with small group capacity (75 seats)
        if (manager.bookResource(resources[1], "2PM-4PM", smallGroupStrategy)) {
            System.out.println("Successfully booked " + resources[1].getName() + " for small group");
        } else {
            System.out.println("Booking failed - insufficient capacity for small group");
        }

        // Try booking with large group capacity (150 seats)
        if (manager.bookResource(resources[1], "3PM-5PM", largeGroupStrategy)) {
            System.out.println("Successfully booked " + resources[1].getName() + " for large group");
        } else {
            System.out.println("Booking failed - insufficient capacity for large group");
        }

        // Try booking the largest hall for a large group
        if (manager.bookResource(resources[2], "1PM-3PM", largeGroupStrategy)) {
            System.out.println("Successfully booked " + resources[2].getName() + " for large group");
        } else {
            System.out.println("Booking failed - insufficient capacity for large group");
        }

        System.out.println("\n=== Lab Capacity Limits ===");
        // Try booking a lab with capacity requirements (should fail as labs are
        // smaller)
        if (manager.bookResource(resources[3], "3PM-5PM", smallGroupStrategy)) {
            System.out.println("Successfully booked " + resources[3].getName());
        } else {
            System.out.println("Booking failed - lab doesn't have enough capacity");
        }
    }
}
