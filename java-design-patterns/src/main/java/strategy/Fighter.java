package strategy;

/**
 * Created by liju on 5/22/16.
 */
public class Fighter {
    private FightStrategy fightStrategy;

    public Fighter(FightStrategy fightStrategy) {
        this.fightStrategy = fightStrategy;
    }

    public void changeFightStrategy(FightStrategy fightStrategy) {
        this.fightStrategy = fightStrategy;
    }

    public void fight() {
        this.fightStrategy.execute();
    }
}
