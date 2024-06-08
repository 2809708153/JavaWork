import java.util.*;
public class Test2{
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
		for (int i=0;i<10;i++)
			System.out.print (arr[i]+" ");
		System.out.println ();	
        System.out.println ("Max="+ma+"\tMin="+mi+"\tSum="+sum/10);
        
        
        char [] aa={'g','o','o','g','t','e','f','h','i','t'};
        int [] count=new int[26];
        for (int i=0;i<aa.length;i++)
        	count[aa[i]-97]++;
        for (int i=0;i<aa.length;i++)
        	if (count[aa[i]-97]==1)
        		System.out.print (aa[i]+" ");
        System.out.println ();		
        
        //char [] aa={'g','o','o','g','t','e','f','h','i','t'};
		for (int i=0;i<aa.length;i++){
			boolean flag=true;
			for (int j=0;j<aa.length;j++)
				if (i!=j && aa[i]==aa[j]){
					flag=false;
					break;
				}
			if (flag){
				System.out.println (aa[i]);
				break;
			}	
 		}
    }
}