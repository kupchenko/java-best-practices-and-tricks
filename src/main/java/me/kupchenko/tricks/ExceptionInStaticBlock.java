package me.kupchenko.tricks;

public class ExceptionInStaticBlock {
    public static void main(String[] args) {
        try {
            Clazz.sayHello();
        } catch (Throwable e) {
            Clazz.sayHello(); //Exception in thread "main" java.lang.NoClassDefFoundError: Could not initialize class me.kupchenko.tricks.Clazz
        }
    }
    static class Clazz {
        static {
            if (true) throw new NullPointerException();
        }

        public static void sayHello() {
            System.out.println("Hello!!!");
        }
    }
}