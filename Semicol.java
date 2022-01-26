package log_parse;

import java.io.*;
import java.util.Scanner;

public class Semicol {

    public static void main(String[] args) throws IOException {
        Scanner console = new Scanner(System.in);
        if (console.hasNext("--help")) {
            System.out.println("*****SEMICOLON SEPARATION*****" +"\n"+ "\n"+
                    "Parameter #1: Path to log file" + "\n"+
                    "Parameter #2: Title of created parsed file" +
                    "File would be created in the jar directory");
            System.exit(1);
        }

        String f_path = console.nextLine(); // path to log file
        String semi = console.nextLine(); // name of created parse file
        File file = new File(f_path);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        PrintWriter f = new PrintWriter(semi);
        String line = reader.readLine();
        while(line != null) {
            f.println(line.replaceAll("\\s+", ";"));
            line = reader.readLine();
        }
        System.out.println("Semicol successfully finished");
    }
}
