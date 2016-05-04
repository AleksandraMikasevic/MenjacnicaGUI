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
	private static Menjacnica menjacnica;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menjacnica = new Menjacnica();
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
		return menjacnica.vratiSveKurseve();
	}
	public static void dodajKursProzor() {
		DodajKursGui prozor = new DodajKursGui();
		prozor.setVisible(true);
		prozor.setLocationRelativeTo(null);
	}
	
	public static void dodajKurs(String naziv, String skraceniNaziv, String sifra, String prodajniKurs, String kupovniKurs, String srednjiKurs) {
		double pk = Double.parseDouble(prodajniKurs);
		double kk = Double.parseDouble(kupovniKurs);
		double sk = Double.parseDouble(srednjiKurs);
		menjacnica.dodajKurs(sifra, naziv, skraceniNaziv, pk, kk, sk);
		frame.osveziTabelu();
	}
	
	public static void upozoriDaBiraRed() {
		JOptionPane.showMessageDialog(frame.getContentPane(), "Izaberite kurs za brisanje iz tabele!",
				"Greška", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void izbrisiKurs(Kurs k) {
	
		menjacnica.izbrisiKurs(k);
		
		frame.osveziTabelu();
		

	}
	
	public static void izvrsiZamenuProzor() {
		IzvrsiZamenuGUI prozor = new IzvrsiZamenuGUI();
		prozor.setVisible(true);
		prozor.setLocationRelativeTo(null);
	}

	public static void ispisi(String tekst) {
		// TODO Auto-generated method stub
		frame.ispisiTekst(tekst);
	}
	
	public static void pomoc() {
		JOptionPane.showMessageDialog(frame.getContentPane(), "Autor programa: \nAleksandra Mikaševiæ", "O programu", JOptionPane.INFORMATION_MESSAGE);
	}
}	
