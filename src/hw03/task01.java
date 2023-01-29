package hw03;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class task01 {
    /*  1) Пусть дан произвольный список целых чисел, удалить из него четные числа  */
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(ThreadLocalRandom.current().nextInt(1, 21));
        }
        System.out.print("Input array: ");
        System.out.println(list);
        System.out.print("Output array: ");
        list.removeIf(integer -> integer % 2 == 0);
        System.out.println(list);
    }
}
