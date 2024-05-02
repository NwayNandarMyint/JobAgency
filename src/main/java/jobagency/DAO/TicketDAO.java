package jobagency.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jobagency.DTO.TicketRequestDTO;
import jobagency.DTO.TicketResponseDTO;

public class TicketDAO {

	public static Connection con=null;
	static {
		con=MyConnection.getConnection();
	}
	
	//Insert
		public int addTicket(TicketRequestDTO ticketDTO) {
			int result=0;
			String sql="INSERT INTO ticket (amount,admin_id,post,code_number,is_delete) VALUES(?,?,?,?,?)";
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setDouble(1, ticketDTO.getAmount());
				ps.setInt(2, ticketDTO.getAdmin_id());
				ps.setInt(3, ticketDTO.getPost());
				ps.setString(4, ticketDTO.getCode_number());
				ps.setInt(5, 0);
				
				result=ps.executeUpdate();	
			}catch(SQLException e) {
				System.out.println("Insert Errot"+e);
			}
			return result;
		}
		
		//Update
		
		public int editTicket(TicketRequestDTO ticketDTO) {
			int result = 0;
			String sql = "UPDATE ticket SET amount=?,admin_id=?,post=?,level=? WHERE id=?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setDouble(1, ticketDTO.getAmount());
				ps.setInt(2, ticketDTO.getAdmin_id());
				ps.setInt(3, ticketDTO.getPost());
				ps.setString(4, ticketDTO.getCode_number());
				ps.setInt(5, ticketDTO.getId());
				
				result = ps.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Ticket Update error: " + e);
			}
			return result;
		}
		
		//Delete
		
		public int deleteTicket(int id ) {
			int result = 0;
			String sql = "update ticket set is_delete=? where id=?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, 1);
				ps.setInt(2, id);
				result = ps.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Ticket Delete error: " + e);
			}
			return result;
		}
		
		//selectById
		
		public TicketResponseDTO getTicketById(int id) {
			TicketResponseDTO ticket = new TicketResponseDTO();
			String sql = "SELECT * FROM ticket WHERE id=?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					ticket.setId(rs.getInt("id"));
					ticket.setAmount(rs.getDouble("amount"));
					ticket.setAdmin_id(rs.getInt("admin_id"));
					ticket.setPost(rs.getInt("post"));
					ticket.setCode_number(rs.getString("code_number"));
				}
			} catch (SQLException e) {
				System.out.println("select industry by id error" + e);
			}
			return ticket;
		}
		
		//Select All
		public List<TicketResponseDTO> getAllTicket() {
			List<TicketResponseDTO> tickets=new ArrayList<TicketResponseDTO>();
			String sql="SELECT * FROM ticket where is_delete=0";
			
			try {
				PreparedStatement ps=con.prepareStatement(sql);			
				ResultSet rs=ps.executeQuery();			
				while(rs.next()) {
					TicketResponseDTO ticket=new TicketResponseDTO();
					ticket.setId(rs.getInt("id"));
					ticket.setAmount(rs.getDouble("amount"));
					ticket.setAdmin_id(rs.getInt("admin_id"));
					ticket.setPost(rs.getInt("post"));
					ticket.setCode_number(rs.getString("code_number"));
					
					tickets.add(ticket);
				}				
			}catch(SQLException e) {
				System.out.println("select all error: "+e);
			}
			return tickets;
		}
	
}
