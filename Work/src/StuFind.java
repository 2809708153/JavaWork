import javax.swing.*;
import java.awt.*;

public class StuFind extends JFrame {
    StuFind() {
        setTitle("学生查询");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        // 创建内容面板
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new FlowLayout());
        //创建输入框和按钮
        JPanel inputPanel = new JPanel();
        JLabel lblAuthorId = new JLabel("请输入学号:");
        JTextField tfAuthorId = new JTextField(10);
        JButton btnSearch = new JButton("查询");
        JButton saveButton = new JButton("保存");
        JButton closeButton = new JButton("关闭");
        inputPanel.add(lblAuthorId);
        inputPanel.add(tfAuthorId);
        inputPanel.add(btnSearch);
        inputPanel.add(saveButton);
        inputPanel.add(closeButton);
        //创建结果显示区域
        JTextArea taResult = new JTextArea();
        taResult.setPreferredSize(new Dimension(400, 200));  //设置固定大小，防止布局自定义
        taResult.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(taResult);
        //将输入框、查询按钮和结果显示区域添加到内容面板中
        contentPanel.add(inputPanel, BorderLayout.NORTH);
        contentPanel.add(scrollPane, BorderLayout.CENTER);
        //设置内容面板
        setContentPane(contentPanel);
    }
    public static void main(String [] args){
        SwingUtilities.invokeLater(() -> new StuFind().setVisible(true));
    }
}
