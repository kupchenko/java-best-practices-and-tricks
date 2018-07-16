package me.kupchenko.lambda;

import me.kupchenko.model.QualityAnnotations.Good;
import me.kupchenko.model.QualityAnnotations.CabBeBetter;

import java.util.Optional;

public class UselessLambdas {

    @CabBeBetter("Lambdas are not always the best option")
    class UnneededLambdasUsage {
        public void processAndPrint(String name) {
            Optional.ofNullable(name)
                    //.filter(s -> !s.isEmpty())
                    .map(s -> s.toUpperCase())
                    .map(s -> doProcess(s))
                    .ifPresent(s -> System.out.print(s));
        }

        private String doProcess(String name) {
            return "MR. " + name;
        }
    }

    @Good("In some case you can replace it with method reference")
    class MethodReferenceUsage {
        public void processAndPrint(String name) {
            Optional.ofNullable(name)
                    //.filter(StringUtils::isNotEmpty) // replace with appropriate library method ref
                    .map(String::toUpperCase)
                    .map(this::doProcess)
                    .ifPresent(System.out::print);
        }

        private String doProcess(String name) {
            return "MR. " + name;
        }
    }
}
