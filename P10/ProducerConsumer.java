public class ProducerConsumer {

    static int[] buffer = new int[3];
    static int count = 0;

    static synchronized void produce(int value) throws InterruptedException {

        while (count == buffer.length) {
            ProducerConsumer.class.wait();
        }

        buffer[count] = value;
        count++;

        System.out.println("Produced: " + value);

        ProducerConsumer.class.notify();
    }

    static synchronized int consume() throws InterruptedException {

        while (count == 0) {
            ProducerConsumer.class.wait();
        }

        int value = buffer[0];

        for (int i = 1; i < count; i++) {
            buffer[i - 1] = buffer[i];
        }

        count--;

        System.out.println("Consumed: " + value);

        ProducerConsumer.class.notify();

        return value;
    }

    public static void main(String[] args) {

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    produce(i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    consume();
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}