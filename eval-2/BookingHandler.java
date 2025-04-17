// Base handler for chain of responsibility
public abstract class BookingHandler {
    protected BookingHandler nextHandler;

    public void setNext(BookingHandler handler) {
        this.nextHandler = handler;
    }

    public abstract boolean handle(Resource resource, String timeSlot, String requester);
}
