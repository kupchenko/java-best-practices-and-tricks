package me.kupchenko.tricks;

public class SyntacticDevice {

    class Person implements Comparable<Person> {

        private Long age;

        @Override
        public int compareTo(Person this, Person o) {
            return this.age.compareTo(o.age);
        }
    }

}