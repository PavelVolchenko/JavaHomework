package hw02;

import java.util.Scanner;

public class task03 {
    /*  Напишите метод, который принимает на вход строку (String) и определяет
        является ли строка палиндромом (возвращает boolean значение).       */
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Enter string: ");
        System.out.println(checkPalindrome(new StringBuilder(iScanner.nextLine())));
        iScanner.close();
    }
    public static boolean checkPalindrome(StringBuilder string) {
        return string.toString().equals(String.valueOf(string.reverse()));
    }
}
