package something_of_Duong.privateforDuong.JavaAppletForDemonstrationPrimAndKruskalAlgo;

import java.awt.* ;
import javax.swing.*;
public class MaFrame extends JFrame {
    /**
     *
     */
//    private static final long serialVersionUID = 1L;
    Dessin d=new Dessin();
    North n = new North(d);
    South s=new South(d);
    public MaFrame() {
        super("Minimum spanning tree");
        setLayout(new BorderLayout());
        this.add(n,BorderLayout.NORTH);
        this.add(d, BorderLayout.CENTER);
        this.add(s,BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
    }
    public static void main(String[] args) {
        JFrame cadre = new MaFrame();
        cadre.setVisible(true);
    }
}
