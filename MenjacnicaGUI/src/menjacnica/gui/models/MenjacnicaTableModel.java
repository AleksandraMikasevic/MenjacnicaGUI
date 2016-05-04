package menjacnica.gui.models;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import menjacnica.Kurs;

public class MenjacnicaTableModel extends AbstractTableModel {
	private final String[] kolone = new String[] { "Šifra", "Skraæeni naziv", "Prodajni", "Srednji", "Kupovni", "Naziv" };
	private List<Kurs> kursevi = new LinkedList<Kurs>();

	public  MenjacnicaTableModel(List<Kurs> kursevi) {
		// TODO Auto-generated constructor stub
		this.kursevi = kursevi;
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return kolone.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return kursevi.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		Kurs kurs = kursevi.get(arg0);
		switch (arg1) {
		case 0:
			return kurs.getSifra();
		case 1: 
			return kurs.getSkraceniNaziv();
		case 2:
			return kurs.getProdajniKurs();
		case 3:
			return kurs.getSrednjiKurs();
		case 4:
			return kurs.getKupovniKurs();
		case 5:
			return kurs.getNaziv();
		default:
			return 0;
		}	}
	
	@Override
	public String getColumnName(int column) {
		return kolone[column];
	}

	public void staviSveKurseveUModel(List<Kurs> kursevi) {
		this.kursevi = kursevi;
		fireTableDataChanged();
	}

	public Kurs vratiKurs(int index) {
		return kursevi.get(index);
	}
	
}
