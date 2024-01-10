package something_of_Duong.privateforDuong.JavaAppletForDemonstrationPrimAndKruskalAlgo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;

public class Arrow extends JPanel {
    private int x1, y1, x2, y2;

    public Arrow(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Vẽ đường thẳng nối 2 điểm
        g2d.drawLine(x1, y1, x2, y2);

        double angle = Math.atan2(y2 - y1, x2 - x1);

        // tính toán khoảng cách từ đỉnh B đến đầu mũi tên
        int arrowSize = 30;
        int dx = (int) (arrowSize * Math.cos(angle));
        int dy = (int) (arrowSize * Math.sin(angle));

        // tính toán vị trí mới của đỉnh B
        int newX = x2 - dx;
        int newY = y2 - dy;

        // vẽ đường thẳng và đầu mũi tên
        g2d.drawLine(x1, y1, newX, newY);
        Polygon arrowHead = new Polygon();
        arrowHead.addPoint(newX, newY);
        arrowHead.addPoint((int) (newX - arrowSize * Math.cos(angle - Math.PI / 6)), (int) (newY - arrowSize * Math.sin(angle - Math.PI / 6)));
        arrowHead.addPoint((int) (newX - arrowSize * Math.cos(angle + Math.PI / 6)), (int) (newY - arrowSize * Math.sin(angle + Math.PI / 6)));
        g2d.fill(arrowHead);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Arrow");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Arrow(23,23,48,48));
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}