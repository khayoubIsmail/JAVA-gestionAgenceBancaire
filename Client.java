
public class Client {
	private String code;
	private String nom;
	private String prenom;
	private String ville;
	
	private int nbrCompte=0;
	
	
	public Client() {}
	
	public Client(String _code, String _nom, String _prenom, String _ville)
	{
		this.code=_code;
		this.nom = _nom;
		this.prenom = _prenom;
		this.ville = _ville;		
	}
	
	/*********************************************** proprietes ***************************************************/
		public String getNom(){return this.nom;}
		public void setNom(String _newNom ){this.nom=_newNom;}
		
		public String getPrenom(){return this.prenom;}
		public void setPrenom(String _newPrenom ){this.prenom=_newPrenom;}
		
		public String  getVille(){return this.ville;}
		public void  setVille(String _newVille ){this.ville=_newVille;}
		
		public String  getCode(){return this.code;}
		/*Attention!! Une fois un Client, Employe ou Directeur sont Créer ,
		  impossible de modifier leurs Code*/

		public int getNbrCompte(){return this.nbrCompte;}
		public void incrementNbrCompte(){this.nbrCompte++;}
		public void decrementNbrCompte(){this.nbrCompte--;}
	/*************************************************************************************************************/
	/************************************ L'affichage des données ***********************************************/
		// Overriding toString() method of String class
	    @Override
	    public String toString() {
	        return "Code 	 : " + this.code +
	        		"\nNom   	 : " + this.nom +
	        		"\nPrenom   : " + this.prenom +
	        		"\nVille 	 : " + this.ville ;
	    }
	/*************************************************************************************************************/	
	
}

