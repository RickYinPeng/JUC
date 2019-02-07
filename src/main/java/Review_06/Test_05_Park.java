package Review_06;

import java.util.concurrent.locks.LockSupport;

/**
 * @author RickYinPeng
 * @ClassName Test_05_Park
 * @Description
 * @date 2019/2/7/12:40
 */
public class Test_05_Park {
    public static void main(String[] args) {
        Test_05_Park test_05_park = new Test_05_Park();
        test_05_park.testPark();
    }
    public void testPark(){
        LockSupport.park();
    }
}
