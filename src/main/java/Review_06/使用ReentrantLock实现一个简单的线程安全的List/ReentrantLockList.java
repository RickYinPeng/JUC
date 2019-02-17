package Review_06.使用ReentrantLock实现一个简单的线程安全的List;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author RickYinPeng
 * @ClassName ReentrantLockList
 * @Description
 * @date 2019/2/16/21:08
 */
public class ReentrantLockList {
    //线程不安全的list
    private ArrayList<String> array = new ArrayList<>();
    //独占锁
    private volatile ReentrantLock lock = new ReentrantLock();

    //添加元素
    public void add(String e){
        lock.lock();
        try {
            array.add(e);
        }finally {
            lock.unlock();
        }
    }

    //删除元素
    public void remove(String e){
        lock.lock();
        try {
            array.remove(e);
        }finally {
            lock.unlock();
        }
    }

    //获取数据
    public String get(int index){
        lock.lock();
        try {
            return array.get(index);
        }finally {
            lock.unlock();
        }
    }

}
