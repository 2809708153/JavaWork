import java.io.*;

public class Test5 {
    public static void main(String[] args) {
        String fileName = "txtfile/Test5.txt";
        String line;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            FileWriter fileWriter = new FileWriter("txtfile/Test5_new.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            while ((line = bufferedReader.readLine()) != null) {
                String updatedLine = removeExtraSpaces(line);
                bufferedWriter.write(updatedLine);
                bufferedWriter.newLine();
            }

            bufferedReader.close();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String removeExtraSpaces(String line) {
        String[] words = line.trim().split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                String capitalizedWord = word.substring(0, 1).toUpperCase() + word.substring(1);
                result.append(capitalizedWord).append(" ");
            }
        }

        return result.toString().trim();
    }
}