package me.kupchenko.tricks;

public class TernaryOperator {

    public void NPE() {
        Integer i = null;
        Double d = 2.0d;
        Object o = true ? i : d; // throws NullPointerException - in this case java tries to case 'i' to Double, 'i' == null -> NPE
    }

    public void diff() {
        Object o1 = true ? 1 : 2.0;

        // Does the same?

        Object o2;
        if (true)
            o2 = 1;
        else
            o2 = 2.0;

        // No. Let's check:

        System.out.println("TernaryOperator = " + o1); // Output: TernaryOperator = 1.0
        System.out.println("if-else = " +o2); // Output: if-else = 1
    }
}
