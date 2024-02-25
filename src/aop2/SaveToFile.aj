package aop2;
import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public aspect SaveToFile {
	
	// ArrayList <Person> persons = new ArrayList<Person>();
	  private String filePath; 
	  Scanner in = new Scanner(System.in);
	
	  ArrayList <Person> persons = new ArrayList<Person>();
	  
	  
		//Pointcut 
		pointcut saveRemoved(AddressBook addressBook,String name,String lastName) : 
			execution(void AddressBook.remove(String,String)) 
			&& target (addressBook)
			&& args (name,lastName);
		 
				//An advice that will run after execution of play() method.
			    before(AddressBook addressBook,String name,String lastName): saveRemoved(addressBook,name,lastName)
			    
			    {
			    	
			    	for (int i = 0; i < addressBook.persons.size(); i++)
					{
			    		Person p = (Person)addressBook.persons.get(i);
						if(name.equalsIgnoreCase(p.getName()) && (lastName.equalsIgnoreCase(p.getlastName()))) {
				  
			        try {
			        	System.out.print("Enter the file path of where you would like backup saved. "
			        			+ "\n Example: C:/Users/wkpar/documents/BackUpContacts2 ");
						filePath = in.next();
						System.out.print("Is this a new file (Yes or No)");
						String answer = in.next();
						if (answer.equalsIgnoreCase("yes"))
						{
							boolean append = false;
							String outputText = "Record Deleted: " + addressBook.persons.get(i).getName() + " " + addressBook.persons.get(i).getlastName() +
						    		 " " + addressBook.persons.get(i).getAddress() + " " + addressBook.persons.get(i).getPhoneNumber();
						     
						     		saveToFile(filePath, outputText, append);
						}
						if (answer.equalsIgnoreCase("no"))
						{
							boolean append = true;	
							String outputText = "Record Deleted: " + addressBook.persons.get(i).getName() + " " + addressBook.persons.get(i).getlastName() +
						    		 " " + addressBook.persons.get(i).getAddress() + " " + addressBook.persons.get(i).getPhoneNumber();
						     
						     		saveToFile(filePath, outputText, append);
						}
			        	
			            
			        } catch (Exception ex) {
			            ex.printStackTrace();
			        }
				}
			}
		}
		
	  
		

			//Pointcut 
				pointcut saveUpdate(AddressBook addressBook,String name,String lastName) : 
					execution(void AddressBook.update(String,String)) 
					&& target (addressBook)
					&& args (name,lastName);
				 
						//An advice that will run after execution of play() method.
					    before(AddressBook addressBook,String name,String lastName): saveUpdate(addressBook,name,lastName)
					    
					    {
					    	
					    	for (int i = 0; i < addressBook.persons.size(); i++)
							{
					    		Person p = (Person)addressBook.persons.get(i);
								if(name.equalsIgnoreCase(p.getName()) && (lastName.equalsIgnoreCase(p.getlastName()))) {
						  
					        try {
					        	System.out.print("Enter the file path of where you would like backup saved. "
					        			+ "\n Example: C:/Users/wkpar/documents/BackUpContacts2 ");
								filePath = in.next();
								System.out.print("Is this a new file (Yes or No)");
								String answer = in.next();
								if (answer.equalsIgnoreCase("yes"))
								{
									boolean append = false;
									String outputText = "Record Updated: " + addressBook.persons.get(i).getName() + " " + addressBook.persons.get(i).getlastName() +
								    		 " " + addressBook.persons.get(i).getAddress() + " " + addressBook.persons.get(i).getPhoneNumber();
								     
								     		saveToFile(filePath, outputText, append);
								}
								if (answer.equalsIgnoreCase("no"))
								{
									boolean append = true;	
									String outputText = "Record Updated: " + addressBook.persons.get(i).getName() + " " + addressBook.persons.get(i).getlastName() +
						    		 " " + addressBook.persons.get(i).getAddress() + " " + addressBook.persons.get(i).getPhoneNumber();
								     
								     		saveToFile(filePath, outputText, append);
								}
					        	
					            
					        } catch (Exception ex) {
					            ex.printStackTrace();
					        }
						}	
					}
				}
				
					    
	  public void saveToFile(String fileName, String text, boolean append) throws IOException {
	//create a file	  
	File file1 = new File(fileName);
	//create a file writer class
	FileWriter fw  = new FileWriter(file1, append);
	//create a print writer class
	PrintWriter pw = new PrintWriter(fw);
	pw.println(text);
	pw.close();	
				
 }	

}
