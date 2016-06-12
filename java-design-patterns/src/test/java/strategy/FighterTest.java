package strategy;

import static org.junit.Assert.*;

import org.junit.Test;

public class FighterTest {

    @Test
    public void testFight() throws Exception {
        Fighter fighter = new Fighter(new BoxingStrategy());
        fighter.fight();
        fighter.changeFightStrategy(new GrapplingStrategy());
        fighter.fight();
        fighter.changeFightStrategy(new SubmissionStrategy());
        fighter.fight();
    }
}