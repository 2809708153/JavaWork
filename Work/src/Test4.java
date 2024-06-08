import java.util.*;
import java.io.*;
public class Test4{
	public static void main (String[] args) {
		Scanner scc = new Scanner(System.in);
		String s=scc.nextLine();
		String [] words=new String[100];
		int count=0,k=0,len=0;
		int [] arr=new int[26];
		String temp="";
		for (int i=0;i<s.length();i++){
			if (s.charAt(i)>='a' && s.charAt(i)<='z'){
				temp+=s.charAt(i);
				arr[s.charAt(i)-97]++;
				len++;
			}	
			else{
				if (temp!=""){
					words[k++]=temp;
					count++;
					temp="";
				}
			}
		}
		if (temp!=""){
			words[k++]=temp;
			count++;
		}
		System.out.println ("words count="+count);
		for (int i=0;i<count;i++)
			System.out.print ((i+1)+":"+words[i]+" ");
		System.out.println ();
		for (int i=0;i<26;i++){
			if (arr[i]>0){
				System.out.printf ("%c:%.2f",(char)(i+97),(double)arr[i]/len*100);
				System.out.print ("% ");
			}
				
		}
		System.out.println ();
		
		try {
    		Scanner sc = new Scanner(new File("txtfile/Test4.txt"));
    		int wordslen=0,n=0;
    		int [] arrw = new int[26];
    		while (sc.hasNextLine()){
    			String str=sc.nextLine().replaceAll("[^a-zA-Z]"," ").toLowerCase();
    			wordslen+=str.trim().split("\\s+").length;
    			for (int i=0;i<str.length();i++)
    				if (str.charAt(i)>='a' && str.charAt(i)<='z'){
    					n++;
    					arrw[str.charAt(i)-97]++;
    				}
    		}
    		System.out.println ("words:"+wordslen);
    		for (int i=0;i<26;i++){
    			System.out.printf ("%c:%.2f",(char)(i+97),(double)arrw[i]/n*100);
    			System.out.println ("%");
    		}
    			
		}
		catch (Exception ex) {
			System.out.println ("fail");
		}
		
		
		System.out.println ();
		int [] months={31,28,31,30,31,30,31,31,30,31,30,31};
		int year,mon;
		year=scc.nextInt();
		mon=scc.nextInt();
		if (year%400==0 || (year%4==0 && year%100!=0))
			months[1]++;
		System.out.println ("days:"+months[mon-1]);
    }
}