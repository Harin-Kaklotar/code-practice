package generics;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by liju on 3/21/18.
 */
public class Example1 {

    class A {};

    class B extends A {};

    /**problem**/
  /*  class testGenerics<T extends A> {

        T a;

        T getA() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
            //return getA(A.class); // Compilation problem:
            //return null;
        }

        T getA(Class<T> clazz) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
            return clazz.getConstructor().newInstance();
        }

    }*/

    //solution

    class TestGenerics{

         A getA() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
            return getA(B.class); // Compilation problem:
            //return null;
        }

        <T extends A> A getA(Class<T> clazz) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
            return clazz.getConstructor().newInstance();
        }

    }


}

