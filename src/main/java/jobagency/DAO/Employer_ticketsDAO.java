package jobagency.DAO;

import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;

import jobagency.DTO.Employer_ticketsRequestDTO;
import jobagency.DTO.Employer_ticketsResponseDTO;
import jobagency.DTO.IndustryResponseDTO;

public class Employer_ticketsDAO {
  public static Connection con=null;
  static {
    con=MyConnection.getConnection();
  }
  
  private String DateTime() {
      DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
      LocalDateTime now=LocalDateTime.now();
      String datetime=dtf.format(now);
      return datetime;
    }
  //insert
  public int addEmployer_cticket(Employer_ticketsRequestDTO employer_ticketDTO) {
    int result=0;
    String sql="INSERT INTO employer_tickets(payment_date,employer_id,ticket_id,screen_shot,isApproved) VALUES(?,?,?,?,?)";
    try {
      PreparedStatement ps=con.prepareStatement(sql);
      ps.setString(1, DateTime());
      ps.setInt(2, employer_ticketDTO.getEmployer_id());
      ps.setInt(3, employer_ticketDTO.getTicket_id());
      Blob blob = new javax.sql.rowset.serial.SerialBlob(employer_ticketDTO.getScreen_shot());
      ps.setBlob(4, blob);
      ps.setInt(5, 0);
      
      result=ps.executeUpdate();  
    }catch(SQLException e) {
      System.out.println("Insert Error"+e);
    }
    return result;
  }
  
//Select All
	public List<Employer_ticketsResponseDTO> getAllTicketOrder() {
		List<Employer_ticketsResponseDTO> ticketorders=new ArrayList<Employer_ticketsResponseDTO>();
		String sql="SELECT * FROM employer_tickets";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);			
			ResultSet rs=ps.executeQuery();			
			while(rs.next()) {
				Employer_ticketsResponseDTO ticketorder=new Employer_ticketsResponseDTO();
				ticketorder.setId(rs.getInt("id"));
				ticketorder.setPayment_date(rs.getString("payment_date"));
				ticketorder.setEmployer_id(rs.getInt("employer_id"));
				ticketorder.setTicket_id(rs.getInt("ticket_id"));
				ticketorder.setIs_Approved(rs.getInt("isApproved"));
				Blob blob = (Blob) rs.getBlob("screen_shot");
	            byte [] bytes  =  blob.getBytes(1,(int) blob.length());
	            byte[] encodeBase64 = Base64.encodeBase64(bytes);
	            try {
					ticketorder.setScreen_shot(new String(encodeBase64, "UTF-8"));
					ticketorders.add(ticketorder);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
//	            ticketorders.add(ticketorder);
			}				
		}catch(SQLException e) {
			System.out.println("select all error: "+e);
		}
		return ticketorders;
	}
	//confrimticket
	public int confirmTicket(Employer_ticketsRequestDTO employer_ticketDTO) {
	    int result=0;
	    String sql = "UPDATE employer_tickets SET applied_date=?, admin_id=?, isApproved=? WHERE id=?";
	    try {
	      PreparedStatement ps=con.prepareStatement(sql);
	      ps.setString(1, DateTime());
	      ps.setInt(2,employer_ticketDTO.getAdmin_id());
	      ps.setInt(3,1);
	      ps.setInt(4, employer_ticketDTO.getId());
	      result=ps.executeUpdate();  
	    }catch(SQLException e) {
	      System.out.println("Insert Error"+e);
	    }
	    return result;
	  }

	//cancelticket
	  public int cancelTicket(Employer_ticketsRequestDTO employer_ticketDTO) {
	      int result=0;
	      String sql = "UPDATE employer_tickets SET applied_date=?, admin_id=?, isApproved=? WHERE id=?";
	      try {
	        PreparedStatement ps=con.prepareStatement(sql);
	        ps.setString(1, DateTime());
	        ps.setInt(2,employer_ticketDTO.getAdmin_id());
	        ps.setInt(3,2);
	        ps.setInt(4, employer_ticketDTO.getId());
	        result=ps.executeUpdate();  
	      }catch(SQLException e) {
	        System.out.println("Insert Error"+e);
	      }
	      return result;
	    }

}