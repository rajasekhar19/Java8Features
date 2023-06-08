package synchronization;

/**
 * Cases 5 : Different threads calls methods on different object of a class (Thread Service)
 */
public class ThreadTest1 {
    public static void main(String[] s) {
        final ThreadService ser1 = new ThreadService();

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

        final ThreadService ser2 = new ThreadService();
        Thread t4 = new Thread("Four") {
            public void run() {
                ser2.method1();
            }
        };
        t4.start();

        Thread t5 = new Thread("Five") {
            public void run() {
                ser2.method2();
            }
        };
        t5.start();
    }
}
