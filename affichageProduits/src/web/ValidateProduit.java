package web;

import org.springframework.validation.Errors;

public class ValidateProduit implements
		org.springframework.validation.Validator {

	public boolean supports(Class classe) {
		boolean assignableFrom = classe.isAssignableFrom(CommandAjout.class);
		return assignableFrom;
	}

	public void validate(Object obj, Errors erreurs) {
		// on récupère le produit posté
		CommandAjout command = (CommandAjout) obj;
		// on vérifie le nom
		String produit = command.getNouveauProduit();
		if (produit == null || produit.trim().length() == 0) {
			erreurs.rejectValue("nouveauProduit",
					"commandAjout.nouveauProduit.necessaire",
					"Le nom est nécessaire !");
		}
	}

}