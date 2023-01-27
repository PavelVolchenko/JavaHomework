package hw03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;

public class task02 {
    /* 2) Задан целочисленный список ArrayList. Найти минимальное,
        максимальное и среднее ариф. из этого списка            */
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(ThreadLocalRandom.current().nextInt(1, 21));
        }
        System.out.println(list);
        list.sort(Comparator.naturalOrder());
        System.out.print("min -> ");
        System.out.println(list.get(0));
        System.out.print("max -> ");
        System.out.println(list.get(list.size()-1));
        int sumElements = list.stream().mapToInt(integer -> integer).sum();
        System.out.print("average -> ");
        System.out.println((float)sumElements / list.size());
    }
}
