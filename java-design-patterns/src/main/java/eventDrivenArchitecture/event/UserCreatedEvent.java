package eventDrivenArchitecture.event;

import eventDrivenArchitecture.model.User;

/**
 * Created by liju on 6/11/16.
 */
public class UserCreatedEvent extends AbstractEvent {

    private User user;

    public UserCreatedEvent(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
