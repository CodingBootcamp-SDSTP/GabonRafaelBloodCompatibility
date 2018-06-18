class BloodBag extends Blood
{
	private String donor;
	private String collectionDate;
	private String expiryDate;
	private int label;

	public BloodBag( int l, String d, String cd, String ed, String t, String r) {
		label = l;
		donor = d;
		collectionDate = cd;
		expiryDate = ed;
		setType(t);
		setRheus(r);
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
}
