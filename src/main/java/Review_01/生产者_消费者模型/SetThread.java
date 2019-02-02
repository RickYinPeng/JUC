package Review_01.生产者_消费者模型;

/**
 * @author RickYinPeng
 * @ClassName SetThread
 * @Description 生产者
 * @date 2019/1/20/21:59
 */
public class SetThread implements Runnable {

    private Student s;

    public SetThread(Student s) {
        this.s = s;
    }

    @Override
    public void run() {
        synchronized (s) {
            //判断有没有
            if (s.flag) {
                try {
                    s.wait();//
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            s.name = "林青霞";
            s.age = 27;

            //有产品了,修改标记
            s.flag = true;
            //唤醒等待的线程
            s.notify();
        }
    }
}
