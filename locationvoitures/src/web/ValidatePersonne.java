package web;

import metier.Personne;

import org.springframework.validation.Errors;

public class ValidatePersonne implements
		org.springframework.validation.Validator {

	public boolean supports(Class classe) {
		boolean assignableFrom = classe.isAssignableFrom(Personne.class);
		return assignableFrom;
	}

	public void validate(Object obj, Errors erreurs) {
		// on récupère le produit posté
		Personne p = (Personne) obj;
		// on vérifie le nom
		String nom = p.getNom();
		String prenom = p.getPrenom();
		if (nom == null || nom.trim().length() == 0) {
			erreurs.rejectValue("nom",
					"fake",
					"Le nom est nŽcessaire !");
		}
		if (prenom == null || prenom.trim().length() == 0) {
			erreurs.rejectValue("prenom",
					"fake",
					"Le prŽnom est nŽcessaire !");
		}
	}

}