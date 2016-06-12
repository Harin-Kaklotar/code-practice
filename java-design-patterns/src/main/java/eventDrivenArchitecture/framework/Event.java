package eventDrivenArchitecture.framework;

/**
 * Created by liju on 6/11/16.
 */
public interface Event {

    Class<? extends Event> getType();
}
