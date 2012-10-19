package web;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.FabVoiture;
import metier.Voiture;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class ListeVoituresController extends MultiActionController {
	
	FabVoiture fabVoitures;
	
	public FabVoiture getFabVoitures() {
		return fabVoitures;
	}

	public void setFabVoitures(FabVoiture fabVoitures) {
		this.fabVoitures = fabVoitures;
	}

	public ModelAndView list(HttpServletRequest request, HttpServletResponse response){
		
		HashMap<String, Object> mapReturn = new HashMap<String,Object>();
		mapReturn.put("listevoitures", this.getFabVoitures().getIds());
		
		return new ModelAndView("listerVoitures", mapReturn);
	}
	
	public ModelAndView ajout(HttpServletRequest request, HttpServletResponse response){
		
		String IdNouveau = request.getParameter("nouveau");

		HashMap<String, Object> mapReturn = new HashMap<String,Object>();
		//mapReturn.put("nom", IdNouveau);
		
		return new ModelAndView("redirectionSaisieVoitureController", mapReturn);
	}

	public ModelAndView voir(HttpServletRequest request, HttpServletResponse response){
		
		String nomSelection = request.getParameter("listevoitures");
		HashMap<String, Object> mapReturn = new HashMap<String,Object>();
		
		mapReturn.put("listevoitures", this.getFabVoitures().getIds());
		mapReturn.put("selectionVoiture", fabVoitures.getVoiture(nomSelection));
		
		return new ModelAndView("listerVoitures", mapReturn);
	}
}

