import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolRunner {
    public static void main(String[] args) throws Exception {

        ExecutorService pool = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 10; i++) {
            int id = i;

            pool.execute(() -> {
                try {
                    System.out.println("Task " + id + " running on " +
                            Thread.currentThread().getName());
                    Thread.sleep(500);
                    System.out.println("Task " + id + " completed");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        pool.shutdown();
        pool.awaitTermination(10, java.util.concurrent.TimeUnit.SECONDS);

        System.out.println("All tasks completed");
    }
}