package singleton;

/**
 * Created by liju on 5/16/16. simple , thread-safe , preferred method
 */
public enum SingletonEnum {
    INSTANCE;

    public void doStuff() {
        System.out.println("I am singleton using enum");
    }

    public static void main(String[] args) {

        SingletonEnum.INSTANCE.doStuff();
    }
}
