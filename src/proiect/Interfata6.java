package proiect;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

 public class Interfata6 extends JFrame{
	    // Tabel lista zboruri gasite
	 int i=0; 
		JLabel label1=new JLabel("Zboruri Disponibile");
		JLabel label2=new JLabel("Introduceti numarul zborului:");
		JLabel label3=new JLabel("Introduceti orasul de destinatie:");
		JFrame frame1=new JFrame();
		JTextField  textField1=new JTextField(10);
		JTextField  textField2=new JTextField(10);
		JTextField  textField3=new JTextField(10);
		JTextField  textField4=new JTextField(10);
		public int nrZbor;
		public String orasDestinatie;
		File f1=new File("E:\\proiecte-eclips\\proiect poo\\src\\proiect\\pasageri.txt");
		int cod;
		JTable table,table1;
		Zbor zbor = new Zbor();
		InformatiiZboruri InformatiiZboruri = new InformatiiZboruri();
		Rezervari rezervari = new Rezervari ();
		ArrayList<Zbor> rezervari1 = rezervari.getRezervari();
		ArrayList<Zbor> rezervari2 = InformatiiZboruri.AfiseazaZboruri();
		int confirmare;
		ModificaRezervare index = new ModificaRezervare();
		
		public  Interfata6() {
			
		}
		
		public  Interfata6(String orasDestinatie, int cod) {
			JButton button=new JButton("Selecteaza");
			JPanel panel1=new JPanel();
			JPanel panel2=new JPanel();
			this.cod=cod;
			this.orasDestinatie=orasDestinatie;
			 button.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
			 button.setSize(50, 50);
			 
			JTable table1=cauta(orasDestinatie);
			JScrollPane scrollPane1=new JScrollPane(table1);
			table1.setEnabled(false);
		
			panel1.add(label2,BorderLayout.WEST);
			 panel1.add(textField1,BorderLayout.CENTER);
			 panel1.add(button,BorderLayout.EAST);
			 panel2.add(label1,BorderLayout.CENTER);
			 panel1.setBorder(BorderFactory.createEmptyBorder(10,0,10,10));
			   scrollPane1.setVisible(true);
			scrollPane1.setBorder(BorderFactory.createEmptyBorder(50,10,10,10));
		    frame1.add(scrollPane1,BorderLayout.CENTER);
		    frame1.add(panel1,BorderLayout.SOUTH);
		    frame1.add(panel2,BorderLayout.NORTH);
			frame1.setTitle("Zboruri Disponibile");
			frame1.setSize(50,150);
			frame1.pack();
			frame1.setLayout(null);
			frame1.setVisible(true);
			
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			i++;
	    	String indexZbor=textField1.getText();
	      	nrZbor=Integer.parseInt(indexZbor);
	      	nrZbor--;
			
			confirmare = JOptionPane.showConfirmDialog(null, " Categoria de bilet ramane neschimbata? ");
			frame1.setVisible(false);
			if(confirmare==1) {
				
				JOptionPane.showMessageDialog(null," Rezervarea NU a fost modificata!");
			}
			else {
				int codNou = 0;
				for(int i =0;i<rezervari1.size();i++) 
					if(cod == rezervari1.get(i).cod) {	
					Random A1 = new Random();
					 codNou = A1.nextInt(1000)+10;
					
						
					modifyFile("E:\\proiecte-eclips\\proiect poo\\src\\proiect\\Rezervari1.txt",rezervari1.get(i).oraseDestinatie , rezervari2.get(nrZbor).oraseDestinatie, i+1);
					
					modifyFile("E:\\proiecte-eclips\\proiect poo\\src\\proiect\\Rezervari1.txt",String.valueOf(cod) , String.valueOf(codNou), i+1);
					
					zbor.numarLocuri(nrZbor, index.getZbor() );
					frame1.setVisible(false);
					break;
					}
				
				JOptionPane.showMessageDialog(null," Rezervarea a fost modificata! Cod nou: "+ codNou);
				new Main().initializare();
			}
		}});
			
		}
		public  JTable cauta(String orasPlecare){


			boolean gasit=false;
			String[] columsNames= {
				"Nr","OrasPlecare","OrasDestinatie"
		};
		Object[][] h= {};
		setLayout(new FlowLayout());
		table=new JTable(h,columsNames);
		JTable table = new JTable(new DefaultTableModel(h,new Object[]{
				"Nr Zbor","OrasPlecare","OrasDestinatie","DataPlecare","DataIntoarcere","Piloti","Insotitori","Escale"
		}));
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		InformatiiZboruri A=new InformatiiZboruri();
		ArrayList<Zbor> cautareZbor=A.AfiseazaZboruri();
		Object[] data=new Object[10];
	   
		
		for(int j=0;j<cautareZbor.size();j++){
			if(cautareZbor.get(j).orasePlecare.equals(orasPlecare) && cautareZbor.get(j).numarLocuri >0 ) {
			data[0]=j+1;
		    data[1]=cautareZbor.get(j).orasePlecare;	
		    data[2]=cautareZbor.get(j).oraseDestinatie;	
		    data[3]=cautareZbor.get(j).dataPleacare;
		    data[4]=cautareZbor.get(j).dataIntoarcere;
		    data[5]=cautareZbor.get(j).piloti;
		    data[6]=cautareZbor.get(j).insotitori;
		    data[7]=cautareZbor.get(j).escale;
		model.addRow(data);
		}
		}

		table.setPreferredScrollableViewportSize(new Dimension(800,300));
		table.setFillsViewportHeight(false);
		if(gasit==true);
		return table; 
	}
		
		 void modifyFile(String filePath, String oldString, String newString,int index)
		  {
			  int i,nrLinie = 0;
			  i=index;
		      File fileToBeModified = new File(filePath);
		       
		      String oldContent = "";
		      String oldContent2 = "";
		       
		      BufferedReader reader = null;
		       
		      FileWriter writer = null;
		       
		      try
		      {
		          reader = new BufferedReader(new FileReader(fileToBeModified));
		         
		          String line = reader.readLine();
		           
		          while (line != null) 
		          {
		        	  if(i == nrLinie) {
		        		  oldContent2 = oldContent2 + line + System.lineSeparator();
		        		  
		        	  }
		              oldContent = oldContent + line + System.lineSeparator();
		               
		              line = reader.readLine();
		          }
		       
		          //inlocuirea oldString cu newString în oldContent
		           
		          String newContent = oldContent.replaceAll(oldString, newString);
		           
		          //Rescrierea fișierului text de intrare cu newContent
		           
		          writer = new FileWriter(fileToBeModified);
		           
		          writer.write(newContent);
		      }
		      catch (IOException e)
		      {
		          e.printStackTrace();
		      }
		      finally
		      {
		          try
		          {
		               
		              reader.close();
		               
		              writer.close();
		          } 
		          catch (IOException e) 
		          {
		              e.printStackTrace();
		          }
		      }
		  
		  }
		 
		
 }