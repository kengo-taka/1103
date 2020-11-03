import java.util.ArrayList;
import java.util.Random;

public class Doctor {

	private int doctorId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private String specialty;
    private ArrayList<Appointment> appointment;
    
    
    
    
	public Doctor( String firstName, String lastName, String phoneNumber, String email, String specialty
			) {
		
		setDoctorId();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.specialty = specialty;
		this.appointment = new ArrayList<Appointment>();
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId() {
		 Random rnd = new Random();
			this.doctorId = rnd.nextInt(99001)+1000;
		}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		if (!firstName.isEmpty() && !firstName.equalsIgnoreCase(null)) {
			this.firstName = firstName;
		} else {
		this.firstName = "unknown";
		}
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		if (!lastName.isEmpty() && !lastName.equalsIgnoreCase(null)) {
			this.lastName = lastName;
		} else {
		this.lastName = "unknown";
		}
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		if (!phoneNumber.isEmpty() && !phoneNumber.equalsIgnoreCase(null)) {
			this.phoneNumber = phoneNumber;
		} else {
		this.phoneNumber = "unknown";
		}
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if (!email.isEmpty() && !email.equalsIgnoreCase(null)) {
			this.email = email;
		} else {
		this.email = "unknown";
		}
	}
	public String getspecialty() {
		return specialty;
	}
	public void setspecialty(String specialty) {
		if (!specialty.isEmpty() && !specialty.equalsIgnoreCase(null)) {
			this.specialty = specialty;
		} else {
		this.specialty = "unknown";
		}
	}
	public ArrayList<Appointment> getAppointment() {
		return appointment;
	}
	public void setAppointment(ArrayList<Appointment> appointment) {
		this.appointment = appointment;
	}
	@Override
	public String toString() {
		return "DoctorId : " + doctorId + 
				"\nName : " + firstName + " "+lastName + 
				"\nPhoneNumber : "+ phoneNumber +
				"\nemail : " + email + 
				"\nSpecialty : " + specialty;
	}
	
	public void add(Appointment appointment) {
		this.appointment.add(appointment);
		
	}
	
    
    
}
