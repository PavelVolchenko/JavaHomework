package hw02;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class task04 {
    /*  *Дополнительно. К калькулятору из предыдущего ДЗ добавить логирование.  */
    public static void main(String[] args) throws IOException {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Enter first number: x = ");
        int x = iScanner.nextInt();
        System.out.print("Enter simple arithmetical operation: ");
        String operation = iScanner.next();
        System.out.print("Enter second number: y = ");
        int y = iScanner.nextInt();
        iScanner.close();

        int result;
        switch (operation) {
            case "+" -> {
                result = x + y;
                System.out.printf("%d %s %d = %d", x, operation, y, result);
                log(x, operation, y, result);
            }
            case "-" -> {
                result = x - y;
                System.out.printf("%d %s %d = %d", x, operation, y, result);
                log(x, operation, y, result);
            }
            case "*" -> {
                result = x * y;
                System.out.printf("%d %s %d = %d", x, operation, y, result);
                log(x, operation, y, result);
            }
            case "/" -> {
                float divide = (float) x / (float) y;
                System.out.printf("%d %s %d = %.2f", x, operation, y, divide);
                log(x, operation, y, divide);
            }
        }
    }
    public static void log(int a, String b, int c, float d) throws IOException {
        Logger logger = Logger.getLogger(task04.class.getName());
        FileHandler fh = new FileHandler("./src/hw02/logCalc.txt", true);
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
        logger.info(a + " " + b + " " + c + " = " + d + "\n");
        fh.close();
    }
}
