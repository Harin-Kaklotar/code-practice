package singleton;

/**
 * Created by liju on 5/16/16. Singleton using eager initialization
 *
 */
public final class Singleton2 {
    private static final Singleton2 instance = new Singleton2();

    private Singleton2() {
        // to avoid instantiation
    }

    public static Singleton2 getInstance() {
        return instance;
    }
}
