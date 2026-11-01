package P9;

class SharedTotal {
    long total = 0;

    void add(long value) {
        total = total + value;
    }
}

class SumThread extends Thread {
    int[] arr;
    int start;
    int end;
    SharedTotal shared;

    SumThread(int[] arr, int start, int end, SharedTotal shared) {
        this.arr = arr;
        this.start = start;
        this.end = end;
        this.shared = shared;
    }

    public void run() {
        for (int i = start; i < end; i++) {
            shared.add(arr[i]);
        }
    }
}

public class ArraySumRace {
    public static void main(String[] args) throws Exception {

        int size = 1000000;

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        SharedTotal shared = new SharedTotal();

        int part = size / 4;

        SumThread t1 = new SumThread(arr, 0, part, shared);
        SumThread t2 = new SumThread(arr, part, part * 2, shared);
        SumThread t3 = new SumThread(arr, part * 2, part * 3, shared);
        SumThread t4 = new SumThread(arr, part * 3, size, shared);

        long startTime = System.nanoTime();

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        long endTime = System.nanoTime();

        System.out.println("Expected Total = " + size);
        System.out.println("Actual Total = " + shared.total);

        System.out.println("Time = " +
                (endTime - startTime) + " nanoseconds");
    }
}