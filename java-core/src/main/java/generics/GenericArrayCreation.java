package generics;

import java.lang.reflect.Array;

/**
 * Created by liju on 3/24/18.
 */
public class GenericArrayCreation {


    class MySet<E>{
        private E[] e;
        public MySet(Class<E> clazz,int capacity){
            e = (E[])Array.newInstance(clazz, capacity);
        }

        public E getElement(int i){
            return e[i];
        }

    }
}
