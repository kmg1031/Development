package org.web.memberdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.web.connect.DBConnect;
import org.web.memberdto.MemberDTO;

public class MemberDAO {
	private MemberDAO() {}
	private static class SingleTone{
		private static final MemberDAO INSTANCE=new MemberDAO();
	}
	public static MemberDAO getInstance() {
		return SingleTone.INSTANCE;
	}

	public int idCheck(String userId) {
		int result=0;
		
		Connection conn=null;
		PreparedStatement pst=null;
		String query="";
		ResultSet rs=null;
		try {
			conn=DBConnect.getConnection();
			query="select count(userId) from myproject_member where userId=?";
			pst=conn.prepareStatement(query);
			
			pst.setString(1, userId);
			
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
	
	public int update(MemberDTO dto) {
		int result=0;
		
		Connection conn=null;
		PreparedStatement pst=null;
		String query="";
		try {
			conn=DBConnect.getConnection();
			query="update myproject_member set userPw=?, userName=? where userId=?";
			pst=conn.prepareStatement(query);
			
			pst.setString(1, dto.getUserPw());
			pst.setString(2, dto.getUserName());
			pst.setString(3, dto.getUserId());
			
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

	public MemberDTO modifyView(String userId) {
		MemberDTO result=null;
		
		Connection conn=null;
		PreparedStatement pst=null;
		String query="";
		ResultSet rs=null;
		try {
			conn=DBConnect.getConnection();
			query="select * from myproject_member where userId=?";
			pst=conn.prepareStatement(query);
			
			pst.setString(1, userId);
			
			rs=pst.executeQuery();
			rs.next();
			result=new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3));
			
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
	
	public int login(String userId, String userPw) {
		int result=0;
		
		Connection conn=null;
		PreparedStatement pst=null;
		String query="";
		ResultSet rs=null;
		try {
			conn=DBConnect.getConnection();
			query="select count(*) from myproject_member where userId=? and userPw=?";
			pst=conn.prepareStatement(query);
			pst.setString(1, userId);
			pst.setString(2, userPw);
			
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
	
	
	public int delete(String userId, String userPw) {
		int result=0;
		
		Connection conn=null;
		PreparedStatement pst=null;
		String query="";
		try {
			conn=DBConnect.getConnection();
			query="delete from myproject_member where userId=? and userPw=?";
			pst=conn.prepareStatement(query);
			pst.setString(1, userId);
			pst.setString(2, userPw);
			
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
	
	public int join(String userId, String userPw,String userName) {
		int result=0;
		
		Connection conn=null;
		PreparedStatement pst=null;
		String query="";
		try {
			conn=DBConnect.getConnection();
			query="insert into myproject_member values(?,?,?)";
			pst=conn.prepareStatement(query);
			
			pst.setString(1, userId);
			pst.setString(2, userPw);
			pst.setString(3, userName);
			
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
	
}
