package eventDrivenArchitecture.event;

import eventDrivenArchitecture.model.User;

/**
 * Created by liju on 6/11/16.
 */
public class UserUpdatedEvent extends AbstractEvent {
    private User user;

    public UserUpdatedEvent(User user){
        this.user = user;
    }

    public User getUser(){
        return user;
    }

}
