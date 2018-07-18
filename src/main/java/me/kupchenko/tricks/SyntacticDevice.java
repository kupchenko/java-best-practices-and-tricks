package me.kupchenko.tricks;

import me.kupchenko.model.New;

public class SyntacticDevice {

    class Person implements Comparable<Person> {

        private Long age;

        @Override
        public int compareTo(@New("Now you can annotate parameter")Person this, Person o) {
            return this.age.compareTo(o.age);
        }
    }

}