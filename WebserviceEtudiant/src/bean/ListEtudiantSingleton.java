package bean;

import java.util.ArrayList;

public final class ListEtudiantSingleton {

	private ArrayList<Etudiant> listEtudiant;
	
	private static ListEtudiantSingleton instance;

	private ListEtudiantSingleton() {
		setListEtudiant(new ArrayList<Etudiant>());
		
		Etudiant cedric = new Etudiant();
		cedric.setPrenom("Cedric");
		cedric.setNom("Montay");
		cedric.setAge(23);
		cedric.setClasse("Master2 e services");
		
		Etudiant benjamin = new Etudiant();
		benjamin.setPrenom("Benjamin");
		benjamin.setNom("Jacquet");
		benjamin.setAge(22);
		benjamin.setClasse("Master2 e services");
		
		listEtudiant.add(cedric);
		listEtudiant.add(benjamin);
	}
	
	public static ListEtudiantSingleton getInstance() {
		if (instance == null) {
			instance = new ListEtudiantSingleton();
		}

		return instance;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	public ArrayList<Etudiant> getListEtudiant() {
		return listEtudiant;
	}

	public void setListEtudiant(ArrayList<Etudiant> listEtudiant) {
		this.listEtudiant = listEtudiant;
	}

}