package mybank;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private static List<Customer> customers = new ArrayList<>();

    // Метод для читання даних з файлу
    public static void loadCustomersFromFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            int numberOfCustomers = Integer.parseInt(line.trim()); // Перша строка — кількість клієнтів

            for (int i = 0; i < numberOfCustomers; i++) {
                // Читаємо дані про клієнта
                do {
                    line = reader.readLine();
                } while (line != null && line.trim().isEmpty());
                
                String[] customerParts = line.trim().split("\\s+");
                
                String firstName = customerParts[0];
                String lastName = customerParts[1];
                int numberOfAccounts = Integer.parseInt(customerParts[2]);

                Customer customer = new Customer(firstName, lastName);

                // Читаємо дані про рахунки клієнта
                for (int j = 0; j < numberOfAccounts; j++) {
                    line = reader.readLine();
                    String[] accountParts = line.split("\\s+");
                    String accountType = accountParts[0];
                    double balance = Double.parseDouble(accountParts[1]);

                    if (accountType.equalsIgnoreCase("S")) {
                        double interestRate = Double.parseDouble(accountParts[2]);
                        customer.addAccount(new SavingsAccount("Savings", balance, interestRate));
                    } else if (accountType.equalsIgnoreCase("C")) {
                        double creditLimit = Double.parseDouble(accountParts[2]);
                        customer.addAccount(new CheckingAccount("Checking", balance, creditLimit));
                    }
                }

                customers.add(customer);
            }
        }
    }

    // Метод для отримання клієнта за його номером
    public static Customer getCustomer(int customerId) {
        if (customerId >= 0 && customerId < customers.size()) {
            return customers.get(customerId);
        }
        throw new IllegalArgumentException("Invalid customer ID");
    }
}