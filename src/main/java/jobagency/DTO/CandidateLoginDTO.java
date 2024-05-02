package jobagency.DTO;

public class CandidateLoginDTO {
	public String email;
	public String password;
	public CandidateLoginDTO() {
		
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
