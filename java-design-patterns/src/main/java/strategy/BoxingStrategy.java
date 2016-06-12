package strategy;

/**
 * Created by liju on 5/22/16.
 */
public class BoxingStrategy implements FightStrategy {
    @Override
    public void execute() {
        System.out.println("attack by boxing the opponent");
    }
}
