package emailapp;


import java.util.Scanner;

/**
 * Simple Email App
 * @author YSL 3.0
 * @version 1.0
 *
 */
public class Email {
	//Basic user properties
	private String firstName;
	private String lastName;
	private String department;
	private String email;
	private String password;
	private int mailboxCapacity = 500;
	private String alternateEmail;
	private int defaultPasswordLenght = 10;
	private String companyDomaineName = "hainova.com";


	// Constructor to receive the first name and the last name

	/**
	 *
	 * @param firstName
	 * @param lastName
	 */
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName ; 
		
		// Call a method asking for department - return the department
		this.department = setDepartment();
		
		// Call a method that return a random password 
		this.password = randomPassword(defaultPasswordLenght);
		System.out.println("Your password is : " + this.password);
		//Combine elements to generate email 
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companyDomaineName.toLowerCase();
		
		
	}
	//Ask for the department

	/**
	 *
	 * @return the key number of the departement
	 */
	public String setDepartment() {
		System.out.print("New worker " + firstName + " DEPARTEMENT CODE \n 1 : Sales\n 2 : Development\n 3 : Accounting\n 0 : none\nEnter department code:  ");
		try (Scanner in = new Scanner(System.in)) {
			int depChoice = in.nextInt();
			if (depChoice == 1) { return "sales"; }
			else if (depChoice == 2) { return "development"; }
			else if (depChoice == 3) { return "accounting"; }
			else
				System.out.println("Incorrect Departement");
			    setDepartment();
				return "";
		}
	}
	
	//Generate random password

	/**
	 *
	 * @param length : the length of the password
	 * @return : random password
	 */
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@$%#";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int)(Math.random()*(passwordSet.length() - 0 + 1) );
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	//Set a new password
	public void changePassword(String password) {
		this.password = password;
	}
	
	
	//Display user informations
	public String showInfo() {
		return "NAME: " + firstName + " " + lastName +
				"\nEMAIL; " + email +
				"\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
	}

	/**
	 *
	 * Getters,  setters
	 */
	public String getPassword() {return password;}
	public int getMailboxCapacity() {return mailboxCapacity;}
	// Set the mailbox capacity
	public void setMailboxCapacity(int capacity) {this.mailboxCapacity = capacity;}
	public String getAlternateEmail() {return alternateEmail;}
	// Set the alternate email
	public void setAlternateEmail(String altEmail) {this.alternateEmail = altEmail;}

}
