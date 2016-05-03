package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class DodajKursGui extends JFrame {

	private JPanel contentPane;
	private JLabel lblifra;
	private JTextField sifraTxt;
	private JLabel lblNaziv;
	private JTextField nazivTxt;
	private JLabel lblProdajniKurs;
	private JLabel lblKupovniKurs;
	private JTextField prodajniKursTxt;
	private JTextField kupovniKursTxt;
	private JLabel lblSrednjiKurs;
	private JLabel lblSkraæeniNaziv;
	private JTextField srednjiKursTxt;
	private JTextField skraceniNazivTxt;
	private JButton btnDodaj;
	private JButton btnOdustani;


	/**
	 * Create the frame.
	 */
	public DodajKursGui() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setTitle("Dodaj kurs");
		setBounds(100, 100, 410, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		contentPane.add(getLblifra());
		contentPane.add(getLblNaziv());
		contentPane.add(getSifraTxt());
		contentPane.add(getNazivTxt());
		contentPane.add(getLblProdajniKurs());
		contentPane.add(getLblKupovniKurs());
		contentPane.add(getProdajniKursTxt());
		contentPane.add(getKupovniKursTxt());
		contentPane.add(getLblSrednjiKurs());
		contentPane.add(getLblSkraæeniNaziv());
		contentPane.add(getSrednjiKursTxt());
		contentPane.add(getSkraceniNazivTxt());
		contentPane.add(getBtnDodaj());
		contentPane.add(getBtnOdustani());
	}

	private JLabel getLblifra() {
		if (lblifra == null) {
			lblifra = new JLabel("\u0160ifra:");
			lblifra.setPreferredSize(new Dimension(70, 5));
			lblifra.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblifra;
	}
	private JTextField getSifraTxt() {
		if (sifraTxt == null) {
			sifraTxt = new JTextField();
			sifraTxt.setPreferredSize(new Dimension(70, 20));
			sifraTxt.setColumns(10);
		}
		return sifraTxt;
	}
	private JLabel getLblNaziv() {
		if (lblNaziv == null) {
			lblNaziv = new JLabel("Naziv:");
			lblNaziv.setPreferredSize(new Dimension(70, 20));
			lblNaziv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblNaziv;
	}
	private JTextField getNazivTxt() {
		if (nazivTxt == null) {
			nazivTxt = new JTextField();
			nazivTxt.setPreferredSize(new Dimension(70, 20));
			nazivTxt.setColumns(10);
		}
		return nazivTxt;
	}
	private JLabel getLblProdajniKurs() {
		if (lblProdajniKurs == null) {
			lblProdajniKurs = new JLabel("Prodajni kurs: ");
			lblProdajniKurs.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblProdajniKurs;
	}
	private JLabel getLblKupovniKurs() {
		if (lblKupovniKurs == null) {
			lblKupovniKurs = new JLabel("Kupovni kurs:");
			lblKupovniKurs.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblKupovniKurs;
	}
	private JTextField getProdajniKursTxt() {
		if (prodajniKursTxt == null) {
			prodajniKursTxt = new JTextField();
			prodajniKursTxt.setColumns(10);
		}
		return prodajniKursTxt;
	}
	private JTextField getKupovniKursTxt() {
		if (kupovniKursTxt == null) {
			kupovniKursTxt = new JTextField();
			kupovniKursTxt.setColumns(10);
		}
		return kupovniKursTxt;
	}
	private JLabel getLblSrednjiKurs() {
		if (lblSrednjiKurs == null) {
			lblSrednjiKurs = new JLabel("Srednji kurs:");
			lblSrednjiKurs.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblSrednjiKurs;
	}
	private JLabel getLblSkraæeniNaziv() {
		if (lblSkraæeniNaziv == null) {
			lblSkraæeniNaziv = new JLabel("Skra\u0107eni naziv:");
			lblSkraæeniNaziv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblSkraæeniNaziv;
	}
	private JTextField getSrednjiKursTxt() {
		if (srednjiKursTxt == null) {
			srednjiKursTxt = new JTextField();
			srednjiKursTxt.setColumns(10);
		}
		return srednjiKursTxt;
	}
	private JTextField getSkraceniNazivTxt() {
		if (skraceniNazivTxt == null) {
			skraceniNazivTxt = new JTextField();
			skraceniNazivTxt.setColumns(10);
		}
		return skraceniNazivTxt;
	}
	private JButton getBtnDodaj() {
		if (btnDodaj == null) {
			btnDodaj = new JButton("Dodaj");
			btnDodaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				String sifra = getSifraTxt().getText();
				String naziv = getNazivTxt().getText();
				String prodajniKurs = getProdajniKursTxt().getText();
				String kupovniKurs = getKupovniKursTxt().getText();
				String skraceniNaziv = getSkraceniNazivTxt().getText();
				String srednjiKurs = getSrednjiKursTxt().getText();
				String novo = sifra+","+naziv+","+prodajniKurs+","+kupovniKurs+","+skraceniNaziv+","+srednjiKurs;
				GUIKontroler.dodajKurs(novo);
				}
			});
			btnDodaj.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return btnDodaj;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					toBack();
				}
			});
			btnOdustani.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return btnOdustani;
	}
}
