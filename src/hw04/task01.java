package hw04;

import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class task01 {
    /*  1. Пусть дан LinkedList с несколькими элементами.
        Реализуйте метод(не void), который вернет “перевернутый” список.    */
    public static void main(String[] args) {
        LinkedList<Integer> linkList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkList.add(ThreadLocalRandom.current().nextInt(1, 100));
        }
        System.out.print("   Input array: ");
        System.out.println(linkList);
        System.out.print("Reversed array: ");
        System.out.println(reverseList(linkList));
    }
    public static LinkedList<Integer> reverseList(LinkedList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.add(list.size()-i-1, list.pop());
        }
        return list;
    }
}
