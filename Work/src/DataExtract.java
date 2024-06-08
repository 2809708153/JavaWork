import java.util.*;
import java.io.*;
public class DataExtract {
	private static ArrayList <String> StuList = new ArrayList<>();
	public void ReadStuData(){
		try {
            BufferedReader reader = new BufferedReader(new FileReader("txtfile/data.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                StuList.add(parts[1]);
            }
            reader.close();
        } 
        catch (IOException e) {
            e.printStackTrace();
            System.out.println ("fail");
        }
	}
	public void RandomSelectStu(int n){
		int i=0,StuCount;
		ArrayList <String> StuRetList = new ArrayList<>();
		while (i<n){
			StuCount=StuList.size();
			Random r=new Random();
			int index=r.nextInt(StuCount);
			//System.out.println (StuCount);
			//System.out.println (StuList.get(index));
			StuRetList.add(StuList.get(index));
			StuList.remove(index);
			i++;
		}
		try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("txtfile/data_result.txt"));
            String line;
            for (int k=0;k<StuRetList.size();k++){
            	writer.write(StuRetList.get(k));
            	writer.newLine();
            }
            writer.close();
            System.out.println ("SUCC");
        } 
        catch (IOException e) {
            e.printStackTrace();
            System.out.println ("fail");
        }
	}
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		DataExtract StuSel = new DataExtract();
		StuSel.ReadStuData();
		StuSel.RandomSelectStu(n);
    }
}