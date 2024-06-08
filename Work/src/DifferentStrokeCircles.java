import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class DifferentStrokeCircles extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // 设置抗锯齿渲染，使图像边缘更平滑  
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 设置背景色  
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // 绘制细圆  
        g2d.setColor(Color.BLUE);
        float thinStrokeWidth = 2.0f; // 细圆的线宽  
        BasicStroke thinStroke = new BasicStroke(thinStrokeWidth);
        g2d.setStroke(thinStroke);
        g2d.draw(new Ellipse2D.Double(50, 50, 200, 200)); // 绘制细圆，位置和大小  

        // 绘制粗圆
        g2d.setColor(Color.RED);
        float thickStrokeWidth = 10.0f; // 粗圆的线宽  
        BasicStroke thickStroke = new BasicStroke(thickStrokeWidth);
        g2d.setStroke(thickStroke);
        g2d.draw(new Ellipse2D.Double(300, 50, 200, 200)); // 绘制粗圆，位置和大小  
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("双圆");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.add(new DifferentStrokeCircles());
        frame.setVisible(true);
    }
}