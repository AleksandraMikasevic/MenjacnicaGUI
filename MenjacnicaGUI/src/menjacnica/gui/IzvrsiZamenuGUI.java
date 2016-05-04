package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IzvrsiZamenuGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblKupovniKurs;
	private JLabel lblProdajniKurs;
	private JTextField kupovniKursTxt;
	private JTextField prodajniKursTxt;
	private JComboBox comboBox;
	private JLabel lblIznos;
	private JTextField iznosTxt;
	private JRadioButton rdbtnKupovina;
	private JRadioButton rdbtnProdaja;
	private JLabel lblVrstaTransakcije;
	private JSlider slider;
	private JButton btnIzvrsiZamenu;
	private JButton btnOdustani;	
	private final ButtonGroup buttonGroup = new ButtonGroup();

	

	/**
	 * Create the frame.
	 */
	public IzvrsiZamenuGUI() {
		setResizable(false);
		setTitle("Izvrsi zamenu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 361, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblKupovniKurs());
		contentPane.add(getLblProdajniKurs());
		contentPane.add(getKupovniKursTxt());
		contentPane.add(getProdajniKursTxt());
		contentPane.add(getComboBox());
		contentPane.add(getLblIznos());
		contentPane.add(getIznosTxt());
		contentPane.add(getRdbtnKupovina());
		contentPane.add(getRdbtnProdaja());
		contentPane.add(getLblVrstaTransakcije());
		contentPane.add(getSlider());
		contentPane.add(getBtnIzvrsiZamenu());
		contentPane.add(getBtnOdustani());
	}
	private JLabel getLblKupovniKurs() {
		if (lblKupovniKurs == null) {
			lblKupovniKurs = new JLabel("Kupovni kurs: ");
			lblKupovniKurs.setBounds(12, 0, 108, 34);
		}
		return lblKupovniKurs;
	}
	private JLabel getLblProdajniKurs() {
		if (lblProdajniKurs == null) {
			lblProdajniKurs = new JLabel("Prodajni kurs:");
			lblProdajniKurs.setBounds(237, 0, 108, 34);
		}
		return lblProdajniKurs;
	}
	private JTextField getKupovniKursTxt() {
		if (kupovniKursTxt == null) {
			kupovniKursTxt = new JTextField();
			kupovniKursTxt.setEditable(false);
			kupovniKursTxt.setBounds(4, 34, 116, 22);
			kupovniKursTxt.setColumns(10);
		}
		return kupovniKursTxt;
	}
	private JTextField getProdajniKursTxt() {
		if (prodajniKursTxt == null) {
			prodajniKursTxt = new JTextField();
			prodajniKursTxt.setEditable(false);
			prodajniKursTxt.setBounds(227, 34, 116, 22);
			prodajniKursTxt.setColumns(10);
		}
		return prodajniKursTxt;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"EUR", "USD", "CHF"}));
			comboBox.setBounds(132, 34, 83, 22);
		}
		return comboBox;
	}
	private JLabel getLblIznos() {
		if (lblIznos == null) {
			lblIznos = new JLabel("Iznos:");
			lblIznos.setBounds(12, 69, 108, 34);
		}
		return lblIznos;
	}
	private JTextField getIznosTxt() {
		if (iznosTxt == null) {
			iznosTxt = new JTextField();
			iznosTxt.setBounds(4, 102, 116, 22);
			iznosTxt.setColumns(10);
		}
		return iznosTxt;
	}
	private JRadioButton getRdbtnKupovina() {
		if (rdbtnKupovina == null) {
			rdbtnKupovina = new JRadioButton("Kupovina");
			rdbtnKupovina.setSelected(true);
			buttonGroup.add(rdbtnKupovina);
			rdbtnKupovina.setBounds(218, 101, 127, 25);
		}
		return rdbtnKupovina;
	}
	private JRadioButton getRdbtnProdaja() {
		if (rdbtnProdaja == null) {
			rdbtnProdaja = new JRadioButton("Prodaja");
			buttonGroup.add(rdbtnProdaja);
			rdbtnProdaja.setBounds(218, 129, 127, 25);
		}
		return rdbtnProdaja;
	}
	private JLabel getLblVrstaTransakcije() {
		if (lblVrstaTransakcije == null) {
			lblVrstaTransakcije = new JLabel("Vrsta transakcije:");
			lblVrstaTransakcije.setBounds(218, 69, 108, 34);
		}
		return lblVrstaTransakcije;
	}
	private JSlider getSlider() {
		if (slider == null) {
			slider = new JSlider();
			slider.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					iznosTxt.setText(""+slider.getValue());
				}
			});
			slider.setMajorTickSpacing(10);
			slider.setSnapToTicks(true);
			slider.setPaintTicks(true);
			slider.setPaintLabels(true);
			slider.setMinorTickSpacing(5);
			slider.setBounds(4, 176, 339, 52);
		}
		return slider;
	}
	private JButton getBtnIzvrsiZamenu() {
		if (btnIzvrsiZamenu == null) {
			btnIzvrsiZamenu = new JButton("Izvrsi zamenu");
			btnIzvrsiZamenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String tekst;
					String naziv = (String) comboBox.getSelectedItem();
					String iznos = iznosTxt.getText();
					String izabrano;
					boolean staJeizabrano = rdbtnKupovina.isSelected();
					if(staJeizabrano == true) {
						izabrano = "kupovina";
					}
					else {
						izabrano = "prodaja";
					}
					tekst = naziv+" "+iznos+" "+izabrano;
					GUIKontroler.ispisi(tekst);
				}
				
			});
			btnIzvrsiZamenu.setBounds(4, 241, 116, 30);
		}
		return btnIzvrsiZamenu;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnOdustani.setBounds(227, 240, 116, 30);
		}
		return btnOdustani;
	}
}
