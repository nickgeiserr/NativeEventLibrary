import EventSystem.EventDispatcher;
import EventSystem.Events.ConsoleInputEvent;
import EventSystem.Events.ConsoleOutputEvent;
import EventSystem.Modules.StringExtension;

public class EventHandler {

    @EventDispatcher.Subscriber
    public void onConsolePrintMessage(ConsoleOutputEvent event) {
        System.out.println(event.getInput());
    }

    @EventDispatcher.Subscriber
    public void onConsoleInput(ConsoleInputEvent event) {
        System.out.println(StringExtension.toPigLatin(event.input()));
    }
}
