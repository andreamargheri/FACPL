package it.unifi.facpl.lib.util;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ShowResult {

	public static void showResult(StringBuffer s) {
		JFrame frame = new JFrame("FACPL Decisions");
		frame.getContentPane().setLayout(new FlowLayout());

		// JTextArea jt= new JTextArea(s.toString(),5,40);
		// jt.setLineWrap(true);

		// JScrollPane sbrText = new JScrollPane(jt);
		// sbrText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		frame.add(new JScrollPane(new JTextArea(s.toString(), 40, 40)));
		// frame.getContentPane().add(jt);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
