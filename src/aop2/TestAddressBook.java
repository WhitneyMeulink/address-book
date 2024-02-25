package aop2;
import java.util.Scanner;
public class TestAddressBook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
AddressBook addressBook = new AddressBook();
try (Scanner in = new Scanner(System.in)) {
	
	Address address1 = new Address("1111 Evergreen St", "Tacoma", "WA", "99999");
	Person Mike = new Person("Mike", "Jackson", address1, "444-444-4444");
	addressBook.persons.add(Mike);
	Address address2 = new Address("2222 Pacific Ave", "Olympia", "WA", "99555");
	Person Chris = new Person("Chris", "Roberts", address2, "555-555-5555");
	addressBook.persons.add(Chris);
	Address address3 = new Address("3333 Forest Lp", "Seattle", "WA", "99222");
	Person Sally = new Person("Sally", "Baker", address3, "777-777-7777");
	addressBook.persons.add(Sally);
	
	addressBook.addressBookMainMenu ();
}
}
}
