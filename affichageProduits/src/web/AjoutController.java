package web;

import metier.AlcoholException;
import metier.Groupe;
import metier.ProduitPresentException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class AjoutController extends SimpleFormController {
	private Groupe groupe;

	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	protected Object formBackingObject(HttpServletRequest request) {
		return new CommandAjout();
	}

	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object commandAjout,
			BindException errors) throws Exception {
		CommandAjout command = (CommandAjout) commandAjout;
		try {
			groupe.addProduit(command.getNouveauProduit());
			return new ModelAndView("confirmation", "commandAjout", command);
		} catch (ProduitPresentException e) {
			errors.reject("commandAjout.echec", new Object[]{ command.getNouveauProduit() }, "produit déjà présent: {0}");
			return showForm(request, response, errors);
		} catch (AlcoholException e) {
			errors.reject("commandAjout.alcool", new Object[]{ command.getNouveauProduit() }, "{0} est de l'alcool: {0}");
			return showForm(request, response, errors);
		}

	}

}
