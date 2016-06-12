package eventDrivenArchitecture;

import eventDrivenArchitecture.event.UserCreatedEvent;
import eventDrivenArchitecture.event.UserUpdatedEvent;
import eventDrivenArchitecture.framework.EventDispatcher;
import eventDrivenArchitecture.handler.UserCreatedHandler;
import eventDrivenArchitecture.handler.UserUpdatedHandler;
import eventDrivenArchitecture.model.User;

/**
 * Created by liju on 6/11/16.
 */
public class Main {

    public static void main(String[] args) {
        EventDispatcher eventDispatcher = new EventDispatcher();
        eventDispatcher.registerHandler(UserCreatedEvent.class,new UserCreatedHandler());
        eventDispatcher.registerHandler(UserUpdatedEvent.class,new UserUpdatedHandler());

        User user = new User("OldName");
        UserCreatedEvent userCreatedEvent = new UserCreatedEvent(user);
        eventDispatcher.dispatch(userCreatedEvent);
        user.setName("NewName");
        UserUpdatedEvent userUpdatedEvent = new UserUpdatedEvent(user);
        eventDispatcher.dispatch(userUpdatedEvent);

    }
}
