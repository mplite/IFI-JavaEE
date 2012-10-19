package web;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.FabPersonne;
import metier.FabVoiture;
import metier.Personne;
import metier.Voiture;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class ReservationController extends MultiActionController{

	FabPersonne fabPersonnes;
	FabVoiture fabVoitures;

	
	public FabPersonne getFabPersonnes() {
		return fabPersonnes;
	}

	public void setFabPersonnes(FabPersonne fabPersonnes) {
		this.fabPersonnes = fabPersonnes;
	}

	public FabVoiture getFabVoitures() {
		return fabVoitures;
	}

	public void setFabVoitures(FabVoiture fabVoitures) {
		this.fabVoitures = fabVoitures;
	}

	public ModelAndView list(HttpServletRequest request, HttpServletResponse response){
		
		HashMap<String, Object> mapReturn = new HashMap<String,Object>();
		
		mapReturn.put("listenoms", this.getFabPersonnes().getNoms());
		mapReturn.put("listevoitures", this.getFabVoitures().getIds());
		
		HttpSession session = request.getSession();	
	
		mapReturn.put("selectionVoiture", session.getAttribute("voirVoiture") );
		mapReturn.put("selectionPersonne", session.getAttribute("voirPersonne") );
		mapReturn.put("choixVoiture", session.getAttribute("choixVoiture") );
		mapReturn.put("choixPersonne", session.getAttribute("choixPersonne") );

		
		
		return new ModelAndView("Reservation", mapReturn);
	}
	
	public ModelAndView choixVoiture(HttpServletRequest request, HttpServletResponse response){
		
		String nomSelection = request.getParameter("listevoitures");
		
		HttpSession session = request.getSession();
		session.setAttribute("choixVoiture", fabVoitures.getVoiture(nomSelection));
		
		return list(request, response);
	}

	public ModelAndView choixPersonne(HttpServletRequest request, HttpServletResponse response){
		
		String nomSelection = request.getParameter("listepersonnes");
		
		HttpSession session = request.getSession();
		session.setAttribute("choixPersonne", fabPersonnes.getPersonne(nomSelection));
		
		return list(request, response);
	}
	
	public ModelAndView voirVoiture(HttpServletRequest request, HttpServletResponse response){
		
		String nomSelection = request.getParameter("listevoitures");
		

		HttpSession session = request.getSession();
		session.setAttribute("voirVoiture", fabVoitures.getVoiture(nomSelection));
		
		return list(request, response);
	}

	public ModelAndView voirPersonne(HttpServletRequest request, HttpServletResponse response){
		
		String nomSelection = request.getParameter("listepersonnes");
		
		HttpSession session = request.getSession();
		session.setAttribute("voirPersonne", fabPersonnes.getPersonne(nomSelection));
		
		return list(request, response);
	}
	
	public ModelAndView confirmer(HttpServletRequest request, HttpServletResponse response){
		
		HttpSession session = request.getSession();
		
		Voiture choixVoiture = (Voiture) session.getAttribute("choixVoiture");
		Personne choixPersonne = (Personne) session.getAttribute("choixPersonne");
		
		if( (choixVoiture!=null) && (choixPersonne!=null) ){
			choixPersonne.addVoiture(choixVoiture);
		}
		
		return list(request, response);
		
	}

	public ModelAndView annuler(HttpServletRequest request, HttpServletResponse response){
		
		HttpSession session = request.getSession(false);
		session.invalidate();
		return list(request, response);
				
	}
	
}

