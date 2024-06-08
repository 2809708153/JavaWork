import java.util.*;
public class test14 {
	public static void main (String[] args) {
		int	[] Arr = {18,32,41,52,0,0,6,61,0,5,4,72,86,79,0,565,0};
		int [] num = new int[Arr.length];
		int k=0;
		for (int i=0;i<Arr.length;i++)
			if (Arr[i]!=0)
				num[k++]=Arr[i];
		for (int i=0;i<k-1;i++)
			for (int j=i+1;j<k;j++)
				if (num[i]>num[j]){
					int temp=num[i];
					num[i]=num[j];
					num[j]=temp;
				}
		for (int i=0;i<k;i++)
			System.out.print (num[i]+" ");
    }
}