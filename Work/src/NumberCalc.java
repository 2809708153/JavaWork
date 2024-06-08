import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberCalc {
    public StringBuilder sb = new StringBuilder();   //输出结果
    public static void main(String[] args){
        NumberCalc index = new NumberCalc();
    }
    NumberCalc(){
        JFrame CalcFrame = new JFrame();
        CalcFrame.setTitle("区间计算");
        CalcFrame.setBounds(100, 100, 250, 300);  //设置框架大小
        //int wid = frame.getWidth();
        //int hig = frame.getHeight();
        CalcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CalcFrame.getContentPane().setLayout(new FlowLayout());  //浮动布局
        //指示用户说明
        JLabel instruction1 = new JLabel("请输入整数:");
        JLabel instruction2 = new JLabel("请输入整数:");
        //用户输入框
        JTextField number1Field = new JTextField();
        JTextField number2Field = new JTextField();
        //添加组件
        CalcFrame.getContentPane().add(instruction1);
        CalcFrame.getContentPane().add(number1Field);
        number1Field.setColumns(10);
        CalcFrame.getContentPane().add(instruction2);
        CalcFrame.getContentPane().add(number2Field);
        number2Field.setColumns(10);
        //输出框
        JTextArea resultArea = new JTextArea();
        resultArea.setPreferredSize(new Dimension(200, 150));  //设置固定大小，防止布局自定义
        CalcFrame.getContentPane().add(resultArea);
        resultArea.setEditable(false);  //文本不可编辑
        resultArea.setLineWrap(true);   //文本自动换行
        resultArea.setWrapStyleWord(true); //防止文本换行断词
        //计算与关闭按钮
        JButton calcButton = new JButton("计算");
        calcButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String numstr1 = number1Field.getText().trim();
                String numstr2 = number2Field.getText().trim();
                if (numstr1.isEmpty() || numstr2.isEmpty()) {
                    JOptionPane.showMessageDialog(CalcFrame, "请输入数字！");
                    return;
                }
                String ret = CalcNum(numstr1,numstr2);
                resultArea.setText(ret);
            }
        });
        CalcFrame.getContentPane().add(calcButton);
        //关闭按钮
        JButton closeButton = new JButton("关闭");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CalcFrame.dispose();
            }
        });
        CalcFrame.getContentPane().add(closeButton);
        CalcFrame.setVisible(true);
    }
    public String CalcNum(String numstr1,String numstr2){
        try {
            int num1 = Integer.parseInt(numstr1),num2 = Integer.parseInt(numstr2);
            if (num1 > num2){
                sb.delete(0, sb.length());
                sb.append("第一个数不能比第二个数小！");
                return sb.toString();
            }
            int oddsum = 0, oddcount = 0;
            for (int i = num1 ;i <= num2 ;i++){
                if (i % 2 == 1){
                    oddsum+=i;
                    oddcount++;
                }
            }
            sb.delete(0, sb.length());
            sb.append("从"+num1+"到"+num2+"之前的处理结果如下：\n");
            sb.append("奇数和："+ String.valueOf(oddsum) + "\n");
            sb.append("奇数个数："+ String.valueOf(oddcount) + "\n");
        }
        catch (NumberFormatException e) {
            sb.delete(0, sb.length());
            sb.append("其中一个字符串不能被解析为整数！");
        }
        return sb.toString();
    }
}
