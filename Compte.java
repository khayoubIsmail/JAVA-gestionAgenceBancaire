import java.util.ArrayList;
import java.util.Date;

public class Compte {
	
	private String numero;
	private String codeClientAssocie;
	private String type;
	private double solde=0;
	private ArrayList<Date> logs=new ArrayList<Date>();
	
	public Compte()
	{
		
	}
	public Compte(String _numero, String _codeClientAssocie,String _type , double _solde )
	{
		this.numero=_numero;
		this.codeClientAssocie=_codeClientAssocie;
		this.type = _type;
		this.solde += _solde;
	}
	
	/***************************************************** proprietes **********************************************/
	public  ArrayList<Date> gelog(){return this.logs;}

	public String geType(){return this.type;}
	public void setType(String _newType ){this.type=_newType;}
	
	public String getNumero(){return this.numero;}
	//une fois compte créer , impossible de mdifier son numéro
	
	public String  getClientassocie(){return this.codeClientAssocie;}
	/*une fois uncompte créer , il doit associe à un seule compte jusqu'à la fin (suppression du client)
	  pour cela il faut éviter de modifier le code de Client Associe
	*/
	
	public double  getSolde(){return this.solde;}
	/*********/
	public void  VerserSolde(double _SoldeVerser )
	{
		this.solde += _SoldeVerser;
	}
	public void  RetirerSolde(double _SoldeRetirer )
	{
		this.solde -= _SoldeRetirer;
	}
	/************************************************************************************************************/
	/************************************ L'affichage des données ***********************************************/
	// Overriding toString() method of String class
    @Override
    public String toString() {
        return "Numéro 		  	: " + this.numero +
        		"\nCode de Client Associe  : " + this.codeClientAssocie +
        		"\nType 			: " + this.type +
        		"\nSolde 			: " + this.solde ;
    }

	/*********************/
	public String afficherCompte() {//Affichage sans \n
        return "\t-> Numéro : " + this.numero +
        		"\n\t------Code de Client Associe : " + this.codeClientAssocie +
        		"\n\t------Type : " + this.type +
        		"\n\t------Solde : " + this.solde ;
    }
    /*************************************************************************************************************/
}
