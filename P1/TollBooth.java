import java.util.Scanner;

class Vehicle {

    String number;
    String type;

    Vehicle(String number, String type) {
        this.number = number;
        this.type = type;
    }
}

public class TollBooth {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int totalToll = 0;

        int bikeCount = 0;
        int carCount = 0;
        int truckCount = 0;

        while (true) {

            System.out.print("Enter vehicle number (or done): ");
            String number = sc.next();

            if (number.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter vehicle type (bike/car/truck): ");
            String type = sc.next().toLowerCase();

            Vehicle vehicle = new Vehicle(number, type);

            int toll = switch (vehicle.type) {
                case "bike" -> 20;
                case "car" -> 50;
                case "truck" -> 150;
                default -> 0;
            };

            totalToll += toll;

            switch (vehicle.type) {
                case "bike" -> bikeCount++;
                case "car" -> carCount++;
                case "truck" -> truckCount++;
            }
        }

        String mostFrequent;

        if (bikeCount >= carCount && bikeCount >= truckCount) {
            mostFrequent = "bike";
        } else if (carCount >= bikeCount && carCount >= truckCount) {
            mostFrequent = "car";
        } else {
            mostFrequent = "truck";
        }

        System.out.println("Total toll: " + totalToll);
        System.out.println("Most frequent: " + mostFrequent);

        sc.close();
    }
}