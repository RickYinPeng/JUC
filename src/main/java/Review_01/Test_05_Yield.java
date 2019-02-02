package Review_01;

/**
 * @author RickYinPeng
 * @ClassName Test_05_Yield
 * @Description 礼让线程：暂停当前正在执行的线程对象，并执行其他线程
 * @date 2019/1/20/21:02
 */
public class Test_05_Yield extends Thread{
    @Override
    public void run() {
        for(int i = 0;i<100;i++){
            System.out.println(getName()+":"+i);
            /**
             * 线程礼让可以在一定程度上让线程执行的更和谐一些，但是不能靠它保证让线程一人一次
             */
            Thread.yield();
        }
    }
}

class ThreadYieldDemo{
    public static void main(String[] args) {
        Test_05_Yield t1 = new Test_05_Yield();
        Test_05_Yield t2 = new Test_05_Yield();

        t1.setName("林青霞");
        t2.setName("尹鹏");

        t1.start();
        t2.start();


    }
}
