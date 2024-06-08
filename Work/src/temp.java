import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class temp extends JFrame {

	private JTextField empIdField;
	private JTextField empNameField;
	private JComboBox<String> empSexField;
	private JTextField empPhoneField;
	private JTextField empEmailField;
	private JTextField birthDateField;
	private JButton registerButton;

	public temp() {
		setTitle("用户注册");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		// 账号
		JLabel empIdLabel = new JLabel("账号:");
		empIdField = new JTextField(10);
		add(empIdLabel);
		add(empIdField);

		// 姓名
		JLabel empNameLabel = new JLabel("姓名:");
		empNameField = new JTextField(20);
		add(empNameLabel);
		add(empNameField);

		// 性别
		JLabel empSexLabel = new JLabel("性别:");
		empSexField = new JComboBox<>(new String[]{"男", "女"});
		add(empSexLabel);
		add(empSexField);

		// 电话
		JLabel empPhoneLabel = new JLabel("电话:");
		empPhoneField = new JTextField(15);
		add(empPhoneLabel);
		add(empPhoneField);

		// 邮箱
		JLabel empEmailLabel = new JLabel("邮箱:");
		empEmailField = new JTextField(20);
		add(empEmailLabel);
		add(empEmailField);

		// 生日
		JLabel birthDateLabel = new JLabel("生日:");
		// 这里可以添加一个日期选择器，但为了简单起见，我们使用文本框
		birthDateField = new JTextField(10);
		add(birthDateLabel);
		add(birthDateField);

		// 注册按钮
		registerButton = new JButton("注册");
		registerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 这里可以添加注册逻辑，比如验证输入并发送到服务器
				System.out.println("注册信息:");
				System.out.println("账号: " + empIdField.getText());
				System.out.println("姓名: " + empNameField.getText());
				System.out.println("性别: " + (String) empSexField.getSelectedItem());
				System.out.println("电话: " + empPhoneField.getText());
				System.out.println("邮箱: " + empEmailField.getText());
				System.out.println("生日: " + birthDateField.getText());
			}
		});
		add(registerButton);

		setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new temp();
			}
		});
	}
}