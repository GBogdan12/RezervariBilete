package proiect;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;



public class anuleazaRezervare extends JFrame {
	
	private JFrame frame;
	private JLabel titlu;
	JTable table;
	public String orasDestinatie;
	 JLabel oras = new JLabel();
	 InformatiiZboruri InformatiiZboruri = new InformatiiZboruri();
	ArrayList<Zbor> zbor = InformatiiZboruri.AfiseazaZboruri();
	JTextField orasNou = new JTextField();
	JLabel mesajModificare = new JLabel();
	JLabel informatii = new JLabel();
	int nr1,index2;
	boolean ok;
	ArrayList<String> nume;
	String pret;
	Rezervari A=new Rezervari();
	int cod;
	File fisier1 = new File("E:\\proiecte-eclips\\proiect poo\\src\\proiect\\Rezervari1.txt");
	String[] separator = new String[8];
	ArrayList<Zbor> cautareZbor=A.getRezervari();
	
	
	public anuleazaRezervare(){
		
	}
	
	public void  content(int index)  {
		this.index2=index;
		nume = new  ArrayList<String>();
		
		 try {
			Scanner f1=new Scanner(fisier1);
			 while(f1.hasNextLine()) {
				 String sir1=f1.nextLine();
				 
				 separator= sir1.split(",");
				  nume.add(separator[6]);
				  pret= separator[5];
			 }
		} catch (FileNotFoundException e) {
			System.out.println("Eroare citire ModificaRezervare.");
			e.printStackTrace();
		}
		

		frame=new JFrame("Anuleaza Rezervare");
		frame.setSize(900,400);
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
	    titlu = new JLabel();
	    titlu.setText(" Anuleaza Rezervare");
	    titlu.setFont(new Font("Time New Roman", Font.PLAIN, 22));
	    panel2.add(titlu,BorderLayout.CENTER);
	    titlu.setBorder(BorderFactory.createLineBorder(Color.black));
	    frame.add(panel2, BorderLayout.NORTH);
	    titlu.setVisible(true);
	     
	    
	    informatii.setText("Informatii Rezervare");
	    informatii.setFont(new Font("Time New Roman", Font.PLAIN, 18));
	    informatii.setBounds(50, 100, 300, 50);	   
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton anuleaza = new JButton ("Anuleaza Rezervarea");
		
		 JTable table=new JTable();
			table=cauta(index);
			table.setEnabled(false);
			panel1.setLayout(new GridLayout(1,2));
			panel1.add(table,BorderLayout.CENTER);
			panel3.add(anuleaza, BorderLayout.CENTER);
			frame.add(panel1, BorderLayout.CENTER);
			frame.add(panel3, BorderLayout.SOUTH);
			JScrollPane scrollPane1=new JScrollPane(table);
			frame.add(scrollPane1);
			anuleaza.setVisible(true);
			scrollPane1.setVisible(true);
			scrollPane1.setBorder(BorderFactory.createEmptyBorder(50,10,10,10));
		    frame.add(scrollPane1,BorderLayout.CENTER);
		   	    
	
		    anuleaza.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
			modifyFile("E:\\proiecte-eclips\\proiect poo\\src\\proiect\\Rezervari1.txt",index);
			JOptionPane.showMessageDialog(null, "Rezervarea a fost stearsa cu succes!");
			 frame.setVisible(false);
			 modificaSold();
			 new Main().initializare();
		}
	});
	}
	
	public  JTable cauta(int numar){
		
		boolean gasit=false;
		String[] columsNames= {
			"Nr","Nume","OrasPlecare","OrasDestinatie"
	};
	Object[][] h= {};
	setLayout(new FlowLayout());
	table=new JTable(h,columsNames);
	
	JTable table = new JTable(new DefaultTableModel(h,new Object[]{
			"Nr Zbor","Nume","OrasPlecare","OrasDestinatie","DataPlecare","DataIntoarcere"
	}));
	DefaultTableModel model = (DefaultTableModel) table.getModel();
	
	Object[] data=new Object[10];

		
		data[0]=numar+1;
		data[1]=nume.get(numar);
	    data[2]=cautareZbor.get(numar).orasePlecare;	
	    data[3]=cautareZbor.get(numar).oraseDestinatie;	
	    data[4]=cautareZbor.get(numar).dataPleacare;
	    data[5]=cautareZbor.get(numar).dataIntoarcere;
	    data[6]=cautareZbor.get(numar).piloti;
	    data[7]=cautareZbor.get(numar).insotitori;
	    data[8]=cautareZbor.get(numar).escale;
	    
	    model.addRow(data);
	    
	    nr1 = numar;
	table.setPreferredScrollableViewportSize(new Dimension(800,300));
	table.setFillsViewportHeight(false);
	if(gasit==true);
	return table;
}
	
	 void modifyFile(String filePath, int index)
	  {
		  int i,nrLinie = 1;
		  i=index;
	      File fileToBeModified = new File(filePath);
	       
	      String oldContent = "";
	      
	       
	      BufferedReader reader = null;
	       
	      FileWriter writer = null;
	       
	      try
	      {
	          reader = new BufferedReader(new FileReader(fileToBeModified));
	         
	          String line = reader.readLine();
	           
	          while (line != null) 
	          {
	        	  if(i == nrLinie) {
	        		  line = reader.readLine();
	        		  
	        	  }
	              oldContent = oldContent + line + System.lineSeparator();
	               
	              line = reader.readLine();
	              nrLinie++;
	          }
	       
	          //inlocuirea oldString cu newString în oldContent
	           
	         
	           
	          //Rescrierea fișierului text de intrare cu newContent
	           
	          writer = new FileWriter(fileToBeModified);
	           
	          writer.write(oldContent);
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
	 
	 public void modificaSold() {
		 Zbor modifica = new Zbor();	
		 File fisier1=new File("E:\\proiecte-eclips\\proiect poo\\src\\proiect\\Utilizatori.txt");
	    	Scanner f1;    	
			int sold=0;
			
		 try {
			 	f1 = new Scanner(fisier1);
				String[] separator1 = new String[10];		
			
				f1 = new Scanner(fisier1);

				while(f1.hasNextLine()) {
					String sir1=f1.nextLine();
					
					
					 separator1= sir1.split(" : "); 
					  
				
					 System.out.println("nume= " +nume + " pret: "+pret +" separator1[0:]:  "+separator[4]);
					 if(separator1[0].equals(separator[6])) {	 
							sold = Integer.parseInt(separator1[2]);
							int	pret1 = Integer.parseInt(pret);
							int pret2 = sold+pret1;
		    			    modifica.modifyFile("E:\\proiecte-eclips\\proiect poo\\src\\proiect\\Utilizatori.txt", String.valueOf(sold), String.valueOf(pret2));
		    			   }
		 
		 
					}
	 
	
		 }catch (FileNotFoundException e1) {
				System.out.println("Eroare restituire sold");
				e1.printStackTrace();
		 }
	 }
}