package menjacnica;

import java.util.LinkedList;
import java.util.List;

public class Menjacnica {
	private static List<Kurs> kursevi = new LinkedList<Kurs>();

	public static List<Kurs> vratiSveKurseve() {
		return kursevi;
	}

	public void setKursevi(List<Kurs> kursevi) {
		this.kursevi = kursevi;
	}
	
	public static void dodajKurs(String sifra, String naziv, String skraceniNaziv, double prodajniKurs, double kupovniKurs, double srednjiKurs) {
		Kurs k = new Kurs();
		k.setSifra(sifra);
		k.setKupovniKurs(kupovniKurs);
		k.setNaziv(naziv);
		k.setSkraceniNaziv(skraceniNaziv);
		k.setProdajniKurs(prodajniKurs);
		k.setSrednjiKurs(srednjiKurs);
		kursevi.add(k);
	}
	
	public static void izbrisiKurs(Kurs k) {
		kursevi.remove(k);
	}
}
