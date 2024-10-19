package banking_app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankingSystem bankingSystem = new BankingSystem();
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("\nWelcome to the Banking System");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter account holder name: ");
                    String name = scanner.nextLine();
                    bankingSystem.createAccount(name);
                    break;
                case "2":
                    System.out.print("Enter account holder name: ");
                    name = scanner.nextLine();
                    BankAccount account = bankingSystem.getAccount(name);
                    if (account != null) {
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = Double.parseDouble(scanner.nextLine());
                        account.deposit(depositAmount);
                    }
                    break;
                case "3":
                    System.out.print("Enter account holder name: ");
                    name = scanner.nextLine();
                    account = bankingSystem.getAccount(name);
                    if (account != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = Double.parseDouble(scanner.nextLine());
                        account.withdraw(withdrawAmount);
                    }
                    break;
                case "4":
                    System.out.print("Enter your account holder name: ");
                    String fromAccountHolder = scanner.nextLine();
                    account = bankingSystem.getAccount(fromAccountHolder);
                    if (account != null) {
                        System.out.print("Enter target account holder name: ");
                        String toAccountHolder = scanner.nextLine();
                        BankAccount targetAccount = bankingSystem.getAccount(toAccountHolder);
                        if (targetAccount != null) {
                            System.out.print("Enter amount to transfer: ");
                            double transferAmount = Double.parseDouble(scanner.nextLine());
                            account.transfer(targetAccount, transferAmount);
                        } else {
                            System.out.println("Target account not found!");
                        }
                    }
                    break;
                case "5":
                    System.out.println("Exiting the banking system. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (!choice.equals("5"));

        scanner.close();
    }
}