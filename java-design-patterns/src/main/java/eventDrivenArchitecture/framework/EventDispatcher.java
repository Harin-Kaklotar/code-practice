package eventDrivenArchitecture.framework;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liju on 6/11/16.
 */
public class EventDispatcher {

    private final Map<Class<? extends Event>, Handler<? extends Event>> eventHandlers;

    public EventDispatcher() {
        eventHandlers = new HashMap<>();
    }

    public <E extends Event> void registerHandler(Class<E> clazz, Handler<E> handler) {
        eventHandlers.put(clazz, handler);
    }

    public <E extends Event> void dispatch(E event) {
        Handler handler = eventHandlers.get(event.getType());
        if (handler != null) {
            handler.onEvent(event);
        }
    }

}
