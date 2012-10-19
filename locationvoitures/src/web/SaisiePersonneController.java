package web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.FabPersonne;
import metier.Personne;
import metier.ExistantException;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class SaisiePersonneController extends SimpleFormController{

	private FabPersonne fabPersonnes;

	public FabPersonne getFabPersonnes() {
		return fabPersonnes;
	}

	public void setFabPersonnes(FabPersonne fabPersonnes) {
		this.fabPersonnes = fabPersonnes;
	}
	
	protected Object formBackingObject(HttpServletRequest request) {
		return new Personne();
	}

	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object personne,
			BindException errors) throws Exception {
		Personne person = (Personne) personne;
		try {
			fabPersonnes.addPersonne(person);
			return new ModelAndView("redirectionListePersonnes", "listerPersonnes", fabPersonnes.getNoms());
		}catch (ExistantException e){
			errors.rejectValue("nom", "fake", "Déja présent : " + e.getName());
			return showForm(request, response, errors);
		}

	}
	
}
