package interfaces;

interface A {
    default void hello() {
        System.out.println("hello from A");
    }

    default void bye() {
        System.out.println("bye from A");
    }

    static void demo() {
        System.out.println("i am static method");
    }
}

interface B extends A {
    default void hello() {
        System.out.println("hello from B");
    }
}

interface C {
    default void hello() {
        System.out.println("hello from C");
    }
}

class Greet1 implements A, B {
    @Override
    public void hello() {
        System.out.println("hello from Greet");
    }
}

class Greet2 implements A, B {
}

//Error - inherits hello() from unrelated interfaces
/*class Greet3 implements A, C {

}*/

class Greet4 implements A, C {
    @Override
    public void hello() {
        A.super.hello(); // or custom implementation
    }
}

public class InterfaceTest {

    public static void main(String[] args) {
        new Greet1().hello();
        new Greet2().hello();
        new Greet4().hello();
    }
}
