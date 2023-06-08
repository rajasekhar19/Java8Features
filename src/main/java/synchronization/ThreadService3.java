package synchronization;

import java.util.Date;
/*
Case4 : method1 is static synchronized
 */
public class ThreadService3 {
    static int i=0;
    int j=0;
    public static synchronized void method1 () {
        Date date = new Date();
        System.out.println(Thread.currentThread().getName() + " called method1 at " + date.getSeconds() + " : i :" + i);
        try {
            i++;
            Thread.sleep(10000);
        }
        catch (InterruptedException iEx) {
            iEx.printStackTrace();
        }
        date = new Date();
        System.out.println(Thread.currentThread().getName() + " exiting method1 at " + date.getSeconds() + " : i :" + i);
    }

    public void method2 () {
        Date date = new Date();
        System.out.println(Thread.currentThread().getName() + " called method2 at " + date.getSeconds() + " : j :" + j);
        try {
            j++;
            Thread.sleep(2000);
        }
        catch (InterruptedException iEx) {
            iEx.printStackTrace();
        }
        date = new Date();
        System.out.println(Thread.currentThread().getName() + " exiting method2 at " + date.getSeconds() + " : j :" + j);
    }
}

/*Case 4: method1 is static synchronized
One called method1 at 29 : i :0     //ststic synchronization behaviour will be same when we operate multiple threads on same object
Three called method2 at 29 : j :0
Three exiting method2 at 31 : j :1
One exiting method1 at 39 : i :1
Two called method1 at 39 : i :1
Two exiting method1 at 49 : i :2
 */