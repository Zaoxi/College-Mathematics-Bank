package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.glass.ui.Application;
import java.io.*;

import model.*;

public class ProblemHTML implements AHTML {
	
	private String subject;
	private String content;
	private int problemNum;
	
	private ProblemFormat problem;
	
	public ProblemHTML(String _subject, String _content, int _problemNum)
	{
		subject = _subject;
		content = _content;
		problemNum = _problemNum;
		problem = MathManager.GetInstance().GetMathDAO().GetProblem(subject, content, problemNum);
		System.out.println(subject + content + problemNum);
		System.out.println(problem.GetContent());
	}
	
	
	@Override
	public void PrintHTML(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		System.out.println(req.getContextPath());
		out.println("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"  <head>\r\n" + 
				"    <meta charset=\"utf-8\">\r\n" + 
				"    <title></title>\r\n" + 
				"\r\n" + 
				"    <script src=\"http://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\r\n" + 
				"\r\n" + 
				"    <script src=\"http://cdn.mathjax.org/mathjax/latest/MathJax.js?config=TeX-AMS-MML_HTMLorMML\"></script>\r\n" + 
				"    <script type=\"text/x-mathjax-config\">MathJax.Hub.Config({tex2jax: {inlineMath: [['$','$'], ['\\\\(','\\\\)']]}});</script>\r\n" + 
				"    <script type=\"text/x-mathjax-config\">\r\n" + 
				"    MathJax.Hub.Config({\r\n" + 
				"        \"HTML-CSS\": {undefinedFamily:\"'Malgun Gothic',Arial\"},\r\n" + 
				"        \"showProcessingMessages\": false,\r\n" + 
				"        \"messageStyle\": \"none\"\r\n" + 
				"    });\r\n" + 
				"    </script>\r\n" + 
				"\r\n" + 
				"    <script type=\"text/javascript\">\r\n" + 
				"    $(document).ready(function () {\r\n" + 
				"      $('.outer-menu-item').hover(function(){\r\n" + 
				"        $(this).find('.inner-menu').show();\r\n" + 
				"      }, function(){\r\n" + 
				"        $(this).find('.inner-menu').hide();\r\n" + 
				"      });\r\n" + 
				"    });\r\n" + 
				"\r\n" + 
				"    $(document).ready(function(){\r\n" + 
				"      $('#solbutton').click(function(){\r\n" + 
				"        $('#sol').toggle();\r\n" + 
				"      });\r\n" + 
				"    });\r\n" + 
				"\r\n" + 
				"    $(document).ready(function(){\r\n" + 
				"      $('#expbutton').click(function(){\r\n" + 
				"        $('#exp').toggle();\r\n" + 
				"      });\r\n" + 
				"    });\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"    </script>\r\n" + 
				"    <style>\r\n" + 
				"\r\n" + 
				"    @import url(http://fonts.googleapis.com/earlyaccess/nanummyeongjo.css);\r\n" + 
				"    body {\r\n" + 
				"      /*font-family: 'Nanum Myeongjo', serif;*/\r\n" + 
				"      width: 660px;\r\n" + 
				"      margin: auto;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    h1{\r\n" + 
				"      text-align: center;\r\n" + 
				"    }\r\n" + 
				"    h3{\r\n" + 
				"      text-align: center;\r\n" + 
				"    }\r\n" + 
				"    h4{\r\n" + 
				"      text-align: center;\r\n" + 
				"    }\r\n" + 
				"    a{\r\n" + 
				"      text-decoration: none;\r\n" + 
				"    }\r\n" + 
				"    li{\r\n" + 
				"      list-style: none;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    .div{\r\n" + 
				"      height: 50px;\r\n" + 
				"      width: 100px;\r\n" + 
				"      border-style:groove;\r\n" + 
				"      border-width: thin;\r\n" + 
				"      margin: 5px;\r\n" + 
				"\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    .theater-list{\r\n" + 
				"      width: 640px;\r\n" + 
				"      height: auto;\r\n" + 
				"      float:inherit;\r\n" + 
				"      position: relative;\r\n" + 
				"      margin: auto;\r\n" + 
				"    }\r\n" + 
				"    .outer-menu{\r\n" + 
				"      padding: 0;\r\n" + 
				"    }\r\n" + 
				"    .outer-menu-item{\r\n" + 
				"      float: left;\r\n" + 
				"      position: relative;\r\n" + 
				"      width: 160px;\r\n" + 
				"      text-align: center;\r\n" + 
				"      background-color: rgba(255,255,255,0.4);\r\n" + 
				"      /*border-style:solid;\r\n" + 
				"      border-width: thin;*/\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"    .menu-title:hover{\r\n" + 
				"     /*color: white;*/\r\n" + 
				"     background-color: rgba(200,200,200,1);\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    .menu-title{\r\n" + 
				"      display: block;\r\n" + 
				"      height: 60px;\r\n" + 
				"      line-height: 60px;\r\n" + 
				"      text-align: center;\r\n" + 
				"      padding: 0px;\r\n" + 
				"      color: black;\r\n" + 
				"      font-weight: bold;\r\n" + 
				"      font-size: 20px;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"    .inner-menu{\r\n" + 
				"      display: none;\r\n" + 
				"      /*position: absolute;*/\r\n" + 
				"      /*position: relative;*/\r\n" + 
				"      padding: 0px;\r\n" + 
				"      width: 180px; height: auto;\r\n" + 
				"      text-align: center;\r\n" + 
				"      z-index: 1000;\r\n" + 
				"      background: rgba(255,255,255,0.95);\r\n" + 
				"\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"    .inner-menu li{\r\n" + 
				"      height: 50px;\r\n" + 
				"      line-height: 50px;\r\n" + 
				"      width: 210px;\r\n" + 
				"      /*float: left;*/\r\n" + 
				"      /*border-style: solid;\r\n" + 
				"      border-width: thin;*/\r\n" + 
				"\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    .inner-menu li a{\r\n" + 
				"      color: rgb(0,0,0);\r\n" + 
				"      font-size: 14px;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    .inner-menu :hover{\r\n" + 
				"      background: rgba(230,230,230,1);\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    .inner-div{\r\n" + 
				"      height: auto;\r\n" + 
				"      width: auto;\r\n" + 
				"      position: absolute;\r\n" + 
				"      left: -20px;\r\n" + 
				"    }\r\n" + 
				"    .pro{\r\n" + 
				"      width: 600px;\r\n" + 
				"      height: auto;\r\n" + 
				"      margin: auto;\r\n" + 
				"      padding: 30px;\r\n" + 
				"\r\n" + 
				"      /*border-style: solid;\r\n" + 
				"      border-width: thin;*/\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    .solandexpdiv{\r\n" + 
				"      width: 600px;\r\n" + 
				"      height: auto;\r\n" + 
				"      margin: auto;\r\n" + 
				"      padding: 20px;\r\n" + 
				"      display: none;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"    .solandexpp{\r\n" + 
				"      font-size: 25px;\r\n" + 
				"      font-weight: bold;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    .span{\r\n" + 
				"      margin-left: 10px;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    #proimg{\r\n" + 
				"      width: 80px;\r\n" + 
				"      /*border-style: solid;*/\r\n" + 
				"    }\r\n" + 
				"    .buttondiv{\r\n" + 
				"      position:static;\r\n" + 
				"      margin: auto;\r\n" + 
				"      /*border-style: solid;*/\r\n" + 
				"      width: 240px;\r\n" + 
				"    }\r\n" + 
				"    .button{\r\n" + 
				"      margin: 20px;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    #frmbutton{\r\n" + 
				"      float: right;\r\n" + 
				"      position: relative;\r\n" + 
				"    }\r\n" + 
				"    #subject{\r\n" + 
				"      right: 10px;\r\n" + 
				"    }\r\n" + 
				"    .topbutton{\r\n" + 
				"      position: absolute;\r\n" + 
				"      top: -60px;\r\n" + 
				"      background-color: rgb(255,255,255);\r\n" + 
				"      border-style:solid;\r\n" + 
				"      border-width: thin;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    </style>\r\n" + 
				"  </head>\r\n" + 
				"\r\n" + 
				"  <body>\r\n" + 
				"\r\n" + 
				"    <h1>대학 수학 문제은행</h1>\r\n" + 
				"    <form id=\"frmbutton\" method=\"get\">\r\n" + 
				"      <input class=\"topbutton\" type=\"submit\" id=\"subject\" name=\"과목선택\" value=\"과목선택\">\r\n" + 
				"      <input class=\"topbutton\" type=\"submit\" id=\"next\" name=\"다음문제\" value=\"다음문제\">\r\n" + 
				"    </form>\r\n" +
				"    <h3>" + subject + "</h3>\r\n" + 
				"    <h4>" + content + "</h4>\r\n" + 
				"\r\n" + 
				"    <div class=\"pro\">\r\n" + 
				"      <p class=\"solandexpp\">문제</p>\r\n" + 
				"      <p></p> <!-- <p>데이터 베이스로 부터 문제를 읽어와서 여기에 그대로 대입하면 된다.</p> -->\r\n" + 
				"      <p>" + problem.GetContent() + "</p>\r\n" + 
				"      <!-- src=\"DB에 저장된 이미지가 저장된 경로를 대입하면 된다\" -->\r\n" + 
				"      <img id=\"solutionimg\" src=\"" + req.getContextPath() + "/" + problem.GetImagePath() + "\" alt=\"\">\r\n" + 
				"    </div>\r\n" + 
				"\r\n" + 
				"    <div class=\"buttondiv\">\r\n" + 
				"      <input type=\"button\" id=\"solbutton\" class = \"button\" tabindex=\"1\" value=\"정답보기\" onclick=\"sol()\">\r\n" + 
				"      <input type=\"button\" id=\"expbutton\" class = \"button\" tabindex=\"2\" value=\"해설보기\">\r\n" + 
				"    </div>\r\n" + 
				"\r\n" + 
				"    <div class=\"solandexpdiv\"id=\"sol\">\r\n" + 
				"      <p class=\"solandexpp\" >정답</p>\r\n" + 
				"      <p>" + problem.GetRightAnswer() + "</p>\r\n" + 
				"    </div>\r\n" + 
				"\r\n" + 
				"    <div class=\"solandexpdiv\"id=\"exp\">\r\n" + 
				"      <p class=\"solandexpp\" >해설</p>\r\n" + 
				"      <p>" + problem.GetSolution() + "</p>\r\n" + 
				"      <img id=\"explanationimg\" src=\"" + req.getContextPath() + "/" + problem.GetRightAnswerImagePath() + "\" alt=\"\">\r\n" + 
				"    </div>\r\n" + 
				"\r\n" + 
				"  </body>\r\n" + 
				"</html>\r\n" + 
				"");
	}

	@Override
	public void ProcessRequest(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintHTML(req, res);
		String subjectButton = req.getParameter("과목선택");
		String nextButton = req.getParameter("다음문제");
		System.out.println(subjectButton + nextButton);
//		if(subjectButton.equals("과목선택")) 
//		{
//			MathManager.GetInstance().GetJSPServer().SetUserAHTML(req, MathManager.GetInstance().GetSubjectPage());
//			MathManager.GetInstance().GetSubjectPage().PrintHTML(req, res);
//		}
//		else if(nextButton.equals("다음문제"))
//		{
//			ProblemHTML problem = new ProblemHTML(subject, content, problemNum + 1);
//			MathManager.GetInstance().GetJSPServer().SetUserAHTML(req, problem);
//			problem.PrintHTML(req, res);
//		}
	}

}
