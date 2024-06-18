import interfaces.Command;

public class TriggerManager {
    private String condition;
    private int threshold;
    private Command actionCommand;

    public TriggerManager(String condition, int threshold, Command actionCommand) {
        this.condition = condition;
        this.threshold = threshold;
        this.actionCommand = actionCommand;
    }

    public String getCondition() {
        return condition;
    }

    public int getThreshold() {
        return threshold;
    }

    public Command getActionCommand() {
        return actionCommand;
    }

    public void checkAndExecute(int currentTemperature) {
        if (evaluateCondition(currentTemperature)) {
            System.out.println("Trigger activated: " + condition + " > " + threshold);
            actionCommand.execute();
        }
    }

    private boolean evaluateCondition(int currentTemperature) {
        switch (condition) {
            case "temperature >":
                return currentTemperature > threshold;
            case "temperature <":
                return currentTemperature < threshold;
            case "temperature ==":
                return currentTemperature == threshold;
            default:
                return false;
        }
    }
}
