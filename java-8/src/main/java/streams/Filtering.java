package streams;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.*;

/**
 * Created by liju on 7/8/16.
 */
public class Filtering {

    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH)
        );

        //filtering with predicate (filter)
        List<Dish> vegetarianDishes  = menu.stream().filter(Dish::isVegetarian).collect(toList());
        //Filtering unique elements (distinct)
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream().filter(i -> i%2==0).distinct().forEach(System.out::println);
        //Truncating a stream (limit)
        List<Dish> highCalDishes = menu.stream().filter(d -> d.getCalories() > 300 ).limit(3).collect(toList());
        //Skipping elements in a stream
        List<Dish> dishes  = menu.stream().filter(d -> d.getCalories()>300).skip(2).collect(toList());

    }
}
