package hw05;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class task01 {
    /*  Реализуйте структуру телефонной книги с помощью HashMap,
        учитывая, что 1 человек может иметь несколько телефонов.    */
    public static void main(String[] args) {
        System.out.println("""
                ===== ===== ТЕЛЕФОННАЯ КНИГА ===== =====
                1. Создать новую запись
                2. Добавить телефон к существующей записи
                3. Вывести на экран все записи
                4. Завершить работу""");
        db.put("Иван Иванов", List.of("+7(909)909-93-12", "+7(928)912-94-52"));
        db.put("Петя Петров", List.of("+7(999)909-33-22", "+7(906)111-22-52", "+7(159)909-33-55"));
        db.put("Зоя Витальевна", List.of("+7(159)909-33-55", "+7(936)441-22-52",
                "+7(159)909-33-55", "+7(936)441-22-52"));

        while (true) {
            System.out.print("Действие -> ");
            int action = iScanner.nextInt();
            switch (action) {
                case 1 -> createRecord();
                case 2 -> addTelephone();
                case 3 -> printTelephoneBook();
            }
            if (action == 4) {
                System.out.println("===== ====== ВСЕГО ДОБРОГО ====== =====");
                break;
            }
        }
    }

    public static Scanner iScanner = new Scanner(System.in);
    public static HashMap<String, List> db = new HashMap<>();

    public static void createRecord() {
        iScanner.useDelimiter("\n");
        System.out.print("Имя, фамилия: ");
        String name = iScanner.next();
        System.out.print("Номера телефонов через пробел: ");
        db.put(name, List.of(iScanner.next().split(" ")));
    }

    public static void addTelephone() {
        String a = db.get("Петя Петров").toString().replace("[","").replace("]","");
        a += "+7(900)111-22-33";
        System.out.println(db.put("Петя Петров", List.of(a.split(", "))));

    }

    public static void printTelephoneBook() {
        int maxLenght = 0;
        for (var item : db.keySet()) {
            if (item.length() > maxLenght) {
                maxLenght = item.length() + 2;
            }
        }
        for (var item : db.entrySet()) {
            System.out.println("-".repeat(maxLenght + 16));
            System.out.printf("%s" + " ".repeat(maxLenght - item.getKey().length()), item.getKey());
            System.out.println(item.getValue().get(0));
            for (int i = 1; i < item.getValue().size(); i++) {
                System.out.println(" ".repeat(maxLenght) + item.getValue().get(i));
            }
        }
        System.out.println("-".repeat(maxLenght + 16));
    }
}

