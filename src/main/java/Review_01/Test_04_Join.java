package Review_01;

/**
 * @author RickYinPeng
 * @ClassName Test_04_Join
 * @Description 加入线程：为了让某些线程执行完毕，别的线程才能执行
 * @date 2019/1/20/20:57
 */
public class Test_04_Join extends Thread{
    @Override
    public void run() {
        for(int i = 0;i<100;i++){
            System.out.println(getName()+":"+i);
        }
    }
}
class ThreadJoinDemo{
    public static void main(String[] args) throws InterruptedException {
        Test_04_Join t1 = new Test_04_Join();
        Test_04_Join t2 = new Test_04_Join();
        Test_04_Join t3 = new Test_04_Join();

        t1.setName("李渊");

        /**
         * join(): 等待该线程终止
         */


        t2.setName("李世民");
        t3.setName("李元霸");

        t1.start();


        t2.start();
        t3.start();

        /**
         * 李渊结束之后才能执行李世民和李元霸的线程
         */
        t1.join();
    }
}