package menjacnica.gui;

import java.awt.EventQueue;
import java.io.File;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import menjacnica.Kurs;
import menjacnica.Menjacnica;

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
	
	public static String ucitajIzFajla() {
		JFileChooser fc = new JFileChooser();
		int povratnaVrednost = fc.showOpenDialog(frame.getContentPane());
		String s = "";
		if(povratnaVrednost == JFileChooser.APPROVE_OPTION) {
			File fajl = fc.getSelectedFile();
			s = fajl.getAbsolutePath();
		}
		return s;
}
	
	public static String sacuvaj() {
		JFileChooser fc = new JFileChooser();
		int povratnaVrednost = fc.showSaveDialog(frame.getContentPane());
		String s = "";
		if(povratnaVrednost == JFileChooser.APPROVE_OPTION) {
			File fajl = fc.getSelectedFile();
			s = fajl.getAbsolutePath();
		}
		return s;

	}
	
	public static void ugasiAplikaciju() {
		int opcija = JOptionPane.showConfirmDialog(frame.getContentPane(),
				"Da li zelite da zatvorite aplikaciju?", "Izlazak", JOptionPane.YES_NO_CANCEL_OPTION);

		if (opcija == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	public static List<Kurs> vratiSveKurseve() {
		return Menjacnica.vratiSveKurseve();
	}
	public static void dodajKursProzor() {
		DodajKursGui prozor = new DodajKursGui();
		prozor.setVisible(true);
		prozor.setLocationRelativeTo(null);
	}
	//String naziv, String skraceniNaziv, String sifra, double prodajniKurs, double kupovniKurs, double srednjiKurs
	public static void dodajKurs(String novo) {
		String[] novi = novo.split(",");
		String sifra = novi[0];
		String naziv = novi[1];
		Double prodajniKurs = Double.parseDouble(novi[2]);
		Double kupovniKurs = Double.parseDouble(novi[3]);
		String skraceniNaziv = novi[4];
		Double srednjiKurs = Double.parseDouble(novi[5]);
		Menjacnica.dodajKurs(sifra, naziv, skraceniNaziv, prodajniKurs, kupovniKurs, srednjiKurs);
		frame.osveziTabelu();
	}
	
}	
