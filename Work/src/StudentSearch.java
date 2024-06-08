import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class StudentSearch {
    private JFrame StudentSearchFrame;
    private JTextField nameField;
    private JTextArea resultArea;
    private JButton searchButton;
    private JButton closeButton;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StudentSearch window = new StudentSearch();
                    window.StudentSearchFrame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public StudentSearch() {
        initialize();
    }

    private void initialize() {
        //框架
        StudentSearchFrame = new JFrame();
        StudentSearchFrame.setBounds(100, 100, 450, 225);  //设置框架大小
        StudentSearchFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        StudentSearchFrame.getContentPane().setLayout(new FlowLayout());  //浮动布局
        //指示用户说明
        JLabel instruction = new JLabel("请输入学生姓名:");
        StudentSearchFrame.getContentPane().add(instruction);
        //用户输入框
        nameField = new JTextField();
        StudentSearchFrame.getContentPane().add(nameField);
        nameField.setColumns(10);
        //查询按钮
        searchButton = new JButton("查询");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(StudentSearchFrame, "请输入学生姓名！");
                    return;
                }
                String result = searchStudent(name);
                resultArea.setText(result);
            }
        });
        StudentSearchFrame.getContentPane().add(searchButton);
        //关闭按钮
        closeButton = new JButton("关闭");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StudentSearchFrame.dispose();
            }
        });
        StudentSearchFrame.getContentPane().add(closeButton);
        //输出框
        resultArea = new JTextArea();
        resultArea.setPreferredSize(new Dimension(350, 135));  //设置固定大小，防止布局自定义
        StudentSearchFrame.getContentPane().add(resultArea);
        resultArea.setEditable(false);  //文本不可编辑
        resultArea.setLineWrap(true);   //文本自动换行
        resultArea.setWrapStyleWord(true); //防止文本换行断词
    }

    private String searchStudent(String name) {
        String filePath = "txtfile/StuSearchData.txt";  //数据文件路径
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean found = false,first=true;
            while ((line = reader.readLine()) != null) {
                if (first){   //跳过第一行说明行
                    first=false;
                    continue;
                }
                String[] parts = line.split("\\s+"); //假设数据文件中每行格式为 "姓名 成绩"
                if (parts[0].equals(name)) {
                    sb.append("学生姓名: ").append(name).append("\n");
                    sb.append("性别: ").append(parts[1]).append("\n");
                    sb.append("语文: ").append(parts[2]).append("\n");
                    sb.append("数学: ").append(parts[3]).append("\n");
                    sb.append("英语: ").append(parts[4]).append("\n");
                    sb.append("自然: ").append(parts[5]).append("\n");
                    sb.append("社会: ").append(parts[6]).append("\n");
                    sb.append("总分: ").append(parts[7]);
                    found = true;
                    break;
                }
            }
            if (!found) {
                JOptionPane.showMessageDialog(null, "查无此人");
            }
        }
        catch (IOException ex) {
            sb.append("读取文件时出错: ").append(ex.getMessage());
        }
        return sb.toString();
    }
}