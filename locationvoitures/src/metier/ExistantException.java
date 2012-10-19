package metier;

 public class ExistantException extends RuntimeException {
	 
	private static final long serialVersionUID = 1L;
	private String name;
	
	public ExistantException(String name) {
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
}
