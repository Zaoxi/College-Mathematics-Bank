package CollegeMathBankProject.view;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.*;

/**
 * Servlet implementation class JSPServer
 */
@WebServlet(description = "대학 수학 문제 은행 시스템 서블릿", urlPatterns = { "/JSPServer" })
public class JSPServer extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    private AHTML htmlController;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JSPServer()
    {
        super();
        htmlController = new LoginHTML();
    }
    // HTML Controller를 동적으로 설정
    public void SetHTMP(AHTML newHtmlController)
    {
    	htmlController = newHtmlController;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html;charset=UTF-8");
		htmlController.PrintHTML(response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		htmlController.GetResponse(request);
		doGet(request, response);
	}

}
