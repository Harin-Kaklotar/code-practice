package builder;

/**
 * Created by liju on 5/22/16.
 */
public class App {

    public static void main(String[] args) {
        Person person = new Person.PersonBuilder()
            .setSex(Sex.FEMALE)
            .setProfession(Profession.DIRECTOR)
            .setEthnicity(Ethnicity.CHINEESE)
            .setColor(Color.WHITE)
            .setCharacter(Character.GOOD)
            .build();
        System.out.println(person.toString());
    }
}
