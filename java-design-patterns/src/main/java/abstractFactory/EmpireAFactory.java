package abstractFactory;

/**
 * Created by liju on 5/22/16.
 */
public class EmpireAFactory implements EmpireFactory {
    @Override
    public Emperor createEmperor() {
        return new EmperorA();
    }

    @Override
    public Army createArmy() {
        return new ArmyA();
    }

    @Override
    public Castle createCastle() {
        return new CastleA();
    }
}
