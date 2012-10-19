package web;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.FabPersonne;
import metier.Personne;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class ListePersonnesController extends MultiActionController{
	
	FabPersonne fabPersonnes;
	
	public FabPersonne getFabPersonnes() {
		return fabPersonnes;
	}

	public void setFabPersonnes(FabPersonne fabPersonnes) {
		this.fabPersonnes = fabPersonnes;
	}

	public ModelAndView list(HttpServletRequest request, HttpServletResponse response){
		
		HashMap<String, Object> mapReturn = new HashMap<String,Object>();
		mapReturn.put("listenoms", this.getFabPersonnes().getNoms());
		
		return new ModelAndView("listerPersonnes", mapReturn);
	}

	public ModelAndView ajout(HttpServletRequest request, HttpServletResponse response){
		
		String nomNouveau = request.getParameter("nouveau");

		HashMap<String, Object> mapReturn = new HashMap<String,Object>();
		//mapReturn.put("nom", nomNouveau);
		
		return new ModelAndView("redirectionSaisiePersonneController", mapReturn);
		
	}

	public ModelAndView voir(HttpServletRequest request, HttpServletResponse response){
		
		String nomSelection = request.getParameter("listepersonnes");
		HashMap<String, Object> mapReturn = new HashMap<String,Object>();
		
		mapReturn.put("listenoms", this.getFabPersonnes().getNoms());
		mapReturn.put("selectionPersonne", fabPersonnes.getPersonne(nomSelection));
		
		return new ModelAndView("listerPersonnes", mapReturn);
	}
}
