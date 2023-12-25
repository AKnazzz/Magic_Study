package org.workwork.first_path_java_base.homework_4;

import java.util.Scanner;

public class HomwWork4 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter number!");
        int anyNumber = input.nextInt();

        for(int i = 0; i <= anyNumber; i++){
            if(i % 3 == 0 && i % 5 == 0 && i > 0) {
                System.out.print("fizzbuzz ");
            }else if(i % 3 == 0  && i > 0) {
                System.out.print("fizz ");
            }else if(i % 5 == 0 && i > 0) {
                System.out.print("buzz ");
            }else{
                System.out.print(i + " ");
            }
        }
    }
}
