package me.kupchenko.lambda;

import me.kupchenko.model.QualityAnnotations.Bad;
import me.kupchenko.model.QualityAnnotations.Good;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ClassDesign {
    @Bad("The problem is: ambiguous overloaded methods (UnaryOperator extends Function)")
    static class AmbiguousOverloadedMethods {
        interface AmbiguousService<T> {
            <R> R process(Function<T, R> fn);

            T process(UnaryOperator<T> fn);
        }

        public void usage(AmbiguousService<String> service) {
            // which method you intended to call??? both are acceptable.
            service.process(String::toUpperCase);

            // UnaryOperator extends Function
            Function<String, String> function = String::toUpperCase;
            service.process(function);
        }
    }

    @Good("In such case it is better to name methods in the different way")
    static class SeparateSpecializedMethods {
        interface ClearService<T> {
            <R> R convert(Function<T, R> fn);

            T process(UnaryOperator<T> fn);
        }

        public void usage(ClearService<String> service) {
            //now it's clear which method will be called.
            service.convert(String::toUpperCase);
        }
    }
}
