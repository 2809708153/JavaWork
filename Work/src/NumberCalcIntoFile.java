import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class NumberCalcIntoFile {
    private JFrame frame;
    private JTextField numberField;
    private JTextArea resultArea;
    private JButton calcButton,saveButton,closeButton;
    StringBuilder sb = new StringBuilder();   //输出结果

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    NumberCalcIntoFile window = new NumberCalcIntoFile();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public NumberCalcIntoFile() {
        initialize();
    }

    private void initialize() {
        //框架
        frame = new JFrame();
        frame.setTitle("数字计算");
        frame.setBounds(100, 100, 350, 225);  //设置框架大小
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout());  //浮动布局
        //指示用户说明
        JLabel instruction = new JLabel("请输入正整数:");
        frame.getContentPane().add(instruction);
        //用户输入框
        numberField = new JTextField();
        frame.getContentPane().add(numberField);
        numberField.setColumns(10);
        //输出框
        resultArea = new JTextArea();
        //int wid = frame.getWidth();
        //int hig = frame.getHeight();
        resultArea.setPreferredSize(new Dimension(300, 120));  //设置固定大小，防止布局自定义
        frame.getContentPane().add(resultArea);
        resultArea.setEditable(false);  //文本不可编辑
        resultArea.setLineWrap(true);   //文本自动换行
        resultArea.setWrapStyleWord(true); //防止文本换行断词
        //计算按钮
        calcButton = new JButton("计算");
        calcButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String numstr = numberField.getText().trim();
                if (numstr.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "请输入数字！");
                    return;
                }
                String ret = CalcNum(numstr);
                resultArea.setText(ret);
            }
        });
        frame.getContentPane().add(calcButton);
        //保存按钮
        saveButton = new JButton("保存");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ret = sb.toString();
                if (ret.isEmpty()){
                    JOptionPane.showMessageDialog(frame, "请输入数字并计算！");
                    return;
                }
                //定义文件路径和名称
                String filePath = "txtfile/js.dat";
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                    // 将字符串写入文件
                    writer.write(ret);
                    writer.flush();
                    JOptionPane.showMessageDialog(frame, "保存成功！");
                    return;
                } catch (IOException error) {
                    JOptionPane.showMessageDialog(frame, "保存失败！");
                    return;
                }
            }
        });
        frame.getContentPane().add(saveButton);
        //关闭按钮
        closeButton = new JButton("关闭");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        frame.getContentPane().add(closeButton);
    }

    private String CalcNum(String numstr) {
        try {
            int num = Integer.parseInt(numstr);
            if (num <= 0){
                sb.delete(0, sb.length());
                sb.append("请输入正整数！");
                return sb.toString();
            }
            int count1=0,count2=0;
            long sum1=0,sum2=0;
            for (int i = 1;i < num;i++){
               if (i%2==0){
                   sum1+= i * i;
                   count1++;
               }
               else{
                   sum2+= i * i;
                   count2++;
               }
            }
            sb.delete(0, sb.length());
            sb.append("从1到"+num+"之前的处理结果如下：\n");
            sb.append("奇数平方和："+ String.valueOf(sum1) + "\n");
            sb.append("奇数个数："+ String.valueOf(count1) + "\n");
            sb.append("偶数平方和："+ String.valueOf(sum2) + "\n");
            sb.append("偶数个数："+ String.valueOf(count2));
        }
        catch (NumberFormatException e) {
            sb.delete(0, sb.length());
            sb.append("\"" + numstr + "\"" + "字符串不能被解析为整数！");
        }
        return sb.toString();
    }
}