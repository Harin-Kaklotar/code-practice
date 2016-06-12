package singleton;

/**
 * Created by liju on 5/16/16. /** The Initialize-on-demand-holder idiom is a secure way of creating a lazy initialized
 * singleton object in Java.
 * <p>
 * The technique is is as lazy as possible and works in all known versions of Java. It takes advantage of language
 * guarantees about class initialization, and will therefore work correctly in all Java-compliant compilers and virtual
 * machines.
 * <p>
 * The inner class is referenced no earlier (and therefore loaded no earlier by the class loader) than the moment that
 * getInstance() is called. Thus, this solution is thread-safe without requiring special language constructs (i.e.
 * volatile or synchronized).
 *
 */
public final class Singleton3 {

    private Singleton3() {

    }

    public static Singleton3 getInstance() {
        return SingletonHelper.instance;
    }

    private final static class SingletonHelper {
        private static final Singleton3 instance = new Singleton3();
    }
}
