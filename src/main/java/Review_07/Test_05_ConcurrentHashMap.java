package Review_07;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author RickYinPeng
 * @ClassName Test_05_ConcurrentHashMap
 * @Description
 * @date 2019/3/20/20:54
 */
public class Test_05_ConcurrentHashMap {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer,String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(1,"a");
        HashMap hashMap = new HashMap();
    }
}
