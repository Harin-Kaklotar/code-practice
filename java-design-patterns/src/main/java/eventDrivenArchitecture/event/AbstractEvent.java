package eventDrivenArchitecture.event;

import eventDrivenArchitecture.framework.Event;

/**
 * Created by liju on 6/11/16.
 */
public class AbstractEvent implements Event {
    @Override
    public Class<? extends Event> getType() {
        return getClass();
    }
}
