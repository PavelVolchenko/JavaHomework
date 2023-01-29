package hw02;


import org.json.*;
import javax.imageio.IIOException;
import java.io.*;

public class task02 {
    /*  Дана json строка (прочитать и сохранить в файл).
        [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
        {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
        {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
        Написать метод(ы), который распарсит json и используя StringBuilder,
        создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
        Пример вывода:
        Студент Иванов получил 5 по предмету Математика.
        Студент Петрова получил 4 по предмету Информатика.
        Студент Краснов получил 5 по предмету Физика.                               */
    public static void main(String[] args) throws Exception {
        // Считываем json файл и сохраняем в переменную jsonFile
        BufferedReader br = new BufferedReader(new FileReader("./src/hw02/input.json"));
        StringBuilder jsonFile = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) jsonFile.append(line);
        br.close();
        // Парсим json и записываем в массив строк
        String[] studentsLog = parseJSON(String.valueOf(jsonFile));
        // Печатаем форматированный вывод
        printLog(studentsLog);
        // Подгатавливаем и сохраняем логи в json файл
        saveJSON(studentsLog);
    }
    public static void saveJSON(String[] studentsLog) throws IOException {
        JSONArray jsonData = new JSONArray();
        FileWriter file = new FileWriter("./src/hw02/output.json");
        for (String str : studentsLog) {
            String std = "lastname, score, discipline \n" + str;
            jsonData.putAll(CDL.toJSONArray(std));
        }
        try {
            file.write(jsonData.toString(1));
        } catch (IIOException e) {
            e.printStackTrace();
            System.out.println("Не получилось записать данные в файл!");
        } finally {
            file.flush();
            file.close();
        }
    }
    public static String[] parseJSON(String jsonString) {
        JSONArray jsObj = new JSONArray(jsonString);
        String[] studentLog = new String[jsObj.length()];
        StringBuilder log = new StringBuilder();
        for (int i = 0; i < jsObj.length(); i++) {
            JSONObject jsonLog = jsObj.getJSONObject(i);
            log.append(jsonLog.getString("фамилия")).append(",")
                    .append(jsonLog.getString("оценка")).append(",")
                    .append(jsonLog.getString("предмет"));
            studentLog[i] = log.toString();
            log = new StringBuilder();
        }
        return studentLog;
    }
    public static void printLog(String[] studentLog) {
        for (String log : studentLog) {
            StringBuilder toPrint = new StringBuilder();
            String[] logg = log.split(",");
            toPrint.append("Студент ").append(logg[0])
                    .append(" получил ").append(logg[1])
                    .append(" по предмету ").append(logg[2]).append(".");
            // ИЛИ ЧЕРЕЗ КОНКАТЕНАЦИЮ БЫСТРЕЕ?
//            String toPrint = "Студент " + log[0] +
//                    " получил " + log[1] +
//                    " по предмету " + log[2] + ".";
            System.out.println(toPrint);
        }
    }
}