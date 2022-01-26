package log_parse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.*;


public class Regexp {

    public static void main(String[] args) throws IOException {
        Scanner console = new Scanner(System.in);

        if (console.hasNext("--help")) {
            System.out.println("*****REGEXP SEARCH*****" +"\n" + "\n"+
                    "Parameter #1: Path to log file" + "\n"+
                    "Parameter #2: Title of created parsed file" +"\n"+
                    "Parameter #3: Regular Expression" + "\n"+
                    "File would be created in the jar directory");
            System.exit(1);
        }

        String f_path = console.nextLine(); // path to log file
        String reg_file = console.nextLine(); // name of created parse file
        String reg_ex = console.nextLine(); // regexp string


        File file = new File(f_path.toString());
        BufferedReader reader = new BufferedReader(new FileReader(file));
        PrintWriter f = new PrintWriter(reg_file);
        Pattern pattern = Pattern.compile(reg_ex);
        String line = reader.readLine();
        while (line != null) {
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()){
                f.println(line.substring(matcher.start(), matcher.end()));
            }
            try {
                line = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Regexp success");
    }
}
