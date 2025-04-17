// Base class for all resources (lecture halls and labs)
public abstract class Resource {
    private String name;
    private int capacity;
    private boolean isAvailable;

    public Resource(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.isAvailable = true;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
