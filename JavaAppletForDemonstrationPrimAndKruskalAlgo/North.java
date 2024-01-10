package something_of_Duong.privateforDuong.JavaAppletForDemonstrationPrimAndKruskalAlgo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class North extends JPanel implements ActionListener {
	/**
	 *
	 */
//    private static final long serialVersionUID = 1L;
	private JTextField textField = new JTextField();
	private JButton sendButton = new JButton("send");
	private JLabel node = new JLabel(" number of Node");
//	private JComboBox<String> box = new JComboBox<String>();
	Dessin d;
	private String regularExpression = "([0-9]*)";

	public North(Dessin d) {
		this.d = d;
		setBackground(Color.DARK_GRAY);
//		box.addItem(("Prim"));
//		box.setBackground(Color.WHITE);
//
//		box.addActionListener(this);
		sendButton.addActionListener(this);

//		this.add(box);
		node.setForeground(Color.white);
		this.add(node);
		textField.setColumns(3);
		this.add(textField);
		this.add(sendButton);
	}

	public void actionPerformed(ActionEvent e) {
		String s = textField.getText();
		if (s.matches(regularExpression) && s.length() > 0) {
			d.setNodes(Integer.parseInt(s));
			d.tree = new Edge[2500];
			d.nEdges = 0;
			d.setCpt(0);
			d.finish = false;
			d.recommence = true;
			d.repaint();
		}
	}
}
