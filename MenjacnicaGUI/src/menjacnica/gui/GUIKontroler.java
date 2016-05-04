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
	public static void dodajKurs(String naziv, String skraceniNaziv, String sifra, String prodajniKurs, String kupovniKurs, String srednjiKurs) {
		double pk = Double.parseDouble(prodajniKurs);
		double kk = Double.parseDouble(kupovniKurs);
		double sk = Double.parseDouble(srednjiKurs);
		Menjacnica.dodajKurs(sifra, naziv, skraceniNaziv, pk, kk, sk);
		frame.osveziTabelu();
	}
	
	public static void upozoriDaBiraRed() {
		JOptionPane.showMessageDialog(frame.getContentPane(), "Izaberite kurs za brisanje iz tabele!",
				"Greška", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void izbrisiKurs(Kurs k) {
		List<Kurs> kursevi = Menjacnica.vratiSveKurseve();
		Menjacnica.izbrisiKurs(k);
		List<Kurs> kursevi1 = Menjacnica.vratiSveKurseve();
		if(kursevi.equals(kursevi1)) {
			JOptionPane.showMessageDialog(frame, "Brisanje kursa nije uspešno.", "Greška", JOptionPane.ERROR_MESSAGE);
		}
		else {
		frame.osveziTabelu();
		JOptionPane.showMessageDialog(frame, "Uspešno ste izbrisali kurs.");
		}

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
		JOptionPane.showMessageDialog(frame, "Autor programa: \nAleksandra Mikaševiæ");
	}
}	
