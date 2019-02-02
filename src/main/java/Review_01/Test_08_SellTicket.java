package Review_01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author RickYinPeng
 * @ClassName Test_08_SellTicket
 * @Description Lock ：让我们可以显示的看到具体在哪里加锁，在哪里释放锁了
 * @date 2019/1/20/21:39
 */
public class Test_08_SellTicket implements Runnable{

    //定义票
    private int ticket = 100;

    /**
     * Lock:
     *      void lock(): 获取锁
     *      void unlock(): 释放锁
     * ReentrantLock是Lock的实现类
     */
    //定义锁对象
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){
            /**
             * 如果不加 try-catch-finally 一旦在代码执行过程中出事了，那么锁就不会释放，所以用try-catch-finally
             */
            try {
                //加锁
                lock.lock();
                if(ticket>0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"正在出售第"+(ticket--)+"张票");
                }
            } finally {
                //释放锁
                lock.unlock();
            }
        }
    }
}

class ThreadSellTicketDemo{
    public static void main(String[] args) {
        //创建资源对象
        Test_08_SellTicket ts = new Test_08_SellTicket();

        Thread t1 = new Thread(ts,"窗口1");
        Thread t2 = new Thread(ts,"窗口2");
        Thread t3 = new Thread(ts,"窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
