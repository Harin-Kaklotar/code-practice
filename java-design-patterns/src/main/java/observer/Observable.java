package observer;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by liju on 6/10/16.
 */
public abstract class Observable<A> {

    private final List<Observer<A>> observerList;

    public Observable() {
        observerList = new CopyOnWriteArrayList<>();
    }

    public void subscribe(Observer observer) {
        observerList.add(observer);
    }

    public void unSubscribe(Observer observer) {
        observerList.remove(observer);
    }

    public void notify(A argument) {
        for (Observer observer : observerList) {
            observer.update(argument);
        }
    }

}
