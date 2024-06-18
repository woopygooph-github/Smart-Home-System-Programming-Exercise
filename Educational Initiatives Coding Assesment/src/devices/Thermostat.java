package devices;

import interfaces.Device;

public class Thermostat implements Device {

    private int id;
    private String type;
    private int temperature;

    public Thermostat(int id, int temperature) {
        this.id = id;
        this.type = "thermostat";
        this.temperature = temperature;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getType() {
        return type;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}
