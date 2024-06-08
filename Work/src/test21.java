import java.util.*;
import java.io.*;
public class test21 {
	public static void main (String[] args) {
		int [] arr=new int[10];
		int mi=1000,ma=0,sum=0;
		Random r=new Random();
		for (int i=0;i<10;i++){
			int num=r.nextInt(1000-100+2)+100;
			arr[i]=num;
			ma=Math.max(ma,num);
			mi=Math.min(mi,num);
			sum+=num;
		}
		
		try {
			FileWriter fileWriter = new FileWriter("txtfile/test21_result.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			for (int i=0;i<10;i++)
				bufferedWriter.write(arr[i]+" ");
			bufferedWriter.newLine();
			bufferedWriter.write("Max="+ma+"\tMin="+mi+"\tSum="+sum/10);
            bufferedWriter.close();
		}
		catch (Exception ex) {
			System.out.println ("fail!");
		}
		
		/*
		for (int i=0;i<10;i++)
			System.out.print (arr[i]+" ");
		System.out.println ();	
        System.out.println ("Max="+ma+"\tMin="+mi+"\tSum="+sum/10);
        */
    }
}