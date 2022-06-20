//TODO Saves in a file every person with their data
//TODO Simple CustomerId validator

import java.util.Scanner;

public class SoftwareApplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your 'Name' and 'CustomerId' to access your Bank account:");
        String name = sc.nextLine();
        String customerId = sc.nextLine();
        BankAccount obj1 = new BankAccount(name, customerId);
        obj1.menu();
    }
}

class BankAccount {
    double balance;
    double prevTrans;
    String customerName;
    String customerId;

    BankAccount(String customerName, String customerId) {
        this.customerName = customerName;
        this.customerId = customerId;
    }

    void deposit(double amount) {
        if (amount != 0) {
            balance += amount;
            prevTrans = amount;
        }
    }

    void withdraw(double amt) {
        if (amt != 0 && balance >= amt) {
            balance -= amt;
            prevTrans = -amt;
        } else if (balance < amt) {
            System.out.println("Bank balance insufficient");
        }
    }

    void getPreviousTrans() {
        if (prevTrans > 0) {
            System.out.println("Deposited: " + prevTrans);
        } else if (prevTrans < 0) {
            System.out.println("Withdrawn: " + Math.abs(prevTrans));
        } else {
            System.out.println("No transaction occured");
        }
    }

    void menu() {
        char option;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome " + customerName);
        System.out.println("Your ID:" + customerId);
        System.out.println("\n");
        System.out.println("a) Check Balance");
        System.out.println("b) Deposit Amount");
        System.out.println("c) Withdraw Amount");
        System.out.println("d) Previous Transaction");
        System.out.println("e) Exit");

        do {
            System.out.println("********************************************");
            System.out.println("Choose an option");
            option = sc.next().charAt(0);
            System.out.println("\n");

            switch (option) {
                case 'a' -> {
                    System.out.println("......................");
                    System.out.println("Balance =" + balance);
                    System.out.println("......................");
                    System.out.println("\n");
                }
                case 'b' -> {
                    System.out.println("......................");
                    System.out.println("Enter an amount to deposit :");
                    System.out.println("......................");
                    double amt = sc.nextDouble();
                    deposit(amt);
                    System.out.println("\n");
                }
                case 'c' -> {
                    System.out.println("......................");
                    System.out.println("Enter an amount to Withdraw :");
                    System.out.println("......................");
                    double amtW = sc.nextDouble();
                    withdraw(amtW);
                    System.out.println("\n");
                }
                case 'd' -> {
                    System.out.println("......................");
                    System.out.println("Previous Transaction:");
                    getPreviousTrans();
                    System.out.println("......................");
                    System.out.println("\n");
                }
                case 'e' -> System.out.println("......................");
                default -> System.out.println("Choose a correct option to proceed");
            }

        } while (option != 'e');

        System.out.println("Thank you for using our banking application");
    }
}