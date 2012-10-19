package web;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Groupe;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Affichage implements Controller {

	// un groupe de produits fourni par le contexte de l'application
	private Groupe groupe;

	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	// gestion de la requête
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		HashMap<String, Object> mapReturn = new HashMap<String,Object>();
		
		mapReturn.put("groupe", groupe.getProduits());
		
		return new ModelAndView("vueproduits", mapReturn);
	}

}