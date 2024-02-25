package aop2;
import java.io.Serializable;

public class Address implements Serializable {
	
	//default serialVersion id
    private static final long serialVersionUID = 1L;

	  private String street;

	  private String city;

	  private String state;

	  private String zip;
	  
	    public Address(String street, String city, String state, String zip) {

	          //Validate parameters and any invalid or missing values throw IllegalArgumentException
	      if (street == null  ) {
	      throw new IllegalArgumentException ("No street was entered");
	  }
	      if (city == null) {
	      throw new IllegalArgumentException ("No city was entered");
	  }
	        if (state == null  ) {
	      throw new IllegalArgumentException ("No state was entered");
	  }
	      if (zip == null) {
	      throw new IllegalArgumentException ("No zip was entered");
	  }
	      // Assign parameters's values to attributes 
	        this.street = street;
	    	this.city = city;
	    	this.state = state;
	    	this.zip = zip;
	  }
	    public Address(String line) {
	     this.street = line.substring(line.indexOf("<street>") + 8, line.indexOf("</street>"));
		 this.city = line.substring(line.indexOf("<city>") + 6, line.indexOf("</city>"));
		 this.state = line.substring(line.indexOf("<state>") + 7, line.indexOf("</state>"));
		 this.zip = line.substring(line.indexOf("<zip>") + 5, line.indexOf("</zip>"));
	    }
	    
	       public Address clone() {
	   	Address addressClone = new Address(this.street, this.city, this.state, this.zip);
	    	return addressClone;
	    
	    }
	    
	  public String getStreet() {
	  return this.street;
	       /* get street
	       *  return street
	       */
	  }

	  public String getCity() {
	  return this.city;
	       /* get city
	       *  return city
	       */
	  }

	  public String getState() {
	  return this.state;
	         /* get state
	          * return state
	          */
	  }

	  public String getZip() {
	  return this.zip;
	       /* get zip
	       *  return zip
	       */
	  } 
	  
	    public void setStreet(String street) {
	         /* validate parameter
	          * this.street = newStreet
	          */
	      if (street == null  ) {
	      throw new IllegalArgumentException ("No street was entered");
	  }
	         this.street = street;
	  }

	  public void setCity(String city) {
	         /* validate parameter
	          * this.city = newCity
	          */
	      if (city == null) {
	      throw new IllegalArgumentException ("No city was entered");
	  }
	         this.street = city;
	         
	  }

	  public void setState(String state) {
	         /* validate parameter
	          * this.state = newState
	          */
	      if (state == null  ) {
	      throw new IllegalArgumentException ("No state was entered");
	  }
	         this.state = state;
	  }

	  public void setZip(String zip) {
	         /* validate parameter
	          * this.zip = newZip
	          */
	      if (zip == null) {
	      throw new IllegalArgumentException ("No zip was entered");
	  }
	         this.zip = zip;
	  }
	  
	 
	  public String toString() {
		
	           return  street + " " +
	                   state + " " + 
	                   city+ " "  + zip + " " ;
	}
}