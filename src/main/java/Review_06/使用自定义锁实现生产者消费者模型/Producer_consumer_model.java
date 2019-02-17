package Review_06.使用自定义锁实现生产者消费者模型;

import Review_06.基于AQS实现不可重入锁.NonReentrantLock;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;

/**
 * @author RickYinPeng
 * @ClassName Producer_consumer_model
 * @Description 使用我们基于AQS实现的不可重入锁实现生产者消费者模型
 * @date 2019/2/16/20:04
 */
public class Producer_consumer_model {
    final static NonReentrantLock lock = new NonReentrantLock();
    final static Condition notFull = lock.newCondition();
    final static Condition notEmpty = lock.newCondition();

    final static Queue<String> queue = new LinkedBlockingQueue<String>();
    final static int queueSize = 10;

    public static void main(String[] args) {

        /**
         * 生产者线程
         */
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                //获取独占锁
                lock.lock();
                try {
                    //1、如果队列满了，则等待(避免虚假唤醒)
                    while (queue.size()==queueSize){
                        notEmpty.await();
                    }

                    //2、添加元素到队列
                    queue.add("ele");
                    System.out.println("添加一个元素");

                    //3、唤醒消费者线程
                    notFull.signalAll();

                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    //释放锁
                    lock.unlock();
                }
            }
        });

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                //获取独占锁
                lock.lock();
                try {
                    //队列空,则等待
                    while (0==queue.size()){
                        notFull.await();
                    }

                    //消费一个元素
                    String ele = queue.poll();
                    System.out.println("消费一个元素");

                    //唤醒生产线程
                    notEmpty.signalAll();

                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        });

        //启动线程
        producer.start();
        consumer.start();
    }
}
