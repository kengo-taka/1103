import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {

		Patient patient1 = new Patient("Aidan", "Dandan", "000111001", "aidan1@com", "male");
		Patient patient2 = new Patient("Albert", "Abreu", "000111002", "aidan2@com", "female");
		Patient patient3 = new Patient("Luis", "Britton", "000111003", "aidan3@com", "male");
		Patient patient4 = new Patient("Aroldis", "Chapman", "000111004", "aidan4@com", "female");
		Patient patient5 = new Patient("Gerit", "Cole", "000111005", "aidan5@com", "male");
		Patient patient6 = new Patient("Deivi", "Gracia", "000111006", "aidan6@com", "female");
		Patient patient7 = new Patient("Domingo", "German", "000111007", "aidan7@com", "male");
		Patient patient8 = new Patient("Luis", "Gil", "000111008", "aidan8@com", "female");
		Patient patient9 = new Patient("Chad", "Green", "000111009", "aidan9@com", "male");
		Patient patient10 = new Patient("Ben", "Heller", "000111010", "aidan10@com", "female");

		ArrayList<Patient> pList = new ArrayList<Patient>();
		pList.add(patient1);
		pList.add(patient2);
		pList.add(patient3);
		pList.add(patient4);
		pList.add(patient5);
		pList.add(patient6);
		pList.add(patient7);
		pList.add(patient8);
		pList.add(patient9);
		pList.add(patient10);

		Doctor doctor1 = new Doctor("Marina", "Yamamoto", "000222000", "marina1@com", "Pulmonologists");
		Doctor doctor2 = new Doctor("Kengo", "Takamiya", "000222000", "marina2@com", "Gastroenterologists");
		Doctor doctor3 = new Doctor("Abbas", "John", "000222000", "marina3@com", "Nephrologists");
		Doctor doctor4 = new Doctor("Moy", "Taro", "000222000", "marina4@com", "Urologist");

		ArrayList<Doctor> dList = new ArrayList<Doctor>();

		dList.add(doctor1);
		dList.add(doctor2);
		dList.add(doctor3);
		dList.add(doctor4);

		Appointment appointment1 = new Appointment(patient1, LocalDateTime.of(2020, 12, 15, 23, 30));
		Appointment appointment2 = new Appointment(patient2, LocalDateTime.of(2020, 11, 15, 20, 30));

		doctor1.add(appointment1);
		doctor2.add(appointment2);

//		appointment1.addPatient(patient1);
//		appointment1.addPatient(patient1);

		ArrayList<Appointment>aList = new ArrayList<Appointment>();
		aList.add(appointment1);
		aList.add(appointment2);

//		pList.get(1).addAppointment(appointment1);
//		pList.get(2).addAppointment(appointment2);
//        dList.get(1).addAppointment(appointment1);	
//		dList.get(2).addAppointment(appointment2);
//		

		printInformation(pList, dList);
		areYouPatOrDoc(pList, dList);
	}

//print first name, last name and id
	public static void printInformation(ArrayList<Patient> pList, ArrayList<Doctor> dList) {
		System.out.println("Patient list");
		for (Patient p : pList) {
			System.out.println("Name : " + p.getFirstName() + " " + p.getLastName() + ", id : " + p.getPatientId());
		}
		System.out.println("-----------------------\nDoctor list");

		for (Doctor d : dList) {
			System.out.println("Name : " + d.getFirstName() + " " + d.getLastName() + ", id : " + d.getDoctorId());
		}
	}

//	ask patient or doctor
	public static void areYouPatOrDoc(ArrayList<Patient> pList, ArrayList<Doctor> dList) {
		Scanner input = new Scanner(System.in);
		System.out.println("Who are you? Please enter 'p' or 'd' or 'e'.( p : patient, d : doctor, e : end )");
		String str = input.nextLine().toLowerCase();

		switch (str) {
		case "p":
//				getPatient(pList);
			Patient returnPatient = getPatient(pList);
//				makeAppointment(returnPatient);
			Appointment newAppo = makeAppointment(returnPatient);
//				newAppo.addPatient(returnPatient);
			Doctor returnDoctor = getDoctor(dList);
			returnDoctor.add(newAppo);
			printForPatient(pList, returnPatient, newAppo, returnDoctor);
			break;
		case "d":
//				getDoctor(dList);
//				Doctor returnDoctor2 = getDoctor(dList);
			printForDoctor(getDoctor(dList));
			break;
		case "e":
			System.out.println("See you");
			break;
		default:
			System.err.println("Please enter again");
			areYouPatOrDoc(pList, dList);
			break;

		}
	}

//	search for patient
	public static Patient getPatient(ArrayList<Patient> pList) {
		Scanner input = new Scanner(System.in);
		Patient patient = null;

		System.out.println("Please enter your patient ID");
		int num = input.nextInt();
		for (Patient p : pList) {
			if (p.getPatientId() == num) {
				patient = p;
				return patient;
			}
		}
		if (patient == null) {
			System.err.println("We cannot find your Id. Please enter again.");
			getPatient(pList);
		}
		return patient;
	}

//	search for doctor
	public static Doctor getDoctor(ArrayList<Doctor> dList) {
		Scanner input = new Scanner(System.in);
		Doctor doctor = null;
		System.out.println("Please enter your Doctor ID");
		int num = input.nextInt();
		for (Doctor p : dList) {
			if (p.getDoctorId() == num) {
				doctor = p;
				return doctor;
			}
		}
		if (doctor == null) {
			System.err.println("We cannot find your Id. Please enter again.");
			getDoctor(dList);
		}
		return doctor;
	}

//ask the date and time for the appointment
	public static Appointment makeAppointment(Patient patient) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter year of appointment");
		int year = input.nextInt();
		System.out.println("Please enter month of appointment");
		int month = input.nextInt();
		System.out.println("Please enter day of appointment");
		int day = input.nextInt();
		System.out.println("Please enter hour of appointment");
		int hour = input.nextInt();
		System.out.println("Please enter minute of appointment");
		int minute = input.nextInt();

		LocalDateTime appointment = LocalDateTime.of(year, month, day, hour, minute);
		Appointment newAppointment = new Appointment(patient, appointment);
		return newAppointment;
	}

//	appointment information for patient
	public static void printForPatient(ArrayList<Patient> pList, Patient patient, Appointment appointment,
			Doctor doctor) {
		
//		for (int i = 0; i < aList.size(); i++) {
//			if (aList.get(i).getPatient() == patient) {
//				System.out.println(aList.get(i).getAppointmentDate().getYear() + " " + aList.get(i).getAppointmentDate().getMonth() + " "+aList.get(i).getAppointmentDate().getDayOfMonth() +
//						" " + aList.get(i).getAppointmentDate().getHour() + ":" +aList.get(i).getAppointmentDate().getMinute() + " ");  
//			}
//		}
//		
		System.out.println("Patient Name " + patient.getFirstName() + " " + patient.getLastName()
				+ " \n----------------\n" + "Your Appointment is with Dr " + doctor.getFirstName() + " "
				+ doctor.getLastName() + "\n" + appointment + "\nDoctor information" + doctor
				+ "\n----------------\nPatient information" + patient);

	}

	public static void printForDoctor(Doctor doctor) {
		System.out.println("Doctor Name " + doctor.getFirstName() + " " + doctor.getLastName()
				+ "\nYour appointment information is");
		for (Appointment a : doctor.getAppointment()) {
			System.out.println(a.toString() + "\nPatient information\n" + a.getPatient());
		}
		System.out.println("-----------------\nDoctor information\n" + doctor);
	}

}