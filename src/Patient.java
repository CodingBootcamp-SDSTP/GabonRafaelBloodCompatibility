public class Patient
{
	final int ID;
	private String name;
	private int phone;
	private String address;
	private String email;
	private Blood blood;

	public Patient(int id, String n, int p, String a, String e, String type, String rheus) {
		ID = id;
		name = n;
		phone = p;
		address = a;
		email = e;
		blood = new Blood(type, rheus);
	}

	public void setBlood(Blood b) {
		blood = b;
	}

	public void setName(String n) {
		name = n;
	}

	public void setPhone(int p) {
		phone = p;
	}

	public void setAddress(String a) {
		address = a;
	}

	public void setEmail(String e) {
		email = e;
	}

	public int getID() {
		return(ID);
	}

	public Blood getBlood() {
		return(blood);
	}

	public String getName() {
		return(name);
	}

	public int getPhone() {
		return(phone);
	}

	public String getAddress() {
		return(address);
	}

	public String getEmail() {
		return(email);
	}
}
