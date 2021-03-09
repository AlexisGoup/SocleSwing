package fr.diginamic.services.exemples;

import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.validator.FormValidator;

public class ModifierVehiculeValidator extends FormValidator {
	
	@Override
	public boolean validate(Form form) {
		String immat = form.getValue("champ1");
		String km = form.getValue("champ2");
		String statut = form.getValue("champ3");
		
		if (immat.trim().isEmpty()) {
			console.alert("L'immatriculatio est obligatoire !");
			return false;
		}
		
		else if (km.trim().isEmpty()) {
			console.alert("Le kilometrage est obligatoire !");
			return false;
		}
		
		else if (statut.trim().isEmpty()) {
			console.alert("Le statut est obligatoire !");
			return false;
		}
		return true;
	}
}
