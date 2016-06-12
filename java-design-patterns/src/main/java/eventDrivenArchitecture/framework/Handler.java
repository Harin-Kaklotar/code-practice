package eventDrivenArchitecture.framework;

/**
 * Created by liju on 6/11/16.
 */
public interface Handler<E extends Event> {

    public void onEvent(E event);

}
