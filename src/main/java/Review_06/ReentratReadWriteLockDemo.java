package Review_06;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author RickYinPeng
 * @ClassName ReentratReadWriteLockDemo
 * @Description
 * @date 2019/2/18/22:49
 */
public class ReentratReadWriteLockDemo {
    public static void main(String[] args) throws InterruptedException {
        News news = new News();
        Thread.sleep(1000);

        //read
        for(int n = 0; n < 3; n++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String pre = "";
                    while(true){
                        String s = news.getLast();
                        if(s == null)
                            continue;
                        if(!s.equals(pre)) {
                            pre = s;
                            System.out.println(Thread.currentThread().getName() + " get the last news : " + s);
                            if(Integer.parseInt(s) == 9)
                                break;
                        }
                    }
                }
            }, "read thread" + n).start();
        }

/*        //write
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int  i = 0; i < 10; i++){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    news.add(i + "");
                }
            }
        }).start();*/
    }

    static class News {
        private static final List<String> newsList = new ArrayList<>();
        static {
            newsList.add("a");
            newsList.add("a");
            newsList.add("a");
            newsList.add("a");
            newsList.add("a");
            newsList.add("a");
            newsList.add("a");
        }


        private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        private Lock readLock = lock.readLock();

        private Lock writeLock = lock.writeLock();

        public String getLast(){
            readLock.lock();

            readLock.unlock();
            readLock.lock();
            readLock.unlock();
            try{
                if(newsList.size() == 0)
                    return null;
                return newsList.get(newsList.size() - 1);
            }
            finally {

            }
        }

/*        public void add(String news) {
            writeLock.lock();
            try{
                newsList.add(news);
                System.out.println("add a news:" + news);
            }
            finally {
                writeLock.unlock();
            }
        }*/
    }
}
