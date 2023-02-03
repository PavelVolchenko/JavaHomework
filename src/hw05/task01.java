package hw05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.HashMap;

public class task01 {
    /*  Реализуйте структуру телефонной книги с помощью HashMap,
        учитывая, что 1 человек может иметь несколько телефонов.    */
    public static void main(String[] args) {
        System.out.println(showMenu);

        db.put("Иван Иванов", List.of("+7(909)909-93-12", "+7(928)912-94-52"));
        db.put("Петя Петров", List.of("+7(999)909-33-22", "+7(906)111-22-52", "+7(159)909-33-55"));
        db.put("Зоя Витальевна", List.of("+7(159)909-33-55", "+7(936)441-22-52",
                "+7(159)909-33-55", "+7(936)441-22-52"));

        List<String> ph = new ArrayList<>();
        ph.add("+7(909)909-93-12");
        ph.add("+7(222)111-44-12");
        ph.add("+7(333)111-44-12");
        db.put("Денис Иванов", ph);

        iScanner.useDelimiter("\n");
        while (true) {
            System.out.print("Действие -> ");
            int action = iScanner.nextInt();
            switch (action) {
                case 1 -> createRecord();
                case 2 -> addTelephone();
                case 3 -> printTelephoneBook();
            }
            if (action == 4) {
                System.out.println("======== ВСЕГО ДОБРОГО ========");
                break;
            }
        }
    }

    public static String showMenu = """
            \n======= ТЕЛЕФОННАЯ КНИГА =======
            1. Создать новую запись
            2. Добавить телефон к записи
            3. Вывести на экран все записи
            4. Завершить работу""";
    public static Scanner iScanner = new Scanner(System.in);
    public static HashMap<String, List> db = new HashMap<>();

    public static void createRecord() {
        System.out.print("Имя, фамилия: ");
        String name = iScanner.next();
        System.out.print("Введите номера телефонов через пробел: ");
        db.put(name, List.of(iScanner.next().split(" ")));
    }

    public static void addTelephone() {
        TreeMap<Integer, String> abonent = new TreeMap<>();
        int index = 1;
        System.out.println("\n======= СПИСОК АБОНЕНТОВ =======");
        for (var item : db.entrySet()) {
            abonent.put(index, item.getKey());
            System.out.println(index + ". " + item.getKey());
            index++;
        }
        System.out.print("Порядковый номер абонента -> ");
        int id = Integer.parseInt(iScanner.next());
        List<String> phones = new ArrayList<String>(db.get(abonent.get(id)));
        System.out.print("Введите номера телефонов через пробел: ");
        phones.addAll(List.of(iScanner.next().split(" ")));
        db.put(abonent.get(id), phones);
    }

    public static void printTelephoneBook() {
        System.out.println(showMenu);
        System.out.println("\n======= СПИСОК АБОНЕНТОВ =======");
        int maxLenght = 0;
        for (var item : db.keySet()) {
            if (item.length() > maxLenght) {
                maxLenght = item.length();
                maxLenght++;
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

