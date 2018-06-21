import java.util.ArrayList;
import java.sql.*;

public class BloodManagerDatabase
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
			"localhost/projectdb?user=gabon&password=projects&serverTimezone"+
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
			rs = stmt.executeQuery("SELECT * FROM bloodlist INNER JOIN patients on" +
			" bloodlist.bloodid=patients.bloodid;");
			while(rs != null && rs.next()) {
				String[] p = {
					rs.getString("patientsid"),
					rs.getString("name"), 
					rs.getString("phone"),
					rs.getString("address"),
					rs.getString("email"),
					rs.getString("typeid"),
					rs.getString("rheusid"),
					"patient"
				};
				createObject(p);
			}
			rs = stmt.executeQuery("SELECT * FROM bloodlist INNER JOIN bloodbags on" +
			" bloodlist.bloodid=bloodbags.bloodid;");
			while(rs != null && rs.next()) {
				String[] b = {
					rs.getString("bloodbagsid"),
					rs.getString("donor"),
					rs.getString("collectiondate"),
					rs.getString("expirydate"),
					rs.getString("typeid"),
					rs.getString("rheusid"),
					rs.getString("label"),
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
			try { if (rs != null) rs.close();  } catch (Exception e) {};
			try { if (rs != null) rs.close(); } catch (Exception e) {};
		}
		return(result);
	}

	public void createObject(String[] str) {
		int n = str.length-1;
		String s = str[n];
		switch(s) {
			case "patient" :
				Patient p = new Patient(Integer.parseInt(str[0]), str[1],
				Integer.parseInt(str[2]), str[3], str[4], str[5], str[6]);
				patients.addPatient(p);
			break;
			case "bloodbag" :
				BloodBag bb = new BloodBag(Integer.parseInt(str[0]), str[1],
				str[2], str[3], str[4], str[5], Integer.parseInt(str[6]));
				bloodBags.addBloodBag(bb);
			break;
		}
	}
}
