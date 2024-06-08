class Stu{
	private String id,name;
	private int cj1,cj2,cj3;
	public String getId() {
		return id;}
	public void setId(String id) {
		this.id = id;}
	public String getName() {
		return name;}
	public void setName(String name) {
		this.name = name;}
	public int getCj1() {
		return cj1;}
	public void setCj1(int cj1) {
		this.cj1 = cj1;}
	public int getCj2() {
		return cj2;}
	public void setCj2(int cj2) {
		this.cj2 = cj2;}
	public int getCj3() {
		return cj3;}
	public void setCj3(int cj3) {
		this.cj3 = cj3;}

	Stu(String stuid, String stuname, int a, int b, int c){
		id=stuid;
		name=stuname;
		cj1=a;
		cj2=b;
		cj3=c;
	}
	private int sum(){

		return cj1+cj2+cj3;
	}
	private int average(){

		return sum()/3;
	}
	public void display(){
		//System.out.println ("id\tname\tcj1\tcj2\tcj3\tsum\taverage");
		//System.out.println (id+"\t"+name+"\t"+cj1+"\t"+cj2+"\t"+cj3+"\t"+this.sum()+"\t"+this.average());
		
		System.out.println ("------------------");
		System.out.println ("id = "+id);
		System.out.println ("name = "+name);
		System.out.println ("cj1 = "+cj1);
		System.out.println ("cj2 = "+cj2);
		System.out.println ("cj3 = "+cj3);
		System.out.println ("sum = "+sum());
		System.out.println ("average = "+average());
		
	}
}

public class Test8 {  
    public static void main(String[] args) {  
        Stu[] students = new Stu[5];  
        students[0] = new Stu("001", "zs", 85, 90, 88);  
        students[1] = new Stu("002", "ls", 78, 82, 91);  
        students[2] = new Stu("003", "ww", 92, 88, 90);  
        students[3] = new Stu("004", "zl", 88, 91, 85);  
        students[4] = new Stu("005", "sq", 70, 75, 77);  
        for (Stu student : students) {  
            student.display();  
        }  
    }  
}