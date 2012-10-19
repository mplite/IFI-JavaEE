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
		// on r�cup�re le produit post�
		Personne p = (Personne) obj;
		// on v�rifie le nom
		String nom = p.getNom();
		String prenom = p.getPrenom();
		if (nom == null || nom.trim().length() == 0) {
			erreurs.rejectValue("nom",
					"fake",
					"Le nom est n�cessaire !");
		}
		if (prenom == null || prenom.trim().length() == 0) {
			erreurs.rejectValue("prenom",
					"fake",
					"Le pr�nom est n�cessaire !");
		}
	}

}