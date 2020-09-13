package interfaces;

interface Deduction {
    static void deduct() {
        System.out.println("deduct");
    }
}

class Customer implements Deduction {
    public static void deduct() {
        System.out.println("deduction for customer");
    }
}

public class StaticMethodTest {
    public static void main(String[] args) {
        Deduction deduction = new Customer();
        // deduction.deduct(); //--> error
        Deduction.deduct(); //--> correct
        Customer.deduct(); //--> correct
    }
}

