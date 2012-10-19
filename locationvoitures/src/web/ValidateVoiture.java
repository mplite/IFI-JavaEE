package web;

import metier.Personne;
import metier.Voiture;

import org.springframework.validation.Errors;

public class ValidateVoiture implements
		org.springframework.validation.Validator {

	public boolean supports(Class classe) {
		boolean assignableFrom = classe.isAssignableFrom(Voiture.class);
		return assignableFrom;
	}

	public void validate(Object obj, Errors erreurs) {
		// on récupère le produit posté
		Voiture v = (Voiture) obj;
		// on vérifie le nom
		String id = v.getId();
		String modele = v.getModele();
		String couleur = v.getCouleur();
		
		if (id == null || id.trim().length() == 0) {
			erreurs.rejectValue("id",
					"fake",
					"L'id est nŽcessaire !");
		}
		if (modele == null || modele.trim().length() == 0) {
			erreurs.rejectValue("modele",
					"fake",
					"Le modele est nŽcessaire !");
		}
		if (couleur == null || couleur.trim().length() == 0) {
			erreurs.rejectValue("couleur",
					"fake",
					"La couleur est nŽcessaire !");
		}
		
	}

}