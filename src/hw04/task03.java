package hw04;

import java.util.Scanner;
import java.util.Stack;

public class task03 {
    /*  В калькулятор добавьте возможность отменить последнюю операцию.
        Пример
        1
        +
        2
        ответ:
        3
        +
        4
        ответ:
        7
        Отмена
        3
        *
        3
        ответ:
        9                                                              */
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        Stack<Float> result = new Stack<>();
        System.out.println("""
                ===== ====== ====== КАЛЬКУЛЯТОР ====== ====== =====
                Команды вводятся поочередно, каждая в новой строке.
                "c" - отмена последней операции.
                "q" - завершение работы.
                """);
        while (true) {
            if (iScanner.hasNextFloat()) {
                result.add(iScanner.nextFloat());
            } else {
                    String action = iScanner.next();
                    if (action.equalsIgnoreCase("q")) {
                        break;
                    }
                    if (action.equalsIgnoreCase("c")) {
                        result.remove(0);
                        System.out.println("Отмена");
                        System.out.println(result.firstElement());
                    }
                    if (iScanner.hasNextFloat()) {
                        result.add(iScanner.nextFloat());
                        float x = result.firstElement();
                        float y = result.pop();
                        switch (action) {
                            case "+" -> {
                                result.add(0, x + y);
//                                System.out.printf("%.2f %s %.2f = %.2f\n", x, action, y, result.firstElement());
                                System.out.printf("Ответ\n%.2f\n", result.firstElement());
                            }
                            case "-" -> {
                                result.add(0, x - y);
//                                System.out.printf("%.2f %s %.2f = %.2f\n", x, action, y, result.firstElement());
                                System.out.printf("Ответ\n%.2f\n", result.firstElement());
                            }
                            case "*" -> {
                                result.add(0, x * y);
//                                System.out.printf("%.2f %s %.2f = %.2f\n", x, action, y, result.firstElement());
                                System.out.printf("Ответ\n%.2f\n", result.firstElement());
                            }
                            case "/" -> {
                                result.add(0, x / y);
//                                System.out.printf("%.2f %s %.2f = %.2f\n", x, action, y, result.firstElement());
                                System.out.printf("Ответ\n%.2f\n", result.firstElement());
                            }
                        }
                    }
                }
            }
        iScanner.close();
        }
    }