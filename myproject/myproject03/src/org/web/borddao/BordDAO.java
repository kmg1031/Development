package org.web.borddao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.web.borddto.BordDTO;
import org.web.connect.DBConnect;

public class BordDAO {
	private BordDAO() {}
	private static class SingleTone{
		private static final BordDAO INSTANCE=new BordDAO();
	}
	public static BordDAO getInstance() {
		return SingleTone.INSTANCE;
	}


	public ArrayList<BordDTO> list() {
		ArrayList<BordDTO> result=new ArrayList<>();
		
		Connection conn=null;
		PreparedStatement pst=null;
		String query="";
		ResultSet rs=null;
		try {
			conn=DBConnect.getConnection();
			query="select * from myproject3";
			pst=conn.prepareStatement(query);
			
			rs=pst.executeQuery();
			
			while(rs.next()) {
				String name=rs.getString(1); 
				String title=rs.getString(2); 
				String memo=rs.getString(3); 
				
				
				result.add(new BordDTO(name, title, memo));
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null)conn.close();
				if(pst!=null)pst.close();
				if(rs!=null)rs.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public ArrayList<BordDTO> paging(int sNum, int eNum) {
		ArrayList<BordDTO> result=new ArrayList<>();
		
		Connection conn=null;
		PreparedStatement pst=null;
		String query="";
		ResultSet rs=null;
		try {
			conn=DBConnect.getConnection();
			query="select * from myproject3 limit ?, ?";
			pst=conn.prepareStatement(query);
			
			pst.setInt(1, sNum);
			pst.setInt(2, eNum);
			
			rs=pst.executeQuery();
			
			while(rs.next()) {
				String name=rs.getString(1); 
				String title=rs.getString(2); 
				String memo=rs.getString(3); 
				
				result.add(new BordDTO(name, title, memo));
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null)conn.close();
				if(pst!=null)pst.close();
				if(rs!=null)rs.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	
	public int listSize() {
		int result=0;
		
		Connection conn=null;
		PreparedStatement pst=null;
		String query="";
		ResultSet rs=null;
		try {
			conn=DBConnect.getConnection();
			query="select count(*) from myproject3";
			pst=conn.prepareStatement(query);
			
			rs=pst.executeQuery();
			rs.next();
			result=rs.getInt(1);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null)conn.close();
				if(pst!=null)pst.close();
				if(rs!=null)rs.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public BordDTO bordView(int name1) {
		BordDTO result=null;
		
		Connection conn=null;
		PreparedStatement pst=null;
		String query="";
		ResultSet rs=null;
		try {
			conn=DBConnect.getConnection();	
			query="select * from myproject3 where name=?";
			pst=conn.prepareStatement(query);
	
			pst.setInt(1, name1);
			
			rs=pst.executeQuery();
			
			while(rs.next()) {
				String name=rs.getString(1); 
				String title=rs.getString(2); 
				String memo=rs.getString(3); 
				
				result=new BordDTO(name, title, memo);
				
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null)conn.close();
				if(pst!=null)pst.close();
				if(rs!=null)rs.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public BordDTO replyView(int name1) {
		BordDTO result=null;
		
		Connection conn=null;
		PreparedStatement pst=null;
		String query="";
		ResultSet rs=null;
		try {
			conn=DBConnect.getConnection();	
			query="select * from myproject3 where name=?";
			pst=conn.prepareStatement(query);
			
			pst.setInt(1, name1);
			
			rs=pst.executeQuery();
			
			while(rs.next()) {
				String name=rs.getString(1); 
				String title=rs.getString(2); 
				String memo=rs.getString(3); 
				
				result=new BordDTO(name, title, memo);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null)conn.close();
				if(pst!=null)pst.close();
				if(rs!=null)rs.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public int delete(int name1) {
		int result=0;
		
		Connection conn=null;
		PreparedStatement pst=null;
		String query="";
		try {
			conn=DBConnect.getConnection();
			query="delete from bord1029 where name=?";
			pst=conn.prepareStatement(query);
			
			pst.setInt(1, name1);
			
			result=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null)conn.close();
				if(pst!=null)pst.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public int update(int name, String title,String memo) {
		int result=0;
		
		Connection conn=null;
		PreparedStatement pst=null;
		String query="";
		try {
			conn=DBConnect.getConnection();
			query="update bord1029 set title=?, memo=? where name=?";
			pst=conn.prepareStatement(query);
			
			pst.setString(1, title);
			pst.setString(2, memo);
			pst.setInt(3, name);
			
			result=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null)conn.close();
				if(pst!=null)pst.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
/*	
	public void replyUpdate(String mGroup, String step) {
		Connection conn=null;
		PreparedStatement pst=null;
		String query="";
		try {
			conn=DBConnect.getConnection();
			query="update bord1029 set step=step+1 where mGroup=? and step > ?";
			pst=conn.prepareStatement(query);
			
			pst.setInt(1, Integer.parseInt(mGroup));
			pst.setInt(2, Integer.parseInt(step));
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null)conn.close();
				if(pst!=null)pst.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public int write(String nicName, String title, String memo) {
		int result=0;
		
		Connection conn=null;
		PreparedStatement pst=null;
		String query="";
		try {
			conn=DBConnect.getConnection();
			
			
			query="insert into bord1029(mgroup,step,hit,mindent,nicname,title,memo,mtime)"
					+ " values((select case count(*) when 0 then 1 else max(mGroup)+1 end from bord1029 a),0,0,0,?,?,?,now())";
			
			
			pst=conn.prepareStatement(query);
			
			pst.setString(1, nicName);
			pst.setString(2, title);
			pst.setString(3, memo);
			
			result = pst.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null)conn.close();
				if(pst!=null)pst.close();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public int reply(String name,String mGroup, String step,String indent,String nicName, String title, String memo) {
		int result=0;
		
		replyUpdate(mGroup, step);
		
		Connection conn=null;
		PreparedStatement pst=null;
		String query="";
		try {
			conn=DBConnect.getConnection();
			
			
			query="insert into bord1029(mgroup,step,mindent,nicname,title,memo,mtime)"
					+ " values(?,?,?,?,?,?,now())";
			
			
			pst=conn.prepareStatement(query);
			
			pst.setInt(1, Integer.parseInt(mGroup));
			pst.setInt(2, Integer.parseInt(step)+1);
			pst.setInt(3, Integer.parseInt(indent)+1);
			
			pst.setString(4, nicName);
			pst.setString(5, title);
			pst.setString(6, memo);
			
			result = pst.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null)conn.close();
				if(pst!=null)pst.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	*/
	public ArrayList<BordDTO> search(String keyWord) {
		ArrayList<BordDTO> result=new ArrayList<>();
		
		Connection conn=null;
		PreparedStatement pst=null;
		String query="";
		ResultSet rs=null;
		try {
			conn=DBConnect.getConnection();
			query="select * from bord1029 where title like ?";
			pst=conn.prepareStatement(query);
			
			pst.setString(1, "%"+keyWord+"%");
			
			rs=pst.executeQuery();
			
			while(rs.next()) {
				String name=rs.getString(1); //글목록
				String title=rs.getString(2); //새글
				String memo=rs.getString(3); //댓글
				
				
				result.add(new BordDTO(name, title, memo));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null)conn.close();
				if(pst!=null)pst.close();
				if(rs!=null)rs.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
