package abstractFactory;

/**
 * Created by liju on 5/22/16.
 */
public class Main {

    public static void main(String[] args) {
        EmpireFactory empireFactory = new EmpireAFactory();
        Emperor emperor = empireFactory.createEmperor();
        Castle castle = empireFactory.createCastle();
        Army army = empireFactory.createArmy();

        emperor.printEmperorDetails();
        castle.printCastleDetails();
        army.printArmyDetails();

    }
}
