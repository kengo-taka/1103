import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Patient {

	private int patientId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private LocalDate dateOfBirth;
	private String gender;

	public Patient(String firstName, String lastName, String phoneNumber, String email, String gender) {

		setPatientId();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		setDateOfBirth();
		this.gender = gender;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId() {
		Random rnd = new Random();
		this.patientId = rnd.nextInt(99001) + 1000;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {

		if (!gender.isEmpty() && !gender.equalsIgnoreCase(null)) {
			this.gender = gender;
		} else {
			this.gender = "unknown";
		}
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth() {
		long minDay = LocalDate.of(1970, 1, 1).toEpochDay();
		long maxDay = LocalDate.of(2010, 12, 31).toEpochDay();
		long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
		LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
		this.dateOfBirth = randomDate;
	}

	@Override
	public String toString() {
		return "Patient Id : " + patientId + "\nName : " + firstName + " " + lastName + "\nPhoneNumber : " + phoneNumber
				+ "\nemail : " + email + "\nDate of Birth : " + dateOfBirth + "\nGender : " + gender;
	}

}
