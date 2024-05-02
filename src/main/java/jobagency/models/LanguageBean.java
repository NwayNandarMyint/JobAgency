package jobagency.models;

import javax.validation.constraints.NotEmpty;

public class LanguageBean {

	private int id;
	@NotEmpty
	private String name;
	private int is_delete;
	
	public LanguageBean() {
		
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
//	@Override
//	public int hashCode() {
//		return Objects.hash(id,language);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		LanguageBean other = (LanguageBean) obj;
//		return Objects.equals(id, other.id) && Objects.equals(language, other.language);
//	}
	
	
}
