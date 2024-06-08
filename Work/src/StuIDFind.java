import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class StuIDFind {
    private JFrame StuIDframe;
    private JTextField nameField;
    private JTextArea resultArea;
    private JButton searchButton;
    private JButton closeButton;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StuIDFind window = new StuIDFind();
                    window.StuIDframe.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public StuIDFind() {
        initialize();
    }

    private void initialize() {
        //框架
        StuIDframe = new JFrame();
        StuIDframe.setBounds(100, 100, 450, 225);  //设置框架大小
        StuIDframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        StuIDframe.getContentPane().setLayout(new FlowLayout());  //浮动布局
        //指示用户说明
        JLabel instruction = new JLabel("请输入查询ID:");
        instruction.setFont(new Font("宋体",Font.BOLD,15));
        StuIDframe.getContentPane().add(instruction);
        //用户输入框
        nameField = new JTextField();
        StuIDframe.getContentPane().add(nameField);
        nameField.setColumns(15);
        //查询按钮
        searchButton = new JButton("查询");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(StuIDframe, "请输入查询ID！");
                    return;
                }
                String result = searchStudent(name);
                resultArea.setText(result);
            }
        });
        StuIDframe.getContentPane().add(searchButton);
        //关闭按钮
        closeButton = new JButton("关闭");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StuIDframe.dispose();
            }
        });
        StuIDframe.getContentPane().add(closeButton);
        //输出框
        resultArea = new JTextArea();
        resultArea.setPreferredSize(new Dimension(350, 135));  //设置固定大小，防止布局自定义
        StuIDframe.getContentPane().add(resultArea);
        resultArea.setEditable(false);  //文本不可编辑
        resultArea.setLineWrap(true);   //文本自动换行
        resultArea.setWrapStyleWord(true); //防止文本换行断词
    }

    private String searchStudent(String StuID) {
        String filePath = "txtfile/StuIDinfo.txt";  //数据文件路径
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean found = false,first=true;
            while ((line = reader.readLine()) != null) {
                if (first){   //跳过第一行说明行
                    first=false;
                    continue;
                }
                String[] parts = line.split("\\s+"); //假设数据文件中每行格式为 "学号 姓名 成绩"
                if (parts[0].equals(StuID)) {
                    sb.append("学号: ").append(StuID).append("\n");
                    sb.append("姓名: ").append(parts[1]).append("\n");
                    sb.append("计算机: ").append(parts[2]).append("\n");
                    sb.append("外语: ").append(parts[3]).append("\n");
                    sb.append("统计原理: ").append(parts[4]).append("\n");
                    found = true;
                    break;
                }
            }
            if (!found) {
                sb.append("");
                JOptionPane.showMessageDialog(null, "查无此人");
            }
        }
        catch (IOException ex) {
            sb.append("读取文件时出错: ").append(ex.getMessage());
        }
        return sb.toString();
    }
}