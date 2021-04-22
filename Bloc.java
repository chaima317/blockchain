package Blockchaine;

public class Bloc {
	Etat etatFinal;
	Transaction transactionsEffectuee;
	private int sel ;
	private long hash;
	private int previousHach;
	public Bloc(Etat etatFinal, Transaction transactionsEffectuee) {

		this.etatFinal = etatFinal;
		this.transactionsEffectuee = transactionsEffectuee;
		//le sel représente le temps de l'insersion 
		this.sel=0;
		this.hash= this.hashCode();
		this.previousHach=0;
	}

	public int getSel() {
		return sel;
	}

	public void setSel(int sel) {
		this.sel = sel;
	}

	public long getHash() {
		return hash;
	}

	public void setHash(long hash) {
		this.hash = hash;
	}


	public long hasher() {
		return  this.hashCode()+sel+previousHach;
	}

	/**
	 * methode hacher qui prend un sel en argument cela nous evitera de changer le sel du bloc quand on executera   
	 * la méthode blockchain.indiserable 
	 * @return
	 */
	public long hasher(int sel ) {
		return  this.hashCode()+sel+previousHach;
	}
	public int getPreviousHach() {
		return previousHach;
	}

	public void setPreviousHach(int previousHach) {
		this.previousHach = previousHach;
	}

}
