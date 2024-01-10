package something_of_Duong.privateforDuong.JavaAppletForDemonstrationPrimAndKruskalAlgo;

import java.awt.*;

import javax.swing.JPanel;

public class Dessin extends JPanel {
	/**
	 *
	 */
//    private static final long serialVersionUID = 1L;

	private int nNodes = 0;

	Edge[] tree;
	public int nEdges = 0;

	Edge[] treeFinal = new Edge[2500];
	public boolean finish = false;
	public boolean recommence = false;
	private int cpt = 0;

	public Dessin() {
		tree = new Edge[2500];
		setBackground(Color.white);
	}

	public void paint(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		int length = getSize().width;
		int height = getSize().height;
		double angle = 0;
		Stroke s = g2.getStroke();

		for (int i = 0; i < nEdges; i++) {
			int node1 = tree[i].getNode1();
			int node2 = tree[i].getNode2();

			angle = (node1 - 1) * (2 * Math.PI / nNodes);
			double angle1 = (node2 - 1) * (2 * Math.PI / nNodes);

			g2.setColor(Color.black);

			int x1 = (int) (length / 2 - (length / 4) * Math.cos(angle) + 15);

			int y1 = (int) (height / 2 - (height / 4) * Math.sin(angle) + 15);

			int x2 = (int) ((length / 2) - (length / 4) * Math.cos(angle1) + 15);

			int y2 = (int) (height / 2 - (height / 4) * Math.sin(angle1) + 15);

			g2.setColor(Color.yellow);

			g2.drawLine(x1, y1, x2, y2);

			// Vẽ đường thẳng nối 2 điểm
			g2.drawLine(x1, y1, x2, y2);

			double angle2 = Math.atan2(y2 - y1, x2 - x1);

			// tính toán khoảng cách từ đỉnh B đến đầu mũi tên
			int arrowSize = 10;
			int dx = (int) (arrowSize * Math.cos(angle2));
			int dy = (int) (arrowSize * Math.sin(angle2));

			// tính toán vị trí mới của đỉnh B
			int newX = x2 - dx;
			int newY = y2 - dy;

			// vẽ đường thẳng và đầu mũi tên
			g2.drawLine(x1, y1, newX, newY);
			Polygon arrowHead = new Polygon();
			arrowHead.addPoint(newX, newY);
			arrowHead.addPoint((int) (newX - arrowSize * Math.cos(angle2 - Math.PI / 6)), (int) (newY - arrowSize * Math.sin(angle2 - Math.PI / 6)));
			arrowHead.addPoint((int) (newX - arrowSize * Math.cos(angle2 + Math.PI / 6)), (int) (newY - arrowSize * Math.sin(angle2 + Math.PI / 6)));
			g2.fill(arrowHead);

			g.drawString("" + (tree[i].getWeight()), (int) ((x1 + x2) / 2 + 20), (int) ((y1 + y2) / 2 + 20));
		}

		for (int i = 0; i < getCpt(); i++) {

			if (treeFinal[i] != null) {
				int node1 = treeFinal[i].getNode1();
				int node2 = treeFinal[i].getNode2();

				angle = (node1 - 1) * (2 * Math.PI / nNodes);
				double angle1 = (node2 - 1) * (2 * Math.PI / nNodes);

				g2.setColor(Color.red);
				g2.setStroke(new BasicStroke(2));
				int x = (int) ((length / 2) - ((length / 4) * Math.cos(angle)) + 15);

				int y = (int) (height / 2 - (height / 4) * Math.sin(angle) + 15);

				int x2 = (int) ((length / 2) - ((length / 4) * Math.cos(angle1)) + 15);
				int y2 = (int) (height / 2 - (height / 4) * Math.sin(angle1) + 15);

				g2.drawLine(x, y, x2, y2);
				g2.setStroke(s);

				g.setColor(Color.red);

				g.drawString("" + (treeFinal[i].getWeight()), (int) ((x + x2) / 2 + 20), (int) ((y + y2) / 2 + 20));
			}
		}

		angle = 0;
		for (int i = 0; i < nNodes; i++) {
			g2.setColor(Color.BLACK);
			g2.fillOval((int) ((length / 2) - ((length / 4) * Math.cos(angle))),
					(int) (height / 2 - (height / 4) * Math.sin(angle)), 30, 30);

			g.setColor(Color.white);

			g.drawString("" + (i + 1), (int) ((length / 2) - ((length / 4) * Math.cos(angle)) + 10),
					(int) (height / 2 - (height / 4) * Math.sin(angle) + 20));

			angle += 2 * Math.PI / nNodes;
		}

	}

	public int getCpt() {
		return cpt;
	}

	public void setCpt(int i) {
		this.cpt = i;
	}

	public int getNode() {
		return nNodes;
	}

	public void setNodes(int i) {
		this.nNodes = i;
	}

	public int getNEdge() {
		return nEdges;
	}

	public void addEdge(Edge a, int nEdge) {
		tree[nEdge] = a;
		nEdges++;
	}

	public void modifyEdge(int emplacement, int weight) {
		tree[emplacement].setWeight(weight);
	}
}
