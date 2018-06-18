import java.util.ArrayList;

class PatientCollection
{
	ArrayList<Patient> patients;

	public PatientCollection() {
		patients = new ArrayList<Patient>();
	}

	public void addPatient(Patient patient) {
		patients.add(patient);
	}

	public void removePatient(Patient patient) {
		patients.remove(patient);
	}

	public ArrayList<Patient> getAllPatients() {
		return(patients);
	}

	public Patient getPatientByIndex(int n) {
		return(patients.get(n));
	}

	public int getPatientCount() {
		return(patients.size());
	}
}
