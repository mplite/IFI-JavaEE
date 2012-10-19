package web;

import org.springframework.validation.Errors;

public class ValidateProduit implements
		org.springframework.validation.Validator {

	public boolean supports(Class classe) {
		boolean assignableFrom = classe.isAssignableFrom(CommandAjout.class);
		return assignableFrom;
	}

	public void validate(Object obj, Errors erreurs) {
		// on r�cup�re le produit post�
		CommandAjout command = (CommandAjout) obj;
		// on v�rifie le nom
		String produit = command.getNouveauProduit();
		if (produit == null || produit.trim().length() == 0) {
			erreurs.rejectValue("nouveauProduit",
					"commandAjout.nouveauProduit.necessaire",
					"Le nom est n�cessaire !");
		}
	}

}