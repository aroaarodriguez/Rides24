package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import businessLogic.BLFacade;
import domain.Driver;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGidariGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane;
	protected JLabel jLabelSelectOption;
	private JButton jButtonAcceptRide = null;
	private JButton jButtonCreateRide = null;
	private JButton jButtonAddCar = null;
	private JButton jButtonRemoveRide = null;
	private JButton jButtonSeeMovements = null;

    private static BLFacade appFacadeInterface;
	
	public static BLFacade getBusinessLogic(){
		return appFacadeInterface;
	}
	 
	public static void setBussinessLogic (BLFacade afi){
		appFacadeInterface=afi;
	}

	public MainGidariGUI(Driver driver) {
		super();
		setTitle(ResourceBundle.getBundle("Etiquetas").getString("MainGidariGUI.Title"));
	    setBounds(100, 100, 495, 290);
		
		this.setSize(495, 290);
		jLabelSelectOption = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("MainGidariGUI.Title"));
		jLabelSelectOption.setBounds(0, 0, 481, 42);
		jLabelSelectOption.setFont(new Font("Tahoma", Font.BOLD, 13));
		jLabelSelectOption.setForeground(Color.BLACK);
		jLabelSelectOption.setHorizontalAlignment(SwingConstants.CENTER);
	
		jButtonCreateRide = new JButton(); //$NON-NLS-1$ //$NON-NLS-2$
		jButtonCreateRide.setBounds(0, 42, 481, 42);
		jButtonCreateRide.setText(ResourceBundle.getBundle("Etiquetas").getString("CreateRideGUI.CreateRide"));
		jButtonCreateRide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame a = new CreateRideGUI(driver);
				a.setVisible(true);
			}
		});
		
		jButtonAcceptRide = new JButton();
		jButtonAcceptRide.setBounds(0, 84, 481, 42);
		jButtonAcceptRide.setText(ResourceBundle.getBundle("Etiquetas").getString("MainGidariGUI.AcceptRide"));
		jButtonAcceptRide.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				JFrame a = new OnartuGUI(driver);
				a.setVisible(true);
			}
		});

		jButtonAddCar = new JButton();
		jButtonAddCar.setBounds(0, 126, 481, 42);
		//jButtonAddCar.setText(ResourceBundle.getBundle("Etiquetas").getString("MainGidariGUI.AcceptRide"));
		jButtonAddCar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				JFrame a = new AddCarGUI(driver);
				a.setVisible(true);
			}
		});
		
		jButtonRemoveRide = new JButton();
		jButtonRemoveRide.setBounds(0, 168, 481, 42);
		//jButtonRemoveRide.setText(ResourceBundle.getBundle("Etiquetas").getString("MainGidariGUI.AcceptRide"));
		jButtonRemoveRide.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				JFrame a = new KantzelatuGUI();
				a.setVisible(true);
			}
		});
		
		jButtonSeeMovements = new JButton();
		jButtonSeeMovements.setBounds(0, 210, 481, 42);
		//jButtonSeeMovements.setText(ResourceBundle.getBundle("Etiquetas").getString("MainGidariGUI.AcceptRide"));
		jButtonSeeMovements.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				//JFrame a = new OnartuGUI(driver);
				//a.setVisible(true);
			}
		});
		
		setContentPane(jContentPane);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(1);
			}
		});

		jContentPane = new JPanel();
		jContentPane.setLayout(new GridLayout(6, 1, 0, 0));
		jContentPane.add(jLabelSelectOption);
		jContentPane.add(jButtonCreateRide);
		jContentPane.add(jButtonAcceptRide);
		jContentPane.add(jButtonAddCar);
		jContentPane.add(jButtonRemoveRide);
		jContentPane.add(jButtonSeeMovements);
		
		
		setContentPane(jContentPane);
		setTitle(ResourceBundle.getBundle("Etiquetas").getString("MainGUI.MainTitle") + " - driver :"+driver.getName());
		
	}
}

