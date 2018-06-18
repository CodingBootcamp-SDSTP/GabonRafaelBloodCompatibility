import java.util.ArrayList;
import java.sql.*;

class BloodManagerDatabase
{
	private PatientCollection patients;
	private BloodBagCollection bloodBags;
	private Connection conn;

	public BloodManagerDatabase() {
		patients = new PatientCollection();
		bloodBags = new BloodBagCollection();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://" + 
			"localhost/blooddb?user=rafael&password=kingpin&serverTimezone"+
			"=UTC&useSSL=false");
			readSQLTable(conn);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public PatientCollection getPatientCollection() {
		return(patients);
	}

	public BloodBagCollection getBloodBagCollection() {
		return(bloodBags);
	}

	public boolean readSQLTable(Connection conn) {
		Statement stmt = null;
		ResultSet rs = null;
		boolean result = false;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM patientlist");
			while(rs != null && rs.next()) {
				String[] p = {
					rs.getString("name"), 
					("phone"),
					("address"),
					("email"),
					("type"),
					("rheus"),
					"patient"
				};
				createObject(p);
			}
			rs = stmt.executeQuery("SELECT * FROM bloodbaglist");
			while(rs != null && rs.next()) {
				String[] b = {
					rs.getString("label"),
					("donor"),
					("collectiondate"),
					("expirydate"),
					("type"),
					("rheus"),
					"bloodbag"
				};
				createObject(b);
			}
			result=true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (rs != null) rs.close();
			}
			catch (Exception e) {};
			try {
				if (rs != null) rs.close();
			}
			catch (Exception e) {};
		}
		return(result);
	}

	public void createObject(String[] str) {
		int n = str.length-1;
		String s = str[n];
		switch(s) {
			case "patient" :
				Patient p = new Patient(str[0], Integer.parseInt(str[1]), str[2],
				str[3], str[4], str[5]);
				patients.addPatient(p);
			case "bloodbag" :
				BloodBag bb = new BloodBag(Integer.parseInt(str[0]), str[1],
				str[2], str[3], str[4], str[5]);
				bloodBags.addBloodBag(bb);
			break;
		}
	}
}
