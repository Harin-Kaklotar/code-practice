package observer;

/**
 * Created by liju on 6/10/16.
 */
public class Main {

    public static void main(String[] args) {

        Observer<MONTH> observerA = new ObserverA();
        Observer<MONTH> observerB = new ObserverB();
        Observer<MONTH> observerC = new ObserverC();

        Observable<MONTH> observable = new MonthObservable();
        observable.subscribe(observerA);
        observable.subscribe(observerB);
        observable.subscribe(observerC);
        observable.notify(MONTH.AUG);

        observable.unSubscribe(observerB);
        observable.notify(MONTH.DEC);

    }
}
