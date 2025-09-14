package bank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AccountDAO dao = new AccountDAO();

        while (true) {
            System.out.println("\n=== Bank Menu ===");
            System.out.println("1. Create Account");
            System.out.println("2. View All Accounts");
            System.out.println("3. Exit");
            System.out.println("4. Deposit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double bal = sc.nextDouble();
                    dao.createAccount(name, bal);
                    break;

                case 2:
                    dao.getAllAccounts().forEach(System.out::println);
                    break;

                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
// Deposit Option 
                case 4:
                    System.out.print("Enter Account No: ");
                    int accNo = sc.nextInt();
                    System.out.print("Enter Amount to Deposit: ");
                    double amount = sc.nextDouble();
                    dao.deposit(accNo, amount);
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
