package synchronization;

import java.util.Date;

public class ThreadService {
    int i=0, j=0;
    //public void method1 () {
    //Case 6: method1 & method2 are synchronized
    //Case 7: method1 is static synchronized
    //Case 8: method1 & method2 are static synchronized
    public synchronized void method1 () {
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

    public synchronized void method2 () {
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
/*
Case 1:
Three called method2 at 58 : j :0
Two called method1 at 58 : i :0
One called method1 at 58 : i :0
Three exiting method2 at 0 : j :1       //Thread One called method1, incremented i by 1 & sleep
Two exiting method1 at 8 : i :2         //Thread Two is able to call method1 as its not synch & incremented i by 1
One exiting method1 at 8 : i :2         // because of this Thread one got final value as 2 instead of 1.

 */