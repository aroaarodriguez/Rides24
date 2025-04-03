package gui;

import java.awt.EventQueue;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogic.BLFacade;
import domain.Bidaiari;
import domain.Car;
import domain.Eskaera;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ErrEgKon extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ErrEgKon frame = new ErrEgKon();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public ErrEgKon(Bidaiari bidaiari) {
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(ResourceBundle.getBundle("Etiquetas").getString("ErrEgKon.Title"));
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JComboBox Erreserbak = new JComboBox();
		Erreserbak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Eskaera eskaera = (Eskaera) Erreserbak.getSelectedItem();
				Date data = eskaera.getDate();
				if(new Date().compareTo(data)>0) {
					btnNewButton.setVisible(true);
				}
			}
		});
		btnNewButton = new JButton();
		btnNewButton.setText(ResourceBundle.getBundle("Etiquetas").getString("ErrEgKon.Confirm"));
		btnNewButton.setVisible(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BLFacade facade = MainGUI.getBusinessLogic();
				Eskaera eskaera = (Eskaera) Erreserbak.getSelectedItem();
				facade.ezabatuEskaera(eskaera);
				//kendu dirua
				
			}
		});
		
		Erreserbak.setBounds(10, 85, 416, 33);
		BLFacade facade = MainGUI.getBusinessLogic();
		List<Eskaera> eskaerak = facade.getAllEskaera();
		for (Eskaera esk: eskaerak) {
			if(esk.isBaieztatuta()) {
				Erreserbak.addItem(esk);
			}
		}

		
		/*List<Bidaiari> bidaiariList = facade.getAllBidaiari();
		JcomboBox.removeAllItems();
		for (Bidaiari bidaiari : bidaiariList) {
		    for (Eskaera eskaera : bidaiari.getEskaerak()) {
		        comboBox.addItem(eskaera);
		    }
		}*/
		contentPane.add(Erreserbak);
		
		JLabel Erreserbak_txt = new JLabel("New label");
		Erreserbak_txt.setBounds(191, 36, 49, 14);
		contentPane.add(Erreserbak_txt);
		
	
		btnNewButton.setBounds(174, 201, 89, 23);
		contentPane.add(btnNewButton);
	}
}
