import java.io.*;

public class abcIO {
	private static int LineCount=0,WordCount=0,n=0;
	private static int [] WordArr = new int[26];
	public void ReadData(){
		try {
            BufferedReader reader = new BufferedReader(new FileReader("txtfile/abc.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String temp="";
                for (int i=0;i<line.length();i++){
                	if (Character.isAlphabetic(line.charAt(i))){
                		char ch=Character.toLowerCase(line.charAt(i));
                		temp+=ch;
                		WordArr[ch-97]++;
                		n++;
                	}
                	else{
                		if (temp!=""){
                			WordCount++;
                			temp="";
                		}
                	}
                }
                if (temp!=""){
                	WordCount++;
                	temp="";
                }
                LineCount++;
            }
            reader.close();
        } 
        catch (IOException e) {
            e.printStackTrace();
            System.out.println ("fail");
        }
	}
	public void WriteData(){
		try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("txtfile/abc_result.txt"));
            writer.write("WordCount:"+WordCount);
            writer.newLine();
            writer.write("LineCount:"+LineCount);
            writer.newLine();
            for (int i=0;i<26;i++){
            	char ch = (char)(i+97);
            	writer.write(ch+":"+(double)WordArr[i]/n*100+"%");
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
		abcIO index = new abcIO();
		index.ReadData();
		index.WriteData();
    }
}