package overridding;

import java.io.IOException;

public class OverriddingExample {

    public static void main(String[] args) {
        Base b1 = new Base();
        Base b2 = new SubClass();
        //SubClass sb1 = new Base();//compile error
        SubClass sb1 = new SubClass();
        sb1.test3();
        b2.test2();

    }
}

class Base {
    public final void test1(){
        System.out.println("Base t1");
    }
    public void test2(){
        System.out.println("Base t2");
    }

    public void test3 () {
        System.out.println("Base t3");
    }

    private void test4 ()
    { System.out.println("Base t4"); }

    public void test5 () throws IOException {
        throw new IOException();
    }



}
class SubClass extends Base {


    public void test2(){
        System.out.println("Subclass t2");
    }

    private void test4 ()
    { System.out.println("Subclass t4"); }

    /*compile error - cannot override final method
    public void test1(){
        System.out.println("Subclass t1");
    }*/

    //Compilation error - cannot throw Broader exception than baseclass
    /*public void test5 () throws Exception {
        throw new IOException();
    }*/

    //Compilation error - access cannot be more restrictive than baseclass
    /*private void test5 () throws IOException {
        throw new IOException();
    }*/

}
