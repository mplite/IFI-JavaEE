package metier;

import java.util.HashMap;
import java.util.Set;

public class FabVoiture {

	public HashMap<String, Voiture> voitures = new HashMap<String, Voiture>();
	
	public Set<String> getIds() { return voitures.keySet(); }
	
	public Voiture getVoiture (String id) {
		return  voitures.get(id); 
	}
	public void setvoitures(HashMap<String, Voiture> voitures) {
		this.voitures = voitures;	
	}
	public boolean existe(String id) {
		return voitures.containsKey(id);
	}
	public Voiture creerTemplate (String id) {
		Voiture v = new Voiture();
		v.setId(id);
		return v;
	}
	public void addVoiture(Voiture v){
		if(!voitures.containsKey(v.getId())){
			voitures.put(v.getId(),v); 
		}
		else{
			throw new ExistantException(v.getId());
		}
		
	}
	
	public void removeVoiture(String id)
		{voitures.remove(id); }


}
