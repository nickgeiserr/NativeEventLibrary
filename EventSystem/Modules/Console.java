package EventSystem.Modules;

import EventSystem.DispatcherGlobals;
import EventSystem.Events.ConsoleInputEvent;
import EventSystem.Events.ConsoleOutputEvent;
import EventSystem.Exceptions.NullEventDispatcherException;

import java.util.Scanner;

public class Console {
    public static void WriteLine(String message) {
        System.out.println(message + "\n");
        try {
            DispatcherGlobals.try_dispatch(new ConsoleOutputEvent(message));
        } catch (NullEventDispatcherException e) {
            throw new RuntimeException(e);
        }
    }

    public static void Write(String message) {
        System.out.println(message);
        try {
            DispatcherGlobals.try_dispatch(new ConsoleOutputEvent(message));
        } catch (NullEventDispatcherException e) {
            throw new RuntimeException(e);
        }
    }

    public static String GetInput(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if(input != null) {
            try {
                DispatcherGlobals.try_dispatch(new ConsoleInputEvent(input));
            } catch (NullEventDispatcherException e) {
                throw new RuntimeException(e);
            }
        }
        return input;
    }
}
