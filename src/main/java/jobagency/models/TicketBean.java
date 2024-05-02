package jobagency.models;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Range;
import org.springframework.web.multipart.MultipartFile;

public class TicketBean {
	  private int id;
	  @Range(min=1000,max=1000000)
	  private double amount;
	  @Range(min=1,max=200)
	  private int post;
	  private int admin_id;
	  private String admin_name;
	  @NotEmpty
	  private String code_number;
	  private boolean is_delete;
	  private MultipartFile screenshot;
	 
	public TicketBean() {
		  
	  }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getPost() {
		return post;
	}
	public void setPost(int post) {
		this.post = post;
	}
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getCode_number() {
		return code_number;
	}
	public void setCode_number(String code_number) {
		this.code_number = code_number;
	}
	public boolean isIs_delete() {
		return is_delete;
	}
	public void setIs_delete(boolean is_delete) {
		this.is_delete = is_delete;
	}
	 public MultipartFile getScreenshot() {
		return screenshot;
	}
	public void setScreenshot(MultipartFile screenshot) {
		this.screenshot = screenshot;
	}
	
}
