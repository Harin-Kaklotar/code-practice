package singleton;

/**
 * Created by liju on 5/16/16.
 *
 * Using double lock checking to make lazy initializtion thread safe
 *
 * final class - avoid inheritence private constructor - avoid instantiation from outside synchronize - to make
 * threadsafe double-check locking - to improve performance with multiple threading tradeoff static method - for global
 * access
 */
public final class Singleton1 {

    private static Singleton1 instance;

    private Singleton1() {
        // to avoid instantiation from outside
    }

    /**
     * Thread safe implementation but synchronization on method is performance intensive
     * 
     * @return
     */
    public static synchronized Singleton1 getInstance1() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }

    /**
     * Better performance wise but not completely thread safe
     * 
     * @return
     */
    public static Singleton1 getInstance() {
        if (instance == null) {
            synchronized (Singleton1.class) {
                if (instance == null) {
                    instance = new Singleton1();
                }
            }
        }
        return instance;
    }

}
