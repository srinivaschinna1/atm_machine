import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Create a sample user account
        BankAccount user = new BankAccount("123456", "0000", 5000.0);

        System.out.println("----- Welcome to Java ATM -----");

        // Step 2: Login process
        System.out.print("Enter Card Number: ");
        String card = sc.nextLine();

        System.out.print("Enter PIN: ");
        String pin = sc.nextLine();

        if (!user.getCardNumber().equals(card) || !user.checkPin(pin)) {
            System.out.println("❌ Invalid card or PIN. Exiting.");
            return;
        }

        // Step 3: ATM Menu Loop
        int choice;
        do {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("✅ Your balance is: ₹" + user.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double deposit = sc.nextDouble();
                    user.deposit(deposit);
                    System.out.println("💰 Deposited successfully.");
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdraw = sc.nextDouble();
                    if (user.withdraw(withdraw)) {
                        System.out.println("💵 Withdrawn successfully.");
                    } else {
                        System.out.println("❌ Insufficient balance.");
                    }
                    break;
                case 4:
                    System.out.println("👋 Thank you for using Java ATM.");
                    break;
                default:
                    System.out.println("⚠️ Invalid option. Try again.");
            }

        } while (choice != 4);
        
        sc.close();
    }
}
