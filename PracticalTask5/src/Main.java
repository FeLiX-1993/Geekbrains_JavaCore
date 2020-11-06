public class Main {

    static final int SIZE = 10000000;

    public static void main(String[] args) {

        // Single thread
        long a = System.currentTimeMillis();
        calculateSingleThread();
        System.out.printf("Calculating score in 1 thread: %s\n", System.currentTimeMillis() - a);

        // Multiple threads
        for (int i = 2; i <= 10; i++) {
            long b = System.currentTimeMillis();
            calculateMultipleThreads(i);
            System.out.printf("Calculating score in %s threads: %s\n", i, System.currentTimeMillis() - b);
        }

    }

    public static void calculateSingleThread() {

        float[] arr = createArray();
        calculate(arr);

    }

    public static void calculateMultipleThreads(int countOfThreads) {

        float[] arr = createArray();
        int sizeOfParts = SIZE / countOfThreads;

        // Creating parts of array
        float[][] arr_Parts = new float[SIZE % countOfThreads == 0 ? countOfThreads : countOfThreads + 1][];
        for (int i = 0; i < arr_Parts.length; i++) {
            int srcPos = i * sizeOfParts;
            int length = Math.min(sizeOfParts, SIZE - srcPos);
            arr_Parts[i] = new float[length];
            System.arraycopy(arr, srcPos, arr_Parts[i], 0, length);
        }

        // Creating threads
        Thread[] threads = new Thread[arr_Parts.length];
        for (int i = 0; i < arr_Parts.length; i++) {
            float[] currentPart = arr_Parts[i];
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    calculate(currentPart);
                }
            });
            threads[i].start();
        }

        // Awaiting completion
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        // Collecting the array
        float[] arr_Full = new float[SIZE];
        for (int i = 0; i < arr_Parts.length; i++) {
            System.arraycopy(arr_Parts[i], 0, arr_Full, i * sizeOfParts, arr_Parts[i].length);
        }

    }

    public static void calculate(float[] arr) {

        for (int i = 0; i < arr.length; i++)
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

    }

    public static float[] createArray() {

        float[] arr = new float[SIZE];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        return arr;
    }
}
