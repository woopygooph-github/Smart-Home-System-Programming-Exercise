package command;

import interfaces.Command;

public class AddTriggerCommand implements Command {
    private String condition;
    private int threshold;
    private Command actionCommand;

    public AddTriggerCommand(String condition, int threshold, Command actionCommand) {
        this.condition = condition;
        this.threshold = threshold;
        this.actionCommand = actionCommand;
    }

    @Override
    public void execute() {
        System.out.println("Trigger added: " + condition + " > " + threshold);
    }
}
