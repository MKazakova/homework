package homework5;
import java.util.concurrent.CyclicBarrier;
import java.util.function.BiConsumer;

public class Exo5 {
    static final int size = 10000000;
    static final int h = size / 2;
    static final BiConsumer<float[], Integer> fillArray = (array, offset) -> {
        for(int i = 0; i<array.length; i++) {
            array[i] = (float)(array[i]*
                    Math.sin(0.2f + (i+offset)/5)*
                    Math.cos(0.2f + (i+offset)/5)*
                    Math.cos(0.4f + (i+offset)/2));
        }
    };

    public static void main(String[] args) {
        float[] arr = new float[size];
        for(int i = 0; i<size; i++) {
            arr[i] = 1;
        }
        firstMethod(arr);
        float[] arr2 = new float[size];
        for(int i = 0; i<size; i++) {
            arr2[i] = 1;
        }
        secondMethod(arr2);
    }

    public static void firstMethod(float[] arr) {
        long a = System.currentTimeMillis();
        fillArray.accept(arr, 0);
        System.out.println("first : "+(System.currentTimeMillis() - a));
    }

    public static void secondMethod(float[] arr) {
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        long b = System.currentTimeMillis();
        Thread t1 = new Thread(() -> fillArray.accept(a1, 0));
        Thread t2 = new Thread(() -> fillArray.accept(a2, h));
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
            System.arraycopy(a1, 0, arr, 0, h);
            System.arraycopy(a2, 0, arr, h, h);
            System.out.println("second : "+(System.currentTimeMillis() - b));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}