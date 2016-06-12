package strategy;

/**
 * Created by liju on 5/22/16.
 */
public class GrapplingStrategy implements FightStrategy {
    @Override
    public void execute() {
        System.out.println("drain the opponents strength with grappling");
    }
}
