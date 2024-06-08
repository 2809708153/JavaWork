import javax.swing.*;
import java.awt.*;

public class Shape {
    public static void main(String[] args) {
        JFrame Star = new JFrame();
        Star.setTitle("Shape");
        Star.setBounds(0,0,600,400);
        Star.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Star.setContentPane(new ShapePanel());
        Star.setVisible(true);
    }
}
class ShapePanel extends JPanel{
    public void paint(Graphics g) {
        //super.paint(g);    //清屏
        int wid = this.getWidth() / 10, hig = this.getHeight() / 10;
        //绘制方圆
        g.setColor(Color.CYAN);
        g.fillOval(wid * 2,hig,wid * 3 / 2,wid * 3 / 2);
        g.setColor(Color.RED);
        g.drawRect(wid * 2,hig,wid * 3 / 2,wid * 3 / 2);
        //绘制椭圆线
        g.drawArc(wid,hig * 5,wid * 2,wid,0,180);
        g.setColor(Color.BLUE);
        g.drawArc(wid * 2,hig * 5,wid * 2,wid,0,-180);
        //绘制缺右上角圆
        g.setColor(Color.CYAN);
        g.fillArc(wid * 4,hig * 7,wid,wid,0,-270);
        //绘制椭圆
        g.setColor(Color.MAGENTA);
        g.fillOval(wid * 5,hig * 5,wid * 2,wid);
        //绘制缺右下角圆
        g.setColor(Color.GREEN);
        g.fillArc(wid * 6,hig * 7,wid * 2,wid,0,270);
    }
}
