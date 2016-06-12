package decorator;

/**
 * Created by liju on 5/20/16.
 */
public class SimpleWorkout implements Workout {
    @Override
    public void doWarmUp() {
        System.out.println("doing warm up");
    }

    @Override
    public void doLegs() {
        System.out.println("doing legs");
    }

    @Override
    public void doChest() {
        System.out.println("doing chest");
    }

    @Override
    public void doAbs() {
        System.out.println("doing abs");
    }

    @Override
    public void doCoolDown() {
        System.out.println("cooling down");
    }
}
