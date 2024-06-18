package command;

import devices.Thermostat;
import interfaces.Command;

public class SetScheduleCommand implements Command {
    private Thermostat thermostat;
    private String time;

    public SetScheduleCommand(Thermostat thermostat, String time) {
        this.thermostat = thermostat;
        this.time = time;
    }

    @Override
    public void execute() {
        System.out.println("Scheduled task set for Thermostat at " + time);
    }
}
