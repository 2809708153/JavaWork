import java.util.*;
public class Test7 {
    private String str;
    private  void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a string: ");
        str = scanner.nextLine();
    }
    private void extractStudentID() {
        String studentID = null;
        String[] words = str.split(" ");
        for (String word : words) {
            if (word.length() == 10 && word.matches("\\d+")) {
                studentID = word;
                break;
            } 
        }
        if (studentID != null) {
            System.out.println("Student ID: " + studentID);
        } 
        else {
            System.out.println("No student ID data found.");
        }
    }
    
    public static void main(String[] args) {
        Test7 processor = new Test7();
        processor.input();
        processor.extractStudentID();
    }
}