import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

public class FiveStar {
    public static void main(String[] args) {
        JFrame Star = new JFrame();
        Star.setTitle("五角星");
        Star.setBounds(0,0,575,575);
        Star.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Star.setContentPane(new StarPanel());
        Star.setVisible(true);
    }
}
class StarPanel extends JPanel{
    public void paint(Graphics g) {
        //super.paint(g);    //清屏
        int wid = this.getWidth();
        //System.out.println(wid);
        //随机颜色数组
        Color [] colors = { Color.RED  ,Color.GREEN  ,Color.BLUE  ,Color.DARK_GRAY  ,
                Color.CYAN  ,Color.GRAY  ,Color.MAGENTA  ,Color.PINK  ,Color.YELLOW};
        int ColorCount = colors.length;
        Graphics2D g2d=(Graphics2D)g;
        //平滑绘制
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        //10个顶点的坐标 注意：这里是以中心为原点，X轴向右，Y轴向上的坐标轴，标准的半径为1
        Random r = new Random();
        for (int k = 0; k < 100; k++){
            int Ranx = r.nextInt(wid), Rany = r.nextInt(wid), Ranwid = r.nextInt(wid / 5);
            Color RanColor = colors[Ranwid % ColorCount];
            Point2D.Double pA=new Point2D.Double(0, 1);
            Point2D.Double pB=new Point2D.Double(-0.95106, 0.30902);
            Point2D.Double pC=new Point2D.Double(-0.58779, -0.80902);
            Point2D.Double pD=new Point2D.Double(0.58779, -0.80902);
            Point2D.Double pE=new Point2D.Double(0.95106, 0.30902);
            Point2D.Double pF=new Point2D.Double(0, -0.38197);
            Point2D.Double pG=new Point2D.Double(0.36328, -0.11804);
            Point2D.Double pH=new Point2D.Double(0.22452, 0.30902);
            Point2D.Double pI=new Point2D.Double(-0.22452, 0.30902);
            Point2D.Double pJ=new Point2D.Double(-0.36328, -0.11804);
            Point2D.Double[] points= {pA,pI,pB,pJ,pC,pF,pD,pG,pE,pH};
            //坐标转换（指定目标正方形，在里面画一个五角星）
            Rectangle rect=new Rectangle(Ranx,Rany,Ranwid,Ranwid);
            int radius_x=rect.width/2;
            int radius_y=rect.height/2;
            for(Point2D.Double point:points) {
                point.x=rect.getCenterX()+radius_x*point.x;
                point.y=rect.getCenterY()-radius_y*point.y;  //坐标反转
            }
            //圆五角星
            Path2D outline=new Path2D.Double();
            outline.moveTo(points[0].x, points[0].y);
            for(int i=1;i<points.length;i++)
                outline.lineTo(points[i].x, points[i].y);
            outline.closePath();
            g2d.setPaint(RanColor);
            g2d.fill(outline);
            //repaint();   //重绘
        }
    }
}
