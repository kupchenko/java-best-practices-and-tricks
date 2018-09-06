package me.kupchenko.tricks;


/**
 * Class shows how you can save reference to object using finalize method
 */
public class Finalize {
    static Finalize obj;

    @Override
    protected void finalize() throws Throwable {
        // Saving reference to inner static field
        obj = this;
        System.out.println("Deleting " + this.toString());
    }

    public static void main(String[] args) throws InterruptedException {
        Finalize localObject = new Finalize();
        System.out.println("Object before GC: " + localObject);
        localObject = null;
        System.gc(); // Ask GC to start the work
        while (Finalize.obj == null) {
            System.out.println("Still alive!!");
            Thread.sleep(1000);
        }
        System.out.println("Object AFTER deleting: " + Finalize.obj);
    }

    @Override
    public String toString() {
        return "Object: " + super.toString();
    }
}
