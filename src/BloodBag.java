public class BloodBag
{
	private final int ID;
	private int label;
	private String donor;
	private String collectionDate;
	private String expiryDate;
	private Blood blood;

	public BloodBag(int id, String d, String cd, String ed, String type, String rheus, int l) {
		blood = new Blood(type, rheus);
		ID = id;
		label = l;
		donor = d;
		collectionDate = cd;
		expiryDate = ed;;
	}

	public void setBlood(Blood b) {
		blood = b;
	}

	public void setDonor(String d) {
		donor = d;
	}

	public void setCollectionDate(String cd) {
		collectionDate = cd;
	}

	public void setExpiryDate(String ed) {
		expiryDate = ed;
	}

	public void setLabel(int l) {
		label = l;
	}

	public int getID() {
		return(ID);
	}

	public Blood getBlood() {
		return(blood);
	}

	public String getDonor() {
		return(donor);
	}

	public String getCollectionDate() {
		return(collectionDate);
	}

	public String getExpiryDate() {
		return(expiryDate);
	}

	public int getLabel() {
		return(label);
	}
}
