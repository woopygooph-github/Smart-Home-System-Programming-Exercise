import command.*;
import devices.Door;
import devices.Light;
import devices.Thermostat;
import interfaces.Command;
import interfaces.Device;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Device> devices = new ArrayList<>();
        devices.add(new Light(1, false));
        devices.add(new Thermostat(2, 70));
        devices.add(new Door(3, true));

        Command turnOnCommand = new TurnOnCommand((Light) devices.get(0));
        Command turnOffCommand = new TurnOffCommand((Light) devices.get(0));

        Scheduler scheduler = new Scheduler();
        scheduler.scheduleTask(devices.get(1), "06:00", turnOnCommand);

        TriggerManager triggerManager = new TriggerManager("temperature >", 75, turnOffCommand);

        int currentTemperature = 80;

        triggerManager.checkAndExecute(currentTemperature);

        scheduler.runScheduledTasks();

        printStatusReport(devices);

        printScheduledTasks(scheduler);

        printAutomatedTriggers(triggerManager);
    }

    private static void printStatusReport(List<Device> devices) {
        System.out.println("Status Report:");
        StringBuilder statusReport = new StringBuilder();
        for (Device device : devices) {
            if (device instanceof Light) {
                Light light = (Light) device;
                statusReport.append("Light ").append(light.getId()).append(" is ").append(light.getStatus() ? "On" : "Off").append(". ");
            } else if (device instanceof Thermostat) {
                Thermostat thermostat = (Thermostat) device;
                statusReport.append("Thermostat is set to ").append(thermostat.getTemperature()).append(" degrees. ");
            } else if (device instanceof Door) {
                Door door = (Door) device;
                statusReport.append("Door is ").append(door.isLocked() ? "Locked" : "Unlocked").append(". ");
            }
        }
        System.out.println(statusReport.toString());
    }

    private static void printScheduledTasks(Scheduler scheduler) {
        System.out.println("Scheduled Tasks:");
        scheduler.getTasks().forEach(task -> {
            System.out.println("{device: " + task.getDeviceId() + ", time: \"" + task.getTime() + "\", command: \"" + task.getCommandDescription() + "\"}");
        });
    }

    private static void printAutomatedTriggers(TriggerManager triggerManager) {
        System.out.println("Automated Triggers:");
        System.out.println("{condition: \"" + triggerManager.getCondition() + " " + triggerManager.getThreshold() + "\", action: \"" + triggerManager.getActionCommand().getClass().getSimpleName() + "\"}");
    }
}
