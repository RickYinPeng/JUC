package Review_06;

import java.util.concurrent.locks.LockSupport;

/**
 * @author RickYinPeng
 * @ClassName Test_04_park_interrupt
 * @Description
 * @date 2019/2/7/12:35
 */
public class Test_04_park_interrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("child thread begin park!");
            while (!Thread.currentThread().isInterrupted()){
                LockSupport.park();
            }
            System.out.println("child thread unpark");
        });

        thread.start();

        Thread.sleep(1000);

        System.out.println("main thread begin unpark");

        thread.interrupt();
    }
}
