import javax.swing.*;
import java.awt.*;

public class Smile {
    public static void main(String[] args) {
        JFrame Star = new JFrame();
        Star.setTitle("😊");
        Star.setBounds(0,0,400,400);
        Star.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Star.setContentPane(new SmilePanel());
        Star.setVisible(true);
    }
}
class SmilePanel extends JPanel{
    public void paint(Graphics g) {
        //super.paint(g);    //清屏
        int bigradius = this.getWidth() / 2;
        //绘制大脸
        g.setColor(Color.YELLOW);
        g.fillOval(bigradius / 4,bigradius / 4,bigradius * 3 / 2,bigradius * 3 / 2);
        //绘制小眼
        int smallradius = this.getWidth() / 12;
        g.setColor(Color.RED);
        g.fillOval(bigradius * 3 / 5,bigradius * 2 / 3,smallradius * 4 / 3,smallradius * 4 / 3);
        g.fillOval( bigradius * 2 - bigradius * 4 / 5,bigradius * 2 / 3,smallradius * 4 / 3,smallradius * 4 / 3);
        //绘制嘴巴
        int halfradius = bigradius;
        g.setColor(Color.BLUE);
        g.fillArc(this.getWidth() - halfradius * 3 / 2, this.getWidth() - halfradius  * 3 / 2, halfradius, halfradius, 0, -180);
    }
}
