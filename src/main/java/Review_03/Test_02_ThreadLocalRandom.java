package Review_03;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author RickYinPeng
 * @ClassName Test_02_ThreadLocalRandom
 * @Description ThreadLocalRandom的实现原理
 * @date 2019/2/2/14:13
 */
public class Test_02_ThreadLocalRandom {
    public static void main(String[] args) {
        /**
         * 获取当前线程的随机数生成器
         */
        ThreadLocalRandom random = ThreadLocalRandom.current();


        for(int i = 0;i<10;i++){
            System.out.println(random.nextInt(5));
        }
    }
}
