import java.util.*;
import java.io.*;
public class test22 {
	public static void main (String[] args) {
		String str="123545rtyuiewwer21q3q2r2qrqrq23aewqt3qr35y2yhw";
        Set<Character> occ = new HashSet<Character>();
        int n = str.length();
        int rk = -1, ans = 0;
        String ret="";
        for (int i = 0; i < n; i++) {
            if (i != 0) 
                occ.remove(str.charAt(i - 1));
            while (rk + 1 < n && !occ.contains(str.charAt(rk + 1))) {
                occ.add(str.charAt(rk + 1));
                rk++;
            }
            if (rk - i + 1 > ans){
            	ans = rk - i + 1;
            	ret = str.substring(i,rk + 1);
            }
        }
        try {
			FileWriter fileWriter = new FileWriter("txtfile/test22_result.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(String.valueOf(ans));
			bufferedWriter.newLine();
			bufferedWriter.write(ret);
            bufferedWriter.close();
		}
		catch (Exception ex) {
			System.out.println ("fail!");
		}
        /*
        System.out.println (ans);
        System.out.println (ret);
        */
    }
}
