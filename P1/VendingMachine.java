import java.util.Scanner;
enum Coin{ONE, TWO,FIVE,TEN}
public class VendingMachine
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int price = 15;
        int total = 0;
        while (total < price)
        {
            System.out.print("Enter the coin : ");
            String input = sc.next();
            Coin coin = Coin.valueOf(input);

            int value = switch (coin)
            {
                case ONE -> 1;
                case TWO -> 2;
                case FIVE -> 5;
                case TEN -> 10;
            };
            total = total + value;

                System.out.println("Total paid = " + total);
        }
        int change = total - price;

        System.out.println("Paid.");
        System.out.println("Change = " + change);

        sc.close();
    }
}