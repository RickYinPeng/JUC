package Review_01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author RickYinPeng
 * @ClassName Test_03_Callable
 * @Description 实现线程的第三种方式：实现Callable接口
 * @date 2019/1/19/20:00
 */
public class Test_03_Callable {

    static class CallerTask implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "hello";
        }
    }

    public static void main(String[] args) {
        //创建异步任务
        FutureTask<String> futureTask = new FutureTask<String>(new CallerTask());

        //启动线程
        new Thread(futureTask).start();

        try {
            //等待任务执行完毕，并返回结果
            String result = futureTask.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
