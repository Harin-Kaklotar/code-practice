package builder;

/**
 * Created by liju on 5/22/16.
 */
public class Person {
    private Sex sex;
    private Profession profession;
    private Ethnicity ethnicity;
    private Color color;
    private Character character;

    public Person(PersonBuilder personBuilder) {
        this.sex = personBuilder.sex;
        this.profession = personBuilder.profession;
        this.ethnicity = personBuilder.ethnicity;
        this.color = personBuilder.color;
        this.character = personBuilder.character;
    }

    public Sex getSex() {
        return sex;
    }

    public Profession getProfession() {
        return profession;
    }

    public Ethnicity getEthnicity() {
        return ethnicity;
    }

    public Color getColor() {
        return color;
    }

    public Character getCharacter() {
        return character;
    }

    @Override
    public String toString() {
        return "Person{" + "sex=" + sex + ", profession=" + profession + ", ethnicity=" + ethnicity + ", color=" + color + ", character=" + character + '}';
    }


    public static class PersonBuilder {
        private Sex sex;
        private Profession profession;
        private Ethnicity ethnicity;
        private Color color;
        private Character character;

        public PersonBuilder setCharacter(Character character) {
            this.character = character;
            return this;
        }

        public PersonBuilder setColor(Color color) {
            this.color = color;
            return this;
        }

        public PersonBuilder setEthnicity(Ethnicity ethnicity) {
            this.ethnicity = ethnicity;
            return this;
        }

        public PersonBuilder setProfession(Profession profession) {
            this.profession = profession;
            return this;
        }

        public PersonBuilder setSex(Sex sex) {
            this.sex = sex;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
