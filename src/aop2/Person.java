package aop2;
import java.io.Serializable;

public class Person implements Serializable {
	//default serialVersion id
	  private static final long serialVersionUID = 1L;

	  private String name; // account person's first name
	  
	  private String lastName; // account person's Last name

	  private Address address; // account person's address

	  private String phoneNumber; // account person's phone number
	  
	  public Person(String name, String lastName, Address address, String phoneNumber) {
	       
		  /* Validate parameters 
	           * constructors: any invalid or missing values throw IllegalArgumentException
		   * Assign parameters's values to attributes 
		   */
	    if (name == null) {
	      throw new IllegalArgumentException ("No name was entered");
	  }
	    if (lastName == null) {
		      throw new IllegalArgumentException ("No name was entered");
		  }
	    if (address == null) {
	      throw new IllegalArgumentException ("No address was entered");
	  }
	    if (phoneNumber == null) {
	      throw new IllegalArgumentException ("No name was entered");
	  }
	    this.name = name;
	    this.lastName = lastName;
	    this.address = address;
	    this.phoneNumber = phoneNumber;
	    
	  }
	  public Person clone(){
	  Person personClone = new Person(this.name, this.lastName, this.address,this.phoneNumber);  
	  return personClone;

	  }
	  
	  public Person (String line) {
	    
	    name = line.substring(line.indexOf("<name>") + 8, line.indexOf("</name>"));
	    phoneNumber = line.substring(line.indexOf("<phoneNumber>") + 5, line.indexOf("</phoneNumber>"));
	    address = new Address(line);
	    
	    }
	  
	  public String toString( ) {
			
          return  name + " " + lastName + " " + 
                  address.toString() + " " +   
                   phoneNumber;	
	  }
	    public String getName() {
	          /* get name
	          * return name
	          */
	  return this.name;
	  }
	    public String getlastName() {
	          /* get name
	          * return name
	          */
	  return this.lastName;
	  }

	  public String getPhoneNumber() {
	          /* get phoneNumber
	          * return phoneNumber
	          */
	  return this.phoneNumber;
	  }
	  
	  public Address getAddress() {
	          /* get address
	          * return address
	          */
	  return this.address;
	  }

	  public void setName(String name) {
	        //validate parameter
	      if (name == null) {
	      throw new IllegalArgumentException ("No name was entered");
	  }
	        this.name = name;
	  }
	  public void setlastName(String lastName) {
	        //validate parameter
	      if (name == null) {
	      throw new IllegalArgumentException ("No name was entered");
	  }
	        this.lastName = lastName;
	  }

	  public void setPhoneNumber(String phoneNumber) {
	        //validate parameter
	      if (phoneNumber == null) {
	      throw new IllegalArgumentException ("No name was entered");
	  }
	        this.phoneNumber = phoneNumber;
	  }
	  
	    public void setAddress(String street, String city, String state, String zip) {
	   //validate parameter
	       if (address == null) {
	      throw new IllegalArgumentException ("No name was entered");
	  }
	  this.address = new Address(street,city,state,zip);
	  }
	}