package Review_02;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author RickYinPeng
 * @ClassName Test_01_UnSafe
 * @Description 并没有感觉到什么卵用
 * @date 2019/1/25/19:57
 */
public  class Test_01_UnSafe {

    static   Unsafe unsafe;

    static  long stateOffset;

    private  static volatile long state = 0;

    static {
        try {
            /**
             * 使用反射来获取Unsafe类的成员变量theUnsafe
             */
            Field field = Unsafe.class.getDeclaredField("theUnsafe");

            field.setAccessible(true);

            unsafe  = (Unsafe) field.get(null);

            stateOffset = unsafe.objectFieldOffset(Test_01_UnSafe.class.getDeclaredField("state"));
        } catch (NoSuchFieldException e) {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Test_01_UnSafe test_01_unSafe = new Test_01_UnSafe();
        Boolean sucess = unsafe.compareAndSwapInt(test_01_unSafe,stateOffset,0,1);
        System.out.println(sucess);

        System.out.println(state);

    }
}
