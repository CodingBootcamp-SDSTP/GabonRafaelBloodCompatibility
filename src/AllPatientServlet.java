import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;

public class AllPatientServlet extends HttpServlet
{

	PatientCollection patients;

	public void init() throws ServletException {
		BloodManagerDatabase bmd = new BloodManagerDatabase();
		patients = bmd.getPatientCollection();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
		System.out.println("AllPatientServlet is now connected..");
		res.setContentType("text/xml");
		PrintWriter p = res.getWriter();
		p.print(exportToXML());
	}

	public String exportToXML() {
		StringBuffer sb = new StringBuffer("<patients>");
		ArrayList<Patient> patient = patients.getAllPatients();
		for(Patient p : patient) {
			sb.append("<patient><name>");
			sb.append(p.getName());
			sb.append("</name><phone>");
			sb.append(p.getPhone());
			sb.append("</phone><address>");
			sb.append(p.getAddress());
			sb.append("</address><type>");
			sb.append(p.getType());
			sb.append("</type><rheus>");
			sb.append(p.getRheus());
			sb.append("</rheus></patient>");
		}
		sb.append("</patients>");
		return(sb.toString());
	}

	public void destroy() {
		patients = null;
	}
}