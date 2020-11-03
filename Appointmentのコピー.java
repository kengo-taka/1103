import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Appointment {

	private Patient patient;
	private LocalDateTime appointmentDate;

	public Appointment(Patient patient, LocalDateTime time) {
		this.patient = patient;
		setAppointmentDate(time);
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public LocalDateTime getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDateTime time) {
		this.appointmentDate = time;
	}

	@Override
	public String toString() {
		return "AppointmentDate : " +
				appointmentDate.getYear() + " " +
				appointmentDate.getMonth() +" " +
				appointmentDate.getDayOfMonth() + " " +
				appointmentDate.getHour() + ":" + appointmentDate.getMinute() + 
				"\nPatient is "+ patient.getFirstName() + " "+ patient.getLastName() + "\n----------------";
		}

}
