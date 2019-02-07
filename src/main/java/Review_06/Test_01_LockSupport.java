package Review_06;

import java.util.concurrent.locks.LockSupport;

/**
 * @author RickYinPeng
 * @ClassName Test_01_LockSupport
 * @Description park方法
 * @date 2019/2/7/12:05
 */
public class Test_01_LockSupport {
    public static void main(String[] args) {
        System.out.println("begin park!");
        LockSupport.park();
        System.out.println("end park!");
    }
}
