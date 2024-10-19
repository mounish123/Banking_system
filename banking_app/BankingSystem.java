package banking_app;

import java.util.HashMap;

public class BankingSystem {
    private HashMap<String, BankAccount> accounts;

    public BankingSystem() {
        accounts = new HashMap<>();
    }

    public void createAccount(String accountHolder) {
        String normalizedAccountHolder = accountHolder.toLowerCase(); // normalize case
        if (!accounts.containsKey(normalizedAccountHolder)) {
            accounts.put(normalizedAccountHolder, new BankAccount(accountHolder));
            System.out.println("Account created for " + accountHolder);
        } else {
            System.out.println("Account already exists for " + accountHolder);
        }
    }

    public BankAccount getAccount(String accountHolder) {
        String normalizedAccountHolder = accountHolder.toLowerCase(); // normalize case
        BankAccount account = accounts.get(normalizedAccountHolder);
        if (account == null) {
            System.out.println("Account not found for: " + accountHolder);
        }
        return account;
    }
}