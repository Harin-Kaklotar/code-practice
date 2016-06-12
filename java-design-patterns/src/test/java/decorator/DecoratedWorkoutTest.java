package decorator;

import static org.junit.Assert.*;

import org.junit.Test;

public class DecoratedWorkoutTest {

    @Test
    public void testDoWarmUp() throws Exception {
        Workout workout = new SimpleWorkout();
        new DecoratedWorkout(workout).doWarmUp();

    }

    @Test
    public void testDoLegs() throws Exception {
        Workout workout = new SimpleWorkout();
        new DecoratedWorkout(workout).doLegs();
    }

    @Test
    public void testDoChest() throws Exception {
        Workout workout = new SimpleWorkout();
        new DecoratedWorkout(workout).doChest();
    }

    @Test
    public void testDoAbs() throws Exception {
        Workout workout = new SimpleWorkout();
        new DecoratedWorkout(workout).doAbs();
    }

    @Test
    public void testDoCoolDown() throws Exception {
        Workout workout = new SimpleWorkout();
        new DecoratedWorkout(workout).doCoolDown();
    }
}