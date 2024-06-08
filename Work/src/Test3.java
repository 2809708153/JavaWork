import java.util.*;
public class Test3{
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		String s=sc.nextLine();
		String [] words=new String[100];
		String [] nums=new String[100];
		int count1=0,count2=0,k1=0,k2=0;
		String temp1="",temp2="";
		for (int i=0;i<s.length();i++){
			if (s.charAt(i)>='a' && s.charAt(i)<='z')
				temp1+=s.charAt(i);
			else{
				if (temp1!=""){
					words[k1++]=temp1;
					count1++;
					temp1="";
				}
			}
			if (s.charAt(i)>='0' && s.charAt(i)<='9')
				temp2+=s.charAt(i);
			else{
				if (temp2!=""){
					nums[k2++]=temp2;
					count2++;
					temp2="";
				}
			}
		}
		if (temp1!=""){
			words[k1++]=temp1;
			count1++;
		}
		if (temp2!=""){
			nums[k2++]=temp2;
			count2++;
		}
		System.out.println ("words count="+count1);
		for (int i=0;i<count1;i++)
			System.out.print ((i+1)+":"+words[i]+" ");
		System.out.println ();
		System.out.println ("numbers count="+count2);
		for (int i=0;i<count2;i++)
			System.out.print ((i+1)+":"+nums[i]+" ");
		System.out.println ();


		String str=sc.nextLine();
		int [] arr=new int[1000];
		for (int i=0;i<str.length();i++)
			arr[str.charAt(i)-48]++;
		int r=0;
		for (int i=0;i<str.length();i++)
			if (arr[str.charAt(i)-48]==1)
				System.out.print (str.charAt(i)+" ");
		System.out.println ();


		for (int i=0;i<str.length();i++){
			boolean flag=true;
			for (int j=0;j<str.length();j++)
				if (i!=j && str.charAt(i)==str.charAt(j)){
					flag=false;
					break;
				}
			if (flag){
				System.out.println (str.charAt(i));
			}
		}

		for (int i=0;i<str.length();i++)
			if (str.indexOf(str.charAt(i))==str.lastIndexOf(str.charAt(i)))
				System.out.println (str.charAt(i));

	}
}