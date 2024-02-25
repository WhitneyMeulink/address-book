package aop2;
import java.io.Serializable;
import java.util.*;
import java.util.Scanner;


public class AddressBook implements Serializable {
	//default serialVersion id
	  private static final long serialVersionUID = 1L;

ArrayList <Person> persons;
Scanner in = new Scanner(System.in);


//constructor
public AddressBook ()
{
persons = new ArrayList<Person>();
}

//Add new person record to arraylist after taking input
public void addPerson()
{
	String name;
	String lastName;
	Address address;
	String phoneNumber;
	String street;
	String city;
	String state;
	String zip;
		
		//Ask the user for what position they want to place their x or o
		System.out.print("Contact's first name: ");
		name = in.next();
		System.out.print("Contact's last name: ");
		lastName = in.next();
		System.out.print("Contact's Street: ");
		street = in.next();
		System.out.print("Contact's city: ");
		city = in.next();
		System.out.print("Contact's state: ");
		state = in.next();
		System.out.print("Contact's zip code: ");
		zip = in.next();
		System.out.print("Contact's phone number: ");
		phoneNumber = in.next();
		
		address = new Address(street, city, state, zip);
		
		Person p = new Person(name, lastName, address, phoneNumber);
		persons.add(p);

}
public void display () {
	for (int i = 0; i < persons.size(); i++)
	{
		System.out.println((Person)persons.get(i));
		
	}
}
public void remove (String name, String lastName) {
	for (int i = 0; i < persons.size(); i++) {
		Person p = (Person)persons.get(i);
		if (name.equalsIgnoreCase(p.getName()) && (lastName.equalsIgnoreCase(p.getlastName()))) {
			persons.remove(i);
			
		}
	}
}

public void update (String name, String lastName) {
	while (true)
	{	
int ch;
	for (int i = 0; i < persons.size(); i++) {
		Person p = (Person)persons.get(i);
		if (name.equalsIgnoreCase(p.getName()) && (lastName.equalsIgnoreCase(p.getlastName()))) {
			
			persons.set(i, p);
		
			System.out.print("Contact Update Menu:\n"
					+ "Enter 1 to update name \n"
					+ "Enter 2 to update address \n"
					+ "Enter 3 to update phone number \n"
					+ "Enter 4 to go back to Main Menu");
			
			ch = in.nextInt();
			switch(ch) {
			case 1:
				System.out.print("Contact's new first name: ");
				name = in.next();
				persons.get(i).setName(name);
				System.out.print("Contact's new last name: ");
				String lastName2 = in.next();
				persons.get(i).setlastName(lastName2);
				break;
			case 2:
				System.out.print("Contact's street address: ");
				String street = in.next();
				System.out.print("Contact's city: ");
				String city = in.next();
				System.out.print("Contact's state: ");
				String state = in.next();
				System.out.print("zip: ");
				String zip = in.next();
				persons.get(i).setAddress(street, city, state, zip);
				break;
			case 3:
				System.out.print("Contact's new phone number ");
				String phoneNumber = in.next();
				persons.get(i).setPhoneNumber(phoneNumber);
				break;
			case 4:
				addressBookMainMenu();
			}
			}
		}
	}
}
public void addressBookMainMenu () {
	while (true)
	{
		int ch;
		String name;
		System.out.print("Address Book Menu:\n"
				+ " Enter 1 to add contact \n"
				+ " Enter 2 to remove contact \n "
				+ "Enter 3 to display address book\n"
				+ " Enter 4 to update contact\n"
				+ " Enter 5 to exit");
		ch = in.nextInt();
		switch(ch) {
		case 1:
			addPerson();
			break;
		case 2:
			System.out.print("Contact's first name: ");
			name = in.next();
			System.out.print("Contact's last name: ");
			String lastName = in.next();
			remove(name, lastName);
			break;
		case 3:
			System.out.print("Address Book \n ");	
			display();
			break;
		case 4:
			System.out.print("Contact's first name: ");
			name = in.next();
			System.out.print("Contact's last name: ");
			lastName = in.next();
			update(name, lastName);
		case 5:
			System.exit(0);
		
		}	
	
	}
}
}


