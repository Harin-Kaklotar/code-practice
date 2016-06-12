package delegate;

/**
 * Delegare class , instead of implementing its own print method , it call the print method of the printer passed
 * Created by liju on 5/25/16.
 */
public class PrinterDelegate implements Printer {
    private Printer printer;

    public PrinterDelegate(Printer printer) {
        this.printer = printer;
    }

    /**
     * /** This method is implemented from {@link Printer} however instead on providing an implementation, it instead
     * calls upon the class passed through the constructor. This is the delegate, hence the pattern. Therefore meaning
     * that the caller does not care of the implementing class only the owning controller.
     *
     * @param msg
     *            to be printed to the screen
     */
    @Override
    public void print(String msg) {
        printer.print(msg);
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }
}
