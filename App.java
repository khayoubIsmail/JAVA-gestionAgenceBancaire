import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;

public class App {
	/***************************************************************************************************************/
	//global variable:
	public static int i; /*@param	i 	utilisée comme un compteur dans les boucle For */
	public static double soldeRetirerMax; /*@param 	soldeRetirerMax  solde Retirer Max par jour, si type de compte est épargne*/
	public static Scanner clavier = new Scanner(System.in);	
	/**************************************************************************************************************/
		public static final String yellow_background = "\033[43m"; // YELLOW background for Error
		public static final String RED_BOLD_BRIGHT = "\033[1;91m"; // red text using with yellow background
		
		public static final String white_background = "\033[47m";//WHITE background for Menu Titre
		public static final String text_blackBold = "\033[1;90m"; //pour le titre de Menu

		public static final String YELLOW_UNDERLINED = "\033[4;33m";

		public static final String blue_text = "\u001B[34m";

		//affichage de statut message - bien fait
		public static final String red_text = "\u001b[31m";
		public static final String green_text = "\u001b[32m";
		//

		public static final String white_underline = "\033[4;37m"; // text souligné pour le choix
		
		public static final String normal_Style = "\033[0m"; //	reset to normal background color
	/***************************************************************************************************************/
		public static int choix0 ;//pour choisir le type de user que vous entrer et login l'application , c'est un Directeur , Employe ou Client
		public static int choix01;//pour choisir sur laquel le directeur va appliquer ses tâches
		public static int choix010;//pour choisir une tâche va appliquer par le Directeur sur les Employes
		public static int choix0103;//pour choisir la information que le directeur peut modifier sur un employe
	/**************************************************************************************************************/
	/**************************************** instance de directeur ***********************************************/
	/**/																								   	    /**/
	/**/public static Directeur directeur=new Directeur("I123456", "khayoub", "ismail","Béni Mellal", "gérer l'agence"); 	    /**/
	/**/																								        /**/
	/**************************************************************************************************************/
	/**************************************************************************************************************/
	//Toutes les informations des Employés , des Clients et ses Comptes
		public static ArrayList<Client> clients=new ArrayList<Client>();
		public static ArrayList<Compte> comptes=new ArrayList<Compte>(); 
		public static ArrayList<Employe> employes=new ArrayList<Employe>();

	//historiquesRetirer : ArrayList pour stocker last operation retirer des comptes qui est de type épargne
	//chaque cellule de cette ArrayList est un Array de type Object[]
	//qui stock Object[]{numCompte,dateLastRetirer,soldeRetirerMax} .
	//la creation d'un Array et de l'ajouter dans ArrayList fait automatiquement 
	//après chaque operation d'ajoute d'un compte de type épargne par directeur ou employe
	//sans fonction ajouterCompte (fonction choix =  1 --> 13 -->130)
	//la modification fait sur dateLastRetirer après chaque opération de Retirer succés
	//la modification fait sur soldeRetirerMax après chaque opération de Retirer succés ,
	//ou affecter soldeRetirerMax=0 , si dateLastRetirer!=date.now().
		public static ArrayList<Object[]> historiquesRetirer = new ArrayList<Object[]>();
	/***************************************************************************************************************/
	//Methode Main

	public static void main(String[] args) throws Exception {
		/***********************************************************/
		/*
		 * @Autor 	: Khayoub ismail
		 * @App 	: Gestion d'Agence Bancaire
		 * @Version : 1.0
		 * ==> Project de Fin de Module Programmation Orientée Objet <==
		 * ==> Licence Professionnel Adiministrateur de Bases de Données <==
		 */
		/**********************************************************************************************************/
		//debut de programme :
		block1: while(true)
		{ //debut block1
		System.out.println(".---------------------------------------------------------------------------.");
		System.out.println(text_blackBold+white_background+"|"+String.format("%60s" , "Bonjour dans la gestion d'agence bancaire") + String.format("%16s" , "|") + normal_Style);
		System.out.println("|---------------------------------------------------------------------------|");
		System.out.println("|==> Vous êtes : " + String.format("%60s" , "|"));
		System.out.println("|"+String.format("%20s" , "1-Directeur") + String.format("%56s" , "|"));
		System.out.println("|"+String.format("%19s" , "2-Employee") + String.format("%57s" , "|"));
		System.out.println("|"+String.format("%17s" , "3-Client") + String.format("%59s" , "|"));
		System.out.println("|"+String.format("%19s" , "-1-Quitter ") + String.format("%57s" , "|"));
		System.out.println("*---------------------------------------------------------------------------*");
		/**********************************************************************************************************/
		// debut de demander enter un choix à partir de Menu précédent
		//choix0
		System.out.print(YELLOW_UNDERLINED+"\nVotre Choix = "+normal_Style);
		while(!clavier.hasNextInt())
		{
			
			System.out.println("\n"+yellow_background+text_blackBold+"Attention!! Votre choix doit être de type Inreger"+normal_Style+"\n");
			System.out.print(YELLOW_UNDERLINED+"Re-entrez choix = "+normal_Style);
			clavier.nextLine();
		}
		choix0 = clavier.nextInt();
		clavier.nextLine(); /*cette ligne est obligatoir après chaque lecture d'un number (int,double,..),
							* pour éviter les problems de lecture un ensembles des mots de type String 
							* avec clavier.nextLine() après clavier.nextInt() ou clavier.nextDouble();
							* c'est vous utilisez clavier.next() pour la lecture d'un ensembles des motes
							* sa décleche un proleme à la lecture
							*/
		//System.out.println("choix0="+choix0 +" Classe : "+((Object) choix0).getClass().getSimpleName());
		/**********************************************************************************************************/
		/**********************************************************************************************************/
		switch (choix0) 
		{ //debut switch choix0
			/**********************************************************************************************************/
			/**********************************************************************************************************/
			//Gestion Directeur
			case 1: //debut (choix1 = case 1) - Gestion de Directeur
				/* --------------login directeur-----------------*/
				System.out.print("\nEntrez votre Code (I123456 -- pour tester) : ");
				while(!clavier.hasNextLine())
				{
					System.out.println("\n"+yellow_background+text_blackBold+"Attention!! Code doit être de type String"+normal_Style+"\n");
					
					System.out.print(YELLOW_UNDERLINED+"Re-entrez Code = "+normal_Style);
					clavier.nextLine();
				}
				String codeD = clavier.nextLine(); //codeD --> code de directeur (en utilise CIN , comme code de directeur)
				//System.out.println("codeD="+codeD);

				System.out.print("Entrez votre Nom (khayoub -- pour tester) : ");
				while(!clavier.hasNextLine())
				{
					System.out.print("\n"+"\n"+yellow_background+text_blackBold+"Attention!! Nom doit être de type String "+normal_Style+"\n");
					System.out.print(YELLOW_UNDERLINED+"Re-entrez Nom = "+normal_Style);
					clavier.nextLine();
				}
				String nomD = clavier.nextLine();
				nomD=nomD.strip().toLowerCase();
				//System.out.println("nomD="+nomD);
				
				if (directeur.getNom().equals(nomD) && directeur.getCode().equals(codeD)) 
				{ //debut if - Si login Directeur Correct -- directeur existe
					/* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
					/* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
					/* +++++++++++++++++Les tâches qui peut être executer par le Directeur+++++++++++++++++++++++*/
					tachesDirecteur: while (choix0 == 1) 
					{//debut tachesDirecteur
						System.out.println(".---------------------------------------------------------------------------.");
						System.out.println(text_blackBold + white_background + "|"
								+ String.format("%38s", "Bonjour " + directeur.getNom())+"("+directeur.getClass().getSimpleName()+")"+ String.format("%27s", "|")
								+ normal_Style);
						System.out.println("|---------------------------------------------------------------------------|");
						System.out.println("|==> Vous voulez gérer : " + String.format("%52s", "|"));
						System.out.println("|" + String.format("%26s", "11-Employes") + String.format("%50s", "|"));
						System.out.println("|" + String.format("%25s", "12-Clients") + String.format("%51s", "|"));
						System.out.println("|" + String.format("%25s", "13-Comptes") + String.format("%51s", "|"));
						System.out.println("|" + String.format("%32s", "0-Menu Principale") + String.format("%44s", "|"));
						System.out.println("|" + String.format("%25s" , "-1-Quitter ") + String.format("%51s" , "|"));
						System.out.println("*---------------------------------------------------------------------------*");
						System.out.print(YELLOW_UNDERLINED + "\nVotre Choix = " + normal_Style);
						while(!clavier.hasNextInt())
						{
							System.out.print("\n"+yellow_background+text_blackBold+"Attention!! Votre choix doit être de type Integer"+normal_Style+"\n");
							
							System.out.print(YELLOW_UNDERLINED+"Re-entrez choix = "+normal_Style);
							clavier.nextLine();
						}
						choix01 = clavier.nextInt();
						clavier.nextLine();
						switch (choix01) 
						{//debut switch choix01
							case 11://Les tâches faire par directeur sur employes
									tachesDirecteurEmployes: while (choix01 == 11) 
									{// debut tachesDirecteurEmployes
									System.out.println(".---------------------------------------------------------------------------.");
									System.out.println(text_blackBold + white_background + "|"+ String.format("%38s", "User : " + directeur.getNom()) + "("+ directeur.getClass().getSimpleName() + ")" + String.format("%27s", "|") + normal_Style);
									System.out.println("|---------------------------------------------------------------------------|");
									System.out.println("|==> Que vous voulez faire : " + String.format("%48s", "|"));
									System.out.println("|" + String.format("%50s", "110-Ajouter un nouvel employé")+String.format("%26s", "|"));
									System.out.println("|" + String.format("%72s", "111-Afficher les informations de touts les employés")+ String.format("%4s", "|"));
									System.out.println("|" + String.format("%63s", "112-Afficher les informations d'un employé")+ String.format("%13s", "|"));
									System.out.println("|" + String.format("%63s", "113-modifier les informations d'un employé")+ String.format("%13s", "|"));
									System.out.println("|" + String.format("%45s", "114-Supprimer un employé")+ String.format("%31s", "|"));
									System.out.println("|" + String.format("%48s", "99-Retour au menu précédent")+ String.format("%28s", "|"));
									System.out.println("|" + String.format("%38s", "0-Menu Principale")+ String.format("%38s", "|"));
									System.out.println("|" + String.format("%31s" , "-1-Quitter ") + String.format("%45s" , "|"));
									System.out.println("*---------------------------------------------------------------------------*");
									System.out.print(YELLOW_UNDERLINED + "\nVotre Choix = " + normal_Style);
									while(!clavier.hasNextInt())
									{
										System.out.print("\n"+yellow_background+text_blackBold+"Attention!! Choix doit être de type Integer "+normal_Style+"\n");
										
										System.out.print(YELLOW_UNDERLINED+"Re-entrez choix = "+normal_Style);
										clavier.nextLine();
									}
									choix010 = clavier.nextInt();
									clavier.nextLine();
									switch (choix010) { //debut switch choix010
										case 110:
											//Appelle finction choix = 1 --> 11 -->110
											ajouterEmploye(employes);
											break;
										case 111:
											//Appele fonction choix = 1 --> 11 --> 111
											afficherToutsEmployes(employes);
											break;
										case 112:
											//Appelle fonction choix = 1 --> 11 --> 112
											afficherEmploye(employes);
											break;
										case 113:
											//Appelle fonction choix = 1 --> 11 --> 113
											//modifierEmploye(employes);
											System.out.println("\n#La modification des informations d'un Employer");
											System.out.print("##Entrer le code de l'employe que vous voulez modifié: ");
											String codeEmployeModifier= clavier.nextLine();
											if(employeExiste(codeEmployeModifier, employes))
											{//employe existe --> debut de traitement de modification d'un employe par le directeur 
												choixInfoEmployeModifier: while (choix010==113) 
												{// debut boucle while --> label : choixInfoEmployeModifier
													System.out.println(".---------------------------------------------------------------------------.");
													System.out.println(text_blackBold + white_background + "|"+ String.format("%38s", "User : " + directeur.getNom()) + "("+ directeur.getClass().getSimpleName() + ")" + String.format("%27s", "|") + normal_Style);
													System.out.println("|---------------------------------------------------------------------------|");
													System.out.println("|==> Quelle est l'information que vous voulez modifier : " + String.format("%20s", "|"));
													System.out.println("|" + String.format("%31s", "1131-Nom")+String.format("%45s", "|"));
													System.out.println("|" + String.format("%34s", "1132-Prenom")+ String.format("%42s", "|"));
													System.out.println("|" + String.format("%33s", "1133-Ville")+ String.format("%43s", "|"));
													System.out.println("|" + String.format("%36s", "1134-Fonction")+ String.format("%40s", "|"));
													System.out.println("|" + String.format("%50s", "99-Retour au menu précédent")+ String.format("%26s", "|"));
													System.out.println("|" + String.format("%40s", "0-Menu Principale")+ String.format("%36s", "|"));
													System.out.println("|"+String.format("%33s" , "-1-Quitter ") + String.format("%43s" , "|"));
													System.out.println("*---------------------------------------------------------------------------*");
													System.out.print(YELLOW_UNDERLINED + "\nVotre Choix = " + normal_Style);
													while(!clavier.hasNextInt())
													{
														System.out.print("\n"+yellow_background+text_blackBold+"Attention!! Votre choix doit être de type Integer"+normal_Style+"\n");
														
														System.out.print(YELLOW_UNDERLINED+"Re-entrez choix = "+normal_Style);
														clavier.nextLine();
													}
													choix0103 = clavier.nextInt();
													clavier.nextLine();
													for(i=0 ; i<employes.size() ; i++)
													{//debut boucler sur toutes les employes
														if(employes.get(i).getCode().equals(codeEmployeModifier))
														{//debut capturer l'emplye que leur code egale à codeEmployeModifier
														int firstChar;
															switch(choix0103)
															{//debut switch choix0103
																case 1131 : 
																	System.out.println("Nom actuel : " + employes.get(i).getNom());
																	System.out.print("Entrer le nouveau Nom : ");
																	//*/
																	while(!clavier.hasNext())
																	{
																		System.out.print("\n"+yellow_background+text_blackBold+"Nom de nouvel employé doit être de type String"+normal_Style+"\n");
																		System.out.print(YELLOW_UNDERLINED+"Re-entrez nom = "+normal_Style);
																		clavier.nextLine();
																	}
																	String nomNouveauEmploye = clavier.nextLine();
																	nomNouveauEmploye=nomNouveauEmploye.strip().toLowerCase();
																	firstChar=(nomNouveauEmploye.charAt(0)- '0');
																	for(int i = 0;i<nomNouveauEmploye.length();i++)
																	{
																		if(firstChar>=0 && firstChar<=9)
																		{
																			System.out.println("\n"+yellow_background+text_blackBold+"Attention!! Nom de nouvel employé doit être de type String"+normal_Style+"\n");
																			continue choixInfoEmployeModifier;
																		}
																	}
																	//*
																	employes.get(i).setNom(nomNouveauEmploye);
																	System.out.println(green_text+"la modification de nom est bien fait"+normal_Style);
																	break;
																case 1132 : 
																	System.out.println("\nPrenom actuel : " + employes.get(i).getPrenom());
																	System.out.print("Entrer le nouveau Prenom : ");
																	//*/
																	while(!clavier.hasNext())
																	{
																		System.out.print("\n"+yellow_background+text_blackBold+"Prénom de nouvel employé doit être de type String"+normal_Style+"\n");
																		System.out.print(YELLOW_UNDERLINED+"Re-entrez Prenom = "+normal_Style);
																		clavier.nextLine();
																	}
																	String prenomNouveauEmploye = clavier.nextLine();
																	prenomNouveauEmploye=prenomNouveauEmploye.strip().toLowerCase();
																	firstChar=(prenomNouveauEmploye.charAt(0)- '0');
																	for(int i = 0;i<prenomNouveauEmploye.length();i++)
																	{
																		if(firstChar>=0 && firstChar<=9)
																		{
																			System.out.println("\n"+yellow_background+text_blackBold+"Attention!! Prénom de nouvel employé doit être de type String"+normal_Style+"\n");
																			continue choixInfoEmployeModifier;
																		}
																	}
																	//*/
																	employes.get(i).setPrenom(prenomNouveauEmploye);
																	System.out.println(green_text+"la modification de prénom est bien fait"+normal_Style);
																	break;
																case 1133 : 
																	System.out.println("Ville actuel : " + employes.get(i).getVille());
																	System.out.print("Entrer le nouveau Ville : ");
																	//*/
																	while(!clavier.hasNext())
																	{
																		System.out.print("\n"+yellow_background+text_blackBold+"Ville de nouvel employé doit être de type String"+normal_Style+"\n");
																		System.out.print(YELLOW_UNDERLINED+"Re-entrez Ville = "+normal_Style);
																		clavier.nextLine();
																	}
																	String villeNouveauEmploye = clavier.nextLine();
																	villeNouveauEmploye=villeNouveauEmploye.strip().toLowerCase();
																	firstChar=(villeNouveauEmploye.charAt(0)- '0');
																	for(int i = 0;i<villeNouveauEmploye.length();i++)
																	{
																		if(firstChar>=0 && firstChar<=9)
																		{
																			System.out.println("\n"+yellow_background+text_blackBold+"Attention!! Ville de nouvel employé doit être de type String"+normal_Style+"\n");
																			continue choixInfoEmployeModifier;
																		}
																	}
																	//*/
																	employes.get(i).setVille(villeNouveauEmploye);
																	System.out.println(green_text+"la modification de ville est bien fait"+normal_Style);
																	break;
																case 1134 : 
																	System.out.println("Fonction actuel : " + employes.get(i).getFonction());
																	System.out.print("Entrer le nouveau Fonction : ");
																	//*/
																	while(!clavier.hasNext())
																	{
																		System.out.print("\n"+yellow_background+text_blackBold+"Fonction de nouvel employé doit être de type String"+normal_Style+"\n");
																		System.out.print(YELLOW_UNDERLINED+"Re-entrez Fonction = "+normal_Style);
																		clavier.nextLine();
																	}
																	String fonctionNouveauEmploye = clavier.nextLine();
																	fonctionNouveauEmploye=fonctionNouveauEmploye.strip().toLowerCase();
																	firstChar=(fonctionNouveauEmploye.charAt(0)- '0');
																	for(int i = 0;i<fonctionNouveauEmploye.length();i++)
																	{
																		if(firstChar>=0 && firstChar<=9)
																		{
																			System.out.println("\n"+yellow_background+text_blackBold+"Attention!! Fonction de nouvel employé doit être de type String"+normal_Style+"\n");
																			continue choixInfoEmployeModifier;
																		}
																	}
																	//*/
																	employes.get(i).setFonction(fonctionNouveauEmploye);
																	System.out.println(green_text+"la modification de fonction est bien fait"+normal_Style);
																	break;
																case 99:
																	System.out.println(green_text+"Retour au menu précédent"+normal_Style);
																	continue tachesDirecteurEmployes;
																case 0:
																	System.out.println(green_text+"Retour au Menu Principale"+normal_Style);
																	continue block1;
																case -1:
																	System.out.println(blue_text+"à bientôt"+normal_Style);
																	break block1;
																default:
																System.out.println("\n"+RED_BOLD_BRIGHT + yellow_background+ "==> Attention!! numéro de choix entrer n'existe pas <==" + normal_Style);
																	break;
															}//fin switch choix0103
														}//fin capturer l"emplye que leur code egale à codeEmployeModifier
													}//fin boucler sur toutes les employes
												}//fin boucle while --> label : choixInfoEmployeModifier
											}//fin de traitement de modification d'un employe par le directeur
											else
											{//debut else - employe à modifier n'existe pas
												System.out.println(red_text+"Attention !! l'employe que vous voulez modifier n'existe pas"+normal_Style);
											}//fin else - employe à modifier n'existe pas
										break;
										case 114:
											//appelle fonction  choix = 1 --> 11 --> 114
											supprimerEmploye(employes);
											break;
										case 99:
											System.out.println(green_text+"Retour au menu précédent"+normal_Style);
											continue tachesDirecteur;
										case 0:
											System.out.println(green_text+"Retour au Menu Principale"+normal_Style);
											continue block1;
										case -1:
											System.out.println(blue_text+"à bientôt"+normal_Style);
											break block1;
										default:
										System.out.println("\n"+RED_BOLD_BRIGHT + yellow_background+ "==> Attention!! numéro de choix entrer n'existe pas <==" + normal_Style);
											break;

									}//fin switch choix010
								} // fin tachesDirecteurEmployes
								break;
							case 12://Les tâches faire par directeur sur clients
									tachesDirecteurClients: while (choix01 == 12) 
									{// debut tachesDirecteurClients
										System.out.println(".---------------------------------------------------------------------------.");
										System.out.println(text_blackBold + white_background + "|"+ String.format("%38s", "User : " + directeur.getNom()) + "("+ directeur.getClass().getSimpleName() + ")" + String.format("%27s", "|") + normal_Style);
										System.out.println("|---------------------------------------------------------------------------|");
										System.out.println("|==> Que vous voulez faire : " + String.format("%48s", "|"));
										System.out.println("|" + String.format("%51s", "120-Ajouter un nouveau client")+String.format("%25s", "|"));
										System.out.println("|"+ String.format("%73s", "121-Afficher les informations de toutes les clients")+ String.format("%3s", "|"));
										System.out.println("|" + String.format("%63s", "122-Afficher les informations d'un client")+ String.format("%13s", "|"));
										System.out.println("|" + String.format("%63s", "123-Modifier les informations d'un client")+ String.format("%13s", "|"));
										System.out.println("|" + String.format("%45s", "124-Supprimer un client")+ String.format("%31s", "|"));
										System.out.println("|" + String.format("%49s", "99-Retour au menu précédent")+ String.format("%27s", "|"));
										System.out.println("|" + String.format("%39s", "0-Menu Principale")+ String.format("%37s", "|"));
										System.out.println("|"+String.format("%32s" , "-1-Quitter ") + String.format("%44s" , "|"));
										System.out.println("*---------------------------------------------------------------------------*");
										System.out.print(YELLOW_UNDERLINED + "\nVotre Choix = " + normal_Style);
										while(!clavier.hasNextInt())
										{
											System.out.print("\n"+yellow_background+text_blackBold+"Attention!! Choix doit être de type Integer"+normal_Style+"\n");
											
											System.out.print(YELLOW_UNDERLINED+"Re-entrez choix = "+normal_Style);
											clavier.nextLine();
										}
										choix010 = clavier.nextInt();
										clavier.nextLine();
										switch (choix010) { //debut switch choix010
											case 120:
												//Appelle finction choix = 1 --> 12 -->120
												ajouterClient(clients);
												break;
											case 121:
												//Appele fonction choix = 1 --> 12 --> 121
												afficherToutesClients(clients);
												break;
											case 122:
												//Appelle fonction choix = 1 --> 12 --> 122
												afficherClient(clients);
												break;
											case 123:
												//modification informations de clients par le directeur
												System.out.println("\n#La modification des informations d'un Client");
												System.out.print("##Entrer le code de client que vous voulez :");
												String codeClientModifier = clavier.nextLine();
												if(clientExiste(codeClientModifier, clients))
												{//client existe --> debut de traitement de modification d'un client par le directeur 
													choixInfoClientModifier: while (choix010==123) 
													{// debut boucle while --> label : choixInfoClientModifier
														System.out.println(".---------------------------------------------------------------------------.");
														System.out.println(text_blackBold + white_background + "|"+ String.format("%38s", "User : " + directeur.getNom()) + "("+ directeur.getClass().getSimpleName() + ")" + String.format("%27s", "|") + normal_Style);
														System.out.println("|---------------------------------------------------------------------------|");
														System.out.println("|==> Quelle est l'information que vous voulez modifier : " + String.format("%20s", "|"));
														System.out.println("|" + String.format("%31s", "1231-Nom")+String.format("%45s", "|"));
														System.out.println("|" + String.format("%34s", "1232-Prenom")+ String.format("%42s", "|"));
														System.out.println("|" + String.format("%33s", "1233-Ville")+ String.format("%43s", "|"));
														System.out.println("|" + String.format("%50s", "99-Retour au menu précédent")+ String.format("%26s", "|"));
														System.out.println("|" + String.format("%40s", "0-Menu Principale")+ String.format("%36s", "|"));
														System.out.println("|"+String.format("%33s" , "-1-Quitter ") + String.format("%43s" , "|"));
														System.out.println("*---------------------------------------------------------------------------*");
														System.out.print(YELLOW_UNDERLINED + "\nVotre Choix = " + normal_Style);
														while(!clavier.hasNextInt())
														{
															System.out.print("\n"+yellow_background+text_blackBold+"Attention!! Choix doit être de type Integer"+normal_Style+"\n");
															
															System.out.print(YELLOW_UNDERLINED+"Re-entrez choix = "+normal_Style);
															clavier.nextLine();
														}
														choix0103 = clavier.nextInt();
														clavier.nextLine();
														for(i=0 ; i<clients.size() ; i++)
														{//debut boucler sur toutes les clients
															if(clients.get(i).getCode().equals(codeClientModifier))
															{//debut capturer le client que leur code egale à codeClientsModifier
															int firstChar;
																switch(choix0103)
																{//debut switch choix0103
																	case 1231 : 
																		System.out.println("Nom actuel : " + clients.get(i).getNom());
																		System.out.print("Entrer le nouveau Nom : ");
																		//*/
																		while(!clavier.hasNext())
																		{
																			System.out.print("\n"+yellow_background+text_blackBold+"Nom de nouvel Client doit être de type String"+normal_Style+"\n");
																			System.out.print(YELLOW_UNDERLINED+"Re-entrez nom = "+normal_Style);
																			clavier.nextLine();
																		}
																		String nomNouveauClient = clavier.nextLine();
																		nomNouveauClient=nomNouveauClient.strip().toLowerCase();
																		firstChar=(nomNouveauClient.charAt(0)- '0');
																		for(int i = 0;i<nomNouveauClient.length();i++)
																		{
																			if(firstChar>=0 && firstChar<=9)
																			{
																				System.out.println("\n"+yellow_background+text_blackBold+"Attention!! Nom de nouvel Client doit être de type String"+normal_Style+"\n");
																				continue choixInfoClientModifier;
																			}
																		}
																		//*/
																		clients.get(i).setNom(nomNouveauClient);
																		System.out.println(green_text+"la modification de nom est bien fait"+normal_Style);
																		break;
																	case 1232 : 
																		System.out.println("Prenom actuel : " + clients.get(i).getPrenom());
																		System.out.print("Entrer le nouveau Prenom : ");
																		//*/
																		while(!clavier.hasNext())
																		{
																			System.out.print("\n"+yellow_background+text_blackBold+"Prénom de nouvel Client doit être de type String"+normal_Style+"\n");
																			System.out.print(YELLOW_UNDERLINED+"Re-entrez Prenom = "+normal_Style);
																			clavier.nextLine();
																		}
																		String prenomNouveauClient = clavier.nextLine();
																		prenomNouveauClient=prenomNouveauClient.strip().toLowerCase();
																		firstChar=(prenomNouveauClient.charAt(0)- '0');
																		for(int i = 0;i<prenomNouveauClient.length();i++)
																		{
																			if(firstChar>=0 && firstChar<=9)
																			{
																				System.out.println("\n"+yellow_background+text_blackBold+"Attention!! Prénom de nouvel Client doit être de type String"+normal_Style+"\n");
																				continue choixInfoClientModifier;
																			}
																		}
																		//*/
																		clients.get(i).setPrenom(prenomNouveauClient);
																		System.out.println(green_text+"la modification de prénom est bien fait"+normal_Style);
																		break;
																	case 1233 : 
																		System.out.println("Ville actuel : " + clients.get(i).getVille());
																		System.out.print("Entrer la nouvel Ville : ");
																		//*/
																		while(!clavier.hasNext())
																		{
																			System.out.print("\n"+yellow_background+text_blackBold+"Ville de nouvel Client doit être de type String"+normal_Style+"\n");
																			System.out.print(YELLOW_UNDERLINED+"Re-entrez Ville = "+normal_Style);
																			clavier.nextLine();
																		}
																		String villeNouveauClient = clavier.nextLine();
																		villeNouveauClient=villeNouveauClient.strip().toLowerCase();
																		firstChar=(villeNouveauClient.charAt(0)- '0');
																		for(int i = 0;i<villeNouveauClient.length();i++)
																		{
																			if(firstChar>=0 && firstChar<=9)
																			{
																				System.out.println("\n"+yellow_background+text_blackBold+"Attention!! Ville de nouvel Client doit être de type String"+normal_Style+"\n");
																				continue choixInfoClientModifier;
																			}
																		}
																		//*/
																		clients.get(i).setVille(villeNouveauClient);
																		System.out.println(green_text+"la modification de ville est bien fait"+normal_Style);
																		break;
										
																	case 99:
																		System.out.println(green_text+"Retour au menu précédent"+normal_Style);
																		continue tachesDirecteurClients;
																	case 0:
																		System.out.println(green_text+"Retour Menu Principale"+normal_Style);
																		continue block1;
																	case -1:
																		System.out.println(blue_text+"à bientôt"+normal_Style);
																		break block1;
																	default:
																		System.out.println("\n"+RED_BOLD_BRIGHT + yellow_background+ "==> Attention!! numéro de choix entrer n'existe pas <==" + normal_Style);

																		break;
																}//fin switch choix0103
															}//fin capturer l'client que leur code egale à codeClientModifier
														}//fin boucler sur toutes les clients
													}//fin boucle while --> label : choixInfoClientModifier
												}//fin de traitement de modification d'un client par le directeur
												else
												{//debut else - client à modifier n'existe pas
													System.out.println(red_text+"Attention !! le client que vous voulez modifier n'existe pas"+normal_Style);
												}//fin else - client à modifier n'existe pas
											break;
											case 124:
												//appelle fonction  choix = 1 --> 12 --> 124
												supprimerClient(clients,comptes);
												break;
											case 99:
												System.out.println(green_text+"Retour au menu précédent"+normal_Style);
												continue tachesDirecteur;
											case 0:
												System.out.println(green_text+"Retour au Menu Principale"+normal_Style);
												continue block1;
											case -1:
												System.out.println(blue_text+"à bientôt"+normal_Style);
												break block1;
											default:
												System.out.println("\n"+RED_BOLD_BRIGHT + yellow_background+ "==> Attention!! numéro de choix entrer n'existe pas <==" + normal_Style);
												break;
	
										}//fin switch choix010
								} // fin tachesDirecteurClients
								break;
							case 13://Les tâches faire par directeur sur comptes
								//tachesDirecteurComptes: 
								while (choix01 == 13)
								{// debut tachesDirecteurComptes
										System.out.println(".---------------------------------------------------------------------------.");
										System.out.println(text_blackBold + white_background + "|"+ String.format("%38s", "User : " + directeur.getNom()) + "("+ directeur.getClass().getSimpleName() + ")" + String.format("%27s", "|") + normal_Style);
										System.out.println("|---------------------------------------------------------------------------|");
										System.out.println("|==> Que vous voulez faire : " + String.format("%48s", "|"));
										System.out.println("|" + String.format("%51s", "130-Ajouter un nouveau Compte")+String.format("%25s", "|"));
										System.out.println("|"+ String.format("%73s", "131-Afficher les informations de toutes les comptes")+ String.format("%3s", "|"));
										System.out.println("|" + String.format("%65s", "132-Afficher Toutes les comptes d'un client")+ String.format("%11s", "|"));
										System.out.println("|" + String.format("%55s", "133-Verser un solde sur un compte")+ String.format("%21s", "|"));
										System.out.println("|" + String.format("%45s", "134-Supprimer un compte")+ String.format("%31s", "|"));
										System.out.println("|" + String.format("%49s", "99-Retour au menu précédent")+ String.format("%27s", "|"));
										System.out.println("|" + String.format("%39s", "0-Menu Principale")+ String.format("%37s", "|"));
										System.out.println("|"+String.format("%32s" , "-1-Quitter ") + String.format("%44s" , "|"));
										System.out.println("*---------------------------------------------------------------------------*");
										System.out.print(YELLOW_UNDERLINED + "\nVotre Choix = " + normal_Style);
										while(!clavier.hasNextInt())
										{
											System.out.print("\n"+yellow_background+text_blackBold+"Attention!! Choix doit être de type Integer"+normal_Style+"\n");
											
											System.out.print(YELLOW_UNDERLINED+"Re-entrez choix = "+normal_Style);
											clavier.nextLine();
										}
										choix010 = clavier.nextInt();
										clavier.nextLine();
										switch (choix010) { //debut switch choix010
											case 130:
												//Appelle finction choix = 1 --> 13 -->130
												ajouterCompte(clients,comptes);
												break;
											case 131:
												//Appele fonction choix = 1 --> 13 --> 131
												afficherToutesComptes(comptes);
												break;
											case 132:
												//Appelle fonction choix = 1 --> 13 --> 132
												afficherToutesComptesClient(clients,comptes);
												break;
											case 133:
												//
												Employe_directeur_VerserSoldeClientCompte(clients,comptes);
												break;
											case 134:
												//appelle fonction  choix = 1 --> 13 --> 134
												supprimerComptes(clients,comptes);
												break;
											case 99:
												System.out.println(green_text+"Retour au menu précédent"+normal_Style);
												continue tachesDirecteur;
											case 0:
												System.out.println(green_text+"Retour Menu Principale"+normal_Style);
												continue block1;
											case -1:
												System.out.println(blue_text+"à bientôt"+normal_Style);
												break block1;
											default:
												System.out.println("\n"+RED_BOLD_BRIGHT + yellow_background+ "==> Attention!! numéro de choix entrer n'existe pas <==" + normal_Style);
												break;
	
										}//fin switch choix010
								
								} // fin tachesDirecteurComptes
								break;
							case 0:
								continue block1;
							case -1:
								System.out.println(blue_text+"à bientôt"+normal_Style);
								break block1;
							default:
								System.out.println(RED_BOLD_BRIGHT + yellow_background
										+ "==> Attention!! numéro de choix entrer n'existe pas <==" + normal_Style);
								break;
						} //fin switch choix01

					} // fin tachesDirecteur

				} //debut if - Si login Directeur Correct
				else//debut else - Si login de directeur incorrect
				{
					System.out.println(red_text+ "==> Attention !! nom ou code incorrect <==" + normal_Style);
					continue block1;
				} //fin else - Si login de directeur incorrect
				/* --------------------------------------------------------------------------------*/
				;
				break;
			/**********************************************************************************************************/
			/**********************************************************************************************************/
			/**********************************************************************************************************/
			/**********************************************************************************************************/
			/**********************************************************************************************************/
			/**********************************************************************************************************/
			/**********************************************************************************************************/
			/**********************************************************************************************************/
			/**********************************************************************************************************/
			/**********************************************************************************************************/
			/**********************************************************************************************************/
			/**********************************************************************************************************/
			//Gestion employes
			case 2:
				/* --------------login employe-----------------------------------------------------*/
				System.out.print("\nEntrez votre code : ");
				String codeEmp = clavier.nextLine();
				System.out.print("\nEntrez votre nom : ");
				String nomEmp = clavier.nextLine();
				
				boolean EmployeExiste = false;
				for (i = 0; i < employes.size(); i++) 
				{
					int indexEmp = i;
					if (employes.get(i).getNom().equals(nomEmp) && employes.get(i).getCode().equals(codeEmp))
					{
						
						/* +++++++++++++++++Choix d'une tache à faire+++++++++++++++++++++++*/
						tachesEmploye: while (choix0 == 2) 
						{//debut tachesEmploye
							//System.out.println("employe existe");
							EmployeExiste = true;
							System.out.println(".---------------------------------------------------------------------------.");
							System.out.println(text_blackBold + white_background + "|"
									+ String.format("%45s", "Bonjour " + employes.get(indexEmp).getNom())+"(" +employes.get(indexEmp).getClass().getSimpleName()+ ")"+String.format("%22s", "|")
									+ normal_Style);
							System.out.println("|---------------------------------------------------------------------------|");
							System.out.println("|==> Vous voulez gérer : " + String.format("%52s", "|"));
							System.out.println("|" + String.format("%25s", "21-Clients") + String.format("%51s", "|"));
							System.out.println("|" + String.format("%25s", "22-Comptes") + String.format("%51s", "|"));
							System.out.println("|" + String.format("%32s", "0-Menu Principale") + String.format("%44s", "|"));
							System.out.println("|"+String.format("%25s" , "-1-Quitter ") + String.format("%51s" , "|"));
							System.out.println("*---------------------------------------------------------------------------*");
							System.out.print(YELLOW_UNDERLINED + "\nVotre Choix = " + normal_Style);
							while(!clavier.hasNextInt())
									{
										System.out.print("\n"+yellow_background+text_blackBold+"Attention!! Choix doit être de type Integer"+normal_Style+"\n");
										
										System.out.print(YELLOW_UNDERLINED+"Re-entrez choix = "+normal_Style);
										clavier.nextLine();
									}
							choix01 = clavier.nextInt();
							clavier.nextLine();
							switch (choix01) {//debut switch choix01
								case 21://Les tâches faire par employe sur clients
										tachesEmployeClients: while (choix01 == 21) 
										{// debut tachesEmployeClients
											System.out.println(".---------------------------------------------------------------------------.");
											System.out.println(text_blackBold + white_background + "|"+ String.format("%38s", "User : " + employes.get(indexEmp).getNom()) + "("+ employes.get(indexEmp).getClass().getSimpleName() + ")" + String.format("%29s", "|") + normal_Style);
											System.out.println("|---------------------------------------------------------------------------|");
											System.out.println("|==> Que vous voulez faire : " + String.format("%48s", "|"));
											System.out.println("|" + String.format("%51s", "210-Ajouter un nouveau client")+String.format("%25s", "|"));
											System.out.println("|"+ String.format("%73s", "211-Afficher les informations de toutes les clients")+ String.format("%3s", "|"));
											System.out.println("|" + String.format("%63s", "212-Afficher les informations d'un client")+ String.format("%13s", "|"));
											System.out.println("|" + String.format("%63s", "213-modifier les informations d'un client")+ String.format("%13s", "|"));
											System.out.println("|" + String.format("%45s", "214-Supprimer un client")+ String.format("%31s", "|"));
											System.out.println("|" + String.format("%49s", "99-Retour au menu précédent")+ String.format("%27s", "|"));
											System.out.println("|" + String.format("%39s", "0-Menu Principale")+ String.format("%37s", "|"));
											System.out.println("|"+String.format("%32s" , "-1-Quitter ") + String.format("%44s" , "|"));
											System.out.println("*---------------------------------------------------------------------------*");
											System.out.print(YELLOW_UNDERLINED + "\nVotre Choix = " + normal_Style);
											while(!clavier.hasNextInt())
												{
													System.out.print("\n"+yellow_background+text_blackBold+"Attention!! Choix doit être de type Integer"+normal_Style+"\n");
													
													System.out.print(YELLOW_UNDERLINED+"Re-entrez choix = "+normal_Style);
													clavier.nextLine();
												}
											choix010 = clavier.nextInt();
											clavier.nextLine();
											switch (choix010) { //debut switch choix010
												case 210:
													//Appelle finction choix = 1 --> 21 -->210
													ajouterClient(clients);
													break;
												case 211:
													//Appele fonction choix = 1 --> 21 --> 211
													afficherToutesClients(clients);
													break;
												case 212:
													//Appelle fonction choix = 1 --> 21 --> 212
													afficherClient(clients);
													break;
												case 213:
													//modification informations de clients par l'employe

													System.out.println("\n#La modification des informations d'un Client");
													System.out.print("##Entrer le code d'client que vous voulez :");
													String codeClientModifier = clavier.nextLine();
													if(clientExiste(codeClientModifier, clients))
													{//client existe --> debut de traitement de modification d'un client par l'employe 
														choixInfoClientModifier: while (choix010==213) 
														{// debut boucle while --> label : choixInfoClientModifier
															System.out.println(".---------------------------------------------------------------------------.");
															System.out.println(text_blackBold + white_background + "|"+ String.format("%38s", "User : " + employes.get(indexEmp).getNom()) + "("+ employes.get(indexEmp).getClass().getSimpleName() + ")" + String.format("%31s", "|") + normal_Style);
															System.out.println("|---------------------------------------------------------------------------|");
															System.out.println("|==> Quelle est l'information que vous voulez modifier : " + String.format("%20s", "|"));
															System.out.println("|" + String.format("%31s", "2131-Nom")+String.format("%45s", "|"));
															System.out.println("|" + String.format("%34s", "2132-Prenom")+ String.format("%42s", "|"));
															System.out.println("|" + String.format("%33s", "2133-Ville")+ String.format("%43s", "|"));
															System.out.println("|" + String.format("%50s", "99-Retour au menu précédent")+ String.format("%26s", "|"));
															System.out.println("|" + String.format("%40s", "0-Menu Principale")+ String.format("%36s", "|"));
															System.out.println("|"+String.format("%33s" , "-1-Quitter ") + String.format("%43s" , "|"));
															System.out.println("*---------------------------------------------------------------------------*");
															System.out.print(YELLOW_UNDERLINED + "\nVotre Choix = " + normal_Style);
															while(!clavier.hasNextInt())
																{
																	System.out.print("\n"+yellow_background+text_blackBold+"Attention!! Choix doit être de type Integer"+normal_Style+"\n");
																	
																	System.out.print(YELLOW_UNDERLINED+"Re-entrez choix = "+normal_Style);
																	clavier.nextLine();
																}
															choix0103 = clavier.nextInt();
															clavier.nextLine();
															for(i=0 ; i<clients.size() ; i++)
															{//debut boucler sur toutes les clients
																if(clients.get(i).getCode().equals(codeClientModifier))
																{//debut capturer l"client que leur code egale à codeClientsModifier
																	int firstChar;
																	switch(choix0103)
																	{//debut switch choix0103
																		//************ */
																			case 2131 : 
																			System.out.println("Nom actuel : " + clients.get(i).getNom());
																			System.out.print("Entrer le nouveau Nom : ");
																			//*/
																			while(!clavier.hasNext())
																			{
																				System.out.print("\n"+yellow_background+text_blackBold+"Nom de nouvel Client doit être de type String"+normal_Style+"\n");
																				System.out.print(YELLOW_UNDERLINED+"Re-entrez nom = "+normal_Style);
																				clavier.nextLine();
																			}
																			String nomNouveauClient = clavier.nextLine();
																			nomNouveauClient=nomNouveauClient.strip().toLowerCase();
																			firstChar=(nomNouveauClient.charAt(0)- '0');
																			for(int i = 0;i<nomNouveauClient.length();i++)
																			{
																				if(firstChar>=0 && firstChar<=9)
																				{
																					System.out.println("\n"+yellow_background+text_blackBold+"Attention!! Nom de nouvel Client doit être de type String"+normal_Style+"\n");
																					continue choixInfoClientModifier;
																				}
																			}
																			//*/
																			clients.get(i).setNom(nomNouveauClient);
																			System.out.println(green_text+"la modification de nom est bien fait"+normal_Style);
																			break;
																		case 2132 : 
																			System.out.println("Prenom actuel : " + clients.get(i).getPrenom());
																			System.out.print("Entrer le nouveau Prenom : ");
																			//*/
																			while(!clavier.hasNext())
																			{
																				System.out.print("\n"+yellow_background+text_blackBold+"Prénom de nouvel Client doit être de type String"+normal_Style+"\n");
																				System.out.print(YELLOW_UNDERLINED+"Re-entrez Prenom = "+normal_Style);
																				clavier.nextLine();
																			}
																			String prenomNouveauClient = clavier.nextLine();
																			prenomNouveauClient=prenomNouveauClient.strip().toLowerCase();
																			firstChar=(prenomNouveauClient.charAt(0)- '0');
																			for(int i = 0;i<prenomNouveauClient.length();i++)
																			{
																				if(firstChar>=0 && firstChar<=9)
																				{
																					System.out.println("\n"+yellow_background+text_blackBold+"Attention!! Prénom de nouvel Client doit être de type String"+normal_Style+"\n");
																					continue choixInfoClientModifier;
																				}
																			}
																			//*/
																			clients.get(i).setPrenom(prenomNouveauClient);
																			System.out.println(green_text+"la modification de prénom est bien fait"+normal_Style);
																			break;
																		case 2133 : 
																			System.out.println("Ville actuel : " + clients.get(i).getVille());
																			System.out.print("Entrer la nouvel Ville : ");
																			//*/
																			while(!clavier.hasNext())
																			{
																				System.out.print("\n"+yellow_background+text_blackBold+"Ville de nouvel Client doit être de type String"+normal_Style+"\n");
																				System.out.print(YELLOW_UNDERLINED+"Re-entrez Ville = "+normal_Style);
																				clavier.nextLine();
																			}
																			String villeNouveauClient = clavier.nextLine();
																			villeNouveauClient=villeNouveauClient.strip().toLowerCase();
																			firstChar=(villeNouveauClient.charAt(0)- '0');
																			for(int i = 0;i<villeNouveauClient.length();i++)
																			{
																				if(firstChar>=0 && firstChar<=9)
																				{
																					System.out.println("\n"+yellow_background+text_blackBold+"Attention!! Ville de nouvel Client doit être de type String"+normal_Style+"\n");
																					continue choixInfoClientModifier;
																				}
																			}
																			//*/
																			clients.get(i).setVille(villeNouveauClient);
																			System.out.println(green_text+"la modification de ville est bien fait"+normal_Style);
																			break;
											
																		case 99:
																			System.out.println(green_text+"Retour au menu précédent"+normal_Style);
																			continue tachesEmployeClients;
																		case 0:
																			System.out.println(green_text+"Retour Menu Principale"+normal_Style);
																			continue block1;
																		case -1:
																			System.out.println(blue_text+"à bientôt"+normal_Style);
																			break block1;
																		default:
																			System.out.println("\n"+RED_BOLD_BRIGHT + yellow_background+ "==> Attention!! numéro de choix entrer n'existe pas <==" + normal_Style);

																			break;
																		//************ */
																	}//fin switch choix0103
																}//fin capturer l'client que leur code egale à codeClientModifier
															}//fin boucler sur toutes les clients
														}//fin boucle while --> label : choixInfoClientModifier
													}//fin de traitement de modification d'un client par l'employe
													else
													{//debut else - client à modifier n'existe pas

														System.out.println(RED_BOLD_BRIGHT+yellow_background+ "==> Attention !! le client que vous voulez modifier n'existe pas <=="+normal_Style);
														
													}//fin else - client à modifier n'existe pas
												break;
												case 214:
													//appelle fonction  choix = 1 --> 12 --> 124
													supprimerClient(clients,comptes);
													break;
												case 99:
													System.out.println(green_text+"Retour au menu précédent"+normal_Style);
													continue tachesEmploye;
												case 0:
													System.out.println(green_text+"Retour Menu Principale"+normal_Style);
													continue block1;
												case -1:
													System.out.println(blue_text+"à bientôt"+normal_Style);
													break block1;
												default:
													System.out.println(RED_BOLD_BRIGHT+yellow_background+ "==> Attention !! choix Entree est incorrect (n'existe pas) <=="+normal_Style);
													break;
		
											}//fin switch choix010
									} // fin tachesDirecteurClients
									break;
								case 22://Les tâches faire par employe sur comptes
										//tachesEmployeComptes: 
										while (choix01 == 22)
										{// debut tachesEmployeComptes
											System.out.println(".---------------------------------------------------------------------------.");
											System.out.println(text_blackBold + white_background + "|"+ String.format("%38s", "User : " + employes.get(indexEmp).getNom()) + "("+ employes.get(indexEmp).getClass().getSimpleName() + ")" + String.format("%28s", "|") + normal_Style);
											System.out.println("|---------------------------------------------------------------------------|");
											System.out.println("|==> Que vous voulez faire : " + String.format("%48s", "|"));
											System.out.println("|" + String.format("%51s", "220-Ajouter un nouveau Compte")+String.format("%25s", "|"));
											System.out.println("|"+ String.format("%73s", "221-Afficher les informations de toutes les comptes")+ String.format("%3s", "|"));
											System.out.println("|" + String.format("%65s", "222-Afficher Toutes les comptes d'un client")+ String.format("%11s", "|"));
											System.out.println("|" + String.format("%55s", "223-Verser un solde sur un compte")+ String.format("%21s", "|"));
											System.out.println("|" + String.format("%45s", "224-Supprimer un compte")+ String.format("%31s", "|"));
											System.out.println("|" + String.format("%49s", "99-Retour au menu précédent")+ String.format("%27s", "|"));
											System.out.println("|" + String.format("%39s", "0-Menu Principale")+ String.format("%37s", "|"));
											System.out.println("|"+String.format("%32s" , "-1-Quitter ") + String.format("%44s" , "|"));
											System.out.println("*---------------------------------------------------------------------------*");
											System.out.print(YELLOW_UNDERLINED + "\nVotre Choix = " + normal_Style);
											while(!clavier.hasNextInt())
												{
													System.out.print("\n"+yellow_background+text_blackBold+"Attention!! Choix doit être de type Integer"+normal_Style+"\n");
													
													System.out.print(YELLOW_UNDERLINED+"Re-entrez choix = "+normal_Style);
													clavier.nextLine();
												}
											choix010 = clavier.nextInt();
											clavier.nextLine();
											switch (choix010) { //debut switch choix010
												case 220:
													//Appelle finction choix = 1 --> 13 -->130
													ajouterCompte(clients,comptes);
													break;
												case 221:
													//Appele fonction choix = 1 --> 13 --> 131
													afficherToutesComptes(comptes);
													break;
												case 222:
													//Appelle fonction choix = 1 --> 13 --> 132
													afficherToutesComptesClient(clients,comptes);
													break;
												case 223:
													//
													Employe_directeur_VerserSoldeClientCompte(clients,comptes);
													break;
												case 224:
													//appelle fonction  choix = 1 --> 13 --> 134
													supprimerComptes(clients,comptes);
													break;
												case 99:
													System.out.println("Retour au menu précédent");
													continue tachesEmploye;
												case 0:
													System.out.println("Retour Menu Principale");
													continue block1;
												case -1:
													System.out.println(blue_text+"à bientôt"+normal_Style);
													break block1;
												default:
													System.out.println(RED_BOLD_BRIGHT+yellow_background+ "==> Attention !! Votre choix Entree est incorrect (n'existe pas) <=="+normal_Style);
													break;
		
											}//fin switch choix010
									} // fin tachesEmployeComptes
									;break;
								case 0:
									continue block1;
								case -1:
									System.out.println(blue_text+"à bientôt"+normal_Style);
									break block1;
								default:
								System.out.println(RED_BOLD_BRIGHT+yellow_background+ "==> Attention !! Votre choix Entree est incorrect (n'existe pas) <=="+normal_Style);
									break;
							} //fin switch choix01
	
						} // fin tachesEmploye
						/* +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
						
					}
				}
				if (EmployeExiste==false) // Si login de Employe incorrect
				{
					System.out.println(red_text+"Attention !! nom ou code incorrect"+normal_Style);
					continue block1;
				}

				/* --------------------------------------------------------------------------------*/
				;
				break;
			/**********************************************************************************************************/
			/**********************************************************************************************************/
			/**********************************************************************************************************/
			/**********************************************************************************************************/
			/**********************************************************************************************************/
			/**********************************************************************************************************/
			/**********************************************************************************************************/
			/**********************************************************************************************************/
			/**********************************************************************************************************/
			/**********************************************************************************************************/
			/**********************************************************************************************************/
			/**********************************************************************************************************/
			//Gestion clients
			case 3:
				/* --------------login client-----------------------------------------------------*/
				System.out.print("\nEntrez votre code : ");
				String codeclt = clavier.nextLine();
				System.out.print("\nEntrez votre nom : ");
				String nomclt = clavier.nextLine();
				boolean ClientExiste = false;
				for (i =clients.size()-1; i >=0; i--)
				{
					int indexCl = i;
					if (clients.get(i).getNom().equals(nomclt) && clients.get(i).getCode().equals(codeclt)) {
						/* +++++++++++++++++Choix d'une tache à faire TâchesClient+++++++++++++++++++++++*/
						//tachesClient: 
						while (choix0 == 3)
						{// debut tachesClient
							System.out.println(".---------------------------------------------------------------------------.");
							System.out.println(text_blackBold + white_background + "|"+ String.format("%38s", "User : " + clients.get(indexCl).getNom()) + "("+ clients.get(indexCl).getClass().getSimpleName() + ")" + String.format("%30s", "|") + normal_Style);
							System.out.println("|---------------------------------------------------------------------------|");
							System.out.println("|==> Que vous voulez faire : " + String.format("%48s", "|"));
							System.out.println("|" + String.format("%51s", "30-Consulter toutes mes comptes")+String.format("%25s", "|"));
							System.out.println("|" + String.format("%73s", "31-Verser depuis un de mes comptes vers autre comptre")+ String.format("%3s", "|"));
							System.out.println("|" + String.format("%53s", "32-Verser un solde sur mon compte")+ String.format("%23s", "|"));
							System.out.println("|" + String.format("%39s", "33-Retirer un solde")+ String.format("%37s", "|"));
							System.out.println("|" + String.format("%37s", "0-Menu Principale")+ String.format("%39s", "|"));
							System.out.println("|" + String.format("%30s" , "-1-Quitter ") + String.format("%46s" , "|"));
							System.out.println("*---------------------------------------------------------------------------*");
							System.out.print(YELLOW_UNDERLINED + "\nVotre Choix = " + normal_Style);
							while(!clavier.hasNextInt())
									{
										System.out.print("\n"+yellow_background+text_blackBold+"Attention!! Choix doit être de type Integer"+normal_Style+"\n");
										System.out.print(YELLOW_UNDERLINED+"Re-entrez choix = "+normal_Style);
										clavier.nextLine();
									}
							choix010 = clavier.nextInt();
							clavier.nextLine();
							switch (choix010) { //debut switch choix010
								case 30:
									//Appelle finction choix = 3 --> 30
									clientConsulterComptes(codeclt,clients,comptes);
									break;
								case 31:
									//Appele fonction choix = 3 --> 31
									clientVerserClient(codeclt,clients,comptes);
									break;
								case 32:
									//
									System.out.println(blue_text+"Avis ==> Le versement d'un solde fait seulment par l'employer ou directeur "+normal_Style);
									break;
								case 33:
									//Appelle fonction choix = 3 --> 32
									//System.out.println("Retirer un solde (<4000 par jour)");
									ClientRetirer(codeclt,clients,comptes,historiquesRetirer);
									break;
								case 0:
									System.out.println(green_text+"Retour au Menu Principale"+normal_Style);
									continue block1;
								case -1:
									System.out.println(blue_text+"à bientôt"+normal_Style);
									break block1;
								default:
									System.out.println(RED_BOLD_BRIGHT+yellow_background+ "==> Attention !! Votre choix Entree est incorrect (n'existe pas) <=="+normal_Style);
									break;

							}//fin switch choix010
					
						} // fin tachesEmployeComptes

						/* +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
						ClientExiste = true;
					}
				}
				if (ClientExiste==false) //Si login de Client incorrect
				{	
					System.out.println(red_text+"Attention!! nom ou code incorrect" +normal_Style);
					continue block1;
				}
				/* --------------------------------------------------------------------------------*/
				;
				break;
			/**********************************************************************************************************/
			/**********************************************************************************************************/
			/**********************************************************************************************************/
			/**********************************************************************************************************/
			/**********************************************************************************************************/
			/**********************************************************************************************************/
			/**********************************************************************************************************/
			/**********************************************************************************************************/
			/**********************************************************************************************************/
			/**********************************************************************************************************/
			/**********************************************************************************************************/
			/**********************************************************************************************************/
			case -1:
				System.out.println(blue_text+"à bientôt"+normal_Style);
				break block1;
			//choix1 error(n'existe pas) ==> ni 1 , ni 2 et ni 3
			default:System.out.println("\n"+RED_BOLD_BRIGHT+yellow_background+ "==> Attention !! Votre choix Entree est incorrect (n'existe pas) <=="+normal_Style );
				 break;
		}//fin switch choix0
	}//fin block1
	
}// fin method main

/******************************Les fonctions utilisés dans le main*********************************/
/**************************************************************************************************/
/**************************************************************************************************/
/**************************************************************************************************/
/**************************************************************************************************/
/**************************************************************************************************/
/**************************************************************************************************/
/**************************************************************************************************/
/**************************************************************************************************/
/**************************************************************************************************/
/**************************************************************************************************/
/**************************************************************************************************/
/**************************************************************************************************/
//fonction qui test si un employe est existe ou non
public static boolean employeExiste(String _code ,ArrayList<Employe> _employes)
	{
		for (int i = 0; i < _employes.size(); i++)
		{
			if (_employes.get(i).getCode().equals(_code)) {
				return true;
			}
		}
		return false;
	}
//fonction choix = 1 --> 11 --> 110
public static void ajouterEmploye(ArrayList<Employe> _employes)
{
	testInput:while(_employes.size()>-1)
	{
		int firstChar;
		System.out.println("\n#L'ajoute d'un nouvel Employé :");
		System.out.print("##Entrer le code : ");
		while(!clavier.hasNext())
			{
				System.out.println("\n"+yellow_background+text_blackBold+"code de nouvel employé doit être de type String"+normal_Style+"\n");
				System.out.print(YELLOW_UNDERLINED+"Re-entrez code = "+normal_Style);
				clavier.nextLine();
			}
		String codeNouveauEmploye = clavier.nextLine();
		codeNouveauEmploye=codeNouveauEmploye.strip().toLowerCase();
		firstChar=(codeNouveauEmploye.charAt(0)- '0');
		if(firstChar>=0 && firstChar<=9)
		{
			System.out.print("\n"+yellow_background+text_blackBold+"Attention!! code de nouvel employé doit être de type String"+normal_Style+"\n");
			continue testInput;
		}
		/****/
		if(!employeExiste(codeNouveauEmploye,_employes))
		{//debut de traitement d'ajoute d'un employe par le directeur
			System.out.print("##Entrer le nom : ");
			while(!clavier.hasNext())
			{
				System.out.print("\n"+yellow_background+text_blackBold+"Nom de nouvel employé doit être de type String"+normal_Style+"\n");
				System.out.print(YELLOW_UNDERLINED+"Re-entrez nom = "+normal_Style);
				clavier.nextLine();
			}
			String nomNouveauEmploye = clavier.nextLine();
			nomNouveauEmploye=nomNouveauEmploye.strip().toLowerCase();
			firstChar=(nomNouveauEmploye.charAt(0)- '0');
			for(int i = 0;i<nomNouveauEmploye.length();i++)
			{
				if(firstChar>=0 && firstChar<=9)
				{
					System.out.println("\n"+yellow_background+text_blackBold+"Attention!! Nom de nouvel employé doit être de type String"+normal_Style+"\n");
					continue testInput;
				}
			}
			/***/
			System.out.print("##Entrer le prénom : ");
			while(!clavier.hasNext())
			{
				System.out.print("\n"+yellow_background+text_blackBold+"Prénom de nouvel employé doit être de type String"+normal_Style+"\n");
				System.out.print(YELLOW_UNDERLINED+"Re-entrez Prenom = "+normal_Style);
				clavier.nextLine();
			}
			String prenomNouveauEmploye = clavier.nextLine();
			prenomNouveauEmploye=prenomNouveauEmploye.strip().toLowerCase();
			firstChar=(prenomNouveauEmploye.charAt(0)- '0');
			for(int i = 0;i<prenomNouveauEmploye.length();i++)
			{
				if(firstChar>=0 && firstChar<=9)
				{
					System.out.println("\n"+yellow_background+text_blackBold+"Attention!! Prénom de nouvel employé doit être de type String"+normal_Style+"\n");
					continue testInput;
				}
			}
			/****/

			System.out.print("##Entrer la ville : ");
			while(!clavier.hasNext())
			{
				System.out.print("\n"+yellow_background+text_blackBold+"Ville de nouvel employé doit être de type String"+normal_Style+"\n");
				System.out.print(YELLOW_UNDERLINED+"Re-entrez Ville = "+normal_Style);
				clavier.nextLine();
			}
			String villeNouveauEmploye = clavier.nextLine();
			villeNouveauEmploye=villeNouveauEmploye.strip().toLowerCase();
			firstChar=(villeNouveauEmploye.charAt(0)- '0');
			for(int i = 0;i<villeNouveauEmploye.length();i++)
			{
				if(firstChar>=0 && firstChar<=9)
				{
					System.out.println("\n"+yellow_background+text_blackBold+"Attention!! Ville de nouvel employé doit être de type String"+normal_Style+"\n");
					continue testInput;
				}
			}
			/****/
			

			System.out.print("##Entrer la fonction : ");
			while(!clavier.hasNext())
			{
				System.out.print("\n"+yellow_background+text_blackBold+"Fonction de nouvel employé doit être de type String"+normal_Style+"\n");
				System.out.print(YELLOW_UNDERLINED+"Re-entrez Fonction = "+normal_Style);
				clavier.nextLine();
			}
			String fonctionNouveauEmploye = clavier.nextLine();
			fonctionNouveauEmploye=fonctionNouveauEmploye.strip().toLowerCase();
			firstChar=(fonctionNouveauEmploye.charAt(0)- '0');
			for(int i = 0;i<fonctionNouveauEmploye.length();i++)
			{
				if(firstChar>=0 && firstChar<=9)
				{
					System.out.println("\n"+yellow_background+text_blackBold+"Attention!! Fonction de nouvel employé doit être de type String"+normal_Style+"\n");
					continue testInput;
				}
			}
			/****/
			

			Employe newEmploye = new Employe(codeNouveauEmploye,nomNouveauEmploye,prenomNouveauEmploye,villeNouveauEmploye,fonctionNouveauEmploye);
			_employes.add(newEmploye); // l'ajoute de l'instance newEmploye dans ArrayList employes
			System.out.println("\n"+green_text + "L'ajoute de l'employe est bien fait" + normal_Style+"\n");
			break;
		}//fin de traitement d'ajoute d'un employe par le directeur
		else
		{
			System.out.println(red_text+ "==> Attention !! cet employé est déja existe <==" + normal_Style);
			return;
		}
	}
}
//fonction pour choix : 1 --> 11 --> 111
public static void afficherToutsEmployes(ArrayList<Employe> _employes)
	{
		if (_employes.size() >= 1)
			{//debut test si ArrayList employes vide on non
				System.out.println("\n#Les informations de toutes les employes :");
				for (int i = 0; i < _employes.size(); i++)
				{//debut boucle for sur ArrayList employes pour afficher toutes les informations
					System.out.println("*------------------------------------------*");
					System.out.print(_employes.get(i).toString());
					System.out.println("\n*------------------------------------------*");
				}//fin boucle for sur ArrayList employes pour afficher toutes les informations
				
			}//fin test si ArrayList employes vide on non
			else
			{//Arraylist employe est vide
				System.out.println(red_text+"Aucun employe existe -- Merci d'ajouter un Employe par le menu suivant --" +normal_Style);
			}
	}
//fonction choix = 1 --> 11 --> 112
public static void afficherEmploye(ArrayList<Employe> _employes)
	{
		if (_employes.size() >= 1)
			{//debut test si ArrayList employes vide on non
				System.out.print("\n##Entrer le code : ");
				String codeEmployeAfficher = clavier.nextLine();
				if (employeExiste(codeEmployeAfficher, _employes))
				{//debut de l'affichage des information de employe lorsque existe
					System.out.println("\n#Les informations de l'employe de code "+codeEmployeAfficher+ " est :");
					for (i = 0; i < _employes.size(); i++)
					{//debut boucle for sur ArrayList employes pour afficher les informations de l'employe
						if (_employes.get(i).getCode().equals(codeEmployeAfficher))
						{
							System.out.println("*------------------------------------------*");
							System.out.print(_employes.get(i).toString());
							System.out.println("\n*------------------------------------------*");
						}	
					}//fin boucle for sur ArrayList employes pour afficher les informations de l'employe
				}//fin de l'affichage des information de employe lorsque existe
				else
				{//debut else : si employer n'existe pas
					System.out.println(red_text+"==> Attention !! cet Employe n'existe pas <=="+normal_Style);
				}//fin else : si employer n'existe pas
			}//fin test si ArrayList employes vide on non
			else
			{//Arraylist employe est vide
				System.out.println(red_text+"Aucun employe existe -- Merci d'ajouter un Employe par le menu suivant --" +normal_Style);
			}
	}
//fonction choix = 1 --> 11 --> 114
public static void supprimerEmploye(ArrayList<Employe> _employes)
	{
		System.out.println("\n#La suppresion d'un Employe : ");
		System.out.print("##Entrer le code : ");
		String codeEmployeSupprimer = clavier.nextLine();
		if(employeExiste(codeEmployeSupprimer,_employes))
		{//debut de traitemment de suppression si Employe existe
			for(i=0;i<_employes.size();i++)
			{
				if(_employes.get(i).getCode().equals(codeEmployeSupprimer))
				{
					System.out.println("\n###Confirmer la suppresion : ");
					System.out.println("Yes ou Y ==> pour confirmer la suppression");
					System.out.print("No ou N ==> pour Annuler la suppression"+"\nChoix : ");
					String confirmerSuppresion = clavier.nextLine();
					if(confirmerSuppresion.strip().toLowerCase().charAt(0) =='y')
					{
						_employes.remove(i);
						System.out.println(green_text+"La suppression est bien fait"+normal_Style);
					}
					else
					{
						System.out.println(red_text+"La suppression est annulée"+normal_Style);
						break;
					}
				}
			}
		}//fin de traitemment de suppression si Employe existe
		else
		{//debut -- si Employe n'existe pas
			System.out.println(red_text+"==> Attention !! cette Employe n'existe pas <=="+normal_Style);
		}//fin -- si Employe n'existe pas
	}

/**************************************************************************************************/
/**************************************************************************************************/
/**************************************************************************************************/
//fonction qui test si un client est existe ou non
public static boolean clientExiste(String _code ,ArrayList<Client> _clients)
{
	for (int i = 0; i < _clients.size(); i++)
		{
			if (_clients.get(i).getCode().equals(_code)) {
				return true;
			}
		}
		return false;
}
//fonction choix = 1 --> 12 --> 120
public static void ajouterClient(ArrayList<Client> _clients)
{
/*-------------------------------------------------------------------------------- */
	testInput:while(_clients.size()>-1)
	{//debut test input : code , nom , prenom , ville
		int firstChar;//test si un entee est commencer par un nombre --> déclencher un erreur
		System.out.println("\n#L'ajoute d'un nouvel Cient :");
		System.out.print("##Entrer le code : ");
		while(!clavier.hasNext())
			{
				System.out.println("\n"+yellow_background+text_blackBold+"code de nouvel Client doit être de type String"+normal_Style+"\n");
				System.out.print(YELLOW_UNDERLINED+"Re-entrez code = "+normal_Style);
				clavier.nextLine();
			}
		String codeNouveauClient = clavier.nextLine();
		codeNouveauClient=codeNouveauClient.strip().toLowerCase();
		firstChar=(codeNouveauClient.charAt(0)- '0');
		if(firstChar>=0 && firstChar<=9)
		{
			System.out.print("\n"+yellow_background+text_blackBold+"Attention!! code de nouvel Client doit être de type String"+normal_Style+"\n");
			continue testInput;
		}
		/****/
		if(!clientExiste(codeNouveauClient,_clients))
		{//debut de traitement d'ajoute d'un client par le directeur
			System.out.print("##Entrer le nom : ");
			while(!clavier.hasNext())
			{
				System.out.print("\n"+yellow_background+text_blackBold+"Nom de nouvel Client doit être de type String"+normal_Style+"\n");
				System.out.print(YELLOW_UNDERLINED+"Re-entrez nom = "+normal_Style);
				clavier.nextLine();
			}
			String nomNouveauClient = clavier.nextLine();
			nomNouveauClient=nomNouveauClient.strip().toLowerCase();
			firstChar=(nomNouveauClient.charAt(0)- '0');
			for(int i = 0;i<nomNouveauClient.length();i++)
			{
				if(firstChar>=0 && firstChar<=9)
				{
					System.out.println("\n"+yellow_background+text_blackBold+"Attention!! Nom de nouvel Client doit être de type String"+normal_Style+"\n");
					continue testInput;
				}
			}
			/***/
			System.out.print("##Entrer le prénom : ");
			while(!clavier.hasNext())
			{
				System.out.print("\n"+yellow_background+text_blackBold+"Prénom de nouvel Client doit être de type String"+normal_Style+"\n");
				System.out.print(YELLOW_UNDERLINED+"Re-entrez Prenom = "+normal_Style);
				clavier.nextLine();
			}
			String prenomNouveauClient = clavier.nextLine();
			prenomNouveauClient=prenomNouveauClient.strip().toLowerCase();
			firstChar=(prenomNouveauClient.charAt(0)- '0');
			for(int i = 0;i<prenomNouveauClient.length();i++)
			{
				if(firstChar>=0 && firstChar<=9)
				{
					System.out.println("\n"+yellow_background+text_blackBold+"Attention!! Prénom de nouvel Client doit être de type String"+normal_Style+"\n");
					continue testInput;
				}
			}
			/****/

			System.out.print("##Entrer la ville : ");
			while(!clavier.hasNext())
			{
				System.out.print("\n"+yellow_background+text_blackBold+"Ville de nouvel Client doit être de type String"+normal_Style+"\n");
				System.out.print(YELLOW_UNDERLINED+"Re-entrez Ville = "+normal_Style);
				clavier.nextLine();
			}
			String villeNouveauClient = clavier.nextLine();
			villeNouveauClient=villeNouveauClient.strip().toLowerCase();
			firstChar=(villeNouveauClient.charAt(0)- '0');
			for(int i = 0;i<villeNouveauClient.length();i++)
			{
				if(firstChar>=0 && firstChar<=9)
				{
					System.out.println("\n"+yellow_background+text_blackBold+"Attention!! Ville de nouvel Client doit être de type String"+normal_Style+"\n");
					continue testInput;
				}
			}
			/****/

			Client newClient = new Client(codeNouveauClient,nomNouveauClient,prenomNouveauClient,villeNouveauClient);
			_clients.add(newClient); // l'ajoute de l'instance newEmploye dans ArrayList employes
			System.out.println("\n"+green_text + "L'ajoute de Client est bien fait" + normal_Style+"\n");
			break;
		}//fin de traitement d'ajoute d'un employe par le directeur
		else
		{
			System.out.println(red_text+ "==> Attention !! cet Client est déja existe <==" + normal_Style);
			return;
		}
	}
/*-------------------------------------------------------------------------------- */
}
//fonction pour choix : 1 --> 12 --> 121
public static void afficherToutesClients(ArrayList<Client> _clients)
	{
		if (_clients.size() != 0)
			{//debut test si ArrayList clients vide on non
				System.out.println("\n#Les informations de toutes les clients :");
				for (int i = 0; i < _clients.size(); i++)
				{//debut boucle for sur ArrayList clients pour afficher toutes les informations
					System.out.println("*------------------------------------------*");
					System.out.print(_clients.get(i).toString());
					System.out.println("\n*------------------------------------------*");
				}//fin boucle for sur ArrayList clients pour afficher toutes les informations
				
			}//fin test si ArrayList clients vide on non
			else
			{//Arraylist clients est vide
				System.out.println(red_text+"Aucun clients existe -- Merci d'ajoute un Clients par le menu suivant --"+normal_Style);
			}
	}
//fonction choix = 1 --> 12 --> 122
public static void afficherClient(ArrayList<Client> _clients)
	{
		if (_clients.size() >= 1)
			{//debut test si ArrayList clients vide on non
				System.out.print("\n##Entrer le code : ");
				String codeClientAfficher = clavier.nextLine();
				if (clientExiste(codeClientAfficher, _clients))
				{//debut de l'affichage des information de client lorsque existe
					System.out.println("\n#Les informations d'client de code "+codeClientAfficher+ " est :");
					for (i = 0; i < _clients.size(); i++)
					{//debut boucle for sur ArrayList clients pour afficher les informations de l'client
						if (_clients.get(i).getCode().equals(codeClientAfficher))
						{
							System.out.println("*------------------------------------------*");
							System.out.print(_clients.get(i).toString());
							System.out.println("\n*------------------------------------------*");
						}	
					}//fin boucle for sur ArrayList clients pour afficher les informations de l'client
				}//fin de l'affichage des information de client lorsque existe
				else
				{//debut else : si client n'existe pas
					System.out.println(red_text+"==> Attention !! cet Client n'existe pas <=="+normal_Style);
				}//fin else : si client n'existe pas
			}//fin test si ArrayList clients vide on non
			else
			{//Arraylist client est vide
				System.out.println(red_text+"Aucun client existe -- Merci d'ajoute un Client par le menu suivant --"+normal_Style);
			}
	}
//fonction pour choix : 1 --> 12 --> 124
public static void supprimerClient(ArrayList<Client> _clients , ArrayList<Compte> _comptes)
	{
		
		System.out.println("\n#La suppresion d'un Client : ");
		System.out.print("##Entrer le code : ");
		String codeClientSupprimer = clavier.nextLine();
		if(clientExiste(codeClientSupprimer,_clients))
		{//debut de traitemment de suppression si Client existe
			for(i=0;i<_clients.size();i++)
			{
				if(_clients.get(i).getCode().equals(codeClientSupprimer))
				{
					System.out.println("\n###Confirmer la suppresion : ");
					System.out.println("Yes ou Y ==> pour confirmer la suppression");
					System.out.println("No ou N ==> pour Annuler la suppression");
					System.out.print("Choix : ");
					String confirmerSuppresion = clavier.nextLine();
					if(confirmerSuppresion.strip().toLowerCase().charAt(0) =='y')
					{
						for(int j=0;j<_comptes.size();j++)
						{//pour faire la suppression de toutes ses comptes avant le supprimer
							if(_comptes.get(j).getClientassocie().equals(codeClientSupprimer))
							{
								System.out.println("compte : " + _comptes.get(j).getNumero()+ " à été supprimer");
								_comptes.remove(j);
							}
						}
						_clients.remove(i);
						System.out.println(green_text+"La suppression est bien fait de client et ses comptes"+normal_Style);
					}
					else
					{
						System.out.println(red_text+"La suppression est annulée"+normal_Style);
						break;
					}
				}
			}
		}//fin de traitemment de suppression si Client existe
		else
		{//debut -- si Client n'existe pas
			System.out.println(red_text+"Attention !! cette Client n'existe pas"+normal_Style);
		}//fin -- si Client n'existe pas
	}

/**************************************************************************************************/
/**************************************************************************************************/
/**************************************************************************************************/
//fonction choix =  1 --> 13 -->130
public static void ajouterCompte(ArrayList<Client> _clients , ArrayList<Compte> _comptes)
{/* @Autor 	: Khayoub ismail */
	System.out.println("\n#L'ajoute d'un nouveau Compte :");
	System.out.print("##Entrer le code de client que vous vouler ajouter un compte : ");
	String codeClientCompte = clavier.nextLine();
	if(clientExiste(codeClientCompte, _clients))
	{//debut if client existe
		for(i=0 ; i<_clients.size();i++)
		{//debut boucle sur ArrayList clients
			if(_clients.get(i).getCode().equals(codeClientCompte))
			{//caputrer le client pour verifier le nombre des compte
				if(_clients.get(i).getNbrCompte()>=3)
				{//test si nombre de client est egale 3 
					System.out.println(red_text+"Attention !! le nombre max des comptes qu'un client peut avoir est 3"+normal_Style);
				}
				else
				{//nombre de comptes de ce client est inférieur strictement à 3

					ArrayList<Compte> _comptes2=new ArrayList<Compte>();
					//_comptes2  : tous les compte de _clients.get(i).getCode()
					if(_clients.get(i).getNbrCompte()!=0)
					{
						for(int z=0 ; z<_comptes.size();z++)
						{
							if(_comptes.get(z).getClientassocie().equals(codeClientCompte))
							{
								_comptes2.add(_comptes.get(z));
							}
						}
					}
					String newNumero;
					int nbrCompte = _clients.get(i).getNbrCompte();
					//*System.out.println("nbr compte = " + nbrCompte);
					newNumero = _clients.get(i).getCode()+"_NumeroCompte"+(nbrCompte+1);
					//*System.out.println("newNumero="+newNumero);
					//*System.out.println("_comptes1.size()="+_comptes2.size());
					//debut numeroCheck
					numeroCheck:while(nbrCompte!=0)
					{
						if(nbrCompte!=0)
						{
							boolean comptexiste=false;
							for(int r=0;r<_comptes2.size();r++)
								{
									if(_comptes2.get(r).getClientassocie().equals(codeClientCompte))
									{
										if(_comptes2.get(r).getNumero().equals(newNumero))
										{
											String lastNumString = _comptes2.get((_comptes2.size())-1).getNumero();
											char intChar = lastNumString.charAt((lastNumString.length())-1);
											int lastNum =Integer.parseInt(String.valueOf(intChar));
											//System.out.println("lastNum : "+lastNum);
											newNumero=_clients.get(i).getCode()+"_NumeroCompte"+(lastNum+1);
											//newNumero=_clients.get(i).getCode()+"_NumeroCompte"+(nbrCompte+2);
											//System.out.println("changed newNumero="+newNumero);
											comptexiste=true;
										}
										if(r==(_comptes2.size()-1) && comptexiste==false)
										{//c'est-à-dire : arriver à la fin de _comptes2 et ne numCompte n'existe pas
											comptexiste=false;
										}
									}

								}
								if(comptexiste==false)
									{
										//System.out.println(red_text+"numero n'existe pas"+normal_Style);
										break numeroCheck;
									}		
						}
					}
					System.out.println(green_text+"--> Numéro de compte creér automatiquement par le système : "+newNumero+" "+normal_Style);
					//fin numeroCheck
					//break labelChoixType;					
					labelChoixType:while(nbrCompte!=-1)
					{
						System.out.println("\nEntrer le type de compte :");
						System.out.println("1-courant");
						System.out.println("2-épargne");
						System.out.print("Type : ");
						while(!clavier.hasNextInt())
							{
								System.out.print("\n"+yellow_background+text_blackBold+"Choix de type doit être de type Integer , soit 1 ou 2"+normal_Style+"\n");
								System.out.print(YELLOW_UNDERLINED+"Re-entrez Type : "+normal_Style);
								clavier.nextLine();
							}
						int choixTypeCompte = clavier.nextInt();
						clavier.nextLine();
						String newTypeCompte;
						switch(choixTypeCompte)
						{
							case 1 : newTypeCompte="courant"; break ;
							case 2 : newTypeCompte="epargne"; break ;
							default : System.out.println(red_text+"Attention !!! choix incorrect"+normal_Style);
							continue labelChoixType;
						}
						if(newTypeCompte=="epargne")//parce que compte de type epargne, en doit creér un array de numero de Compte, date de retirer , solde Retirer Max
						{//creation de array et l'ajoute sur ArrayList pour la fonction
							// c = cellule Historiques Retirer
							Object[] c = new Object[]{newNumero,LocalDate.of(0001,01,01),0.0};
							historiquesRetirer.add(c);
							//*******/ */
							System.out.println(green_text+"\nAvis : car compte est de type épargne , on l'ajoute aussi sur Historiques Retirer ArrayList"+normal_Style);
							/*for(Object element:c)
							{
								System.out.println(element);
							}
							for(Object[] o:historiquesRetirer)
							{
								for(int g=0;g<o.length;g++)
								{
									System.out.print(o[g]+" ");
								}
								
							}*/

						}
						Compte newCompte = new Compte(newNumero,codeClientCompte,newTypeCompte,0);
						_comptes.add(newCompte);
						_clients.get(i).incrementNbrCompte();
						System.out.println("\n"+green_text+"l'ajoute de compte est bien fait"+normal_Style);
						break labelChoixType;
					}
					
				}
			}// fin caputrer le client pour verifier le nombre des compte
		}//fin boucle sur ArrayList clients
		
	}//fin if client existe
	else
	{//debut client n'existe pas
		System.out.println(red_text+"Attention !! cet client n'existe pas"+normal_Style);
	}//fin client n'existe pas

}
//fonction pour choix : 1 --> 13 --> 131
public static void afficherToutesComptes(ArrayList<Compte> _comptes)
	{/* @Autor 	: Khayoub ismail */
		if (_comptes.size() != 0)
			{//debut test si ArrayList comptes vide on non
				System.out.println("#Les informations de toutes les comptes :");
				for (int m = 0; m < _comptes.size(); m++)
				{//debut boucle for sur ArrayList comptes pour afficher toutes les informations
					System.out.println("*------------------------------------------*");
					System.out.print(_comptes.get(m).toString());
					System.out.println("\n*------------------------------------------*");
				}//fin boucle for sur ArrayList comptes pour afficher toutes les informations
				
			}//fin test si ArrayList comptes vide on non
			else
			{//Arraylist comptes est vide
				System.out.println(red_text+"Aucun Compte existe -- Merci d'ajoute un Compte par le menu suivant --"+normal_Style);
			}
	}
//fonction pour choix : 1 --> 13 --> 132
public static void afficherToutesComptesClient(ArrayList<Client> _clients,ArrayList<Compte> _comptes)
{
	System.out.println("\n#Toutes les comptes d'un client  :");
	System.out.print("##Entrer le code de client que vous vouler afficher ses comptes : ");
	String codeClientCompte = clavier.nextLine();
	if(clientExiste(codeClientCompte, _clients))
	{//debut if client existe
		boolean clientExiste = false;
		for(int v=0;v<_clients.size();v++)
		{
			if(_clients.get(v).getCode().equals(codeClientCompte))
			{
				if(_clients.get(v).getNbrCompte()!=0)
				{//existe au moins un compte pour l'afficher
					for(int w=0;w<_comptes.size();w++)
						{
							if(_comptes.get(w).getClientassocie().equals(codeClientCompte))
							{
								System.out.println("*------------------------------------------*");
								System.out.print(_comptes.get(w).toString());
								System.out.println("\n*------------------------------------------*");
							}
						}
				}
				else
				{//n'existe auccun compte associer avec ce client
					System.out.println(red_text+"Attention !! cet client ne possède auccun compte"+normal_Style);
				}
				clientExiste = true;
			}
		}
		if(clientExiste==false)
			{
				System.out.println(red_text+"Attention!! cet client n'existe pas"+normal_Style);
			}
	}//fin if client existe
	else
	{//debut else - client n'existe pas
		System.out.println(red_text+"Attention !! cet client n'existe pas"+normal_Style);
	}//fin else - client n'existe pas
}
//fonction pour choix : 1 --> 13 --> 134
public static void supprimerComptes(ArrayList<Client> _clients,ArrayList<Compte> _comptes)
{
	Boolean continueSuppression=false;
	//debutDemandeCodeClient : 
	while(!continueSuppression)
	{//debut debutDemandeCodeClient;
		continueSuppression =true;
		System.out.println("\n#La suppression d'un compte qui Associe avec un client :");
		/*1*/System.out.print("##Entrez le code de Client "+"\n##pour afficher ses comptes "+"\n##et choisir le compte que vous voulez supprimer"+"\nCode = ");
		String codeClientSupprimerCompte = clavier.nextLine();
		/*2*/
		if(clientExiste(codeClientSupprimerCompte, _clients))
		{//debut 2
			/*3*/
			for(int i =0 ; i<_clients.size();i++)
			{//debut 3 suite_1
				if(_clients.get(i).getCode().equals(codeClientSupprimerCompte))
				{//debut 3 suite_2
					if(_clients.get(i).getNbrCompte()!=0)
					{//debut 3 suite_3
						/*5*/
						ComptesClient : while(_clients.get(i).getNbrCompte()!=0)
						{//debut de 5
							//cccodeClientSupprimerCompte = _clients.get(i).getCode();
							System.out.println("\nLes comptes de Client " + codeClientSupprimerCompte + " : ");
							for(int j=0 ; j<_comptes.size();j++)
							{//debut 5 suite_1
								if(_comptes.get(j).getClientassocie().equals(codeClientSupprimerCompte))
								{//debut 5 suite_2
									System.out.println(_comptes.get(j).afficherCompte());
								}//fin 5 suite_2
							}//fin 5 suite_1

							/*6*/
							System.out.print("Entrer le numero de compte que vous voulez supprimer :");
							String numeroCompteSupprimer = clavier.nextLine();
							boolean numExiste ;
							numExiste= false;
							for(int k=_comptes.size()-1 ; k>=0;k--)
							{
								if(_comptes.get(k).getNumero().equals(numeroCompteSupprimer))
								{	
									numExiste=true;
									/*7*/
									/*8*/
									//debut 8
									System.out.println("\nla Confirmation de suppression :");
									System.out.println("Yes ou Y ==> Confirmer la suppresion");
									System.out.println("No ou N ==> Annuler la suppresion");
									System.out.print("choix =");
									String choixConfirmation = clavier.nextLine();
									/*9*/
									if(choixConfirmation.strip().toLowerCase().charAt(0) =='y')
									{/*10*/
										//debut -Si ce compte de type epargne --> supprimer depuis historiquesRetirer
										for(Object[] a: historiquesRetirer)
											{
												if(a[0]==numeroCompteSupprimer) 
												{
														historiquesRetirer.remove(a);
												}
											}
										//fin -Si ce compte de type epargne --> supprimer depuis historiquesRetirer
										_comptes.remove(k);
										System.out.println(green_text+"La suppression de compte est bien fait"+normal_Style);
										_clients.get(i).decrementNbrCompte();
										System.out.println(green_text+"la decrementation de nombre de compte est bien fait depuis nombre comptes de cet Client"+normal_Style);
										return;
									}
									else
									{/*11*/
										System.out.println(red_text+"La suppression est à été annulée"+normal_Style);	
										return;								
									}
									//fin 8
									
								}	
							}
							/*13*/
							if(numExiste==false)
							{
								/*14*/
								System.out.println(red_text+"Attention !! numero compte incorrect (n'existe pas)"+normal_Style);
								continue ComptesClient;
							}
							else{// break de /*11*/ ici pour dépasser l'erreur de numExiste=true --> 'unreachable code'
								continue ComptesClient;
							}
						}//fin 5
					}//fin 3 suite_3
					else/*15*/
					{
						/*16*/
						System.out.println(red_text+"Attention !! cet Client ne possède aucun comptes"+normal_Style);
						//continue debutDemandeCodeClient;
						return;
					}
				}//fin 3 suite_2
			}//fin 3 suite_1
		}//fin 2
		else/*17*/
		{//debut 17
			/*18*/
			System.out.println(red_text+"Attention !! Client n'existe pas"+normal_Style);
			//continue debutDemandeCodeClient;
			return;
		}//fin 17
	}//fin debutDemandeCodeClient;
	if(continueSuppression==false)
	{
		System.out.println(red_text+"Aucun client existe "+normal_Style);
		//return;
	}

	/*System.out.println("il est possible d'afficher les comptes d'un clients par le menu précedent --> 132");
	System.out.println("#La suppresion d'un Compte :");
	System.out.print("##Entrer le numero de compte que vous vouler supprimer :");
	String numeroCompteSupprimer = clavier.nextLine();
	for(i=0 ; i<_comptes.size();i++)
	{
		if(_comptes.get(i).getNumero().equals(numeroCompteSupprimer))
		{
			String codeClientAssocie = _comptes.get(i).getClientassocie();
			_comptes.remove(i);
			System.out.println("la suppression du compte est bien fait");
			for(i=0 ; i<_clients.size();i++)
			{
				if(_clients.get(i).getCode().equals(codeClientAssocie))
				{
					_clients.get(i).decrementNbrCompte();
					System.out.println("la decrementation de nombre de compte est bien fait");
				}
			}
		}
		else
		{
			System.out.println("Attention !! compte n'existe pas");
		}
	}*/
}
/**************************************************************************************************/
/**************************************************************************************************/
/**************************************************************************************************/
//gestion des clients


public static void clientConsulterComptes(String _codeClient,ArrayList<Client> _clients,ArrayList<Compte> _comptes)
	{
		System.out.println("\n#Toutes les comptes de client : "+_codeClient);
		//boolean clientExiste = false;
		if(clientExiste(_codeClient, _clients))
		{//debut if client existe
			for(int v=0;v<_clients.size();v++)
			{
				if(_clients.get(v).getCode().equals(_codeClient))
				{
					 //clientExiste = true;
					if(_clients.get(v).getNbrCompte()!=0)
					{//existe au moins un compte pour l'afficher
						for(int w=0;w<_comptes.size();w++)
							{
								if(_comptes.get(w).getClientassocie().equals(_codeClient))
								{
									System.out.println("*------------------------------------------*");
									System.out.print(_comptes.get(w).toString());
									System.out.println("\n*------------------------------------------*");
								}
							}
					}
					else
					{//n'existe auccun compte associer avec ce client
						System.out.println(red_text+"Attention !! cet client ne possède aucun compte"+normal_Style);
						return;
					}
				}
			}
		}//fin if client existe
		else
		{//debut else - client n'existe pas
			System.out.println(red_text+"Attention !! cet client n'existe pas"+normal_Style);
			return;
		}//fin else - client n'existe pas
		/*if(clientExiste==false)
		{
			System.out.println("Attention!! client n'existe pas");
			return;
		}*/

	}

public static void clientVerserClient(String _codeClient,ArrayList<Client> _clients,ArrayList<Compte> _comptes)
	{
		clientConsulterComptes(_codeClient,_clients,_comptes);
		System.out.print("\nEntrez numero de son compte qui vous utilisez pour verser un solde vers autre client : ");
		String numCompteClient1 = clavier.nextLine();
		boolean compteClient1Existe = false;
		for(int i = 0 ; i<_comptes.size();i++)
		{//debut consulter comptes pour catch choix compte
			if(_comptes.get(i).getNumero().equals(numCompteClient1))
			{//debut compte existe
				compteClient1Existe = true;
				//if(_comptes.get(i).getSolde()==0)_comptes.get(i).VerserSolde(5000); //--------il faut faire verser par Employer
				if(_comptes.get(i).getSolde()!=0.0)
				{//debut test if solde dans ce compte est different à 0
					System.out.print("\nEntrer le code de client 2 que vous voulez le transferer un solde --(client récépteur)--:");
					String codeClient2 = clavier.nextLine();
					if(clientExiste(codeClient2, _clients))//tester if client 2 existe
					{//debut client 2 existe 
						clientConsulterComptes(codeClient2, _clients, _comptes); 
						System.out.print("\nEntrer un compte de client 2 pour verser un solde --(compte récépteur)--: ");
						String numCompteClient2 = clavier.nextLine();
						boolean numCompteClient2Existe =false;
						double soldeVerser1to2;
						for(int j = 0 ; j<_comptes.size();j++)
						{//debut boucle sur les comptes pour catch compte client 2 entrer
							if(_comptes.get(j).getNumero().equals(numCompteClient2))
							{//debut compte existe
								numCompteClient2Existe =true;
								System.out.print("\nEntrer un solde à Verser vers client 2 : ");
								while(!clavier.hasNextDouble())
									{	//
										
										System.out.print("\n"+yellow_background+text_blackBold+"Attention !! le solde doit être de type Double"+normal_Style+"\n");
										System.out.print(YELLOW_UNDERLINED+"Re-entrez solde verser : "+normal_Style);
										clavier.nextLine();
									}
								soldeVerser1to2 = clavier.nextDouble();
								clavier.nextLine();
								//System.out.println("solde à verser = "+soldeVerser1to2);
								if(soldeVerser1to2>0)
								{//debut test soldeVerser1to2
								if(_comptes.get(i).getSolde()>=soldeVerser1to2)
								{
									//debut confirmation
									System.out.println("\nla Confirmation de verser :");
									System.out.println("Yes ou Y ==> continue la transformation");
									System.out.println("No ou N ==> Annuler la transformation");
									System.out.print("choix = ");
									String choixConfirmationEnv = clavier.nextLine();
									if(choixConfirmationEnv.strip().toLowerCase().charAt(0) =='y')
									{
										_comptes.get(i).RetirerSolde(soldeVerser1to2); 
										_comptes.get(j).VerserSolde(soldeVerser1to2);
										System.out.println(green_text+"\nVirement éffectué :"+normal_Style);
										System.out.println(green_text+"\nvers :"+numCompteClient2+" "+normal_Style);
										System.out.println(green_text+"\npartir de :"+numCompteClient2+" "+normal_Style);
										System.out.println(green_text+"\nMontant :"+soldeVerser1to2+" DH"+normal_Style);
										//il fait faire par la fonction RetirerSolde de question 9
										//System.out.println("retirer depuis Solde client 1 bien fait ==>"+soldeVerser1to2);
										//System.out.println("verser vers Solde client 2 bien fait ==>"+soldeVerser1to2);
										return;
									}
									else
									{
										System.out.println(red_text+"La transformation est à été annulée"+normal_Style);	
										return;								
									}
									//fin confirmation
								}
								else
								{
									System.out.println(red_text+"Attention !! solde insuffisant pour cette operation"+normal_Style);
									return;
								}
								}//fin test soldeVerser1to2
								else
								{
									System.out.println(red_text+"Attention !! solde entree doit être supérieur à 0"+normal_Style);
									return;
								}
								
							}//fin compte existe
						}//fin boucle sur les comptes pour catch compte entrer
						if(numCompteClient2Existe ==false)
							{//debut compte not existe
								System.out.println(red_text+"Attention!! cet compte "+numCompteClient2+" de Client "+codeClient2+" n'existe pas" +normal_Style);
							}//fin compte not existe
					}//fin client 2 existe
					else
					{//debut client 2 not existe
						System.out.println(red_text+"Attention !! client "+codeClient2+" n'existe pas"+normal_Style);
						return;
					}//fin client 2 not existe
				}//fin test if solde dans ce compte est different à 0
				else
				{//debut message error : compte est vider 
					System.out.println(red_text+"Attention!! Impossible de continue la transformation avec cette compte( "+numCompteClient1+") --> solde=0"+normal_Style);
				}//fin message error : compte est vider 
			compteClient1Existe = true;
			}//fin compte existe
		}//fin consulter comptes pour catch choix compte
		if(compteClient1Existe == false)
		{
			System.out.println(red_text+"Attention !! cet compte "+numCompteClient1+" de Client "+_codeClient+" n'existe pas"+normal_Style);
		}
	}

public static void ClientRetirer(String _codeClient,ArrayList<Client> _clients,ArrayList<Compte> _comptes , ArrayList<Object[]> _logsRetirer )
{
	clientConsulterComptes(_codeClient,_clients,_comptes);
	System.out.print("\nEntrez numero de votre compte utiliser pour Retirer un solde : ");
	String numCompteClient1 = clavier.nextLine();
	boolean compteClient1Existe = false;
	blockSolde0:for(int i = 0 ; i<_comptes.size();i++)
	{//debut consulter comptes pour catch choix compte
		if(_comptes.get(i).getNumero().equals(numCompteClient1))
		{//debut compte existe
		if(_comptes.get(i).getSolde()>0)
		{//debut if solde dans ce compte est upérieure à 0
			compteClient1Existe =true;
			String typeCompte = _comptes.get(i).geType();
			System.out.print("\nDonnez solde à Retirer : ");
			while(!clavier.hasNextDouble())
				{	
					System.out.print("\n"+yellow_background+text_blackBold+"Attention !! le solde doit être de type Double"+normal_Style+"\n");
					System.out.print(YELLOW_UNDERLINED+"Re-entrez solde à retirer : "+normal_Style);
					clavier.nextLine();
				}
			double soldeRetirer = clavier.nextDouble();
			clavier.nextLine();
			//System.out.print("Solde(Retirer) Entree est : "+soldeRetirer);

			if(soldeRetirer>0 && _comptes.get(i).getSolde()>soldeRetirer)
			{//debut test si soldeRetirer est supérieure strictement à 0
				//System.out.println("soldeRetirer>0");
				//System.out.println("type : " +typeCompte);
				//System.out.println(typeCompte.equals("courant"));
				if(typeCompte.equals("courant"))
				{//debut tester if compte de type courante
					//debut confirmation
					System.out.println("\nla Confirmation de Retirer :");
					System.out.println("Yes ou Y ==> continue de Retirer");
					System.out.println("No ou N ==> Annuler de Reetirer");
					System.out.print("choix = ");
					String choixConfirmation = clavier.nextLine();
					if(choixConfirmation.strip().toLowerCase().charAt(0) =='y')
					{
						_comptes.get(i).RetirerSolde(soldeRetirer); 
						//il fait faire par la fonction RetirerSolde de question 9
						System.out.println(green_text+"\nReçu : " +normal_Style);
						System.out.println(green_text+"vous retirer :" + soldeRetirer+" "+normal_Style);
						System.out.println(green_text+"vous rester dans votre solde : " +_comptes.get(i).getSolde()+" "+normal_Style);
						return;
					}
					else
					{
						System.out.println(red_text+"Le Retirer est à été annulée"+normal_Style);	
						return;								
					}
					//fin confirmation
				}//fin tester if compte de type courante
				
				//System.out.println("dépass test courant");
				if(typeCompte=="epargne")
				{//debut tester if compte de type épargne
					//System.out.println("epargne true");
					/*********************** *
					 * for(Object[] o:historiquesRetirer)
							{
								for(int g=0;g<o.length;g++)
								{
									System.out.print(o[g]);
								}
								
							}
					*****************/
					
					for(Object[] array:_logsRetirer)
					{//debut boucler sur logsRetirer pour catch arrays[]

						//System.out.println("enumCompteClient1 = " +numCompteClient1);
						//System.out.println("array[0] = "+array[0]);
						//System.out.println("array[0].equals(numCompteClient1) ==> " + array[0].equals(numCompteClient1));
						if(array[0].equals(numCompteClient1))
							{//debut if --catch array si Object[0] = numCompteClient1
								//System.out.println(LocalDate.now());
								//System.out.println(array[1]);
								//System.out.println(array[1]!=LocalDate.now());
								if(!(array[1].equals(LocalDate.now())))
								{//debut if -- test si lastDateRetirer != dateAujourd'hui
									//System.out.println("1) array[1]!=LocalDate.now() ==>" +(array[1]!=LocalDate.now()));
									soldeRetirerMax = 0.0; 
									//array[1]=0.0;
									//System.out.println("soldeRetirerMax "+soldeRetirerMax);
								}//fin if -- test si lastDateRetirer != dateAujourd'hui
								else
								{//debut if -- test si lastDateRetirer == dateAujourd'hui
									//System.out.println("2) array[1]!=LocalDate.now() ==>" +(array[1]!=LocalDate.now()));
									soldeRetirerMax=0;
									soldeRetirerMax =(double)(array[2]);
									//System.out.println("soldeRetirerMax "+soldeRetirerMax);
									//System.out.println("array[2] "+array[2]);
								}//fin if -- test si lastDateRetirer == dateAujourd'hui
								/**************************** */
								if((soldeRetirerMax+soldeRetirer)<4000)
									{//debut de faite le retirer car (soldeRetirerMax de ce jour < 4000)
										soldeRetirerMax+=soldeRetirer;
										array[2]=(double)array[2]+(double)soldeRetirerMax;
										//debut----fait ici confirmation
										System.out.println("\nla Confirmation de Retirer :");
										System.out.println("Yes ou Y ==> continue de Retirer");
										System.out.println("No ou N ==> Annuler de Reetirer");
										System.out.print("choix = ");
										String choixConfirmation = clavier.nextLine();
										if(choixConfirmation.strip().toLowerCase().charAt(0) =='y')
										{
											_comptes.get(i).RetirerSolde(soldeRetirer); 
											//debut----fait ici confirmation
											//stock new soldeRetirerMax sur array[2]
											//System.out.println("soldeRetirerMax = "+soldeRetirerMax);
											//System.out.println("1) array[2] = "+array[2]);
											array[2]=soldeRetirerMax;
											//System.out.println("2) array[2] = "+array[2]);
											//stock new lastDateRetirer sur array[1]
											//System.out.println("1) array[1]= "+array[1]);
											array[1]=LocalDate.now();
											//System.out.println("1) array[1]= "+array[1]);
											int indexArray = _logsRetirer.indexOf(array);
											//System.out.println("1) index array = "+indexArray);
											//->before set
											//System.out.println("before set : ");
											/********************** */
											/*
											for(Object[] o:historiquesRetirer)
												{
													for(int g=0;g<o.length;g++)
													{
														System.out.print(o[g]+" ");
													}
													
												}
											*/
											/********************** */
											_logsRetirer.set(indexArray,array);
											//-after set
											//System.out.println("after set : ");
											/********************** */
											/*
											for(Object[] o:historiquesRetirer)
												{
													for(int g=0;g<o.length;g++)
													{
														System.out.print(o[g]+" ");
													}
													
												}
											*/
											/********************** */
											System.out.println(green_text+"Félicitation ==> tous ça passe bien"+normal_Style);
											System.out.println(green_text+"Vous Retirer : "+soldeRetirer+" DH"+normal_Style);
											System.out.println(green_text+"Vous Rester : " + _comptes.get(i).getSolde()+normal_Style);
											return;
										}
										else
										{
											System.out.println(red_text+"Le Retirer est à été annulée"+normal_Style);	
											return;								
										}
										//fin confirmation
									}//debut de faite le retirer car (soldeRetirerMax de ce jour < 4000)
									else
									{//debut soldeRetirerMax dépasse 4000 ce jour
										System.out.println(red_text+"\nAttention !! vous devez dépasser le solde max de ce jour avec cet retirer"+normal_Style);
										System.out.println(red_text+"votre solde max de ce jour est : "+soldeRetirerMax+" "+normal_Style);
										if(4000-soldeRetirerMax>0)
										{
											System.out.println(red_text+"vous rest juste inferieur " +(4000-soldeRetirerMax)+" DH, à retirer"+normal_Style);
										}
										else
										{
											System.out.println(red_text+"vous rest juste inferieur " +(soldeRetirerMax-4000)+" DH, à retirer"+normal_Style);

										}
										continue blockSolde0;
									}//fin soldeRetirerMax dépasse 4000 ce jour
							}//fin if --catch array si Object[0] = numCompteClient1
					}//debut boucler sur logsRetirer pour catch arrays[]
				}//fin tester if compte de type épargne
			}//fin soldeRetirer est supérieure strictement à 0
			else
			{//debut soldeRetirer est inférieur ou égale 0
				System.out.println(red_text+"Attention !! Solde Retirer doit être supérieur à 0  et supperieur à solde de compte"+normal_Style);
				continue blockSolde0;
			}//fin soldeRetirer est inférieur ou égale 0
		}//fin if solde dans ce compte est upérieure à 0
		else
		{//message error car solde de Compte est = 0
			System.out.println(red_text+"Attention vous êtes pas un solde suffisant pour cette operation "+normal_Style);
			return;
		}
		}//fin compte existe
	}//fin boucle sur les comptes pour catch compte entrer
	if(compteClient1Existe == false)
	{
		System.out.println(red_text+"Attention !! compte Client1 not existe"+normal_Style);
		return;
	}

}
/* @Autor 	: Khayoub ismail */
/*****************************************************************************************************/
//fonction utiliser par Employer est
public static void Employe_directeur_VerserSoldeClientCompte(ArrayList<Client> _clients,ArrayList<Compte> _comptes)
{
	System.out.print("\nEntrez code client que vous voulez verser un solde : ");
	String _codeClient = clavier.nextLine();
	clientConsulterComptes(_codeClient,_clients,_comptes);
	System.out.print("\nEntrez numero de votre compte utiliser pour verser de solde : ");
	String numCompteClient1 = clavier.nextLine();
	boolean compteClient1Existe = false;
	if(clientExiste(_codeClient, _clients))
	{//debut client  existe
		for(int i = 0 ; i<_comptes.size();i++)
		{//debut consulter comptes pour catch choix compte
			if(_comptes.get(i).getNumero().equals(numCompteClient1))
			{//debut compte existe
				compteClient1Existe = true;
				double soldeVerser;
				System.out.print(YELLOW_UNDERLINED+"\nDonnez solde Verser : "+normal_Style);
				while(!clavier.hasNextDouble())
					{	
						System.out.print("\n"+yellow_background+text_blackBold+"Attention !! le solde doit être de type Double"+normal_Style+"\n");
						System.out.print(YELLOW_UNDERLINED+"Re-entrez solde à verser : "+normal_Style);
						clavier.nextLine();
					}
				soldeVerser = clavier.nextDouble();
				clavier.nextLine();
				//debut confirmation
				System.out.println("\nla Confirmation de verser :");
				System.out.println("Yes ou Y ==> continue la transformation");
				System.out.println("No ou N ==> Annuler la transformation");
				System.out.print("choix = ");
				String choixConfirmationEnv = clavier.nextLine();
					if(choixConfirmationEnv.strip().toLowerCase().charAt(0) =='y')
					{
						_comptes.get(i).VerserSolde(soldeVerser);
						System.out.println(green_text+"\nReçu : "+normal_Style);
						System.out.println(green_text+"Le versement de "+soldeVerser+" est bien fait sur Client "+_codeClient+"-> compte "+numCompteClient1+" "+normal_Style);

						return;
					}
					else
					{
						System.out.println(red_text+"Le versement à été annulée"+normal_Style);	
						return;								
					}
				//fin confirmation
			}//fin compte existe
		}//fin consulter comptes pour catch choix compte
	}//fin compte existe
	if(compteClient1Existe == false)
	{
		System.out.println(red_text+"Attention !! cet compte "+numCompteClient1+" de Client "+_codeClient+" n'existe pas"+normal_Style);
	}

}

}

