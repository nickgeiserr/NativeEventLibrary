import EventSystem.DispatcherGlobals;
import EventSystem.EventDispatcher;
import EventSystem.Modules.Console;

public class Main {
    public static void main(String[] args) {
        DispatcherGlobals.dispatcher = new EventDispatcher();
        EventHandler handler = new EventHandler();

        DispatcherGlobals.dispatcher.subscribe(handler);
        while(true) {
            Console.GetInput();
        }
    }
}

