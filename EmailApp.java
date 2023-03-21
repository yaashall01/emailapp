package emailapp;

public class EmailApp {
	public static void main(String[] args) {
		Email em1 = new Email("loco","naruto");
		System.out.println(em1.showInfo());
		System.out.println(em1.getPassword());
		System.out.println("______________________________________________________");
		em1.changePassword("newpassword");
		System.out.println(em1.getPassword());



	}

}
