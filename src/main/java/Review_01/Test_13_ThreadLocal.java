package Review_01;

/**
 * @author RickYinPeng
 * @ClassName Test_13_ThreadLocal
 * @Description
 * @date 2019/1/23/18:24
 */
public class Test_13_ThreadLocal {
    //static ThreadLocal<String> localVariable = new ThreadLocal<String>();
    static ThreadLocal<String> localVariable = new InheritableThreadLocal<>();

    public static void main(String[] args) {

        Thread.currentThread().setName("主线程");

        localVariable.set("main local variable");

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("子线程:"+localVariable.get());
            }
        });
        threadOne.setName("子线程");
        threadOne.start();
        System.out.println("父线程："+localVariable.get());
    }
}
