package delegate;

import delegate.printer.CannonPrinter;
import delegate.printer.HPPrinter;

/**
 * Created by liju on 5/25/16.
 */
public class App {

    public static void main(String[] args) {
        PrinterDelegate delegate = new PrinterDelegate(new CannonPrinter());
        delegate.print("Hello");

        delegate.setPrinter(new HPPrinter());
        delegate.print("Hello");
    }
}
