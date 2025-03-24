import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DoubleQuotesToSingle {
    public static void main(String[] args) {
        try {
            Scanner transcriptOriginal = new Scanner(new File("C:\\Users\\SCRoth\\AppData\\Roaming\\JetBrains\\IntelliJIdea2024.1\\scratches\\input.txt"));

            FileWriter transcriptNew = new FileWriter("C:\\Users\\SCRoth\\AppData\\Roaming\\JetBrains\\IntelliJIdea2024.1\\scratches\\output.txt");
            String line;

            char[] lineChars;
            int limit;
            StringBuilder newLine;
            while (transcriptOriginal.hasNextLine()) {
                line = transcriptOriginal.nextLine();
                if (!line.equals("\"")) {
                    newLine = new StringBuilder();
                    lineChars = line.toCharArray();
                    limit = line.length() - 1;
                    for (int i = 0; i < limit; ++i) {
                        newLine.append(lineChars[i]);
                        if (lineChars[i] == lineChars[i + 1] && lineChars[i] == '"')
                            ++i;
                    }
                    if (limit > -1 && lineChars[limit] != '"')
                        newLine.append(lineChars[limit]);
                    newLine.append('\n');
                    transcriptNew.write(newLine.toString());
                }
            }

            transcriptOriginal.close();
            transcriptNew.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("An error has occurred");
            e.printStackTrace();
        }
    }
}