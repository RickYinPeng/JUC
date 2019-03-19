package Review_01;

/**
 * @author RickYinPeng
 * @ClassName Test_12_ThreadLocal
 * @Description ThreadLocal不支持继承
 * @date 2019/1/23/18:09
 */
public class Test_12_ThreadLocal {
    /**
     * 创建线程变量
     */
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("hello world");
        /**
         * 启动子线程nizanlinewozaihelin
         */
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                /**
                 * 子线程输出线程变量的值
                  */
                System.out.println("thread:"+threadLocal.get());
            }
        });
        thread.setName("子线程");
        thread.start();
        /**
         * 主线程输出主线程变量的值
         */
        System.out.println("main:"+threadLocal.get());
    }

}
