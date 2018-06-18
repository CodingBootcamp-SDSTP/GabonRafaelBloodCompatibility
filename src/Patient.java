class Patient extends Blood
{
	private String name;
	private int phone;
	private String address;
	private String email;

	public Patient(String n, int p, String a, String e, String t, String r) {
		name = n;
		phone = p;
		address = a;
		email = e;
		setType(t);
		setRheus(r);
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

	public void setName(String n) {
		name = n;
	}

	public void setPhone(int p) {
		phone = p;
	}

	public void setAddress(String a) {
		address = a;
	}
}
