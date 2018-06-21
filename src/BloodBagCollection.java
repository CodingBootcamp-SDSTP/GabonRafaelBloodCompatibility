import java.util.ArrayList;

public class BloodBagCollection
{
	ArrayList<BloodBag> bloodBags;

	public BloodBagCollection() {
		bloodBags = new ArrayList<BloodBag>();
	}

	public void addBloodBag(BloodBag bloodBag) {
		bloodBags.add(bloodBag);
	}

	public void removeBloodBag(BloodBag bloodBag) {
		bloodBags.remove(bloodBag);
	}

	public ArrayList<BloodBag> getAllBloodBags() {
		return(bloodBags);
	}

	public BloodBag getBloodBagByIndex(int n) {
		return(bloodBags.get(n));
	}

	public int getBloodBagCount() {
		return(bloodBags.size());
	}
}
