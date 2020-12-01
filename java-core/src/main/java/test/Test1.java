package test;

import org.mockito.internal.matchers.Null;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Test1 {


  /*  public static void main(String[] args) {
       // test1();
        //test2();

        WithDefaultDefinitionImpl impl = new WithDefaultDefinitionImpl();
        impl.callPrint();

        LocalDate.of(12, 11, 202220);
    }



    public static void test1(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        for (int i = 0; i < list.size();i++){
            list.remove(i);
            System.out.println(list);
            list.add(4);
        }

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            list.remove(0);
            System.out.println(iterator.next());

        }
    }

    public static void test2(){
        Set<String> set  = new HashSet<>();
        set.add("a");
        set.add(null);
        System.out.println(set);

        set = new TreeSet<>();
        set.add("a");
        set.add(null);
        System.out.println(set);
    }

    public static void test3(){

        try(Scanner scanInp = new Scanner(System.in)) {	// line 1
            // Input getting using Scanner
        }
		catch (Exception e) {
            // TODO: handle exception
        }
		finally {
            // scanInp.close();	// line 2
        }
    }


*/

    public static void main(String[] args) {
       /* String value1 = "Hello";
        String value2 = new String("Hello");
        System.out.print(value1 == value2);
        System.out.print(" ");
        String value3 = value2.intern();
        System.out.println(value1 == value3);*/

/*
        int number = 1234;
        float f1 = 1234.0;
        float f2 = 1234;
        double d3 = 1234.0;
        long num = 1234;*/

        String firstString = "String";
        StringBuilder secondString = new StringBuilder("String");
        StringBuilder thirdString = new StringBuilder("String");
        System.out.println(firstString.contains(secondString));
        System.out.println(firstString.equals(secondString));
        System.out.println(secondString.equals(firstString));
        System.out.println(secondString.equals(thirdString));

    }
}
/*interface WithDefaultDefinition {
    default void printDefault() {
        System.out.println("default method");
    }
}

class WithDefaultDefinitionImpl implements WithDefaultDefinition{
    void callPrint() {
        printDefault();
    }
}*/

/*class RegularEx {
    public static void main(String... arg) {
        Pattern pattern = Pattern.compile("M+", 5);
        Matcher matcher = pattern.matcher("M Merit Match MM m mM");
        while (matcher.find())
            System.out.print(matcher.group() + " ");
    }
}*/

/*
class Tester {
    public static void main(String[] args) {
        Base obj = new Derived();
        obj.method(25);
    }
}

class Base {
    public static void method(int a) {
        System.out.println("Base Method");
    }
}

class Derived extends Base {
    public static void method(int a) {
        System.out.println("Derived Method");
    }
}*/

/*class Tester {
    public static void main(String[] args) {
        Base obj = new Derived();
        obj.method(25);
    }
}

class Base {
    public static void method(int a) {
        System.out.println("Base Method");
    }
}

class Derived extends Base {
    public static void method(int a) {
        System.out.println("Derived Method");
    }
}*/


/*

interface MyInterface {
    void method1();
}

class MyImplementation implements MyInterface {
    void method1() {
        System.out.println("My Method");
    }
}

class Testing1 {
    public static void main(String[] args) {
        MyInterface obj = new MyImplementation();
        obj.method1();
    }
}
*/


/*
class Vehicle {
    Vehicle() {
        System.out.println("Vehicle is created");
    }
}
class Bike5 extends Vehicle {
    Bike5() {
        super();
        System.out.println("Bike is created");
    }
    public static void main(String args[]) {
        Bike5 b = new Bike5();
    }
}*/
/*

class Tester1 {
    public static void main(String[] args) {
        String s1 = "Infosys";
        String s2 = "Infosys";
        if (s1 == s2) {
            System.out.print("Equal");
        } else {
            System.out.print(" UnEqual");
        }
        if (s1.equals(s2)) {
            System.out.print(" Equal");
        } else {
            System.out.print(" UnEqual");
        }
    }
}*/
/*
 class StringTest {
    public static void main(String[] args) {
        String s1 = "A", s2 = "a", s3 = "b";
        s1.toLowerCase();
        s3.replace('b', 'a');
        System.out.print((s1.equals(s2)) + "," + (s2.equals(s3)));
    }
}*/
/*
class InfyTest {
    public static void main(String[] args) {
        int x, y, z;
        System.out.println(x + y + z);
    }
}*/

/*

 class SuperClass {
    private void displayName() {
        System.out.println("Super Class");
    }
    public static void main(String[] args) {
        SuperClass superClass = new SubClass();
        superClass.displayName();
    }
}

 class SubClass extends SuperClass {
    private void displayName() {
        System.out.println("SubClass is a type of SuperClass");
    }
}*/
/*

class Person{
    public Person(String name){
        System.out.println(name);
    }
}

class Student extends Person{
    public Student(){          //line 8
        System.out.println("Student");
    }
    public static void main(String[] args) { // line 11
        new Person("Bob");
    }
}
*/
/*

abstract class Person1 {
    public final void display(){
        System.out.println("Display method in Person");
    }

    public static void main(String[] args){
        Person1 person = new Student1();        //line 6
        person.display();                     //line 7
    }
}

class Student1 extends Person1{
    public void display(){                  //line 11
        System.out.println("Display method in Student");
    }
}*/

/*

class Employee {
    public void display() {
        System.out.print(" display ");
    }

    public void print(int age) {
        System.out.print(" Employee ");
    }
}

public class Trainee extends Employee {
    public void display(String name) { // line 2
        System.out.print(name);
    }
    public int print(int age) { // line 5
        System.out.print(" Trainee ");
        return age;
    }
    public static void main(String[] args) {
        Trainee trainee = new Trainee();
        trainee.display(); // line 10
        trainee.display("Bob"); // line 11
        trainee.print(10); // line 12
    }
}*/

/*

class Employee {
    public static void display() { // line 2
        System.out.print(" Employee ");
    }
}

 class Trainee extends Employee {
    public static void display() { // line 5
        System.out.print(" Trainee ");
    }
    public static void main(String[] args) {
        Employee employee = new Trainee();
        employee.display(); // line 9
    }
}*/


/*

abstract class Employee {
    private void display() {
        System.out.print(" Employee ");
    }
}

class Trainee extends Employee {
    protected void display() { // line 5
        System.out.print(" Trainee ");
    }
    public static void main(String[] args) {
        Employee emp = new Trainee();
        emp.display(); // line 10
    }
}*/

/*
class DateDemo {

    public static void main(String[] args) {
        LocalDate date = LocalDate.parse("2019-03-07");
        LocalDate date1 = LocalDate.of(2019, 12, 07);
        System.out.println(date.getYear()+date1.getYear()
                +" , "+date.compareTo(date1)+" , "+date1.compareTo(date));
    }
}*/



 enum Day {
    SUNDAY(1), MONDAY(2), TUESDAY(3), WEDNESDAY(4), THURSDAY(5), FRIDAY(6), SATURDAY(7);
    private int value;
    private Day(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
 class TestEnum {
    public static void main(String[] args) {
        for(Day day:Day.values()) {
            // Line 1
            day.name();
        }
    }



}

/*class TestTry{
    public static void main(String[] args) {
        try {

            // execute code that may throw 1 of the 3 exceptions below.
            throw new SQLException("");

        } catch(ArithmeticException | NumberFormatException e) {
            e.printStackTrace();

        }
    }
}*/

interface StaticInterface {
    static void staticMethod() {
        System.out.println("inside interface");
    }
}

class StaticInterfaceImpl implements StaticInterface {
    public void staticMethod() {
        System.out.println("inside class");
    }
}
 class StaticInterfaceStarter {
    public static void main(String[] args) {
        new StaticInterfaceImpl().staticMethod();
    }
}

class NumberUtil {

    public static void main(String[] args) {
        List<Number> nums = new ArrayList<Number>(); List<Integer> ints = Arrays.asList(1, 2); List<Double> dbls = Arrays.asList(2.78, 3.14); nums.addAll(ints);
        nums.addAll(dbls);

        System.out.println(nums);

        List<Integer> ints1 = Arrays.asList(1,2,3);
        sum(ints1);


    }
    public static double sum(Collection<? extends Number> nums) { double s = 0.0;
        for (Number num : nums) s += num.doubleValue();
        return s;
    }
}



class T<Object>{

}