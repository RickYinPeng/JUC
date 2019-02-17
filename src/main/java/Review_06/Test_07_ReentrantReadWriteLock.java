package Review_06;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author RickYinPeng
 * @ClassName Test_07_ReentrantReadWriteLock
 * @Description 读写锁
 * @date 2019/2/17/21:02
 */
public class Test_07_ReentrantReadWriteLock {
    public static void main(String[] args) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        System.out.println((1 << 16));
        System.out.println(Integer.toBinaryString((1<<16)-1));
    }
}
