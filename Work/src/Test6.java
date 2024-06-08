import java.util.*;
public class Test6{
	private int a,b,c;
	private void input(){
		Scanner sc=new Scanner(System.in);
		a=sc.nextInt();
		b=sc.nextInt();
		c=sc.nextInt();
	}
	private void judge(){
		if (a+b>c && a+c>b && b+c>a)
			System.out.println ("Yes");
		else
			System.out.println ("No");
	}
	private void area(){
		if (a+b>c && a+c>b && b+c>a){
			double p=(a+b+c)/2;
			double ans=Math.sqrt(p*(p-a)*(p-b)*(p-c));
			System.out.println ("Area is:"+ans);
		}
		else
			System.out.println ("Not a triangle!");
	}
	public static void main (String[] args) {
		Test6 Triangle=new Test6();
		Triangle.input();
		Triangle.judge();
		Triangle.area();
    }
}