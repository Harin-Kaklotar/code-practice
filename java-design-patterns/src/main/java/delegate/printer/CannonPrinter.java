package delegate.printer;

import delegate.Printer;

/**
 * Created by liju on 5/25/16.
 */
public class CannonPrinter implements Printer {
    @Override
    public void print(String msg) {
        System.out.println("Cannon printer printing - " + msg);
    }
}
