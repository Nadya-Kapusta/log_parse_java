/*
--------------HELP--------------
Обрабатываемый файл логов - main.log.2014-11-17 - лежит в contetnt root.
Создаваемый regex.txt файл с резульатми поиска по регулярному выражению, находится ^в src папке
*/


package log_parce_a;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class log_a {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main.log.2014-11-17");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        PrintWriter f = new PrintWriter("regex.txt");
        Scanner console = new Scanner(System.in);
        String reg_ex = console.nextLine();
        Pattern pattern = Pattern.compile(reg_ex);
        String line = reader.readLine();
        while(line != null) {
//            System.out.println(line);
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()){
                f.println(line.substring(matcher.start(), matcher.end()));
            }
            line = reader.readLine();
        }
    }
}
