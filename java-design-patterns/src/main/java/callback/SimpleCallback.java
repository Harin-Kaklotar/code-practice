package callback;

/**
 * Created by liju on 5/20/16.
 */
public class SimpleCallback implements Callback {
    @Override
    public void call() {
        System.out.println("callback called");
    }
}
