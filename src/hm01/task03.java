package hm01;

import java.util.Scanner;

public class task03 {

            /*    3. Реализовать простой калькулятор Scanner sc = ...
                     int a = sc.nextLine int b = sc.nextLine       */

    public static void main(String[] args) {

        Scanner iScanner = new Scanner(System.in);
        System.out.print("Enter first number: x = ");
        int x = iScanner.nextInt();
        System.out.print("Enter simple arithmetical operation: ");
        String operation = iScanner.next();
        System.out.print("Enter second number: y = ");
        int y = iScanner.nextInt();

        int result;
        switch (operation) {
            case "+" -> {
                result = x + y;
                System.out.printf("%d %s %d = %d", x, operation, y, result);
            }
            case "-" -> {
                result = x - y;
                System.out.printf("%d %s %d = %d", x, operation, y, result);
            }
            case "*" -> {
                result = x * y;
                System.out.printf("%d %s %d = %d", x, operation, y, result);
            }
            case "/" -> {
                float divide = (float) x / (float) y;
                System.out.printf("%d %s %d = %.2f", x, operation, y, divide);
            }
        }
        iScanner.close();
    }
}
