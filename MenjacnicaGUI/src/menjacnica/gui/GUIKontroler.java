package menjacnica.gui;

import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class GUIKontroler {
	private static MenjacnicaGUI frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new MenjacnicaGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void ucitajIzFajla() {
		JFileChooser fc = new JFileChooser();
		int povratnaVrednost = fc.showOpenDialog(frame.getContentPane());

		if (povratnaVrednost == JFileChooser.APPROVE_OPTION) {
			File fajl = fc.getSelectedFile();
			
	}
		JOptionPane.showMessageDialog(frame.getContentPane(), "Uspesno ste ocitali fajl!", "Poruka",
				JOptionPane.ERROR_MESSAGE);
}
}
