package me.kupchenko.override;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * From Class.getMethod(String, Class...) doc:
 * <p>
 * Note that there may be more than one matching method in a class because
 * while the Java language forbids a class to declare multiple methods with the same signature
 * but different return types, the Java virtual machine does not.
 * This increased flexibility in the virtual machine can be used to implement various language features.
 * For example, covariant returns can be implemented with bridge methods;
 * the bridge method and the method being overridden would have the same signature but different return types.
 */
public class MethodSignature {
    public static void main(String[] args) {
        Child child = new Child();
        Method[] methods = child.getClass().getDeclaredMethods();
        Arrays.stream(methods).forEach(method -> System.out.println(method.getName() + "() - " + method.getReturnType().getCanonicalName()));
        //Output:
        //method() - java.lang.String
        //method() - java.lang.Object
    }
}

abstract class Parent<T> {
    abstract T method();
}

class Child extends Parent<String> {
    @Override
    String method() {
        return "...";
    }
}
