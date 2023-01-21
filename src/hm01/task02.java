package hm01;

public class task02 {

    /*      2. Вывести все простые числа от 1 до 1000   */

    public static void main(String[] args) {

        for (int i = 1; i <= 1000 ; i++) {
            int count = 0;
            for (int j = 1; j < i && j < 10; j++) if (i % j == 0) count++;
            if (count < 2) System.out.printf("%d ", i);
        }
    }
}
