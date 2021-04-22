package Blockchaine;

import java.util.ArrayList;

public class Blockchain {
	ArrayList<Bloc >blocs;
	/**
	 * cette variable représente le temps d'ajout du dernier bloc 
	 */
	
    public static long temps_ajout;
	public Blockchain() {
		this.blocs=new ArrayList<Bloc>();
		 temps_ajout=0;
	}

	public boolean add(Bloc e)  {
            



		// le bloc e a inserer doit se relier avec le bloc précéndent dpon con doit mettre a jour son previous hach 

		try {
			if(this.verif(e))
			{
				e.setPreviousHach(blocs.get((blocs.size())-1).hashCode());
				e.setHash(e.hasher());

				e.etatFinal.afficher();
				System.out.print("receveur="+e.etatFinal.individus.get(e.transactionsEffectuee.payeur));
				this.blocs.add(blocs.size(),e);
				this.temps_ajout=System.currentTimeMillis();
			    System.out.println("temps actuel d'ajour du dernier bloc :"+this.temps_ajout);
				return true ;
			}
		} catch (ExeptionFirstBloc e1) {

			e1.printStackTrace();
		}

		return false;
	}


	public boolean verif(Bloc e ) throws ExeptionFirstBloc {


		if(blocs.isEmpty())
		{
			if(e.transactionsEffectuee!=null)
				throw new ExeptionFirstBloc("la transition du premier bloc n'est pas null");
			return false;

		}
 //modifier 
		/**
		 * je dois vérifier que avec le size du dernier de l'etat du dernier bloc de la blockchain
		 */
		if(!(e.transactionsEffectuee.payeur < this.blocs.get(blocs.size()-1).etatFinal.individus.size() && e.transactionsEffectuee.receveur < this.blocs.get(blocs.size()-1).etatFinal.individus.size() ))
		{
			//je dois creer une exeption --> essayer de creer plusieirs exeptions ensemble dans la meme classe
			System.out.println("le recepteur ou le payeur n'existe pas dans ");
			return false ;
		}

		//if(e.transactionsEffectuee.payeur)
		if(e.etatFinal.individus.get(e.transactionsEffectuee.payeur)< e.etatFinal.individus.get(e.transactionsEffectuee.receveur))
		{   
			return false;
		}
		//mettre a jour le previoushach du bloc e a inserer 
		return true ;

	}
	/**
	 * 
	 * 
	 * @param difficulté
	 * @param sel
	 * @param bloc
	 * @return
	 */
   // false-->il existe un nombre"difficulté" de 0
	public boolean inserable (int difficulté, int sel , Bloc bloc ) {
		// on 
		long hach ;
		try {
			if(this.verif(bloc))
			{
				
				hach= bloc.hasher(sel);
				if( premier_chiffre(hach,difficulté));
					  return false;
			      
				
			}
		} catch (ExeptionFirstBloc e) {
		
			e.printStackTrace();
		}
		return true;
	}
	/**
	 * cette fonction vérifie si un chiffre commence oar n 0
	 * @param nombre de chiifre difficulté
	 * @param nbr_chiffre
	 * @return
	 */
	public boolean premier_chiffre(long n,int  nbr )
	{ 
		  
		
			int cnt = 0 ;
			if ( n == 0 ) return nbr == 1; 
			while(n % 2 == 0)
			{
				cnt ++;
				n /= 2; 
			}
			
			return cnt == nbr ; 
        		   
	}
		   
	

}
