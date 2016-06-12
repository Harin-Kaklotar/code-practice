package observer;

/**
 * Created by liju on 6/10/16.
 */
public class ObserverA implements Observer<MONTH> {
    @Override
    public void update(MONTH argument) {
        System.out.println("ObserverA  - notification received : "+argument);
    }
}
