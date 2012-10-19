package web;

public class CommandAjout {

	private String nouveauProduit;

	public CommandAjout() {
		this.setNouveauProduit("tapez un nom");
	}

	public String getNouveauProduit() {
		return nouveauProduit;
	}

	public void setNouveauProduit(String nouveauProduit) {
		this.nouveauProduit = nouveauProduit;
	}
}
