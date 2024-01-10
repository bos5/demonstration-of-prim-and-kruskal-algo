package something_of_Duong.privateforDuong.JavaAppletForDemonstrationPrimAndKruskalAlgo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class South extends JPanel implements ActionListener {
	/**
	 *
	 */
//    private static final long serialVersionUID = 1L;
	private JTextField box1TextField = new JTextField("");
	private JTextField box2TextField = new JTextField("");
	private JTextField setWeightTextField = new JTextField("");

	private JButton sendButton = new JButton("send");
	private JButton step = new JButton("step");

	private JLabel node1Label = new JLabel("1st node");
	private JLabel node2Label = new JLabel("2nd node");
	private JLabel weightLabel = new JLabel("weight");

	private String regularExpression = "([1-9][0-9]*)";
	Dessin d;
	public int nNodes = 50;
	Edge[] tree = new Edge[nNodes * nNodes];;


	public South(Dessin d) {
		this.d = d;
		initTree(tree);
		setBackground(Color.black);
		sendButton.addActionListener(this);
		step.addActionListener(this);

		node1Label.setForeground(Color.white);
		this.add(node1Label);
		box1TextField.setColumns(3);
		this.add(box1TextField);

		node2Label.setForeground(Color.white);
		this.add(node2Label);
		box2TextField.setColumns(3);
		this.add(box2TextField);

		weightLabel.setForeground(Color.white);
		this.add(weightLabel);
		setWeightTextField.setColumns(3);

		this.add(setWeightTextField);
		this.add(sendButton);
		this.add(step);
	}

	public void initTree(Edge[] tree) {
		for (int i = 0; i < tree.length; i++) {
			tree[i] = null;
		}
	}

	public void actionPerformed(ActionEvent event) {
		if (d.recommence) {
			initTree(tree);
			d.recommence = false;
		}
		if (event.getSource() == sendButton) {
			String c1 = box1TextField.getText();
			String c2 = box2TextField.getText();
			String c3 = setWeightTextField.getText();

			if (c1.matches(regularExpression) && c2.matches(regularExpression) && c3.matches(regularExpression)) {

				int s1 = Integer.parseInt(c1);
				int s2 = Integer.parseInt(c2);
				int weight = Integer.parseInt(c3);

				if (s1 <= d.getNode() && s2 <= d.getNode() && s1 != s2) {
					Edge a = new Edge(s1, s2, weight);

					boolean isReady = false;
					int emplacement = 0;
					int i = 0;

					while (tree[i] != null && i < tree.length) {
						if ((tree[i].getNode1() == a.getNode1() || tree[i].getNode1() == a.getNode2())
								&& (tree[i].getNode2() == a.getNode1() || tree[i].getNode2() == a.getNode2())) {
							emplacement = i;
							isReady = true;
						}
						i++;
					}
					if (!isReady) {
						tree[d.getNEdge()] = a;
						d.addEdge(a, d.getNEdge());

					} else {
						tree[emplacement].setWeight(weight);
						d.modifyEdge(emplacement, weight);
					}

					d.repaint();
				}
			}
		} else if (event.getSource() == step) {

		}
	}
}
