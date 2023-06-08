package synchronization;

/**
 * Cases 1 - 4 : Different threads calls methods on same object of a class (Thread Service)
 * Case 1: methods are not synchronized so 2 threads Simultaneously can access methods
 * & possible to corrupt data.
 */
public class ThreadTest {
    public static void main(String[] s) {
        //case 1
        //final ThreadService ser1 = new ThreadService();
        //Case 2
        //final ThreadService1 ser1 = new ThreadService1();
        //case 4
        final ThreadService3 ser1 = new ThreadService3();

        Thread t1 = new Thread("One") {
            public void run() {
                ser1.method1();
            }
        };
        t1.start();

        Thread t2 = new Thread("Two") {
            public void run() {
                ser1.method1();
            }
        };
        t2.start();

        Thread t3 = new Thread("Three") {
            public void run() {
                ser1.method2();
            }
        };
        t3.start();
    }
}
