package me.kupchenko.tricks.exceptions;

public class TryCatchFinally {

    public void work() { //Never stops!
        try {
            work();
        } finally {
            work();
        }
        // In this case no StackOverFlowError will be thrown.
        // It would only execute 'work()' over and over.
    }

}
