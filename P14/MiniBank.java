import java.util.Scanner;

public class MiniBank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankService service = new BankService();

        while (true) {
            System.out.println("1. Add Account");
            System.out.println("2. Show Account Count");
            System.out.println("3. Show Account");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter balance: ");
                        double balance = sc.nextDouble();
                        sc.nextLine();

                        service.addAccount(name, balance);
                        System.out.println("Account added successfully");
                        break;

                    case 2:
                        System.out.println("Account count: "
                                + service.getAccountCount());
                        break;

                    case 3:
                        System.out.print("Enter account index: ");
                        int index = sc.nextInt();

                        Account account = service.getAccount(index);

                        System.out.println("Name: " + account.getName());
                        System.out.println("Balance: " + account.getBalance());
                        break;

                    case 4:
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}