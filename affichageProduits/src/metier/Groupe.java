package metier;

import java.util.ArrayList;

public class Groupe {

	private ArrayList<String> produits;

	public ArrayList<String> getProduits() {
		return produits;
	}

	public void setProduits(ArrayList<String> produits) {
		this.produits = produits;
	}
	
	public void addProduit (String produit) {
		if (produits.contains(produit)){
			throw new ProduitPresentException();
		}
		if (produit.equals("biere")
				|| produit.equals("rhum")
				|| produit.equals("vodka")){
			throw new AlcoholException();
		}
		produits.add(produit);
	}
}