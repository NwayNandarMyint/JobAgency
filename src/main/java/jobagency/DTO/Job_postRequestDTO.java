package jobagency.DTO;

import javax.validation.constraints.NotEmpty;

public class Job_postRequestDTO {
	private int id;
	@NotEmpty
	private String age_range;
	@NotEmpty
	private String salary;
	@NotEmpty
	private String background_education;
	@NotEmpty
	private String work_experiences;
	private boolean isActive;
	private String created_date;
	private String updated_date;
	@NotEmpty
	private String address;
	private int level_id;
	private String level_name;
	private int employer_id;
	private String employer_name;
	private int position_id;
	private String position_name;
	private String required_candidate;
	
	public Job_postRequestDTO() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAge_range() {
		return age_range;
	}
	public void setAge_range(String age_range) {
		this.age_range = age_range;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getBackground_education() {
		return background_education;
	}
	public void setBackground_education(String background_education) {
		this.background_education = background_education;
	}
	public String getWork_experiences() {
		return work_experiences;
	}
	public void setWork_experiences(String work_experiences) {
		this.work_experiences = work_experiences;
	}
	
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getLevel_id() {
		return level_id;
	}
	public void setLevel_id(int level_id) {
		this.level_id = level_id;
	}
	public int getEmployer_id() {
		return employer_id;
	}
	public void setEmployer_id(int employer_id) {
		this.employer_id = employer_id;
	}
	public int getPosition_id() {
		return position_id;
	}
	public void setPosition_id(int position_id) {
		this.position_id = position_id;
	}
	public String getLevel_name() {
		return level_name;
	}
	public void setLevel_name(String level_name) {
		this.level_name = level_name;
	}
	public String getEmployer_name() {
		return employer_name;
	}
	public void setEmployer_name(String employer_name) {
		this.employer_name = employer_name;
	}
	public String getPosition_name() {
		return position_name;
	}
	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}
	public String getRequired_candidate() {
		return required_candidate;
	}
	public void setRequired_candidate(String required_candidate) {
		this.required_candidate = required_candidate;
	}
}
