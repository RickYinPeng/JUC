package Review_01;

/**
 * @author RickYinPeng
 * @ClassName Test_11_ThreadLocal
 * @Description ThreadLocal类
 * @date 2019/1/22/19:38
 */
public class Test_11_ThreadLocal {

    static ThreadLocal<String> localVariable = new ThreadLocal<String>();

    static void print(String str){

        System.out.println(str+":"+localVariable.get());


        //localVariable.remove();
    }

    public static void main(String[] args) {

        localVariable.set("main local variable");

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                localVariable.set("threadOne local variable");
                print("threadOne");

                //System.out.println("threadOne remove after:"+localVariable.get());
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                localVariable.set("threadTwo local variable");


                print("threadTwo");

                //System.out.println("threadTwo remove after:"+localVariable.get());
            }
        });

        threadOne.setName("线程1");
        threadTwo.setName("线程2");

        threadOne.start();
        threadTwo.start();

        System.out.println(localVariable.get());

    }
}
