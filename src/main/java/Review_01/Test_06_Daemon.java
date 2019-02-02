package Review_01;

/**
 * @author RickYinPeng
 * @ClassName Test_06_Daemon
 * @Description 守护线程
 * @date 2019/1/20/21:08
 */
public class Test_06_Daemon extends Thread{
    @Override
    public void run() {
        for(int i = 0;i<100;i++){
            System.out.println(getName()+":"+i);
        }
    }
}
class ThreadDaemonDemo{
    public static void main(String[] args) {
        Test_06_Daemon t1 = new Test_06_Daemon();
        Test_06_Daemon t2 = new Test_06_Daemon();

        t1.setName("张飞");
        t2.setName("关羽");

        /**
         * setDaemon():设置守护线程
         * 将该线程标记为守护线程或用户线程，当正在运行的线程都是守护线程时，Java虚拟机退出，该方法必须在启动线程前调用
         */
        t1.setDaemon(true);
        t2.setDaemon(true);

        t1.start();
        t2.start();

        Thread.currentThread().setName("刘备");
        for(int i = 0;i<5;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
