package com.lijubjohn.creational.builder;

/**
 * Created by liju on 8/22/16.
 */
public class Person {
    private String sex;
    private int age;
    private String profession;
    private int height;
    private int weight;

    public Person(PersonBuilder personBuilder) {
        this.sex = personBuilder.sex;
        this.age = personBuilder.age;
        this.profession = personBuilder.profession;
        this.height = personBuilder.height;
        this.weight = personBuilder.weight;
    }

    public static class PersonBuilder {
        private String sex;
        private int age;
        private String profession;
        private int height;
        private int weight;

        public PersonBuilder setSex(String sex) {
            this.sex = sex;
            return this;
        }

        public PersonBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public PersonBuilder setProfession(String profession) {
            this.profession = profession;
            return this;
        }

        public PersonBuilder setHeight(int height) {
            this.height = height;
            return this;
        }

        public PersonBuilder setWeight(int weight) {
            this.weight = weight;
            return this;
        }

        public Person createPerson() {
            return new Person(this);
        }
    }

}

class Client {

    public static void main(String[] args) {
        final Person person = new Person.PersonBuilder().setAge(30).setHeight(6).setProfession("xyz").setSex("M").setWeight(120).createPerson();
    }
}
