package hm01;

import java.util.Scanner;

public class task04 {

    /*  4. *Дополнительно. Задано уравнение вида x + y = z. Где, (x, y, z) >= 0.
            Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69.
            Требуется восстановить выражение до верного равенства.
            Предложить хотя бы одно решение или сообщить, что его нет.
            Вывод: 24 + 45 = 69                                                      */

    public static void main(String[] args) {

        Scanner iScanner = new Scanner(System.in);
        System.out.print("Enter equation like '2? + ?5 = 69': ");
        String equation = iScanner.nextLine();
        String message = "Решения нет!";
        for (int i = 0; i < 10; i++) {
            String result = equation.replace("?", Integer.toString(i));
            String[] arr = result.split(" ");
            switch (arr[1]) {
                case "+" -> {
                    if (Integer.parseInt(arr[0]) + Integer.parseInt(arr[2]) == Integer.parseInt(arr[4]))
                        message = result;
                }
                case "-" -> {
                    if (Integer.parseInt(arr[0]) - Integer.parseInt(arr[2]) == Integer.parseInt(arr[4]))
                        message = result;
                }
                case "*" -> {
                    if (Integer.parseInt(arr[0]) * Integer.parseInt(arr[2]) == Integer.parseInt(arr[4]))
                        message = result;
                }
                case "/" -> {
                    if (Double.parseDouble(arr[0]) / Double.parseDouble(arr[2]) == Double.parseDouble(arr[4]))
                        message = result;
                }
            }
        }
        System.out.println(message);
    }
}
