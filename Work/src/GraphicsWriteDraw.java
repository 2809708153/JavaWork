import javax.swing.*;
import java.awt.*;

public class GraphicsWriteDraw extends JPanel {
    private JLabel image1 = new JLabel(new ImageIcon("image/DrawOne.png"));
    private JLabel image2 = new JLabel(new ImageIcon("image/DrawTwo.png"));
    @Override
    protected void paintComponent(Graphics g) {
        int wid = this.getWidth(),hig = this.getHeight();   //获取框架长宽用于百分比放缩
        super.paintComponent(g);
        BasicStroke stokeLine = new BasicStroke(1.0f);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(stokeLine);
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, wid, hig);
        //黑线
        g2.setColor(Color.BLUE);
        g2.drawLine(50, 60, 160, 60);
        g2.drawLine(50, 100, 160, 100);
        //绘制三根绿色的线
        g2.setColor(Color.GREEN);
        g2.drawLine(95, 115, 180, 190);
        g2.drawLine(120, 115, 220, 200);
        g2.drawLine(136, 140, 220, 200);

        float thin1=3.0f;
        BasicStroke stokeLine1 = new BasicStroke(thin1);
        g2.setStroke(stokeLine1);
        //红绿实心矩形
        g2.setColor(Color.GREEN);
        g2.fillRect(50, 51, 30, 30);
        g2.setColor(Color.RED);
        g2.fillRect(80, 50, 50, 30);
        g2.setColor(Color.GREEN);
        g2.fillRect(50, 91 , 30, 30);
        g2.setColor(Color.RED);
        g2.fillRect(80, 90, 50, 30);
        //绘制圆弧
        g2.setColor(Color.blue);
        g2.drawArc(190, 105, 25, 25, 0, 360);
        // 绘制椭圆形
        g2.setColor(Color.RED);
        g2.fillOval(240, 105, 30, 20);
        //绘制横线，两个矩形边框
        g2.setColor(Color.RED);
        g2.drawLine(50, 135, 200, 135);
        g2.setColor(Color.RED);
        g2.drawRect(50, 150, 50, 80);
        g2.setColor(Color.RED);
        g2.drawRoundRect(120, 150, 80, 80,20,20);
        // 写字
        g2.setColor(Color.blue);
        g2.setFont(new Font("宋体", Font.BOLD, 25));
        g2.drawString("中华人民共和国", 120, 300);
        g2.drawString("用Graphics写字和画图", 120, 350);
        // 画笑脸
        g2.setColor(Color.RED);
        g2.drawOval(370, 40, 160, 160);
        g2.fillOval(420, 80, 10, 20);
        g2.fillOval(470, 80, 10, 20);
        g2.drawArc(405, 130, 90, 40, 0, -180);
        float thin2=1.0f;
        BasicStroke stokeLine2 = new BasicStroke(thin2);
        g2.setStroke(stokeLine2);
        //黑线
        g2.setColor(Color.BLUE);
        g2.drawLine(50, 60, 160, 60);
        g2.drawLine(50, 100, 160, 100);
        //图片
        image1.setLocation(400, 250);
        image2.setLocation(280, 360);
        add(image1);
        add(image2);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("绘图与写字");
        frame.setSize(600, 500);
        frame.add(new GraphicsWriteDraw());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}