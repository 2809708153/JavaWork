import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TestSet {
    public StringBuilder sb = new StringBuilder();   //输出结果
    public static void main(String[] args){
        TestSet index = new TestSet();
}
    TestSet(){
        JFrame TestSetFrame = new JFrame();
        TestSetFrame.setTitle("区间计算");
        TestSetFrame.setBounds(100, 100, 300, 300);  //设置框架大小
        TestSetFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TestSetFrame.getContentPane().setLayout(new FlowLayout());     //浮动布局
        //输出框
        JTextArea resultArea = new JTextArea();
        resultArea.setPreferredSize(new Dimension(260, 220));  //设置固定大小，防止布局自定义
        TestSetFrame.getContentPane().add(resultArea);
        resultArea.setEditable(false);  //文本不可编辑
        resultArea.setLineWrap(true);   //文本自动换行
        resultArea.setWrapStyleWord(true); //防止文本换行断词
        //显示与关闭按钮
        //显示按钮
        JButton displayButton = new JButton("显示");
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ans = Dsp();
                resultArea.setText(ans);
            }
        });
        //关闭按钮
        JButton closeButton = new JButton("关闭");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TestSetFrame.dispose();
            }
        });
        TestSetFrame.add(displayButton);
        TestSetFrame.add(closeButton);
        TestSetFrame.add(resultArea);
        TestSetFrame.setVisible(true);
    }
    public String Dsp(){
        sb.delete(0,sb.length()); //重置
        try {
            Scanner sc = new Scanner(new File("txtfile/TestSetData.txt"));
            ArrayList <String> strs = new ArrayList<>();
            while (sc.hasNextLine()){
                String str=sc.nextLine();
                strs.add(str);
            }
            Random r = new Random();
            for (int i=0;i<10;i++){
                int len = strs.size(), ran = r.nextInt(len);
                sb.append(strs.get(ran) + "\n");
                strs.remove(ran);
            }
            return sb.toString();
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "文件不存在！");
            return "";
        }
    }
}
