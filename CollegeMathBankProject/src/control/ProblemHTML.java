package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		if(subject != null && content != null)
		{
			problem = MathManager.GetInstance().GetMathDAO().GetProblem(subject, content, problemNum);
		}
	}
	
	
	@Override
	public void PrintHTML(HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		
		
		out.println("");
		
		
	}

	@Override
	public void ProcessRequest(HttpServletRequest req) throws IOException {
		
	}

}
