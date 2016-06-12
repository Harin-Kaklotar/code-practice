package observer;

/**
 * Created by liju on 6/10/16.
 */
public class ObserverB implements Observer<MONTH> {
    @Override
    public void update(MONTH argument) {
        System.out.println("ObserverB  - notification received : "+argument);
    }
}
