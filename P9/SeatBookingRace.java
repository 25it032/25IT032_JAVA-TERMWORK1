package P9;

class BookingSystem {
    int seatsLeft = 5;

    void book(String name) {

        if (seatsLeft > 0) {

            System.out.println(name + " booked a seat.");

            seatsLeft--;

            System.out.println("Seats left = " + seatsLeft);
        } else {
            System.out.println(name + " could not book. No seats left.");
        }
    }
}

class Customer extends Thread {
    BookingSystem system;

    Customer(BookingSystem system, String name) {
        super(name);
        this.system = system;
    }

    public void run() {
        system.book(getName());
    }
}

public class SeatBookingRace {
    public static void main(String[] args) {

        BookingSystem system = new BookingSystem();

        for (int i = 1; i <= 10; i++) {
            Customer c = new Customer(system, "Customer " + i);
            c.start();
        }
    }
}
