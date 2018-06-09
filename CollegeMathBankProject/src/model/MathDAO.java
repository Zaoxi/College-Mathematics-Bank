package model;

import java.sql.*;

public class MathDAO {
	private Connection conn = null;
	private String url = "jdbc:mysql://localhost:3306/testdb?serverTimezone=Asia/Seoul";
	private String id = "root";
	private String pw = "1234";

	public MathDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("MySQL : " + url + "연결성공!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void CloseDB()
	{
		try {
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public boolean BisExistUser(String id, String pw)
	{
		String getPassWord="";
		
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			
			String sql;
			sql = "SELECT USERPW FROM USER WHERE USERID = '"+id+"'";
			ResultSet rs = stmt.executeQuery((sql));
			
			while(rs.next()) {
				getPassWord = rs.getString("USERPW");
			}
			rs.close();
			stmt.close();
		}
		catch(SQLException sel) {
			sel.printStackTrace();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally{
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}
		}
		
		System.out.println("\n\n- MySQL Connection Close");
		
		if(getPassWord.equals((pw)) && !getPassWord.equals("")){
			return true;
		}
		else {
			return false;
		}
	}

	public ProblemFormat GetProblem(String subject, String unit, int problemNum)
	{
		
		ProblemFormat information = new ProblemFormat();
		
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			
			String sql;
		
			sql = "SELECT CONTENT,IMAGEPATH,SOLUTION,RIGHTANSWER,RIGHTANSWERIMAGEPATH FROM PROBLEM "
					+ "WHERE SUBJECTKIND = '"+subject+"' AND UNIT = '"+unit+"' AND PROBLEMNO = "+problemNum;
			
			ResultSet rs = stmt.executeQuery((sql));
			
			while(rs.next()) {
				information.SetContent(rs.getString("CONTENT"));
				information.SetImagePath(rs.getString("IMAGEPATH"));
				information.SetSolution(rs.getString("SOLUTION"));
				information.SetRightAnswer(rs.getString("RIGHTANSWER"));
				information.SetRightAnswerImagePath(rs.getString("RIGHTANSWERIMAGEPATH")); 
			}
			
			rs.close();
			stmt.close();
		}
		catch(SQLException sel) {
			sel.printStackTrace();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally{
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}
		}
		
		return information;
	}
}
