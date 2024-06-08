import java.util.*;

public class index {
    public static void main(String [] args){
        System.out.println("该项目为工作项目");
        Random r = new Random();
        int i=0;
        while (i<100){
            int t=r.nextInt(100+1);
            if (t==100)
                System.out.println("yes");
            i++;
        }


        ArrayList <String> strs = new ArrayList<>();
    }
}