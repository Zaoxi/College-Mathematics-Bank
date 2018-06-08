package model;

import java.sql.*;

public class MathDAO {
	private Connection conn = null;
	private String url = "jdbc:mysql://localhost:3306/testdb";
	private String id = "root";
	private String pw = "1234";

	public MathDAO() {
		try {
			Class.forName("con.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("MySQL : " + url + "연결 성공!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void CloseDB()
	{
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	// 전세영 담당 부분.
	// id와 pw를 받아서 유저가 존재하는지 확인
	// 해당 id, pw와 일치하는 유저가 있다면 true
	// 없으면 false 반환
	public boolean BisExistUser(String id, String pw)
	{
		return true;
	}
	// (과목명, 단원명, 문제 번호)를 전달하면 해당하는 문제의 내용, 정답, 풀이, 그림 이미지 경로등 모든 것을 전달
	// 이미지 경로의 경우 존재하지 않는다면 null을 대입해 줄 것.
	public ProblemFormat GetProblem(String subject, String content, int problemNum)
	{
		return null;
	}
}
