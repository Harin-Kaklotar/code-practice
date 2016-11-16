package generics;

/**
 * Created by liju on 11/14/16.
 */
public class Legacy {

    public Object legacyMethod(Object object){
        // do something
        return  object;
    }
}


class LegacyWrapper{
    private Legacy legacy = new Legacy();
    public <T> T legacyMethodWrapper(Object obj ,Class<T> clazz) throws ClassCastException{
        return clazz.cast(legacy.legacyMethod(obj));
    }

    public static void main(String[] args) {
        LegacyWrapper legacyWrapper = new LegacyWrapper();
        System.out.println(legacyWrapper.legacyMethodWrapper(new String("Test"), String.class));
    }
}
