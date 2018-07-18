package me.kupchenko.model;

public class QualityAnnotations {
    public @interface Bad{
        String value() default "";
    }
    public @interface Ugly {
        String value() default "";
    }
    public @interface Good{
        String value() default "";
    }
}
