package me.kupchenko.model;

public class QualityAnnotations {
    public @interface Bad{
        String value() default "";
    }
    public @interface CabBeBetter {
        String value() default "";
    }
    public @interface Good{
        String value() default "";
    }
}
