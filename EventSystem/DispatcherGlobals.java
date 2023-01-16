package EventSystem;

import EventSystem.Exceptions.NullEventDispatcherException;

public class DispatcherGlobals {
    public static EventDispatcher dispatcher;
    public static void try_dispatch(Object event) throws NullEventDispatcherException {
        if(DispatcherGlobals.dispatcher != null) {
            DispatcherGlobals.dispatcher.dispatch(event);
        } else {
            throw new NullEventDispatcherException();
        }
    }
}
