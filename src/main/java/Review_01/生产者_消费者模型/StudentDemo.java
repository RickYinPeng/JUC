package Review_01.生产者_消费者模型;

/**
 * @author RickYinPeng
 * @ClassName StudentDemo
 * @Description 测试代码
 * @date 2019/1/20/22:01
 */
public class StudentDemo {
    public static void main(String[] args) {
        //创建资源
        Student s = new Student();

        SetThread st= new SetThread(s);
        GetThread gt = new GetThread(s);

        Thread t1 = new Thread(st);
        Thread t2 = new Thread(gt);

        t2.start();
        t1.start();
    }
}
