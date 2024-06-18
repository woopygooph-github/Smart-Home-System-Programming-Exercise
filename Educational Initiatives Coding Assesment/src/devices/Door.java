package devices;

import interfaces.Device;

public class Door implements Device {
    private int id;
    private String type;
    private boolean locked;

    public Door(int id, boolean locked) {
        this.id = id;
        this.type = "door";
        this.locked = locked;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getType() {
        return type;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

}
