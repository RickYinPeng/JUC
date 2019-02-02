package Review_01;

/**
 * @author RickYinPeng
 * @ClassName Test_01_ThreadTest
 * @Description 实现线程的第一种方式:继承Thread类
 * @date 2019/1/19/19:30
 */
public class Test_01_ThreadTest {
    /**
     * 继承Thread类并重写run方法
     *      好处：
     *          在run()方法内部获取当前线程直接使用this就可以了，无需使用Thread.currentThread()
     *      不好处：
     *          1：Java不支持多继承，如果继承了Thread类就不能再去继承其他类
     *          2：任务和代码没有分离，当多个线程执行一样的任务时需要多份任务代码
     */
    public static class MyThread extends Thread{
        @Override
        public void run() {
            this.setName("子线程");
            System.out.println(Thread.currentThread().getName());
            System.out.println(this.getName());
            System.out.println("I am a child thread");
        }
    }

    public static void main(String[] args) {
        //创建线程
        MyThread myThread = new MyThread();
        System.out.println(Thread.currentThread().getName());
        //启动线程
        myThread.start();
    }
}
