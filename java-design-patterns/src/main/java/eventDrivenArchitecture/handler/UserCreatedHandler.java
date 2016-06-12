package eventDrivenArchitecture.handler;

import eventDrivenArchitecture.event.UserCreatedEvent;
import eventDrivenArchitecture.framework.Handler;

/**
 * Created by liju on 6/11/16.
 */
public class UserCreatedHandler implements Handler<UserCreatedEvent> {

    @Override
    public void onEvent(UserCreatedEvent event) {
        System.out.println(String.format("user '%s' created", event.getUser().getName()));
    }
}
