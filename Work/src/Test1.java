import java.util.Scanner;
public class Test1 { 
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int i=0;
        while (i<4){
            int n = sc.nextInt();
            System.out.println (n);
            System.out.print ((byte)n);
            System.out.print ("\t");
            System.out.print ((short)n);
            System.out.print ("\t");
            System.out.print ((int)n);
            System.out.print ("\t");
            System.out.print ((long)n);
            System.out.print ("\t");
            System.out.print ((char)n);
            System.out.println();
            i++;
        }
        for (int k=1;k<10;k++){
            System.out.print (k);
            System.out.print ((char)k);
            System.out.print (" ");
        }
        System.out.println ();
        for (int j=0x4e00;j<=0x4eee;j++){
            System.out.print (j);
            System.out.print ((char)j);
            System.out.print (" ");
        }
    }
}