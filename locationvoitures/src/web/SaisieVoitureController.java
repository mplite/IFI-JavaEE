package web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.ExistantException;
import metier.FabVoiture;
import metier.Voiture;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class SaisieVoitureController extends SimpleFormController{

	private FabVoiture fabVoitures;

	public FabVoiture getFabVoitures() {
		return fabVoitures;
	}

	public void setFabVoitures(FabVoiture fabVoitures) {
		this.fabVoitures = fabVoitures;
	}

	
	protected Object formBackingObject(HttpServletRequest request) {
		return new Voiture();
	}

	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object voiture,
			BindException errors) throws Exception {
		Voiture voitur = (Voiture) voiture;
		try {
			fabVoitures.addVoiture(voitur);
			return new ModelAndView("redirectionListeVoitures", "listerVoitures", voitur);
		}catch (ExistantException e){
			errors.rejectValue("id", "fake", "Déja présent : " + e.getName());
			return showForm(request, response, errors);
		}

	}


	
}
