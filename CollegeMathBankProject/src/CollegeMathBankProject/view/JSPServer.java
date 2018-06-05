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
	private Hashtable<String, AHTML> userTable;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JSPServer() {
		super();
		MathManager.GetInstance().SetJSPServer(this);
		userTable = new Hashtable<String, AHTML>();
	}

	// HTML Controller를 동적으로 설정
	public void SetHTML(HttpServletRequest req, AHTML newHtmlController) {
		userTable.replace(req.getRemoteAddr(), newHtmlController);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String userIP = request.getRemoteAddr();
		
		// 처음 접속한 유저인 경우
		if(!userTable.containsKey(userIP))
		{
			userTable.put(userIP, MathManager.GetInstance().GetLoginPage());
		}
		
		userTable.get(userIP).PrintHTML(response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String userIP = request.getRemoteAddr();
		userTable.get(userIP).ProcessRequest(request);
		
		doGet(request, response);
	}

}
