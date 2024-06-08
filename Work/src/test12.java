import java.util.*;
public class test12 {
    public static int countOnes(int n) {
        int count = 0;
        //- >>> + >>
        while (n != 0) {
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ones = countOnes(n);
        System.out.println("Number of ones in binary representation of " + n + " is: " + ones);
    }
}