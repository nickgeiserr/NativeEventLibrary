package EventSystem;

import EventSystem.Exceptions.NullEventDispatcherException;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class EventDispatcher {
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface Subscriber { }

    private final Map<Class<?>, Map<Object, Method>> subscribers = new HashMap<>();

    public void subscribe(Object object) {
        for (Method method : object.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(Subscriber.class)) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length != 1) {
                    throw new IllegalArgumentException("@Subscriber method must have exactly one parameter");
                }
                Class<?> eventType = parameterTypes[0];

                Map<Object, Method> eventSubscribers = subscribers.get(eventType);
                if (eventSubscribers == null) {
                    eventSubscribers = new HashMap<>();
                    subscribers.put(eventType, eventSubscribers);
                }
                eventSubscribers.put(object, method);
            }
        }
    }

    public void unsubscribe(Object object) {
        for (Map<Object, Method> eventSubscribers : subscribers.values()) {
            eventSubscribers.remove(object);
        }
    }

    public void dispatch(Object event) {
        Map<Object, Method> eventSubscribers = subscribers.get(event.getClass());
        if (eventSubscribers == null) {
            return;
        }

        for (Map.Entry<Object, Method> entry : eventSubscribers.entrySet()) {
            Object object = entry.getKey();
            Method method = entry.getValue();
            try {
                method.invoke(object, event);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}

