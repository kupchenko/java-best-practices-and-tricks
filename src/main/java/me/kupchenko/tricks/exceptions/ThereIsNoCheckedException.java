package me.kupchenko.tricks.exceptions;

import java.sql.SQLException;

/**
 * This program is successfully compiled and it throws the SQLException without 'throws' declaration.
 * You don't even need the @SneakyThrows from Lombok'а.
 *
 * As can be seen, the JVM doesn’t seem to have a problem with the checked exception thrown from doThrow0().
 * In other words, checked and unchecked exceptions are mere syntactic sugar
 *
 *
 *
 * The case you are doing is same as this.
 * Exception e = new IOException();
 * throw (RuntimeException) (e);
 *
 * Because this is explicit type casting this call will result in ClassCastException
 * however compiler is allowing it.
 *
 * In this case there is no way for compiler to restrict the type conversion you are doing.
 *
 * However if you change method signature to below it will start complaining about it.
 */
public class ThereIsNoCheckedException {
    // No 'throws'
    public static void main(String[] args) {
        doThrow(new SQLException());

    }

    private static void doThrow(Exception e) {
        ThereIsNoCheckedException.doThrow0(e);

        //ThereIsNoCheckedException.doThrow1(e); // - must be surrounded with try catch
    }


    private static <E extends Exception> void doThrow0(Exception e) throws E {
        if(e != null)
            throw (E) e;
    }

    private static <E extends Exception> void doThrow1(E e) throws E {
        if(e != null)
            throw (E) e;
    }
}
