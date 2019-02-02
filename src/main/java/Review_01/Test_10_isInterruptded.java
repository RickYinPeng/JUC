package Review_01;

/**
 * @author RickYinPeng
 * @ClassName Test_10_isInterruptded
 * @Description 测试 isInterruptded
 * @date 2019/1/21/19:24
 */
public class Test_10_isInterruptded {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                System.out.println("线程开始执行");
                while (true){
                    System.out.println(i++);
                }
            }
        });

        t1.start();
        Thread.sleep(1000);
        System.out.println("开始中断线程----------------------");
        t1.interrupt();


        t1.join();
        System.out.println("main is over");

    }
}
