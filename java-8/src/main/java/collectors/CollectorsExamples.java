package collectors;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorsExamples {


    public static void main(String[] args) {

        Person p1 = new Person(10, "A");
        Person p2 = new Person(20, "B");
        Person p3 = new Person(30, "C");
        Person p4 = new Person(40, "D");
        Person p5 = new Person(50, "E");
        Person p6 = new Person(60, "F");

        List<Person> personList = new ArrayList<>();
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);
        personList.add(p5);
        personList.add(p6);

        List<String> result = personList.stream().collect(Collectors.mapping(p -> p.getName(), Collectors.toList()));

        result.stream().forEach(System.out::println);


    }


}

class Person{
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
