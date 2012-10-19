package demo;

import java.util.ArrayList;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import bean.Etudiant;
import bean.ListEtudiantSingleton;


@Path("/etudiant")
public class Lille1 {
	
	ListEtudiantSingleton listSingleton;
	ArrayList<Etudiant> listEtudiant;
	
	public Lille1(){
		listSingleton = ListEtudiantSingleton.getInstance();
		listEtudiant = listSingleton.getListEtudiant();
	}

  
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String getListEtudiantsText(){
	  StringBuilder buff = new StringBuilder();
	  for(Etudiant student : listEtudiant){
		  buff.append(student.getPrenom()).append(' ');
		  buff.append(student.getNom()).append(' ');
		  buff.append(student.getAge()).append(' ');
		  buff.append(student.getClasse()).append("\n");
	  }
	  
	  return buff.toString();
  }
  
  @GET
  @Produces(MediaType.TEXT_XML)
  public String getListEtudiantsXML(){
	  StringBuilder buff = new StringBuilder();
	  buff.append("<?xml version=\"1.0\"?>");
	  buff.append("<etudiants>");
	  for(Etudiant student : listEtudiant){
		  buff.append("<etudiant>");
		  buff.append("<prenom>").append(student.getPrenom()).append("</prenom>");
		  buff.append("<nom>").append(student.getNom()).append("</nom>");
		  buff.append("<age>").append(student.getAge()).append("</age>");
		  buff.append("<classe>").append(student.getClasse()).append("</classe>");
		  buff.append("</etudiant>");
	  }
	  buff.append("</etudiants>");
	  
	  return buff.toString();
  }
  
  @GET
  @Produces(MediaType.TEXT_HTML)
  public String getListEtudiantHTML(){
	  StringBuilder buff = new StringBuilder();
	  buff.append("<html>");
	  buff.append("<head>");
	  buff.append("<title>Liste des étudiants</title>");
	  buff.append("</head>");
	  buff.append("<body>");
	  buff.append("<table border='1'>");
	  buff.append("<tr><th>Prenom</th><th>Prenom</th><th>Age</th><th>Classe</th></tr>");
	  for(Etudiant student : listEtudiant){
		  buff.append("<tr>");
		  buff.append("<td>").append(student.getPrenom()).append("</td>");
		  buff.append("<td>").append(student.getNom()).append("</td>");
		  buff.append("<td>").append(student.getAge()).append("</td>");
		  buff.append("<td>").append(student.getClasse()).append("</td>");
		  buff.append("</tr>");
	  }
	  buff.append("</body>");
	  buff.append("</html>");
	  
	  return buff.toString();
  }
  
  @POST
  @Path("{prenom}/{nom}/{age}/{classe}")
  public String CreateEtudiant(@PathParam("prenom") String prenom, @PathParam("nom") String nom, @PathParam("age") int age, @PathParam("classe") String classe){
	  Etudiant student = new Etudiant();
	  student.setPrenom(prenom);
	  student.setNom(nom);
	  student.setAge(age);
	  student.setClasse(classe);
	  
	  if(!listEtudiant.contains(student)){
		  listEtudiant.add(student);
		  return "etudiant cree";
	  }
	  else{
		  return "etudiant deja dans la base";
	  }
  }
  
  @PUT
  @Path("{prenom}/{nom}/{age}/{classe}")
  public String EditEtudiant(@PathParam("prenom") String prenom, @PathParam("nom") String nom, @PathParam("age") int age, @PathParam("classe") String classe){
	  
	  
	  for(Etudiant student : listEtudiant){
		  if(student.getNom().equals(nom) && student.getPrenom().equals(prenom)){
			  listEtudiant.remove(student);
			  student.setAge(age);
			  student.setClasse(classe);
			  listEtudiant.add(student);
			  
			  return "etudiant modifie";
		  }
	  }
	  return "etudiant inexistant dans la base";
  }
  
  @DELETE
  @Path("{prenom}/{nom}")
  public String DeleteEtudiant(@PathParam("prenom") String prenom, @PathParam("nom") String nom){
	  for(Etudiant student : listEtudiant){
		  if(student.getNom().equals(nom) && student.getPrenom().equals(prenom)){
			  listEtudiant.remove(student);
			  
			  return "etudiant supprimé";
		  }
	  }
	  return "etudiant inexistant dans la base";
  }
  
  
  
} 
