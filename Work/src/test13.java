import java.util.*;
public class test13 {
	public static void main (String[] args) {
		int [] aa={5,2,4,3,3,2,5};	
		int ret=0;
		for (int i=0;i<aa.length;i++)
			ret^=aa[i];
		System.out.println (ret);		
	}
}