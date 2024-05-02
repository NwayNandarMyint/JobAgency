package jobagency.DTO;

import javax.validation.constraints.NotEmpty;

public class LanguageRequestDTO {

	private int id;
	@NotEmpty
	private String name;
	private int is_delete;
	
	public LanguageRequestDTO() {
		
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

	public int getIs_delete() {
		return is_delete;
	}
	public void setIs_delete(int is_delete) {
		this.is_delete = is_delete;
	}
	
	
}

