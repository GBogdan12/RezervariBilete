package proiect;


import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		
		initializare();
		
	}
	
	public static void initializare() {
		
		Rezervari rezervari1 = new Rezervari();
		ModificaRezervare modificaRezervare = new ModificaRezervare();
		
		
		JButton rezervari, modificaRezervarebtn, anuleazaRezervare;
		
		rezervari = new JButton("Fă o rezervare!");   //butoane
		modificaRezervarebtn = new JButton ("Modifică rezervare");
		anuleazaRezervare = new JButton ("Anuleaza rezervare");
		
		
		JLabel paragraf = new JLabel("Orarul zborurilor este afișat în ora locală. Orele de deschidere și închidere ale biroului de check-in,");
		JLabel paragraf1 = new JLabel( "de predare a bagajelor și ale porții de îmbarcare pot fi afectate de modificările stării zborului.");
		JLabel paragraf2 = new JLabel( "Vă recomandăm să urmăriți cu atenție ecranele/anunțurile de la aeroport și informațiile care vă  ");
		JLabel paragraf3 = new JLabel( "sunt trimise direct de Serviciul de relații cu clienții EBileteAvion."); //paragraf
		JLabel titlu = new JLabel();
	    titlu.setText("EBileteAvion");
	    titlu.setFont(new Font("Time New Roman", Font.PLAIN, 40));
	    

	  
		JFrame frame = new JFrame ("Fereastra Principala - EBileteAvion");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(650,600);
		frame.setVisible(true);
		
	    frame.add(titlu);
	    frame.add(paragraf);
	    frame.add(paragraf1);
	    frame.add(paragraf2);
	    frame.add(paragraf3);
	    frame.add( anuleazaRezervare );
	    frame.add(modificaRezervarebtn);
	    frame.add(rezervari);
	    titlu.setBounds(225, 30, 300, 50);
		rezervari.setBounds(235, 110, 200, 50);
		modificaRezervarebtn.setBounds(235, 170, 200, 50);
		anuleazaRezervare.setBounds(235, 230, 200, 50);
		paragraf.setBounds(30, 235, 800, 150);
		paragraf1.setBounds(30, 250, 800, 150);
		paragraf2.setBounds(30, 275, 800, 150);
		paragraf3.setBounds(30, 290, 800, 150);
		

		rezervari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				new Interfata1();
			}
		});
		
		modificaRezervarebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean gasit = false;
				String cod;
				frame.setVisible(false);
				cod = JOptionPane.showInputDialog("Introduceti codul rezervarii");
				ArrayList<Zbor> zbor = rezervari1.getRezervari();
				for(int i=0;i<zbor.size();i++) {
					if(String.valueOf(zbor.get(i).cod).equals(cod)) {
						modificaRezervare.content(i);
						gasit = true;
						
						break;
					}}
					if(gasit == false) {
						JOptionPane.showMessageDialog(null, "Rezervarea nu exista in sistem!");
						initializare();
					
					}
					else {
						
						frame.setVisible(false);
					}
						
				
				
				}
		});
		
		anuleazaRezervare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean gasit = false;
				String cod;
				frame.setVisible(false);
				cod = JOptionPane.showInputDialog("Introduceti codul rezervarii");
				ArrayList<Zbor> zbor = rezervari1.getRezervari();
				for(int i=0;i<zbor.size();i++) {
					if(String.valueOf(zbor.get(i).cod).equals(cod)) {
						anuleazaRezervare anuleazaRezervare = new anuleazaRezervare();
						anuleazaRezervare.content(i);
						gasit = true;
						
						break;
					}}
					if(gasit == false) {
						JOptionPane.showMessageDialog(null, "Rezervarea nu exista in sistem!");
						initializare();
					
					}
					else {
						
						frame.setVisible(false);
					}
			}
		});
		
		
	}
	
	
	

}
