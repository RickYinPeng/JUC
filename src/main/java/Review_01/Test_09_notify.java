package Review_01;

/**
 * @author RickYinPeng
 * @ClassName Test_09_notify
 * @Description notify和notifyAll的使用
 * @date 2019/1/21/18:33
 */
public class Test_09_notify {

    private static volatile Object resourcesA = new Object();

    public static void main(String[] args) throws InterruptedException {
        //创建线程A
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourcesA){
                    System.out.println("threadA get resourcesA lock");

                    try {
                        System.out.println("threadA begin wait");
                        resourcesA.wait();
                        System.out.println("threadA end wait");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        //创建线程B
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourcesA){
                    System.out.println("threadB get resourcesB lock");

                    try {
                        System.out.println("threadB begin wait");
                        resourcesA.wait();
                        System.out.println("threadB end wait");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        //创建线程B
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourcesA){
                    System.out.println("threadC begin notify");
                    /**
                     * 只会激活resourcesA阻塞队列上的一个线程，而且是随机的
                     */
                    //resourcesA.notify();

                    /**
                     * 会激活resourcesA阻塞队列上的所有线程
                     */
                    resourcesA.notifyAll();
                }
            }
        });

        //启动线程
        threadA.start();
        threadB.start();

        Thread.sleep(1000);
        threadC.start();

        //等待线程结束
        threadA.join();
        threadB.join();
        threadC.join();

        System.out.println("main over");

    }

}
