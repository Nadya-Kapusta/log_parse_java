package log_parse;
import java.io.*;
import java.util.Scanner;

public class To_files {

    public static void main(String args[]) {
        try {

            Scanner console = new Scanner(System.in);
            if (console.hasNext("--help")) {
                System.out.println("*****BREAK TO FILES*****" + "\n"+ "\n"+
                        "Parameter #1: Path to log file" + "\n"+
                        "Parameter #2: Name of the created files" + "\n"+
                        "Files would be created in the jar directory");
                System.exit(1);
            }
            String f_path = console.nextLine(); // path to log file
            String title = console.nextLine(); // path to log file

            FileReader read = new FileReader(f_path);
            BufferedReader br = new BufferedReader(read);
            String row;

            int rownum = 1;
            int fileNo = 1;
            FileWriter fw = new FileWriter(title+fileNo +".txt");

            while ((row = br.readLine()) != null) {
                rownum ++;
                fw.append(row + "\r\n");
                if((rownum / 100000) > (fileNo - 1)){
                    fw.close();
                    fileNo ++ ;
                    fw = new FileWriter(title+fileNo +".txt");
                }
            }
            fw.close();
            System.out.println("Files are created");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
