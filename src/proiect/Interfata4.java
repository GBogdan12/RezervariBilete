package proiect;

	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.*;

	public class Interfata4 implements ActionListener{
		 int g=0; 
		 Main main=new Main();
		 //plata card
		 	int codRezervare;
			JLabel label1=new JLabel("Introduceti datele:");
			JLabel label2=new JLabel("Nume:");
			JLabel label3=new JLabel("Prenume:");
			JLabel label4=new JLabel("Tip card:");
			JLabel label5=new JLabel("Numar card:");
			JLabel label6=new JLabel("Data expirare:");
			
			
			JTextField  textField1=new JTextField(10);
			JTextField  textField2=new JTextField(10);
			JTextField  textField3=new JTextField(10);
			JTextField  textField4=new JTextField(10);
			JTextField  textField5=new JTextField(10);
			File f1=new File("E:\\proiecte-eclips\\proiect poo\\src\\proiect\\pasageri.txt");
	    	File fisier2=new File("E:\\proiecte-eclips\\proiect poo\\src\\proiect\\Rezervari1.txt");

			Zbor  cursa=new Zbor();
			JFrame frame1=new JFrame();
			public  Interfata4() {
				
				
				
				JPanel panel1=new JPanel();
				JPanel panel2=new JPanel();
				GridLayout experimentLayout = new GridLayout(0,1);
				
				panel1.setLayout(experimentLayout);
				panel1.add(label1);
				panel1.add(label2);
				panel1.add(textField1);
				panel1.add(label3);
				panel1.add(textField2);
				panel1.add(label4);
				panel1.add(textField3);
				panel1.add(label5);
				panel1.add(textField4);
				panel1.add(label6);
				panel1.add(textField5);
				
				panel1.setSize(new Dimension(200,400));
				panel1.setBorder(BorderFactory.createEmptyBorder(25,50,50,50));
				label1.setBorder(BorderFactory.createEmptyBorder(50,50,0,50));
				
				JButton button=new JButton("Trimite");
				button.addActionListener(this);
				 button.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
				 button.setSize(50, 50);
				 panel2.add(button);
				 panel2.setBorder(BorderFactory.createEmptyBorder(0,50,25,50));
				
				 frame1.add(panel1,BorderLayout.CENTER);
				frame1.add(label1,BorderLayout.NORTH);
				frame1.add(panel2,BorderLayout.SOUTH);
				frame1.setTitle("Date personale");
				frame1.setSize(1200,400);
				frame1.pack();
				frame1.setLayout(null);
				frame1.setVisible(true);
			
			}
			@Override
			public void actionPerformed(ActionEvent e) {
				String nume = textField1.getText();
				String prenume = textField2.getText();
				String tipCard = textField3.getText();
				String nrCard = textField4.getText();
				String dataExpirare = textField5.getText();
				if(validare(tipCard,nrCard,dataExpirare)==true) {
					
					try {
						File fisier1=new File("E:\\proiecte-eclips\\proiect poo\\src\\proiect\\Rezervari1.txt");
		    			   Scanner f1=new Scanner(fisier1);
		    			   while(f1.hasNextLine()) {
		    				   
		    				   String sir1=f1.nextLine();
		    				   String[] sir=new String[30];
		    				   sir=sir1.split(",");
		    				   codRezervare = Integer.parseInt(sir[4]);
		    			   }
		    			  
		    			   
					} catch(IOException a) {
		    			   System.out.println("Eroare interfata4");
					}
					
				try {
					BufferedWriter scriere=new BufferedWriter(new FileWriter(f1,true));  // scriere rezervarii in fisier
					scriere.write(codRezervare+" , "+nume+" , "+prenume+" , "+tipCard+" , "+nrCard+" , "+dataExpirare+"\n");
					scriere.close();
					} catch (IOException e1) {
					System.out.println("Eroare interfata4 scriere");
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
				
				
				
				
				JOptionPane.showMessageDialog(null, "Rezervarea a fost creata! Cod rezervare: "+ codRezervare);
				
				
				Main.initializare();
				frame1.setVisible(false);
					}
				else 
					JOptionPane.showMessageDialog(null, "Datele nu sunt corecte!");
				
				
				
				
			}
			
			public boolean validare(String s, String s1, String s2) {
				
				if(s.equals("visa")  || s.equals("mastercard")) {
					
					if(s1.length() == 12) {
						
							if(getDateTime(s2)) {
								return true;
							}}}
							else {
								System.out.print("Eroare lungime.");
				
							}
				return false;
			}
			
			private boolean getDateTime(String dataUtil) {
		        DateFormat dateFormat = new SimpleDateFormat("MM yyyy");
		        Date date = new Date();
		        String data = new String();
		        data = dateFormat.format(date).toString();
		        String[] data2 = new String[3];
		        String[] data3 = new String[3];
		        data2 = data.split(" ");
		        data3 = dataUtil.split(" ");
		        int luna = Integer.parseInt(data2[0]);
		         int an = Integer.parseInt(data2[1]);
		         int lunaUtil = Integer.parseInt(data3[0]);
		         int anUtil = Integer.parseInt(data3[1]);
		         if(anUtil - an>0) 
		    	   return true;
		         else if(anUtil == an && lunaUtil - luna >0)
		        		 return true;
		        
		       return false;
	}
}
