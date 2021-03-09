package fr.diginamic.services.exemples;

import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.validator.FormValidator;

public class AjouterVehiculeValidator extends FormValidator {

	@Override
	public boolean validate(Form form) {
		String immat  = form.getValue("champ1");
		String type   = form.getValue("champ2");
		String marque = form.getValue("champ4"); 
		String modele = form.getValue("champ5");
		
		
		if (immat.trim().isEmpty()) {
			console.alert("L'immatriculatio est obligatoire !");
			return false;
		}
		
		else if (type.trim().isEmpty()) {
			console.alert("Le type est obligatoire !");
			return false;
		}
		
		else if (marque.trim().isEmpty()) {
			console.alert("La marque est obligatoire !");
			return false;
		}
		
		else if (modele.trim().isEmpty()) {
			console.alert("Le modele est obligatoire !");
			return false;
		}
		return true;
	}

}
