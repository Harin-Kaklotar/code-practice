package streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * https://stackoverflow.com/questions/20363719/java-8-listv-into-mapk-v?rq=1
 */
public class ListToMapExample {

    public static void main(String[] args) {
        List<Choice> choiceList = new ArrayList<>();
        choiceList.add(new Choice("c1", "o1"));
        choiceList.add(new Choice("c2", "o2"));
        choiceList.add(new Choice("c3", "o3"));

        Map<String, Choice> collect = choiceList.stream()
                .collect(Collectors.toMap(Choice::getName, Function.identity()));
        System.out.println(collect);
    }

}

class Choice {
    String name;
    String otherstuff;

    public Choice(String name, String otherstuff) {
        this.name = name;
        this.otherstuff = otherstuff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOtherstuff() {
        return otherstuff;
    }

    public void setOtherstuff(String otherstuff) {
        this.otherstuff = otherstuff;
    }
}
