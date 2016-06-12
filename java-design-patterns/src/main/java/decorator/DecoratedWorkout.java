package decorator;

/**
 * Created by liju on 5/20/16.
 */
public class DecoratedWorkout implements Workout {

    private Workout workout = null;

    public DecoratedWorkout(Workout workout){
        this.workout = workout;
    }


    @Override public void doWarmUp() {
        System.out.println("get ready");
        workout.doWarmUp();
    }

    @Override public void doLegs() {
        System.out.println("do stretching");
        workout.doLegs();
    }

    @Override public void doChest() {
        workout.doChest();
        System.out.println("drink water");
    }

    @Override public void doAbs() {
        workout.doAbs();
        System.out.println("take pause");
    }

    @Override public void doCoolDown() {
        workout.doCoolDown();
        System.out.println("say bye");

    }
}
