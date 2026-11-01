public class CinemaShow {

    private String title;
    private int seatsAvailable;
    private final int capacity;
    private static int totalBooked = 0;

    public CinemaShow(String title, int capacity) {
        this.title = title;
        this.seatsAvailable = capacity;
        this.capacity = capacity;
    }

    public CinemaShow(String title) {
        this(title, 100);
    }

    public boolean book(int n) {
        if (n <= seatsAvailable) {
            seatsAvailable = seatsAvailable - n;
            totalBooked = totalBooked + n;
            return true;
        } else {
            return false;
        }
    }

    public void cancel(int n) {
        seatsAvailable += n;

        if (seatsAvailable > capacity) {
            seatsAvailable = capacity;
        }
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public static int getTotalBooked() {
        return totalBooked;
    }

    public static void main(String[] args) {

        CinemaShow show = new CinemaShow("Avengers");

        System.out.println(show.book(30));
        System.out.println("Seats Available = " + show.getSeatsAvailable());

        System.out.println(show.book(50));
        System.out.println("Seats Available = " + show.getSeatsAvailable());

        System.out.println(show.book(30));
        System.out.println("Seats Available = " + show.getSeatsAvailable());

        show.cancel(10);
        System.out.println("Seats Available = " + show.getSeatsAvailable());

        System.out.println("Total Booked Seats = " + CinemaShow.getTotalBooked());
    }
}