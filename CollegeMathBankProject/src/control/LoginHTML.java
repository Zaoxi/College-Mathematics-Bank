package control;

import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHTML implements AHTML {

	@Override
	public void PrintHTML(HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		out.println("<html>\r\n" + "  <head>\r\n" + "    <meta charset=\"utf-8\">\r\n" + "    <style>\r\n"
				+ "    h1{\r\n" + "      text-align: center;\r\n" + "\r\n" + "    }\r\n" + "    body{\r\n"
				+ "      width: 660px;\r\n" + "      margin: auto;\r\n" + "    }\r\n" + "\r\n" + "    .form{\r\n"
				+ "      width : 310px;\r\n" + "      margin: 100px;\r\n" + "      margin : auto;\r\n"
				+ "      margin-top: 13%;\r\n" + "      padding: 20px;\r\n" + "    }\r\n" + "    .textlabel{\r\n"
				+ "      width : 300px;\r\n" + "      height:  30px;\r\n" + "      margin: auto;\r\n"
				+ "      margin-top: 10px;\r\n" + "    }\r\n" + "    .button{\r\n" + "      margin: 0px;\r\n"
				+ "      margin-top: 10px;\r\n" + "      margin-bottom: 10px;\r\n" + "      width: 303px;\r\n"
				+ "      height: 40px;\r\n" + "\r\n" + "    }\r\n" + "\r\n" + "    </style>\r\n" + "  </head>\r\n"
				+ "  <body>\r\n" + "    <h1>대학 수학 문제은행</h1>\r\n"
				+ "  <form id=\"frmNIDLogin\" class = \"form\" name=\"frmNIDLogin\" target=\"_top\" autocomplete=\"off\" method=\"post\" onsubmit=\"return confirmAlterSubmit();\" >\r\n"
				+ "  		<div class=\"input_row\" id=\"id_area\">\r\n" + "  			<span class=\"input_box\">\r\n"
				+ "  				<input type=\"text\" id=\"id\" name=\"id\" class = \"textlabel\" tabindex=\"7\" accesskey=\"L\" placeholder=\"아이디\" class=\"int\" maxlength=\"41\" value=\"\">\r\n"
				+ "  			</span>\r\n" + "  		</div>\r\n"
				+ "  		<div class=\"input_row\" id=\"pw_area\">\r\n" + "  			<span class=\"input_box\">\r\n"
				+ "  				<input type=\"password\" id=\"pw\" class = \"textlabel\" name=\"pw\" tabindex=\"8\" placeholder=\"비밀번호\" class=\"int\" maxlength=\"16\" onkeypress=\"capslockevt(event);getKeysv2();\" onkeyup=\"checkShiftUp(event);\" onkeydown=\"checkShiftDown(event);\">\r\n"
				+ "  			</span>\r\n" + "  		</div>\r\n"
				+ "  		<input type=\"submit\" title=\"로그인\" class = \"button\" alt=\"로그인\" tabindex=\"12\" value=\"로그인\" class=\"btn_global\" onclick=\"nclks('log.login',this,event)\">\r\n"
				+ "  </form>\r\n" + "\r\n" + "  </body>\r\n" + "</html>\r\n" + "");
	}

	@Override
	public void ProcessRequest(HttpServletRequest req) throws IOException {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");

		System.out.println(id + ", " + pw);

		/*
		 * DAO를 참조하여 유저 확인 후, 일치하는 유저면 다음 페이지로
		 */
		if (MathManager.GetInstance().GetMathDAO().BisExistUser(id, pw)) {
			// 단원을 출력하는 페이지로 전환
			MathManager.GetInstance().GetJSPServer().SetHTML(req, MathManager.GetInstance().GetSubjectPage());
		} else {
			// 로그인에 실패한 페이지로 전환
			MathManager.GetInstance().GetJSPServer().SetHTML(req, MathManager.GetInstance().GetLoginFailPage());
		}
	}
}
