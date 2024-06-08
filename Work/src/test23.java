import java.util.*;
import java.io.*;
public class test23 {
	public static void main (String[] args) {
		String str="34dkyekoyw";
		Map<Character, Integer> mp = new HashMap<Character, Integer>();
		for (int i=0;i<str.length();i++)
			mp.put(str.charAt(i), mp.getOrDefault(str.charAt(i), 0) + 1);
		for (int i=str.length()-1;i>=0;i--)
			if (mp.get(str.charAt(i))==2){
				
				try {
					FileWriter fileWriter = new FileWriter("txtfile/test23_new.txt");
            		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            		char ch = str.charAt(i);
            		bufferedWriter.write(ch);
            		bufferedWriter.newLine();
            		bufferedWriter.flush();
				}
				catch (Exception ex) {
					System.out.println ("Fail!");
					ex.printStackTrace();
				}
				System.out.println (str.charAt(i));
				break;
			}
    }
}