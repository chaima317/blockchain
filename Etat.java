package Blockchaine;

import java.util.ArrayList;
/**
 * 
 * @author chaimaabdellali
 * 
 */
public class Etat {
	
	ArrayList <Integer> individus ;
	/**
	 * cet attribut est le hashage de l'objet Etat s
	 */
	int hachEtat;

	public Etat() {
		individus=new ArrayList <Integer>();
	     hachEtat=hashCode();
		
	}
	
	  @Override
	    public int hashCode() {
		 
		  return individus .hashCode();
		  
	  }

	  public void add(int solde) {
		 this.individus.add(solde);
	  }
	
	public void afficher() {
		   System.out.print("les individus :");
	       individus.forEach(individus->System.out.println(individus));;
	}
}

