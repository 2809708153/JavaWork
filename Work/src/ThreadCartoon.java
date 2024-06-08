import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ThreadCartoon {

    private JFrame Cartoonframe;
    private JLabel label;
    private MovePicture movePictureThread;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ThreadCartoon().createAndShowGUI();
            }
        });
    }

    private void createAndShowGUI() {
        Cartoonframe = new JFrame("线程动画");
        // 设置窗口图标
        Cartoonframe.setIconImage(new ImageIcon("image/福.png").getImage());

        Cartoonframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Cartoonframe.setSize(1000, 1000);

        label = new JLabel();
        ImageIcon icon = new ImageIcon("image/CodeRabbit.gif"); // 确保图片路径正确
        label.setIcon(icon);
        label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight()); // 初始位置  

        Cartoonframe.add(label);
        Cartoonframe.setLayout(null); // 使用绝对布局
        Cartoonframe.setVisible(true);

        movePictureThread = new MovePicture(label, Cartoonframe.getSize());
        movePictureThread.start();
    }

    class MovePicture extends Thread {
        private JLabel label;
        private Dimension frameSize;
        private Random random;

        public MovePicture(JLabel label, Dimension frameSize) {
            this.label = label;
            this.frameSize = frameSize;
            this.random = new Random();
        }

        @Override
        public void run() {
            while (true) { // 无限循环，使图片持续移动  
                int newX = random.nextInt(frameSize.width - label.getWidth());
                int newY = random.nextInt(frameSize.height - label.getHeight());
                label.setBounds(newX, newY, label.getWidth(), label.getHeight());

                try {
                    Thread.sleep(100); // 每次移动后暂停100毫秒  
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}