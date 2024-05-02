package jobagency.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

public class EmployerBean {
	private int id;
	@NotEmpty
	private String name;
	@NotEmpty
	@Email
	private String email;
	@Size(min = 6)
	private String password;
	@Pattern(regexp = "^09[0-9]{9}$")
	private String phone_number;
	private MultipartFile logo;
	private String logoString;
	private String created_date;
	private String updated_date;
	private int avaliable_jobpost;
	private int industry_id;
	private String industry_name;
	
	public String getLogoString() {
		return logoString;
	}
	public void setLogoString(String logoString) {
		this.logoString = logoString;
	}
	public EmployerBean() {
		//this.created_date= LocalDateTime.now();
		
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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
	
	public String getPhone_number() {
		return phone_number;
	}
	
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
	public MultipartFile getLogo() {
		return logo;
	}
	
	public void setLogo(MultipartFile logo) {
		this.logo = logo;
	}
	
	public String getCreated_date() {
		return created_date;
	}
	
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}
	
	public String getUpdated_date() {
		return updated_date;
	}
	
	public void setUpdated_date(String updated_date) {
		this.updated_date = updated_date;
	}
	
	public int getAvaliable_jobpost() {
		return avaliable_jobpost;
	}
	
	public void setAvaliable_jobpost(int avaliable_jobpost) {
		this.avaliable_jobpost = avaliable_jobpost;
	}
	public int getIndustry_id() {
		return industry_id;
	}
	public void setIndustry_id(int industry_id) {
		this.industry_id = industry_id;
	}
	public String getIndustry_name() {
		return industry_name;
	}
	public void setIndustry_name(String industry_name) {
		this.industry_name = industry_name;
	}
	

}
