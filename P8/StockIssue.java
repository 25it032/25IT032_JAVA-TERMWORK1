package P8;
class OutOfStockException extends Exception {
    private int shortfall;

    OutOfStockException(String message, int shortfall) {
        super(message);
        this.shortfall = shortfall;
    }

    public int getShortfall() {
        return shortfall;
    }
}

class InvalidQuantityException extends Exception {
    InvalidQuantityException(String message) {
        super(message);
    }
}

class Warehouse {
    private int stock = 10;

    public void issue(String item, int qty)
            throws OutOfStockException, InvalidQuantityException {

        if (qty <= 0) {
            throw new InvalidQuantityException(
                    "Quantity must be greater than zero.");
        }

        if (qty > stock) {
            int shortfall = qty - stock;

            throw new OutOfStockException(
                    "Not enough stock for " + item,
                    shortfall);
        }

        stock = stock - qty;

        System.out.println(qty + " " + item + " issued successfully.");
        System.out.println("Remaining stock = " + stock);
    }
}

public class StockIssue {
    public static void main(String[] args) {

        Warehouse warehouse = new Warehouse();

        String[] items = {"Pen", "Pen", "Pen", "Pen"};
        int[] quantities = {3, 5, 0, 6};

        for (int i = 0; i < items.length; i++) {

            try {
                System.out.println("Request: "
                        + items[i] + " Quantity: " + quantities[i]);

                warehouse.issue(items[i], quantities[i]);
            }

            catch (InvalidQuantityException e) {
                System.out.println("Error: " + e.getMessage());
            }

            catch (OutOfStockException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Shortfall = " + e.getShortfall());
            }

            System.out.println();
        }

        System.out.println("All requests processed.");
    }
}