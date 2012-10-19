package metier;

import java.util.HashMap;
import java.util.Set;

public class FabPersonne {

	public HashMap<String,Personne> personnes = new HashMap<String,Personne>();
	
	public Set<String> getNoms() { return personnes.keySet(); }
	
	public Personne getPersonne (String nom) {
		return personnes.get(nom); 
	}
	public void setPersonnes(HashMap<String, Personne> personnes) {
		this.personnes = personnes;	
	}
	public boolean existe(String nom) {
		return personnes.containsKey(nom);
	}
	public Personne creerTemplate (String nom) {
		Personne p = new Personne();
		p.setNom(nom);
		return p;
	}
	public void addPersonne(Personne p){
		if(!personnes.containsKey(p.getNom())){
			personnes.put(p.getNom(),p);
		}
		else{
			throw new ExistantException(p.getNom());
		}
			 
	}
	
	public void removePersonne(String nom)
		{personnes.remove(nom); }


}
