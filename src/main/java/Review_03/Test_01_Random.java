package Review_03;

import java.util.Random;

/**
 * @author RickYinPeng
 * @ClassName Test_01_Random
 * @Description Random类的使用方法
 * @date 2019/2/2/14:00
 */
public class Test_01_Random {
    public static void main(String[] args) {
        Random random = new Random();

        for(int i = 0;i<10;i++){
            System.out.println(random.nextInt(5));
        }
    }
}
