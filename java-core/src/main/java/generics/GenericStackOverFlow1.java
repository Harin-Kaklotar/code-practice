package generics;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by liju on 11/14/16.
 */
public class GenericStackOverFlow1 {

    /**
     * Get Subclass out of Super class collection
     * @param politicians
     * @return
     */
    public  Set<Trump> getSetOfTrump(Set<? extends Politician> politicians){
        return  politicians.stream().filter( s  -> s instanceof Trump).map(s ->(Trump)s).collect(Collectors.toSet());
    }
}


class Politician {

}

class Trump extends Politician{

}