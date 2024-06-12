package org.hogwarts.a6_oop.object_class.bank_account;

public class BankAccount {
    int id = 10;
    String name = "Petr";
    double balance = 100;

    void popolnenieScheta(double summaPopolneniya) {
        System.out.println("Balans do popolneniya: " + balance);
        System.out.println("Balans popolnayetsa na: " + summaPopolneniya);
        balance += summaPopolneniya;
        System.out.println("Balans pospe popolneniya: " + balance);
        System.out.println();
    }

    void snyatieSoScheta(double summaSnyatiya) {
        System.out.println("Balans do snyatiya: " + balance);
        System.out.println("Balans umenshaetsa na: " + summaSnyatiya);
        balance -= summaSnyatiya;
        System.out.println("Balans pospe snyatia: " + balance);
        System.out.println();
    }
}

class BankAccountTest {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();

        bankAccount.popolnenieScheta(1000);
        bankAccount.snyatieSoScheta(555.67);
    }


}