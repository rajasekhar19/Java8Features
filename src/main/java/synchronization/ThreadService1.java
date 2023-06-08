package synchronization;

import java.util.Date;
/*
Case2 : To avoid Case1, corrupting i value make method1 as synchronized
 */
public class ThreadService1 {
    int i=0, j=0;
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

    //public void method2 () {
    //Case 3
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
One called method1 at 36 : i :0     //method1 is synchronized. Thread One acquires monitor for method1 on current object, calls method1
Three called method2 at 36 : j :0   //incremented i by 1 & sleeps. Thread Two is waiting for Thread One to release monitor. Thread Three
Three exiting method2 at 38 : j :1  //can still call method2 as its not synchronized.
One exiting method1 at 46 : i :1    //Thread One copletes execution & releases monitor.
Two called method1 at 46 : i :1     //Thread Two acquires monitor for method1 on current object, calls method1, increment i by 1.
Two exiting method1 at 56 : i :2
 */

/* Case3: both methods are synchronized.
One called method1 at 21 : i :0     //method1 is synchronized. Thread One acquires monitor for method1 on current object, calls method1
One exiting method1 at 31 : i :1    //incremented i by 1 & sleeps. Thread Two is waiting for Thread One to release monitor.
Three called method2 at 31 : j :0   //In this case both methods are synchronized so Two & Three will wait for monitor.
Three exiting method2 at 33 : j :1
Two called method1 at 33 : i :1
Two exiting method1 at 43 : i :2
 */

/*Case 4: method1 is static synchronized

 */