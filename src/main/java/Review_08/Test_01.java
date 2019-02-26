package Review_08;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author RickYinPeng
 * @ClassName Test_01
 * @Description 线程池
 * @date 2019/2/22/19:29
 */
public class Test_01 {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

        threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("你好，线程池"); 
            }
        });
    }
}
