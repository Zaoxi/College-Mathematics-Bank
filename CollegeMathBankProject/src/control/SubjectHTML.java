package control;

import java.io.IOException;

import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class SubjectHTML implements AHTML {

	@Override
	public void PrintHTML(HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();

		out.println("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"  <head>\r\n" + 
				"    <meta charset=\"utf-8\">\r\n" + 
				"    <title></title>\r\n" + 
				"\r\n" + 
				"    <script src=\"http://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\r\n" + 
				"    <script type=\"text/javascript\">\r\n" + 
				"    $(document).ready(function () {\r\n" + 
				"      $('.outer-menu-item').hover(function(){\r\n" + 
				"        $(this).find('.inner-menu').show();\r\n" + 
				"      }, function(){\r\n" + 
				"        $(this).find('.inner-menu').hide();\r\n" + 
				"      });\r\n" + 
				"    });\r\n" + 
				"    </script>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"    <style>\r\n" + 
				"\r\n" + 
				"    body{\r\n" + 
				"      width: 660px;\r\n" + 
				"      margin: auto;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    h1{\r\n" + 
				"      text-align: center;\r\n" + 
				"    }\r\n" + 
				"    h2{\r\n" + 
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
				"      border-style: solid;\r\n" + 
				"      border-width: thin;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    .menu-list{\r\n" + 
				"      width: 660px;\r\n" + 
				"      height: auto;\r\n" + 
				"      float:inherit;\r\n" + 
				"      position: relative;\r\n" + 
				"      margin: auto;\r\n" + 
				"    }\r\n" + 
				"    .outer-menu{\r\n" + 
				"      padding: 0px;\r\n" + 
				"      margin: auto;\r\n" + 
				"    }\r\n" + 
				"    .outer-menu-item{\r\n" + 
				"      float: left;\r\n" + 
				"      position: relative;\r\n" + 
				"      width: 160px;\r\n" + 
				"      text-align: center;\r\n" + 
				"      background-color: rgba(255,255,255,0.4);\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"    .menu-title:hover{\r\n" + 
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
				"      padding: 0px;\r\n" + 
				"      width: 180px; height: auto;\r\n" + 
				"      text-align: center;\r\n" + 
				"      z-index: 1000;\r\n" + 
				"      background: rgba(255,255,255,0.95);\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"    .inner-menu li{\r\n" + 
				"      height: 50px;\r\n" + 
				"      line-height: 50px;\r\n" + 
				"      width: 210px;\r\n" + 
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
				"\r\n" + 
				"    #first{\r\n" + 
				"      left: -20px;\r\n" + 
				"      position: absolute;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"    </style>\r\n" + 
				"  </head>\r\n" + 
				"  <body>\r\n" + 
				"<h1>대학 수학 문제은행</h1>\r\n" + 
				"\r\n" + 
				"    <div class=\"menu-list\" class=\"div\">\r\n" + 
				"      <ul class=\"outer-menu\">\r\n" + 
				"        <li class=\"outer-menu-item\" id=\"menu1\">\r\n" + 
				"          <span class=\"menu-title\">미적분</span>\r\n" + 
				"          <ul class=\"inner-menu\" id=\"first\">\r\n" + 
				"            <li><a href=\"?sub=미적분&con=함수와 극한\">함수와 극한</a></li>\r\n" + 
				"            <li><a href=\"?sub=미적분&con=도함수\">도함수</a></li>\r\n" + 
				"            <li><a href=\"?sub=미적분&con=역합수\">역함수</a></li>\r\n" + 
				"            <li><a href=\"?sub=미적분&con=미분\">미분</a></li>\r\n" + 
				"            <li><a href=\"?sub=미적분&con=적분\">적분</a></li>\r\n" + 
				"            <li><a href=\"?sub=미적분&con=급수\">급수</a></li>\r\n" + 
				"            <li><a href=\"?sub=미적분&con=매개 방정식과 극 좌표\">매개 방정식과 극 좌표</a></li>\r\n" + 
				"            <li><a href=\"?sub=미적분&con=벡터와 공간 기하학\">벡터와 공간 기하학</a></li>\r\n" + 
				"            <li><a href=\"?sub=미적분&con=편도합수\">편도함수</a></li>\r\n" + 
				"            <li><a href=\"?sub=미적분&con=다중 적분\">다중 적분</a></li>\r\n" + 
				"            <li><a href=\"?sub=미적분&con=벡터 해석\">벡터 해석</a></li>\r\n" + 
				"          </ul>\r\n" + 
				"        </li>\r\n" + 
				"        <li class=\"outer-menu-item\" id=\"menu2\">\r\n" + 
				"          <span class=\"menu-title\">이산수학</span>\r\n" + 
				"          <div class=\"inner-div\">\r\n" + 
				"            <ul class=\"inner-menu\">\r\n" + 
				"              <li><a href=\"?sub=이산수학&con=논리와 명제\">논리와 명제</a></li>\r\n" + 
				"              <li><a href=\"?sub=이산수학&con=성질과 알고리즘\">성질과 알고리즘</a></li>\r\n" + 
				"              <li><a href=\"?sub=이산수학&con=세는 방법\">세는 방법</a></li>\r\n" + 
				"              <li><a href=\"?sub=이산수학&con=관계 및 함수\">관계 및 함수</a></li>\r\n" + 
				"              <li><a href=\"?sub=이산수학&con=그래프\">그래프</a></li>\r\n" + 
				"              <li><a href=\"?sub=이산수학&con=수형도\">수형도</a></li>\r\n" + 
				"              <li><a href=\"?sub=이산수학&con=부울대수\">부울대수</a></li>\r\n" + 
				"              <li><a href=\"?sub=이산수학&con=형식언어와 유한상태기계\">형식언어와 유한상태기계</a></li>\r\n" + 
				"            </ul>\r\n" + 
				"          </div>\r\n" + 
				"        </li>\r\n" + 
				"        <li class=\"outer-menu-item\" id=\"menu3\">\r\n" + 
				"          <span class=\"menu-title\">확률과 통계</span>\r\n" + 
				"          <div class=\"inner-div\">\r\n" + 
				"            <ul class=\"inner-menu\">\r\n" + 
				"              <li><a href=\"?sub=확률과 통계&con=집합\">집합</a></li>\r\n" + 
				"              <li><a href=\"?sub=확률과 통계&con=확률\">확률</a></li>\r\n" + 
				"              <li><a href=\"?sub=확률과 통계&con=확률변수\">확률변수</a></li>\r\n" + 
				"              <li><a href=\"?sub=확률과 통계&con=확률벡터\">확률벡터</a></li>\r\n" + 
				"              <li><a href=\"?sub=확률과 통계&con=순서 통계량\">순서 통계량</a></li>\r\n" + 
				"              <li><a href=\"?sub=확률과 통계&con=순위 통계량\">순위 통계량</a></li>\r\n" + 
				"              <li><a href=\"?sub=확률과 통계&con=확률변수와 수렴\">확률변수와 수렴</a></li>\r\n" + 
				"              <li><a href=\"?sub=확률과 통계&con=확률과정\">확률과정</a></li>\r\n" + 
				"              <li><a href=\"?sub=확률과 통계&con=전력 밀도와 선형 시스템\">전력 밀도와 선형 시스템</a></li>\r\n" + 
				"              <li><a href=\"?sub=확률과 통계&con=몇 가지 확률 과정\">몇 가지 확률 과정</a></li>\r\n" + 
				"            </ul>\r\n" + 
				"          </div>\r\n" + 
				"        </li>\r\n" + 
				"        <li class=\"outer-menu-item\" id=\"menu4\">\r\n" + 
				"          <span class=\"menu-title\">선형대수</span>\r\n" + 
				"          <div class=\"inner-div\">\r\n" + 
				"            <ul class=\"inner-menu\">\r\n" + 
				"              <li><a href=\"?sub=선형대수&con=연립일차방정식과 행렬\">연립일차방적식과 행렬</a></li>\r\n" + 
				"              <li><a href=\"?sub=선형대수&con=행렬식\">행렬식</a></li>\r\n" + 
				"              <li><a href=\"?sub=선형대수&con=유클리드 벡터공간\">유클리드 벡터공간</a></li>\r\n" + 
				"              <li><a href=\"?sub=선형대수&con=일반 벡터공간\">일반 벡터공간</a></li>\r\n" + 
				"              <li><a href=\"?sub=선형대수&con=고유값, 고유벡터\">고유값, 고유벡터</a></li>\r\n" + 
				"              <li><a href=\"?sub=선형대수&con=내적공간\">내적공간</a></li>\r\n" + 
				"              <li><a href=\"?sub=선형대수&con=대각화와 이차형식\">대각화와 이차형식</a></li>\r\n" + 
				"              <li><a href=\"?sub=선형대수&con=선형변환\">선형변환</a></li>\r\n" + 
				"              <li><a href=\"?sub=선형대수&con=수치적 방법\">수치적 방법</a></li>\r\n" + 
				"            </ul>\r\n" + 
				"          </div>\r\n" + 
				"        </li>\r\n" + 
				"      </ul>\r\n" + 
				"    </div>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"  </body>\r\n" + 
				"</html>\r\n" + 
				"");
	}

	@Override
	public void ProcessRequest(HttpServletRequest req) throws IOException {
		MathManager.GetInstance().GetJSPServer().SetHTML(req, new ProblemHTML(req.getParameter("sub"), req.getParameter("con"), 1));
		
	}

}
