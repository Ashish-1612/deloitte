package designation.details;

public class Trainer extends UserInfo {
	private long contactNo;
	private String specialization;

	public Trainer() {
		super();
	}

	public Trainer(String name, String eMail, int userId, String userType, String password, long contactNo,
			String specialization) {
		super(name, eMail, userId, userType, password);
		this.contactNo = contactNo;
		this.specialization = specialization;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

}
