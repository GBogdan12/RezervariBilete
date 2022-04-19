package proiect;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

 public class Interfata1  implements ActionListener{
	    //afisare zboruri disponibile
	 int i=0; 
		JLabel label1=new JLabel("Zboruri Disponibile");
		JLabel label2=new JLabel("Orasul de plecare:");
		JLabel label3=new JLabel("Orasul de destinatie:");
		JLabel label4=new JLabel("Data de plecare:");
		JLabel label5=new JLabel("Data de intoarcere:");
		JTextField  textField1=new JTextField(10);
		JTextField  textField2=new JTextField(10);
		JTextField  textField3=new JTextField(10);
		JTextField  textField4=new JTextField(10);
		JFrame frame1=new JFrame();
		public  Interfata1(){
			JButton button=new JButton("Cauta");
			JPanel panel1=new JPanel();
			JPanel panel2=new JPanel();
	
			
			 button.setSize(50, 50);
			 button.addActionListener(this);
			 Tabel A=new Tabel();
			JTable table=new JTable();
			table=A.adaugaTabel();
			JScrollPane scrollPane1=new JScrollPane(table);
			
			
			 panel1.add(label2);
			 panel1.add(textField1);
			 panel1.add(label3);
			 panel1.add(textField2);
			 panel1.add(label4);
			 panel1.add(textField3);
			 panel1.add(label5);
			 panel1.add(textField4);
			 panel1.add(button);
			 panel1.setLayout(new FlowLayout());
			 panel2.add(label1,BorderLayout.CENTER);
			 panel1.setBorder(BorderFactory.createEmptyBorder(10,0,10,10));
			 scrollPane1.setVisible(true);
			scrollPane1.setBorder(BorderFactory.createEmptyBorder(50,10,10,10));
		    frame1.add(scrollPane1,BorderLayout.CENTER);
		    frame1.add(panel1,BorderLayout.SOUTH);
		    frame1.add(panel2,BorderLayout.NORTH);
			frame1.setTitle("Zboruri deschise");
			frame1.setSize(150,150);
			frame1.pack();
			frame1.setLayout(null);
			frame1.setVisible(true);
		
		}
		public void actionPerformed(ActionEvent e) {
			String orasPlecare=textField1.getText();
			String orasDestinatie=textField2.getText();
			String dataPlecare=textField3.getText();
			String dataIntoarcere=textField4.getText();
			textField1.setText(null);
			textField2.setText(null);
			textField3.setText(null);
			textField4.setText(null);
			Tabel verific=new Tabel();
			if(verific.gasit(orasPlecare, orasDestinatie, dataPlecare, dataIntoarcere)==true) {
				new Interfata2(orasPlecare, orasDestinatie, dataPlecare, dataIntoarcere);	
				frame1.setVisible(false);
			}
			else { JOptionPane.showMessageDialog(null, "Nu este disponibil niciun zbor cu datele:\n"
					+ "Oras de plecare:"+orasPlecare+
					"\nOras de destinatie:"+orasDestinatie+
					"\nData de plecare:"+dataPlecare+
					"\nData de intoarcere:"+dataIntoarcere);
			frame1.setVisible(true);
			}	
			
		}
}
	