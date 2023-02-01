package hw04;

import java.util.LinkedList;
import java.util.Scanner;

public class task02 {
    /*  2. Реализуйте очередь с помощью LinkedList со следующими методами:
        enqueue() - помещает элемент в конец очереди,
        dequeue() - возвращает первый элемент из очереди и удаляет его,
        first() - возвращает первый элемент из очереди, не удаляя.       */
    public static void main(String[] args) {
        System.out.println("""
                === ===== ===== ===== МЕНЮ ===== ===== ===== ===
                1. Поместить элемент в конец очереди
                2. Вернуть первый элемент очереди и удалить его
                3. Вернуть первый элемент очереди, не удаляя его
                4. Распечатать очередь
                5. Завершить работу                        \s""");
        Scanner iScanner = new Scanner(System.in);
        int action = 0;
        while (action != 5) {
            System.out.print("Выбирете действие -> ");
            action = iScanner.nextInt();
            switch (action) {
                case 1 -> {
                    System.out.print("Введите элемент: ");
                    String element = iScanner.next();
                    enqueue(element);
                }
                case 2 -> System.out.printf("%s - удален из очереди\n", dequeue());
                case 3 -> System.out.printf("%s - первая в очереди\n", first());
                case 4 -> System.out.println(queue);
                case 5 -> System.out.println("\n===== ===== Всего доброго! ===== =====");
            }
        }
        iScanner.close();
    }
    public static LinkedList<String> queue = new LinkedList<>();
    public static void enqueue(String element) {
        queue.addLast(element);
    }
    public static String dequeue() {
        return queue.pop();
    }
    public static String first() {
        return queue.getFirst();
    }
}
