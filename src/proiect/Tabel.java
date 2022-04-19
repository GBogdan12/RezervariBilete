package proiect;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;
import javax.swing.table.*;
class Tabel extends JFrame {  //Creare Tabeluri cu zboruri

	JTable table,table1;
	InformatiiZboruri nrLocuri = new InformatiiZboruri();
	ArrayList <Zbor> zbor = nrLocuri.AfiseazaZboruri();
	public  JTable adaugaTabel(){
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
	ArrayList<Zbor> xx=A.AfiseazaZboruri();
	
	Object[] data=new Object[10];

	for(int j=0;j<xx.size();j++){
		if(getDateTime(xx.get(j).dataPleacare)==true && zbor.get(j).numarLocuri >0 ) {
		data[0]=j+1;
	    data[1]=xx.get(j).orasePlecare;	
	    data[2]=xx.get(j).oraseDestinatie;	
	    data[3]=xx.get(j).dataPleacare;
	    data[4]=xx.get(j).dataIntoarcere;
	    data[5]=xx.get(j).piloti;
	    data[6]=xx.get(j).insotitori;
	    if(xx.get(j).escale.equals(" -"))
	    	data[7]="Nu exista escale.";
	    else
	    	data[7]=xx.get(j).escale;

	model.addRow(data);
		}
	}
	table.setEnabled(false);

	table.setPreferredScrollableViewportSize(new Dimension(800,400));
	table.setFillsViewportHeight(false);
	return table;
}
	public  JTable cauta(String orasPlecare,String orasDestinatie,String dataPlecare,String dataIntoarcere){


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
		if(cautareZbor.get(j).orasePlecare.equalsIgnoreCase(orasPlecare) && cautareZbor.get(j).oraseDestinatie.equalsIgnoreCase(orasDestinatie) 
				&& cautareZbor.get(j).dataPleacare.equalsIgnoreCase(dataPlecare) && cautareZbor.get(j).dataIntoarcere.equalsIgnoreCase(dataIntoarcere) && cautareZbor.get(j).numarLocuri >0 ) {
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
	public JTable selecteaza(int nr) {
		
		String[] columsNames= {
			"Nr","OrasPlecare","OrasDestinatie"
	};
	Object[][] h= {};
	setLayout(new FlowLayout());
	table=new JTable(h,columsNames);
	JTable table = new JTable(new DefaultTableModel(h,new Object[]{
			"Nr Zbor","OrasPlecare","OrasDestinatie","DataPlecare","DataIntoarcere"
	}));
	DefaultTableModel model = (DefaultTableModel) table.getModel();
	InformatiiZboruri A=new InformatiiZboruri();
	ArrayList<Zbor> xx=A.AfiseazaZboruri();
	
	Object[] data=new Object[5];
	data[0]=nr+1;
    data[1]=xx.get(nr).orasePlecare;	
    data[2]=xx.get(nr).oraseDestinatie;	
    data[3]=xx.get(nr).dataPleacare;
    data[4]=xx.get(nr).dataIntoarcere;
    model.addRow(data);
    return table;
	}
	
	public  boolean gasit(String orasPlecare,String orasDestinatie,String dataPlecare,String dataIntoarcere) {
		InformatiiZboruri A=new InformatiiZboruri();
		boolean gasit=false;
		ArrayList<Zbor> xx=A.AfiseazaZboruri();
		for(int j=0;j<xx.size();j++){
			if(xx.get(j).orasePlecare.equalsIgnoreCase(orasPlecare) && xx.get(j).oraseDestinatie.equalsIgnoreCase(orasDestinatie) 
					&& xx.get(j).dataPleacare.equalsIgnoreCase(dataPlecare) && xx.get(j).dataIntoarcere.equalsIgnoreCase(dataIntoarcere)) {
			gasit=true;
			}	
	}
		return gasit;
	}
	
	private boolean getDateTime(String dataPlecare) {
        DateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
        Date date = new Date();
        String data = new String();
        data = dateFormat.format(date).toString();
        String[] data2 = new String[3];
        String[] data3 = new String[3];
        data2 = data.split(" ");
        data3 = dataPlecare.split(" ");
        int luna = Integer.parseInt(data2[1]);       
        int lunaPlecare = Integer.parseInt(data3[1]);
       if(lunaPlecare-luna >2)
    	   return false;
       return true;
	}
}
