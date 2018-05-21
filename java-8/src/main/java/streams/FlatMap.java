package streams;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://stackoverflow.com/questions/50348166/java-8-list-of-objects-to-mapstring-list-of-values
 */
public class FlatMap {

    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("n1","a1","o1"));
        userList.add(new User("n2","a2","o2"));
        userList.add(new User("n3","a3","o3"));
        userList.add(new User("n4","a4","o4"));

        Map<String,List<String>> map =  userList.stream().flatMap(user -> Stream.of(
                new AbstractMap.SimpleEntry<>("name",user.getName()),
                new AbstractMap.SimpleEntry<>("age",user.getAge()),
                new AbstractMap.SimpleEntry<>("org",user.getOrg())))
                .collect(Collectors.groupingBy(Map.Entry::getKey,Collectors.mapping(Map.Entry::getValue,Collectors.toList())));

        System.out.println(map);

    }

}

class User{
    String name,age,org;

    public User(String name, String age, String org) {
        this.name = name;
        this.age = age;
        this.org = org;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }
}
