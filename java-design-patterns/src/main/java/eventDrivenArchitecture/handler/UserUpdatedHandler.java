package eventDrivenArchitecture.handler;

import eventDrivenArchitecture.event.UserUpdatedEvent;
import eventDrivenArchitecture.framework.Handler;

/**
 * Created by liju on 6/11/16.
 */
public class UserUpdatedHandler implements Handler<UserUpdatedEvent> {
    @Override public void onEvent(UserUpdatedEvent event) {
        System.out.println(String.format("user '%s' updated",event.getUser().getName()));
    }
}
