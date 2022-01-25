/*
--------------HELP--------------
Обрабатываемый файл логов - main.log.2014-11-17 - лежит в contetnt root.
Создаваемый semicol.txt файл с данными, разделенными точкой с запятой, находится так же в src папке
*/

package log_parce_a;

import java.io.*;
//import java.util.regex.Matcher;

public class log_b {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main.log.2014-11-17");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        PrintWriter f = new PrintWriter("src/semicol.txt");
        String line = reader.readLine();
        while(line != null) {
//            System.out.println(line);
//            System.out.println(line);
            f.println(line.replaceAll("\\s+", ";"));
            line = reader.readLine();
        }
    }
}
