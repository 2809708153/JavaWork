//2022413536 王锦渝 计算机二班
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class Test2022413536 extends JFrame implements ActionListener {
    private final JTextField tfAuthorId;
    private final JTextArea taResult;

    public static void main(String[] args) {
        // 创建并显示图书查询窗口
        SwingUtilities.invokeLater(() -> new Test2022413536().setVisible(true));
    }
    public Test2022413536() {
        setTitle("图书查询");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);

        // 创建内容面板
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new FlowLayout());

        // 创建作者编号输入框和查询按钮
        JPanel inputPanel = new JPanel();
        JLabel lblAuthorId = new JLabel("请输入作者编号:");
        tfAuthorId = new JTextField(10);
        JButton btnSearch = new JButton("查询");
        JButton closeButton = new JButton("关闭");
        btnSearch.addActionListener(this);
        closeButton.addActionListener(e -> this.dispose());

        inputPanel.add(lblAuthorId);
        inputPanel.add(tfAuthorId);
        inputPanel.add(btnSearch);
        inputPanel.add(closeButton);

        // 创建结果显示区域
        taResult = new JTextArea();
        taResult.setPreferredSize(new Dimension(325, 135));  //设置固定大小，防止布局自定义
        taResult.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(taResult);

        // 将输入框、查询按钮和结果显示区域添加到内容面板中
        contentPanel.add(inputPanel, BorderLayout.NORTH);
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        // 设置内容面板
        setContentPane(contentPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String authorId = tfAuthorId.getText();
        String result = searchBook(authorId);
        taResult.setText(result);
    }

    private String searchBook(String authorId) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("txtfile/Book.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                /*
                //测试
                for (int i=0;i<parts.length;i++)
                    System.out.println(parts[i]);
                 **/
                if (parts[1].equals(authorId)) {
                    // 如果作者编号匹配，返回相关信息
                    System.out.println("SUCC");
                    return "作者编号：" + parts[1] + "\n书名：" + parts[2] + "\n价格：" + parts[3] + "\n数量：" + parts[4]+ "\n书号：" + parts[0];

                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            return "数据文件读取失败";
        }
        // 如果作者编号不存在，返回查无此人
        return "查无此人";
    }
}