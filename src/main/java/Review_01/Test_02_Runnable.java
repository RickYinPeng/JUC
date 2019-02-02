package Review_01;

/**
 * @author RickYinPeng
 * @ClassName Test_02_Runnable
 * @Description 实现线程的第二种方式：实现Runnable接口
 * @date 2019/1/19/19:52
 */
public class Test_02_Runnable {

    /**
     * 这样两个线程就共用一个task代码逻辑，而且RunnableTask可以继承其他类
     *      缺点：
     *          任务没有返回值，之前继承Thread的方法也没有返回值
     */
    static class RunnableTask implements Runnable{
        @Override
        public void run() {
            System.out.println("I am a child thread");
        }
    }

    public static void main(String[] args) {
        RunnableTask task = new RunnableTask();
        new Thread(task).start();
        new Thread(task).start();
    }
}