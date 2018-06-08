package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProblemHTML implements AHTML {
	
	private String subject;
	private String content;
	
	public ProblemHTML(String _subject, String _content)
	{
		subject = _subject;
		content = _content;
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
