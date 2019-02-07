package Review_06;

import java.util.concurrent.locks.LockSupport;

/**
 * @author RickYinPeng
 * @ClassName Test_02_unpark
 * @Description unpark方法
 * @date 2019/2/7/12:19
 */
public class Test_02_unpark {
    public static void main(String[] args) {
        System.out.println("begin park!");

        LockSupport.unpark(Thread.currentThread());

        LockSupport.park();

        System.out.println("end park!");
    }
}
