import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class FindFile {
    private JLabel label=new JLabel("所选文件路径：");
    private JTextField jtf=new JTextField(25);
    private JButton button=new JButton("浏览");
    public FindFile() {
        JFrame frame=new JFrame("文件选择器");
        //jf.setBounds(300,200,500,300);
        JPanel panel=new JPanel();
        //JPanel panel=new JPanel(new GridLayout(3,1));
        panel.add(label);
        panel.add(jtf);
        panel.add(button);
        frame.add(panel);
        frame.pack();    //自动调整大小
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button.addActionListener(new MyActionListener());    //监听按钮事件
    }
    //Action事件处理
    class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fc=new JFileChooser("C:\\");
            int val=fc.showOpenDialog(null);    //文件打开对话框
            if(val== JFileChooser.APPROVE_OPTION) {
                //正常选择文件
                jtf.setText(fc.getSelectedFile().toString());
            }
            else {
                //未正常选择文件，如选择取消按钮
                jtf.setText("未选择文件");
            }
        }
    }
    public static void main(String[] args) {
        new FindFile();
    }
}