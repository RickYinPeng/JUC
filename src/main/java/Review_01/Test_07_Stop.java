package Review_01;

import java.util.Date;

/**
 * @author RickYinPeng
 * @ClassName Test_07_Stop
 * @Description 终止线程
 * @date 2019/1/20/21:18
 */
public class Test_07_Stop extends Thread{
    @Override
    public void run() {
        System.out.println("开始执行："+new Date());

        //休息10秒
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            //e.printStackTrace();

            System.out.println("线程被终止了");
        }

        System.out.println("结束执行："+new Date());
    }
}
class ThreadStopDemo{
    public static void main(String[] args) {
        Test_07_Stop t1 = new Test_07_Stop();
        t1.start();

        //中断线程
        /**
         * public final void stop(): 让线程停止过时了，但是还可以使用
         */
        /**
         * public void interrupt():  把线程的状态终止，并抛出一个InterruptedException的异常
         */
        try {
            //如果你超过3秒我就终止线程
            Thread.sleep(3000);
            //t1.stop();
            t1.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
