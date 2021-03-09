package fr.diginamic.services.exemples;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.composants.MenuService;
import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.ui.TextField;
import fr.diginamic.services.exemples.entite.Camion;
import fr.diginamic.services.exemples.entite.StatutVehicule;
import fr.diginamic.services.exemples.entite.TypeVehicule;
import fr.diginamic.services.exemples.entite.Vehicule;
import fr.diginamic.services.exemples.entite.Voiture;
import fr.diginamic.services.exemples.manager.CamionManager;
import fr.diginamic.services.exemples.manager.TypeVehiculemanager;
import fr.diginamic.services.exemples.manager.VoitureManager;

public class ListeVehiculesService extends MenuService {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("SocleSwing");
	
	/***
	 * Population de la base de donnee
	 */
	static {	
		TypeVehicule type_1 = new TypeVehicule(59.99, 2999, "Sport");
		TypeVehicule type_2 = new TypeVehicule(29.99, 1999, "berline");
		TypeVehicule type_3 = new TypeVehicule(79.99, 4999, "cabriolet");
		
		TypeVehicule type_4 = new TypeVehicule(89.99, 6999, "frigorifique");
		TypeVehicule type_5 = new TypeVehicule(49.99, 2599, "demenagement");
		
		Voiture voiture_1 = new Voiture("123-XXX-XXX", type_1, 120000, StatutVehicule.DISPONIBLE, 5, "Mercedes", "Classe C");
		Voiture voiture_2 = new Voiture("124-XXX-XXX", type_2, 110000, StatutVehicule.LOUE, 4, "BMW", "E400");
		Voiture voiture_3 = new Voiture("125-XXX-XXX", type_2, 40000, StatutVehicule.LOUE, 7, "BMW", "Serie 3");
		Voiture voiture_4 = new Voiture("126-XXX-XXX", type_3, 75000, StatutVehicule.DISPONIBLE, 2, "Porsche", "911");
		
		Camion camion_1 = new Camion("127-XXX-XXX", type_4, 150000, StatutVehicule.DISPONIBLE, 35, "Volvo", "C35");
		Camion camion_2 = new Camion("128-XXX-XXX", type_5, 10000, StatutVehicule.DISPONIBLE, 45, "Toyota", "D56");
		Camion camion_3 = new Camion("129-XXX-XXX", type_4, 300000, StatutVehicule.DISPONIBLE, 55, "Tigre", "T-34");
		
		EntityManager em = emf.createEntityManager();
		
		TypeVehiculemanager typeVehiculeManager = new TypeVehiculemanager(em);
		typeVehiculeManager.insertionTypeVehicule(type_1);
		typeVehiculeManager.insertionTypeVehicule(type_2);
		typeVehiculeManager.insertionTypeVehicule(type_3);
		typeVehiculeManager.insertionTypeVehicule(type_4);
		typeVehiculeManager.insertionTypeVehicule(type_5);
		
		VoitureManager voitureManager = new VoitureManager(em);
		voitureManager.insertionVoiture(voiture_1);
		voitureManager.insertionVoiture(voiture_2);
		voitureManager.insertionVoiture(voiture_3);
		voitureManager.insertionVoiture(voiture_4);
		
		CamionManager camionManager = new CamionManager(em);
		camionManager.insertionCamion(camion_1);
		camionManager.insertionCamion(camion_2);
		camionManager.insertionCamion(camion_3);
		
		em.close();				
	}

	@Override
	public void traitement() {
		
		console.clear();
		
		EntityManager em = emf.createEntityManager();
		TypedQuery<Vehicule> query = em.createQuery("SELECT v FROM Vehicule v", Vehicule.class);
		List<Vehicule> listeVehicules = query.getResultList();
		
		console.println("<h1 class='bg-green'><center>Liste des Vehicules</center></h1>");
		
		String tab = "<table cellspacing=0>"
				+ "<tr class='bg-green'><td>&nbsp;</td><td>&nbsp;</td><td>Marque</td><td>Modele</td><td>Immatriculation</td><td>Type</td><td>Kilometrage (KMS)</td><td>Statut</td></tr>";
		
		for (Vehicule v : listeVehicules) {
			tab += "<tr>"
				  + "  <td><a class='btn-blue' href='modifier(" + v.getId() + ")'><img width=25 src='images/pencil-blue-xs.png'></a></td>"
				  + "  <td><a class='btn-red'  href='supprimer(" + v.getId() + ")'><img width=25 src='images/trash-red-xs.png'></a></td>"
				  + "  <td width='150px'>" + v.getMarque() + "</td>"
				  + "  <td width='150px'>" + v.getModele() + "</td>"
				  + "  <td width='150px'>" + v.getImmatriculation() + "</td>"
				  + "  <td width='150px'>" + getTypeName(v.getTypeVehicule().getId()) + v.getTypeVehicule().getNom() + "</td>"
				  + "  <td width='150px'>" + v.getKilometrage() + "</td>"
				  + "  <td width='150px'>" + v.getStatutVehicule() + "</td>"
				  + "</tr>";
		} 
		
		console.println(tab);		
		
		console.println("<h2 class='bg-green'><center>Ajouter un Vehicule</center></h2>");		
		console.println("<center><h3>Voiture <a class='btn-blue' href='ajouterVoiture()'><img width=25 src='images/plus-green.png'></a></h3></center>");
		
		// TODO AjouterCamion()
		console.println("<center><h3>Camion <a class='btn-blue' href=''><img width=25 src='images/plus-green.png'></a></h3></center>"); 
		
	}
	
	/**
	 * Méthode apellée lorsque l'utilisateur clique sur une icone d'ajout de véhicule 
	 * 
	 */
	private void ajouterVoiture() {
		EntityManager em = emf.createEntityManager();
		
		// Creation d'un formulaire vide
		Form form = new Form();
		
		// Ajout d'une voiture en base  
		form.addInput(new TextField("Immatriculation :", "champ1"));
		form.addInput(new TextField("Type :", "champ2"));
		form.addInput(new TextField("Nombre de places :", "champ3"));
		form.addInput(new TextField("Marque :", "champ4"));
		form.addInput(new TextField("Modèle :", "champ5"));
		form.addInput(new TextField("Kilométrage :", "champ6"));
		
		// Les règles métier sont vérifiées dans le validator 
		AjouterVehiculeValidator validator = new AjouterVehiculeValidator();
		
		// Recupération et conversion du champ type
		TypeVehicule type = getTypeVehicule(form.getValue("champ2"));
		
		boolean valide = console.input("Ajout d'un véhicule en base", form, validator);
		if (valide) {		
			
			// Récupération des informations du form
			String immat    = form.getValue("champ1");
			String kms      = form.getValue("champ6");
			String nbPlaces = form.getValue("champ3");
			String marque   = form.getValue("champ4");
			String modele   = form.getValue("champ5");
			
			// Construction de l'objet voiture
			Voiture voiture = new Voiture(immat, type, Integer.parseInt(kms), Integer.parseInt(nbPlaces), marque, modele);
			
			VoitureManager voitureManager = new VoitureManager(em);
			voitureManager.insertionVoiture(voiture);

			traitement();
		}
		
	}
	
	/** 
	 * Méthode apellée lorsque l'utilisateur clique sur une icone de modification
	 * dans la table des véhicules.
	 * 
	 * @param id identifiant du client à modifier.
	 */
	private void modifier(Long id) {	
		EntityManager em = emf.createEntityManager();
		
		// Recherche de la voiture souhaitee par le manager 
		VoitureManager voitureManager = new VoitureManager(em);
		Voiture v = voitureManager.findVoiture(id);	
		
		// On commence par creer le formulaire vide
		Form form = new Form();
				
		// On ajoute au formulaire 3 champs de type texte pour modifier les valeurs du véhicule choisi
		form.addInput(new TextField("Immatriculation :", "champ1", v.getImmatriculation()));
		form.addInput(new TextField("Kilometrage :", "champ2", v.getKilometrage().toString()));
		form.addInput(new TextField("Commentaire :", "champ3", v.getCommentaire()));
		
		// Les règles métier sont vérifiées dans le validator 
		ModifierVehiculeValidator validator = new ModifierVehiculeValidator();
		
		boolean valide = console.input("Modification du véhicule "+v.getMarque()+"  "+v.getModele(), form, validator);
		if (valide) {
			
			// On recupere les information dans les champs
			String immatriculation = form.getValue("champ1");
			Integer kilometrage = Integer.parseInt(form.getValue("champ2"));
			String comment = form.getValue("champ3");		
			
			// On attribue les informations des champs a la voiture 
			v.setImmatriculation(immatriculation);
			v.setKilometrage(kilometrage);
			v.setCommentaire(comment);
			
			// Update de la voiture en base 
			voitureManager.updateVoiture(v);

			traitement();
		}
	}

	/**
	 *  Méthode apellée lorsque l'utilisateur clique sur une icone de suppression
	 * dans la table des clients
	 * 
	 * @param id identifiant du véhicule à supprimer.
	 */
	private void supprimer(Long id) {
		
		// Ouverture d'un pop up de confirmation de suppression 
		boolean result = console.confirm("Suppression de l'item " + id, "Confirmez-vous la suppression de l'item : " + id);
		
		// Si l'utilisateur valide la suppression
		// On supprime l'entité en base
		if(result) {
			EntityManager em = emf.createEntityManager();
			EntityTransaction transaction = em.getTransaction();
			
			transaction.begin();
			
			Vehicule v = em.find(Vehicule.class, id);
			
			if (v!=null) {
				em.remove(v);
			}
			
			transaction.commit();
			
			traitement();
		}
	}
	
	/***
	 * Retourne le type de vehicule (Voiture / Camion)
	 * @param id 
	 * @return type of vehicule 
	 */
	private String getTypeName(int id) {
		if(id < 4) {
			return "Voiture ";
		} else {
			return "Camion ";
		}
	}
	
	/***
	 * Retourne le type de véhicule (Berline, sport, ect...)
	 * @param s 
	 * @return TypeVehicule
	 */
	private TypeVehicule getTypeVehicule(String s) {
		EntityManager EM = emf.createEntityManager();
		
		switch(s.toLowerCase()) {
			case "sport":
				return EM.find(TypeVehicule.class, 1);
			case "berline":
				return EM.find(TypeVehicule.class, 2);
			case "cabriolet":
			default :
				return EM.find(TypeVehicule.class, 3);
		}
	}
}
