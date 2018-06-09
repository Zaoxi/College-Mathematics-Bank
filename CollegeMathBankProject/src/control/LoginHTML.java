package control;

import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHTML implements AHTML {
	
	private String id = null;
	private String pw = null;
	private boolean isChecked = false;
	
	@Override
	public void PrintHTML(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		
		out.println("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"  <head>\r\n" + 
				"    <meta charset=\"utf-8\">\r\n" + 
				"    <style>\r\n" + 
				"    h1{\r\n" + 
				"      text-align: center;\r\n" + 
				"    }\r\n" + 
				"    body{\r\n" + 
				"      width: 660px;\r\n" + 
				"      margin: auto;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    .form{\r\n" + 
				"      width : 310px;\r\n" + 
				"      margin: 100px;\r\n" + 
				"      margin : auto;\r\n" + 
				"      margin-top: 13%;\r\n" + 
				"      padding: 20px;\r\n" + 
				"    }\r\n" + 
				"    .textlabel{\r\n" + 
				"      width : 300px;\r\n" + 
				"      height:  30px;\r\n" + 
				"      margin: auto;\r\n" + 
				"      margin-top: 10px;\r\n" + 
				"    }\r\n" + 
				"    .button{\r\n" + 
				"      margin: 0px;\r\n" + 
				"      margin-top: 10px;\r\n" + 
				"      margin-bottom: 10px;\r\n" + 
				"      width: 303px;\r\n" + 
				"      height: 40px;\r\n" + 
				"\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    </style>\r\n" + 
				"  </head>\r\n" + 
				"  <body>\r\n" + 
				"    <h1>대학 수학 문제은행</h1>\r\n" + 
				"  <form id=\"frmNIDLogin\" class = \"form\" name=\"frmNIDLogin\" target=\"_top\" autocomplete=\"off\" method=\"post\">\r\n" + 
				"  		<div class=\"input_row\" id=\"id_area\">\r\n" + 
				"  			<span class=\"input_box\">\r\n" + 
				"  				<input type=\"text\" id=\"id\" name=\"id\" class = \"textlabel\" tabindex=\"7\" accesskey=\"L\" placeholder=\"아이디\" class=\"int\" maxlength=\"20\" value=\"\">\r\n" + 
				"  			</span>\r\n" + 
				"  		</div>\r\n" + 
				"  		<div class=\"input_row\" id=\"pw_area\">\r\n" + 
				"  			<span class=\"input_box\">\r\n" + 
				"  				<input type=\"password\" id=\"pw\" class = \"textlabel\" name=\"pw\" tabindex=\"8\" placeholder=\"비밀번호\" maxlength=\"20\">\r\n" + 
				"  			</span>\r\n" + 
				"  		</div>\r\n" + 
				"  		<input type=\"submit\" title=\"로그인\" class = \"button\" alt=\"로그인\" tabindex=\"12\" value=\"로그인\">\r\n" + 
				"\r\n");
		// 
		if(isChecked)
		{
			isChecked = false;
			out.println(
				"      <!--메시지 박스 출력-->\r\n" + 
				"      <script>\r\n" + 
				"        alert(\"아이디 또는 패스워드를 잘못 입력하셨습니다.\");\r\n" + 
				"      </script>\r\n");
		}
		out.println(
				"\r\n" + 
				"  </form>\r\n" + 
				"\r\n" + 
				"  </body>\r\n" + 
				"</html>\r\n" + 
				"");
	}

	@Override
	public void ProcessRequest(HttpServletRequest req, HttpServletResponse res) throws IOException {
		id = req.getParameter("id");
		pw = req.getParameter("pw");
		
		if(id == null && pw == null)
		{
			PrintHTML(req, res);
		}
		else if(MathManager.GetInstance().GetMathDAO().BisExistUser(id, pw))
		{
			MathManager.GetInstance().GetJSPServer().LoginUser(req);
			MathManager.GetInstance().GetJSPServer().SetUserAHTML(req, MathManager.GetInstance().GetSubjectPage());
			MathManager.GetInstance().GetSubjectPage().PrintHTML(req, res);
		}
		else
		{
			isChecked = true;
			PrintHTML(req, res);
		}
	}
}
