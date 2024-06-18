package devices;

import interfaces.Device;

public class Light implements Device {
    private int id;
    private String type;
    private boolean status;

    public Light(int id, boolean status) {
        this.id = id;
        this.type = "light";
        this.status = status;
    }
    

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getType() {
        return type;
    }
    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
