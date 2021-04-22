package Blockchaine;

public class Transaction {
	int somme;
	int payeur;
	int receveur;
	
	  @Override
	 public int hashCode() {
		 return somme+payeur+receveur;
	 }

	public Transaction(int somme, int payeur, int receveur) {
		
		this.somme = somme;
		this.payeur = payeur;
		this.receveur = receveur;
	}
	

}
