package me.kupchenko.tricks.thread;

public class SynchronizationOnThread {
    private final static Thread thread = new Thread(()-> System.out.println("Hello there!!!"));

    public static void main(String[] args) throws InterruptedException {
        synchronized (thread) {
            thread.start();
            thread.wait();
            // Java invokes notifyAll() automatically???!!!
        }
        System.out.println("Hello after???!!!");
    }
}
