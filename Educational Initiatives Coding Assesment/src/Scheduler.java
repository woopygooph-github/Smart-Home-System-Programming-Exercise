import interfaces.Command;
import interfaces.Device;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    private List<ScheduledTask> tasks;

    public Scheduler() {
        this.tasks = new ArrayList<>();
    }

    public void scheduleTask(Device device, String time, Command command) {
        tasks.add(new ScheduledTask(device.getId(), time, command));
    }

    public void runScheduledTasks() {
        for (ScheduledTask task : tasks) {
            System.out.println("Scheduled task for device " + task.getDeviceId() + " at " + task.getTime() + ": " + task.getCommandDescription());
            task.execute();
        }
    }

    public List<ScheduledTask> getTasks() {
        return tasks;
    }

    public static class ScheduledTask {
        private int deviceId;
        private String time;
        private Command command;

        public ScheduledTask(int deviceId, String time, Command command) {
            this.deviceId = deviceId;
            this.time = time;
            this.command = command;
        }

        public int getDeviceId() {
            return deviceId;
        }

        public String getTime() {
            return time;
        }

        public String getCommandDescription() {
            return command.getClass().getSimpleName();
        }

        public void execute() {
            command.execute();
        }
    }
}