package proiect;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;

public class Interfata5  implements ActionListener { // interfata logare
	JLabel label1=new JLabel("Introduceti datele de logare:");
	JLabel label2=new JLabel("UserName:");
	JLabel label3=new JLabel("Parola:");
	JTextField  textField1=new JTextField(10);
	JTextField  textField2=new JTextField(10);
	JFrame frame1=new JFrame();
	Zbor modifica = new Zbor();
	public int pret;
	String nume;
	Main main = new Main();
	public Interfata5() {
	JPanel panel=new JPanel();
	JPanel panel1=new JPanel();
	JPanel panel2=new JPanel();
	
	
	JButton button=new JButton("Logare");
	
	panel.setBorder(BorderFactory.createEmptyBorder(25,50,50,50));
	button.addActionListener(this);
	panel.setLayout(new GridLayout(0,1));
	panel.add(label2);
	panel.add(textField1);
	panel1.setBorder(BorderFactory.createEmptyBorder(0,50,50,50));
	panel.add(label3);
	panel.add(textField2);
	panel1.add(button);
	panel2.setBorder(BorderFactory.createEmptyBorder(50,50,0,50));
	panel2.add(label1,BorderLayout.CENTER);
	frame1.add(panel,BorderLayout.CENTER);
	frame1.add(panel2,BorderLayout.NORTH);
	frame1.add(panel1,BorderLayout.SOUTH);
	frame1.setTitle("Login");
	frame1.setSize(150,150);
	frame1.pack();
	frame1.setLayout(null);
	frame1.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		nume=textField1.getText();
    	String parola=textField2.getText();
    	File fisier1=new File("E:\\proiecte-eclips\\proiect poo\\src\\proiect\\Utilizatori.txt");
    	File fisier2=new File("E:\\proiecte-eclips\\proiect poo\\src\\proiect\\Rezervari1.txt");
    		Scanner f1;
    		Scanner f2;
    		
    		boolean valid=false;
    		
    	
    		
			try {
				
				String[] separator1 = new String[10];
				String[] separator2 = new String[8];
				
				int sold=0;
				f1 = new Scanner(fisier1);
				f2 = new Scanner(fisier2);

				while((f1.hasNextLine() && valid == false) || (f2.hasNextLine()&& valid == false)) {
					String sir1=f1.nextLine();
					String sir2=f2.nextLine();
					
					 separator1= sir1.split(" : "); 
					 separator2 = sir2.split(","); 
				
				
					 if(nume.equals(separator1[0])) {	 
							sold = Integer.parseInt(separator1[2]);
							pret = Integer.parseInt(separator2[5]);
							int pret2 = sold-pret;
		    			    modifica.modifyFile("E:\\proiecte-eclips\\proiect poo\\src\\proiect\\Utilizatori.txt", String.valueOf(sold), String.valueOf(pret2));
		    			   }
				
					
					
				if( valiare(nume,parola,separator1[0],separator1[1]) == true){
					valid = true;
					
				}}
					if(valid == true) {
					int codRezervare = 0;
	    			   Scanner f3=new Scanner(fisier2);
	    			   while(f3.hasNextLine()) {
	    				   String sir2=f3.nextLine();
	    				   String[] sir=new String[30];
	    				   sir=sir2.split(",");
	    				    codRezervare = Integer.parseInt(sir[sir.length-2]);
	    				  
				}
	    			   JOptionPane.showMessageDialog(null, "Rezervarea a fost creata! Cod rezervare: "+ codRezervare);
	    			   Main.initializare();
	    			   
	    			   frame1.setVisible(false);
					}
				else {
					JOptionPane.showMessageDialog(null, "Datele nu sunt corecte!");
					frame1.setVisible(true);
				}
				
			} catch (FileNotFoundException e1) {
				System.out.println("Eroare citire utilizatori");
				e1.printStackTrace();
			}
			
			try {
				BufferedWriter scriere=new BufferedWriter(new FileWriter(fisier2,true));  // scriere rezervarii in fisier
				scriere.write(nume+"\n");
				scriere.close();
			} catch (IOException e2) {
				System.out.println("Eroare scriere Interfata5.");
				e2.printStackTrace();
			}
    		
    		
    			
    		
	}
	public boolean valiare(String nume,String parola, String numeFisier, String parolaFisier) {
		if(nume.equals(numeFisier) && parola.equals(parolaFisier)) {
			
			return true;
		}
		
		return false;
	}

}
