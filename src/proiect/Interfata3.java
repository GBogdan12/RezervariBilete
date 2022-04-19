package proiect;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
public class Interfata3  {
	JTextField  textField1=new JTextField(10);
	JFrame frame1=new JFrame();
	 Bilet bilet = new Bilet();
	 Zbor zbor = new Zbor();

   public Interfata3() {
	   
	  // selectare bilet
	   
	   JLabel label1=new JLabel("Bilete Disponibile");
		JLabel label2=new JLabel("1. Clasa1: "+bilet.clasa1()+" RON");
		JLabel label3=new JLabel("2. Clasa2: "+bilet.clasa2()+" RON");
		JLabel label4=new JLabel("3. Clasa3: "+bilet.clasa3()+" RON");
		JButton button=new JButton("Card Bancar");
		JButton button1=new JButton("Abonament");
		JPanel panel1=new JPanel();
		JPanel panel2=new JPanel();
		JPanel panel3=new JPanel();
		panel1.add(label1,BorderLayout.CENTER);
		 frame1.add(panel2,BorderLayout.NORTH);
		
		 panel2.setBorder(BorderFactory.createEmptyBorder(25,50,0,50));
		 panel1.setBorder(BorderFactory.createEmptyBorder(25,50,25,50));
		
		 label2.setBorder(BorderFactory.createEmptyBorder(25,50,25,50));
		 label3.setBorder(BorderFactory.createEmptyBorder(25,50,25,50));
		 label4.setBorder(BorderFactory.createEmptyBorder(25,50,25,50));
		 panel1.add(label2);
		 panel1.add(label3);
		 panel1.add(label4);
		 panel3.add(textField1);
		 panel3.add(button);
		 panel3.add(button1);
		 panel3.setBorder(BorderFactory.createEmptyBorder(25,50,25,50));
		 panel3.setLayout(new GridLayout(0,1));
		 panel1.setLayout(new GridLayout(0,1));
		 
		    frame1.add(panel1,BorderLayout.CENTER);
		    frame1.add(panel3,BorderLayout.SOUTH);
			frame1.setTitle("Bilete Disponibile");
			
			textField1.setSize(100,10);
			frame1.pack();
			frame1.setLayout(null);
			frame1.setVisible(true);
		
   


	button.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
	String optiune1=textField1.getText();
	int pret,nr;
	nr=Integer.parseInt(optiune1);
	String[] optiuni= {"Confrima","Anulare"};
	if(nr==1) {
		  pret= bilet.clasa1();
	}
	   else if(nr==2) {
		   pret= bilet.clasa2();
	   }
	       else {
	    	   pret= bilet.clasa3();
	       }
	
		JOptionPane.showOptionDialog(null,"Pretul biletului este de "+pret+" RON", " Confirmati?", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, optiuni, null);
		frame1.setVisible(false);
		File f2=new File("E:\\proiecte-eclips\\proiect poo\\src\\proiect\\Rezervari1.txt");
		try {
			
			BufferedWriter scriere=new BufferedWriter(new FileWriter(f2,true));  // scriere rezervarii in fisier
			scriere.write(pret+",");
			scriere.close();
			} catch (IOException e) {
			System.out.println("Eroare interfata3");
			e.printStackTrace();
			}

			 new Interfata4();
		
     
   }

	});
	
	button1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		String optiune1=textField1.getText();
		int pret,nr;
		nr=Integer.parseInt(optiune1);
		String[] optiuni= {"Confrima","Anulare"};
		if(nr==1) {
			  pret= bilet.clasa1();
			  
			
		}
		   else if(nr==2) {
			   pret= bilet.clasa2();
		   }
		       else {
		    	   pret= bilet.clasa3();
		       }
		
			JOptionPane.showOptionDialog(null,"Pretul biletului este de "+pret+" RON", " Confirmati?", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, optiuni, null);
			frame1.setVisible(false);
			File f1=new File("E:\\proiecte-eclips\\proiect poo\\src\\proiect\\Rezervari1.txt");
			try {
				BufferedWriter scriere=new BufferedWriter(new FileWriter(f1,true));  // scriere rezervarii in fisier
				scriere.write(pret+",");
				scriere.close();
				} catch (IOException e) {
				System.out.println("Eroare");
				e.printStackTrace();
				}
			
				new Interfata5();
			
	     
	   }

		});
   }
   

}
