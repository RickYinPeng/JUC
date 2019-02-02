package Review_01;

/**
 * @author RickYinPeng
 * @ClassName Test_08_Interrupt
 * @Description
 * @date 2019/1/21/16:23
 */
public class Test_08_Interrupt implements Runnable{

    public static void main(String[] args) throws InterruptedException {
        Thread testThread = new Thread(new Test_08_Interrupt(),"InterruptionInJava");
        //start thread
        testThread.start();
        Thread.sleep(1000);
        //interrupt thread
        testThread.interrupt();
        System.out.println("main end");
    }



    @Override
    public void run() {
        while(true){
            if(Thread.currentThread().isInterrupted()){
                System.out.println("Yes,I am interruted,but I am still running");

            }else{
                System.out.println("not yet interrupted");
            }
        }
    }
}
