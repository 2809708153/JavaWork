import javax.swing.*;
import java.io.File;
import java.util.Scanner;
public class test extends JFrame {
    JTextArea jta=new JTextArea(10,40);
    JTextField jtf=new JTextField(10);
    public test()
    {
        JPanel p=new JPanel();
        JLabel l1=new JLabel("请输入作者编号：");
        JButton btn1=new JButton("查询");
        JButton btn2=new JButton("关闭");
        btn1.addActionListener(e->search());
        btn2.addActionListener(e->System.exit(0));
        //JScrollPane jsp=new JScrollPane(jta);
        jta.setEditable(false);
        p.add(l1);
        p.add(jtf);
        p.add(btn1);
        p.add(btn2);
        p.add(jta);
        add(p);
        setLocationRelativeTo(null);
        setSize(600,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public void search()
    {
        String ss=jtf.getText();
        try{
            Scanner sc=new Scanner(new File("data.txt"));
            boolean find=false;
            while(sc.hasNextLine())
            {
                String aa=sc.nextLine().trim();
                String[] bb=aa.split("\\s+");
                if(ss.equals(bb[0]))
                {
                    find=true;
                    String disp="作者编号"+bb[0]+"\n书名"+bb[1]+"\n价格"+bb[2]+"\n数量"+bb[3];
                    jta.setText(disp);
                    break;
                }
            }
            if(find==false)
            {
                JOptionPane.showMessageDialog(null,"查无此人");
            }
        }
        catch(Exception ex)
        {
            System.out.println("error");
            System.out.println(ex);
        }
    }
    public static void main(String[] args)
    {
        new test();
    }
}
