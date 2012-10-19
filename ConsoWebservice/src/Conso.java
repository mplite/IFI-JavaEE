import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;




public class Conso {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClientConfig config = new DefaultClientConfig();
	    Client client = Client.create(config);
	    WebResource service = client.resource(getBaseURI());
	    // Fluent interfaces
	    System.out.println(service.path("etudiant").accept(MediaType.TEXT_PLAIN).get(ClientResponse.class).toString());
	   
	    
	    // Post etudiant
	    System.out.println(service.path("etudiant").path("Benjamin").path("Bellangeon").path("22").path("Master2 e services").post(String.class));
	    
	    // Put etudiant
	    System.out.println(service.path("etudiant").path("Benjamin").path("Bellangeon").path("5").path("Master2 e services").put(String.class));
	    
	    // Delete etudiant
	    System.out.println(service.path("etudiant").path("Benjamin").path("Jacquet").delete(String.class));
	    
	    // Get Listetudiant text
	    System.out.println(service.path("etudiant").accept(MediaType.TEXT_PLAIN).get(String.class));
	    // Get Listetudiant XML
	    System.out.println(service.path("etudiant").accept(MediaType.TEXT_XML).get(String.class));
	    // Get Listetudiant HTML
	    System.out.println(service.path("etudiant").accept(MediaType.TEXT_HTML).get(String.class));
	    
	    
	    

	  }

	  private static URI getBaseURI() {
	    return UriBuilder.fromUri("http://localhost:8080/WebserviceEtudiant").build();
	  }

}
