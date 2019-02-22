package Review_07;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author RickYinPeng
 * @ClassName Test_03_ArrayBlockingQueue
 * @Description
 * @date 2019/2/21/16:38
 */
public class Test_03_ArrayBlockingQueue {
    public static void main(String[] args) {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1);
        int i = 0;
        if(i++ == 1){
            System.out.println("a");
        }
        System.out.println(i);
    }

}
