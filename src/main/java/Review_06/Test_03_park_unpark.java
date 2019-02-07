package Review_06;

import java.util.concurrent.locks.LockSupport;

/**
 * @author RickYinPeng
 * @ClassName Test_03_park_unpark
 * @Description
 * @date 2019/2/7/12:21
 */
public class Test_03_park_unpark {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("child thread begin park");

            LockSupport.park();

            System.out.println("child thread unpark");

        });

        thread.start();

        Thread.sleep(1000);

        System.out.println("main thread begin unpark");

        LockSupport.unpark(thread);
    }
}
