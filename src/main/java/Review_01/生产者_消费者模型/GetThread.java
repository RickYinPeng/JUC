package Review_01.生产者_消费者模型;

/**
 * @author RickYinPeng
 * @ClassName GetThread
 * @Description 消费者
 * @date 2019/1/20/22:00
 */
public class GetThread implements Runnable {
    private Student s;

    public GetThread(Student s) {
        this.s = s;
    }

    @Override
    public void run() {
        synchronized (s) {
            //判断有没有
            if (!s.flag){
                try {
                    s.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(s.name + "------" + s.age);

            //没有产品了
            s.flag = false;
            //唤醒线程
            s.notify();
        }

    }
}