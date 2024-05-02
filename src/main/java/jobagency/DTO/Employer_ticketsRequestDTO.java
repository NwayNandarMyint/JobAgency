package jobagency.DTO;


public class Employer_ticketsRequestDTO {
	private int id;
	private String payment_date;
	private String applied_date;
	private int admin_id;
	private int employer_id;
	private int ticket_id;
	private byte[] screen_shot;
	private int is_Approved;
	
	public Employer_ticketsRequestDTO() {
	    
	  }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPayment_date() {
		return payment_date;
	}
	public void setPayment_date(String payment_date) {
		this.payment_date = payment_date;
	}
	public String getApplied_date() {
		return applied_date;
	}
	public void setApplied_date(String applied_date) {
		this.applied_date = applied_date;
	}
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public int getEmployer_id() {
		return employer_id;
	}
	public void setEmployer_id(int employer_id) {
		this.employer_id = employer_id;
	}
	public int getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}
	
	public byte[] getScreen_shot() {
		return screen_shot;
	}
	public void setScreen_shot(byte[] screen_shot) {
		this.screen_shot = screen_shot;
	}
	public int getIs_Approved() {
		return is_Approved;
	}
	public void setIs_Approved(int is_Approved) {
		this.is_Approved = is_Approved;
	}

}
