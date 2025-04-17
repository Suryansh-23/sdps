public class Lab extends Resource {
    private boolean hasComputers;

    public Lab(String name, int capacity) {
        super(name, capacity);
        this.hasComputers = true;
    }

    public boolean hasComputers() {
        return hasComputers;
    }
}
