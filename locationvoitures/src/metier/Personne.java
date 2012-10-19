package metier;

import java.util.HashMap;
import java.util.Collection;


public class Personne {

	private String nom;
	private String prenom;
	
	private HashMap<String, Voiture> lesVoitures = new HashMap<String, Voiture>();
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public HashMap<String, Voiture> getlesVoitures() {
		return lesVoitures;
	}
	public void setlesVoitures(HashMap<String, Voiture> lesVoitures) {
		this.lesVoitures = lesVoitures;
	}
	
	public void addVoiture(Voiture v){
		if(!lesVoitures.containsKey(v.getId())){
			lesVoitures.put(v.getId(), v);
		}
		else{
			throw new ExistantException(v.getId());
		}
			
	}
	
	public Collection<Voiture> getVoitures() {
		return lesVoitures.values();
	}

}
