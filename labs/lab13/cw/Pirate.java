public class Pirate {
	private String pirateName;
	private String Country;
	Pirate(){
		pirateName = "";
		Country = "";
		
	}
	Pirate(String pirateName, String Country){
		this.pirateName = pirateName;
		this.Country = Country;
	}
	public void setPirateName(String pirateName) {
		this.pirateName = pirateName;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getCountry() {
		return Country;
	}
	public String getPirateName() {
		return pirateName;
	}


	public static void main(String[] args) {
		
		
		
	}
}
