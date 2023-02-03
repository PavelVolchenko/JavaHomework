package hw05;

import java.util.*;

public class task02 {
    /*  Пусть дан список сотрудников:
        Иван Иванов
        Светлана Петрова
        Кристина Белова
        Анна Мусина
        Анна Крутова
        Иван Юрин
        Петр Лыков
        Павел Чернов
        Петр Чернышов
        Мария Федорова
        Марина Светлова
        Мария Савина
        Мария Рыкова
        Марина Лугова
        Анна Владимирова
        Иван Мечников
        Петр Петин
        Иван Ежов
        Написать программу, которая найдет и выведет повторяющиеся имена
        с количеством повторений. Отсортировать по убыванию популярности Имени.     */
    public static void main(String[] args) {
        List<String> employees = new ArrayList<>();
        String data = """
                Иван Иванов
                Светлана Петрова
                Кристина Белова
                Анна Мусина
                Анна Крутова
                Иван Юрин
                Петр Лыков
                Иван Иванов
                Павел Чернов
                Петр Чернышов
                Мария Федорова
                Марина Светлова
                Мария Савина
                Иван Иванов
                Анна Мусина
                Мария Рыкова
                Марина Лугова
                Анна Владимирова
                Иван Мечников
                Анна Мусина
                Петр Петин
                Иван Ежов""";
//        Collections.addAll(employees, data.split("\n"));
//        TreeMap<String, Integer> count = new TreeMap<>();
//        for (String employee : employees) {
//            if (!count.containsKey(employee.split(" ")[0])) {
//                count.put(employee.split(" ")[0], 1);
//            } else {
//                count.put(employee.split(" ")[0], count.get(employee.split(" ")[0]) + 1);
//            }
//        }
//        System.out.println(count.entrySet());
        Collections.addAll(employees, data.split("\n"));
        TreeMap<Integer, List> count = new TreeMap<>();
        List<String> name = new ArrayList<>();
        count.put(1, name);
        for (String worker: employees) {
            if (!name.contains(worker.split(" ")[0])) {
                name.add(worker.split(" ")[0]);
            } else {
                name = new ArrayList<>();
                name.add(worker.split(" ")[0]);
                count.put(count.lastKey()+1, name);
            }
        System.out.println(count);
        }

    }
}

