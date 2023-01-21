package hm01;

import java.util.Scanner;

public class task01 {
    /*      1.1 Вычислить n-ое треугольного число (сумма чисел от 1 до n):
            - тр 5 = 1 + 2 + 3 + 4 + 5

            1.2 Вычислить факториал n! (произведение чисел от 1 до n):
            - 5! = 1*2*3*4*5                                            */
    public static void main(String[] args) {

        Scanner iScanner = new Scanner(System.in);
        System.out.print("Enter number for T: ");
        int Tn = iScanner.nextInt();
        int res = 0;
        System.out.printf("T%d = ", Tn);
        for (int i = 1; i <= Tn; i++) {
            if (i == Tn) System.out.printf("%d", i);
            else System.out.printf("%d + ", i);
            res += i;
        }
        System.out.printf(" = %d", res);

        System.out.print("\nEnter number for !n: ");
        int n = iScanner.nextInt();
        System.out.printf("!%d = ", n);
        res = 1;
        for (int i = 1; i <= n; i++) {
            if (i == Tn) System.out.printf("%d", i);
            else System.out.printf("%d * ", i);
            res *= i;
        }
        System.out.printf(" = %d", res);

    }
}
