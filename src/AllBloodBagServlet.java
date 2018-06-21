import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;

public class AllBloodBagServlet extends HttpServlet
{

	BloodBagCollection bloodbags;

	public void init() throws ServletException {
		BloodManagerDatabase bmd = new BloodManagerDatabase();
		bloodbags = bmd.getBloodBagCollection();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
		res.setContentType("text/xml");
		PrintWriter p = res.getWriter();
		p.print(exportToXML());
	}

	public String exportToXML() {
		StringBuffer sb = new StringBuffer("<bloodbags>");
		ArrayList<BloodBag> bloodBag = bloodbags.getAllBloodBags();
		for(BloodBag bb : bloodBag) {
			sb.append("<bloodbag><id>");
			sb.append(bb.getID());
			sb.append("</id><donor>");
			sb.append(bb.getDonor());
			sb.append("</donor><collectiondate>");
			sb.append(bb.getCollectionDate());
			sb.append("</collectiondate><expirydate>");
			sb.append(bb.getExpiryDate());
			sb.append("</expirydate><type>");
			sb.append(bb.getBlood().getTYPE());
			sb.append("</type><rheus>");
			sb.append(bb.getBlood().getRHEUS());
			sb.append("</rheus><label>");
			sb.append(bb.getLabel());
			sb.append("</label></bloodbag>");
		}
		sb.append("</bloodbags>");
		return(sb.toString());
	}

	public void destroy() {
		bloodbags = null;
	}
}