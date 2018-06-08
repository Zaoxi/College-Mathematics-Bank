package control;

import CollegeMathBankProject.view.*;
import model.*;

// 중개자 패턴
public class MathManager {
	static private MathManager instance = null;

	private JSPServer server;
	private MainController mainController;
	private MathDAO dao;
	
	//AHTML
	private LoginHTML loginPage;
	private SubjectHTML subjectPage;
	private LoginFailHTML loginFailPage;
	
	static public MathManager GetInstance() {
		if (instance == null)
			instance = new MathManager();
		return instance;
	}

	// Initialize the Manager Class
	private MathManager() {
		// 생성시 관련 객체들도 같이 생성
		dao = new MathDAO();
		mainController = new MainController();
		loginPage = new LoginHTML();
		subjectPage = new SubjectHTML();
		loginFailPage = new LoginFailHTML();
	}

	// JSP 클래스에서 직접 호출하여 객체 전달
	public void SetJSPServer(JSPServer jsp) {
		server = jsp;
	}
	
	public JSPServer GetJSPServer()
	{
		return server;
	}
	public MainController GetMainController()
	{
		return mainController;
	}
	public MathDAO GetMathDAO()
	{
		return dao;
	}
	
	public LoginHTML GetLoginPage()
	{
		return loginPage;
	}
	public SubjectHTML GetSubjectPage()
	{
		return subjectPage;
	}
	public LoginFailHTML GetLoginFailPage()
	{
		return loginFailPage;
	}
}
