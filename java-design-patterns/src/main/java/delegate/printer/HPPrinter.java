package delegate.printer;

import delegate.Printer;

/**
 * Created by liju on 5/25/16.
 */
public class HPPrinter implements Printer {
    @Override
    public void print(String msg) {
        System.out.println("HP printer printing - "+msg);
    }
}
