package command;

import devices.Light;
import interfaces.Command;

public class TurnOnCommand implements Command {
    private Light light;

    public TurnOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.setStatus(true);
    }
}
