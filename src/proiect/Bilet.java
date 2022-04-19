package proiect;

public class Bilet {
	private Clasa1 clasa1 = new Clasa1();
	private Clasa2 clasa2 = new Clasa2();
	private Clasa3 clasa3 = new Clasa3();
	
	
	public Bilet() {
		
	}
	
	public int clasa1(){
		return clasa1.getPret();
	}
	
	public int clasa2(){
		return clasa2.getPret();
	}
	
	public int clasa3(){
		return clasa3.getPret();
	}
	
}
