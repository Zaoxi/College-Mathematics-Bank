package CollegeMathBankProject.view;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import control.*;

/**
 * Servlet implementation class JSPServer
 */
@WebServlet(description = "대학 수학 문제 은행 시스템 서블릿", urlPatterns = { "/JSPServer" })
public class JSPServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MathManager manager = null;
	private Hashtable<String, AHTML> users;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JSPServer() {
		super();
		manager = MathManager.GetInstance();
		manager.SetJSPServer(this);
		users = new Hashtable<String, AHTML>();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 기본 인코딩 설정
		response.setContentType("text/html;charset=UTF-8");
		if(!users.containsKey(request.getRemoteAddr()))
		{
			MathManager.GetInstance().GetLoginPage().ProcessRequest(request, response);;
		}
		else
		{
			users.get(request.getRemoteAddr()).ProcessRequest(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 기본 인코딩 설정
		response.setContentType("text/html;charset=UTF-8");
		doGet(request, response);
	}
	
	// 유저를 등록하는 메소드
	public void LoginUser(HttpServletRequest request)
	{
		users.put(request.getRemoteAddr(), MathManager.GetInstance().GetSubjectPage());
	}
	// 유저 등록을 해제하는 메소드
	public void LogoutUser(HttpServletRequest request)
	{
		users.remove(request.getRemoteAddr());
	}
	// 유저가 현재 진행중인 작업을 저장하는 메소드
	public void SetUserAHTML(HttpServletRequest request, AHTML html)
	{
		users.replace(request.getRemoteAddr(), html);
	}
	
	
}
