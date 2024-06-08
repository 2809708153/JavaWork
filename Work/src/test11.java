import java.util.*;
public class test11 {
	public static void main (String[] args) {
		int [] aa={2,3,1,0,2,5,3};
		for (int i=0;i<aa.length;i++){
			boolean flag=false;
			for (int j=0;j<aa.length;j++)
				if (i!=j && aa[i]==aa[j]){
					flag=true;
					break;
				}
			if (flag){
				System.out.println (aa[i]);
				break;
			}	
 		}				
	}
}