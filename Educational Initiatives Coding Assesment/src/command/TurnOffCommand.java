package command;

import devices.Light;
import interfaces.Command;

public class TurnOffCommand implements Command {
    private Light light;

    public TurnOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.setStatus(false);
    }
}
