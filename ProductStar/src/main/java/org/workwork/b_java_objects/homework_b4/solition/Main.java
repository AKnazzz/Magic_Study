package org.workwork.b_java_objects.homework_b4.solition;

/**
 * Создать в HomeWork_a4_16-классе 2 переменные – имя владельца банковского аккаунта и ненулевую сумму на счету.
 * <p>
 * Написать функцию, которая принимает имя владельца и сумму, которую надо снять.
 * <p>
 * Имплементировать свой класс, наследованный от Exception, который будет бросаться в случае,
 * если денег на счету недостаточно и обрабатываться в вызывающей (main() ) функции.
 * <p>
 * Имплементировать свой класс, наследованный от RuntimeException, который будет бросаться в случае,
 * если имя аккаунта в вызывающей функции не совпадает с именем в переменной.
 * <p>
 * Написать программу, которая создаёт экземпляр класса, снимает небольшую сумму денег (успешно), снимает больше,
 * чем осталось (Exception) и пытается снять с чужого аккаунта (RuntimeException).
 */

public class Main {

    public static String accountName = "MyAcc";
    public static int amount = 10000;

    public static void main(String[] args) throws InsufficientAmountException {
        System.out.println(deduct("MyAcc", 900));
    }

    public static int deduct(String accountToProcess, int amtToCacheOut) throws
            InsufficientAmountException {
        if (!accountName.equals(accountToProcess)) {
            throw new AccessDeniedException("Provided account doesn't match the target one");
        }
        if (amount < amtToCacheOut) {
            throw new InsufficientAmountException("Not enough money to withdraw " + amtToCacheOut);
        }
        amount = amount - amtToCacheOut;
        return amount;
    }

}
