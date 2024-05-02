package jobagency.models;
import org.springframework.web.multipart.MultipartFile;

public class Employer_tickets {
	private int id;
	private String payment_date;
	private String applied_date;
	private int admin_id;
	private int employer_id;
	private String employer_name;
	private int ticket_id;
	private MultipartFile screen_shot;
	private String getscreen_shot;
	private int is_Approved;
	
	
	

	public Employer_tickets() {
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

	public String getGetscreen_shot() {
		return getscreen_shot;
	}

	public void setGetscreen_shot(String getscreen_shot) {
		this.getscreen_shot = getscreen_shot;
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

	public String getEmployer_name() {
		return employer_name;
	}

	public void setEmployer_name(String employer_name) {
		this.employer_name = employer_name;
	}

	public int getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}

	public MultipartFile getScreen_shot() {
		return screen_shot;
	}

	public void setScreen_shot(MultipartFile screen_shot) {
		this.screen_shot = screen_shot;
	}

	public int getIs_Approved() {
		return is_Approved;
	}

	public void setIs_Approved(int is_Approved) {
		this.is_Approved = is_Approved;
	}
	
}
