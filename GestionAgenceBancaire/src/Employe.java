
public class Employe extends Client{
	private String fonction;
	
	public Employe()
	{
		
	}
	public Employe(String _code,String _nom , String _prenom , String _ville,String _fonction)
	{
		super(_code,_nom,_prenom,_ville);
		this.fonction=_fonction;
	}
	
	public Employe(String _fonction)
	{
		this.fonction=_fonction;
	}
	
	/********************************************** proprietes ****************************************************/
	public String getFonction(){return this.fonction;}
	public void setFonction(String value ){this.fonction=value;}
	/**************************************************************************************************************/
	// Overriding toString() method of String class
    @Override
    public String toString() {
        return super.toString() + 
        		"\nFonction : " + this.fonction;
    }
}
