import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    public static void main(String[] args) {
        Login login = new Login();
        login.initUI();
    }
    public static void initUI() {
        JFrame frame = new JFrame();
        frame.setTitle("用户登录窗口");  //设置标题
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);  //设置窗体相对于另一个组件的居中位置，参数null表示窗体相对于屏幕的中央位置
        frame.setResizable(false);          //设置禁止调整窗体大小
        //流式布局，布局窗体 从左至右依次摆放 整体默认居中 ，一行充满 摆放到下一行
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));  //frame框架调用流式布局方法；

        JLabel labTitle = new JLabel("用户登录窗口");
        labTitle.setFont(new Font("宋体",Font.PLAIN,20));
        labTitle.setPreferredSize(new Dimension(350,20));
        labTitle.setHorizontalAlignment(JLabel.CENTER); //水平居中
        labTitle.setVerticalAlignment(JLabel.CENTER);   //垂直居中
        frame.add(labTitle);

        JLabel labName = new JLabel("账号：");
        frame.add(labName);
        JTextField nameInput = new JTextField();
        Dimension dim1 = new Dimension(250, 20);
        nameInput.setPreferredSize(dim1);
        frame.add(nameInput);
        JLabel labpass = new JLabel("密码：");
        frame.add(labpass);
        JPasswordField pwdInput = new JPasswordField();
        pwdInput.setPreferredSize(dim1);
        frame.add(pwdInput);

        JButton loginbutton = new JButton("登录");
        JButton savebutton = new JButton("重置");
        JButton closebutton = new JButton("关闭");
        frame.add(loginbutton);
        frame.add(savebutton);
        frame.add(closebutton);
        //窗体可视化需要将所有组件加载完再执行
        frame.setVisible(true);// 设置窗体为可见
        LoginListener loginListener = new LoginListener();
        loginbutton.addActionListener(loginListener);
        closebutton.addActionListener(e->frame.dispose());
        loginListener.input(nameInput, pwdInput);
    }
}

class LoginListener implements ActionListener {
    JTextField textName;
    JPasswordField textPwd;
    public void input(JTextField x, JPasswordField y){
        textName = x;
        textPwd = y;
    }
    public void actionPerformed(ActionEvent e) {
        //获取输入框的字符
        String username = textName.getText();
        String pwd = textPwd.getText();
        //验证账号登录的半段
        if (username.equals("admin") && pwd.equals("123456"))
            //写一个小弹窗
            JOptionPane.showMessageDialog(null, "登录成功");
        else
            JOptionPane.showMessageDialog(null,"登录失败");
    }
}
