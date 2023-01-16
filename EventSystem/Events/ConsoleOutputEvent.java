package EventSystem.Events;

public class ConsoleOutputEvent {
    public final String input;

    public ConsoleOutputEvent(String consoleInput) {
        input = consoleInput;
    }

    public String getInput() {
        return input;
    }
}
