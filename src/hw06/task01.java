package hw06;

import java.util.*;

public class task01 {

    public static void main(String[] args) {
        notebooks.add(new Notebook("Apple", "MacBook Pro", 14.2f, "Liquid Retina XDR", "M1 Pro",
                512, 16, "Алюминий", "Серебристый", 1.61f, 136_990));
        notebooks.add(new Notebook("Apple", "MacBook Pro", 16.2f, "Liquid Retina XDR", "M1 Pro",
                512, 16, "Алюминий", "Серый космос", 2.17f, 158_990));
        notebooks.add(new Notebook("Apple", "MacBook Pro", 14.2f, "Liquid Retina XDR", "M1 Pro",
                1024, 16, "Алюминий", "Серебристый", 1.61f, 157_990));
        notebooks.add(new Notebook("HONOR", "MagicBook", 16.1f, "IPS", "AMD Ryzen 5",
                512, 16, "Алюминий", "Серый космос", 1.84f, 79_990));
        notebooks.add(new Notebook("HONOR", "MagicBook X", 14.2f, "FullView", "Intel Core i3",
                256, 8, "Алюминий", "Серый космос", 1.38f, 54_990));
        notebooks.add(new Notebook("HONOR", "MagicBook View", 14.2f, "FullView", "Intel Core i7",
                512, 16, "Алюминий", "Серый космос", 1.48f, 129_990));
        notebooks.add(new Notebook("HONOR", "MagicBook Pro AMD", 16.1f, "FHD", "AMD Ryzen 5",
                512, 16, "Алюминий", "Серебристый", 1.7f, 74_990));
        notebooks.add(new Notebook("HP", "250 G8", 15.6f, "IPS", "Intel Core i3",
                512, 8, "Пластик", "Серебристый", 1.74f, 87_499));
        notebooks.add(new Notebook("HP", "255 G7", 15.6f, "TN+film", "AMD Ryzen 3",
                256, 4, "Пластик", "Серый", 1.78f, 54_999));
        notebooks.add(new Notebook("HP", "Laptop", 15.6f, "IPS", "AMD Ryzen 3",
                256, 8, "Пластик", "Серый", 1.69f, 37_999));

        System.out.println("=".repeat(70));
        System.out.println("=== Рад приветствовать тебя в нашем подпольном магазине ноутбуков! ===");
        System.out.println("=".repeat(70));
        System.out.println("- Давай подберем тебе отличный ноутбук.");
        showFilteredNotebooks();
    }

    public static void showFilteredNotebooks() {
        HashMap<Integer, String> showFilterParam = new HashMap<>();
        showFilterParam.put(1, "Диагональ экрана (inch)");
        showFilterParam.put(2, "Объем оперативной памяти (Gb)");
        showFilterParam.put(3, "Объем жесткого диска (Gb)");
        showFilterParam.put(4, "Цена (руб.)");
        System.out.println("""        
                - Выбери один или несколько параметров через пробел
                  и я отберу для тебя лучшие модели.""");
        for (var param :
                showFilterParam.entrySet()) {
            System.out.printf("%d - %s\n", param.getKey(), param.getValue());
        }

        Scanner iScanner = new Scanner(System.in);
        iScanner.useDelimiter("\n");

        HashMap<Integer, String> userFilter = new HashMap<>();
        List<String> param = new ArrayList<>(List.of(iScanner.next().split(" ")));
        for (var num : param) {
            userFilter.put(Integer.parseInt(num), null);
        }

        System.out.println("Отлично, с параметрами разобрались." +
                "\nТеперь давай зададим минимальные значения для каждого из параметров.");
        for (var par :
                userFilter.entrySet()) {
            System.out.printf("%s -> ", showFilterParam.get(par.getKey()));
            par.setValue(iScanner.next());
        }

        for (int i = 1; i < 6; i++) {
            if (!userFilter.containsKey(i))
                userFilter.put(i, "0");
        }

        List<String> compilation = new ArrayList<>();
        for (var notebook : notebooks) {
            if (notebook.getDisplaySize() >= Integer.parseInt(userFilter.get(1)) &&
                    notebook.getRamSize() >= Integer.parseInt(userFilter.get(2)) &&
                    notebook.getHddSize() >= Integer.parseInt(userFilter.get(3)) &&
                    notebook.getPrice() >= Integer.parseInt(userFilter.get(4))) {
                compilation.add(notebook.toString());
            }
        }

        if (compilation.size() != 0) {
            System.out.println();
            System.out.printf("У меня есть для тебя %d подходящих!\n", compilation.size());
            for (var notebook: compilation) {
                System.out.printf(" - %s\n", notebook);
            }
        } else {
            System.out.println("====================================================");
            System.out.println("Ты ищешь что-то невероятное. Давай попробуем заново.");
            System.out.println("====================================================");
            showFilteredNotebooks();
        }
    }

    public static Set<Notebook> notebooks = new HashSet<>();
}
