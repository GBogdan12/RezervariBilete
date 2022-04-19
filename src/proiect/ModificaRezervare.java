package proiect;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;



public class ModificaRezervare extends JFrame {
	
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
	Rezervari A=new Rezervari();
	int cod;
	File fisier1 = new File("E:\\proiecte-eclips\\proiect poo\\src\\proiect\\Rezervari1.txt");

	ArrayList<Zbor> cautareZbor=A.getRezervari();
	
	
	public ModificaRezervare(){
		
	}
	
	public void  content(int index)  {
		this.index2=index;
		nume = new  ArrayList<String>();
		 try {
			Scanner f1=new Scanner(fisier1);
			 while(f1.hasNextLine()) {
				 String sir1=f1.nextLine();
				 String[] separator = new String[8];
				 separator= sir1.split(",");
				  nume.add(separator[6]);
			 }
		} catch (FileNotFoundException e) {
			System.out.println("Eroare citire ModificaRezervare.");
			e.printStackTrace();
		}
		

		frame=new JFrame("Modifica Rezervare");
		frame.setSize(900,400);
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
	    titlu = new JLabel();
	    titlu.setText(" Modificari Rezervare");
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
		JButton modifica = new JButton ("Modifica Rezervarea");
		
		
		
		 oras.setText("Oras plecare: ");
		 orasNou.setVisible(false);
		 oras.setVisible(false);
		
		 JButton confirma = new JButton ("Confirma");
		 confirma.setBounds(300, 210, 100, 20);
		 frame.add(confirma);
		 confirma.setVisible(false);
		 
		 frame.add(mesajModificare);
		 mesajModificare.setBounds(100, 230, 250, 39);
		 
		    JTable table=new JTable();
			table=cauta(index);
			table.setEnabled(false);
			panel1.setLayout(new GridLayout(1,2));
			panel1.add(table,BorderLayout.CENTER);
			panel3.add(modifica, BorderLayout.SOUTH);
			frame.add(panel1, BorderLayout.CENTER);
			frame.add(panel3, BorderLayout.SOUTH);
			JScrollPane scrollPane1=new JScrollPane(table);
			frame.add(scrollPane1);
			 modifica.setVisible(true);
			scrollPane1.setVisible(true);
			scrollPane1.setBorder(BorderFactory.createEmptyBorder(50,10,10,10));
		    frame.add(scrollPane1,BorderLayout.CENTER);
		   
		    panel3.setLayout(new GridLayout(0,5));
		    panel3.add(oras);
		    panel3.add(orasNou);
		    panel3.add(mesajModificare);
		    panel3.add(confirma);
		    
	
	modifica.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			orasNou.setVisible(true);
			 oras.setVisible(true);
			 confirma.setVisible(true);
			 modifica.setVisible(false);
			 
		}
	});
	
	
	confirma.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			getOrasDestinatie();
		}
	});
	
	}
	public void getOrasDestinatie(){
		ok=false;
		String orasNou2 = orasNou.getText();
		for(int j=0;j<zbor.size();j++) {
		if(orasNou2.equals(zbor.get(j).orasePlecare)  ) {
		ok=true;
		break;
		}	
		}
		mesajModificare.setVisible(true);
		
		mesajConfirma();
	}
	
	public void mesajConfirma() {
		if(ok==true) {
			cod = cautareZbor.get(nr1).cod;
			mesajModificare.setText("Succes! ");
			mesajModificare.setForeground(Color.green);
			
		new Interfata6(orasNou.getText(),cod);
			frame.setVisible(false);
		}
			else {
				mesajModificare.setText("Eroare! Orasul nu este disponibil! ");
				mesajModificare.setForeground(Color.red);
			}
			 
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
	
	public int getZbor() {
		return index2;
	}
}
