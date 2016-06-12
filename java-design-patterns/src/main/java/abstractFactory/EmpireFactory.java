package abstractFactory;

/**
 * Created by liju on 5/22/16.
 */
public interface EmpireFactory
{

    public Emperor createEmperor();
    public Army createArmy();
    public Castle createCastle();
}
