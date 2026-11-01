package P9;

class Counter {
    int count = 0;

    void increment() {
        count++;
    }
}

class CounterThread extends Thread {
    Counter counter;

    CounterThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 100000; i++) {
            counter.increment();
        }
    }
}

public class CounterRace {
    public static void main(String[] args) throws Exception {

        Counter counter = new Counter();

        CounterThread t1 = new CounterThread(counter);
        CounterThread t2 = new CounterThread(counter);
        CounterThread t3 = new CounterThread(counter);
        CounterThread t4 = new CounterThread(counter);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println("Expected = 400000");
        System.out.println("Actual = " + counter.count);
    }
}