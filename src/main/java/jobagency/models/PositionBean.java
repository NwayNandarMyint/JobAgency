package jobagency.models;

import javax.validation.constraints.NotEmpty;

public class PositionBean {

	private int id;
	@NotEmpty
	private String name;
	private boolean is_delete;

	public PositionBean() {
		
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
	public boolean isIs_delete() {
		return is_delete;
	}

	public void setIs_delete(boolean is_delete) {
		this.is_delete = is_delete;
	}
	
}
