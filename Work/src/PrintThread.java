import java.util.Random;

public class PrintThread extends Thread {
    public void run(){
        Random r = new Random();
        for (int i=0;i<10;i++){
            try{
                System.out.println(r.nextInt(1000-100+1)+100);
                Thread.sleep(1000);
            }
        catch (Exception e){
                System.out.println("Error");
            }
        }
    }
    public static void main(String [] args){
        PrintThread printthread = new PrintThread();
        printthread.start();
    }
}
